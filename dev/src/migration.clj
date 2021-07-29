(ns migration
  (:require [migratus.core :as migratus]))

(def config
  {:store                :database
   :migration-dir        "migrations/"
   :init-script          "init.sql"                         ;script should be located in the :migration-dir path

   ;defaults to true, some databases do not support
   ;schema initialization in a transaction
   :init-in-transaction? false

   :migration-table-name "migratus_migrations"
   :db                   {:classname   "com.mysql.cj.jdbc.Driver"
                          :subprotocol "mysql"
                          :subname     "//localhost:3306/migratus_test"
                          :user        "root"
                          :password    "0000"}})

;initialize the database using the 'init.sql' script
;(migratus/init config)

(defn migrate-up!
  "실행되지 않은 모든 마이그레이션을 실행"
  []
  (migratus/migrate config))

(defn rollback!
  "가장 최근에 실행된 마이그레이션 1개를 롤백"
  []
  (migratus/rollback config))

(defn migrate-up-ids
  "하나 또는 2개 이상의 id를 받아서 마이그레이션 실행"
  [& ids]
  (apply (partial migratus/up config) ids))

(defn migrate-down-ids
  "하나 또는 2개 이상의 id를 받아서 롤백 실행"
  [& ids]
  (apply (partial migratus/down config) ids))

(defn create-migration-file
  "마이그레이션 파일쌍(up & down)을 생성"
  [desc]
  (migratus/create config desc))

(defn create-code-based-migration-file
  "code-based 마이그레이션 파일(.edn)을 생성"
  [desc]
  (migratus/create config desc :edn))
