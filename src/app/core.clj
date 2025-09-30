(ns app.core
  (:gen-class)
  (:require
   [app.middleware.middleware :refer [wrap-middleware]]
   [app.route.category-routes :refer [category-routes]]
   [app.route.channel-routes :refer [channel-routes]]
   [compojure.core :refer [defroutes]]
   [compojure.route :as route]
   [ring.adapter.jetty :refer [run-jetty]]))

(defn- not-found []
  {:status 404
   :headers {"Content-Type" "text/html"}
   :body "Not Found"})

(defroutes app-routes
  category-routes
  channel-routes
  (route/not-found (not-found)))

(def app (wrap-middleware app-routes))

(defn -main [& _args]
  (run-jetty app {:port 3000 :join? false})
  (println "Server started on port 3000"))
