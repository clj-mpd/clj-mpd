;  Copyright (c) 2011 Jasper Lievisse Adriaanse <jasper@humppa.nl>
;  The use and distribution terms for this software are covered by the
;  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;  which can be found in the file epl-v10.html at the root of this distribution.
;  By using this software in any fashion, you are agreeing to be bound by
;  the terms of this license.
;  You must not remove this notice, or any other, from this software.

;; Large parts of this code was borrowed from monger.core, that code
;; is Copyright (c) 2011-2012 Michael S. Klishin.

(ns ^{:author "Jasper Lievisse Adriaanse, Albin Stjerna and Dave Yarwood"
      :doc "clj-mpd core"}
  clj-mpd.core
  (:import (org.bff.javampd MPD MPD$Builder)))

(declare ^:dynamic ^MPD *mpd-connection*)

(defn set-connection!
  "Sets given MPD connection as default by altering *mpd-connection* var"
  ^MPD [^MPD conn]
  (alter-var-root (var *mpd-connection*) (constantly conn)))

(defn connect!
  "Connect to MPD and store the connection in the *mpd-connection* var.

  Defaults to localhost:6600 if not provided."
  ^MPD [& {:keys [hostname port] :or {hostname "localhost", port 6600}}]
  (let [builder (doto (MPD$Builder.) (.server hostname) (.port port))
        mpd (.build builder)]
    (set-connection! mpd)))

(defmacro with-connection
  [conn & body]
  `(binding [*mpd-connection* ~conn]
     (do ~@body)))
