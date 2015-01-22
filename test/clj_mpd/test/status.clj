(ns clj-mpd.test.status
  (:require [clojure.test :refer :all]
            [clj-mpd.core :refer (with-mpd-connection)]
            [clj-mpd.player :refer (player status get-elapsed-time)]
            [clj-mpd.utils :refer (format-seconds)]))

(deftest display-currently-playing
  (with-mpd-connection :default
    (let [{:keys [title artist album length]} (status)
          elapsed-time (get-elapsed-time)]
      (printf "\nCurrent song: %s - %s\n" artist title)
      (println "From the album: " album)
      (printf "Time played: %s / %s\n" (format-seconds elapsed-time)
                                       (format-seconds length)))))
