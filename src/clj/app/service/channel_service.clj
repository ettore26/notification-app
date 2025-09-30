(ns app.service.channel-service
  (:require
   [clojure.string :as string]))

(def categories #{"Sports" "Finance" "Movies"})

(defn send-notification
  [{:keys [id user category message channel]}]
  (if (contains? categories category)
    {:success true
     :notification-id id
     :user user
     :category category
     :message message
     :channel channel
     :status "sent"}
    {:success false
     :error (str "Invalid category. Must be one of: " (string/join ", " categories))}))
