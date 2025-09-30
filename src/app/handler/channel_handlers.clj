(ns app.handler.channel-handlers
  (:require
   [cheshire.core :as json]))

(defn channel-handler [_request]
  (let [users ({:id 1 :name "Mario"} {:id 2 :name "Laura"})]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json/generate-string users)}))

