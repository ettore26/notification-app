(ns app.route.channel-routes
  (:require
   [app.handler.channel-handlers :as channel-handlers]
   [compojure.core :refer [defroutes POST]]))

(defroutes channel-routes
  (POST "/api/channel/sms" [] channel-handlers/sms-handler)
  (POST "/api/channel/email" [] channel-handlers/email-handler)
  (POST "/api/channel/push" [] channel-handlers/push-handler))

