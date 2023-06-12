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

 Date: 12/06/2023 17:23:31
*/


-- ----------------------------
-- Table structure for employment_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."employment_info";
CREATE TABLE "public"."employment_info" (
  "information_id" "pg_catalog"."varchar" COLLATE "pg_catalog"."default" NOT NULL,
  "company_name" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "company_address" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "employment_station" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "treatment" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "ability_requirement" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "student_name" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "student_major" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "student_class" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "student_mobile" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "employment_time" "pg_catalog"."date",
  "company_contact_name" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "company_contact_mobile" "pg_catalog"."varchar" COLLATE "pg_catalog"."default",
  "student_gender" "pg_catalog"."varchar" COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of employment_info
-- ----------------------------
INSERT INTO "public"."employment_info" VALUES ('787533c4d-cba4-4b17-94c4-767987bd06e7', '腾讯', '自贡', '项目经理', '10000', '精通java', '秋雾', '软件工程', '21.1', '12456764323', '2023-05-02', '张女士', '18645662344', '男');
INSERT INTO "public"."employment_info" VALUES ('1687533c4d-cba4-4b17-94c4-767987bd06e7', '东方', '冰岛', '产品经理', '6000', '精通java', '无法', '新媒体技术', '18.9', '134567545', '2022-06-01', '李先生', '135666556', '女');
INSERT INTO "public"."employment_info" VALUES ('87533c4d-cba4-4b17-94c4-767987bd06e720', '腾讯', '新疆', '前端开发', '7500', '精通java', '陈以桐', '数字媒体', '22.5', '11445678881', '2023-06-07', '刘女士', '13456667862', '男');
INSERT INTO "public"."employment_info" VALUES ('1787533c4d-cba4-4b17-94c4-767987bd06e7', '东方', '冰岛', '销售', '6000', '精通java', '豆德', '材料化学', '19.3', '1341331', '2022-06-07', '具先生', '1414212424', '女');
INSERT INTO "public"."employment_info" VALUES ('87533c4d-cba4-4b17-94c4-767987bd06e718', '讯飞', '广州', '销售', '9000', '精通java', '二分', '德语', '19.2', '1423412131', '2022-05-31', 'danum', '134646432', '男');
INSERT INTO "public"."employment_info" VALUES ('1187533c4d-cba4-4b17-94c4-767987bd06e7', '阿达化工', '浙江', '操作员', '5000', '精通java', '费尔奈', '材料化学', '18.7', '134423445', '2022-05-31', '方女士', '134646764', '男');
INSERT INTO "public"."employment_info" VALUES ('ca581765-4174-40e7-bc3f-ecac5d869359', '百度', '北京市海淀区', '软件开发', '25*16', '精通java', '张三', '软件工程', '19.1', '15941140001', '2020-05-20', '大A', '15941140000', '女');
INSERT INTO "public"."employment_info" VALUES ('ed82c5c6-fb80-45f9-bf8d-ae71b58242cd', '腾讯', '四川宜宾', '软件开发', '25*13', '精通Java，html', '刘宇扬', '软件工程', '18.2', '15254875862', '2020-05-20', '刘吉', '15456949852', '男');
INSERT INTO "public"."employment_info" VALUES ('c9b3ce22-7afa-4f01-a790-c5564147e5dc', '腾讯', '深圳市和平区', '软件测试', '20*18', '熟练掌握各种自动化测试工具', '张莉丽', '软件工程', '18.2', '15941140102', '2020-05-19', '舒兰', '15941140101', '男');
INSERT INTO "public"."employment_info" VALUES ('87533c4d-cba4-4b17-94c4-767987bd06e7', '腾讯', '四川成都', '软件测试', '23*15', 'java，测试工具，测试方法', '小七', '软件工程', '19.5', '15252486598', '2022-06-30', '李女士', '15458963248', '男');
INSERT INTO "public"."employment_info" VALUES ('87533c4d-cba4-4b17-94c4-767987bd06e74', '阿达化工', '浙江', '销售', '6000', '精通java', '代位', '环境化学', '19.4', '134423445', '2022-06-01', '方女士', '1346467234', '女');
INSERT INTO "public"."employment_info" VALUES ('1387533c4d-cba4-4b17-94c4-767987bd06e7', '字节', '浙江', '架构师', '20000', '精通java', '费尔奈', '嵌入式', '16.7', '1346467213', '2015-06-09', '武女士', '134646764', '男');
INSERT INTO "public"."employment_info" VALUES ('c311', '字节跳动', '北京', 'java工程师', '30000', '熟悉主流框架;大型项目开发经验；', '胡三', '软件工程', '20.4', '1323232312', '2023-06-01', '徐经理', '15647654546', '男');
INSERT INTO "public"."employment_info" VALUES ('1487533c4d-cba4-4b17-94c4-767987bd06e7', '腾讯', '宜宾', '前端开发', '12000', '精通java', '阿子', '数字金融', '22.4', '12312131313', '2023-06-13', '陈先生', '12345667764', '男');
INSERT INTO "public"."employment_info" VALUES ('04bdd32b-30ff-494e-abc4-b10ed5d1a233', '阿达瓦地产', '成都', '售楼部经理', '12000', '精通java', '黄一', '销售管理', '17.4', '134646412', '2021-06-03', '王经理', '134646764', '女');
INSERT INTO "public"."employment_info" VALUES ('87533c4d-cba4-4b17-94c4-767987bd06e3', '讯飞', '深圳', '测试', '4000', '精通java', '一天', '数字媒体', '19.6', '12344556675', '2023-05-04', '王先生', '13244134455', '女');
INSERT INTO "public"."employment_info" VALUES ('87533c4d-cba4-4b17-94c4-767987bd06e719', '美团', '徐州', '棋手', '6900', '精通java', '阿迪', '环境', '19.4', '13441233212', '2020-06-17', '田先生', '134554433', '男');
INSERT INTO "public"."employment_info" VALUES ('87533c4d-cba4-4b17-94c4-767987bd06e71', '讯飞', '成都', '运营', '5000', '精通java', '刘地', '数字金融', '19.3', '13243223443', '2023-06-02', '王先生', '32433445234', '男');
INSERT INTO "public"."employment_info" VALUES ('02186f88-dfc8-4d0e-9010-1e1fa1ca8ee7', '字节', '北京', '测试', '4000', '精通java', '闻一', '数学', '23.1', '12234455551', '2023-05-02', '刘女士', '12145342342', '男');
INSERT INTO "public"."employment_info" VALUES ('c312', '字节跳动', '北京', 'java工程师', '25000', '具有扎实的数据结构、操作系统、数据库、算法、网络等计算机基础知识;大型项目开发经验；', '袁青', '软件工程', '19.4', '1554535633', '2023-05-30', '徐经理', '17313535323', '男');
INSERT INTO "public"."employment_info" VALUES ('0c20a280-6b9a-42d9-8703-ad7860a0bfd5', '阿里', '宜宾', '后端', '15000', '精通java', '早耳', '生物化学', '22.4', '34425566612', '2023-06-21', '刘女士', '12345345143', '女');
INSERT INTO "public"."employment_info" VALUES ('0d96f1bb-e2ad-43ed-bffc-7e54b6746720', '腾讯', '宜宾', '前段开发', '1900', '精通java', '阿狸', '软件工程', '22.4', '12345678333', '2023-06-14', '王先生', '12343567455', '女');
INSERT INTO "public"."employment_info" VALUES ('387533c4d-cba4-4b17-94c4-767987bd06e7', '阿达化工', '武汗', '产品研发', '8000', '精通java', '居然', '生物化学', '20.1', '1344232344', '2022-06-02', '离女士', '134646764', '男');
INSERT INTO "public"."employment_info" VALUES ('c313', '字节跳动', '北京', 'java工程师', '19000', '优秀的学习能力和自驱力，对新技术有强烈的求知精神，能深入代码研究；善于交流，有良好的团队合作精神和协调沟通能力，有一定推动能力；', '于姣', '软件工程', '19.4', '1875353454', '2023-05-17', '徐经理', '17693578697', '男');
INSERT INTO "public"."employment_info" VALUES ('c314', '博智安全', '南京', 'java工程师', '9000', '.熟练使用Java常用框架和工具，如 Spring boot 、Spring Cloud、SpringMVC、Struts、Hibernate、Mybatis等；理解Java常用设计模式，并且能够合理运用，基本技术特性，如Java数据结构，多线程编程，Java IO等', '谢淑', '软件工程', '19.4', '1903533657', '2023-05-02', '何经理', '15709057087', '女');
INSERT INTO "public"."employment_info" VALUES ('1587533c4d-cba4-4b17-94c4-767987bd06e7', '光环有限', '屈服', '客服', '4000', '精通java', '卡奈', '软件工程', '17.7', '1346467643', '2022-06-01', '为女士', '134646764', '男');
INSERT INTO "public"."employment_info" VALUES ('06d65252-17f1-40c7-807c-a471df5d2280', '格力', '喀什', 'UI设计', '7000', '精通java', '李琦', '大数据', '18.6', '142341231', '2021-06-03', '度先生', '134646764', '女');
INSERT INTO "public"."employment_info" VALUES ('0b8232a1-63d0-4201-943c-673b60629370', '达内', '甘肃', '讲师', '7000', '精通java', '徐其', '大数据', '19.6', '13455333232', '2022-05-30', '龙女士', '134646764', '女');
INSERT INTO "public"."employment_info" VALUES ('587533c4d-cba4-4b17-94c4-767987bd06e7', '字节', '广东', '架构师', '2300', '精通java', '太回', '软件工程', '19.3', '14467533331', '2023-06-02', '张女士', '12123444444', '男');
INSERT INTO "public"."employment_info" VALUES ('687533c4d-cba4-4b17-94c4-767987bd06e7', '腾讯', '成都', '前端开发', '20000', '精通java', '都人', '大数据', '19.6', '12345123413', '2023-06-02', '张女士', '12343134445', '男');
INSERT INTO "public"."employment_info" VALUES ('887533c4d-cba4-4b17-94c4-767987bd06e7', '腾讯', '浙江', '审核', '5000', '精通java', '范广', '网络安全', '19.3', '142314133', '2023-05-11', '方女士', '134646764', '男');
INSERT INTO "public"."employment_info" VALUES ('87533c4d-cba4-4b17-94c4-767987bd06e78', '强盛', '重庆', '销售', '4000', '精通java', '大秋', '英语', '18.4', '1324531234', '2023-01-03', '多先生', '1341232321', '男');
INSERT INTO "public"."employment_info" VALUES ('1087533c4d-cba4-4b17-94c4-767987bd06e7', '阿里', '成都', '前端开发', '6400', '精通java', '阿狸1', '大数据', '22.3', '12345531213', '2023-06-07', '陈先生', '12312112344', '女');
INSERT INTO "public"."employment_info" VALUES ('1287533c4d-cba4-4b17-94c4-767987bd06e7', '阿里', '自贡', '运营', '3400', '精通java', '东方', '大数据', '20.1', '11234567882', '2023-05-02', '王先生', '31345666774', '男');
INSERT INTO "public"."employment_info" VALUES ('c315', '亿通国际', '上海', '数据库设计师', '8500', '熟悉数据库原理并熟练掌握相关优化方案，熟悉数据库设计，熟练掌握SQL语句；能在类Unix环境下熟练开发，掌握Java开发，MySQL配置；有shell/python脚本开发能力更佳；', '尹菁', '计算机科学与技术', '19.7', '1432434243', '2023-05-01', '唐经理', '16846578979', '男');
INSERT INTO "public"."employment_info" VALUES ('c316', '亿通国际', '上海', '软件测试', '4000', '熟悉主流框架;大型项目开发经验；', '马开济', '计算机科学与技术', '19.7', '1763543234', '2023-05-30', '熊经理', '17894770988', '女');
INSERT INTO "public"."employment_info" VALUES ('c317', '亿通国际', '上海', '软件测试', '2500', '具备强烈的责任心，思路清晰，较强的学习能力和解决问题的能力；良好的需求归纳分析和文档编写能力；', '沈彬炳', '计算机科学与技术', '19.8', '1679008989', '2023-06-01', '吴经理', '19290778088', '女');
INSERT INTO "public"."employment_info" VALUES ('c318', '云深网络', '上海', 'java工程师', '8000', '本科及以上学历，计算机、软件相关专业优先；熟悉主流框架;大型项目开发经验；', '傅经亘', '计算机科学与技术', '19.8', '1932467896', '2023-06-01', '尹经理', '15224232112', '女');
INSERT INTO "public"."employment_info" VALUES ('c319', '云深网络', '上海', '运维工程师', '12000', '好的沟通能力及团队合作精神，具备良好的理解能力和表达能力，能够承受一定工作压力；', '罗蕴涵', '计算机科学与技术', '19.8', '1345776768', '2023-04-11', '徐经理', '18799232456', '男');
INSERT INTO "public"."employment_info" VALUES ('c320', '快手', '武汉', 'java工程师', '20000', '熟悉主流框架;热爱互联网，对互联网产品和技术有浓厚的兴趣，热衷于追求技术极致与创新； ', '马波鸿', '计算机科学与技术', '19.2', '1872436436', '2023-04-11', '万经理', '19873722435', '男');

-- ----------------------------
-- Primary Key structure for table employment_info
-- ----------------------------
ALTER TABLE "public"."employment_info" ADD CONSTRAINT "employment_info_pkey" PRIMARY KEY ("information_id");
