;; This is Leiningen's own project configuration. See doc/TUTORIAL.md
;; file as well as sample.project.clj for help writing your own.

(defproject leiningen "2.0.0-preview2"
  :description "Automate Clojure projects without setting your hair on fire."
  :url "https://github.com/technomancy/leiningen"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[leiningen-core "2.0.0-preview2"]
                 [clucy "0.2.3"]
                 [useful "0.7.6-alpha1"]
                 [lein-newnew "0.2.4"]
                 [reply "0.1.0-alpha5"]
                 [org.clojure/data.xml "0.0.3"]
                 [bultitude "0.1.3"]
                 [clj-http "0.3.3"]]
  ;; checkout-deps don't work with :eval-in :leiningen
  :profiles {:dev {:resource-paths ["leiningen-core/dev-resources"]
                   :test-paths ["leiningen-core/test"]}}
  :test-selectors {:default (complement :busted)}
  :aot [#"leiningen" leiningen.core.main leiningen.core.eval
        leiningen.core.project leiningen.core.classpath leiningen.core.user]
  :eval-in :leiningen)

;;; Release Checklist

;; * update NEWS, bin/lein, bin/lein.bat, project.clj, leiningen-core/project.clj
;; * publish leiningen-core to clojars
;; * rm -rf target ~/.lein/self-installs/leiningen-*-SNAPSHOT-standalone.jar
;; * temporarily add :aot :all to leiningen-core/project.clj; lein install
;; * bin/lein uberjar, copy standalone to ~/.lein/self-installs
;; * ensure "time lein version" isn't bad
;; * upload to github
;; * test self-install
;; * git tag
;; * push, push tags, update stable branch
;; * announce on mailing list
;; * bump version numbers back to snapshot
;; * regenerate pom.xml
