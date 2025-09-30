(ns app.core
  (:require [helix.core :refer [defnc $]]
            [helix.hooks :as hooks]
            [helix.dom :as d]
            ["react-dom/client" :as rdom]))

(defnc notification-form []
  (let [[form-data set-form-data]
        (hooks/use-state {:user "" :category "" :message "" :channel "sms"})
        [status set-status] (hooks/use-state nil)
        handle-submit (fn []
                        (set-status "Sending...")
                        (let [payload (clj->js {:id (str (random-uuid))
                                                :user (:user form-data)
                                                :category (:category form-data)
                                                :message (:message form-data)})
                              url (str "/api/channel/" (:channel form-data))]
                          (-> (js/fetch url
                                        #js {:method "POST"
                                             :headers #js {"Content-Type" "application/json"}
                                             :body (js/JSON.stringify payload)})
                              (.then #(.json %))
                              (.then (fn [response]
                                       (js/console.log "Response:" response)
                                       (if (aget response "success")
                                         (set-status "Success!")
                                         (set-status (str "Failed: " (aget response "error"))))))
                              (.catch (fn [error]
                                        (js/console.error "Error:" error)
                                        (set-status "Error: Request failed"))))))]
    (d/div
     (d/h2 "Send Notification")
     (d/form
      (d/div
       (d/label "User: ")
       (d/input {:type "text"
                 :value (:user form-data)
                 :on-change #(set-form-data assoc :user (.. % -target -value))}))
      (d/div
       (d/label "Channel: ")
       (d/select {:value (:channel form-data)
                  :on-change #(set-form-data assoc :channel (.. % -target -value))}
                 (d/option {:value "sms"} "SMS")
                 (d/option {:value "email"} "Email")
                 (d/option {:value "push"} "Push")))
      (d/div
       (d/label "Category: ")
       (d/select {:value (:category form-data)
                  :on-change #(set-form-data assoc :category (.. % -target -value))}
                 (d/option {:value ""} "Select a category")
                 (d/option {:value "Sports"} "Sports")
                 (d/option {:value "Finance"} "Finance")
                 (d/option {:value "Movies"} "Movies")))
      (d/div
       (d/label "Message: ")
       (d/textarea {:value (:message form-data)
                    :on-change #(set-form-data assoc :message (.. % -target -value))}))
      (d/button {:type "button"
                 :on-click handle-submit}
                "Send")
      (when status
        (d/div {:style {:margin-top "10px"
                        :font-weight "bold"}}
               status))))))

(defnc app []
  (d/div
   ($ notification-form)))

(defonce root (rdom/createRoot (js/document.getElementById "app")))

(defn ^:export init []
  (js/console.log "Whizard!")
  (.render root ($ app)))
