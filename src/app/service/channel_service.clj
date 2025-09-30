(ns app.service.channel-service)

(defn send-notification
  [{:keys [id user category message channel]}]
  {:success true
   :notification-id id
   :user user
   :category category
   :message message
   :channel channel
   :status "sent"})
