/*
Navicat PGSQL Data Transfer

Source Server         : postgres
Source Server Version : 90412
Source Host           : localhost:5432
Source Database       : architecture_test
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90412
File Encoding         : 65001

Date: 2017-08-02 22:37:07
*/


-- ----------------------------
-- Table structure for architecture_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."architecture_user";
CREATE TABLE "public"."architecture_user" (
"id" int8 NOT NULL,
"age" int4,
"gender" int4,
"name" varchar(255) COLLATE "default",
"phone_number" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table architecture_user
-- ----------------------------
ALTER TABLE "public"."architecture_user" ADD PRIMARY KEY ("id");
