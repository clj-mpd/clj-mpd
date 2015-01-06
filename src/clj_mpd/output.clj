(ns ^{:author "Dave Yarwood"
      :doc "MPDOutput related functions for clj-mpd"}
  clj-mpd.playlist)

(defn get-id
  "Get the id of the output."
  [output]
  (.getId output))

(defn get-name
  "Get the name of the output."
  [output]
  (.getName output))

(defn enabled?
  "Returns whether the output is enabled."
  [output]
  (.isEnabled output))
