(ns matasano-crypto-challenges.set1.challenge2_test
  (:use midje.sweet matasano-crypto-challenges.set1.challenge2))

(fact "Function that takes two equal-length buffers should produce their XOR combination"
      (fixed-xor "1c0111001f010100061a024b53535009181c" "686974207468652062756c6c277320657965")
      => "746865206b696420646f6e277420706c6179")
