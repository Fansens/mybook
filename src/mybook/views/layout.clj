(ns mybook.views.layout
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :refer :all]
            [mybook.tools.func :refer :all]))

(defn common [& body]
  (html5
    [:head
     [:title "Welcome to mybook"]
     (include-css "/css/screen.css")]
    [:body body]))

(defn index [& body]
  (html5
    [:head
     [:title "Login and get more"]
     (include-css "/css/screen.css")]
    [:body
     [:h1 {:style "{color=red}"} "WELCOME TO MY_BOOK"]
     [:hr]
     [:br]
     [:div#main.body
      [:form.login {:method "post" :action "/login"}
       [:p "Login Name: "
        (text-field :name)]
       [:p "Login Password: "
        (password-field :pswd)]
       [:p "Hobbies: "
        (drop-down :hobby ["swiming" "singing" "dancing"] "swiming")]
       [:br]
       [:p
        (submit-button "Submit")
        (reset-button "Reset")]]
      ]]))
(defn login [& body]
  (let [info (list-to-map body)]
    (html5
      [:head
       [:title "Info"]]
      [:body
       [:p (str "name=>" (:name info))]
       [:p (str "pswd=>" (:pswd info))]
       [:p (str "hobby=>" (:hobby info))]])))
