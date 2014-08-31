(ns matasano-crypto-challenges.set1.challenge2
  (:use [matasano-crypto-challenges.set1.challenge1]))

;; Challenge 2
;; Write a function that takes two equal-length buffers and produces their XOR combination.

(defn hexify->string [b]
  (apply str (map #(format "%02x" %) b)))

(defn fixed-xor [x y]
  (hexify->string
   (map bit-xor (unhexify->bytes x) (unhexify->bytes y))))
