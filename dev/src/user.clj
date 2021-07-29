(ns user
  (:require [migration :as mg]
            [util.datetime :as util]))

;(util/now-filename-str)

;(mg/migrate-up!)
;(mg/rollback!)
;(mg/migrate-up-ids 20111206154000)
;(mg/migrate-down-ids 20111206154000)
;(mg/migrate-up-ids 20111206154000 20210729174220)
;(mg/migrate-down-ids 20111206154000 20210729174220)

; code based migration
;(mg/migrate-up-ids 20170331141500)
;(mg/migrate-down-ids 20170331141500)

; migration 파일 생성
;(mg/create-migration-file "import-users")
;(mg/create-code-based-migration-file "import-users")