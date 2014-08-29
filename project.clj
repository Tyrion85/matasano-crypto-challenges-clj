(defproject matasano-crypto-challenges "0.1.0-SNAPSHOT"
  :description "The Matasano Crypto Challenges"
  :url "http://http://cryptopals.com/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/data.codec "0.1.0"]]
  :plugins [[lein-ancient "0.5.4"]]
  :profiles
    {:dev
      {:dependencies [[midje "1.6.3"]]
       :plugins [[lein-midje "3.1.3"]]}})
