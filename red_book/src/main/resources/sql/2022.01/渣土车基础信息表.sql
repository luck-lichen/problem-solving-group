/*
 Navicat Premium Data Transfer

 Source Server         : 张家口开发环境10.110.18.6
 Source Server Type    : PostgreSQL
 Source Server Version : 100003
 Source Host           : 10.110.18.6:5432
 Source Catalog        : pollute
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 100003
 File Encoding         : 65001

 Date: 14/01/2022 15:19:12
*/


-- ----------------------------
-- Table structure for ztc_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."ztc_info";
CREATE TABLE "public"."ztc_info" (
  "id" int8 NOT NULL,
  "gmt_create" timestamp(6) DEFAULT now(),
  "gmt_modified" timestamp(6) DEFAULT now(),
  "qxdm" varchar(255) COLLATE "pg_catalog"."default",
  "qxmc" varchar(255) COLLATE "pg_catalog"."default",
  "ztccph" varchar(255) COLLATE "pg_catalog"."default",
  "qymc" varchar(255) COLLATE "pg_catalog"."default",
  "tyshxydm" varchar(255) COLLATE "pg_catalog"."default",
  "pfjd" varchar(255) COLLATE "pg_catalog"."default",
  "qybm" varchar(255) COLLATE "pg_catalog"."default"
)
;
COMMENT ON COLUMN "public"."ztc_info"."qybm" IS '企业编码';

-- ----------------------------
-- Primary Key structure for table ztc_info
-- ----------------------------
ALTER TABLE "public"."ztc_info" ADD CONSTRAINT "ztc_info_pkey" PRIMARY KEY ("id");
