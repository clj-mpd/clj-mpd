(ns clj-mpd.test.status
  (:require [clojure.test :refer :all]
            [clj-mpd.core :refer (connect!)]
            [clj-mpd.playlist :as plist]
            [clj-mpd.player :refer (player status get-elapsed-time)]
            [clj-mpd.utils :refer (format-seconds)]))

(connect! :hostname "localhost" :port 6600)

(deftest display-currently-playing
  (let [{:keys [title artist album length]} (status (player))
        elapsed-time (get-elapsed-time (player))]
    (printf "\nCurrent song: %s - %s\n" artist title)
    (println "From the album: " album)
    (printf "Time played: %s / %s\n" (format-seconds elapsed-time)
                                     (format-seconds length))))
