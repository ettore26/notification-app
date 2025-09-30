(ns app.route.category-routes
  (:require
   [app.handler.category-handlers :as category-handlers]
   [compojure.core :refer [defroutes GET]]))

(defroutes category-routes
  (GET "/api/categories" [] category-handlers/category-handlers))

