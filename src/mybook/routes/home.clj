(ns mybook.routes.home
  (:require [compojure.core :refer :all]
            [mybook.views.layout :as layout]))

(defn home []
  (layout/common [:h1 "Hello World!"]))
(defn index []
  (layout/index []))
(defn login [& {:keys [name pswd hobby]}]
  (layout/login :name name :pswd pswd :hobby hobby))

(defroutes home-routes
  (GET "/" [] (home))
           (GET "/index" [] (index))
           (POST "/login" [name pswd hobby] (login :name name :pswd pswd :hobby hobby)))
