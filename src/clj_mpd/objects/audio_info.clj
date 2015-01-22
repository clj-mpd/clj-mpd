(ns ^{:author "Dave Yarwood"
      :doc "MPDAudioInfo related functions for clj-mpd"}
  clj-mpd.objects.audio-info
  (:require [clojure.string :as str]))

(defn get-audio-info
  "Get the audio details of an MPDPlayer."
  [player]
  (.getAudioDetails player))

(defn get-sample-rate
  "Get the sample rate."
  [audioinfo]
  (.getSampleRate audioinfo))

(defn get-bits
  "Get the number of bits."
  [audioinfo]
  (.getBits audioinfo))

(defn get-channels
  "Get the number of channels."
  [audioinfo]
  (.getChannels audioinfo))

(defn to-str
  "Get a string representation of an MPDAudioInfo object,
   in the format samplerate:bits:channels."
  [audioinfo]
  (str/join \: ((juxt get-sample-rate get-bits get-channels) audioinfo)))
