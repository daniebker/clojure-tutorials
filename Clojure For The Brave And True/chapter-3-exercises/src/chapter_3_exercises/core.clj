(ns chapter-3-exercises.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn use-str
  "Use the str function"
  [name]
  (println "I think therefore I am -" name ))

(defn use-vector
  "use the vector function"
  [item]
  (def ingredients (vector "Pork" "Soy Sauce" "Panko breadcrumbs" "Curry Powder"))
  (println "mixing" item "with" ingredients)
  (println "ummmmm" (conj ingredients item)))

(defn use-list
  "Use a list"
  [rank]
  (def favourite-things '("Photography" "Reading" "Cooking" "Football" "Running" "Games" "Progamming"))
  (println "My number " rank "favourite thing is" (nth favourite-things rank)))

(defn get-info
  "Get information"
  [info]
  (def information (hash-map :name "daniel" :occupation "programmer" :cats 12))
  (println (get information info)))

(defn use-hash-set 
  "use a hash-set"
  [number]
  (def set (hash-set 1 2 3 5 8))
  (println "Adding" number "to" set)
  (println "Resulting hash set" (conj set number)))

(defn inc-100
  "Increase a number by 100"
  [number]
  (+ 100 number))

(defn dec-maker
  "Create a custom number subtractor"
  [dec-by]
  #(- % dec-by))
