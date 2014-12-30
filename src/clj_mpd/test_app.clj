(ns clj-mpd.test_app
  (:require [clj-mpd.core :refer (connect!)]
            [clj-mpd.playlist :as plist]
            [clj-mpd.player :as player]
            [clj-mpd.item.song :as song]
            [clj-mpd.utils :as utils]))

(defn -main
  "Not much here, just some test code."
  [& args]

  (connect! :hostname "localhost" :port "6600")

  (print "Current song: ")
  (-> (player/create-player) player/get-current-song song/get-artist (print "- "))
  (-> (player/create-player) player/get-current-song song/get-title println)
  (print "From the album: ")
  (-> (player/create-player) player/get-current-song song/get-album println)
  (print "Time played: ")
  (-> (player/create-player) player/get-elapsed-time utils/format-seconds (print "/ "))
  (-> (player/create-player) player/get-current-song song/get-length utils/format-seconds println))
