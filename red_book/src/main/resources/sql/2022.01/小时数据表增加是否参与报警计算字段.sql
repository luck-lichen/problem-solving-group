ALTER TABLE "public"."t_d_monitor_hdata"
  ADD COLUMN "is_calculate" int2 DEFAULT 0;

COMMENT ON COLUMN "public"."t_d_monitor_hdata"."is_calculate" IS '标记是否已经参与过报警计算0:未参与1:已参与';