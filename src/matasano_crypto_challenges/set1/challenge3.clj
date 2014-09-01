(ns matasano-crypto-challenges.set1.challenge3
  (:use [matasano-crypto-challenges.set1.challenge1]
        [matasano-crypto-challenges.set1.challenge2]))

(defn- single-char-xor [hex c-key]
  (map bit-xor (unhexify->bytes hex) (.getBytes c-key)))

(defn- string->char [singleCharacterinString]
  (.charAt singleCharacterinString 0))

(defn- score-character [character]
  (if (Character/isLetter character) 1 0))

(defn- score-plaintext [plaintext]
  (reduce + (map #(score-character %) (char-array plaintext))))

(defn- alphabet []
  (let [all-letters '(\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z)]
    (distinct (concat all-letters (map #(Character/toUpperCase %) all-letters)))))

(defn- all-plaintexts [hex]
  (apply merge
         (map #(hash-map (single-byte-xor-cipher-with-key hex (str %)) %)
                   (alphabet))))

(defn- score-all [hex]
  (let [all (all-plaintexts hex)]
    (apply merge (map #(hash-map (score-plaintext %) (get all %)) (keys all)))))

(defn single-byte-xor-cipher-with-key [hex c-key]
  (apply str
         (map #(String.
                (unhexify->bytes (hexify->string (single-char-xor % c-key)))
                "UTF-8")
              (partition 2 hex))))

(defn find-key [hex]
  (let [all-scores (score-all hex)]
    (str
     (get all-scores
          (apply max (keys all-scores))))))











