(defproject asterion "0.1.0-alpha1"
  :description "Make and explore dependency graphs for Clojure(Script) projects."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :source-paths ["src/clj" "src/cljs"]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.145"]
                 [org.clojure/tools.namespace "0.3.19-SNAPSHOT"]
                 [org.clojure/tools.reader "0.10.0-alpha1"]
                 [commons-io/commons-io "2.4"]
                 [com.stuartsierra/component "0.2.3"]
                 [leiningen-core "2.5.3"]
                 [clj-jgit "0.8.8"]
                 [ring "1.3.2"]
                 [compojure "1.4.0"]
                 [cljsjs/d3 "3.5.5-3"]
                 [org.omcljs/om "0.9.0"]
                 [cljs-ajax "0.5.0"]]  

  :plugins [[lein-cljsbuild "1.1.0"]]

  :min-lein-version "2.5.1"

  :cljsbuild
  {:builds {:dev {:source-paths ["src/cljs" "env/dev/cljs"]
                  :figwheel {:on-jsload "asterion.core/init!"}
                  :compiler {:output-to "resources/public/js/p/app.js"
                             :output-dir "resources/public/js/p/out"
                             :asset-path "js/p/out"
                             :source-map true
                             :main "asterion.dev"
                             :verbose true
                             :optimizations :none
                             :pretty-print  true
                             :cache-analysis true}}
            :app {:source-paths ["src/cljs" "env/dev/cljs"]
                  :figwheel {:on-jsload "asterion.core/init!"}
                  :compiler {:output-to "app/js/p/app.js"
                             :output-dir "app/js/p/out"
                             :asset-path "js/p/out"
                             :source-map true
                             :main "asterion.dev"
                             :verbose true
                             :optimizations :none
                             :pretty-print  true
                             :cache-analysis true}}
            :production
            {:source-paths ["src/cljs" "env/prod/cljs"]
             :compiler {:output-to "app/js/p/app.js"
                        :optimizations :whitespace
                        :main "asterion.prod"
                        :closure-defines {:goog.DEBUG false}
                        :externs ["node_modules/closurecompiler-externs/path.js"
                                  "node_modules/closurecompiler-externs/fs.js"
                                  "externs/misc.js"]}}}}

  :clean-targets ^{:protect false} [:target-path "out" "resources/public/js/p"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles {:dev {:plugins [[lein-ancient "0.6.7"]
                             [lein-kibit "0.1.2"]
                             [lein-cljfmt "0.3.0"]
                             [lein-figwheel "0.4.1"]]}})
