(defproject repp "0.1.0-SNAPSHOT"
  :description "read-eval-print... profit"
  :url "https://github.com/tolitius/repp"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.logging "0.2.6"]
                 [com.google.zxing/javase "2.1"]
                 [com.google.zxing/core "2.1"]
                 [jayq "2.4.0"]
                 [compojure "1.1.5"]
                 [enlive "1.1.1" :exclusions [org.clojure/clojure]]]

  :source-paths ["src" "src/repp"]
  :java-source-paths ["src/java"]

  :plugins [[lein-ring "0.8.6"]
            [lein-cljsbuild "0.3.2"]]

  :ring {:handler repp/app}

  :hooks [leiningen.cljsbuild]

  :cljsbuild
    {:builds
     [{:source-paths ["src"],
       :compiler
       {:pretty-print true,
        :output-to "resources/public/cljs/repp.js",
        :optimizations :simple}}]}           

  :profiles
    {:dev {:dependencies [[ring-mock "0.1.5"]]}})
