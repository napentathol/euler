(def singles [
    ""
    "one"
    "two"
    "three"
    "four"
    "five"
    "six"
    "seven"
    "eight"
    "nine"
    "ten"
    "eleven"
    "twelve"
    "thirteen"
    "fourteen"
    "fifteen"
    "sixteen"
    "seventeen"
    "eighteen"
    "nineteen"
  ])

(def tens [
    ""
    ""
    "twenty"
    "thirty"
    "forty"
    "fifty"
    "sixty"
    "seventy"
    "eighty"
    "ninety"
  ])

;;
;; Converts a hundreds value to a string.
;;
;;   Combines the singles value with "hundred" and "and" if applicable.
;;
(defn hundredsToString [x]
  (def hundredInd (quot x 100))

  (def tenInd (mod x 100))
  (def andStr (if (> tenInd 0)
    " and "
    ""
  ))

  (if (> hundredInd 0)
    (if (== hundredInd 10)
      "one thousand"
      (str (singles hundredInd) " hundred" andStr)
    )
    ""
  )
)

;;
;; Converts a tens value to a string.
;;
(defn tensToString [x]
  (def tensVal (mod x 100))
  (def tensInd (quot tensVal 10))
  (def singleInd (mod tensVal 10))

  (if (< tensVal 20)
    (singles tensVal)
    (str (tens tensInd) "-" (singles singleInd))
  ))

;;
;; Converts a number to a string.
;;
(defn numberToString [x]
  (str
    (hundredsToString x)
    (tensToString (mod x 100))
  )
)

;;
;; Strips ' ' and '-' characters
;;
(defn stripUnwantedChars [s]
  (apply str (remove #((set " -") %) s))
)

(defn sumCounts [x]
  (def sum 0)

  (->> (range 1 (+ x 1))
    (map numberToString)
    (map stripUnwantedChars)
    (map count)
    (reduce +)
  )
)

;; (println (numberToString 101))
;; (println (numberToString 100))
;; (println (numberToString 300))
;; (println (numberToString 342))

;; (println (stripUnwantedChars (numberToString 101)))
;; (println (stripUnwantedChars (numberToString 100)))
;; (println (stripUnwantedChars (numberToString 300)))
;; (println (stripUnwantedChars (numberToString 342)))

;; (println (count (stripUnwantedChars (numberToString 1))))
;; (println (count (stripUnwantedChars (numberToString 2))))
;; (println (count (stripUnwantedChars (numberToString 3))))
;; (println (count (stripUnwantedChars (numberToString 4))))
;; (println (count (stripUnwantedChars (numberToString 5))))
;; (println (count (stripUnwantedChars (numberToString 115))))
;; (println (count (stripUnwantedChars (numberToString 342))))

(println (sumCounts 5))
(println (sumCounts 1000))