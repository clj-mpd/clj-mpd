(ns clj-mpd.test.player
  (:require [clojure.test :refer :all])
  (:require [clj-mpd.core :refer (with-mpd-connection)])
  (:require [clj-mpd.player :refer :all])
  (:require [clj-mpd.objects.song :as song])
  (:import [org.bff.javampd.objects MPDSong]))

; these tests rely on there being an MPD instance running on localhost:6600,
; and there needs to be at least one song in the playlist after the one
; currently playing

(deftest mpd-player-tests
  (with-mpd-connection :default
    (testing "getters"
      (is (instance? MPDSong (get-current-song)))
      (is (number? (get-elapsed-time)))
      (is (number? (get-total-time)))
      (is (number? (get-bitrate)))
      (is (number? (get-volume)))
      (is (string? (get-state)))
      (is (contains? #{true false} (repeat?)))
      (is (contains? #{true false} (random?))))
    (testing "commands"
      (testing "mute/unmute"
        (let [initial-volume (get-volume)]
          (mute!)
          (is (zero? (get-volume)))
          (unmute!)
          (is (= initial-volume (get-volume)))))
      (testing "play/pause/stop"
        (play!)
        (is (= (get-state) "STATUS_PLAYING"))
        (stop!)
        (is (= (get-state) "STATUS_STOPPED"))
        (pause!)
        (is (= (get-state) "STATUS_STOPPED"))
        (play!)
        (pause!)
        (is (= (get-state) "STATUS_PAUSED")))
      (testing "play-next, play-prev"
        (let [current-position (song/get-position (get-current-song))]
          (play-next!)
          (is (= (song/get-position (get-current-song))
                 (inc current-position)))
          (play-prev!)
          (is (= (song/get-position (get-current-song))
                 current-position))))
      (testing "random/repeat"
        (set-random! true)
        (is (true? (random?)))
        (set-random! false)
        (is (false? (random?)))
        (set-repeat! true)
        (is (true? (repeat?)))
        (set-repeat! false)
        (is (false? (repeat?)))))))
