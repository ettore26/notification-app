(ns app.core
  (:gen-class)
  (:require
   [app.middleware.middleware :refer [wrap-middleware]]
   [app.route.category-routes :refer [category-routes]]
   [app.route.channel-routes :refer [channel-routes]]
   [clojure.java.io :as io]
   [compojure.core :refer [defroutes GET]]
   [compojure.route :as route]
   [ring.adapter.jetty :refer [run-jetty]]))

(defn- index-body []
  (slurp (io/resource "public/index.html")))

(defn- index []
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body (index-body)})

(defn- not-found []
  {:status 404
   :headers {"Content-Type" "text/html"}
   :body "Not Found"})

(defroutes app-routes
  (GET "/" [] (index))
  category-routes
  channel-routes
  (route/not-found (not-found)))

(def app (wrap-middleware app-routes))

(defn -main [& _args]
  (run-jetty app {:port 3000 :join? false})
  (println "Server started on port 3000"))
