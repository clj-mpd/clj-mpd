;  Copyright (c) 2011 Jasper Lievisse Adriaanse <jasper@humppa.nl>
;  The use and distribution terms for this software are covered by the
;  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;  which can be found in the file epl-v10.html at the root of this distribution.
;  By using this software in any fashion, you are agreeing to be bound by
;  the terms of this license.
;  You must not remove this notice, or any other, from this software.

(ns ^{:author "Jasper Lievisse Adriaanse and Dave Yarwood"
      :doc "Playlist related functions for clj-mpd"}
  clj-mpd.playlist
  (:require [clj-mpd.core :refer (*mpd-connection*)]))

(defn create-playlist
  "Instantiate an MPDPlaylist object."
  ([]
    (create-playlist *mpd-connection*))
  ([mpd]
    (.getMPDPlaylist mpd)))

(defn current-playlist
  "Return the entire playlist as seq-ed List<MPDSong>"
  [playlist]
  (seq (.getSongList playlist)))
