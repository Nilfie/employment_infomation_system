/*
 Navicat Premium Data Transfer

 Source Server         : employment
 Source Server Type    : PostgreSQL
 Source Server Version : 150003
 Source Host           : localhost:5432
 Source Catalog        : employment
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150003
 File Encoding         : 65001

 Date: 12/06/2023 17:23:39
*/


-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS "public"."user";
CREATE TABLE "public"."user" (
  "userid" "pg_catalog"."varchar" COLLATE "pg_catalog"."default" NOT NULL,
  "useraccount" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "accountname" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "userpwd" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "usertype" "pg_catalog"."int4"
)
;
COMMENT ON COLUMN "public"."user"."usertype" IS '0-管理员，1-普通用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "public"."user" VALUES ('3', '200102', '李老师', '123456', 1);
INSERT INTO "public"."user" VALUES ('4', '200103', '张老师', '123456', 1);
INSERT INTO "public"."user" VALUES ('1', 'admin', '管理员', '1234', 0);
INSERT INTO "public"."user" VALUES ('2', '200101', '刘老师', '123456', 1);
INSERT INTO "public"."user" VALUES ('5', '200104', '黄老师', '12345', 1);
INSERT INTO "public"."user" VALUES ('6', '200105', '齐老师', '123456', 1);
INSERT INTO "public"."user" VALUES ('7', '200106', '徐老师', '23456', 1);
INSERT INTO "public"."user" VALUES ('8', '200107', '严老师', '234678', 1);
INSERT INTO "public"."user" VALUES ('9', '200108', '陈老师', '765432', 1);
INSERT INTO "public"."user" VALUES ('10', '200109', '姚老师', '634524', 1);
INSERT INTO "public"."user" VALUES ('11', '2001010', '任老师', '343266', 1);
INSERT INTO "public"."user" VALUES ('12', '2001011', '胡老师', '5346645', 1);
INSERT INTO "public"."user" VALUES ('13', '2001012', '周老师', '325463', 1);
INSERT INTO "public"."user" VALUES ('14', '2001013', '付老师', '4345747', 1);
INSERT INTO "public"."user" VALUES ('15', '2001014', '傅老师', '2353464', 1);
INSERT INTO "public"."user" VALUES ('16', '2001015', '刘老师', '5447745', 1);

-- ----------------------------
-- Primary Key structure for table user
-- ----------------------------
ALTER TABLE "public"."user" ADD CONSTRAINT "user_pkey" PRIMARY KEY ("userid");
