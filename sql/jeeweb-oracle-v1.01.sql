/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : JEEWEBTEST
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : JEEWEBTEST

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2017-09-10 15:35:37
*/


-- ----------------------------
-- Table structure for CODEGEN_COLUMN
-- ----------------------------
DROP TABLE "CODEGEN_COLUMN";
CREATE TABLE "CODEGEN_COLUMN" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"TABLE_ID" VARCHAR2(32 CHAR) NULL ,
"COLUMN_NAME" VARCHAR2(200 CHAR) NULL ,
"TYPE_NAME" VARCHAR2(200 CHAR) NULL ,
"COLUMN_SIZE" VARCHAR2(10 CHAR) NULL ,
"DECIMAL_DIGITS" VARCHAR2(10 CHAR) NULL ,
"PARMARY_KEY" NUMBER(3) NULL ,
"IMPORTED_KEY" NUMBER(3) NULL ,
"COLUMN_DEF" VARCHAR2(200 CHAR) NULL ,
"IS_NULLABLE" NUMBER(3) NULL ,
"JAVA_TYPE" VARCHAR2(500 CHAR) NULL ,
"JAVA_FIELD" VARCHAR2(200 CHAR) NULL ,
"IS_LIST" CHAR(1 CHAR) NULL ,
"IS_QUERY" CHAR(1 CHAR) NULL ,
"IS_FORM" VARCHAR2(45 CHAR) NULL ,
"QUERY_TYPE" VARCHAR2(200 CHAR) NULL ,
"INPUT_TYPE" VARCHAR2(200 CHAR) NULL ,
"DICT_GROUP" VARCHAR2(200 CHAR) NULL ,
"SORT" NUMBER(10) NULL ,
"CREATE_BY" VARCHAR2(64 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(64 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"DEL_FLAG" CHAR(1 CHAR) DEFAULT '0'  NOT NULL ,
"REGEX_VALID" VARCHAR2(20 CHAR) NULL ,
"VALID_TYPE" VARCHAR2(20 CHAR) NULL ,
"MAX_SIZE" NUMBER(10) NULL ,
"MIN_SIZE" NUMBER(10) NULL ,
"MAX_VALUE" VARCHAR2(30 CHAR) NULL ,
"MIN_VALUE" VARCHAR2(30 CHAR) NULL ,
"NULLMSG" VARCHAR2(255 CHAR) NULL ,
"QUERY_MODEL" VARCHAR2(20 CHAR) NULL ,
"FORM_TYPE" VARCHAR2(20 CHAR) NULL ,
"FOREIGN_TABLE" VARCHAR2(45 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "CODEGEN_COLUMN" IS '代码字段';
COMMENT ON COLUMN "CODEGEN_COLUMN"."ID" IS '字段主键';
COMMENT ON COLUMN "CODEGEN_COLUMN"."TABLE_ID" IS '关联表的ID';
COMMENT ON COLUMN "CODEGEN_COLUMN"."COLUMN_NAME" IS '字段名';
COMMENT ON COLUMN "CODEGEN_COLUMN"."TYPE_NAME" IS '字段类型名称';
COMMENT ON COLUMN "CODEGEN_COLUMN"."COLUMN_SIZE" IS '字段长度';
COMMENT ON COLUMN "CODEGEN_COLUMN"."DECIMAL_DIGITS" IS '小数部分的位数';
COMMENT ON COLUMN "CODEGEN_COLUMN"."PARMARY_KEY" IS '是否为主键';
COMMENT ON COLUMN "CODEGEN_COLUMN"."IMPORTED_KEY" IS '是否为外键';
COMMENT ON COLUMN "CODEGEN_COLUMN"."COLUMN_DEF" IS '默认值';
COMMENT ON COLUMN "CODEGEN_COLUMN"."IS_NULLABLE" IS '是否允许为空';
COMMENT ON COLUMN "CODEGEN_COLUMN"."JAVA_TYPE" IS 'JAVA类型';
COMMENT ON COLUMN "CODEGEN_COLUMN"."JAVA_FIELD" IS 'JAVA字段名';
COMMENT ON COLUMN "CODEGEN_COLUMN"."IS_LIST" IS '是否列表字段';
COMMENT ON COLUMN "CODEGEN_COLUMN"."IS_QUERY" IS '是否查询字段';
COMMENT ON COLUMN "CODEGEN_COLUMN"."IS_FORM" IS '是否表单显示';
COMMENT ON COLUMN "CODEGEN_COLUMN"."QUERY_TYPE" IS '查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）';
COMMENT ON COLUMN "CODEGEN_COLUMN"."INPUT_TYPE" IS '字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）';
COMMENT ON COLUMN "CODEGEN_COLUMN"."DICT_GROUP" IS '字典分组';
COMMENT ON COLUMN "CODEGEN_COLUMN"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "CODEGEN_COLUMN"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "CODEGEN_COLUMN"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "CODEGEN_COLUMN"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "CODEGEN_COLUMN"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "CODEGEN_COLUMN"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "CODEGEN_COLUMN"."REGEX_VALID" IS '验证规则';
COMMENT ON COLUMN "CODEGEN_COLUMN"."VALID_TYPE" IS '校验类型';
COMMENT ON COLUMN "CODEGEN_COLUMN"."MAX_SIZE" IS '最大长度';
COMMENT ON COLUMN "CODEGEN_COLUMN"."MIN_SIZE" IS '最小长度';
COMMENT ON COLUMN "CODEGEN_COLUMN"."MAX_VALUE" IS '最大值';
COMMENT ON COLUMN "CODEGEN_COLUMN"."MIN_VALUE" IS '最小值';
COMMENT ON COLUMN "CODEGEN_COLUMN"."NULLMSG" IS '为空提示';
COMMENT ON COLUMN "CODEGEN_COLUMN"."QUERY_MODEL" IS '查询模式';
COMMENT ON COLUMN "CODEGEN_COLUMN"."FORM_TYPE" IS '显示表单类型';
COMMENT ON COLUMN "CODEGEN_COLUMN"."FOREIGN_TABLE" IS '外键表';

-- ----------------------------
-- Records of CODEGEN_COLUMN
-- ----------------------------
INSERT INTO "CODEGEN_COLUMN" VALUES ('9b04cd2a154348a7ae8d9087efe62fe1', '6a800ca30fc2472bb67b278c0710945c', 'ORDER_ID', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'String', 'order', '0', '0', '0', 'eq', null, null, '2', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), 'order_id', '0', null, null, null, null, null, null, null, 'input', 'input', 'TEST_ORDER_MAIN');
INSERT INTO "CODEGEN_COLUMN" VALUES ('22bb61cf74ca4e26be503d8c059278cf', '6a800ca30fc2472bb67b278c0710945c', 'NAME', 'VARCHAR2', '50', '0', '0', '0', null, '0', 'String', 'name', '1', '0', '1', 'eq', null, null, '3', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '客户姓名', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('21c67e13c304480bbcb5dedba5d58523', '6a800ca30fc2472bb67b278c0710945c', 'SEX', 'VARCHAR2', '4', '0', '0', '0', null, '0', 'String', 'sex', '1', '0', '1', 'eq', null, 'sex', '4', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '性别', '0', null, null, null, null, null, null, null, 'select', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('066144aaf1e941d983c8b5e269230b0c', '6a800ca30fc2472bb67b278c0710945c', 'PHONE', 'VARCHAR2', '11', '0', '0', '0', null, '0', 'String', 'phone', '1', '0', '1', 'eq', null, null, '5', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '电话', '0', null, 'm', null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('d260221fa1c94e058c1caa4b67245388', '6a800ca30fc2472bb67b278c0710945c', 'REMARKS', 'VARCHAR2', '255', '0', '0', '0', null, '1', 'String', 'remarks', '0', '0', '0', 'eq', null, null, '6', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '备注信息', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('7b6d1c9fd6b44b63b9f3ebf9d5e58dad', '6a800ca30fc2472bb67b278c0710945c', 'CREATE_BY', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'createBy', '0', '0', '0', 'eq', null, null, '7', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '创建者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('0457b5dac5ca4eafa0a1e1407b3e7676', '6a800ca30fc2472bb67b278c0710945c', 'CREATE_DATE', 'DATE', '7', '0', '0', '0', null, '1', 'Date', 'createDate', '0', '0', '0', 'eq', null, null, '8', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '创建时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('de86015ec77f430cabcec1eceada4a4d', '6a800ca30fc2472bb67b278c0710945c', 'UPDATE_BY', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'updateBy', '0', '0', '0', 'eq', null, null, '9', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '更新者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('7d5abf09b5024814ba9b03c0fb7c6cd1', '6a800ca30fc2472bb67b278c0710945c', 'UPDATE_DATE', 'DATE', '7', '0', '0', '0', null, '1', 'Date', 'updateDate', '0', '0', '0', 'eq', null, null, '10', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '更新时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('ec3e5d57f7084819a2b7c3c2c00b837c', '6a800ca30fc2472bb67b278c0710945c', 'DEL_FLAG', 'VARCHAR2', '1', '0', '0', '0', '0', '0', 'String', 'delFlag', '0', '0', '0', 'eq', null, null, '11', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '删除标记（0：正常；1：删除）', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('e2f12ab260364e9bb5f7c58e3964bb04', '618a6daeb61d40358cc167499cfec4b5', 'ID', 'VARCHAR2', '32', '0', '1', '0', null, '0', 'String', 'id', '0', '0', '0', 'eq', null, null, '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '主键', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('aee2c0f283ef45fe85f84628e88d5271', '618a6daeb61d40358cc167499cfec4b5', 'FLTNO', 'VARCHAR2', '50', '0', '0', '0', null, '0', 'String', 'fltno', '1', '0', '1', 'eq', null, null, '2', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '航班号', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('be8674acdba148c68d5130600d083931', '618a6daeb61d40358cc167499cfec4b5', 'FLYTIME', 'DATE', '7', '0', '0', '0', null, '0', 'Date', 'flytime', '1', '0', '1', 'eq', null, null, '3', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '航班时间', '0', null, null, null, null, null, null, null, 'input', 'dateselect', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('17d0cff7de0c4445945fe377602404b3', '618a6daeb61d40358cc167499cfec4b5', 'REMARKS', 'VARCHAR2', '255', '0', '0', '0', null, '1', 'String', 'remarks', '1', '0', '1', 'eq', null, null, '4', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '备注信息', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('891f03e9448d470e8fbc2abb8f01adff', '618a6daeb61d40358cc167499cfec4b5', 'ORDER_ID', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'String', 'order', '0', '0', '0', 'eq', null, null, '5', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), 'order_id', '0', null, null, null, null, null, null, null, 'input', 'input', 'TEST_ORDER_MAIN');
INSERT INTO "CODEGEN_COLUMN" VALUES ('1117b17c775b409888e47a5dde98e3e6', '618a6daeb61d40358cc167499cfec4b5', 'CREATE_BY', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'createBy', '0', '0', '0', 'eq', null, null, '6', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '创建者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('ded7479b6d464d4b848f71db189fa209', '618a6daeb61d40358cc167499cfec4b5', 'CREATE_DATE', 'DATE', '19', '0', '0', '0', null, '1', 'Date', 'createDate', '0', '0', '0', 'eq', null, null, '7', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '创建时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('b3e1fffefc0a4391af11a11ae1a4fc04', '618a6daeb61d40358cc167499cfec4b5', 'UPDATE_BY', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'updateBy', '0', '0', '0', 'eq', null, null, '8', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '更新者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('548dd69c534e41b09ce58041c4eb77f5', '618a6daeb61d40358cc167499cfec4b5', 'UPDATE_DATE', 'DATE', '7', '0', '0', '0', null, '1', 'Date', 'updateDate', '0', '0', '0', 'eq', null, null, '9', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '更新时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('3a9003f98dbf467bb42082fed10d0613', '618a6daeb61d40358cc167499cfec4b5', 'DEL_FLAG', 'VARCHAR2', '1', '0', '0', '0', '0', '0', 'String', 'delFlag', '0', '0', '0', 'eq', null, null, '10', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '删除标记（0：正常；1：删除）', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('d2f7586cf67a4a45b67b7ab9dd0df0e4', '26e46c4c899249849029cfb41b1cb541', 'ID', 'VARCHAR2', '32', '0', '1', '0', null, '0', 'String', 'id', '0', '0', '0', 'eq', null, null, '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '主键', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('68397c874057458797b1f71ce12ee39a', '2e1c4541eecb43d5bb87b8032888489d', 'DEL_FLAG', 'VARCHAR2', '1', '0', '0', '0', '0', '0', 'String', 'delFlag', '0', '0', '0', 'eq', null, null, '9', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '删除标记（0：正常；1：删除）', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('5169d35a00604e218009d874af286970', '2e1c4541eecb43d5bb87b8032888489d', 'REMARKS', 'VARCHAR2', '255', '0', '0', '0', null, '1', 'String', 'remarks', '0', '0', '0', 'eq', null, null, '10', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '备注信息', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('348e6fd3955e44eabb750a4ce250af0c', '6a800ca30fc2472bb67b278c0710945c', 'ID', 'VARCHAR2', '32', '0', '1', '0', null, '0', 'String', 'id', '0', '0', '0', 'eq', null, null, '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '主键', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('701f46c7ad774b4b87e7060f514637dd', '26e46c4c899249849029cfb41b1cb541', 'NAME', 'VARCHAR2', '100', '0', '0', '0', null, '1', 'String', 'name', '1', '0', '1', 'eq', null, null, '2', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '机构名称', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('39fd7612f12f42f2b20cd190543cc381', '26e46c4c899249849029cfb41b1cb541', 'REMARKS', 'VARCHAR2', '255', '0', '0', '0', null, '1', 'String', 'remarks', '0', '0', '0', 'eq', null, null, '3', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '备注信息', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('dd2267601f8643b3be498b3fa09928c7', '26e46c4c899249849029cfb41b1cb541', 'CREATE_BY', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'createBy', '0', '0', '0', 'eq', null, null, '4', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '创建者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('7b28010c3bd44ca98b79b6281b914aa3', '26e46c4c899249849029cfb41b1cb541', 'CREATE_DATE', 'DATE', '7', '0', '0', '0', null, '1', 'Date', 'createDate', '0', '0', '0', 'eq', null, null, '5', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '创建时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('74f53ddb74bf4f2e9da351582f8723e4', '26e46c4c899249849029cfb41b1cb541', 'UPDATE_BY', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'updateBy', '0', '0', '0', 'eq', null, null, '6', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '更新者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('8395fde01fb349d8b04e952c5d316e81', '26e46c4c899249849029cfb41b1cb541', 'UPDATE_DATE', 'DATE', '7', '0', '0', '0', null, '1', 'Date', 'updateDate', '0', '0', '0', 'eq', null, null, '7', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '更新时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('d348cfac2ac3466f8707a0bed4e2cccd', '26e46c4c899249849029cfb41b1cb541', 'DEL_FLAG', 'VARCHAR2', '1', '0', '0', '0', '0', '0', 'String', 'delFlag', '0', '0', '0', 'eq', null, null, '8', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '删除标记（0：正常；1：删除）', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('7c510ae317014ec28dc66ec84b25bd07', '2e1c4541eecb43d5bb87b8032888489d', 'ID', 'VARCHAR2', '32', '0', '1', '0', null, '0', 'String', 'id', '0', '0', '0', 'eq', null, null, '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '主键', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('a7b2c7f2e68540e4b39961999a733f6f', '2e1c4541eecb43d5bb87b8032888489d', 'ORDERNO', 'VARCHAR2', '50', '0', '0', '0', null, '0', 'String', 'orderno', '1', '0', '1', 'eq', null, null, '2', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '订单号', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('6611468695d34ba58350825928a5d6a5', '2e1c4541eecb43d5bb87b8032888489d', 'MONEY', 'VARCHAR2', '22', '0', '0', '0', null, '0', 'String', 'money', '1', '0', '1', 'eq', null, null, '3', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '订单金额', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('25104cd08c0a406992268651940d24c2', '2e1c4541eecb43d5bb87b8032888489d', 'ORDERDATE', 'VARCHAR2', '19', '0', '0', '0', null, '0', 'String', 'orderdate', '1', '0', '1', 'eq', null, null, '4', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '订单日期', '0', null, null, null, null, null, null, null, 'input', 'dateselect', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('c961dc60b54a4ac283f8214e2cb30c23', '26e46c4c899249849029cfb41b1cb541', 'PARENT_ID', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'String', 'parentId', '0', '0', '0', 'eq', null, null, '9', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '父节点', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('ca53be0dfba14c64affa64e35402255a', '26e46c4c899249849029cfb41b1cb541', 'PARENT_IDS', 'VARCHAR2', '1000', '0', '0', '0', null, '1', 'String', 'parentIds', '0', '0', '0', 'eq', null, null, '10', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '父节点路径', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('c90a1b29eea54c318c4b66d0cd997031', '2e1c4541eecb43d5bb87b8032888489d', 'CREATE_BY', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'createBy', '0', '0', '0', 'eq', null, null, '5', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '创建者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('f234e622b3194a25818da27971df0197', '2e1c4541eecb43d5bb87b8032888489d', 'CREATE_DATE', 'DATE', '7', '0', '0', '0', null, '1', 'Date', 'createDate', '0', '0', '0', 'eq', null, null, '6', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '创建时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('7657154fbaae4bd09e97e80c46215576', '2e1c4541eecb43d5bb87b8032888489d', 'UPDATE_BY', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'updateBy', '0', '0', '0', 'eq', null, null, '7', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '更新者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('3e7bb73bf8bf4f15acf6874bb06c2ac4', '2e1c4541eecb43d5bb87b8032888489d', 'UPDATE_DATE', 'DATE', '7', '0', '0', '0', null, '1', 'Date', 'updateDate', '0', '0', '0', 'eq', null, null, '8', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '更新时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40281e815c580ea3015c58c75e94002e', '40281e815c580ea3015c58c75e89002d', 'id', 'VARCHAR', '32', '0', '1', '0', ' ', '0', 'String', 'id', '0', '0', '0', 'eq', null, ' ', '1', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '字段主键', '0', ' ', ' ', null, null, ' ', ' ', ' ', 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40281e815c580ea3015c58c75e99002f', '40281e815c580ea3015c58c75e89002d', 'name', 'VARCHAR', '255', ' ', '0', '0', ' ', '0', 'String', 'name', '1', '0', '1', 'eq', null, ' ', '2', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '名称', '0', ' ', '*', null, null, ' ', ' ', ' ', 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40281e815c580ea3015c58c75e9d0030', '40281e815c580ea3015c58c75e89002d', 'create_by', 'VARCHAR', '32', '0', '0', '0', ' ', '1', 'User', 'createBy', '0', '0', '0', 'eq', null, ' ', '4', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '创建者', '0', ' ', ' ', null, null, ' ', ' ', ' ', 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40281e815c580ea3015c58c75ea10031', '40281e815c580ea3015c58c75e89002d', 'create_date', 'DATE', '19', '0', '0', '0', ' ', '1', 'Date', 'createDate', '0', '0', '0', 'eq', null, ' ', '5', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '创建时间', '0', ' ', ' ', null, null, ' ', ' ', ' ', 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40281e815c580ea3015c58c75ea60032', '40281e815c580ea3015c58c75e89002d', 'update_by', 'VARCHAR', '32', '0', '0', '0', ' ', '1', 'User', 'updateBy', '0', '0', '0', 'eq', null, ' ', '6', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '更新者', '0', ' ', ' ', null, null, ' ', ' ', ' ', 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40281e815c580ea3015c58c75eab0033', '40281e815c580ea3015c58c75e89002d', 'update_date', 'DATE', '19', '0', '0', '0', ' ', '1', 'Date', 'updateDate', '0', '0', '0', 'eq', null, ' ', '7', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '更新时间', '0', ' ', ' ', null, null, ' ', ' ', ' ', 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40281e815c580ea3015c58c75eaf0034', '40281e815c580ea3015c58c75e89002d', 'del_flag', 'CHAR', '1', '0', '0', '0', '0', '1', 'String', 'delFlag', '0', '0', '0', 'eq', null, ' ', '8', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '删除标记（0：正常；1：删除）', '0', ' ', ' ', null, null, ' ', ' ', ' ', 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40281e815c580ea3015c58c75eb30035', '40281e815c580ea3015c58c75e89002d', 'remarks', 'VARCHAR', '255', '0', '0', '0', ' ', '1', 'String', 'remarks', '0', '0', '1', 'eq', null, ' ', '9', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '备注信息', '0', ' ', ' ', null, null, ' ', ' ', ' ', 'input', 'editor', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40281e815c58ccb7015c58d9b3bd0016', '40281e815c580ea3015c58c75e89002d', 'testdate', 'DATE', '255', ' ', '0', '0', ' ', '0', 'Date', 'testdate', '0', '0', '1', 'eq', null, ' ', '3', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '时间', '0', ' ', ' ', null, null, ' ', ' ', ' ', 'input', 'dateselect', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('24cde6558c19443d918d2b2341fe565a', '1cc552d7f01442d1b0a7c334161b238c', 'id', 'VARCHAR2', '32', '0', '1', '0', null, '0', 'String', 'id', '0', '0', '0', 'eq', null, null, '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '主键', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('6bd59a81c6184d95b6068cf84681b873', '1cc552d7f01442d1b0a7c334161b238c', 'name', 'VARCHAR2', '255', '0', '0', '0', null, '0', 'String', 'name', '1', '0', '1', 'eq', null, null, '2', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '名称', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('b69a2b8bc9bf49df97e826fffa8cb280', '1cc552d7f01442d1b0a7c334161b238c', 'testdate', 'DATE', '7', '0', '0', '0', null, '0', 'Date', 'testdate', '1', '0', '1', 'eq', null, null, '3', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '时间', '0', null, null, null, null, null, null, null, 'input', 'dateselect', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('cd42b2703d1249fcae724c329912b715', '1cc552d7f01442d1b0a7c334161b238c', 'create_by', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'createBy', '0', '0', '0', 'eq', null, null, '4', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '创建者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('c5f5d7066ac34e5b9e708dc08e2af714', '1cc552d7f01442d1b0a7c334161b238c', 'create_date', 'DATE', '7', '0', '0', '0', null, '1', 'Date', 'createDate', '0', '0', '0', 'eq', null, null, '5', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '创建时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('b8c0a2aec7654aaa8a8529e95a19bc9e', '1cc552d7f01442d1b0a7c334161b238c', 'update_by', 'VARCHAR2', '32', '0', '0', '0', null, '1', 'User', 'updateBy', '0', '0', '0', 'eq', null, null, '6', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '更新者', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('40d74e34286144baa0645b4f35ac1174', '1cc552d7f01442d1b0a7c334161b238c', 'update_date', 'DATE', '7', '0', '0', '0', null, '1', 'Date', 'updateDate', '0', '0', '0', 'eq', null, null, '7', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '更新时间', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('919a9068a38e4b9d97bee34d3b76b7cb', '1cc552d7f01442d1b0a7c334161b238c', 'del_flag', 'CHAR', '1', '0', '0', '0', '0', '1', 'String', 'delFlag', '0', '0', '0', 'eq', null, null, '8', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '删除标记（0：正常；1：删除）', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');
INSERT INTO "CODEGEN_COLUMN" VALUES ('c266292b49ed46f4a49e831a197fca22', '1cc552d7f01442d1b0a7c334161b238c', 'remarks', 'VARCHAR2', '255', '0', '0', '0', null, '1', 'String', 'remarks', '0', '0', '0', 'eq', null, null, '9', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '备注信息', '0', null, null, null, null, null, null, null, 'input', 'input', '请选择主表');

-- ----------------------------
-- Table structure for CODEGEN_SCHEME
-- ----------------------------
DROP TABLE "CODEGEN_SCHEME";
CREATE TABLE "CODEGEN_SCHEME" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"TABLE_TYPE" VARCHAR2(2000 CHAR) NULL ,
"PATH_NAME" VARCHAR2(2000 CHAR) NULL ,
"PACKAGE_NAME" VARCHAR2(500 CHAR) NULL ,
"MODULE_NAME" VARCHAR2(30 CHAR) NULL ,
"ENTITY_NAME" VARCHAR2(30 CHAR) NULL ,
"TABLE_NAME" VARCHAR2(30 CHAR) NULL ,
"SUB_MODULE_NAME" VARCHAR2(30 CHAR) NULL ,
"FUNCTION_NAME" VARCHAR2(500 CHAR) NULL ,
"FUNCTION_DESC" VARCHAR2(100 CHAR) NULL ,
"FUNCTION_AUTHOR" VARCHAR2(100 CHAR) NULL ,
"TABLE_ID" VARCHAR2(200 CHAR) NULL ,
"CREATE_BY" VARCHAR2(64 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(64 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"DEL_FLAG" CHAR(1 CHAR) DEFAULT '0'  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "CODEGEN_SCHEME" IS '生成方案';
COMMENT ON COLUMN "CODEGEN_SCHEME"."ID" IS '编号';
COMMENT ON COLUMN "CODEGEN_SCHEME"."TABLE_TYPE" IS '表类型';
COMMENT ON COLUMN "CODEGEN_SCHEME"."PATH_NAME" IS '代码生成目录';
COMMENT ON COLUMN "CODEGEN_SCHEME"."PACKAGE_NAME" IS '生成包路径';
COMMENT ON COLUMN "CODEGEN_SCHEME"."MODULE_NAME" IS '生成模块名';
COMMENT ON COLUMN "CODEGEN_SCHEME"."ENTITY_NAME" IS '实体名';
COMMENT ON COLUMN "CODEGEN_SCHEME"."TABLE_NAME" IS '表名';
COMMENT ON COLUMN "CODEGEN_SCHEME"."SUB_MODULE_NAME" IS '生成子模块名';
COMMENT ON COLUMN "CODEGEN_SCHEME"."FUNCTION_NAME" IS '生成功能名';
COMMENT ON COLUMN "CODEGEN_SCHEME"."FUNCTION_DESC" IS '生成功能名（简写）';
COMMENT ON COLUMN "CODEGEN_SCHEME"."FUNCTION_AUTHOR" IS '生成功能作者';
COMMENT ON COLUMN "CODEGEN_SCHEME"."TABLE_ID" IS '生成表编号';
COMMENT ON COLUMN "CODEGEN_SCHEME"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "CODEGEN_SCHEME"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "CODEGEN_SCHEME"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "CODEGEN_SCHEME"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "CODEGEN_SCHEME"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "CODEGEN_SCHEME"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';

-- ----------------------------
-- Records of CODEGEN_SCHEME
-- ----------------------------
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815c6bb87e015c6c1df2e3008b', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'test', 'OrderMain', ' ', ' ', '订单主菜单', '订单主菜单', 'jeeweb', '40281e815c6bb87e015c6c118a19006a', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815c6bb87e015c6c1e4124008c', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'test', 'OrderTicket', ' ', ' ', '订单机票信息', '订单机票信息', 'jeeweb', '40281e815c6bb87e015c6c170d450075', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815c6bb87e015c6c1e61be008d', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'test', 'OrderCustomer', ' ', ' ', '订单客户信息', '订单客户信息', 'jeeweb', '40281e815c6bb87e015c6c1bb4d1007f', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-03 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815c8f3512015c8f3fda260019', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'email', 'EmailSendLog', ' ', ' ', '邮件发送日志', '邮件发送日志', 'jeeweb', '40281e815c8f3512015c8f3a07440000', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815c8f3512015c8f403fc1001a', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'email', 'EmailTemplate', ' ', ' ', '邮件发送模板', '邮件发送模板', 'jeeweb', '40281e815c8f3512015c8f3ddecc000c', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815c912406015c9148f0780043', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'oa', 'OaNotification', ' ', ' ', '通知公告', '通知公告', 'jeeweb', '40281e815c912406015c914826de0038', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815cb55466015cb558f36a0017', '2', 'D:\Workspaces\idea\jeeweb-mybatis', 'cn.jeeweb.modules', 'test', 'TestOrderMain', null, null, '订单主表', '订单主表', 'jeeweb', '40281e815cb51519015cb55358d70000', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815cb55aca015cb57180fa0000', '3', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'testest', 'TestOrderTicket', ' ', ' ', '机票信息', '机票信息', 'jeeweb', '40281e815cb55466015cb55718970000', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815cb5eb7c015cb5edc2ef0002', '3', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'test', 'TestOrderCustomer', ' ', ' ', '客户信息', '客户信息', 'jeeweb', '40281e815cb55466015cb5573425000b', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-17 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815cef1f76015cef25771f000d', '4', 'D:\Workspaces\idea\jeeweb-mybatis', 'cn.jeeweb.modules', 'test', 'TestTree', null, null, '测试数', '测试数', 'jeeweb', '40281e815cef1f76015cef253e6f0002', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-28 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40281e815d0df780015d0e218ac60000', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'test', 'TTest', ' ', ' ', '测试', '测试', 'jeeweb', '40281e815cee3be2015cef05ab4c0009', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40288ab85c8593cd015c859c6cd80014', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'sms', 'SmsTemplate', ' ', ' ', '短信模版', '短信模版', 'jeeweb', '40288ab85c8593cd015c8599bb420001', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40288ab85c85fa54015c860c65d10022', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'sms', 'SmsSendLog', ' ', ' ', '短信发送日志', '短信发送日志', 'jeeweb', '40288ab85c85fa54015c85fea121000c', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40288ab85ce39796015ce39a217c000e', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'test', 'SmsSendLog', ' ', ' ', '发送日志', '发送日志', 'jeeweb', '40288ab85ce39796015ce39a0e9a0000', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40288ab85ce39796015ce39c708f0018', null, 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', null, 'TTestTest', 't_test_test', null, '测试表', '测试表', 'jeeweb', '40288ab85ce39796015ce39c661c000f', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('40288ab85d0cb564015d0cb653af0000', '1', 'D:\Workspaces\mavengzfzkj\jeeweb', 'cn.jeeweb.modules', 'test', 'TestTestSingle', ' ', ' ', '测试啦', '测试啦', 'jeeweb', '40288ab85d0b718b015d0b72a92e0000', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-04 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('bbdcb2c5611a472e95f977c5ee7ff39e', null, 'D:\Workspaces\mavengzfzkj\jeeweb-mybatis', 'cn.jeeweb.modules', null, 'TESTSINGLETABLE', 'TEST_SINGLE_TABLE', null, null, null, 'jeeweb', '43ce37d1c555417eb5e0d569589ee097', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:27:16', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('d8e42b05164f4e67b41adebadc9bf316', '1', 'D:\Workspaces\idea\jeeweb-mybatis', 'cn.jeeweb.modules', 'test', 'SingleTable', null, null, '测试单表', '测试单表', 'jeeweb', '1cc552d7f01442d1b0a7c334161b238c', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:30:06', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('b765aadad4a943c3ab6fa4b62205680c', '2', 'D:\Workspaces\idea\jeeweb-mybatis', 'cn.jeeweb.modules', 'test', 'TestOrderMain', null, null, '测试主表', '测试主表', 'jeeweb', '2e1c4541eecb43d5bb87b8032888489d', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:52:56', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:53:17', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "CODEGEN_SCHEME" VALUES ('2d8b620802904294a6158faa367b70fd', '4', 'D:\Workspaces\idea\jeeweb-mybatis', 'cn.jeeweb.modules', 'test', 'TestTree', null, null, '测试树', '测试树', 'jeeweb', '26e46c4c899249849029cfb41b1cb541', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:34:58', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:36:02', 'YYYY-MM-DD HH24:MI:SS'), null, '0');

-- ----------------------------
-- Table structure for CODEGEN_TABLE
-- ----------------------------
DROP TABLE "CODEGEN_TABLE";
CREATE TABLE "CODEGEN_TABLE" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"TITLE" VARCHAR2(200 CHAR) NULL ,
"TABLE_NAME" VARCHAR2(200 CHAR) NULL ,
"TABLE_TYPE" VARCHAR2(10 CHAR) NULL ,
"TABLE_PK_TYPE" VARCHAR2(5 CHAR) NULL ,
"CREATE_BY" VARCHAR2(64 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(64 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"DEL_FLAG" CHAR(1 CHAR) DEFAULT '0'  NOT NULL ,
"SYNC_DATABASE" NUMBER(3) NULL ,
"CLASS_NAME" VARCHAR2(50 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "CODEGEN_TABLE" IS '代码生成信息';
COMMENT ON COLUMN "CODEGEN_TABLE"."ID" IS '生成方案主键';
COMMENT ON COLUMN "CODEGEN_TABLE"."TITLE" IS '实体名称';
COMMENT ON COLUMN "CODEGEN_TABLE"."TABLE_NAME" IS '实体名称';
COMMENT ON COLUMN "CODEGEN_TABLE"."TABLE_TYPE" IS '表的类型';
COMMENT ON COLUMN "CODEGEN_TABLE"."TABLE_PK_TYPE" IS '数据主键类型';
COMMENT ON COLUMN "CODEGEN_TABLE"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "CODEGEN_TABLE"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "CODEGEN_TABLE"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "CODEGEN_TABLE"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "CODEGEN_TABLE"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "CODEGEN_TABLE"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "CODEGEN_TABLE"."SYNC_DATABASE" IS '是否同步数据库';
COMMENT ON COLUMN "CODEGEN_TABLE"."CLASS_NAME" IS '实体名称';

-- ----------------------------
-- Records of CODEGEN_TABLE
-- ----------------------------
INSERT INTO "CODEGEN_TABLE" VALUES ('26e46c4c899249849029cfb41b1cb541', 'TEST_TREE', 'TEST_TREE', '4', null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:29:38', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:04', 'YYYY-MM-DD HH24:MI:SS'), '测试树', '0', '1', 'TestTree');
INSERT INTO "CODEGEN_TABLE" VALUES ('2e1c4541eecb43d5bb87b8032888489d', '测试主表', 'TEST_ORDER_MAIN', '2', null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:04', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), '测试主表', '0', '1', 'TestOrderMain');
INSERT INTO "CODEGEN_TABLE" VALUES ('6a800ca30fc2472bb67b278c0710945c', 'TEST_ORDER_CUSTOMER', 'TEST_ORDER_CUSTOMER', '3', null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:11', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:30', 'YYYY-MM-DD HH24:MI:SS'), '订单客户信息', '0', '1', 'TestOrderCustomer');
INSERT INTO "CODEGEN_TABLE" VALUES ('618a6daeb61d40358cc167499cfec4b5', 'TEST_ORDER_TICKET', 'TEST_ORDER_TICKET', '3', null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:47:37', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:38', 'YYYY-MM-DD HH24:MI:SS'), '订单票据', '0', '1', 'TestOrderTicket');
INSERT INTO "CODEGEN_TABLE" VALUES ('1cc552d7f01442d1b0a7c334161b238c', 'TEST_SINGLE_TABLE', 'TEST_SINGLE_TABLE', '1', null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:34', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:02:10', 'YYYY-MM-DD HH24:MI:SS'), '测试单表', '0', '1', 'TestSingleTable');

-- ----------------------------
-- Table structure for EMAIL_SEND_LOG
-- ----------------------------
DROP TABLE "EMAIL_SEND_LOG";
CREATE TABLE "EMAIL_SEND_LOG" (
"ID" VARCHAR2(32 CHAR) NULL ,
"EMAIL" CLOB NULL ,
"SUBJECT" VARCHAR2(255 CHAR) NULL ,
"CONTENT" CLOB NULL ,
"SENDDATA" VARCHAR2(255 CHAR) NULL ,
"RESPONSE_DATE" DATE NULL ,
"BUSINESS_TYPE" VARCHAR2(4 CHAR) NULL ,
"DEL_FLAG" VARCHAR2(1 CHAR) DEFAULT '0'  NULL ,
"STATUS" VARCHAR2(4 CHAR) NULL ,
"MSG" VARCHAR2(40 CHAR) NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "EMAIL_SEND_LOG" IS '邮件发送日志';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."EMAIL" IS '联系电话';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."SUBJECT" IS '主题';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."CONTENT" IS '模板类型';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."SENDDATA" IS '发送数据';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."RESPONSE_DATE" IS '响应时间';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."BUSINESS_TYPE" IS '业务类型';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."STATUS" IS '发送状态';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."MSG" IS '返回消息';
COMMENT ON COLUMN "EMAIL_SEND_LOG"."REMARKS" IS '备注信息';

-- ----------------------------
-- Records of EMAIL_SEND_LOG
-- ----------------------------
INSERT INTO "EMAIL_SEND_LOG" VALUES ('644f5223cea24848b22c57e649b2c42b', '502079461@qq.com', '士大夫士大夫', '<p>士大夫士大夫士大夫士大夫士大夫士大夫士大夫士大夫<br></p>', null, TO_DATE('2017-09-08 11:14:16', 'YYYY-MM-DD HH24:MI:SS'), null, '0', '1', '发送成功', null);

-- ----------------------------
-- Table structure for EMAIL_TEMPLATE
-- ----------------------------
DROP TABLE "EMAIL_TEMPLATE";
CREATE TABLE "EMAIL_TEMPLATE" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"NAME" VARCHAR2(255 CHAR) NOT NULL ,
"CODE" VARCHAR2(255 CHAR) NOT NULL ,
"BUSINESS_TYPE" VARCHAR2(4 CHAR) NOT NULL ,
"TEMPLATE_SUBJECT" VARCHAR2(255 CHAR) NOT NULL ,
"TEMPLATE_CONTENT" CLOB NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"DEL_FLAG" VARCHAR2(1 CHAR) DEFAULT '0'  NOT NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "EMAIL_TEMPLATE" IS '邮件发送模板';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."NAME" IS '模版名称';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."CODE" IS '模版编码';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."BUSINESS_TYPE" IS '业务类型';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."TEMPLATE_SUBJECT" IS '模版主题';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."TEMPLATE_CONTENT" IS '模版内容';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "EMAIL_TEMPLATE"."UPDATE_DATE" IS '更新时间';

-- ----------------------------
-- Records of EMAIL_TEMPLATE
-- ----------------------------
INSERT INTO "EMAIL_TEMPLATE" VALUES ('40281e815cef4f99015cef71f1850007', 'testcode', 'testcode', '1', '验证码', '&lt;p&gt;验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码验证码&lt;br&gt;&lt;/p&gt;', null, '4028ea815a3d2a8c015a3d2f8d2a0002', null, '0', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:05:11', 'YYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Table structure for OA_NOTIFICATION
-- ----------------------------
DROP TABLE "OA_NOTIFICATION";
CREATE TABLE "OA_NOTIFICATION" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"TITLE" VARCHAR2(255 CHAR) NOT NULL ,
"CONTENT" CLOB NULL ,
"STATUS" VARCHAR2(4 CHAR) NOT NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" VARCHAR2(1 CHAR) DEFAULT '0'  NOT NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "OA_NOTIFICATION"."TITLE" IS '标题';
COMMENT ON COLUMN "OA_NOTIFICATION"."CONTENT" IS '内容';
COMMENT ON COLUMN "OA_NOTIFICATION"."STATUS" IS '发布状态';
COMMENT ON COLUMN "OA_NOTIFICATION"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "OA_NOTIFICATION"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "OA_NOTIFICATION"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "OA_NOTIFICATION"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "OA_NOTIFICATION"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "OA_NOTIFICATION"."REMARKS" IS '备注信息';

-- ----------------------------
-- Records of OA_NOTIFICATION
-- ----------------------------
INSERT INTO "OA_NOTIFICATION" VALUES ('40281e815c912406015c914e3e27006b', '测试通知1', '测试通知1', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:40', 'YYYY-MM-DD HH24:MI:SS'), '0', null);
INSERT INTO "OA_NOTIFICATION" VALUES ('40281e815c914f07015c91548e690000', '测试通知2', '测试通知2', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:53', 'YYYY-MM-DD HH24:MI:SS'), '0', null);
INSERT INTO "OA_NOTIFICATION" VALUES ('40281e815c914f07015c9154aa010001', '测试通知3', '测试通知3', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:57', 'YYYY-MM-DD HH24:MI:SS'), '0', null);
INSERT INTO "OA_NOTIFICATION" VALUES ('40281e815c914f07015c9154c1b30002', '测试通知4', '测试通知4', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:03', 'YYYY-MM-DD HH24:MI:SS'), '0', null);
INSERT INTO "OA_NOTIFICATION" VALUES ('40288ab85cf356ef015cf35c67ae0004', '1111', '111111', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-29 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:09', 'YYYY-MM-DD HH24:MI:SS'), '0', null);

-- ----------------------------
-- Table structure for SMS_SEND_LOG
-- ----------------------------
DROP TABLE "SMS_SEND_LOG";
CREATE TABLE "SMS_SEND_LOG" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"REMARKS" VARCHAR2(255 BYTE) NULL ,
"BUSINESS_TYPE" VARCHAR2(4 BYTE) NOT NULL ,
"PHONE" VARCHAR2(4000 BYTE) NULL ,
"TEMPLATE_ID" VARCHAR2(8 BYTE) NULL ,
"TEMPLATE_CONTENT" VARCHAR2(255 BYTE) NULL ,
"SENDDATA" VARCHAR2(255 BYTE) NULL ,
"STATUS" NVARCHAR2(4) NOT NULL ,
"SMSID" VARCHAR2(50 BYTE) NULL ,
"CODE" VARCHAR2(40 BYTE) NULL ,
"MSG" VARCHAR2(40 BYTE) NULL ,
"DEL_FLAG" CHAR(1 BYTE) DEFAULT '0'  NOT NULL ,
"RESPONSE_DATE" DATE NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SMS_SEND_LOG" IS '短信发送模板';
COMMENT ON COLUMN "SMS_SEND_LOG"."ID" IS '主键';
COMMENT ON COLUMN "SMS_SEND_LOG"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "SMS_SEND_LOG"."BUSINESS_TYPE" IS '业务类型';
COMMENT ON COLUMN "SMS_SEND_LOG"."PHONE" IS '联系电话';
COMMENT ON COLUMN "SMS_SEND_LOG"."TEMPLATE_ID" IS '模板ID';
COMMENT ON COLUMN "SMS_SEND_LOG"."TEMPLATE_CONTENT" IS '模板类型';
COMMENT ON COLUMN "SMS_SEND_LOG"."SENDDATA" IS '发送数据';
COMMENT ON COLUMN "SMS_SEND_LOG"."STATUS" IS '发送状态';
COMMENT ON COLUMN "SMS_SEND_LOG"."SMSID" IS '发送响应消息ID';
COMMENT ON COLUMN "SMS_SEND_LOG"."CODE" IS '返回码';
COMMENT ON COLUMN "SMS_SEND_LOG"."MSG" IS '返回消息';
COMMENT ON COLUMN "SMS_SEND_LOG"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "SMS_SEND_LOG"."RESPONSE_DATE" IS '响应时间';

-- ----------------------------
-- Records of SMS_SEND_LOG
-- ----------------------------
INSERT INTO "SMS_SEND_LOG" VALUES ('15683c924e1a45aea8c03da7ebd18a99', null, '99', '15085980308', null, '您的验证码是：12541。请不要把验证码泄露给其他人。', null, '1', '15048412016792095216', '2', '提交成功', '0', TO_DATE('2017-09-08 11:26:46', 'YYYY-MM-DD HH24:MI:SS'));

-- ----------------------------
-- Table structure for SMS_TEMPLATE
-- ----------------------------
DROP TABLE "SMS_TEMPLATE";
CREATE TABLE "SMS_TEMPLATE" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"NAME" VARCHAR2(255 CHAR) NOT NULL ,
"CODE" VARCHAR2(255 CHAR) NOT NULL ,
"BUSINESS_TYPE" VARCHAR2(4 CHAR) NOT NULL ,
"TEMPLATE_ID" VARCHAR2(20 CHAR) NOT NULL ,
"TEMPLATE_CONTENT" VARCHAR2(255 CHAR) NOT NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" VARCHAR2(1 CHAR) DEFAULT '0'  NOT NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SMS_TEMPLATE" IS '短信发送模板';
COMMENT ON COLUMN "SMS_TEMPLATE"."NAME" IS '模版名称';
COMMENT ON COLUMN "SMS_TEMPLATE"."CODE" IS '模版编码';
COMMENT ON COLUMN "SMS_TEMPLATE"."BUSINESS_TYPE" IS '业务类型';
COMMENT ON COLUMN "SMS_TEMPLATE"."TEMPLATE_ID" IS '模版ID';
COMMENT ON COLUMN "SMS_TEMPLATE"."TEMPLATE_CONTENT" IS '模版内容';
COMMENT ON COLUMN "SMS_TEMPLATE"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "SMS_TEMPLATE"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "SMS_TEMPLATE"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "SMS_TEMPLATE"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "SMS_TEMPLATE"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "SMS_TEMPLATE"."REMARKS" IS '备注信息';

-- ----------------------------
-- Records of SMS_TEMPLATE
-- ----------------------------
INSERT INTO "SMS_TEMPLATE" VALUES ('40288ab85c85a282015c85a83a550003', '验证码', 'vercode', '1', 'vercode', '您的验证码是：{1}。请不要把验证码泄露给其他人。', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:05:22', 'YYYY-MM-DD HH24:MI:SS'), '0', null);

-- ----------------------------
-- Table structure for SYS_ATTACHMENT
-- ----------------------------
DROP TABLE "SYS_ATTACHMENT";
CREATE TABLE "SYS_ATTACHMENT" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"FILENAME" VARCHAR2(50 CHAR) NOT NULL ,
"USERID" VARCHAR2(32 CHAR) NOT NULL ,
"UPLOADTIME" DATE NOT NULL ,
"UPLOADIP" VARCHAR2(15 CHAR) NOT NULL ,
"FILEEXT" VARCHAR2(10 CHAR) NOT NULL ,
"FILEPATH" VARCHAR2(200 CHAR) NOT NULL ,
"FILESIZE" NUMBER(10) DEFAULT '0'  NOT NULL ,
"STATUS" VARCHAR2(1 CHAR) DEFAULT '0'  NOT NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"DEL_FLAG" CHAR(1 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_ATTACHMENT" IS '附件表';
COMMENT ON COLUMN "SYS_ATTACHMENT"."FILENAME" IS '文件名称';
COMMENT ON COLUMN "SYS_ATTACHMENT"."USERID" IS '用户ID';
COMMENT ON COLUMN "SYS_ATTACHMENT"."UPLOADTIME" IS '上传时间';
COMMENT ON COLUMN "SYS_ATTACHMENT"."UPLOADIP" IS '上传的ID';
COMMENT ON COLUMN "SYS_ATTACHMENT"."FILEEXT" IS '文件扩展名';
COMMENT ON COLUMN "SYS_ATTACHMENT"."FILEPATH" IS '文件路径';
COMMENT ON COLUMN "SYS_ATTACHMENT"."FILESIZE" IS '文件大小';
COMMENT ON COLUMN "SYS_ATTACHMENT"."STATUS" IS '状态';

-- ----------------------------
-- Records of SYS_ATTACHMENT
-- ----------------------------
INSERT INTO "SYS_ATTACHMENT" VALUES ('40281e815cf8f87a015cf9168a2a0000', 'logoquan14949235142', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-30 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'PNG', 'upload/2017/06/30/1498827622949.PNG', '22181', '1', null, null, null, null, null, null);
INSERT INTO "SYS_ATTACHMENT" VALUES ('40281e815cfc4624015cfcf2a247006f', 'QQ截图20170605100721', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-01 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'png', 'upload/2017/07/01/1498892378689.png', '40871', '1', null, null, null, null, null, null);
INSERT INTO "SYS_ATTACHMENT" VALUES ('40281e815d01531e015d02ad3bdb0001', 'QQ截图20170630205308', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-02 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'png', 'upload/2017/07/02/1498988493770.png', '35704', '1', null, null, null, null, null, null);
INSERT INTO "SYS_ATTACHMENT" VALUES ('40288ab85d15e64a015d15f279eb0000', '1499311108012', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-06 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'jpg', 'upload/2017/07/06/1499311798749.jpg', '5042', '1', null, null, null, null, null, null);
INSERT INTO "SYS_ATTACHMENT" VALUES ('9149c07c2dab409180aa54498db77930', 'QQ截图20170908164230', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:42:48', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'png', 'upload/2017/09/08/1504860168913.png', '24757', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:42:48', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, '0');
INSERT INTO "SYS_ATTACHMENT" VALUES ('1a57d07a3c41412791a439ada97ed250', 'QQ截图20170910135746', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'png', 'upload/2017/09/10/1505023070932.png', '30603', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:50', 'YYYY-MM-DD HH24:MI:SS'), null, null, null, '0');

-- ----------------------------
-- Table structure for SYS_DATA_SOURCE
-- ----------------------------
DROP TABLE "SYS_DATA_SOURCE";
CREATE TABLE "SYS_DATA_SOURCE" (
"ID" VARCHAR2(36 CHAR) NOT NULL ,
"DB_KEY" VARCHAR2(50 CHAR) NOT NULL ,
"DESCRIPTION" VARCHAR2(50 CHAR) NOT NULL ,
"DRIVER_CLASS" VARCHAR2(50 CHAR) NOT NULL ,
"URL" VARCHAR2(200 CHAR) NOT NULL ,
"DB_USER" VARCHAR2(50 CHAR) NOT NULL ,
"DB_PASSWORD" VARCHAR2(50 CHAR) NULL ,
"DB_TYPE" VARCHAR2(50 CHAR) NULL ,
"DB_NAME" VARCHAR2(50 CHAR) NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"DEL_FLAG" CHAR(1 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_DATA_SOURCE" IS '数据源';
COMMENT ON COLUMN "SYS_DATA_SOURCE"."DB_KEY" IS '索引关键字';
COMMENT ON COLUMN "SYS_DATA_SOURCE"."DESCRIPTION" IS '描述';
COMMENT ON COLUMN "SYS_DATA_SOURCE"."DRIVER_CLASS" IS '驱动';
COMMENT ON COLUMN "SYS_DATA_SOURCE"."URL" IS 'URL';
COMMENT ON COLUMN "SYS_DATA_SOURCE"."DB_USER" IS '帐号';
COMMENT ON COLUMN "SYS_DATA_SOURCE"."DB_PASSWORD" IS '密码';
COMMENT ON COLUMN "SYS_DATA_SOURCE"."DB_TYPE" IS '数据库类型';
COMMENT ON COLUMN "SYS_DATA_SOURCE"."DB_NAME" IS '数据库名称';

-- ----------------------------
-- Records of SYS_DATA_SOURCE
-- ----------------------------
INSERT INTO "SYS_DATA_SOURCE" VALUES ('402880e74e064fc5014e0652f72b0001', 'neiwangbaogong', '微信运营数据库', 'com.mysql.jdbc.Driver', 'jdbc:mysql://localhost:3306/attendance?useUnicode=true&amp;amp;amp;amp;amp;characterEncoding=UTF-8', 'root', 'gliwang123456', 'mysql', 'attendance', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:19', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "SYS_DATA_SOURCE" VALUES ('8a8aada9486347c001486401180a0003', 'PMS', 'sap db', 'oracle.jdbc.driver.OracleDriver', 'jdbc:oracle:thin:@localhost:1521:oral', 'PMS', 'tz', 'oracle', 'PMS', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');

-- ----------------------------
-- Table structure for SYS_DICT
-- ----------------------------
DROP TABLE "SYS_DICT";
CREATE TABLE "SYS_DICT" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"GID" VARCHAR2(32 CHAR) NULL ,
"LABEL" VARCHAR2(100 CHAR) NULL ,
"VALUE" VARCHAR2(100 CHAR) NULL ,
"SORT" NUMBER(10) NULL ,
"REMARKS" VARCHAR2(100 CHAR) NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" CHAR(1 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_DICT" IS '字典分组';
COMMENT ON COLUMN "SYS_DICT"."ID" IS '主键';
COMMENT ON COLUMN "SYS_DICT"."GID" IS '分组ID';
COMMENT ON COLUMN "SYS_DICT"."LABEL" IS '键值键';
COMMENT ON COLUMN "SYS_DICT"."VALUE" IS '值';
COMMENT ON COLUMN "SYS_DICT"."SORT" IS '排序';
COMMENT ON COLUMN "SYS_DICT"."REMARKS" IS '描述';

-- ----------------------------
-- Records of SYS_DICT
-- ----------------------------
INSERT INTO "SYS_DICT" VALUES ('40281e815ced1f27015ced2f83bc000b', '40281e815ced1f27015ced2be5330003', '男', '1', '1', '1', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:25', 'YYYY-MM-DD HH24:MI:SS'), '0');
INSERT INTO "SYS_DICT" VALUES ('40281e815cef4f99015cef6f7d070005', '40281e815ced1f27015ced2be5330003', '女', '2', '1', '女', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:28', 'YYYY-MM-DD HH24:MI:SS'), '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85a20b609015a20c422e90003', '40288ab85a20b609015a20c3f7bf0002', '是', '1', '1', '1', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85a5eecc6015a5eede8720000', '40288ab85a20b609015a20c3f7bf0002', '否', '0', '2', '否', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85b6080e1015b608762aa0001', '40288ab85b6080e1015b60870d410000', '单表', '1', '1', '单表', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85b6080e1015b608797ea0002', '40288ab85b6080e1015b60870d410000', '主表', '2', '2', '主表', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85b6080e1015b6087d0140003', '40288ab85b6080e1015b60870d410000', '附表', '3', '3', '附表', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85b6080e1015b60881c6e0004', '40288ab85b6080e1015b60870d410000', '树结构', '4', '4', '树结构', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85befd65a015bf0a6aa69002a', '40288ab85befd65a015bf0a043630026', 'Oracle', 'oracle', '1', 'Oracle', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85befd65a015bf0a6e30e002b', '40288ab85befd65a015bf0a043630026', 'MySql', 'mysql', '2', 'MySql', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85befd65a015bf0a77d9b002c', '40288ab85befd65a015bf0a043630026', 'sql server', 'sqlserver', '3', 'sql server', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85bf1549e015bf175152a0001', '40288ab85bf1549e015bf17370ff0000', '在线', 'on_line', '1', '在线', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85bf1549e015bf17559ac0002', '40288ab85bf1549e015bf17370ff0000', '隐身', 'hidden', '2', '隐身', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85bf1549e015bf17590820003', '40288ab85bf1549e015bf17370ff0000', '强制退出', 'force_logout', '3', '强制退出', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85c8593cd015c859b70010011', '40288ab85c8593cd015c859b1fcf0010', '验证码', '1', '1', '验证码', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85c8593cd015c859b8ff50012', '40288ab85c8593cd015c859b1fcf0010', '通知', '2', '2', '通知', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('40288ab85c86382b015c863993a30002', '40288ab85c8593cd015c859b1fcf0010', '其他', '99', '99', '其他', null, null, null, null, '0');
INSERT INTO "SYS_DICT" VALUES ('05e2180785584126900df240708c435f', '5b2b965a7e314646a5e227776534417c', '1', '1', '1', '1', null, null, null, null, '0');

-- ----------------------------
-- Table structure for SYS_DICT_GROUP
-- ----------------------------
DROP TABLE "SYS_DICT_GROUP";
CREATE TABLE "SYS_DICT_GROUP" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"NAME" VARCHAR2(100 CHAR) NULL ,
"CODE" VARCHAR2(100 CHAR) NULL ,
"REMARKS" VARCHAR2(100 CHAR) NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" CHAR(1 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON COLUMN "SYS_DICT_GROUP"."ID" IS '主键';
COMMENT ON COLUMN "SYS_DICT_GROUP"."NAME" IS '分组名称';
COMMENT ON COLUMN "SYS_DICT_GROUP"."CODE" IS '分组编码';
COMMENT ON COLUMN "SYS_DICT_GROUP"."REMARKS" IS '备注';

-- ----------------------------
-- Records of SYS_DICT_GROUP
-- ----------------------------
INSERT INTO "SYS_DICT_GROUP" VALUES ('5b2b965a7e314646a5e227776534417c', 'sdfsd', 'fsdf', 'sdfdsfdfsdf', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, null, '0');
INSERT INTO "SYS_DICT_GROUP" VALUES ('40281e815ced1f27015ced2be5330003', '性别', 'sex', '性别', null, null, null, null, '0');
INSERT INTO "SYS_DICT_GROUP" VALUES ('40288ab85a20b609015a20c3f7bf0002', '是否', 'sf', '是否', null, null, null, null, '0');
INSERT INTO "SYS_DICT_GROUP" VALUES ('40288ab85b6080e1015b60870d410000', '表类型', 'tabletype', '表类型', null, null, null, null, '0');
INSERT INTO "SYS_DICT_GROUP" VALUES ('40288ab85befd65a015bf0a043630026', '数据库类型', 'dbtype', '数据库类型', null, null, null, null, '0');
INSERT INTO "SYS_DICT_GROUP" VALUES ('40288ab85bf1549e015bf17370ff0000', '用户登陆状态', 'onlinestatus', ' ', null, null, null, null, '0');
INSERT INTO "SYS_DICT_GROUP" VALUES ('40288ab85c8593cd015c859b1fcf0010', '短信业务类型', 'businesstype', '短信业务类型', null, null, null, null, '0');

-- ----------------------------
-- Table structure for SYS_LOG
-- ----------------------------
DROP TABLE "SYS_LOG";
CREATE TABLE "SYS_LOG" (
"ID" VARCHAR2(64 CHAR) NOT NULL ,
"TYPE" CHAR(1 CHAR) DEFAULT '1'  NULL ,
"TITLE" VARCHAR2(255 CHAR) NULL ,
"CONTENT" VARCHAR2(1000 CHAR) NULL ,
"LOGTYPE" VARCHAR2(4 CHAR) NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"REMOTE_ADDR" VARCHAR2(255 CHAR) NULL ,
"USER_AGENT" VARCHAR2(255 CHAR) NULL ,
"REQUEST_URI" VARCHAR2(255 CHAR) NULL ,
"METHOD" VARCHAR2(5 CHAR) NULL ,
"PARAMS" CLOB NULL ,
"EXCEPTION" CLOB NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_LOG" IS '日志表';
COMMENT ON COLUMN "SYS_LOG"."ID" IS '编号';
COMMENT ON COLUMN "SYS_LOG"."TYPE" IS '日志类型';
COMMENT ON COLUMN "SYS_LOG"."TITLE" IS '日志标题';
COMMENT ON COLUMN "SYS_LOG"."CONTENT" IS '日志内容';
COMMENT ON COLUMN "SYS_LOG"."LOGTYPE" IS '操作方式';
COMMENT ON COLUMN "SYS_LOG"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "SYS_LOG"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "SYS_LOG"."REMOTE_ADDR" IS '操作IP地址';
COMMENT ON COLUMN "SYS_LOG"."USER_AGENT" IS '用户代理';
COMMENT ON COLUMN "SYS_LOG"."REQUEST_URI" IS '请求URI';
COMMENT ON COLUMN "SYS_LOG"."METHOD" IS '操作方式';
COMMENT ON COLUMN "SYS_LOG"."PARAMS" IS '操作提交的数据';
COMMENT ON COLUMN "SYS_LOG"."EXCEPTION" IS '异常信息';

-- ----------------------------
-- Records of SYS_LOG
-- ----------------------------
INSERT INTO "SYS_LOG" VALUES ('e5094e9313ce4f35b7914afcc3ddc8d7', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e678c80666ef4659b5ebec182a276972', '1', '常见工具-多数据源管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e7644552a86349c8bb6b88029c77dbc8', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e85a9b47f1624b4da99aaaf26a1de4bb', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e93303690a3c48379adf2f9455cfc716', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('eb0a4bda56b944e8babce41be2e16495', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ebb775b6b2234d888999f35f321a1cca', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ebf67360ae7d496da0d2b89c4c8ab054', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ef429bb8f7754b308734f31bb36d1381', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ef509e574e8343aa86d7373391fe4425', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f099faf69aae4f2f8a2b441e3936fef9', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/test/testordermain/create', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f13a04c8fdb748199813f67bbcb78836', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f4ec526fdea14608a3f3c3cf4e7914ed', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f5923191d63c4dafa8224284d2a8d1cc', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f7367b9053894c1a89e1fbac4a8d9846', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f905620baafd43da865b205003d97adc', '1', '系统监控-附件信息', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fbe73233a7c74c9dbf13e42f6fcac589', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fc0a6e7c40a14b1ca75a76996c1249c3', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fc5db2e3b5664f809d5b39fa4d6683e2', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fda240dada8342929dbf46ccedb377ec', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fe3a6a8356414cc4ba770977aea54071', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0060eb31cd314f7784053583eb4ecdf0', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:05:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a966ae07823d4ec3903e4ec59e19b495', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:05:17', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d066751c3f654b609f4612529e9dced4', '1', '短信设置-短信模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:05:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smstemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9fea6ea5080d4d37a8ed843d0349809b', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:05:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('39336812943b419db7aa2b289b072677', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:06:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('00d169ef1c60444697905eaf421ef0e5', '1', '通知公告-通知公告', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5e8b6364c7274084bfd9c8328c6c7e67', '1', '通知公告-通知公告', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5edd6af65b5047fb8cc5c7a7750fee3e', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5f69f7b0c38c4ce98f94fcc78efe630e', '1', '邮箱设置-邮件发送', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('60c8d7f598d440e8b18d0954a39aafe0', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('630709f0159146ff924b2cb254a15051', '1', '系统监控-附件信息', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('639d313bfa6c4c8690806e14a3464dc2', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('649c7ed8cb0b400c956327a48ca0fcf9', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('657323b8d6c344eea7c9822a4763abd4', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('658a9e09efda4a27a6d46c4355720a85', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('688ee21613be4bb2b5a8d7965f785b77', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('689008c0249f4f459940ab15174dbbcc', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6924b2b4bb7f4aab83d033e22ada9b45', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('698e24d5ecd2429ab955a3647972c482', '1', '邮箱设置-发送日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6a8fe226eda24ef6b69e62f372dbe1b5', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6c9c3d7937334cea9a85e8185f16c5d4', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('739d4e3ee0e1410c9e037fbef8627aa5', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('76478ca9d33d4188b16eebf34f226d59', '1', '常见工具-计划任务', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7790424a64cc4c0991a4e78c8d9056aa', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('77d32e66672041ce87ee73e1e8b01b25', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; Trident/7.0; rv:11.0) like Gecko', '/jeeweb-mybatis/admin/', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('193fc351789445279ee9d7c830b2b2dc', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1b66b14d685541a8aeb4b93e8a619080', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/test/testordermain/2fe7d6b5f28e4b8dbe2797ab0186a491/update', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1d4405e39b4941a694caf24bdeb20b5e', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1dae9ade7245492c90532810e95c2f0d', '1', '系统设置-菜单管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('23a6373395af4cda9a7aa99f2ccf7a91', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('23a881fa17f74f91818a50cc7d2835e7', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('24def69158af4635a414c5a56ab14f5e', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('24e2241fa1c94816b94a841dfa2f6189', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('24e790e5b4f84319a1d33c214e596106', '1', '系统监控-附件信息', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('25e36b81e5c2472e929d504789537b1c', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('274f5093d0dd4fc7b9df49a24a0131a4', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('282433b8be054afeb0aac02c6d272986', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('288629d6c8e64f38bc5834b67611fdc8', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; Trident/7.0; rv:11.0) like Gecko', '/jeeweb-mybatis/admin/', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2b8d75793a514812832375bab094737d', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('30899acd292c43b4ba075c100cffb81b', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('30c1faed4562489e91d9c5f584808135', '1', '系统设置-菜单管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('30d3af97052342238c03c6b4d416c902', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('31e2db9accec4dcfb9108ceafa38d836', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d72718a4dfdd4d42acbf28db6602906b', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d808a170aa9441dba81b1600404ffddb', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('da5665b13e41483fb6ebe3122683819c', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dd54390582794507b2ec055535fac5df', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dd893452eff14b5a9940132881366364', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dd9870156b974d078b5452047118b63f', '1', '系统监控-附件信息', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('de3d76afc490442ab011554d3fddb96b', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('de6484bf73cd448c9a901d8a2d86dd3e', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('de80cb6743cf4ddd9d73f3bc4ea2376d', '1', '系统设置-角色管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('df618e890f1146c39805cabcd4855294', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e199910526c74de0974fdb7f45c5c6a6', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e1d54428371042e992aed026a0855d79', '1', '系统设置-角色管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e31e55fd9caf472486e124327efa3e95', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e3a9f51f96d64628b1245aa5b7327210', '1', '系统设置-部门管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('035fdc3766cb42fe991e2acea2fc5f4f', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('03d837c886bc4f849d80dc1b261af9d9', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('04f3f44f2d0f46c198ff195951d02da9', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('06463d900b734c31a4c3196fa2037379', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('08f78729315a47999e9ecf3d04afcfc8', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0c4ed792b0634fd2a2fe6849bb0cae9f', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0cc2fad094294c3ea3b0309ec5f7c225', '1', '系统设置-菜单管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0ed45ae9863f47b0a2a416903a49ad6c', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0f8466a2dd924d08b9f83398bd696bde', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0fd7a0a1b22242e3b30c827dab6e35f6', '1', '系统监控-数据库监控', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('100498f90a834064ad2bed446762598a', '1', '系统设置-部门管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('11ab5da2dd474772a907b7b85855dcce', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('13cb962b0f1b4a7eace8eb316b60fb5d', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('15abdeca1f104a189dc79d45afd144f7', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('15fb397dff1241a1b1a55c89dfd6dcb6', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('17acf39d1a984011b832f265771b181b', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('183b737458b244599db56978edcabb8d', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('183d1ce6dadf493e8c6a5a639267b5fe', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('189c03232d1c45f89cb2147eb2677028', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('321e7dec82fb47e290e1855bf87c8351', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('330171cd233446988d2bca3f456a36cc', '1', '常见工具-计划任务', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('342409f6f06c45c4ac289848c421faec', '1', '邮箱设置-邮件模版', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('356f5290d9004bacbd90a62fd3a013ce', '1', '系统设置-菜单管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('371c5c8e70494fc080c7b6cd61003c6c', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/test/testordermain/create', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('371daf77e2ec461783e1aca81bcf5c6d', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('38c44555f8e84658836fb58bb92d39b4', '1', '代码案例-文件上传', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/demo/form/upload', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('398d78d66b084a75a72abe5df66bfedb', '1', '系统设置-数据字典', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3e0d0806d8924e8a89f6fcba718e934a', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3e200c64d97b4050a9a07d05ede9ebb7', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3e9ea0a8c9a84d7290318cc7a7bf1595', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4240e2b17e28447e9fb6c6425f44bfb1', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('45319a66e326490286407d4df3038cca', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4682ad7c5d1140338225b39532cd381d', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('47226f5ab18e4c7eac97a44b3901cec0', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('47d5d37de4fc471b9dd998c7b45b3ded', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('499a6275be9b47508ddaef880ca803ba', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/test/testordermain/2fe7d6b5f28e4b8dbe2797ab0186a491/update', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4b62efcf64e44524a3d770052d0a8230', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4b9cdc1038034560a4b620a323f8ee9b', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4bf3a063c9f14652a3b1abcf8e528a04', '1', '系统设置-角色管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4c9c9e4b78394fa6a9f794b5eb73da53', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4d9c143532df4eaebb0ab792deb0e402', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4ec8be3f80254f7292114a36ed4f3be4', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4f019e70349a4d5bafc0ab1dfdd425e4', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('53141de7ecfe47899cd5edf87b297d82', '1', '常见工具-计划任务', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('56af68fb969d410db6cf7b9c0925d42d', '1', '系统设置-部门管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('56de9624ac734a95be978227cf74945c', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('59ad29c02b9a4070ac4801a06354aab6', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5a3857c7e90c4a82a79795d207b7689a', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5ac71900da3447e188bf904e0f4b5ba4', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5ba5d1db617f4a6e8a5ad5ac6fa487ba', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5d15a898579843b6b43f0bc76b5d4999', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e095488f964f4575bcbb2e261122d72b', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:13:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ef4af14fc4eb4c8fa9ddeca1cbbd9999', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('99dad881820d4378836600bb62015825', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ca173c4efd164e78b62f0ff278278964', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2d95d2dddb514a808db91ddb52dca11e', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4830794ba9a74f7aa557bb169cad8459', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('63f0e2ab392342caa69b319cac17b063', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:15', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6a1c4e03ee54415e8be3f23556db3696', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0fb6bbfbe79d454b9607a71d9dc03802', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('244e54d86d264874a3b1dd911e987cf4', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('75df6b245b6947999bcc64b6f5152143', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('73c924435fb2418da5872a77e40cbe59', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a19ead04874d4ccabd20a623ad544628', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b33a7aad2aff4221bb365313d60c230f', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bf25da2a0fda469db17ed363faba1a0b', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:46:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('32e13b4a73404598891dce2ae9b0c0fe', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:47:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('174fce3915e84f5ca05e7d3cdd42045b', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:47:59', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('eb238c827e2c4a4d9944f5b2daa6d69d', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:50:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ea400f0efffe40f68a704f2c1254ef40', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:50:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('94ec85679b8a4f9f87dc70cf0f43be80', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:50:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('00e4580af3a548359348167a3533786d', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:51:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7befe3923ac4427bbbc5ad15243e673f', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4a0a10d0236043059939686289ebb8ba', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8b0c9a7a266a4b7585be13fc606bcfa1', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b5f43ffb265841bea6cec80236a39036', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('74152efe9d9349c59700fbe80b0bfebe', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1d5e5ec29f6f4f1b85139979f572a6c7', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('973688f4f72746919875516b449f2456', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f3ce5c3fa867479f8c8d567d8401ebee', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2a3e816216e149a3a3c869e27d758ab0', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ad90d56ac81844d1b20d06f6baf1da86', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bd29fce3d0a241d58ff32d5b138a5849', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4efa8e96adaf4c7bac75c96edebfe6d0', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('996301280458452b8f611b2c2d2f2228', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0c813f45d6cd4817a992d785dde9ede5', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dee77785c5bd40f7b035d8684db66549', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a18f892fdedb4d62ac3b1b09c5a032e3', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('076c15035b084caebc147b1703a0d485', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d036e862918b4fd08ae270ccefcebb6b', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('de1219293a2742cbb2b317f97f72befe', '2', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('243a7b31af2d47bda7886d9808ef4980', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1db0f011e46f4bd8b9a847b4ca13af13', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('72ffa563e148481db934fbb21d9e3c0a', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('87241a885f4348f68a04f0a79223e57d', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a042a233239a488d9f52449a115927d3', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('112d50d4c23b4e638411cc8a71894648', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bd41299d6fb44bd6bc4401596dcbf659', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2e5720f2cb814e719c4c82290d777260', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('82e2f6af88864666a60c5f83f79024e0', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('57641978f2e04cf0be9fae3fcbf21354', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8aad8afa560744b0b8f24a7b13de40a1', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b5a64dd674f54410bf68483fb3587858', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8302727444514c8c9d0b0f06128f9ffc', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4ee5fbcf8c3d48ee9b1944b54bb681bb', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d68b6665870d418a959df586a21198c7', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table/40281e815c8f3512015c8f3a07440000/update', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f76c83e8054f4cb886412db38d7ea350', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table/40281e815c8f3512015c8f3a07440000/update', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1690c04b76754a12a6c6b3896e88229e', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('207c5a3a2aaa42058a9ba745f1bd0a01', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('80e5296f87634e73a46e546f28311bbb', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7ebfcd6c47204e82bcccdbceccfa0d14', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b52c4562f8fb40259ca65934e0105970', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2153d3f78d6040f2a3f4fa06aec7bb5a', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('783df43e8661489b905a47ff50c52903', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7841b0ff189545428d94be460b936d9a', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7873fb401f1b49d5ba16c31ebc04bc9d', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-24 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('78e304ca854646748dfc62354e3a9015', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8478b7a0ad784b52af35efe5ed5ffbdb', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:29:14', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('91ee94be218848bfa8a48bd3bb16d967', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:29:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('433d2c743fdf4abeb83faac80a8c08ff', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:29:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7060eec81d214a138babb076d38f3607', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:32:11', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b8de564285d8425fb0ea2f1dd563d801', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:32:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d5196ba19e5f4d229f0aaa912043a731', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:32:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e84496f82ddd4bfebd188d0504a45c90', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:32:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0d0999b17bf14c158603cad6127bc20e', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:32:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ab873962d82a43f2a06eacd82f64e072', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:32:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b138a71a4b0f4188a31cd9ccfeac317d', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:32:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f5f1d46e07564bb48a752b5978e9dcbf', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:32:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e5cc8c31749e4a3ba45afde9147b6bd7', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:32:51', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4bfc8d4f777340709f14ceedb3cacbb9', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:33:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('13697a87c76c45cca6cfa62178434e8a', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1adb2d9b6b1e485886027cca5539ebfd', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('23a02c7f95194b04abee8b2bd3d78935', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('16beb16c0ef742ea891c66544d9ffdc7', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5db157c1680b4124a01f471bc9c02d01', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cea51822bfc5414f84d91d51d1aff936', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e76fe815058a441a874919a548b9b27c', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('83800c9a105c4ae8888292093c2a4575', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b632a5f019dd4624929066c916cfe89c', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('750d7dc36b6f4ef3aa35feef278ede14', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('910d8197be7143fca141b181e05543bf', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f150593caed64bf79883d5dd39e16460', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:52:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9470acbe434a40db820674ab41d83ecd', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9706c7ea0683497b93d2dcf478046d5d', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('97e70116b7dc4cb492525560cde896a8', '1', '系统设置-部门管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('98929c54c7b44d93a68273e7f80facf7', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9948a850b268455eb05f1ba9aa9129f4', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9967713db7ea48b68f1efe10d16cae80', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('997c6d92b9da4b1089a75a6850741fd2', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('99dd897e8705460e8de5deda4234fa1b', '1', '系统设置-部门管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9a2d1a70ae7346fd9b22dbde0553469b', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9a6c9b92fab8497a8b6365f97053ea90', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9b29ace0e26a45ce81a4b1c0a2ec1f3f', '1', '常见工具-多数据源管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9bbb0350ff4f445db050c46857f3732f', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9ce56055656443bf9f2226f6501af671', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a0527616b7714bce855d0715584e426e', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a14faa53d66e4416a454153de39a9334', '1', '系统设置-角色管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a311186d57af42a3b75762eae4611759', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a5078e0cced845ea84826f99a69e7c17', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a541e1ed1b7c40cc8086be0506be8819', '1', '系统监控-用户最后在线情况', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a5b2a01834d0492791edd06854130d21', '1', '系统监控-数据库监控', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a6edb2726a0f4367b27b5bb49c10e0b6', '1', '代码生成器-生成案列-一对多', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a8999e68d75647be9e4ad170ad92d083', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('aa61eacfdd9e4a8ba0dba178bc04ce05', '1', '常见工具-计划任务', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ad96071642774ce7a566aae3121fc7b6', '1', '系统设置-部门管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('af95a81aa4a845fb96ec69b86c65f14e', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b2ad516cef154f8fab29039b33bcef6a', '1', '系统监控-数据库监控', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b43de53ec817428ca1c27f579ce0c487', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b457d151883a4e3c9373764b8efbb11a', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b5096519c86d4f3ebceca409b7f50cb2', '1', '系统设置-数据字典', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b582d3903185465f9b14adc5df802c64', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b5fb8b60c52e4a04b518351ff293979b', '1', '系统设置-部门管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b7090b7c3ed847d7a2dc0133d9a61c95', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b95070f7cb4c448587c119b0c4abb8e5', '1', '系统设置-数据字典', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b9aafb35e2d34bdf819adb2d50fc592e', '1', '邮箱设置-参数设置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ba514a87f654440eb700ef7a621bce8c', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bb1f3a13008a40bba2f6e7341b482c66', '1', '短信设置-短信模版', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sms/smstemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bc71d57307f94284b3724933394784bc', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bcf5db328fe1402193db557d5881a2cb', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bd2cd3e78e2640dcbd19f573578d0f21', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c23785da13f14745a9d8ad45df346d75', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c2458a52d94b453c84b09fa0128f38f0', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c530868218db42898a9fdc58965d9b20', '1', '代码案例-编辑器', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/demo/form/editor', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c62ba61dcad84f329f626879d0aa9c5b', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c785278de317485fa0d598fbc867a733', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c8965f39e3be4fe2b708c7e670295774', '1', '系统监控-数据库监控', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c8af6e09f8eb4885a89121a4cac5e154', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c8b42f0b653040b7961f7dd5b94b5e53', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c98864cd4dba430ea0e79b534da11b1b', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c9b22a30cd5746d9a6f66c2b5ec67f95', '1', '短信设置-参数配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ca65d399c8cf4e8f9efeeeca1297338c', '1', '常见工具-计划任务', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cb442d82f29e4efdb59a354334c91d0b', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cb9c9e7740d046ca898e3fead7706d83', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cbdddc7586da4510a3d711fbcb5f1684', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cc94a684f72049f48c326c58669007fb', '1', '常见工具-多数据源管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ccb24bce7902475e8b3d042a647a23ca', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cccc2cec41b64b39a47b123d2931b854', '1', '系统监控-数据库监控', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cdae42a0dc07458c9dbb595780989a01', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cfb92a2cdfc74b848970c54c09ef912b', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d045d29a588a4c0580ebc2bad2893cc1', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d05a64240f4b4c3082b649c25fa84613', '1', '系统监控-附件信息', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d216ee2a20e34d198bf1fa8aa2bcd0f9', '1', '系统设置-部门管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d2d0248282e54c1bb2c08126daa911f1', '1', '代码生成器-生成案列-测试单表', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d6de49eda86a4f6abd4f80ee0eaf17e0', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9e47d85104014170bb2c39a8f055ab6e', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3cbb537a43cd483d96fc84edd222a68b', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4ea2c67fdfd34ba5aac9bdef31989a67', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('79902d5f0bcb468f8264b7508bd9c055', '1', '邮箱设置-参数设置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7a4613d2ed8642cabb537473f68f0043', '1', '系统监控-在线用户', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7e0dd06c905f492d9bce11f65e057687', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7f70890002a64a53bf3f3a3c2739e1be', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7f7c494c205c41369ec0bc4346d4588d', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8006aa900b41411c9b9332f9673fc106', '1', '系统设置-部门管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('802b28b9f37946569435e4960071a771', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('80433ed95c024844887c42078398387c', '1', '系统监控-数据库监控', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('80daf60986e54e108f844910dbc46953', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('82b0539e44b040c3afeb1579aca82005', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('82e999fb6871447694cdeeff6afeafc4', '1', '系统监控-附件信息', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('82f59e79c6924760a215112782c64f15', '1', '系统设置-角色管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('868cb22e9bb941d5b233fe9adfbbac0b', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8880fd333c6f45998ccf5062d7f2bec4', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-25 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/JeeWeb-Mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('88ce9440d85c44f6943e78e402c9c158', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('89ad73fbbd194d55b9db5b2288e578d2', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8b736a4c380d46ba82232373f5eed470', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8b9b5782251844bfb6dba9fc1d39650c', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8c878efc56bf411eb7de5060b91a05d6', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8ca85fea764e420fbb161a107a81c015', '1', '代码生成器-表单配置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8d880f4aea88423b883a575047808ac5', '1', '系统监控-系统日志', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8e7647fdd41c4595ab5696b032a06a8e', '1', '代码生成器-生成案列-测试树', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8e9534aa1f1947329df71d1b950dec5e', '1', '邮箱设置-参数设置', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('909b65c077954c7281f3f5dffcba69d2', '1', '系统设置-用户管理', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('90f9373bb3844d28a15ccb32e170618f', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-23 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('919a6172fd794adf87a4cc715777d8e3', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36', '/jeeweb-mybatis/admin/sys/online/ajaxList', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('91b2af6cfbcf4e469b48e9927d724167', '2', ' ', ' ', ' ', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-22 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 6.3; Win64; x64; Trident/7.0; rv:11.0) like Gecko', '/jeeweb-mybatis/admin/', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5e35046c756f4f82b229222001585479', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:01:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('215569c9f88d4bec8dd33fcbb4691c55', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e9682e168e3c4c81b2687c758c5856e8', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6f394c505bb045099986fd4d7a8de191', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('888ca7760275441287f8032d6010ab53', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d506ccc7ef1f4646b2ae52d7d91b9d71', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:48', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a45d484505944410a61bb57028a87382', '1', '邮箱设置-参数设置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6a98639b74234f44a7fdbc73a7d73d19', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('514b04ae6ba74bc999076b2fce3a1cb1', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:51', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('997896883cc94102ac16889f60b63837', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4df988a912ab4904b4c389b4a0ec17ac', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:55', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b5bc27291a004c0f95cb2c0ddb02d3aa', '1', '邮箱设置-参数设置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('13fa232adf25400e84957fc29e6d65bd', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1b0ea4d33f174db6b725cbe1c017c3dc', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:04:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a026ace8d1fa412e97377c2dadc313df', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:05:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d19dc80296bd44e2ae0650a588056d87', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:05:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bd65cc3b5f5b46b4a3c46b2af3a61eda', '1', '邮箱设置-参数设置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:05:13', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0d7d6e93b35f49e79c51b4ed23a34d68', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:11:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e7c3af4f24e548b5bccc20763e7b89de', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:11:57', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('09c2f85c787e4ef4ba895dcc770868a1', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:11:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f1a3b988a3544543aea999f1a7c718c5', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:11:59', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a9cc965806594a23b114a18e366d3e59', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:12:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a7d1813411374bdbb08a0659597f6b9c', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:12:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a530cea9ab4a4854b32fe0f89f79d97f', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:12:01', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1d45f4e4f29146a9a5dacc4be2e78508', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:12:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c14b0357320145339095b64cefe3a3f7', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:13:15', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('db671756266f4c53afdd48bc6406eaad', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:13:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('73d52f95da264342a7bd130ab9d38f35', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:23:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2bd296cc4b91464b9a849c2de7778fba', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:23:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7aee77931f3e4ca08fd19fc38d8de773', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:23:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('32b77bf538a6412f8700fd25df6a2e87', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:23:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7ee802581a3e4bd3940895888a5309a9', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d9e686e69bbd48ff937e939b92602bee', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fc7edf3580734647ac4c770263f335be', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f429d52f4528408896e1b75fcee151b0', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('32f408aba6484c659893030386fa1bfe', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8305027b77ee42139040ddd7ffb40a04', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bcc6c007c3534c96a1fe40526d002638', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3f3e6a9ae8d84164930bb78cb9c3383f', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7f39fce4b7ba4af185df6cb0b56cfc34', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('33a940b0306843cc8945a438e270dbb6', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9952649c3ce24e3195809e182ccab33a', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a7633f01436341c39f2701d98de54b24', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('24642ceb6e5144edb2e12c97d6d25b45', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6f47ea54093746a28e0884abec1d7c8e', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('87ee5e5b1fea4e17864cd7c1240e7ec2', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('757566e25030462d8884cd60684dfbd2', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('54866dd4840c49809d389646507da07a', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a85b42bd3e4d45cf92356bedc1539e74', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:51', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ea10104b9c574b5291fab35b303cde59', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:25:55', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b51f14d4300e4b41aa1f220f097d5a4b', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:26:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('00ca3f53fbc0478c99019b2255c05c05', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:26:10', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('daa580db2ad040bea5e0d2f86d9945ba', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:27:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f30412e722ad40a38763106e29bfa11e', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:27:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ca802c02866d4e35afe5cdb04e238b6a', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:27:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('47e86fa178414497bbc14537c517476d', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:27:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('99bab470ee924bc592afc856f13fbd41', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:27:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5f59446f66b84bee8958c6cebeee0987', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:29:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('69620247c00f402c8d454d7c2bbd41d7', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:29:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('36e5fe1a9bf64afe9dcbb311f7e5354a', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:29:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0df64d36123941e6a6b92a56d1f22c1e', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:29:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3e121880722c4099874aff9578e4979c', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:29:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('04fb721093be43b68d409b00f4f62b0e', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:31:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('30204265e60649c080142958fb2d6414', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:31:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c0094d35f1e44cdaaccf337a5a5d735f', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:31:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4c3023ecc23e4ff4a533974f13dde727', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:31:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e5725bddc9684cb3b3d33e7a79f44d18', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:50:57', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1b810f784ac5411e9d2ce088031553b9', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:38:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4114e97555174a1185eaf8be8955eee9', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:45:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('27483a3066fe41f1b0bd347f56aa663a', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:46:54', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dbc10b09ec3b41a6a1ba13af7e2f5b17', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:46:55', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('04ea62bc3a9444859014d6436030c1fd', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:51:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('859d56ed4e6840b08a5b09ff708e7b6d', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:53:48', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8c7ac1e0dc344e4284ab591d8304c095', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:53:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('de1f9444fbbc4617893511ab41fc9bf5', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:54:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a6f0a6c2d03e43fda7c26d196b04f899', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:56:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('677842f9c42f4a93b2793b0afea8ee8d', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:56:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e665ee2b7b424329a7aa08f8e37a1f8e', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:56:46', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('83d30556aa2d463fa3f97c1ef53bc5f8', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:56:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('725291c86e04463ba52a79f08598ee4c', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:57:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8f5bd8e4372b45f9b833fd7168327276', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('447cb97154164c0f87c4759b3bf576d1', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bd886c5d64924af3b71502ad558efdc1', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1fc95a7bfc2b48949aa590ed57ef18ea', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0de330c4061548df9d4a67a408cdc94b', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('823ac11cca0b4aa5b243f0af09c95864', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:10', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('08f37e0384db4dfe81eb8005f07119fc', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:11', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f29356051e66423aa0fb6388e110f68c', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:13', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('eae34d12cf084495a059617f85a634e5', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:14', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c5d5a5e9bf444a078c12f3a895e5dabd', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:17', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('67ab888b8d1a4dd3bf71a24ac095ac1d', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b7b4f71dd2b44d79be9658e42accdc16', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:34:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('31e45f083e1c41fdb6bdc38caf91ea58', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:35:10', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4980035f634e4195ae3ab4f6fe758f70', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:35:55', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('056f4dab297547beb6c0ed686906080e', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:36:59', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8e39f25fe31e4439a22e197a033a5fdd', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 18:35:55', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('30d27dc8a7474697b3c9bb927edb84f1', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 18:36:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9806ba64443549f09bd8ee543668ebb3', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 08:59:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('22915b59f3d146d4afcba25cfd4a4b94', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 08:59:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5af8b03d49bc46f8a97898d06cb25d4b', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 09:50:20', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('92a818c462034ed98792ba14b1a9a3e0', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 09:50:20', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5ef8c59aa6874beeb9b1eaa4f97c8376', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 09:56:04', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c9b0c4db20844eeab27f2592b7e67999', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 09:56:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('05466d3c32b34ed7845fa4d6aa50464c', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:11:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('35461a16bc534354a40edcf56754f775', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:12:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d52b373d0239415ca2a286bb15419688', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:12:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d5e894b00bf648bba03e69f7271ff22a', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:12:13', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('85590e9a66b94dd19a3e43c11fa6f895', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:12:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7e650d84de9646009e5313431ac5ffb5', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:13:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('29aee5c2a9264b15a5a77f1bf855f722', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:13:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d318f8b82a534860a7355cd3ac43b235', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:13:10', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a6a48cfac4c4478eb80c2518a6a70085', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d3000b2725944a93b320fa9b7503f641', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2204df010a2046628c83cd8600fb2304', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('21bab55a62ca458094caf617fa81a8cf', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:17', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d4f87331106f4685a7e5bf08293697a1', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5407cb3ebe2c43adb0e719c7f91a6768', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a4ca6e3f80ad4425a3dffdcd2e03ee07', '1', '邮箱设置-参数设置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('72ac90caf62942ed9b01dbf7b5d95bce', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('97685e7b4cbe43a881e71b3c631b3cb5', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5f7c40b673864f9c9b4a8b418291c353', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:35:11', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('258a89dcd87e4163b1f14824e185e1f4', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:35:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d3308773b94646e3a70a412430934cf3', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 18:16:01', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ca0b1fc6f9284cf19b55c4b048f65766', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:01:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('21ef3dc8a55a4fb0af481a4c49012747', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:10:20', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('df5fdbd010114485b86c54f35a0d18c5', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:10:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('419dd794684c43559327025b5ed01ab1', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:10:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e7dec79da4494efbbccebed9ca52c88f', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:14:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('14a6c4053e20454392871aed04be0102', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:14:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bcb217e7f97a4f82b709ae3a5437ac86', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:14:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3055c8ae0b55403bb4c3f58108bc4f93', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:16:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f8f553defc5441db82217aa2f9e6b2c0', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:16:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3260709e182a4a15808e2268a0f9a0bc', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:16:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9d040adab7104a868a5076af802d4fa5', '1', '短信设置-短信模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:16:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smstemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('84c665414174471cb8e293f64435a4ae', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:16:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('42f06ed8763b444296bfff4d3c3be81d', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:17:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4dfadf3a46b64b1591abfdd0df3ca6d6', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:17:15', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('21dee49cef7844ec9afb74a5602f5a36', '1', '短信设置-短信模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:17:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smstemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('50321151c3454883aaa7a2eaf9414006', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:17:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a51a76d8b19c462b89a302fc640396bd', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:17:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9574efc3470d419c9b1407d7c8a1b8dd', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:18:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('edb57c05b32b4c33a1f8ab808451864f', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:18:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bf4c2b1d9abe44c5888d0f3dda1e3f19', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:19:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('abb8b6fec16a40e6875ca3dbd560ec39', '1', '短信设置-短信模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:20:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smstemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('78a0a1f935b544819239342dd05b4fa5', '1', '短信设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:20:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smssendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cfc2cfcc510a4420bfd89689329a5264', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:20:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a993c2a66403424e8668a5b32e66e9d0', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:20:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4839882ed2aa4c249ef580144793ff27', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c4ca686c863840eda2ef84b32f4823b8', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c96361848949482581c3e0ef74b4b332', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:15:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b09d3fdbb086476f9d191ad55bf8ee91', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:11', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('29b2010c7eed4f0f968dadcc6f2b9107', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('93da2140badd4b2eac5258b74d80e32a', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('42bf0035bcd9438daa69b59076bb71bc', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('69b93b0d02a244a6ac3cd77ff513d8d5', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1cdd166bf716443a852ac1a2a3442156', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('daab05e1ee0b4bb69f8ff2db2f3a84a4', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('eb6a5648ab144b47ab9a4c75256e94db', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1cd3156685b749be83a22ab7a5931e34', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d7293e9871ca4ebb9b2c7fde1524d603', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('935279f8636a411fa576d07aff1c731f', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a9de0e6358aa490586583a7b9f70691f', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4bd892198dbf486da833ce154f18e3b4', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1ac1876dd5c44bfea71987c4d92c2b09', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8f76101285e740aeabf3fbc90044dd42', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f3571a06fb0d45058360ab60847e210f', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c7d9851b49674cad8dfff8a40a7769c2', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d1d61ca251284f2180740c5486feb4bd', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:16:51', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('38eec369001f4cdeb44faf742b7b84fe', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9f3c50c5fb86469cb9d17613352510d6', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6349d6649e5f4adc8c5642010c23945d', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5d056a9fd4a74deda4a264e759ad4249', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bee2fd99dd2040f3ac6566ccaa4cd8d3', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dfb9f5e395de41ac8ddec28baf6a8059', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e160deeaf84a459988fc58aab0c61669', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:43', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5b018b4c757043e5a989b97e83b3325f', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f31c73fc23a8412fa1aa97cd1bba246b', '1', '邮箱设置-参数设置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7bd3ee29ecad415e93752a77a9723044', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:46', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('20e84200a9af416781db0edd2f5751e8', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:17:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('55b17398c36547a68843958084e6f780', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:26:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('18efe54ee1a544a89163bac8817ef86f', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:26:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('56537c14d96048e4b4cd91110bd9309d', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:26:46', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('67d4ebebf1e74c77a18e144a29a8e27f', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:28:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ff2edde83bf44aedaaf8d5fd3119cc03', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:22', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a6b3f78dff614d73aec0808301163ca1', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:29:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('54ad68aea0a0445aa351a7bb84db8904', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:46:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a74a909efe9240dba291bc438f23c77a', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:46:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('63969a18885d4d79a987e139d37df600', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:46:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b2f5d9ce69d94467822ab8432918dd7f', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:47:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('830cc218886740a79dc8eedebdd85ad6', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:51:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('04ca765603f844a7a8cb67379cda2407', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:00:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('aa9206baca524737acb622a991f69c88', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:00:20', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d61f1ef971df4c3383500715cd402bab', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:00:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('98bdffb761b14a3592d56ccd2ca40da5', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:00:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1963d54620684d42b0f1e0be73cd1b09', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:00:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2a3ca05883c84ee1acb78e78ffc6044f', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:20:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c4df827e4ab545babc9ddfcfe755100c', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:26:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('875e6fd245094d9f9183e6d3fffe3573', '1', '邮箱设置-参数设置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:26:19', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('14f041e1ae8e4c43aac6c182a9dc2442', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:26:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b8b0d1615e0243209ea34bd1ac5a0624', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:26:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('318ba33ae4184b51a2f004b97a543700', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:26:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fb7dc1d61cae4403838b09b74409858d', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:48', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dc5bea78da1d4f03acc2e5343ad6eec4', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b3e881e5d7714eebb364d6877e1cd87c', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ec67e38c4f154d05bb04329d3e93c740', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ae1235c52d674a6e8e6737fb0831cc04', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:54', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('244176a638184ab6b30a42847ab2026d', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:55', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('390c66c6ea754f59ac2b6dbe8e4ee9fa', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:14:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9c2c1ee2f1234ed6be697cf2b8dd282b', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:17:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d973c8880d7f423e902dcdfe871c7533', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:21:48', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a9adbf1b75184bacbb63587812440d78', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:21:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e8e776660c4d407788e06f9dab9aca02', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:23:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('62e13979f3d247b0b6d0835b1ba01043', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:23:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('839cbb0258814120b04cc1fc33f18ada', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:23:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cce4c59c68bf4527b13728f8128e134f', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:23:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cabba22f164647d7b8ecd9ec0240306e', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:41:54', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d7f778d62be84fb7bdd013c1b68e52c1', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:41:54', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d20ac317f7a14aa684df7397542b81fa', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:41:57', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('43a2971313694a74a898efbc44ae7d01', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:41:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5425e66c68554510aceb9097fa91a828', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:41:59', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fa41ca666eef41ec8ef033db4140cf2e', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:41:59', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d7d3940cb1594b2e8d240791a48762e8', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('24a494546a064b04b5a884dc5213eb4c', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:01', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b185a95abaaa46d79cbea54d54b9bcfc', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:04', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f1ebaf994a3e4f399528ac38e7151bae', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('613c074796714ce8b3e43dda9b86539e', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('af8993fe28b14894873e932c66bc2f60', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2c044f54356b4c1785677b4d491bcf4e', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('99dca3c7ba9e4cbdafb4c9e040e8da73', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ee125181e4254c74a0ae83e9a9b60756', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9fce9a63f57a467b98e0079d747914fb', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bab8e5e12aa0446a8cc92f0fc31749f3', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:42:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a094639d24104afb9101c79db9ab5203', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:54:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6f3347592ca34aaf84e338f0308e02ce', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:54:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c760865e19f940e782b81809bc7a25cb', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:55:17', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('deb01800dd914b29bc34cebb3b5ae276', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:59:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('da181fc446e14b9db6b678da9514f048', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:59:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9f48ae75485e47f2b3c63980b4b1c23e', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:59:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d1024930bde746b0879b0b14b720c69c', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:59:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('959fb687a3064a6baf78302900b2f587', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 12:59:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('55db559a0bf244eda51adf5fb22b84aa', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:00:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2093d3e7db80452686be561f4c057521', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:05:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c0bf038430104435bb64ff0a10ab8c92', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:05:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2dbe3d9127b64456b2a714ba11a3ff2b', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:06:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('29686e25e0eb473490860ed174de64b2', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('abf9a9fdf68e401e9c2080ec2537c2ed', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('19d056de6afe4284826cd7db47087a5b', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:14', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8cf23e73c4114efca1cbe3d2e10e6b84', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5c5689a513e74ea2ad375b63251e8c61', '1', '代码案例-编辑器', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/editor', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ea17fd8643b74c25ae0105c00ee0844f', '1', '代码案例-编辑器', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/editor', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d36ffeebc43b468eb331095a8d23930f', '1', '代码案例-文件上传', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/upload', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('66f094012146458d8007222ef234c585', '1', '代码案例-搜索自动补全', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/combox', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7f17c550d30c4612a8d5855c81a61a8c', '1', '代码案例-编辑器', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/editor', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('87c6b3e795f945fb8c5ebeecc71d520b', '1', '统计报表-折线图', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin//charts/echarts/chart/line', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e30c7965362745deaa733e742606190f', '1', '统计报表-柱状图', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin//charts/echarts/chart/bar', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e871ac5863aa44d0b231582c3c267b21', '1', '统计报表-仪表盘', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin//charts/echarts/chart/gauge', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5c995295363d494e8a18a17b65222cb1', '1', '统计报表-漏斗图', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin//charts/echarts/chart/funnel', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f31f89d165e74eefbbd6345da6ae8b53', '1', '统计报表-漏斗图', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin//charts/echarts/chart/funnel', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8150f8e89d64465e87ec5b46d3cdce66', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3af927de20ae4cc7963f2bbf0dcbb4e3', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1e1fe83093514df8bad4e01b07a2fe45', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:43', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e926f0bfabc342afb2517164afaa45fb', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('473bb29815f146fc91ff5639834815fb', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b628c478edc541aaaf20cb9be749e1bf', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:53', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ca23ccd50cd64b0b960fbe8db64c7904', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:54', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2f47cad56dcc4e0bab094b26f1bd3da2', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:55', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('da97500ab7d0422e92d471c5a5aa5412', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:57', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ae62e98e01f040a4895a23972930ecc4', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bd5f2874ac844ca68e612d9fff7eb6c7', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('824d54244bd04f6da8fda94dad7f169f', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:42:54', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b57743dc109b419a8f487e535443388e', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:50:53', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0c76276a7c354a00933147d08074f8fe', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:29:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('36bbc4fdbd484e65a890f7a77fd2e253', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:30:04', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0120a846943248db87a76d43c22bc511', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:30:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('18e04c20e7d6496b924c7e45a8eeda5d', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:30:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e6be273efade46679071b5e92aa2d2f6', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:30:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dbf36141281946bea010cf4f1a28b31c', '1', '系统监控-在线用户', null, null, '40288ab85ce3c20a015ce3ca6df60000', TO_DATE('2017-09-10 13:30:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/8.0; Touch; .NET4.0C; .NET4.0E; InfoPath.3)', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('05e8a99e63664820805faa0a87f5fcd8', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:31:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('87297d859b6a4a8abff1ccc0bccdfe69', '1', '系统设置-用户管理', null, null, '40288ab85ce3c20a015ce3ca6df60000', TO_DATE('2017-09-10 13:31:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/8.0; Touch; .NET4.0C; .NET4.0E; InfoPath.3)', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9615a2cef0a640aea6eb60ece8255f5f', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:31:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c5e1359bc5aa4bbb9937f72ede347137', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:31:57', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('399a98edeea44bd3bf554c79361d87f0', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:33:22', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('30b96d2c94d14799a01b764037c4f871', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:33:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4a646e70efea4ffb9a0d1d48c5316e64', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:33:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('34fa48093f55499a8335deb76e83db7b', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:33:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6db2c09e5d9446bdb03631ec5d116286', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:33:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b7c3cea3426241e3b0dedda992dfdf1d', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:33:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ce39ccd142fc41628f74ec82fb833499', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:33:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('67dca8225abd44d9bd37d5eee3eca998', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:33:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f786fcf117de4202b39a9c0728926db5', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:07:14', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e48cf0badaa947148bb337d985d76a09', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:07:15', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('daac7ec14ada4961bf83ebf18cf0238c', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:07:19', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5387086dfd5b4deebea0048cd173086f', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:07:20', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6ebe302786ae4618a4f154c60b6b1d12', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:09:19', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b360e22f74ff4e83af6c31d436825696', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:10:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f774710b11b446a5b6ac1cc159e68ead', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:10:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('135d6bf611d04b86a7f07d2cdcbd226c', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:11:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bf6ac06876054596bd07ed329cd0fe5c', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:06:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5568bbd767c94c0faa42db5bde24fdd3', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:06:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3c4e3f175cb24953be65066d6752bb1d', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:06:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c90cdf38bf744de3889462916cfda0c9', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:06:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2edf41d3fefc4fa7927ab7544834affe', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:06:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1f9b7571d5e541baa04b35a49e697b25', '1', '短信设置-短信模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:26:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smstemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4ec97e686df0497bba28f6f10715f752', '1', '短信设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:26:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smssendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('97356be441e7411c8a0f024f66d6266a', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:01', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d14440add8d04ce1b4c8d4732525372f', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d56ade877b724e4fb9c6a9e39388692d', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e04efc88788e47c29afa94e65f88cd8b', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dbdc161fbe0b458ca916b32886a2a591', '1', '邮箱设置-参数设置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b1c341430a784a8a94a6e4d38ce70a03', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('544a53b111934c018319e15a8429eb5e', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7dcd7bbefc96476d97f89bdb540f2321', '1', '短信设置-短信模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:10', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smstemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5310bb02711747fe9beb756703a2847c', '1', '短信设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:11', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smssendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('23234837035d4bcfb745e90828f0c293', '1', '统计报表-折线图', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:13', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin//charts/echarts/chart/line', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('579baf5072134b8fa1c7f845052ba818', '1', '统计报表-柱状图', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:27:14', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin//charts/echarts/chart/bar', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('81bb393866a145dcb699049279fe8a82', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:28:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5a481e88f5a54b6b932b3ce18d8423d0', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:28:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cfd74f7e9383464f9fdc589715f7d431', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:28:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fb7b0fb895cb4cadac8bdc94a65132ba', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:28:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0f8e00e31b8e4870b2bd1c738e314a9b', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:28:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('411d2e31074149399afd270bea2210da', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:28:43', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('17e79d60d16244b698421a354ba15571', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:28:43', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d4177f0ac7c24ea386b2e90ba3eb5dc5', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:28:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1536ba5e229c4f499cdae5bd77c937f9', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:30:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('31dbff174fe34a14830def4af7d1ddd6', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b05685528ac2497e882c5be1f9a357dd', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cee10a4ee0b3482e8dbac6c16d9d0e09', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('172ee051d1ce45a0a1eedcfca67d108f', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cda325d6360a481a9f50413b332c694d', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('badb611f8f32420dbc904006486c2eff', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3716fb253724479a86fad7e69e8344f4', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b0c0e37d15f5429aaf968583d4a153fa', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b37e893191944c53848ed83b1a2a17c5', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0e5e17196598463f87de15ebc6007bd5', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('50bc7c0f215b435787d8615eb5591c3a', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('887358a9bbf642c6a776a0b3ad232f15', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('144b2f2697644d49babda7a3d72e21cc', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:36:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fc2edb871c0d47859d659d82670767b7', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:37:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('20c32b37dbfe496791fa10df08939dff', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:01', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('92e2fbe8900a45dfac5409679ef43f38', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('85894ab4e6f740b4aefb5bc72c576e74', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d0020fc123d540d5901312d2cb4940c1', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:14', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dfeef998bf434e8ebaf106571f515198', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:15', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9c764b3e79ff4b14a592ee14052bf112', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:17', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d4aa5445aabc46be82023de753c08981', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:17', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7f29b9b89722432d9911cf459f20b06a', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3c7b21506bff4425a6aacb0b752fa740', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('30e6df6ff1d04bb0aa44d83bbfd92d8e', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:19', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('294bf1682e6c4138a2a2d137cb980d11', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:20', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c19ebde732f842d6887e1c99a1047cc4', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('556e1bb2addf4dfaa581166bc23df025', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:22', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e9dceba71ecb4f4e9305a00ae11a9a0e', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:22', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a80bccf1937b4fa9acc1bb7e39ad440d', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f5d5be0438a04539b1175efe7f5b3ea8', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0aad6ecf5b4f4590a76d6b68af3f8dec', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('85f3d14efbe447be862f4933e943d4a8', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f03b72d0b2a447bc9307749af8f95b9d', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b9732cf534944ff088d5ddd7ad2c9886', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a2af8145833a44e097b3b592dec07733', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2fd05479ec834c86ac750a2fbc7c99c2', '1', '邮箱设置-参数设置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9a4e93e2099143afa6e1dfb6460af835', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('78fffc653f014f3680b3247370750e38', '1', '短信设置-短信发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/send/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5b4b2159e43b4b30af25804d759d3553', '1', '短信设置-短信模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smstemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1ac411a8d41d400d82d7a0e95f0a2a7a', '1', '短信设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smssendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('165d0abf36764e67a6f37f3121a05556', '1', '短信设置-短信模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sms/smstemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f9ac8d7dd1d141ce9936032acab2a8dd', '1', '统计报表-折线图', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin//charts/echarts/chart/line', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('131eb006e01f402c88278d46e0d0b390', '1', '代码案例-编辑器', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:43', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/editor', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9676eaffee6546bfa90321c42d0d39a7', '1', '代码案例-文件上传', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/upload', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('89c382ff50014075baecfca64513020a', '1', '代码案例-搜索自动补全', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:46', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/combox', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d0a24e83a5744aa78de361331b3c87ca', '1', '代码案例-文件上传', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/upload', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('88be98a3c7b048dd9efef066c5c692e3', '1', '代码案例-编辑器', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/editor', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e1608fda5587425e8462351134bcb9ca', '1', '代码案例-文件上传', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/demo/form/upload', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('abff0b4714cf4de49319ba441ae520be', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 11:38:53', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4507cb0b56864bcb9ad9ad5275a255e8', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:40:48', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0c8f113fbab14884b3a356db74d8184e', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9dd3133dd42c4e5882f4b6cc8cdc232b', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:01', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7d36bfc60c034ec58c51ecc1b9f69331', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 16:41:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4d0e570b059c400e99e25626ce1375db', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:57:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b74b969f8f05491cb4180b2a6a37c646', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:57:46', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b5336dbe75e24eeca0348e572c3aaa83', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:57:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('83e4f75acc3c42ea9fc1bdf1bbfd9288', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:06:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6bfda8e6850d444fa4799354b558f070', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:06:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('242b420c80204569bc17df10d1cfc65c', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:06:59', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4b5a3d08e94e401e92f9b10688c6dbc1', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:10:10', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9b8bbc3b00b64a13b644cfae069c917e', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:10:19', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d692b15b6e7443158cef91a8b9a96c72', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:11:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('907b20a2e58749efa9067fbf93a0d075', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:11:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c8143ba026df429cbf9f885398f020de', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:12:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('20ae27eac5604b7991e820c18e3be234', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:09:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('034015012c01485c9bf83d6d053affce', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:19:13', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0e4880db8d134a52b6631baebcba0074', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 10:19:14', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bb80f21af7524797b7d7d833f70b7e17', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:13:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('80b8428fe18549dba3e0181fc10eb828', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:13:17', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cbf5db0a76bd491f95d21c7ac12a3b8f', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:13:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0471b37abfe54fa686f24f5971cd26ab', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e34c80aa17444846affe7ae63cdf7a13', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9bde211e8c7c4ef6919b6baf74163fb2', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8b24fb490ba04c66903fb1e83b2fef82', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:14:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('01978c3b0e0842d7b6e8879994b05b85', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:15:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('24fbeb16c399481194e488ea0a94bb3d', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:27:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('44a8d4144ce44db08daa71f2f42decf1', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:28:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6574d30f3f84483e953927ca7640f380', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:28:51', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d7b42eba58c04c01afebbdea392abfd8', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:28:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0536fe013a044832bbcaffb9f1442ab4', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:28:53', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d728c0152080485bae45839d1dfef9bc', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:28:59', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('30cda26db3724fd7aa74514241cc518c', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:36:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('76b1516e2e8845cfb8abfe88737574fb', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:36:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a010c57ab28e442492531d1b75706cd0', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:37:20', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0f8667a9188145578a8dd263f8eef892', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:37:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6317ed617e7c41aca24c5a19d6a83019', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:37:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b3bee391c72b4347bccf7eb72ea72e36', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:37:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7cd21bdb9e7a438694b8c784348366fb', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:37:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9e08d34a69344e81a51b5becbb376e27', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:37:48', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3157ff6f1c0c4849af125550e2e95da8', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:37:51', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('216d28e15af5460b9c9345f544caea78', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:38:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('44c031ce25ea451fbf074fe72387e795', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:38:43', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4564a9a6278b4f9bad6e22f5572dc8d1', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:38:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('26632a817ae04c79b297dabb0c5aeb4f', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b1f82a442135423faf8fb28e57bf7890', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cdac4609a78143339f251bf8a2df0dfb', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:13', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3bc10e72c9f34619866b154b2c0365ea', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('794aada1d3274c3e89e08f5cdfae68e6', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('19de090ae59c49fa9fc5992cc80cb796', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b42ab4bd8aa64cab9a6939bfd94c49bf', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e0b09419131547889b41e41012f4ccb0', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8dceebc71e5943b98c123472a0e63493', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0c820af8ee0f47e4b8dde0bd9dce5bed', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('134f917865094aa58ed3386775c79831', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:41:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('98419ad2795a45a1bfd533c475315d38', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:41:53', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('819b527d740c4dfda5109328e26bdfd1', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:04:19', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023448590&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01,2017-09-09&query.createDate||between=2017-09-01,2017-09-09', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date BETWEEN ? AND ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.GeneratedMethodAccessor196.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.GeneratedMethodAccessor195.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.GeneratedMethodAccessor197.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 101 more
');
INSERT INTO "SYS_LOG" VALUES ('49093ed5172842ce97850423c080125c', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:05:46', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023474123&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01,2017-09-09&query.createDate||between=2017-09-01,2017-09-09', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date BETWEEN ? AND ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.GeneratedMethodAccessor196.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.GeneratedMethodAccessor195.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.GeneratedMethodAccessor197.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 101 more
');
INSERT INTO "SYS_LOG" VALUES ('db1351f147e64bcfba4199aed3980069', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:06:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('402851c12c70458ca3bc9cf8c490189d', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:07:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9a8af6f0385349d3aea8b578619144a2', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:07:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3525e0ed540d4ebeba525709132258fa', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:07:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c06f34cd885946b19e0b8c802367e082', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:07:10', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5121936eaf014e9791723f6fb95c2f00', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:07:11', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f2ffd1e4172a4b289a287e23fc645587', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:07:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6e0d25c59d604a1eaf3deb26ff68219e', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:07:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a2c5cfc0e6cb4ef79ffd1a3bf209b53a', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:07:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,name,code,isSys,usable,&_search=false&nd=1505023645924&page.size=10&page.pn=1&sort=id&order=asc', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00904: "T"."ID": 标识符无效

### The error may exist in cn/jeeweb/modules/sys/mapper/RoleMapper.java (best guess)
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: SELECT * FROM ( SELECT TMP.*, ROWNUM ROW_ID FROM ( SELECT  id AS id,name,code,is_sys AS isSys,usable,remarks,create_by AS "createBy.id",create_date AS createDate,update_by AS "updateBy.id",update_date AS updateDate,del_flag AS delFlag  FROM sys_role       ORDER BY t.id ASC ) TMP WHERE ROWNUM <=10) WHERE ROW_ID > 0
### Cause: java.sql.SQLSyntaxErrorException: ORA-00904: "T"."ID": 标识符无效

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00904: "T"."ID": 标识符无效

	at org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator.doTranslate(SQLErrorCodeSQLExceptionTranslator.java:231)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy71.selectPage(Unknown Source)
	at com.baomidou.mybatisplus.service.impl.ServiceImpl.selectPage(ServiceImpl.java:320)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.GeneratedMethodAccessor196.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy72.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:102)
	at sun.reflect.GeneratedMethodAccessor195.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00904: "T"."ID": 标识符无效

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.GeneratedMethodAccessor197.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 101 more
');
INSERT INTO "SYS_LOG" VALUES ('d03717939b2c4cf0b6b79e7ddf5764aa', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:10:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('de3c33f3e8eb44c7a62ab7a83f610ff8', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:10:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,name,code,isSys,usable,&_search=false&nd=1505023827145&page.size=10&page.pn=1&sort=id&order=asc', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00904: "T"."ID": 标识符无效

### The error may exist in cn/jeeweb/modules/sys/mapper/RoleMapper.java (best guess)
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: SELECT * FROM ( SELECT TMP.*, ROWNUM ROW_ID FROM ( SELECT  id AS id,name,code,is_sys AS isSys,usable,remarks,create_by AS "createBy.id",create_date AS createDate,update_by AS "updateBy.id",update_date AS updateDate,del_flag AS delFlag  FROM sys_role       ORDER BY t.id ASC ) TMP WHERE ROWNUM <=10) WHERE ROW_ID > 0
### Cause: java.sql.SQLSyntaxErrorException: ORA-00904: "T"."ID": 标识符无效

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00904: "T"."ID": 标识符无效

	at org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator.doTranslate(SQLErrorCodeSQLExceptionTranslator.java:231)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy71.selectPage(Unknown Source)
	at com.baomidou.mybatisplus.service.impl.ServiceImpl.selectPage(ServiceImpl.java:320)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.GeneratedMethodAccessor196.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy72.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:102)
	at sun.reflect.GeneratedMethodAccessor195.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00904: "T"."ID": 标识符无效

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.GeneratedMethodAccessor197.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 101 more
');
INSERT INTO "SYS_LOG" VALUES ('81642dd0c92c40f6bfd714883637f544', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:17:55', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ec30cb4964684b90b20400bfad6a6303', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ad515ef7b16c4f0397417fbd3f68abb2', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7219f32e682543ddb4dea9cae5f9b6d9', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('66f44170b03d403a988048062ec165c5', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:04', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('be6b7fb5b3404aa0b1700b427acc0d36', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('79a1b49ccfa144afa8f3fe866a11152b', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a5eb62f27414462d82de7fb5beb369bc', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:37:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3ad657f7c4cc4ac3b4da3d0a50c2a21f', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0aca40215f4a403a854b3906c4e6a8ba', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('027395f7bf6b4a32a872d6f4e64ea453', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:04', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('51a4fb350ccc48e4befa3d562cbba2f2', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('07873dad83fe4c9eadea996a3cec8dd5', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cea97d0e4434425a965b8cc4a9c1d47d', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0a8c872e70bc40daad8e5b2a52e4138d', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('43a768de13e6462abb18bf909e3b8fe8', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b611d8ad0aa64e9b89c454c643347980', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:10', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ef0914a542e646069303441218b28a0a', '1', '常见工具-计划任务', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/task/schedulejob', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('584845e5e0804ca0bb1321ac03ef85ba', '1', '常见工具-多数据源管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/datasource', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f24e25fd2e3d478c9383c18a057c4075', '1', '通知公告-通知公告', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/oa/oanotification', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1f557d2880394682bd2f70930d3b3aa8', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:17', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5b252afb6aca4a54b3da9e1bbe55fffc', '1', '邮箱设置-邮件模版', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailtemplate', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('700d4f9c3eae4b91927c9d8327bbf85e', '1', '邮箱设置-发送日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:20', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/emailsendlog', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8772042769df41cab8246baf75a56bcd', '1', '邮箱设置-参数设置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bb46b6735f534fe58268bdea09a0e85e', '1', '邮箱设置-邮件发送', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:22', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/email/send/email', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bea52de4ee6e473a8fdafe3e8c1f6726', '1', '短信设置-参数配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:38:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/setting/sms', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('50e5cf923073488a96e5e84c86dc9d6e', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f50c7fb187e34ba7baf6a16683f4b965', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505024313005&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01,2017-09-02&query.createDate||between=2017-09-01,2017-09-02', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date BETWEEN ? AND ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor70.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor70.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('c4160a90f4454e0aaa3bccf40d21d643', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505024318740&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01,2017-09-30&query.createDate||between=2017-09-01,2017-09-30', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date BETWEEN ? AND ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor70.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor70.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('85050f6d7249435eb46c06f4f542e122', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:11:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('53f33a39e8954d9cb7bafa352ba440eb', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:11:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('68e2ebaa739b477e8dc877a86686432d', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:11:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1d3f28c819154d0a82ad5634e3752b88', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:12:51', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8d7f8a66afdc4e98baee16ad89932eaa', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:13:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1d40d449f3584b30a8563199b9a39579', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:13:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f6969cfdd29446ab9520347bde1fa8ed', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:13:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2e13c5e57bff4990a71e918a82757130', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:13:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0a0b757a310040b38806d4ee7c006c59', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:13:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c9bbfc88044143dfb5f3880e69b5d9df', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:13:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6eecb42b7d0c455896a2eeb98a6dd91c', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:15:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('eea7eab813b342e89d006c6dce7f316d', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:15:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('491def9253cc435b85cb144466173984', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:15:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('994c6e5802a94886882315d601f1c94e', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:17:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('24845918fdb64452abc5a1db06b3b322', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:17:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e1f2dcdb7b834ef08088fe6819bd6870', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:18:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b1a6c755fad04d6190496fbdf92d584e', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:18:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b014e6e7bc8949ed8e3642b694e59284', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:18:45', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b82c4ed8098b4b6988b162cf58efa798', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:18:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('70d952bda6994971b8288171be6b9ba2', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:18:47', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7a6c6057e5864a98a0536736dadb0f9a', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:21:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b1f88244cd7a4af3b4ec1a33a454593f', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:21:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ebb3d120b1df48789246eaea387789c4', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:21:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('27daced93f134a5ea9afb321bc2798c6', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:21:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2b3ff8210e194af6a5b1a81b69a30fb9', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:21:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2ba128d127c445269bd46cc9f9087f1a', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:21:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f45832d81abd42398eaf33229290f007', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:22:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7a3744557e6d488295f5c3b199fb0560', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:26:38', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fd8b65f5ff24413dbffd51ce61c2c337', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:26:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('88107cf588bc48a893d76a84c9703e6d', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:26:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ba6f82f5383d4258a2d456337b6adac8', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:26:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ed9f9d51a04a4002b6cc0a0b70254403', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:26:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('621c37b7e4b040f29006475842365688', '1', '系统监控-用户最后在线情况', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:26:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/lastOnline', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('6b4b72f2e6bb48f5a52c5db292d66e14', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:26:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2bdf720abb954ccc83f0a9961628b504', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:26:48', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('812fe16fd93841c0af582b89df9f754d', '1', '系统监控-在线用户', null, null, '40288ab85ce3c20a015ce3ca6df60000', TO_DATE('2017-09-10 13:27:19', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/8.0; Touch; .NET4.0C; .NET4.0E; InfoPath.3)', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('272ad8b15c9f4c81974e8ceb087a9069', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7a73f95f07324f50a74daf3bbf078e3e', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5d7b3f8e2854407f8e89fbaf5d7733b7', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d4eec3d2d0004e6784212cdd776a2e92', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e8ec1419515641468335c7cc27a750aa', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('dd6a3d1b2ed84ea2b0d7abdc7028a8cb', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('cb3cd1edecd94efebc0bc75b7f20cf3d', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:36', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ae07d7f03c6b442d97b06eba9626f0e8', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:37', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8027d89b2d3344caa1bb1ed6519583e7', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('af36c683aa434a55a95565fc13f26fb2', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:41', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0ec2cc5dad3447baa833b03ced159b6e', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5131774dcdda4e3986366df9ef4e470c', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:53', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7b32f483f3244cffa1a467c94e52c6d5', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:54', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('150ab29794964cd4a2a836be6d1381b5', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:27:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('438aa7a74719465384fb3e46dcc977be', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c6c24e4f7b0d47db9f18a08ae0e74654', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('684a1e96875f4bb4895959df04871ac1', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('468affff9e464635885d903ee7e79916', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('99235a60a2af4676a25180bbc8f93ba1', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0007a9fe3bf24c8b926f75782eb4ce65', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('48c06a6cd8314fa4bb305c5fc76876a2', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ec999359e442470bac85fab2f82e33f3', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('429aee7ba2f446ca99e73a64d9a93059', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7c77429b210f49e8badcc338e77a7210', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e55093193e6d4245bdd2d0bab8ac3f0e', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('248f2f602d3740bdbdc1a23edcdfe591', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c210f8c57e7a41c0bcd62730d54cfd47', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5a9fa516d3054dc4a85c4373a355633e', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('877f25c779cf4b6c92d39669843ab102', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('d87973bcc1c64cc6bebfdfc2b89714e2', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8d97894444f94cf4b41b5377382b0e94', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:43', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0212b474b7cf4d62b5d5e06c530a74e3', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('00583bb3b3f3445a8de00493d892914e', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:53', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('15694fd2a3fb4a698436641b1fc250fe', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:28:54', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('02926d7454164e9ca688bd21563a943e', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:29:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bc8f650c75ae42628c1a24d124fcfeb5', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:29:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('aeaacff473244749a375a38de666c15d', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:19', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a7fea7a706f24d0dbdc0d0be07e9ac44', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e7861c5f3b8846f4bc15eb6866eadc45', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('bbc66315e9684d88b8e34d74a900b822', '1', '系统设置-角色管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:26', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/role', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4890e7e6f3524f4f96879917ead453a1', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('11d48cc27b734da19cd5af720030df8a', '1', '系统设置-数据字典', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/dict/group', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('70c5aad08b3043fca5dc62ae16c501b5', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a82dd95c38d14da1ab8ce83ef3de68ae', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:32', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0ba73ff727ba449498c3b7d2ab9e4127', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:33', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5315ccfe02d844408195328d884843ec', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('03ae4cc062664b888f00f5b41e37d104', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('63a0cd7954bc490ca5fca65ab8ac562a', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9bab19213e9c4e6b82fa1ae8cf3ab4df', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:57', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5002d39741894d8090f4c0920642b0b8', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c3ca785959f24f9182e38adc38679d3b', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:57:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c7c975fda15d4f3a8842654059c54d29', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:58:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c00c204018f0470098a5f347cd59ce31', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:59:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('257b66f670a3496988e95fa13748646e', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:59:15', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023155658&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01&query.createDate||eq=2017-09-01', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date = ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('b146656483a743e58e2735f13ebc5db5', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:59:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023156360&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01&query.createDate||eq=2017-09-01', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date = ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('8e293c9d91ad4319997c5bc248ca9844', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:59:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023164608&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01&query.createDate||eq=2017-09-01', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date = ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('5e0f5e6d564c4d12afa522f5554924e2', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:59:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023165084&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01&query.createDate||eq=2017-09-01', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date = ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('7e43b965c20b4fe89de6d7ade0acdc34', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:59:25', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023165888&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01&query.createDate||eq=2017-09-01', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date = ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('058d07f18447441a9442e6212bff95da', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:59:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023168130&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-29&query.createDate||eq=2017-09-29', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date = ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('2a5a71e6fde94121a352e2c9d5245d3a', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:59:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023168770&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-29&query.createDate||eq=2017-09-29', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date = ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('a0b63e73e6244d2880d04ca35e4d7519', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 13:59:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023168974&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-29&query.createDate||eq=2017-09-29', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date = ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.GeneratedMethodAccessor196.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.GeneratedMethodAccessor195.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.GeneratedMethodAccessor197.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 101 more
');
INSERT INTO "SYS_LOG" VALUES ('a4545e864d9949f59fa7b7e5289bd93d', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:00:01', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4137d1f7891644729743b28efe27df47', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:00:08', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023208139&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01,2017-09-30&query.createDate||between=2017-09-01,2017-09-30', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date BETWEEN ? AND ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.GeneratedMethodAccessor196.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.GeneratedMethodAccessor195.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.GeneratedMethodAccessor197.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 101 more
');
INSERT INTO "SYS_LOG" VALUES ('6cb3ec54b1b1408b9d2882c19554855b', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:00:09', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023208994&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01,2017-09-30&query.createDate||between=2017-09-01,2017-09-30', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date BETWEEN ? AND ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.GeneratedMethodAccessor196.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.GeneratedMethodAccessor195.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.GeneratedMethodAccessor197.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 101 more
');
INSERT INTO "SYS_LOG" VALUES ('ac2615b97cef4753a61d114bb69a1b4b', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:00:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('2e8b6a0fc17d40ecacfae70b4b1a46ae', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:00:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('70fd661cbb10496d89d1796084c70166', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:00:53', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5c94b68b24154208b8355156c0024f27', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:00:54', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('a725b784328e4f2dac2103132e1b459f', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:01:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('72cf0b1b866e4efba20cbfbaa5d4b81e', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:01:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c9c07c038d89424c9e4f323c6c1cde66', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:03:20', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023400462&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01,2017-09-09&query.createDate||between=2017-09-01,2017-09-09', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date BETWEEN ? AND ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.GeneratedMethodAccessor196.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.GeneratedMethodAccessor195.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.GeneratedMethodAccessor197.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 101 more
');
INSERT INTO "SYS_LOG" VALUES ('90c34e7d620d43f0ab72137209ebde36', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:04:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505023442411&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01,2017-09-09&query.createDate||between=2017-09-01,2017-09-09', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date BETWEEN ? AND ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.GeneratedMethodAccessor196.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.GeneratedMethodAccessor195.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor68.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.GeneratedMethodAccessor197.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 101 more
');
INSERT INTO "SYS_LOG" VALUES ('367f2bbd3c6e4e089e95ab205a0410e4', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:59:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8f378872e4414a3ca82eab0169315c21', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:59:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('efa10b79b9d9488785dd3fc47e1071a3', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:59:49', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c8ebf479f649445d9c7c8976a5bced33', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:00:10', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9328487160fc4d159fd6606427005158', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:00:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ca831ad4b9754072abc773a46206fcfe', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:00:46', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ad418f230d3747fca3927b7f2a1f75c8', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:00:48', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('367900d1e0fc41df8bf5f00fa0511887', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:00:56', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('596e02b1a221443f9d412cf1b5481ed9', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:01:21', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('656f6de32adc4a89adce64d5538b7d01', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:01:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b87f63f00fae4793b516f86e6bcccece', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:01:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('e330477c829a4859aa5ea2e14aaa3906', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:20:40', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('77f62a53b25c4fd7a466cdaf83538460', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:20:43', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b5f93c77e1ed4adf8b4097f897a3eb57', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:22:23', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b1e8e18407f1457989277187584fa399', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:22:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('1357073e4211484a9f98e9708f5683b1', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:22:30', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ab042fd1f8f84087825364915dd242d0', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,title,createBy.realname,createBy.username,requestUri,method,remoteAddr,createDate,&_search=false&nd=1505024319582&page.size=10&page.pn=1&sort=createDate&order=desc&createDate=2017-09-01,2017-09-30&query.createDate||between=2017-09-01,2017-09-30', 'org.springframework.jdbc.BadSqlGrammarException: 
### Error querying database.  Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

### The error may exist in file [D:\Workspaces\idea\jeeweb-mybatis\target\jeeweb-mybatis\WEB-INF\classes\mappings\modules\sys\LogMapper.xml]
### The error may involve defaultParameterMap
### The error occurred while setting parameters
### SQL: select            t.id,      t.type,      t.title,      t.content,      t.logtype,      t.create_by as "createBy.id",      t.create_date,      t.remote_addr,      t.user_agent,      t.request_uri,      t.method,     t.params,      t.exception,     u.realname as "createBy.realname",     u.username as "createBy.username"         from sys_log t     LEFT JOIN sys_user u on t.create_by=u.id      WHERE  (create_date BETWEEN ? AND ? AND 1 = ?) ORDER BY create_date DESC
### Cause: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

; bad SQL grammar []; nested exception is java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at org.springframework.jdbc.support.SQLExceptionSubclassTranslator.doTranslate(SQLExceptionSubclassTranslator.java:95)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:73)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:81)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:73)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:446)
	at com.sun.proxy.$Proxy13.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:238)
	at org.apache.ibatis.binding.MapperMethod.executeForMany(MapperMethod.java:135)
	at org.apache.ibatis.binding.MapperMethod.execute(MapperMethod.java:75)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:59)
	at com.sun.proxy.$Proxy63.selectLogPage(Unknown Source)
	at cn.jeeweb.modules.sys.service.impl.LogServiceImpl.selectPage(LogServiceImpl.java:19)
	at cn.jeeweb.core.common.service.impl.CommonServiceImpl.list(CommonServiceImpl.java:38)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:317)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:190)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:157)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:98)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:262)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:95)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:179)
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:207)
	at com.sun.proxy.$Proxy64.list(Unknown Source)
	at cn.jeeweb.core.common.controller.BaseCRUDController.ajaxList(BaseCRUDController.java:101)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
Caused by: java.sql.SQLSyntaxErrorException: ORA-00918: 未明确定义列

	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:439)
	at oracle.jdbc.driver.T4CTTIoer.processError(T4CTTIoer.java:395)
	at oracle.jdbc.driver.T4C8Oall.processError(T4C8Oall.java:802)
	at oracle.jdbc.driver.T4CTTIfun.receive(T4CTTIfun.java:436)
	at oracle.jdbc.driver.T4CTTIfun.doRPC(T4CTTIfun.java:186)
	at oracle.jdbc.driver.T4C8Oall.doOALL(T4C8Oall.java:521)
	at oracle.jdbc.driver.T4CPreparedStatement.doOall8(T4CPreparedStatement.java:205)
	at oracle.jdbc.driver.T4CPreparedStatement.executeForDescribe(T4CPreparedStatement.java:861)
	at oracle.jdbc.driver.OracleStatement.executeMaybeDescribe(OracleStatement.java:1145)
	at oracle.jdbc.driver.OracleStatement.doExecuteWithTimeout(OracleStatement.java:1267)
	at oracle.jdbc.driver.OraclePreparedStatement.executeInternal(OraclePreparedStatement.java:3449)
	at oracle.jdbc.driver.OraclePreparedStatement.execute(OraclePreparedStatement.java:3550)
	at oracle.jdbc.driver.OraclePreparedStatementWrapper.execute(OraclePreparedStatementWrapper.java:1374)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2929)
	at com.alibaba.druid.filter.FilterEventAdapter.preparedStatement_execute(FilterEventAdapter.java:440)
	at com.alibaba.druid.filter.FilterChainImpl.preparedStatement_execute(FilterChainImpl.java:2927)
	at com.alibaba.druid.proxy.jdbc.PreparedStatementProxyImpl.execute(PreparedStatementProxyImpl.java:118)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:493)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:63)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at sun.reflect.GeneratedMethodAccessor70.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:63)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at sun.reflect.GeneratedMethodAccessor70.invoke(Unknown Source)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.plugins.PerformanceInterceptor.intercept(PerformanceInterceptor.java:123)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at com.sun.proxy.$Proxy108.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:324)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:109)
	at org.apache.ibatis.executor.CachingExecutor.query(CachingExecutor.java:83)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:148)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:433)
	... 103 more
');
INSERT INTO "SYS_LOG" VALUES ('11cbb93eb0eb4da8b8dedf6898cafd48', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('586516accdb043e69c2a1bc396d31043', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:42', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9bf070a3b1f94afab6ef17f36e12b412', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:43', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3315db617ce14b408966852bb36e7a92', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:18:44', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('62c877806b7b4f4e9fea8ccbec5d2a70', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:01', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4cdb8c4642df40539d420655e6448538', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9841fad0bdc34f3f9a0d4b41570d65e4', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:02', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8696a649b2064853af8f715d331b362b', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:03', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7d912c79f1514c2b8050e61a6408638b', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:04', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('7c6b157e084f4c71bd6b5fb59d187c55', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:04', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9038bdd3e130417d930d7a7751ecab00', '1', '系统监控-在线用户', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:04', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/online', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('db0110c949bc42028cccd8abfdf0673a', '1', '系统监控-数据库监控', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/monitor/druid', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ddf82bfe99974e91bef0577988770851', '1', '系统监控-附件信息', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:05', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/attachment', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5cfd9a553c8840908f3d40f98ebfe6a2', '1', '系统监控-系统日志', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:20:06', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/log', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3c26007f1e244e968a341aef770236b8', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:29:58', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('0b7adbd489c543be9a980d1bdb1144a2', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:36:00', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('eac61ecd03034ca1b045740f113746c3', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:38:31', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b0bf47b878904a9e8ce9e495c292be0c', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:42:07', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('434064f39b2f48cd90fc862ddad8b6a8', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('c66787592d7c4489a4327f3a9037a570', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:34', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('086bd1822dc64efdacacd4097bbf5b43', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,orderno,money,orderdate,&_search=false&nd=1505026535116&page.size=10&page.pn=1&sort=id&order=asc', 'java.lang.NullPointerException
	at cn.jeeweb.modules.test.controller.TestOrderMainController.ajaxList(TestOrderMainController.java:78)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('f02078e410ea4d2e87729334f3553bf4', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('8a0d7f863f8340398054d76b5fd6cb24', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:39', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,name,testdate,&_search=false&nd=1505026539829&page.size=10&page.pn=1&sort=id&order=asc', 'java.lang.NullPointerException
	at cn.jeeweb.modules.test.controller.SingleTableController.ajaxList(SingleTableController.java:70)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('97b6765262a9438ca2326f9b8b53d381', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5aa8aaea14684612bb3aa99fd266c4f2', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:50', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree/ajaxTreeList', 'POST', 'gridtype=jqgrid&async=1&queryFields=id,name,&_search=false&nd=1505026550664&page.size=10000&page.pn=1&sort=id&order=asc', 'java.lang.NullPointerException
	at cn.jeeweb.modules.test.controller.TestTreeController.ajaxTreeList(TestTreeController.java:132)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('0987333a9013427189eee0d7b5514e68', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:51', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b4523b6d5e364577a4fcbffe29956499', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable/ajaxList', 'POST', 'gridtype=jqgrid&queryFields=id,name,testdate,&_search=false&nd=1505026552131&page.size=10&page.pn=1&sort=id&order=asc', 'java.lang.NullPointerException
	at cn.jeeweb.modules.test.controller.SingleTableController.ajaxList(SingleTableController.java:70)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('87718b6e621b47bbbd0a46e0ec41fd2c', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('5a2d9e6c34b24ae69948c24c613b2967', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:55:52', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree/ajaxTreeList', 'POST', 'gridtype=jqgrid&async=1&queryFields=id,name,&_search=false&nd=1505026552830&page.size=10000&page.pn=1&sort=id&order=asc', 'java.lang.NullPointerException
	at cn.jeeweb.modules.test.controller.TestTreeController.ajaxTreeList(TestTreeController.java:132)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('91fcc46cdfd74acc93a8d5a4e95fd563', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:56:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f0c6d0a5ccd14f289c5c82daabfd15b3', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:56:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree/ajaxTreeList', 'POST', 'gridtype=jqgrid&async=1&queryFields=id,name,&_search=false&nd=1505026576461&page.size=10000&page.pn=1&sort=id&order=asc', 'java.lang.NullPointerException
	at cn.jeeweb.modules.test.controller.TestTreeController.ajaxTreeList(TestTreeController.java:132)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('780b15afbfbd4bbda0a7e97dd811dfb5', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:56:19', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree/ajaxTreeList', 'POST', 'gridtype=jqgrid&async=1&queryFields=id,name,&_search=false&nd=1505026579887&page.size=10000&page.pn=1&sort=id&order=asc', 'java.lang.NullPointerException
	at cn.jeeweb.modules.test.controller.TestTreeController.ajaxTreeList(TestTreeController.java:132)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('c4f1370e8a9941c2b03166579822a3c2', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:56:22', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree/ajaxTreeList', 'GET', 'gridtype=jqgrid&async=1', 'java.lang.NullPointerException
	at cn.jeeweb.core.query.resolver.PageableMethodArgumentResolver.resolveArgument(PageableMethodArgumentResolver.java:162)
	at cn.jeeweb.core.query.resolver.QueryMethodArgumentResolver.resolveArgument(QueryMethodArgumentResolver.java:114)
	at org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:79)
	at org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:157)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:124)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:852)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:624)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('33ca6752642c40b0a808da052bc570ae', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:57:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree/ajaxTreeList', 'POST', 'gridtype=jqgrid&async=1&queryFields=id,name,&_search=false&nd=1505026616621&page.size=10000&page.pn=1&sort=id&order=asc', 'java.lang.NullPointerException
	at cn.jeeweb.modules.test.controller.TestTreeController.ajaxTreeList(TestTreeController.java:132)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('23dde462b75745f789edfedd93df050e', '2', null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:57:35', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree/ajaxTreeList', 'POST', 'gridtype=jqgrid&async=1&queryFields=id,name,&_search=false&nd=1505026634906&page.size=10000&page.pn=1&sort=id&order=asc', 'java.lang.NullPointerException
	at cn.jeeweb.modules.test.controller.TestTreeController.ajaxTreeList(TestTreeController.java:132)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
	at org.springframework.web.method.support.InvocableHandlerMethod.invoke(InvocableHandlerMethod.java:215)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:132)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:104)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandleMethod(RequestMappingHandlerAdapter.java:749)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:689)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:83)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:938)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:870)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:961)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:863)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:650)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:837)
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:731)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:303)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:52)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.obtainContent(SiteMeshFilter.java:129)
	at com.opensymphony.sitemesh.webapp.SiteMeshFilter.doFilter(SiteMeshFilter.java:77)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at com.alibaba.druid.support.http.WebStatFilter.doFilter(WebStatFilter.java:140)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:61)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AdviceFilter.executeChain(AdviceFilter.java:108)
	at org.apache.shiro.web.servlet.AdviceFilter.doFilterInternal(AdviceFilter.java:137)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.apache.shiro.web.servlet.ProxiedFilterChain.doFilter(ProxiedFilterChain.java:66)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.executeChain(AbstractShiroFilter.java:449)
	at org.apache.shiro.web.servlet.AbstractShiroFilter$1.call(AbstractShiroFilter.java:365)
	at org.apache.shiro.subject.support.SubjectCallable.doCall(SubjectCallable.java:90)
	at org.apache.shiro.subject.support.SubjectCallable.call(SubjectCallable.java:83)
	at org.apache.shiro.subject.support.DelegatingSubject.execute(DelegatingSubject.java:383)
	at org.apache.shiro.web.servlet.AbstractShiroFilter.doFilterInternal(AbstractShiroFilter.java:362)
	at org.apache.shiro.web.servlet.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:125)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:344)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:261)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:88)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:108)
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:241)
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:208)
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:218)
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:110)
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:506)
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:169)
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:103)
	at org.apache.catalina.valves.AccessLogValve.invoke(AccessLogValve.java:962)
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:116)
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:452)
	at org.apache.coyote.http11.AbstractHttp11Processor.process(AbstractHttp11Processor.java:1087)
	at org.apache.coyote.AbstractProtocol$AbstractConnectionHandler.process(AbstractProtocol.java:637)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.doRun(AprEndpoint.java:2536)
	at org.apache.tomcat.util.net.AprEndpoint$SocketProcessor.run(AprEndpoint.java:2525)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:745)
');
INSERT INTO "SYS_LOG" VALUES ('20606c31c328454d80597bbca1b8dff1', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:04:24', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('b02a1dfa27294ae9a711c4730de803d9', '1', '系统设置-用户管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:04:27', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/user', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('950f91a187d640b7b645cb32aef4d3a5', '1', '系统设置-部门管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:04:28', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/organization', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('ada45d844c3f4042b2ae2737ebb8eb32', '1', '系统设置-菜单管理', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:04:29', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/sys/menu', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('4cae1f2b38644fce91464edee928611a', '1', '代码生成器-表单配置', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:05:15', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/codegen/table', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('3481af20c7194b24bb6dabc5fd1a6678', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:05:16', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('f0dd0d6176ce48e6aa0a00da7d206f66', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:05:17', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('9fbd03dfcd5a4e4d968b2f116202dc99', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:05:18', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('479665cc57c4456a92acbfe4aa1c84eb', '1', '代码生成器-生成案列-一对多', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:17:11', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testordermain', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('48d1bf406f99440c9cc7f46299f89593', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:17:12', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('fe7a69f0709447d1976184e7cca3ad8a', '1', '代码生成器-生成案列-测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:17:13', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/testtree', 'GET', null, null);
INSERT INTO "SYS_LOG" VALUES ('01e59fc3d35d441e851363030d9fe382', '1', '代码生成器-生成案列-测试单表', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:17:14', 'YYYY-MM-DD HH24:MI:SS'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36', '/admin/test/singletable', 'GET', null, null);

-- ----------------------------
-- Table structure for SYS_MENU
-- ----------------------------
DROP TABLE "SYS_MENU";
CREATE TABLE "SYS_MENU" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"NAME" VARCHAR2(100 CHAR) NULL ,
"TYPE" VARCHAR2(50 CHAR) NULL ,
"URL" VARCHAR2(200 CHAR) NULL ,
"PARENT_ID" VARCHAR2(32 CHAR) NULL ,
"PARENT_IDS" VARCHAR2(1000 CHAR) NULL ,
"PERMISSION" VARCHAR2(100 CHAR) NULL ,
"ISSHOW" NUMBER(3) DEFAULT '0'  NULL ,
"SORT" NUMBER(10) NULL ,
"MENU_ICON" VARCHAR2(255 CHAR) NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" CHAR(1 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_MENU" IS '菜单';
COMMENT ON COLUMN "SYS_MENU"."NAME" IS '资源路径';
COMMENT ON COLUMN "SYS_MENU"."TYPE" IS '资源类型';
COMMENT ON COLUMN "SYS_MENU"."URL" IS '点击后前往的地址';
COMMENT ON COLUMN "SYS_MENU"."PARENT_ID" IS '父编号';
COMMENT ON COLUMN "SYS_MENU"."PARENT_IDS" IS '父编号列表';
COMMENT ON COLUMN "SYS_MENU"."PERMISSION" IS '权限字符串';
COMMENT ON COLUMN "SYS_MENU"."ISSHOW" IS '是否显示';
COMMENT ON COLUMN "SYS_MENU"."SORT" IS '排序';
COMMENT ON COLUMN "SYS_MENU"."MENU_ICON" IS '图标';
COMMENT ON COLUMN "SYS_MENU"."REMARKS" IS '摘要';

-- ----------------------------
-- Records of SYS_MENU
-- ----------------------------
INSERT INTO "SYS_MENU" VALUES ('40281e815beda90f015bedcf7102000f', '计划任务', null, 'task/schedulejob', '40288ab85cf8276b015cf82debcb005b', '40288ab85cf8276b015cf82debcb005b/', 'task:schedulejob:list', '1', '4', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c097acf015c097bcaea0000', '用户最后在线情况', null, 'sys/lastOnline', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'sys:userlastonline', '1', '2', null, '用户最后在线情况', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c547c32015c54a21e260038', '生成案列', null, ' ', '4028ea815a78e9e6015a78f1dc9d0000', '4028ea815a78e9e6015a78f1dc9d0000/', ' ', '1', '3', null, '生成案列', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c54d147015c54daf16c0001', '系统日志', null, 'sys/log', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'sys:log', '1', '6', 'fa-book', '系统日志', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c580ea3015c58c8635d0037', '测试单表', null, 'test/singletable', '40281e815c547c32015c54a21e260038', '4028ea815a78e9e6015a78f1dc9d0000/40281e815c547c32015c54a21e260038/', 'test:singletable', '1', '1', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c880c25015c880d29870001', '短信发送', null, 'sms/send/sms', '40288ab85c8593cd015c859f47960016', '40288ab85c8593cd015c859f47960016/', 'sms:send', '1', '3', null, '短信发送', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c8f3512015c8f41cea7001b', '发送日志', null, 'email/emailsendlog', '40288ab85bea9452015beaa7f25a0000', '40288ab85bea9452015beaa7f25a0000/', 'email:emailsendlog', '1', '4', null, '发送日志', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c8f3512015c8f4233fc001c', '邮件模版', null, 'email/emailtemplate', '40288ab85bea9452015beaa7f25a0000', '40288ab85bea9452015beaa7f25a0000/', 'email:emailtemplate', '1', '3', null, '模板配置', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c8f3512015c8f5cc7220040', '邮件发送', null, 'email/send/email', '40288ab85bea9452015beaa7f25a0000', '40288ab85bea9452015beaa7f25a0000/', 'email:send', '1', '2', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c912406015c9149f7b80044', '通知公告', null, ' ', null, null, ' ', '1', '5', 'fa-television', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815c912406015c914a1bc30045', '通知公告', null, 'oa/oanotification', '40281e815c912406015c9149f7b80044', '40281e815c912406015c9149f7b80044/', 'oa:oanotification', '1', '1', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40281e815cef1f76015cef268ff0000e', '测试树', null, 'test/testtree', '40281e815c547c32015c54a21e260038', '4028ea815a78e9e6015a78f1dc9d0000/40281e815c547c32015c54a21e260038/', 'test:testtree', '1', '1', null, '测试树', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:12:43', 'YYYY-MM-DD HH24:MI:SS'), '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85a5eecc6015a5ef22ad80001', '系统设置', null, ' ', null, null, ' ', '1', '2', 'fa-gear', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85a5eecc6015a5ef6ce870002', '用户管理', null, 'sys/user', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:user:list', '1', '1', 'fa-tv', 'sdfdsfsdfsdfsdfsdfsf', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85a5eecc6015a5ef8f2890003', '部门管理', null, 'sys/organization', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:organization:list', '1', '2', 'fa-balance-scale', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85a5eecc6015a5ef95c700004', '角色管理', null, 'sys/role', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:role:list', '1', '3', 'fa-amazon', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85a5eecc6015a5ef9f6160005', '菜单管理', null, 'sys/menu', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:menu:list', '1', '4', 'fa-balance-scale', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85a5eecc6015a5efaa75d0006', '数据字典', null, 'sys/dict/group', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:dict:list', '1', '5', 'fa-amazon', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85b604adf015b605023a70000', '在线用户', null, 'sys/online', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'sys:online:list', '1', '1', null, '在线用户', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85bea9452015beaa7f25a0000', '邮箱设置', null, ' ', null, null, ' ', '1', '5', 'fa-envelope', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85bea9452015beaa846180001', '参数设置', null, 'sys/setting/email', '40288ab85bea9452015beaa7f25a0000', '40288ab85bea9452015beaa7f25a0000/', 'sys:setting:email', '1', null, null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85bea9452015beaa9e7a70002', '参数配置', null, 'sys/setting/sms', '40288ab85c8593cd015c859f47960016', '40288ab85c8593cd015c859f47960016/', 'sys:setting:sms', '1', '1', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85befd65a015bf088333a0015', '多数据源管理', null, 'sys/datasource', '40288ab85cf8276b015cf82debcb005b', '40288ab85cf8276b015cf82debcb005b/', 'sys:datasource:list', '1', '5', null, '动态数据源', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c1ae76c015c1b12b68a0000', '代码案例', null, ' ', null, null, ' ', '1', '12', 'fa-code', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c1ae76c015c1b1316680001', '编辑器', null, 'demo/form/editor', '40288ab85c1ae76c015c1b12b68a0000', '40288ab85c1ae76c015c1b12b68a0000/', ' ', '1', '1', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c1e2442015c1e3246b70000', '文件上传', null, 'demo/form/upload', '40288ab85c1ae76c015c1b12b68a0000', '40288ab85c1ae76c015c1b12b68a0000/', ' ', '1', '2', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c33548d015c33cdc5a600f3', '附件信息', null, 'sys/attachment', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'sys:attachment:list', '1', '5', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c3df6b7015c3e3d1e770000', '搜索自动补全', null, 'demo/form/combox', '40288ab85c1ae76c015c1b12b68a0000', '40288ab85c1ae76c015c1b12b68a0000/', ' ', '1', '3', 'fa-500px', '测试菜单', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c8593cd015c859f47960016', '短信设置', null, ' ', null, null, ' ', '1', '6', 'fa-comments', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c8593cd015c859fa3240017', '短信模版', null, 'sms/smstemplate', '40288ab85c8593cd015c859f47960016', '40288ab85c8593cd015c859f47960016/', 'sms:smstemplate', '1', '3', null, '短信模版', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c85fa54015c860cee2e0023', '发送日志', null, 'sms/smssendlog', '40288ab85c8593cd015c859f47960016', '40288ab85c8593cd015c859f47960016/', 'sms:smssendlog', '1', '4', null, '短信发送日志', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f4d1f8e0000', '统计报表', null, ' ', null, null, ' ', '1', '10', 'fa-bar-chart', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f4e1cd00001', '折线图', null, '/charts/echarts/chart/line', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85c9eeb5c015c9f4d1f8e0000/', ' ', '1', '1', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f5fa02e002a', '柱状图', null, '/charts/echarts/chart/bar', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85c9eeb5c015c9f4d1f8e0000/', ' ', '1', '2', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f626f58002d', '漏斗图', null, '/charts/echarts/chart/funnel', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85c9eeb5c015c9f4d1f8e0000/', ' ', '1', '5', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f62e726002e', '仪表盘', null, '/charts/echarts/chart/gauge', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85c9eeb5c015c9f4d1f8e0000/', ' ', '1', '6', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f6390fd002f', 'K线图', null, '/charts/echarts/chart/k', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85c9eeb5c015c9f4d1f8e0000/', ' ', '1', '7', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f6572630030', '饼状图', null, '/charts/echarts/chart/pie', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85c9eeb5c015c9f4d1f8e0000/', ' ', '1', '7', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f65e3a50031', '雷达图', null, '/charts/echarts/chart/radar', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85c9eeb5c015c9f4d1f8e0000/', ' ', '1', '9', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f672f2e0032', '散点图', null, '/charts/echarts/chart/scatter', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85c9eeb5c015c9f4d1f8e0000/', ' ', '1', '9', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85c9eeb5c015c9f9694480064', '关系图', null, '/charts/echarts/chart/circular', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85c9eeb5c015c9f4d1f8e0000/', ' ', '1', '11', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85cf81b04015cf8213da10002', '一对多', null, 'test/testordermain', '40281e815c547c32015c54a21e260038', '4028ea815a78e9e6015a78f1dc9d0000/40281e815c547c32015c54a21e260038/', 'test:testordermain', '1', '1', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('40288ab85cf8276b015cf82debcb005b', '常见工具', null, ' ', null, null, ' ', '1', '4', 'fa-binoculars', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('4028ea815a701416015a7075b4f9001f', '系统监控', null, ' ', null, null, ' ', '1', '3', 'fa-video-camera', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('4028ea815a701416015a70766a7a0020', '数据库监控', null, 'monitor/druid', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'monitor:druid:index', '1', '3', null, ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('4028ea815a78e9e6015a78f1dc9d0000', '代码生成器', null, ' ', null, null, ' ', '1', '1', 'fa-file-code-o', ' ', null, null, null, null, '0');
INSERT INTO "SYS_MENU" VALUES ('4028ea815a78e9e6015a78f35cbe0001', '表单配置', null, 'codegen/table', '4028ea815a78e9e6015a78f1dc9d0000', '4028ea815a78e9e6015a78f1dc9d0000/', 'codegen:table:list', '1', '1', null, ' ', null, null, null, null, '0');

-- ----------------------------
-- Table structure for SYS_ORGANIZATION
-- ----------------------------
DROP TABLE "SYS_ORGANIZATION";
CREATE TABLE "SYS_ORGANIZATION" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"NAME" VARCHAR2(100 CHAR) NULL ,
"PARENT_ID" VARCHAR2(32 CHAR) NULL ,
"PARENT_IDS" VARCHAR2(1000 CHAR) NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" CHAR(1 CHAR) NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_ORGANIZATION" IS '组织结构';
COMMENT ON COLUMN "SYS_ORGANIZATION"."NAME" IS '机构名称';
COMMENT ON COLUMN "SYS_ORGANIZATION"."PARENT_ID" IS '父节点';
COMMENT ON COLUMN "SYS_ORGANIZATION"."PARENT_IDS" IS '父节点路径';
COMMENT ON COLUMN "SYS_ORGANIZATION"."DEL_FLAG" IS '删除标记';

-- ----------------------------
-- Records of SYS_ORGANIZATION
-- ----------------------------
INSERT INTO "SYS_ORGANIZATION" VALUES ('40288ab85b6080e1015b60996d690005', '数立行', null, null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:12:11', 'YYYY-MM-DD HH24:MI:SS'), '0', null);
INSERT INTO "SYS_ORGANIZATION" VALUES ('4028ea815a452f69015a45346f7b0001', '研发部', '40288ab85b6080e1015b60996d690005', '40288ab85b6080e1015b60996d690005/', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-08 10:12:06', 'YYYY-MM-DD HH24:MI:SS'), '0', null);

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE "SYS_ROLE";
CREATE TABLE "SYS_ROLE" (
"ID" VARCHAR2(64 CHAR) NOT NULL ,
"NAME" VARCHAR2(100 CHAR) NOT NULL ,
"CODE" VARCHAR2(255 CHAR) NULL ,
"IS_SYS" VARCHAR2(64 CHAR) NULL ,
"USABLE" VARCHAR2(64 CHAR) NULL ,
"CREATE_BY" VARCHAR2(64 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(64 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"DEL_FLAG" CHAR(1 CHAR) DEFAULT '0'  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_ROLE" IS '角色';
COMMENT ON COLUMN "SYS_ROLE"."ID" IS '编号';
COMMENT ON COLUMN "SYS_ROLE"."NAME" IS '角色名称';
COMMENT ON COLUMN "SYS_ROLE"."CODE" IS '英文名称';
COMMENT ON COLUMN "SYS_ROLE"."IS_SYS" IS '是否系统数据';
COMMENT ON COLUMN "SYS_ROLE"."USABLE" IS '是否可用';
COMMENT ON COLUMN "SYS_ROLE"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "SYS_ROLE"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "SYS_ROLE"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "SYS_ROLE"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "SYS_ROLE"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "SYS_ROLE"."DEL_FLAG" IS '删除标记';

-- ----------------------------
-- Records of SYS_ROLE
-- ----------------------------
INSERT INTO "SYS_ROLE" VALUES ('05ed619984ed41dcba530d793ca9dd2f', '系统管理员', 'admin', '1', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:12:21', 'YYYY-MM-DD HH24:MI:SS'), null, null, '系统管理员', '0');
INSERT INTO "SYS_ROLE" VALUES ('4c386106f94b474985e1893a37372433', '普通用户', 'normal', '1', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-07 17:12:37', 'YYYY-MM-DD HH24:MI:SS'), null, null, '普通用户', '0');

-- ----------------------------
-- Table structure for SYS_ROLE_MENU
-- ----------------------------
DROP TABLE "SYS_ROLE_MENU";
CREATE TABLE "SYS_ROLE_MENU" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"MENU_ID" VARCHAR2(32 CHAR) NOT NULL ,
"ROLE_ID" VARCHAR2(32 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_ROLE_MENU" IS '角色-菜单';
COMMENT ON COLUMN "SYS_ROLE_MENU"."ID" IS '编号';
COMMENT ON COLUMN "SYS_ROLE_MENU"."MENU_ID" IS '菜单编号';
COMMENT ON COLUMN "SYS_ROLE_MENU"."ROLE_ID" IS '角色编号';

-- ----------------------------
-- Records of SYS_ROLE_MENU
-- ----------------------------
INSERT INTO "SYS_ROLE_MENU" VALUES ('2a12bb13dad8478e85c1dd7af012f915', '40288ab85c9eeb5c015c9f4d1f8e0000', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('bec31dde436b41769cbdca65900624b7', '40288ab85c9eeb5c015c9f9694480064', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('9af3f51851eb4fe491e2536537cef5d5', '40288ab85c9eeb5c015c9f672f2e0032', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('394f8db7923b4dea8e4755101234079f', '40288ab85c9eeb5c015c9f65e3a50031', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('f26a06ebf9a44fdc93e1110721ac065c', '40288ab85c9eeb5c015c9f6572630030', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('280af7e8a6b44aceabe85d479279d693', '40288ab85c9eeb5c015c9f6390fd002f', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('73e693adcacf42a6ab8c42c8f36ef285', '40288ab85c9eeb5c015c9f62e726002e', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('e79fc26a118b494c8662bbf2013cade6', '40288ab85c9eeb5c015c9f626f58002d', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('ada742d7dc464e5dbeeb92e820ada83f', '40288ab85c9eeb5c015c9f5fa02e002a', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('ae2f9271d895400db47ca4cee81e44c5', '40288ab85c9eeb5c015c9f4e1cd00001', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('f3c80aa1a9e14a318438ddf6967d1a5b', '40288ab85c8593cd015c859f47960016', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('ab160675ed2542919a069e1621ca0b3c', '40288ab85c85fa54015c860cee2e0023', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('b53b98b0f72a4f96a55281f863ea7bc5', '40281e815c880c25015c880d29870001', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('3cb488a56d5e4c1681f47ec3def9736f', '40288ab85c8593cd015c859fa3240017', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('591431dc0a2545faa94a0816f1b5af1a', '40288ab85bea9452015beaa9e7a70002', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('c2c802e0a07644de9b84d546b271276d', '40288ab85bea9452015beaa7f25a0000', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('b976b9d94db44aae94d05167fc51621b', '40288ab85bea9452015beaa846180001', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('fe0f95c0e9714f6183b3cf2e2f1983be', '40281e815c8f3512015c8f41cea7001b', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('28765be8e46e48c5b78782864781a4f1', '40281e815c8f3512015c8f4233fc001c', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('07ad878b0fe04f9d898a610f274992f9', '40281e815c8f3512015c8f5cc7220040', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('baccc329626e4aefaebd336bdc9db41c', '40281e815c912406015c9149f7b80044', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('cf9d17812d3b4295bf00f17e1bed012a', '40281e815c912406015c914a1bc30045', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('d5988d6ca73d4fb19d6388b1db56ed34', '40288ab85cf8276b015cf82debcb005b', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('8aaa270b13c046dc90dd363b924db310', '40288ab85befd65a015bf088333a0015', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('36d14292171a45f6ac9d6b6b85c283af', '40281e815beda90f015bedcf7102000f', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('0d6aa1f88c6744de85ecf7c5f21bdaac', '4028ea815a701416015a7075b4f9001f', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('5bc6455411544685911cec599d662249', '40281e815c54d147015c54daf16c0001', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('7166d2a9d5f9426a8ebf7af4ae609bc3', '40288ab85c33548d015c33cdc5a600f3', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('385ddeb78c02440f8abca40d0cf25d95', '4028ea815a701416015a70766a7a0020', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('8b4447785f45422ca192f881eae5f938', '40288ab85b604adf015b605023a70000', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('abc901c586f442c79b7d5251738c1da6', '40288ab85a5eecc6015a5ef22ad80001', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('9ef8caac5bc34d2db27e86100da20ac3', '40288ab85a5eecc6015a5efaa75d0006', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('2c328bc3d1d04e40ae11c96f7a764448', '40288ab85a5eecc6015a5ef9f6160005', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('1447437a21a74b24a289411744dcee0e', '40288ab85a5eecc6015a5ef95c700004', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('cdd857cbb0db4782be176bc3eab7af82', '40288ab85a5eecc6015a5ef8f2890003', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('824dd5c6682740eb81f85bff3e539665', '40288ab85a5eecc6015a5ef6ce870002', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('ce698e25cd5246b8a70098df6e3dfb4c', '4028ea815a78e9e6015a78f1dc9d0000', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('9b9a5fb21d61456fae5cd0a799fd91fb', '40281e815c547c32015c54a21e260038', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('f577bc82b3ca424689f46a8e8bdba009', '40281e815c580ea3015c58c8635d0037', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('4a7c37c22bfb4b6ba66331aa02c843cc', '40281e815cef1f76015cef268ff0000e', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('55e3e05a7ddc4eefae28d3caea849be2', '40288ab85cf81b04015cf8213da10002', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('362bb8341ea949fa8ebbb1d61ce72851', '4028ea815a78e9e6015a78f35cbe0001', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('42402dbab98641d8b98637fdd08e7456', '40288ab85c1ae76c015c1b12b68a0000', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('9efe67fb0052407eb9a03a6b8c048082', '40288ab85c3df6b7015c3e3d1e770000', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('46d024b6e38444a792e13556b0e9af23', '40288ab85c1e2442015c1e3246b70000', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_ROLE_MENU" VALUES ('d8242bc0e7fa4a2a8fd9415c4f4a08b3', '40288ab85c1ae76c015c1b1316680001', '05ed619984ed41dcba530d793ca9dd2f');

-- ----------------------------
-- Table structure for SYS_SESSIONS
-- ----------------------------
DROP TABLE "SYS_SESSIONS";
CREATE TABLE "SYS_SESSIONS" (
"ID" VARCHAR2(200 CHAR) NOT NULL ,
"SESSION_" VARCHAR2(2000 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_SESSIONS
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE "SYS_USER";
CREATE TABLE "SYS_USER" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"REALNAME" VARCHAR2(255 CHAR) NULL ,
"USERNAME" VARCHAR2(100 CHAR) NOT NULL ,
"PORTRAIT" VARCHAR2(250 CHAR) NULL ,
"PASSWORD" VARCHAR2(100 CHAR) NULL ,
"SALT" VARCHAR2(100 CHAR) NULL ,
"EMAIL" VARCHAR2(20 CHAR) NULL ,
"PHONE" VARCHAR2(20 CHAR) NULL ,
"STATUS" VARCHAR2(255 CHAR) NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"DEL_FLAG" CHAR(1 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_USER" IS '用户';
COMMENT ON COLUMN "SYS_USER"."ID" IS '主键';
COMMENT ON COLUMN "SYS_USER"."REALNAME" IS '真实名称';
COMMENT ON COLUMN "SYS_USER"."USERNAME" IS '用户名';
COMMENT ON COLUMN "SYS_USER"."PORTRAIT" IS '头像';
COMMENT ON COLUMN "SYS_USER"."PASSWORD" IS '密码';
COMMENT ON COLUMN "SYS_USER"."EMAIL" IS '邮件';
COMMENT ON COLUMN "SYS_USER"."PHONE" IS '联系电话';
COMMENT ON COLUMN "SYS_USER"."STATUS" IS '系统用户的状态';

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO "SYS_USER" VALUES ('40288ab85ce3c20a015ce3ca6df60000', '测试用户', 'test', null, '947bae5be3028b93fce10e38e56500f5', 'fb58966ee87eb054165fe59d033f436d', 'test@qq.com', '15085980308', '1', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');
INSERT INTO "SYS_USER" VALUES ('4028ea815a3d2a8c015a3d2f8d2a0002', '系统管理员', 'admin', 'upload/2017/09/10/1505023070932.png', 'ae8b5fbb3b5496c87b52fab896db7830', '78cb8d7012d98c91f98963e803fe68bd', 'test2@qq.com', '14785571304', '1', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-26 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), null, '0');

-- ----------------------------
-- Table structure for SYS_USER_LAST_ONLINE
-- ----------------------------
DROP TABLE "SYS_USER_LAST_ONLINE";
CREATE TABLE "SYS_USER_LAST_ONLINE" (
"ID" NUMBER(24) NOT NULL ,
"USER_ID" NUMBER(24) NULL ,
"USERNAME" VARCHAR2(100 CHAR) NULL ,
"UID_" VARCHAR2(100 CHAR) NULL ,
"HOST" VARCHAR2(100 CHAR) NULL ,
"USER_AGENT" VARCHAR2(200 CHAR) NULL ,
"SYSTEM_HOST" VARCHAR2(100 CHAR) NULL ,
"LAST_LOGIN_TIMESTAMP" DATE NULL ,
"LAST_STOP_TIMESTAMP" DATE NULL ,
"LOGIN_COUNT" NUMBER(24) NULL ,
"TOTAL_ONLINE_TIME" NUMBER(24) NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"DEL_FLAG" CHAR(1 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_USER_LAST_ONLINE
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_USER_ONLINE
-- ----------------------------
DROP TABLE "SYS_USER_ONLINE";
CREATE TABLE "SYS_USER_ONLINE" (
"ID" VARCHAR2(100 CHAR) NOT NULL ,
"USER_ID" VARCHAR2(32 CHAR) NULL ,
"USERNAME" VARCHAR2(100 CHAR) NULL ,
"HOST" VARCHAR2(100 CHAR) NULL ,
"SYSTEM_HOST" VARCHAR2(100 CHAR) NULL ,
"USER_AGENT" VARCHAR2(200 CHAR) NULL ,
"STATUS" VARCHAR2(50 CHAR) NULL ,
"START_TIMESTSAMP" DATE NULL ,
"LAST_ACCESS_TIME" DATE NULL ,
"ONLINE_TIMEOUT" NUMBER(24) NULL ,
"ONLINE_SESSION" CLOB NULL ,
"CREATE_BY" VARCHAR2(32 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"REMARKS" VARCHAR2(255 CHAR) NULL ,
"DEL_FLAG" CHAR(1 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SYS_USER_ONLINE
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_USER_ORGANIZATION
-- ----------------------------
DROP TABLE "SYS_USER_ORGANIZATION";
CREATE TABLE "SYS_USER_ORGANIZATION" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"USER_ID" VARCHAR2(32 CHAR) NOT NULL ,
"ORGANIZATION_ID" VARCHAR2(32 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_USER_ORGANIZATION" IS '用户-部门';
COMMENT ON COLUMN "SYS_USER_ORGANIZATION"."ID" IS '编号';
COMMENT ON COLUMN "SYS_USER_ORGANIZATION"."USER_ID" IS '用户主键';
COMMENT ON COLUMN "SYS_USER_ORGANIZATION"."ORGANIZATION_ID" IS '部门主键';

-- ----------------------------
-- Records of SYS_USER_ORGANIZATION
-- ----------------------------
INSERT INTO "SYS_USER_ORGANIZATION" VALUES ('40281e815cfc4624015cfce005b3006e', '40281e815cfc4624015cfcce3d310029', '4028ea815a452f69015a45346f7b0001');
INSERT INTO "SYS_USER_ORGANIZATION" VALUES ('6324f70c16db4974ac28a94dc716f333', '40288ab85ce3c20a015ce3ca6df60000', '4028ea815a452f69015a45346f7b0001');
INSERT INTO "SYS_USER_ORGANIZATION" VALUES ('40281e815cfc4624015cfcc8c640000e', '40288ab85cf6aab4015cf6ecea890000', '40288ab85c20329e015c2037a7800003');
INSERT INTO "SYS_USER_ORGANIZATION" VALUES ('40281e815cfc4624015cfcc8c641000f', '40288ab85cf6aab4015cf6ecea890000', '40288ab85c20329e015c2037d2090004');
INSERT INTO "SYS_USER_ORGANIZATION" VALUES ('1dd2a4988afd4f279b6cdaf90bb6452f', '4028ea815a3d2a8c015a3d2f8d2a0002', '40288ab85b6080e1015b60996d690005');

-- ----------------------------
-- Table structure for SYS_USER_ROLE
-- ----------------------------
DROP TABLE "SYS_USER_ROLE";
CREATE TABLE "SYS_USER_ROLE" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"USER_ID" VARCHAR2(32 CHAR) NOT NULL ,
"ROLE_ID" VARCHAR2(32 CHAR) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "SYS_USER_ROLE" IS '用户-角色';
COMMENT ON COLUMN "SYS_USER_ROLE"."ID" IS '编号';
COMMENT ON COLUMN "SYS_USER_ROLE"."USER_ID" IS '用户编号';
COMMENT ON COLUMN "SYS_USER_ROLE"."ROLE_ID" IS '角色编号';

-- ----------------------------
-- Records of SYS_USER_ROLE
-- ----------------------------
INSERT INTO "SYS_USER_ROLE" VALUES ('b075d6616fca460e96268d3aa635fdf5', '40288ab85ce3c20a015ce3ca6df60000', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_USER_ROLE" VALUES ('25d408a9baef4270bd9a785b6862bd26', '4028ea815a3d2a8c015a3d2f8d2a0002', '05ed619984ed41dcba530d793ca9dd2f');
INSERT INTO "SYS_USER_ROLE" VALUES ('2e12f71ffc1e474da516376ee19dbd82', '4028ea815a3d2a8c015a3d2f8d2a0002', '05ed619984ed41dcba530d793ca9dd2f');

-- ----------------------------
-- Table structure for TASK_SCHEDULE_JOB
-- ----------------------------
DROP TABLE "TASK_SCHEDULE_JOB";
CREATE TABLE "TASK_SCHEDULE_JOB" (
"ID" VARCHAR2(32 CHAR) NOT NULL ,
"CRON_EXPRESSION" VARCHAR2(255 CHAR) NOT NULL ,
"METHOD_NAME" VARCHAR2(255 CHAR) NOT NULL ,
"IS_CONCURRENT" VARCHAR2(255 CHAR) NULL ,
"DESCRIPTION" VARCHAR2(255 CHAR) NULL ,
"UPDATE_BY" VARCHAR2(64 CHAR) NULL ,
"BEAN_CLASS" VARCHAR2(255 CHAR) NULL ,
"CREATE_DATE" DATE NULL ,
"JOB_STATUS" VARCHAR2(255 CHAR) NULL ,
"JOB_GROUP" VARCHAR2(255 CHAR) NULL ,
"UPDATE_DATE" DATE NULL ,
"CREATE_BY" VARCHAR2(64 CHAR) NULL ,
"SPRING_BEAN" VARCHAR2(255 CHAR) NULL ,
"JOB_NAME" VARCHAR2(255 CHAR) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TASK_SCHEDULE_JOB" IS '计划任务';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."CRON_EXPRESSION" IS 'cron表达式';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."METHOD_NAME" IS '任务调用的方法名';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."IS_CONCURRENT" IS '任务是否有状态';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."DESCRIPTION" IS '任务描述';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."BEAN_CLASS" IS '任务执行时调用哪个类的方法 包名+类名';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."JOB_STATUS" IS '任务状态';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."JOB_GROUP" IS '任务分组';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."SPRING_BEAN" IS 'Spring bean';
COMMENT ON COLUMN "TASK_SCHEDULE_JOB"."JOB_NAME" IS '任务名';

-- ----------------------------
-- Records of TASK_SCHEDULE_JOB
-- ----------------------------
INSERT INTO "TASK_SCHEDULE_JOB" VALUES ('0a363c5f8e814e62b810c8b4010cc3dc', '0/10 * * * * ?', 'run', '1', null, null, 'cn.jeeweb.modules.task.task.TaskTest', null, '0', 'test', null, null, null, 'test');

-- ----------------------------
-- Table structure for TEST_ORDER_CUSTOMER
-- ----------------------------
DROP TABLE "TEST_ORDER_CUSTOMER";
CREATE TABLE "TEST_ORDER_CUSTOMER" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"ORDER_ID" VARCHAR2(32 BYTE) NULL ,
"NAME" VARCHAR2(50 BYTE) NOT NULL ,
"SEX" VARCHAR2(4 BYTE) NOT NULL ,
"PHONE" VARCHAR2(11 BYTE) NOT NULL ,
"REMARKS" VARCHAR2(255 BYTE) NULL ,
"CREATE_BY" VARCHAR2(32 BYTE) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 BYTE) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" VARCHAR2(1 BYTE) DEFAULT '0'  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_ORDER_CUSTOMER" IS '订单客户信息';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."ID" IS '主键';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."ORDER_ID" IS 'order_id';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."NAME" IS '客户姓名';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."SEX" IS '性别';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."PHONE" IS '电话';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "TEST_ORDER_CUSTOMER"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';

-- ----------------------------
-- Records of TEST_ORDER_CUSTOMER
-- ----------------------------
INSERT INTO "TEST_ORDER_CUSTOMER" VALUES ('acc7e600283f479b805bb7c9417490b0', '73a06609f83d47a887e50426bcbf3f12', '汪村建', '女', '14785571304', null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:28:46', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:59:48', 'YYYY-MM-DD HH24:MI:SS'), '0');
INSERT INTO "TEST_ORDER_CUSTOMER" VALUES ('05c7032ddb684074a24f939b69a4f550', '73a06609f83d47a887e50426bcbf3f12', 'auth_team', '男', '15085980308', null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:28:30', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:59:48', 'YYYY-MM-DD HH24:MI:SS'), '0');

-- ----------------------------
-- Table structure for TEST_ORDER_MAIN
-- ----------------------------
DROP TABLE "TEST_ORDER_MAIN";
CREATE TABLE "TEST_ORDER_MAIN" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"ORDERNO" VARCHAR2(50 BYTE) NOT NULL ,
"MONEY" VARCHAR2(22 BYTE) NOT NULL ,
"ORDERDATE" VARCHAR2(19 BYTE) NOT NULL ,
"CREATE_BY" VARCHAR2(32 BYTE) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 BYTE) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" VARCHAR2(1 BYTE) DEFAULT '0'  NOT NULL ,
"REMARKS" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_ORDER_MAIN" IS '测试主表';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."ID" IS '主键';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."ORDERNO" IS '订单号';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."MONEY" IS '订单金额';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."ORDERDATE" IS '订单日期';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "TEST_ORDER_MAIN"."REMARKS" IS '备注信息';

-- ----------------------------
-- Records of TEST_ORDER_MAIN
-- ----------------------------
INSERT INTO "TEST_ORDER_MAIN" VALUES ('73a06609f83d47a887e50426bcbf3f12', '士大夫', '士大夫', '2017-09-10 00:00:00', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:10:57', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:59:48', 'YYYY-MM-DD HH24:MI:SS'), '0', null);

-- ----------------------------
-- Table structure for TEST_ORDER_TICKET
-- ----------------------------
DROP TABLE "TEST_ORDER_TICKET";
CREATE TABLE "TEST_ORDER_TICKET" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"FLTNO" VARCHAR2(50 BYTE) NOT NULL ,
"FLYTIME" DATE NOT NULL ,
"REMARKS" VARCHAR2(255 BYTE) NULL ,
"ORDER_ID" VARCHAR2(32 BYTE) NULL ,
"CREATE_BY" VARCHAR2(32 BYTE) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 BYTE) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" VARCHAR2(1 BYTE) DEFAULT '0'  NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_ORDER_TICKET" IS '订单票据';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."ID" IS '主键';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."FLTNO" IS '航班号';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."FLYTIME" IS '航班时间';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."ORDER_ID" IS 'order_id';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "TEST_ORDER_TICKET"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';

-- ----------------------------
-- Records of TEST_ORDER_TICKET
-- ----------------------------
INSERT INTO "TEST_ORDER_TICKET" VALUES ('091ec767c6264ba3ad0030f2cb46430a', '111', TO_DATE('2017-09-27 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '111', '73a06609f83d47a887e50426bcbf3f12', '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:28:30', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 14:59:48', 'YYYY-MM-DD HH24:MI:SS'), '0');

-- ----------------------------
-- Table structure for TEST_SINGLE_TABLE
-- ----------------------------
DROP TABLE "TEST_SINGLE_TABLE";
CREATE TABLE "TEST_SINGLE_TABLE" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"NAME" VARCHAR2(255 BYTE) NOT NULL ,
"TESTDATE" DATE NOT NULL ,
"CREATE_BY" VARCHAR2(32 BYTE) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 BYTE) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" CHAR(1 BYTE) DEFAULT '0'  NULL ,
"REMARKS" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_SINGLE_TABLE" IS '测试单表';
COMMENT ON COLUMN "TEST_SINGLE_TABLE"."ID" IS '主键';
COMMENT ON COLUMN "TEST_SINGLE_TABLE"."NAME" IS '名称';
COMMENT ON COLUMN "TEST_SINGLE_TABLE"."TESTDATE" IS '时间';
COMMENT ON COLUMN "TEST_SINGLE_TABLE"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "TEST_SINGLE_TABLE"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "TEST_SINGLE_TABLE"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "TEST_SINGLE_TABLE"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "TEST_SINGLE_TABLE"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "TEST_SINGLE_TABLE"."REMARKS" IS '备注信息';

-- ----------------------------
-- Records of TEST_SINGLE_TABLE
-- ----------------------------
INSERT INTO "TEST_SINGLE_TABLE" VALUES ('4f8224d2d0ac48908276f5dc00e905eb', 'eee', TO_DATE('2017-09-05 00:00:00', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 15:17:22', 'YYYY-MM-DD HH24:MI:SS'), null, null, '0', null);

-- ----------------------------
-- Table structure for TEST_TREE
-- ----------------------------
DROP TABLE "TEST_TREE";
CREATE TABLE "TEST_TREE" (
"ID" VARCHAR2(32 BYTE) NOT NULL ,
"NAME" VARCHAR2(100 BYTE) NULL ,
"REMARKS" VARCHAR2(255 BYTE) NULL ,
"CREATE_BY" VARCHAR2(32 BYTE) NULL ,
"CREATE_DATE" DATE NULL ,
"UPDATE_BY" VARCHAR2(32 BYTE) NULL ,
"UPDATE_DATE" DATE NULL ,
"DEL_FLAG" VARCHAR2(1 BYTE) DEFAULT '0'  NOT NULL ,
"PARENT_ID" VARCHAR2(32 BYTE) NULL ,
"PARENT_IDS" VARCHAR2(1000 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;
COMMENT ON TABLE "TEST_TREE" IS '测试树';
COMMENT ON COLUMN "TEST_TREE"."ID" IS '主键';
COMMENT ON COLUMN "TEST_TREE"."NAME" IS '机构名称';
COMMENT ON COLUMN "TEST_TREE"."REMARKS" IS '备注信息';
COMMENT ON COLUMN "TEST_TREE"."CREATE_BY" IS '创建者';
COMMENT ON COLUMN "TEST_TREE"."CREATE_DATE" IS '创建时间';
COMMENT ON COLUMN "TEST_TREE"."UPDATE_BY" IS '更新者';
COMMENT ON COLUMN "TEST_TREE"."UPDATE_DATE" IS '更新时间';
COMMENT ON COLUMN "TEST_TREE"."DEL_FLAG" IS '删除标记（0：正常；1：删除）';
COMMENT ON COLUMN "TEST_TREE"."PARENT_ID" IS '父节点';
COMMENT ON COLUMN "TEST_TREE"."PARENT_IDS" IS '父节点路径';

-- ----------------------------
-- Records of TEST_TREE
-- ----------------------------
INSERT INTO "TEST_TREE" VALUES ('8a9983c0cdf747a4ad6c18ed9cd9b808', '第一级', null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:25', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:47', 'YYYY-MM-DD HH24:MI:SS'), '0', null, null);
INSERT INTO "TEST_TREE" VALUES ('48efccf4fe9d4a4dbe1940605d32925f', '第二级', null, '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:31', 'YYYY-MM-DD HH24:MI:SS'), '4028ea815a3d2a8c015a3d2f8d2a0002', TO_DATE('2017-09-10 11:39:54', 'YYYY-MM-DD HH24:MI:SS'), '0', '8a9983c0cdf747a4ad6c18ed9cd9b808', '8a9983c0cdf747a4ad6c18ed9cd9b808/');

-- ----------------------------
-- Indexes structure for table CODEGEN_COLUMN
-- ----------------------------
CREATE INDEX "CODEGEN_TABLE_COLUMN_DEL_FLAG"
ON "CODEGEN_COLUMN" ("DEL_FLAG" ASC)
LOGGING
VISIBLE;
CREATE INDEX "TABLE_ID"
ON "CODEGEN_COLUMN" ("TABLE_ID" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table CODEGEN_COLUMN
-- ----------------------------
ALTER TABLE "CODEGEN_COLUMN" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "CODEGEN_COLUMN" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "CODEGEN_COLUMN" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "CODEGEN_COLUMN" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CODEGEN_COLUMN
-- ----------------------------
ALTER TABLE "CODEGEN_COLUMN" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CODEGEN_SCHEME
-- ----------------------------
CREATE INDEX "CODEGEN_SCHEME_DEL_FLAG_1"
ON "CODEGEN_SCHEME" ("DEL_FLAG" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table CODEGEN_SCHEME
-- ----------------------------
ALTER TABLE "CODEGEN_SCHEME" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "CODEGEN_SCHEME" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "CODEGEN_SCHEME" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "CODEGEN_SCHEME" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CODEGEN_SCHEME
-- ----------------------------
ALTER TABLE "CODEGEN_SCHEME" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CODEGEN_TABLE
-- ----------------------------
CREATE INDEX "CODEGEN_SCHEME_DEL_FLAG"
ON "CODEGEN_TABLE" ("DEL_FLAG" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table CODEGEN_TABLE
-- ----------------------------
ALTER TABLE "CODEGEN_TABLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "CODEGEN_TABLE" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "CODEGEN_TABLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "CODEGEN_TABLE" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CODEGEN_TABLE
-- ----------------------------
ALTER TABLE "CODEGEN_TABLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table EMAIL_TEMPLATE
-- ----------------------------

-- ----------------------------
-- Checks structure for table EMAIL_TEMPLATE
-- ----------------------------
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("CODE" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("BUSINESS_TYPE" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("TEMPLATE_SUBJECT" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("CODE" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("BUSINESS_TYPE" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("TEMPLATE_SUBJECT" IS NOT NULL);
ALTER TABLE "EMAIL_TEMPLATE" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table EMAIL_TEMPLATE
-- ----------------------------
ALTER TABLE "EMAIL_TEMPLATE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table OA_NOTIFICATION
-- ----------------------------

-- ----------------------------
-- Checks structure for table OA_NOTIFICATION
-- ----------------------------
ALTER TABLE "OA_NOTIFICATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "OA_NOTIFICATION" ADD CHECK ("TITLE" IS NOT NULL);
ALTER TABLE "OA_NOTIFICATION" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "OA_NOTIFICATION" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "OA_NOTIFICATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "OA_NOTIFICATION" ADD CHECK ("TITLE" IS NOT NULL);
ALTER TABLE "OA_NOTIFICATION" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "OA_NOTIFICATION" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table OA_NOTIFICATION
-- ----------------------------
ALTER TABLE "OA_NOTIFICATION" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SMS_SEND_LOG
-- ----------------------------

-- ----------------------------
-- Checks structure for table SMS_SEND_LOG
-- ----------------------------
ALTER TABLE "SMS_SEND_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SMS_SEND_LOG" ADD CHECK ("BUSINESS_TYPE" IS NOT NULL);
ALTER TABLE "SMS_SEND_LOG" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "SMS_SEND_LOG" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "SMS_SEND_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SMS_SEND_LOG" ADD CHECK ("BUSINESS_TYPE" IS NOT NULL);
ALTER TABLE "SMS_SEND_LOG" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "SMS_SEND_LOG" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "SMS_SEND_LOG" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SMS_SEND_LOG
-- ----------------------------
ALTER TABLE "SMS_SEND_LOG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SMS_TEMPLATE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SMS_TEMPLATE
-- ----------------------------
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("CODE" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("BUSINESS_TYPE" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("TEMPLATE_ID" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("TEMPLATE_CONTENT" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("CODE" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("BUSINESS_TYPE" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("TEMPLATE_ID" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("TEMPLATE_CONTENT" IS NOT NULL);
ALTER TABLE "SMS_TEMPLATE" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SMS_TEMPLATE
-- ----------------------------
ALTER TABLE "SMS_TEMPLATE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_ATTACHMENT
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_ATTACHMENT
-- ----------------------------
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("FILENAME" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("USERID" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("UPLOADTIME" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("UPLOADIP" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("FILEEXT" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("FILEPATH" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("FILESIZE" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("FILENAME" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("USERID" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("UPLOADTIME" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("UPLOADIP" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("FILEEXT" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("FILEPATH" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("FILESIZE" IS NOT NULL);
ALTER TABLE "SYS_ATTACHMENT" ADD CHECK ("STATUS" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_ATTACHMENT
-- ----------------------------
ALTER TABLE "SYS_ATTACHMENT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_DATA_SOURCE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_DATA_SOURCE
-- ----------------------------
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("DB_KEY" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("DESCRIPTION" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("DRIVER_CLASS" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("URL" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("DB_USER" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("DB_KEY" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("DESCRIPTION" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("DRIVER_CLASS" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("URL" IS NOT NULL);
ALTER TABLE "SYS_DATA_SOURCE" ADD CHECK ("DB_USER" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_DATA_SOURCE
-- ----------------------------
ALTER TABLE "SYS_DATA_SOURCE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_DICT
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_DICT
-- ----------------------------
ALTER TABLE "SYS_DICT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_DICT" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_DICT
-- ----------------------------
ALTER TABLE "SYS_DICT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_DICT_GROUP
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_DICT_GROUP
-- ----------------------------
ALTER TABLE "SYS_DICT_GROUP" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_DICT_GROUP" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_DICT_GROUP
-- ----------------------------
ALTER TABLE "SYS_DICT_GROUP" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_LOG
-- ----------------------------
CREATE INDEX "SYS_LOG_CREATE_BY"
ON "SYS_LOG" ("CREATE_BY" ASC)
LOGGING
VISIBLE;
CREATE INDEX "SYS_LOG_CREATE_DATE"
ON "SYS_LOG" ("CREATE_DATE" ASC)
LOGGING
VISIBLE;
CREATE INDEX "SYS_LOG_REQUEST_URI"
ON "SYS_LOG" ("REQUEST_URI" ASC)
LOGGING
VISIBLE;
CREATE INDEX "SYS_LOG_TYPE"
ON "SYS_LOG" ("TYPE" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table SYS_LOG
-- ----------------------------
ALTER TABLE "SYS_LOG" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_LOG" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_LOG
-- ----------------------------
ALTER TABLE "SYS_LOG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_MENU
-- ----------------------------
CREATE INDEX "IDX_SYS_RESOURCE_PARENT_ID"
ON "SYS_MENU" ("PARENT_ID" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_RESOURCE_PARENT_IDS"
ON "SYS_MENU" ("PARENT_IDS" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table SYS_MENU
-- ----------------------------
ALTER TABLE "SYS_MENU" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_MENU" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_MENU
-- ----------------------------
ALTER TABLE "SYS_MENU" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_ORGANIZATION
-- ----------------------------
CREATE INDEX "IDX_SYS_ORGANIZATION_PARENT_ID"
ON "SYS_ORGANIZATION" ("PARENT_ID" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_ORGANIZATION_PARENT__1"
ON "SYS_ORGANIZATION" ("PARENT_IDS" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table SYS_ORGANIZATION
-- ----------------------------
ALTER TABLE "SYS_ORGANIZATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_ORGANIZATION" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_ORGANIZATION
-- ----------------------------
ALTER TABLE "SYS_ORGANIZATION" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_ROLE
-- ----------------------------
CREATE INDEX "SYS_ROLE_DEL_FLAG"
ON "SYS_ROLE" ("DEL_FLAG" ASC)
LOGGING
VISIBLE;
CREATE INDEX "SYS_ROLE_ENNAME"
ON "SYS_ROLE" ("CODE" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "SYS_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_ROLE" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "SYS_ROLE" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "SYS_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_ROLE" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "SYS_ROLE" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "SYS_ROLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_ROLE_MENU
-- ----------------------------
CREATE INDEX "SYS_ROLE_MENU_MENUID"
ON "SYS_ROLE_MENU" ("MENU_ID" ASC)
LOGGING
VISIBLE;
CREATE INDEX "SYS_ROLE_MENU_ROLEID"
ON "SYS_ROLE_MENU" ("ROLE_ID" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table SYS_ROLE_MENU
-- ----------------------------
ALTER TABLE "SYS_ROLE_MENU" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_ROLE_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "SYS_ROLE_MENU" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "SYS_ROLE_MENU" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_ROLE_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);
ALTER TABLE "SYS_ROLE_MENU" ADD CHECK ("ROLE_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_ROLE_MENU
-- ----------------------------
ALTER TABLE "SYS_ROLE_MENU" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_SESSIONS
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_SESSIONS
-- ----------------------------
ALTER TABLE "SYS_SESSIONS" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_SESSIONS" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_SESSIONS
-- ----------------------------
ALTER TABLE "SYS_SESSIONS" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_USER
-- ----------------------------

-- ----------------------------
-- Uniques structure for table SYS_USER
-- ----------------------------
ALTER TABLE "SYS_USER" ADD UNIQUE ("EMAIL");
ALTER TABLE "SYS_USER" ADD UNIQUE ("PHONE");
ALTER TABLE "SYS_USER" ADD UNIQUE ("USERNAME");

-- ----------------------------
-- Checks structure for table SYS_USER
-- ----------------------------
ALTER TABLE "SYS_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_USER" ADD CHECK ("USERNAME" IS NOT NULL);
ALTER TABLE "SYS_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_USER" ADD CHECK ("USERNAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER
-- ----------------------------
ALTER TABLE "SYS_USER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_USER_LAST_ONLINE
-- ----------------------------
CREATE INDEX "IDX_SYS_USER_LAST_ONLINE_HOST"
ON "SYS_USER_LAST_ONLINE" ("HOST" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_LAST_ONLINE_LAST_"
ON "SYS_USER_LAST_ONLINE" ("LAST_LOGIN_TIMESTAMP" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_LAST_ONLINE_LAS_1"
ON "SYS_USER_LAST_ONLINE" ("LAST_STOP_TIMESTAMP" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_LAST_ONLINE_SYSTE"
ON "SYS_USER_LAST_ONLINE" ("SYSTEM_HOST" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_LAST_ONLINE_USERN"
ON "SYS_USER_LAST_ONLINE" ("USERNAME" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_LAST_ONLINE_USER_"
ON "SYS_USER_LAST_ONLINE" ("USER_AGENT" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Uniques structure for table SYS_USER_LAST_ONLINE
-- ----------------------------
ALTER TABLE "SYS_USER_LAST_ONLINE" ADD UNIQUE ("USER_ID");

-- ----------------------------
-- Checks structure for table SYS_USER_LAST_ONLINE
-- ----------------------------
ALTER TABLE "SYS_USER_LAST_ONLINE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_USER_LAST_ONLINE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER_LAST_ONLINE
-- ----------------------------
ALTER TABLE "SYS_USER_LAST_ONLINE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_USER_ONLINE
-- ----------------------------
CREATE INDEX "IDX_SYS_USER_ONLINE_HOST"
ON "SYS_USER_ONLINE" ("HOST" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_ONLINE_LAST_ACCES"
ON "SYS_USER_ONLINE" ("LAST_ACCESS_TIME" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_ONLINE_START_TIME"
ON "SYS_USER_ONLINE" ("START_TIMESTSAMP" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_ONLINE_SYSTEM_HOS"
ON "SYS_USER_ONLINE" ("SYSTEM_HOST" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_ONLINE_SYS_USER_I"
ON "SYS_USER_ONLINE" ("USER_ID" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_ONLINE_USERNAME"
ON "SYS_USER_ONLINE" ("USERNAME" ASC)
LOGGING
VISIBLE;
CREATE INDEX "IDX_SYS_USER_ONLINE_USER_AGENT"
ON "SYS_USER_ONLINE" ("USER_AGENT" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table SYS_USER_ONLINE
-- ----------------------------
ALTER TABLE "SYS_USER_ONLINE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ONLINE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER_ONLINE
-- ----------------------------
ALTER TABLE "SYS_USER_ONLINE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_USER_ORGANIZATION
-- ----------------------------
CREATE INDEX "SYS_USER_ROLE_ROLEID_1"
ON "SYS_USER_ORGANIZATION" ("ORGANIZATION_ID" ASC)
LOGGING
VISIBLE;
CREATE INDEX "SYS_USER_ROLE_USERID_1"
ON "SYS_USER_ORGANIZATION" ("USER_ID" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table SYS_USER_ORGANIZATION
-- ----------------------------
ALTER TABLE "SYS_USER_ORGANIZATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ORGANIZATION" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ORGANIZATION" ADD CHECK ("ORGANIZATION_ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ORGANIZATION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ORGANIZATION" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ORGANIZATION" ADD CHECK ("ORGANIZATION_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER_ORGANIZATION
-- ----------------------------
ALTER TABLE "SYS_USER_ORGANIZATION" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_USER_ROLE
-- ----------------------------
CREATE INDEX "SYS_USER_ROLE_ROLEID"
ON "SYS_USER_ROLE" ("ROLE_ID" ASC)
LOGGING
VISIBLE;
CREATE INDEX "SYS_USER_ROLE_USERID"
ON "SYS_USER_ROLE" ("USER_ID" ASC)
LOGGING
VISIBLE;

-- ----------------------------
-- Checks structure for table SYS_USER_ROLE
-- ----------------------------
ALTER TABLE "SYS_USER_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ROLE" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ROLE" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "SYS_USER_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER_ROLE
-- ----------------------------
ALTER TABLE "SYS_USER_ROLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TASK_SCHEDULE_JOB
-- ----------------------------

-- ----------------------------
-- Checks structure for table TASK_SCHEDULE_JOB
-- ----------------------------
ALTER TABLE "TASK_SCHEDULE_JOB" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TASK_SCHEDULE_JOB" ADD CHECK ("CRON_EXPRESSION" IS NOT NULL);
ALTER TABLE "TASK_SCHEDULE_JOB" ADD CHECK ("METHOD_NAME" IS NOT NULL);
ALTER TABLE "TASK_SCHEDULE_JOB" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TASK_SCHEDULE_JOB" ADD CHECK ("CRON_EXPRESSION" IS NOT NULL);
ALTER TABLE "TASK_SCHEDULE_JOB" ADD CHECK ("METHOD_NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TASK_SCHEDULE_JOB
-- ----------------------------
ALTER TABLE "TASK_SCHEDULE_JOB" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TEST_ORDER_CUSTOMER
-- ----------------------------

-- ----------------------------
-- Checks structure for table TEST_ORDER_CUSTOMER
-- ----------------------------
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("SEX" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("PHONE" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("SEX" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("PHONE" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TEST_ORDER_CUSTOMER
-- ----------------------------
ALTER TABLE "TEST_ORDER_CUSTOMER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TEST_ORDER_MAIN
-- ----------------------------

-- ----------------------------
-- Checks structure for table TEST_ORDER_MAIN
-- ----------------------------
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("ORDERNO" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("MONEY" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("ORDERDATE" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("ORDERNO" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("MONEY" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("ORDERDATE" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "TEST_ORDER_MAIN" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TEST_ORDER_MAIN
-- ----------------------------
ALTER TABLE "TEST_ORDER_MAIN" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TEST_ORDER_TICKET
-- ----------------------------

-- ----------------------------
-- Checks structure for table TEST_ORDER_TICKET
-- ----------------------------
ALTER TABLE "TEST_ORDER_TICKET" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_ORDER_TICKET" ADD CHECK ("FLTNO" IS NOT NULL);
ALTER TABLE "TEST_ORDER_TICKET" ADD CHECK ("FLYTIME" IS NOT NULL);
ALTER TABLE "TEST_ORDER_TICKET" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "TEST_ORDER_TICKET" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_ORDER_TICKET" ADD CHECK ("FLTNO" IS NOT NULL);
ALTER TABLE "TEST_ORDER_TICKET" ADD CHECK ("FLYTIME" IS NOT NULL);
ALTER TABLE "TEST_ORDER_TICKET" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "TEST_ORDER_TICKET" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TEST_ORDER_TICKET
-- ----------------------------
ALTER TABLE "TEST_ORDER_TICKET" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TEST_SINGLE_TABLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TEST_SINGLE_TABLE
-- ----------------------------
ALTER TABLE "TEST_SINGLE_TABLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_SINGLE_TABLE" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "TEST_SINGLE_TABLE" ADD CHECK ("TESTDATE" IS NOT NULL);
ALTER TABLE "TEST_SINGLE_TABLE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TEST_SINGLE_TABLE
-- ----------------------------
ALTER TABLE "TEST_SINGLE_TABLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table TEST_TREE
-- ----------------------------

-- ----------------------------
-- Checks structure for table TEST_TREE
-- ----------------------------
ALTER TABLE "TEST_TREE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_TREE" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "TEST_TREE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEST_TREE" ADD CHECK ("DEL_FLAG" IS NOT NULL);
ALTER TABLE "TEST_TREE" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table TEST_TREE
-- ----------------------------
ALTER TABLE "TEST_TREE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Foreign Key structure for table "SYS_DICT"
-- ----------------------------
ALTER TABLE "SYS_DICT" ADD FOREIGN KEY ("GID") REFERENCES "SYS_DICT_GROUP" ("ID");
