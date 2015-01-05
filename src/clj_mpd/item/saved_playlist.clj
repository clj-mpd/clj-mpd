(ns ^{:author "Dave Yarwood"
      :doc "MPDSavedPlaylist related functions for clj-mpd"}
  clj-mpd.item.saved-playlist)

(defn get-songs
  "Get the list of songs, as a seq of MPDSong objects."
  [playlist]
  (seq (.getSongs playlist)))
