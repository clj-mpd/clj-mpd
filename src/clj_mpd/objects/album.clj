(ns ^{:author "Dave Yarwood"
      :doc "MPDAlbum related functions for clj-mpd"}
  clj-mpd.objects.album)

(comment
  "MPDAlbum has two attributes: the (album) name and the artistName. Whereas
   artistName has explicit getter and setter methods, the album name is an
   implicit part of the MPDAlbum object -- the getter is just calling
   .toString(), and the setter is supplying the album name as the single
   argument when instantiating an MPDAlbum.")

(defn get-artist
  "Get the artist name associated with the album object."
  [album]
  (.getArtistName album))
