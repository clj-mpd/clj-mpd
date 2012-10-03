(ns clj-mpd.test_app
  (:require [clj-mpd.core]
            [clj-mpd.playlist :as plist]
            [clj-mpd.player :as player]
            [clj-mpd.item.song :as song]
            [clj-mpd.utils :as utils]))

(defn setup-player [mpd]
  (player/create-player mpd))

(defn ^{:doc "Not much here, just some test code."}
  -main [& args]
  (do
    (clj-mpd.core/connect! :hostname "localhost" :port "6600")
    (print "Current song: ")
    (-> (player/create-player) player/get-current-song song/get-artist (print "- "))
    (-> (player/create-player) player/get-current-song song/get-title println)
    (print "From the album: ")
    (-> (player/create-player) player/get-current-song song/get-album println)
    (print "Time played: ")
    (-> (player/create-player) player/get-elapsed-time utils/format-seconds (print "/ "))
    (-> (player/create-player) player/get-current-song song/get-length utils/format-seconds println)))
