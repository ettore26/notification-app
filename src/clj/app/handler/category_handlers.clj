(ns app.handler.category-handlers
  (:require
   [app.service.channel-service :as channel-service]))

(defn category-handlers [_request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (vec channel-service/categories)})

