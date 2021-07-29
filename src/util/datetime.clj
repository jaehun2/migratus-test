(ns util.datetime
  (:require [java-time :as t]))

(def str-format "yyyyMMddHHmmss")

(defn now-ldt
  "현재 datetime을 리턴합니다.
  tz이 없는 경우 UTC로 리턴합니다."
  ([] (now-ldt "UTC"))
  ([tz]
   (let [now (t/with-zone-same-instant (t/zoned-date-time) tz)]
     (.toLocalDateTime now))))

(defn now-filename-str
  "Asia/Seoul tz의 날짜/시간을 yyyyMMddHHmmss 형식으로 반환합니다."
  []
  (t/format str-format (now-ldt "Asia/Seoul")))
