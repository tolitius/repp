(ns repp
  (:use [compojure.core :only (GET POST defroutes)]
        [clojure.tools.logging]
        [clojure.java.shell :only [sh]]
        [ring.middleware.multipart-params]
        [clojure [pprint :only [pprint]]])
  (:require [compojure.handler :as handler]
            [clojure.string :as cstr]
            [net.cgrand.enlive-html :as en]
            [compojure.route :as route]))

(en/deftemplate land
  (en/xml-resource "template/repp.html")
  [request])

(defn- cleanse-ocr* [string]
  (info (str "cleansing:\t \"" string "\""))
  (info (str "cleansed: \t \"" (cstr/replace string #"[^A-z0-9\s,]*" "") "\""))
  (cstr/replace string #"[^A-z0-9\s,\.]*" ""))

(defn to-html-eol [string]
  (cstr/replace string #"\n" "<br />"))

(defn- ocr* [file]
  (let [path (.getAbsolutePath file)]
    (-> (sh "src/sh/ocr-it.sh" path)
        (:out)
        (cleanse-ocr*)
        (to-html-eol))))

(defn textify [image]
  (ocr* image))

(defn scan-barcode [image]
  (org.barcode.BarcodeScanner/decodeFromFile image))

(defroutes repp-routes
  (GET "/" request (land request))
  (wrap-multipart-params
     (POST "/scan-barcode" [pic] (scan-barcode (:tempfile pic))))
  (wrap-multipart-params
     (POST "/ocr" [pic] (textify (:tempfile pic))))
  (route/resources "/")
  (route/not-found "you got lost"))

(def app
  (handler/site repp-routes))
