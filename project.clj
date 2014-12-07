(defproject ssoup "0.1.0-SNAPSHOT"
  :description "Semantic Services Oriented User Platform"
  :url "http://github.com/ssouporg/ssoup"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.6.0"]
				 [org.clojure/clojurescript "0.0-2371"]
				 [com.keminglabs/cljx "0.4.0"]]

  :cljx {:builds [{:source-paths ["src/cljx"]
			:output-path "target/generated/src/clj"
			:rules :clj}
		   {:source-paths ["src/cljx"]
			:output-path "target/generated/src/cljs"
			:rules :cljs}
		   {:source-paths ["test/cljx"]
			:output-path "target/generated/test/clj"
			:rules :clj}
		   {:source-paths ["test/cljx"]
			:output-path "target/generated/test/cljs"
			:rules :cljs}]}

  :profiles {:dev {:plugins [[com.keminglabs/cljx "0.4.0"]
                             [codox "0.8.10"]
                             [lein-cljsbuild "1.0.3"]]}}

  :source-paths ["target/generated/src/clj" "src/clj"]

  :resource-paths ["target/generated/src/cljs"]

  :test-paths ["target/generated/test/clj" "test/clj"]

  :cljsbuild {:builds
              {:dev {:source-paths ["src/clj" "target/generated/src/cljs"]
                     :compiler {:output-to "target/main.js"
                                :optimizations :whitespace
                                :pretty-print true}}
               :test {:source-paths ["src/clj" "test/clj"
                                     "target/generated/src/cljs"
                                     "target/generated/test/cljs"]
                      :compiler {:output-to "target/unit-test.js"
                                 :optimizations :whitespace
                                 :pretty-print true}}}}

  :codox {:src-uri-mapping {#"target/generated/src/clj" #(str "src/cljx/" % "x")}
          :src-dir-uri "http://github.com/ssouporg/ssoup/blob/master/"
          :src-linenum-anchor-prefix "L"})
