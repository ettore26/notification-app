(ns app.handler.channel-handlers
  (:require
   [cheshire.core :as json]
   [app.service.channel-service :as channel-service]))

(defn sms-handler [request]
  (let [body (:body request)
        notification-data (assoc body :channel "sms")
        result (channel-service/send-notification notification-data)]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body result}))

(defn email-handler [request]
  (let [body (:body request)
        notification-data (assoc body :channel "email")
        result (channel-service/send-notification notification-data)]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body result}))

(defn push-handler [request]
  (let [body (:body request)
        notification-data (assoc body :channel "push")
        result (channel-service/send-notification notification-data)]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body result}))

