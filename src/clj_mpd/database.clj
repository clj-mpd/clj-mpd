;  Copyright (c) 2011 Jasper Lievisse Adriaanse <jasper@humppa.nl>
;  The use and distribution terms for this software are covered by the
;  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;  which can be found in the file epl-v10.html at the root of this distribution.
;  By using this software in any fashion, you are agreeing to be bound by
;  the terms of this license.
;  You must not remove this notice, or any other, from this software.

(ns ^{:author "Jasper Lievisse Adriaanse"
      :doc "Database related functions for clj-mpd"}
  clj-mpd.database
  (:require clj-mpd.core))

(defn create-database
  "Instantiate an MPDDatabase object."
  [mpd]
  (.getMPDDatabase clj-mpd.core/*mpd-connection*))

(defn list-saved-playlists
  "List all playlists saved in the database. Return as seq-ed List<MPDSavedPlaylist>."
  [db]
  (seq (.listSavedPlaylists db)))

;; This does not really deserve its own namespace.

(defn saved-playlist-to-songs
  "Convert a MPDSavedPlaylist to seq-ed List<MPDSong>."
  [pl]
  (seq (.getSongs pl)))

(defn list-playlist-songs
  "Return a seq-ed List<MPDSong> from a playlist name."
  [name]
  (seq (.listPlaylistSongs (str name))))

(defn list-all-artists
  "Return a seq-ed List<MPDArtist> of all artists in the database."
  [db]
  (seq (.listAllArtists db)))

(defn list-albums-by-artist
  "Returns a seq-ed List<MPDAlbum> of all albums by artist in the database."
  [db artist]
  (seq (.listAlbumsByArtist db artist)))