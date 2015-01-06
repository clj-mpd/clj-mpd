# clj-mpd

Clojure library wrapping the [javampd][1] library along with several
extra helper functions and other functionality.

[1]: http://www.thejavashop.net/javampd/

## ToDo

* Write tests. (javampd has good tests for reference)
* Implement (if useful):
  * MPDPlaylist
  * MPDAdmin
  * MPDDatabaseManager
  * MPDServerStatistics
  * MPDServerStatus
  * MPDCommand

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

Copyright © 2011 Jasper Lievisse Adriaanse

Some changes copyright © 2012 Albin Stjerna

More changes copyright © 2014-2015 Dave Yarwood

Licensed under the EPL (see the file COPYING).
