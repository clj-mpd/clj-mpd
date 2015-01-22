;  Copyright (c) 2011 Jasper Lievisse Adriaanse <jasper@humppa.nl>
;  The use and distribution terms for this software are covered by the
;  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;  which can be found in the file epl-v10.html at the root of this distribution.
;  By using this software in any fashion, you are agreeing to be bound by
;  the terms of this license.
;  You must not remove this notice, or any other, from this software.

(ns ^{:author "Jasper Lievisse Adriaanse, Albin Stjerna and Dave Yarwood"
      :doc "Playlist related functions for clj-mpd"}
  clj-mpd.player
  (:require [clj-mpd.core :refer (*mpd-connection*)]
            [clj-mpd.objects.song :as song]))

(defn player
  "Instantiate a MPDPlayer object"
  ([]
    (player *mpd-connection*))
  ([conn]
    (.getPlayer conn)))

;;; getters

(defn get-current-song
  "Get current song as MPDSong"
  ([]
   (get-current-song (player)))
  ([player]
    (.getCurrentSong player)))

(defn get-elapsed-time
  "Get the elapsed time in seconds."
  ([]
    (get-elapsed-time (player)))
  ([player]
    (.getElapsedTime player)))

(defn get-total-time
  "Get the total time of the current song."
  ([]
    (get-total-time (player)))
  ([player]
    (.getTotalTime player)))

(defn get-bitrate
  "Get the bitrate of the current stream."
  ([]
    (get-bitrate (player)))
  ([player]
    (.getBitrate player)))

(defn get-volume
  "Get the current volume."
  ([]
    (get-volume (player)))
  ([player]
    (.getVolume player)))

(defn get-state
  "Get the current player state as a string.
  (e.g. STATUS_PLAYING, STATUS_PAUSED, STATUS_STOPPED)"
  ([]
    (get-state (player)))
  ([player]
    (str (.getStatus player))))

(defn repeat?
  "Get true/false status for repeat mode."
  ([]
    (repeat? (player)))
  ([player]
    (.isRepeat player)))

(defn random?
  "Get true/false status for random mode."
  ([]
    (random? (player)))
  ([player]
    (.isRandom player)))

(defn status
  "Returns a map of current song information from a player instance."
  ([]
    (status (player)))
  ([player]
    (let [song (get-current-song player)]
      {:file          (song/get-file song)
       :artist        (song/get-artist song)
       :album         (song/get-album song)
       :title         (song/get-title song)
       :track         (song/get-track-number song)
       :disc          (song/get-disc-number song)
       :genre         (song/get-genre song)
       :year          (song/get-year song)
       :length        (song/get-length song)
       :id            (song/get-id song)
       :position      (song/get-position song)})))

;;; setters

(defn mute!
  "Mutes the volume."
  ([]
    (mute! (player)))
  ([player]
    (.mute player)))

(defn unmute!
  "Unmutes the player."
  ([]
    (unmute! (player)))
  ([player]
    (.unMute player)))

(defn stop!
  "Stop the current song."
  ([]
    (stop! (player)))
  ([player]
    (.stop player)))

(defn pause!
  "Pause the current song"
  ([]
    (pause! (player)))
  ([player]
    (.pause player)))

(defn play!
  "Play the current song."
  ([]
    (play! (player)))
  ([player]
    (.play player)))

(defn play-next!
  "Play the next song."
  ([]
    (play-next! (player)))
  ([player]
    (.playNext player)))

(defn play-prev!
  "Play the previous song."
  ([]
    (play-prev! (player)))
  ([player]
    (.playPrev player)))

(defn set-random!
  "Turn random playing on/off."
  ([random]
    (set-random! (player) random))
  ([player random]
    (.setRandom player random)))

(defn set-repeat!
  "Turn repeated playing on/off."
  ([repeat]
    (set-repeat! (player) repeat))
  ([player repeat]
    (.setRepeat player repeat)))
