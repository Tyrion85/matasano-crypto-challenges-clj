(ns matasano-crypto-challenges.set1.challenge1
  (:require [clojure.data.codec.base64 :as b64]))


;; Challenge 1
;; Convert hex to base64

(defn- unhexify->string [hex]
  (apply str
    (map
     (fn [[x y]] (char (Integer/parseInt (str x y) 16)))
      (partition 2 hex))))

(defn unhexify->bytes [hex]
  (.getBytes (unhexify->string hex)))

(defn hex-to-base64 [hex]
  (String. (b64/encode (unhexify->bytes hex)) "UTF-8"))
