;  Copyright (c) 2011 Jasper Lievisse Adriaanse <jasper@humppa.nl>
;  The use and distribution terms for this software are covered by the
;  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;  which can be found in the file epl-v10.html at the root of this distribution.
;  By using this software in any fashion, you are agreeing to be bound by
;  the terms of this license.
;  You must not remove this notice, or any other, from this software.

(ns ^{:author "Jasper Lievisse Adriaanse, Albin Stjerna and Dave Yarwood"
      :doc "MPDSong related functions for clj-mpd"}
  clj-mpd.objects.song)

(defn get-file
  "Get the path of the song (as String)."
  [song]
  (.getFile song))

(defn get-title
  "Get the song title."
  [song]
  (.getTitle song))

(defn get-album
  "Get the album of the song (as MPDAlbum.toString())."
  [song]
  (str (.getAlbumName song)))

(defn get-artist
  "Get artist of the song (as MPDArtist.toString())."
  [song]
  (str (.getArtistName song)))

(defn get-comment
  "Get the comment tag."
  [song]
  (.getComment song))

(defn get-track-number
  "Get the track number."
  [song]
  (.getTrack song))

(defn get-disc-number
  "Get the disc number."
  [song]
  (.getDiscNumber song))

(defn get-length
  "Get the length of the song (in seconds)."
  [song]
  (.getLength song))

(defn get-genre
  "Get the genre of the song."
  [song]
  (.getGenre song))

(defn get-year
  "Get the song year."
  [song]
  (.getYear song))

(defn get-id
  "Get the song's ID in the playlist.
   Returns -1 if the song is not in the playlist."
  [song]
  (.getId song))

(defn get-position
  "Get the song's position in the current playlist.
   Returns -1 if the song is not in the playlist."
  [song]
  (.getPosition song))
