#!/usr/bin/env bb
(ns page
  (:require [babashka.pods :as pods]))

;; Lade Abhängigkeiten herunter, um Markdown zu HTML umzuwandeln
(pods/load-pod "bootleg")
(require '[pod.retrogradeorbit.bootleg.utils :as utils])
(require '[pod.retrogradeorbit.bootleg.markdown :as markdown])

(defn base
  "Grundgerüst der Webseite."
  [& content]
  ["<!DOCTYPE html>\n"
   [:html {:lang "de"}
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0"}]
     [:link {:rel "stylesheet" :href "/node_modules/bootstrap/dist/css/bootstrap.min.css"}]
     [:link {:rel "stylesheet" :href "/resources/css/main.css"}]
     [:title "Deutscher Pfadfinderbund in Remscheid"]]
    [:body.py-5
     [:main.container.shadow.bg-light.p-5
      content]]]])


;; -----------------------------------------------------------------------------

(defn index-page
  "Erstelle die Startseite."
  []
  (base
   (markdown/markdown "inhalte/index.md")))


;; -----------------------------------------------------------------------------

(defn spit-html
  "Schreibt das generierte HTML in eine Datei."
  [filename page]
  (spit filename (utils/convert-to (page) :html)))

(spit-html "index.html" index-page)
