(ns fwpd.core)
(def filename "suspects.csv")

;;Vector of keys to create vampire maps
(def vamp-keys [:name :glitter-index])

(defn str->int
  "Converts a string to an int"
  [str]
  (Integer. str))

(defn valid-str
  "validates an item is a str"
  [str]
  (instance? String str))

(defn valid-int
  "Validates an item is an int"
  [int]
  (integer? int))

;;Associates a conversion function with each of the vamp keys.
;;No need to conver name, identity just returns the argument
;;passed to it.
(def conversions {:name identity
                  :glitter-index str->int})

(def validations {:name valid-str
                  :glitter-index valid-int })

(defn convert
  "Takes a vamp key and a value and returns the converted value"
  [vamp-key value]
  ((get conversions vamp-key) value))

;;The parse function takes a string and first splits it on the 
;;newline character to create a seq of strings. Next, it maps 
;;over the seq of strings, splitting each one on the comma 
;;character. Try running parse on your CSV:
(defn parse
  "Converts a csv into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\r\n")))

; First, map creates a seq of key-value pairs like 
;;([:name "Bella Swan"] [:glitter-index] 0). Then, reduce builds 
;;up a map by associating a vamp key with a converted vamp value 
;;into row-map;
(defn mapify
  "Return a sequence of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [rows]
  (map (fn [unmapped-row]
         (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                 {}
                 (map vector vamp-keys unmapped-row)))
       rows))

(defn glitter-filter
  "Filters out values with a glitter-index less than minimum-glitter"
  [minimum-glitter records]
  (filter #(>= (:glitter-index %) minimum-glitter) records))

(defn get-names
  "Gets only names of suspects"
  [suspects]
  (map :name suspects))

(defn v
  "Ensures a map contains a key"
  [validations record]
  (if (contains? record validations)
    true
    false))

(defn validate
  "Return a sequence of maps like {:name \"Edward Cullen\" :glitter-index 10}"
  [validations record]
  (reduce (fn [row-map [vamp-key value]]
            ((get validations vamp-key) (get record vamp-key)))
          {}
          validations))

(defn append
  "Appends a suspect to the current suspects"
  [suspect suspects]
  (if (validate validations suspect)
      (conj  suspects {:name (get suspect :name) :glitter-index (get suspect :glitter-index)})
      suspects))
