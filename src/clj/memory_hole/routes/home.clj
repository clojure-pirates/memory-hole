(ns memory-hole.routes.home
  (:require [memory-hole.layout :as layout]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :as response]
            [clojure.java.io :as io]))

(defn home-page []
  (layout/render "home.html"))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/issue/:id" [] (home-page))
  (GET "/issues/:tag-id" [] (home-page))
  (GET "/docs" [] (-> (response/ok (-> "docs/docs.md" io/resource slurp))
                      (response/header "Content-Type" "text/plain; charset=utf-8"))))

