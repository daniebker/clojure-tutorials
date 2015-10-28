(ns chapter-5.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(def character
  {:name "Smooches McCutes"
   :attributes {:intelligence 10
                :strength 4
                :dexterity 5}})

(def c-int (comp :intelligence :attributes))
(def c-str (comp :strength :attributes))
(def c-dex (comp :dexterity :attributes))

(defn attr
  [attribute]
  (get-in character [:attributes attribute]))


(defn my-comp
  [& fns]  
  (reduce (fn [f g]                        
            #(f (apply g %&)))
          fns))
