(ns clj-mpd.test.playlist
  (:require [clojure.test :refer :all]
            [clj-mpd.core :refer (with-mpd-connection)]
            [clj-mpd.playlist :refer :all])
  (:import [org.bff.javampd MPDPlaylist]
           [org.bff.javampd.objects MPDSong]))

; these tests rely on there being an MPD instance running on localhost:6600,
; and there needs to be some songs in the current playlist

(deftest mpd-playlist-tests
  (with-mpd-connection :default
    (testing "a playlist"
      (is (instance? MPDPlaylist (controller)))
      (is (instance? MPDSong (get-current-song)))
      (is (every? (partial instance? MPDSong) (current-playlist)))
      (testing "adding a song"
        (let [num-of-songs (count (current-playlist))]
          (add-song! (last (current-playlist)))
          (is (= (count (current-playlist)) (inc num-of-songs)))))
      (testing "adding 2 songs"
        (let [num-of-songs (count (current-playlist))]
          (add-songs! (take-last 2 (current-playlist)))
          (is (= (count (current-playlist)) (+ 2 num-of-songs)))))
      (testing "removing songs"
        (let [num-of-songs (count (current-playlist))]
          (remove-song! (last (current-playlist)))
          (remove-song! (last (current-playlist)))
          (remove-song! (last (current-playlist)))
          (is (= (count (current-playlist)) (- num-of-songs 3))))))))
