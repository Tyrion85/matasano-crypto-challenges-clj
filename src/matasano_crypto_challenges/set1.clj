(ns matasano-crypto-challenges.set1
  (:require [clojure.data.codec.base64 :as b64]))


;; Challenge 1
;; Convert hex to base64

(defn- unhexify [hex]
  (apply str
    (map
     (fn [[x y]] (char (Integer/parseInt (str x y) 16)))
      (partition 2 hex))))


(defn hex-to-base64 [hex]
  (String. (b64/encode (.getBytes (unhexify hex))) "UTF-8"))
