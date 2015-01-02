# clj-mpd

Clojure library wrapping the [javampd][1] library along with several
extra helper functions and other functionality.

[1]: http://www.thejavashop.net/javampd/

## ToDo

* Implement "useful" methods from javampd.
* Fix NULL derefs when MPD isn't running/playing.
* Proper way to set up a connection and use it throughout clj-mpd.test.status,
  instead of re-creating MPD/MPDPlayer all the time.

### To implement:

<pre>
MPDAudioInfo
MPDItem
  MPDAlbum
  MPDArtist
  MPDGenre
  MPDSavedPlaylist
  MPDSong
</pre>

Implemented in:
<pre>
MPD         - clj-mpd.core
MPDAdmin    - clj-mpd.admin
MPDCommand  - clj-mpd.command
MPDDatabase - clj-mpd.database
MPDFile     - clj-mpd.file
MPDOutput
MPDPlayer   - clj-mpd.player
MPDPlaylist - clj-mpd.playlist
</pre>

## Usage

clj-mpd is still a work in progress -- use at your own peril.

For a simple demo, start mpd locally and then run `lein test`:

```
dave@skeggox [09:16 PM] ~/Code/clj-mpd : lein test
...
lein test clj-mpd.test.status
...
Current song: Brian Eno - Some of Them Are Old
From the album: Here Come the Warm Jets
Time played: 4:50 / 5:12
...
```


## License

Copyright (C) 2011 Jasper Lievisse Adriaanse
Some changes copyright (C) 2012 Albin Stjerna
More changes copyright (C) 2014-2015 Dave Yarwood

Licensed under the EPL (see the file COPYING).
