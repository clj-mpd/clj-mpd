(ns clj-mpd.test.player
  (:require [clojure.test :refer :all])
  (:require [clj-mpd.core :refer (with-mpd-connection)])
  (:require [clj-mpd.player :refer :all])
  (:import [org.bff.javampd Player$Status]
           [org.bff.javampd.objects MPDSong]))

; these tests rely on there being an MPD instance running on localhost:6600

(deftest mpd-player-tests
  (with-mpd-connection :default
    (testing "getters"
      (is (instance? MPDSong (get-current-song)))
      (is (number? (get-elapsed-time)))
      (is (number? (get-total-time)))
      (is (number? (get-bitrate)))
      (is (number? (get-volume)))
      (is (instance? Player$Status (get-state)))
      (is (contains? #{true false} (repeat?)))
      (is (contains? #{true false} (random?))))))
