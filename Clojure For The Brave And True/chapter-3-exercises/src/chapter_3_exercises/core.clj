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