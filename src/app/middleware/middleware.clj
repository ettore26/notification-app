(ns app.middleware.middleware
  (:require
   [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
   [ring.middleware.json :refer [wrap-json-body wrap-json-response]]
   [ring.middleware.cors :refer [wrap-cors]]))

(defn wrap-middleware [handler]
  (-> handler
      wrap-json-response
      (wrap-json-body {:keywords? true})
      (wrap-cors :access-control-allow-origin [#"http://localhost:3001" #"http://localhost:3002"]
                 :access-control-allow-methods [:get :post :put :delete]
                 :access-control-allow-headers ["Content-Type"])
      (wrap-defaults (assoc-in site-defaults [:security :anti-forgery] false))))

