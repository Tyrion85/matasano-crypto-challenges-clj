(ns matasano-crypto-challenges.set1.challenge3
  (:use [matasano-crypto-challenges.set1.challenge1]
        [matasano-crypto-challenges.set1.challenge2]))

(defn- decipher-single-char [char-hex c-key]
  "Does a 1 bit XOR on hexed character with a given key."
   (map bit-xor (unhexify->bytes char-hex) (.getBytes c-key)))

(defn decipher [hex c-key]
  "Deciphers given hex cipher with key."
    (apply str
         (map #(String. (unhexify->bytes
                         (hexify->string
                          (decipher-single-char % c-key)))
                "UTF-8")
              (partition 2 hex))))

(defn- alphabet []
  (let [all-letters '(\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z)]
    (distinct (concat all-letters (map #(Character/toUpperCase %) all-letters)))))

(defn- all-possible-deciphers [hex]
  "Returns a map of all possible decipers and appropriate decipher keys."
  (apply merge
         (map #(hash-map (decipher hex (str %)) %)
                   (alphabet))))

(defn- score-character [character]
  "Scores a character: if Letter => 1 point, else 0 points."
   (if (Character/isLetter character) 1 0))

(defn- score-plaintext [plaintext]
  "Scores a plaintext."
   (reduce + (map #(score-character %) (char-array plaintext))))

(defn- score-all-combinations [hex]
  "Returns a map of all scores for possible decipher keys"
  (let [all (all-possible-deciphers hex)]
    (apply merge (map #(hash-map (score-plaintext %) (get all %)) (keys all)))))


(defn find-key [hex]
  "Finds a most likely decipher key by 'scoring' all possible deciphers.
  \nScoring method is straightforward: each letter is awarded one point,
  other characters get a zero. Key with most points wins."
  (let [all-scores (score-all-combinations hex)]
    (str
     (get all-scores
          (apply max (keys all-scores))))))











