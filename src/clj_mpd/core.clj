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

(defn mpd
  "Create an MPD object, representing a connection to an MPD server running
   on a given host and port. Takes optional password and timeout options.

   Creating the MPD object implicitly opens a connection to that MPD server.
   The JavaMPD docs recommend closing the connection once you're done with it;
   the most idiomatic/functional way to handle this in Clojure is to use the
   with-mpd-connection macro, which ensures that the connection is closed once
   you're done with it.

   As an alternative to using with-mpd-connection, you can also manually
   disconnect the MPD connection using the disconnect! function."
  ^MPD [& {:keys [hostname port password timeout]
           :or {hostname "localhost", port 6600}}]
  (let [b (MPD$Builder.)]
    (.server b hostname)
    (.port b port)
    (when password (.password b password))
    (when timeout (.timeout b timeout))
    (.build b)))

(defn connect!
  "Sets an MPD connection as default by altering the *mpd-connection* var.

   If no argument or :default is provided, uses localhost:6600."
  ([]
    (connect! (mpd)))
  ([^MPD conn]
    (alter-var-root (var *mpd-connection*) (constantly conn))))

(defn disconnect!
  "Close an MPD connection. The JavaMPD docs note that the connection
   remains open for the life of the MPD object, and that we should call
   .close() on the object when we're done with it.

   If no argument is provided, closes the default connection *mpd-connection*."
  ([]
    (disconnect! *mpd-connection*))
  ([^MPD conn]
    (.close conn)))

(defmacro with-mpd-connection
  "A convenience macro for working with MPD connections.

   Creates an MPD connection, executes the expressions in body with the
   connection bound to *mpd-connection*, and closes the connection.

   If :default is provided as the connection, connects to the MPD at
   localhost:6600."
  [conn & body]
  `(do
     (connect! (if (= ~conn :default)
                 (mpd)
                 ~conn))
     ~@body
     (disconnect!)))

(defn get-version
  "Get the MPD version running on the server."
  ([]
    (get-version *mpd-connection*))
  ([mpd]
    (.getVersion mpd)))

(defn get-port
  "Get the port on which the server is running."
  ([]
    (get-port *mpd-connection*))
  ([mpd]
    (.getPort mpd)))

(defn get-address
  "Get the Inet address where the server lives."
  ([]
    (get-address *mpd-connection*))
  ([mpd]
    (.getAddress mpd)))

(defn get-timeout
  "Get the timeout of an MPD server. (0 if no timeout)"
  ([]
    (get-timeout *mpd-connection*))
  ([mpd]
    (.getTimeout mpd)))
