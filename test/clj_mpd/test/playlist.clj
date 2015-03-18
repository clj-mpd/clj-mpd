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
      (is (every? (partial instance? MPDSong) (current-playlist))))))
