;  Copyright (c) 2012 Albin Stjerna <albin.stjerna@gmail.com>
;  The use and distribution terms for this software are covered by the
;  Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;  which can be found in the file epl-v10.html at the root of this distribution.
;  By using this software in any fashion, you are agreeing to be bound by
;  the terms of this license.
;  You must not remove this notice, or any other, from this software.

(ns ^{:author "Albin Stjerna"
      :doc "MPDCommand implementation for clj-mpd"}
  clj-mpd.command
  (:import (org.bff.javampd/MPDCommand))
  (:use [wall.hack]))

(defn make-command
  "Instantiate an MPDCommand object."
  ([command] (org.bff.javampd.MPDCommand. command))
  ([command params] (org.bff.javampd.MPDCommand. command params)))

;; TODO we should have some kind of error correction here. The docs
;; mention that we should run isResponseOK on, uh, something (I think
;; there's a bug here in the documentation).
(defn send-command
  "Send a raw command object to MPD."
  [mpd command]
;;  (.sendMPDCommand mpd command)
  (wall.hack/method org.bff.javampd.MPD :sendMPDCommand [org.bff.javampd.MPDCommand] mpd command))