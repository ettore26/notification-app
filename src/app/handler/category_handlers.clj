(ns app.handler.category-handlers
  (:require
   [cheshire.core :as json]))

(def categories ["Sports" "Finance" "Movies"])

(defn category-handlers [_request]
  {:status 200
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string categories)})

