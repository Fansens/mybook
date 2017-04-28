(ns mybook.tools.func)

(defn list-to-map [list]
  "translate a list to map"
  (let [pairs (partition 2 2 list)]
    (reduce #(assoc % (first %2) (nth %2 1))
            {} pairs)))