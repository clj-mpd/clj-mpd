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
            [clj-mpd.item.song :as song]))

(defn player
  "Instantiate a MPDPlayer object"
  ([]
    (player *mpd-connection*))
  ([conn]
    (.getPlayer conn)))

;;; getters

(defn get-current-song
  "Get current song as MPDSong"
  [player]
  (.getCurrentSong player))

(defn get-elapsed-time
  "Get the elapsed time in seconds."
  [player]
  (.getElapsedTime player))

(defn get-total-time
  "Get the total time of the current song."
  [player]
  (.getTotalTime player))

(defn get-bitrate
  "Get the bitrate of the current stream."
  [player]
  (.getBitrate player))

(defn get-audio-details
  "Get the audio details (sample rate:number of bits:channels)."
  [player]
  (let [details (.getAudioDetails player)
        sample-rate (.getSampleRate details)
        bits (.getBits details)
        channels (.getChannels details)]
    (str sample-rate \: bits \: channels)))

(defn get-volume
  "Get the current volume."
  [player]
  (.getVolume player))

(defn get-state
  "Get the current player state (e.g. playing, paused, stopped)."
  [player]
  (.getStatus player))

(defn repeat?
  "Get true/false status for repeat mode."
  [player]
  (.isRepeat player))

(defn random?
  "Get true/false status for random mode."
  [player]
  (.isRandom player))

(defn status
  "Returns a map of current song information from a player instance."
  [player]
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
     :position      (song/get-position song)}))

;;; setters

(defn mute
  "Mutes the volume."
  [player]
  (.mute player))

(defn unmute
  "Unmutes the player."
  [player]
  (.unMute player))

(defn stop
  "Stop the current song."
  [player]
  (.stop player))

(defn pause
  "Pause the current song"
  [player]
  (.pause player))

(defn play
  "Play the current song."
  [player]
  (.play player))

(defn play-next
  "Play the next song."
  [player]
  (.playNext player))

(defn play-prev
  "Play the previous song."
  [player]
  (.playPrev player))

(defn set-random
  "Turn random playing on/off."
  [player random]
  (.setRandom player random))

(defn set-repeat
  "Turn repeated playing on/off."
  [player repeat]
  (.setRepeat player repeat))
