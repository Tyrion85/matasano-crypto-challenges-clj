(ns matasano-crypto-challenges.set1.challenge3_test
  (:use midje.sweet matasano-crypto-challenges.set1.challenge3))

(fact "Single byte xor function should take a hex value and a single-character key (as String) and return XORed result"
      (decipher "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736" "a")
      => "zVVRPW^tzJUPR\\XIVLW]V_[XZVW")

(fact "Going manually through English letters, letter 'X' gives the most sane result"
      (decipher "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736" "X")
      => "Cooking MC's like a pound of bacon")

(fact "Finding key by scoring each plaintext should result in letter 'X'"
      (find-key "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736")
      => "X")
