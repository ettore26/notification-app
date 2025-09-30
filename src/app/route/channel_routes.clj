(ns app.route.channel-routes
  (:require
   [app.handler.channel-handlers :as channel-handlers]
   [compojure.core :refer [defroutes GET POST]]))

(defroutes channel-route
  (POST "api/channel/sms" [] channel-handlers/channel-handler)
  (POST "api/channel/email" [] channel-handlers/channel-handler)
  (POST "api/channel/push" [] channel-handlers/channel-handler))

