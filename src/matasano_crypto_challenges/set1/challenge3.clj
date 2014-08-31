(ns matasano-crypto-challenges.set1.challenge3
  (:use [matasano-crypto-challenges.set1.challenge1]
        [matasano-crypto-challenges.set1.challenge2]))

(defn- single-char-xor [hex c-key]
  (map bit-xor (unhexify->bytes hex) (.getBytes c-key)))

(defn single-byte-xor-cipher [hex c-key]
  (apply str
         (map #(String.
                (unhexify->bytes (hexify->string (single-char-xor % c-key)))
                "UTF-8")
              (partition 2 hex))))



