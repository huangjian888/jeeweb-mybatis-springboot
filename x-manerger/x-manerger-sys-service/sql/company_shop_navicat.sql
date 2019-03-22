/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : company_shop

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2018-10-06 10:01:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for email_send_log
-- ----------------------------
DROP TABLE IF EXISTS `email_send_log`;
CREATE TABLE `email_send_log` (
  `id` varchar(32) NOT NULL,
  `email` longtext NOT NULL COMMENT '联系电话',
  `subject` varchar(255) DEFAULT NULL COMMENT '主题',
  `content` text COMMENT '模板类型',
  `send_data` varchar(255) DEFAULT NULL,
  `send_code` varchar(255) NOT NULL COMMENT '发送编码',
  `response_date` datetime DEFAULT NULL COMMENT '响应时间',
  `try_num` int(2) DEFAULT NULL COMMENT '重发次数',
  `msg` varchar(250) DEFAULT NULL COMMENT '返回消息',
  `status` varchar(4) DEFAULT NULL COMMENT '发送状态',
  `del_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of email_send_log
-- ----------------------------

-- ----------------------------
-- Table structure for email_template
-- ----------------------------
DROP TABLE IF EXISTS `email_template`;
CREATE TABLE `email_template` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '模版名称',
  `code` varchar(255) NOT NULL COMMENT '模版编码',
  `template_subject` varchar(20) NOT NULL COMMENT '模版主题',
  `template_content` text NOT NULL COMMENT '模版内容',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `create_date` varchar(19) DEFAULT NULL COMMENT '创建时间',
  `del_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `update_date` varchar(19) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件发送模板';

-- ----------------------------
-- Records of email_template
-- ----------------------------

-- ----------------------------
-- Table structure for oa_notification
-- ----------------------------
DROP TABLE IF EXISTS `oa_notification`;
CREATE TABLE `oa_notification` (
  `id` varchar(32) NOT NULL,
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` longtext NOT NULL COMMENT '内容',
  `status` varchar(4) NOT NULL COMMENT '发布状态',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oa_notification
-- ----------------------------

-- ----------------------------
-- Table structure for oss_attachment
-- ----------------------------
DROP TABLE IF EXISTS `oss_attachment`;
CREATE TABLE `oss_attachment` (
  `id` varchar(32) NOT NULL,
  `file_name` varchar(50) NOT NULL COMMENT '文件名称',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `upload_time` datetime NOT NULL COMMENT '上传时间',
  `upload_ip` varchar(30) NOT NULL COMMENT '上传的ID',
  `file_extension` varchar(10) NOT NULL COMMENT '文件扩展名',
  `file_path` varchar(200) NOT NULL COMMENT '文件路径',
  `file_size` int(10) NOT NULL DEFAULT '0' COMMENT '文件大小',
  `content_type` varchar(100) DEFAULT NULL,
  `status` varchar(1) NOT NULL DEFAULT '0' COMMENT '状态',
  `base_path` varchar(250) DEFAULT NULL COMMENT 'oss的根路径',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of oss_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for sms_send_log
-- ----------------------------
DROP TABLE IF EXISTS `sms_send_log`;
CREATE TABLE `sms_send_log` (
  `id` varchar(32) NOT NULL,
  `phone` longtext NOT NULL COMMENT '联系电话',
  `template_name` varchar(50) DEFAULT NULL COMMENT '模板名称',
  `send_data` varchar(255) DEFAULT NULL COMMENT '发送数据',
  `send_code` varchar(20) DEFAULT NULL,
  `try_num` int(2) DEFAULT NULL,
  `status` varchar(4) NOT NULL COMMENT '发送状态',
  `smsid` varchar(50) DEFAULT NULL COMMENT '发送响应消息ID',
  `code` varchar(40) DEFAULT NULL COMMENT '返回码',
  `msg` varchar(600) DEFAULT NULL COMMENT '返回消息',
  `del_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `response_date` datetime DEFAULT NULL COMMENT '响应时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sms_send_log
-- ----------------------------

-- ----------------------------
-- Table structure for sms_template
-- ----------------------------
DROP TABLE IF EXISTS `sms_template`;
CREATE TABLE `sms_template` (
  `id` varchar(32) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '模版名称',
  `code` varchar(255) NOT NULL COMMENT '模版编码',
  `business_type` varchar(4) NOT NULL COMMENT '业务类型',
  `template_content` varchar(255) NOT NULL COMMENT '模版内容',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '删除标记（0：正常；1：删除）',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sms_template
-- ----------------------------

-- ----------------------------
-- Table structure for sys_data_source
-- ----------------------------
DROP TABLE IF EXISTS `sys_data_source`;
CREATE TABLE `sys_data_source` (
  `id` varchar(36) NOT NULL,
  `db_key` varchar(50) NOT NULL COMMENT '索引关键字',
  `description` varchar(50) NOT NULL COMMENT '描述',
  `driver_class` varchar(50) NOT NULL COMMENT '驱动',
  `url` varchar(200) NOT NULL COMMENT 'URL',
  `db_user` varchar(50) NOT NULL COMMENT '帐号',
  `db_password` varchar(50) DEFAULT NULL COMMENT '密码',
  `db_type` varchar(50) DEFAULT NULL COMMENT '数据库类型',
  `db_name` varchar(50) DEFAULT NULL COMMENT '数据库名称',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_data_source
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `gid` varchar(32) DEFAULT NULL COMMENT '分组ID',
  `label` varchar(100) DEFAULT NULL COMMENT '键值键',
  `value` varchar(100) DEFAULT NULL COMMENT '值',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `remarks` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_dict_groupid_key` (`gid`),
  CONSTRAINT `sys_dict_groupid_key` FOREIGN KEY (`gid`) REFERENCES `sys_dict_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('2a6cb5048f204a6d99f5ea6e8cf450bf', '0bf0a5f4378748c1b6b759aea7da9c72', '修改', 'update', '2', '修改', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-30 23:55:04', null, null, '0');
INSERT INTO `sys_dict` VALUES ('2abd99f7a44e4ef0937b97109b31db87', '9f28ef405c63412f9ef6524edb4adc68', '继续执行', '1', '1', '继续执行', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-17 15:37:58', null, null, '0');
INSERT INTO `sys_dict` VALUES ('30bf1683c3a54772bbc75193d8cc48ab', '0bf0a5f4378748c1b6b759aea7da9c72', '删除', 'delete', '5', '删除', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-30 23:55:29', null, null, '0');
INSERT INTO `sys_dict` VALUES ('39f8239fa07a49dda0f5427d750a8d9e', 'c8da4e4534924bb19cd106fbde174d4e', '一年授权', '1', '1', '一年授权', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-19 11:18:36', null, null, '0');
INSERT INTO `sys_dict` VALUES ('3e285e6650cb47f88f452e156b5bf903', '0bf0a5f4378748c1b6b759aea7da9c72', '导出', 'export', '7', '导出', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-30 23:56:28', null, null, '0');
INSERT INTO `sys_dict` VALUES ('40281e815ced1f27015ced2f83bc000b', '40281e815ced1f27015ced2be5330003', '男', '1', '1', '1', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('40281e815cef4f99015cef6f7d070005', '40281e815ced1f27015ced2be5330003', '女', '2', '1', '女', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('40288ab85a20b609015a20c422e90003', '40288ab85a20b609015a20c3f7bf0002', '是', '1', '1', '1', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('40288ab85a5eecc6015a5eede8720000', '40288ab85a20b609015a20c3f7bf0002', '否', '0', '2', '否', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('40288ab85bf1549e015bf175152a0001', '40288ab85bf1549e015bf17370ff0000', '在线', 'on_line', '1', '在线', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('40288ab85bf1549e015bf17559ac0002', '40288ab85bf1549e015bf17370ff0000', '隐身', 'hidden', '2', '隐身', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('40288ab85bf1549e015bf17590820003', '40288ab85bf1549e015bf17370ff0000', '强制退出', 'force_logout', '3', '强制退出', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('40288ab85c8593cd015c859b70010011', '40288ab85c8593cd015c859b1fcf0010', '验证码', '1', '1', '验证码', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('40288ab85c8593cd015c859b8ff50012', '40288ab85c8593cd015c859b1fcf0010', '通知', '2', '2', '通知', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('40288ab85c86382b015c863993a30002', '40288ab85c8593cd015c859b1fcf0010', '其他', '99', '99', '其他', null, null, null, null, '0');
INSERT INTO `sys_dict` VALUES ('406ee9ed59bc4810b0feb2aa16617706', '4ce6a66f28be454ba614339d0b018d4e', '目录', '1', '1', '目录', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 14:53:35', null, null, '0');
INSERT INTO `sys_dict` VALUES ('4335d86dce584400b739a9d62ddcb3f7', '79d26e50f69a45479bdac723beea4811', '已付款', '2', '2', '已付款', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-19 16:44:23', null, null, '0');
INSERT INTO `sys_dict` VALUES ('4d13a0afc66a41c5a892b677ecf51e5d', 'f8a0d22e387445b29f6c238e252c7068', '论坛', '论坛', '2', '论坛', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-01 15:23:09', null, null, '0');
INSERT INTO `sys_dict` VALUES ('4e23f0cd2a154d62bdd9417610ca2679', '0bf0a5f4378748c1b6b759aea7da9c72', '新增', 'insert', '1', '新增', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-30 23:54:48', null, null, '0');
INSERT INTO `sys_dict` VALUES ('5b905a49c182491988865986e4cc48e3', '9f28ef405c63412f9ef6524edb4adc68', '放弃执行', '3', '3', '放弃执行', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-17 15:38:20', null, null, '0');
INSERT INTO `sys_dict` VALUES ('6aeb216b950740c9ba61ba2994b4ce98', '9f28ef405c63412f9ef6524edb4adc68', '一次执行', '2', '2', '一次执行', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-17 15:38:10', null, null, '0');
INSERT INTO `sys_dict` VALUES ('72a55df5480c48b79e095eb5c6a4728f', 'd8fd027d0743468c828d7d068239d483', '成功', '1', '1', '成功', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-28 13:15:31', null, null, '0');
INSERT INTO `sys_dict` VALUES ('839273eee78947759bd8a980fcf77e99', '0bf0a5f4378748c1b6b759aea7da9c72', '查询', 'select', '3', '查询', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-30 23:55:13', null, null, '0');
INSERT INTO `sys_dict` VALUES ('8aa5b728b8c94bdcba0d54d4ba3ad8a1', '0a44514f07c64f2d867b5d88a879c795', '链接', 'view', '2', '链接', '4028ea815a3d2a8c015a3d2f8d2a0002', '2017-10-23 22:27:54', '4028ea815a3d2a8c015a3d2f8d2a0002', '2017-10-23 23:28:26', '0');
INSERT INTO `sys_dict` VALUES ('90f97d607fb745019c88e126b989fa8d', '7a4ed165f128484787a119179b7c18fd', '普通类', '2', '2', '普通类', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-20 15:00:56', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-17 17:57:04', '0');
INSERT INTO `sys_dict` VALUES ('91beec564eb04a3c9808f08c7a7aa086', '0a44514f07c64f2d867b5d88a879c795', '消息', 'click', '1', '1', '4028ea815a3d2a8c015a3d2f8d2a0002', '2017-10-23 22:27:32', '4028ea815a3d2a8c015a3d2f8d2a0002', '2017-10-23 23:28:34', '0');
INSERT INTO `sys_dict` VALUES ('95fe7c02adf345c68303c8da34e7cef4', '4ce6a66f28be454ba614339d0b018d4e', '菜单', '2', '2', '2', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 14:53:42', null, null, '0');
INSERT INTO `sys_dict` VALUES ('973bdbced7ef467fa9d21d65631fe8fc', '79d26e50f69a45479bdac723beea4811', '未付款', '1', '1', '未付款', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-19 16:44:06', null, null, '0');
INSERT INTO `sys_dict` VALUES ('a94650c480914ad69f4820b01086a8be', '7a4ed165f128484787a119179b7c18fd', 'SpringBean', '1', '1', 'SpringBean', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-20 15:00:31', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 12:36:33', '0');
INSERT INTO `sys_dict` VALUES ('aa6aeaf0fcaa42098f039b5e15494ebb', '0bf0a5f4378748c1b6b759aea7da9c72', '其他', 'other', '6', '其他', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-30 23:55:59', null, null, '0');
INSERT INTO `sys_dict` VALUES ('b568561ffaa5459e8c79fd71d58eede2', '0bf0a5f4378748c1b6b759aea7da9c72', '导入', 'import', '8', '导入', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-30 23:56:44', null, null, '0');
INSERT INTO `sys_dict` VALUES ('c44a4bdda43c4af1adb95ad7627f658e', '79d26e50f69a45479bdac723beea4811', '交易成功', '3', '3', '交易成功', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-19 16:44:40', null, null, '0');
INSERT INTO `sys_dict` VALUES ('de1ad2226ae04bb98f6db78ff9e7fee0', 'd8fd027d0743468c828d7d068239d483', '失败', '-1', '1', '失败', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-28 13:15:39', null, null, '0');
INSERT INTO `sys_dict` VALUES ('e64158128fd1400fb9f834c7a96a1046', 'd8fd027d0743468c828d7d068239d483', '退出', '0', '0', '退出', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-28 13:15:54', null, null, '0');
INSERT INTO `sys_dict` VALUES ('fb30cb9b10ed4a038ccc7d6137f68b3b', 'c8da4e4534924bb19cd106fbde174d4e', '永久授权', '2', '2', '永久授权', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-19 11:18:47', null, null, '0');
INSERT INTO `sys_dict` VALUES ('fbc892407e714426a62908397fc8512f', '4ce6a66f28be454ba614339d0b018d4e', '按钮', '3', '3', '按钮', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 14:53:51', null, null, '0');
INSERT INTO `sys_dict` VALUES ('fdd9f7e252fe46fb9dd99a46e292793b', '79d26e50f69a45479bdac723beea4811', '交易关闭', '4', '4', '交易关闭', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-19 16:44:49', null, null, '0');

-- ----------------------------
-- Table structure for sys_dict_group
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_group`;
CREATE TABLE `sys_dict_group` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(100) DEFAULT NULL COMMENT '分组名称',
  `code` varchar(100) DEFAULT NULL COMMENT '分组编码',
  `remarks` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典分组';

-- ----------------------------
-- Records of sys_dict_group
-- ----------------------------
INSERT INTO `sys_dict_group` VALUES ('0a44514f07c64f2d867b5d88a879c795', '菜单动作行为', 'mpmenutype', '菜单动作行为', '4028ea815a3d2a8c015a3d2f8d2a0002', '2017-10-23 22:27:02', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-03-23 09:45:44', '0');
INSERT INTO `sys_dict_group` VALUES ('0bf0a5f4378748c1b6b759aea7da9c72', '日志类型', 'logType', '日志类型', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-30 23:54:01', null, null, '0');
INSERT INTO `sys_dict_group` VALUES ('40281e815ced1f27015ced2be5330003', '性别', 'sex', '性别', null, null, null, null, '0');
INSERT INTO `sys_dict_group` VALUES ('40288ab85a20b609015a20c3f7bf0002', '是否', 'sf', '是否', null, null, null, null, '0');
INSERT INTO `sys_dict_group` VALUES ('40288ab85bf1549e015bf17370ff0000', '用户登陆状态', 'onlinestatus', '', null, null, null, null, '0');
INSERT INTO `sys_dict_group` VALUES ('40288ab85c8593cd015c859b1fcf0010', '短信业务类型', 'businesstype', '短信业务类型', null, null, null, null, '0');
INSERT INTO `sys_dict_group` VALUES ('4ce6a66f28be454ba614339d0b018d4e', '菜单类型', 'menutype', 'menutype', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 14:53:19', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 14:54:27', '0');
INSERT INTO `sys_dict_group` VALUES ('79d26e50f69a45479bdac723beea4811', '订单编码', 'productOrderStatus', '订单编码', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-19 16:43:37', null, null, '0');
INSERT INTO `sys_dict_group` VALUES ('7a4ed165f128484787a119179b7c18fd', '任务加载方式', 'loadway', '任务加载方式', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-20 15:00:01', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-27 16:46:02', '0');
INSERT INTO `sys_dict_group` VALUES ('9f28ef405c63412f9ef6524edb4adc68', '执行策略', 'misfirePolicy', '执行策略', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-17 15:37:42', null, null, '0');
INSERT INTO `sys_dict_group` VALUES ('c8da4e4534924bb19cd106fbde174d4e', '授权期限', 'authorizationPeriod', '授权期限', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-19 11:16:48', null, null, '0');
INSERT INTO `sys_dict_group` VALUES ('d8fd027d0743468c828d7d068239d483', '登陆状态', 'loginstatus', '登陆状态', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-28 13:15:00', null, null, '0');
INSERT INTO `sys_dict_group` VALUES ('f8a0d22e387445b29f6c238e252c7068', '项目类型', 'projecttype', 'projecttype', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-01 15:21:57', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-19 11:09:05', '0');

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` varchar(32) NOT NULL COMMENT '访问ID',
  `login_name` varchar(50) DEFAULT '' COMMENT '登录账号',
  `login_ip` varchar(50) DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) DEFAULT '' COMMENT '操作系统',
  `status` char(2) DEFAULT '0' COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) DEFAULT '' COMMENT '提示消息',
  `login_time` datetime DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统访问记录';

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '资源路径',
  `type` varchar(50) DEFAULT NULL COMMENT '资源类型',
  `url` varchar(200) DEFAULT NULL COMMENT '点击后前往的地址',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父编号',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '父编号列表',
  `permission` varchar(100) DEFAULT NULL COMMENT '权限字符串',
  `enabled` tinyint(1) DEFAULT '0' COMMENT '是否显示',
  `sort` int(5) DEFAULT NULL COMMENT '排序',
  `menu_icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `remarks` varchar(255) DEFAULT NULL COMMENT '摘要',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_sys_resource_parent_id` (`parent_id`),
  KEY `idx_sys_resource_parent_ids` (`parent_ids`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO sys_menu VALUES
('004ef02eff6347de8b054834e37e7084', '查询', '3', NULL, '40288ab85a5eecc6015a5ef9f6160005', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef9f6160005/', 'sys:menu:list', 1, NULL, '', '查询', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 12:49:49', NULL, NULL, '0'),
('05e3cd68c0e44f288b5605577c54b696', '登陆日志', '2', '/admin/sys/login/log', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'sys:login:log', 1, 3, 'fa-map-o', '登陆日志', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-28 13:09:31', NULL, NULL, '0'),
('0f6ed028011a4e06a90af8edfa0c9dbb', '修改', '3', NULL, '40288ab85a5eecc6015a5ef9f6160005', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef9f6160005/', 'sys:menu:update', 1, 3, '', '修改', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 12:51:35', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 14:15:21', '0'),
('34e23174debf447a86ad322c466b1020', '删除', '3', NULL, '40288ab85a5eecc6015a5ef9f6160005', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef9f6160005/', 'sys:menu:delete', 1, NULL, '', '删除', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 12:51:52', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 14:15:37', '0'),
('35ff47636f044375b54b6be644996c38', '添加', '3', NULL, '40288ab85a5eecc6015a5ef95c700004', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef95c700004/', 'sys:role:add', 1, NULL, '', '添加', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 12:58:20', NULL, NULL, '0'),
('40281e815c54d147015c54daf16c0001', '操作日志', '2', '/admin/sys/operation/log', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'sys:operation:log', 1, 6, 'fa-book', '操作日志', NULL, NULL, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-09-30 23:29:31', '0'),
('40288ab85a5eecc6015a5ef22ad80001', '系统设置', '1', NULL, NULL, NULL, '', 1, 2, 'fa-gear', '', NULL, NULL, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 15:18:21', '0'),
('40288ab85a5eecc6015a5ef6ce870002', '用户管理', '2', '/admin/sys/user', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:user:view', 1, 1, 'fa-user', 'sdfdsfsdfsdfsdfsdfsf', NULL, NULL, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 20:24:28', '0'),
('40288ab85a5eecc6015a5ef8f2890003', '部门管理', '2', '/admin/sys/organization', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:organization', 1, 2, 'fa-balance-scale', '', NULL, NULL, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 14:07:59', '0'),
('40288ab85a5eecc6015a5ef95c700004', '角色管理', '2', '/admin/sys/role', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:role:view', 1, 3, 'fa-users', '', NULL, NULL, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 20:24:05', '0'),
('40288ab85a5eecc6015a5ef9f6160005', '菜单管理', '2', '/admin/sys/menu', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:menu:view', 1, 4, 'fa-align-justify', '', NULL, NULL, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 20:26:34', '0'),
('40288ab85a5eecc6015a5efaa75d0006', '数据字典', '2', '/admin/sys/dict/group', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a5eecc6015a5ef22ad80001/', 'sys:dict', 1, 5, 'fa-yelp', '', NULL, NULL, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 20:25:41', '0'),
('40288ab85b604adf015b605023a70000', '在线用户', '2', '/admin/sys/online', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'sys:online:list', 1, 1, '', '在线用户', NULL, NULL, NULL, NULL, '0'),
('40288ab85c33548d015c33cdc5a600f3', '附件信息', '2', '/admin/oss/attachment', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'oss:attachment:list', 1, 5, '', '', NULL, NULL, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-16 17:36:48', '0'),
('4028ea815a701416015a7075b4f9001f', '系统监控', '1', NULL, NULL, NULL, '', 1, 3, 'fa-video-camera', '', NULL, NULL, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 15:18:16', '0'),
('4028ea815a701416015a70766a7a0020', '数据库监控', '2', '/admin/monitor/druid', '4028ea815a701416015a7075b4f9001f', '4028ea815a701416015a7075b4f9001f/', 'monitor:druid:index', 1, 3, '', '', NULL, NULL, NULL, NULL, '0'),
('55df31718bb643d2af588ba308029649', '导出', '3', NULL, '40288ab85a5eecc6015a5ef6ce870002', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef6ce870002/', 'sys:user:export', 1, NULL, '', '导出', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 14:05:56', NULL, NULL, '0'),
('59d1613e398e4319b3564726bd670dbc', '添加', '3', NULL, '40288ab85a5eecc6015a5ef6ce870002', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef6ce870002/', 'sys:user:add', 1, NULL, '', '添加', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 14:01:52', NULL, NULL, '0'),
('66232cfca6214d78b5416577df05ee01', '删除', '3', NULL, '40288ab85a5eecc6015a5ef6ce870002', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef6ce870002/', 'sys:user:delete', 1, NULL, '', '删除', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 14:02:35', NULL, NULL, '0'),
('6d53ef7fe9c74146b24e5d00c96a95c1', '查询', '3', NULL, '40288ab85a5eecc6015a5ef6ce870002', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef6ce870002/', 'sys:user:list', 1, NULL, '', '查询', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 14:01:31', NULL, NULL, '0'),
('6f69b26a8a0c4117834f8742b22e5afc', '更新', '3', NULL, '40288ab85a5eecc6015a5ef6ce870002', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef6ce870002/', 'sys:user:update', 1, NULL, '', '更新', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 14:02:12', NULL, NULL, '0'),
('93c7b840d2d449cc8c23f8f3195ede63', '查询', '3', NULL, '40288ab85a5eecc6015a5ef95c700004', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef95c700004/', 'sys:role:list', 1, NULL, '', '查询', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 12:57:53', NULL, NULL, '0'),
('a2382df311694fae93d3e801798dd125', '修改', '3', NULL, '40288ab85a5eecc6015a5ef95c700004', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef95c700004/', 'sys:role:update', 1, NULL, '', '修改', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 12:58:47', NULL, NULL, '0'),
('ba31cd4c2b514a3e944c2c6120e6a41d', '删除', '3', NULL, '40288ab85a5eecc6015a5ef95c700004', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef95c700004/', 'sys:role:delete', 1, NULL, '', '删除', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 12:59:07', NULL, NULL, '0'),
('fa2cce3b3cc3418e9aa152c07b619769', '角色授权', '3', '', '40288ab85a5eecc6015a5ef95c700004', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef95c700004/', 'sys:role:authMenu', 1, NULL, '', '角色授权', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 15:00:04', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 15:00:28', '0'),
('fd89335cd9324bdfb1de17c61ced6675', '新增', '3', NULL, '40288ab85a5eecc6015a5ef9f6160005', '40288ab85a5eecc6015a5ef22ad80001/40288ab85a5eecc6015a5ef9f6160005/', 'sys:menu:add', 1, NULL, '', '新增', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 12:50:44', NULL, NULL, '0');


-- ----------------------------
-- Table structure for sys_message
-- ----------------------------
DROP TABLE IF EXISTS `sys_message`;
CREATE TABLE `sys_message` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` text NOT NULL COMMENT '模版内容',
  `is_read` tinyint(1) DEFAULT NULL COMMENT '是否阅读',
  `read_uid` varchar(32) DEFAULT NULL COMMENT '阅读的用户ID',
  `read_uname` varchar(250) DEFAULT NULL COMMENT '阅读的人',
  `read_date` datetime DEFAULT NULL COMMENT '阅读时间',
  `send_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_message_read_uid` (`read_uid`),
  CONSTRAINT `sys_message_read_uid` FOREIGN KEY (`read_uid`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发送消息';

-- ----------------------------
-- Records of sys_message
-- ----------------------------

-- ----------------------------
-- Table structure for sys_message_template
-- ----------------------------
DROP TABLE IF EXISTS `sys_message_template`;
CREATE TABLE `sys_message_template` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `name` varchar(255) NOT NULL COMMENT '模版名称',
  `code` varchar(255) NOT NULL COMMENT '模版编码',
  `template_title` varchar(255) NOT NULL COMMENT '模版标题',
  `template_content` text NOT NULL COMMENT '模版内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='发送消息模板';

-- ----------------------------
-- Records of sys_message_template
-- ----------------------------

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `content` varchar(1000) DEFAULT '' COMMENT '日志内容',
  `log_type` varchar(10) DEFAULT '' COMMENT '操作方式',
  `create_by` varchar(32) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URL',
  `browser` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `os` varchar(100) DEFAULT NULL COMMENT '操作系统',
  `operation_ip` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `operation_name` varchar(255) DEFAULT NULL COMMENT '操作人',
  `method` varchar(255) DEFAULT NULL COMMENT '操作方法',
  `params` text COMMENT '数据',
  `msg` text COMMENT '异常信息',
  `status` varchar(1) DEFAULT NULL COMMENT '请求状态',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`operation_ip`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_organization`;
CREATE TABLE `sys_organization` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '机构名称',
  `parent_id` varchar(32) DEFAULT NULL COMMENT '父节点',
  `parent_ids` varchar(1000) DEFAULT NULL COMMENT '父节点路径',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL COMMENT '删除标记',
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_sys_organization_parent_id` (`parent_id`),
  KEY `idx_sys_organization_parent_ids` (`parent_ids`(255))
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_organization
-- ----------------------------
INSERT INTO `sys_organization` VALUES ('40288ab85b6080e1015b60996d690005', '数立行', null, null, null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-16 16:06:40', '0', null);
INSERT INTO `sys_organization` VALUES ('4028ea815a452f69015a45346f7b0001', '研发部', '40288ab85b6080e1015b60996d690005', '40288ab85b6080e1015b60996d690005/', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-10-05 19:47:18', '0', '');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `code` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `is_sys` varchar(64) DEFAULT NULL COMMENT '是否系统数据',
  `usable` varchar(64) DEFAULT NULL COMMENT '是否可用',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`),
  KEY `sys_role_enname` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('402880e45b5d7636015b5d8baca60000', '普通用户', 'normal', '1', '1', null, '2017-04-11 23:04:46', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 14:19:50', '', '0');
INSERT INTO `sys_role` VALUES ('40288ab85a362150015a3675ca950006', '系统管理员', 'admin', '1', '1', null, '2017-02-13 15:52:53', '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 13:07:41', '系统管理员', '0');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `menu_id` varchar(32) NOT NULL COMMENT '菜单编号',
  `role_id` varchar(32) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`),
  KEY `sys_role_menu_menuid` (`menu_id`),
  KEY `sys_role_menu_roleid` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO sys_role_menu VALUES
('00e36aff04c647b7bc9a335ebd237b15', 'fa2cce3b3cc3418e9aa152c07b619769', '40288ab85a362150015a3675ca950006'),
('06a757ad0fb543ccad16cda20699705c', 'b67720154aa640a9b8379f90f1b74678', '40288ab85a362150015a3675ca950006'),
('07d9ab133d3c46b891a57e9598339fdf', '34e23174debf447a86ad322c466b1020', '40288ab85a362150015a3675ca950006'),
('081424d2dc3d40f486b8d5fde27e02c1', '40288ab85c9eeb5c015c9f4e1cd00001', '40288ab85a362150015a3675ca950006'),
('097fba0dffcd4741b949cd32826ef58b', '40288ab85c9eeb5c015c9f626f58002d', '40288ab85a362150015a3675ca950006'),
('0ee051c288904e92bdb8e72b74c5149b', '55df31718bb643d2af588ba308029649', '40288ab85a362150015a3675ca950006'),
('0f0d1fd6f2294204a8a9241923181b46', '40288ab85a5eecc6015a5ef95c700004', '40288ab85a362150015a3675ca950006'),
('1022131a72d2495dbde0b83ecaef3f89', '40288ab85c9eeb5c015c9f4d1f8e0000', '40288ab85a362150015a3675ca950006'),
('117b5193bef34704926a86becb0ff8e8', '59d1613e398e4319b3564726bd670dbc', '40288ab85a362150015a3675ca950006'),
('19bfec325a3a4bc0a85bd7a8eecc3b9f', '40288ab85a5eecc6015a5ef8f2890003', '40288ab85a362150015a3675ca950006'),
('1fd83fba75a1408b9ed71276fb6678ca', '40288ab85c9eeb5c015c9f6390fd002f', '40288ab85a362150015a3675ca950006'),
('2055ad752ad14cc8b774259431b023be', '40288ab85a5eecc6015a5ef6ce870002', '40288ab85a362150015a3675ca950006'),
('2988c6ab6049493f94edb2361e57b2ac', '93c7b840d2d449cc8c23f8f3195ede63', '40288ab85a362150015a3675ca950006'),
('30f458832f814fe7b7a0ac11b10c8a6c', '004ef02eff6347de8b054834e37e7084', '40288ab85a362150015a3675ca950006'),
('3fd61b027ce845e4b2ff474658284db6', '66232cfca6214d78b5416577df05ee01', '40288ab85a362150015a3675ca950006'),
('49c8460670484af0aeaf24a8d58b926a', '320c2e390d25488eb18fe75261795907', '40288ab85a362150015a3675ca950006'),
('4cd3944c941846e08917229dc5b7a186', '40281e815c912406015c9149f7b80044', '40288ab85a362150015a3675ca950006'),
('50181df3fae241bd9a3734dd8b34fea2', '1232ea9d3e374e89aef6ec3a1c693da8', '40288ab85a362150015a3675ca950006'),
('6ae16da3db794250b3a2ef398ea4bc69', 'dfff75fbd33d4a3c868c3b9d6d528d85', '40288ab85a362150015a3675ca950006'),
('701a266facbb4e87a754a271289e1698', '40288ab85c33548d015c33cdc5a600f3', '40288ab85a362150015a3675ca950006'),
('70cb3e489ccd42a8b2cdff7914c0839f', '40288ab85c9eeb5c015c9f5fa02e002a', '40288ab85a362150015a3675ca950006'),
('73b6a277f9bb45a7a40f7e629c461e08', '40288ab85a5eecc6015a5ef22ad80001', '40288ab85a362150015a3675ca950006'),
('750cacefd23c43a4b9a4d4a1c16b07a2', '40288ab85cf8276b015cf82debcb005b', '40288ab85a362150015a3675ca950006'),
('782b100135c24677b4bd7b27309ecfd9', '40288ab85c9eeb5c015c9f6572630030', '40288ab85a362150015a3675ca950006'),
('796d91aeabc94f7481a7ca19947e9b01', '40288ab85c9eeb5c015c9f65e3a50031', '40288ab85a362150015a3675ca950006'),
('79adea4aa6b14d34a55a1bdd2d95bcd0', 'dab0d97279514c73b2ab6ddf427f91d6', '40288ab85a362150015a3675ca950006'),
('7d40d0b5bc8b45b78d765c1119c083fb', '40281e815beda90f015bedcf7102000f', '40288ab85a362150015a3675ca950006'),
('808301693cf94743b18eb7aefe28e9f8', '40288ab85a5eecc6015a5ef9f6160005', '40288ab85a362150015a3675ca950006'),
('90433bd81ac649689c6150151415620f', '43aae5e9ac4b4c39b26316b54b1708ec', '40288ab85a362150015a3675ca950006'),
('99b9c431333d44b9bfc0b58312c8576d', '3f9752eb9b7d481a85cdb3c32c442025', '40288ab85a362150015a3675ca950006'),
('9a80a9a4c8b34f8f8797f84cd30dea95', '05e3cd68c0e44f288b5605577c54b696', '40288ab85a362150015a3675ca950006'),
('9b6f0313094e4df8bd03e5c3bc530782', '40288ab85c9eeb5c015c9f9694480064', '40288ab85a362150015a3675ca950006'),
('9ddb04c92db249da9255e2e8f0de7f21', '4028ea815a701416015a7075b4f9001f', '40288ab85a362150015a3675ca950006'),
('a1caa8d19d6c48d589a591122d6b140a', '0f6ed028011a4e06a90af8edfa0c9dbb', '40288ab85a362150015a3675ca950006'),
('bdb20d81f1224d9299f5972632ea4107', '40281e815c912406015c914a1bc30045', '40288ab85a362150015a3675ca950006'),
('c0dc3a44a73a455799c4a235248c121d', 'a2382df311694fae93d3e801798dd125', '40288ab85a362150015a3675ca950006'),
('c171e25414eb4ce28d9cfa6cdf6d1a44', '9202cea7d208446fa14089317ba938c8', '40288ab85a362150015a3675ca950006'),
('c30c5c731d074f22979b8cca5041835e', '40288ab85c9eeb5c015c9f672f2e0032', '40288ab85a362150015a3675ca950006'),
('c6fc3e54d5b944f5b0fb75df03ab9331', 'fd89335cd9324bdfb1de17c61ced6675', '40288ab85a362150015a3675ca950006'),
('c92bd6831b0a4ae3bda883d21e05299a', 'ba31cd4c2b514a3e944c2c6120e6a41d', '40288ab85a362150015a3675ca950006'),
('cb3315b0b320497b89246cfd53bd1600', '6f69b26a8a0c4117834f8742b22e5afc', '40288ab85a362150015a3675ca950006'),
('cbc96ade94f8448480cdbcb142f18f6d', '40288ab85a5eecc6015a5efaa75d0006', '40288ab85a362150015a3675ca950006'),
('d14e93aaaa44439dac9a28b104138572', 'df7449d9e15545c7bdffee270e82aea0', '40288ab85a362150015a3675ca950006'),
('d766b882e1ca4905ac19a6cd7092be7d', '40288ab85c9eeb5c015c9f62e726002e', '40288ab85a362150015a3675ca950006'),
('d89c9aa2999f4fe5b6e7b439dca8bc60', 'dca06272b9e045cb953507f2ea9970d6', '40288ab85a362150015a3675ca950006'),
('da0f8148ef8e48f58c96809050d5fad0', '4028ea815a701416015a70766a7a0020', '40288ab85a362150015a3675ca950006'),
('dab904096e2245138468be64bc13f928', '40288ab85b604adf015b605023a70000', '40288ab85a362150015a3675ca950006'),
('f4208fc595fc4456989549e5b53f8575', 'e5a287017839419d9dac884d78574153', '40288ab85a362150015a3675ca950006'),
('f546d231aad342a193450633f91676ac', '40281e815c54d147015c54daf16c0001', '40288ab85a362150015a3675ca950006'),
('fa33688ae0e647dba24ec7743972dd87', '35ff47636f044375b54b6be644996c38', '40288ab85a362150015a3675ca950006'),
('fa9a0232fc3748c4a981427c764aa204', '6d53ef7fe9c74146b24e5d00c96a95c1', '40288ab85a362150015a3675ca950006');


-- ----------------------------
-- Table structure for sys_sessions
-- ----------------------------
DROP TABLE IF EXISTS `sys_sessions`;
CREATE TABLE `sys_sessions` (
  `id` varchar(200) NOT NULL DEFAULT '',
  `session` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_sessions
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `realname` varchar(255) DEFAULT NULL COMMENT '真实名称',
  `username` varchar(100) NOT NULL COMMENT '用户名',
  `portrait` varchar(250) DEFAULT NULL COMMENT '头像',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL COMMENT '邮件',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `status` varchar(255) DEFAULT NULL COMMENT '系统用户的状态',
  `create_by` varchar(32) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(32) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `del_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_sys_user_username` (`username`),
  UNIQUE KEY `idx_sys_user_email` (`email`),
  UNIQUE KEY `idx_sys_user_phone` (`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('40288ab85ce3c20a015ce3ca6df60000', '测试用户', 'test', null, '2ebb8bee885791cb053cfe142353cb8a', '5a9d6207da81bd4c1cca29d5e3b6695b', 'test@qq.com', '15085980308', '1', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 17:36:44', null, '0');
INSERT INTO `sys_user` VALUES ('4028ea815a3d2a8c015a3d2f8d2a0002', '系统管理员', 'admin', null, '9af085bddb58515c1b391f7483feaca3', '7287174b3c96603d2d28ec8cab59418b', 'test2@qq.com', '14785571304', '1', null, null, '4028ea815a3d2a8c015a3d2f8d2a0002', '2018-08-24 17:36:49', null, '0');

-- ----------------------------
-- Table structure for sys_user_organization
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_organization`;
CREATE TABLE `sys_user_organization` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户主键',
  `organization_id` varchar(32) NOT NULL COMMENT '部门主键',
  PRIMARY KEY (`id`),
  KEY `sys_user_role_userid` (`user_id`),
  KEY `sys_user_role_roleid` (`organization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-部门';

-- ----------------------------
-- Records of sys_user_organization
-- ----------------------------
INSERT INTO `sys_user_organization` VALUES ('2a6fedbc887340fca68b2b377d35f39a', '40288ab85ce3c20a015ce3ca6df60000', '4028ea815a452f69015a45346f7b0001');
INSERT INTO `sys_user_organization` VALUES ('40281e815cfc4624015cfcc8c640000e', '40288ab85cf6aab4015cf6ecea890000', '40288ab85c20329e015c2037a7800003');
INSERT INTO `sys_user_organization` VALUES ('40281e815cfc4624015cfcc8c641000f', '40288ab85cf6aab4015cf6ecea890000', '40288ab85c20329e015c2037d2090004');
INSERT INTO `sys_user_organization` VALUES ('40281e815cfc4624015cfce005b3006e', '40281e815cfc4624015cfcce3d310029', '4028ea815a452f69015a45346f7b0001');
INSERT INTO `sys_user_organization` VALUES ('9ac4cf35fc33474ca0be229289285952', '40288ab85ce3c20a015ce3ca6df60000', '40288ab85b6080e1015b60996d690005');
INSERT INTO `sys_user_organization` VALUES ('c72514f8d6aa4456b93307f687e9b6c1', '4028ea815a3d2a8c015a3d2f8d2a0002', '40288ab85b6080e1015b60996d690005');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` varchar(32) NOT NULL COMMENT '编号',
  `user_id` varchar(32) NOT NULL COMMENT '用户编号',
  `role_id` varchar(32) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`),
  KEY `sys_user_role_userid` (`user_id`),
  KEY `sys_user_role_roleid` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('4f4593ff063b4fd7a2eda05d028c8df4', '4028ea815a3d2a8c015a3d2f8d2a0002', '40288ab85a362150015a3675ca950006');
INSERT INTO `sys_user_role` VALUES ('519fb0f440204d8db1b608fe93c31a35', '4028ea815a3d2a8c015a3d2f8d2a0002', '402880e45b5d7636015b5d8baca60000');
INSERT INTO `sys_user_role` VALUES ('f938ba96fa1e40c78a09394d0dcd0785', '40288ab85ce3c20a015ce3ca6df60000', '402880e45b5d7636015b5d8baca60000');

-- ----------------------------
-- Table structure for task_schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `task_schedule_job`;
CREATE TABLE `task_schedule_job` (
  `id` varchar(32) NOT NULL,
  `cron_expression` varchar(255) NOT NULL COMMENT 'cron表达式',
  `method_name` varchar(255) NOT NULL COMMENT '任务调用的方法名',
  `method_params` varchar(255) DEFAULT NULL COMMENT '请求参数',
  `misfire_policy` varchar(4) DEFAULT NULL COMMENT '执行策略',
  `is_concurrent` varchar(255) DEFAULT NULL COMMENT '任务是否有状态',
  `description` varchar(255) DEFAULT NULL COMMENT '任务描述',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `job_status` varchar(255) DEFAULT NULL COMMENT '任务状态',
  `job_group` varchar(255) DEFAULT NULL COMMENT '任务分组',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `execute_class` varchar(255) DEFAULT NULL COMMENT 'Spring bean',
  `job_name` varchar(255) DEFAULT NULL COMMENT '任务名',
  `load_way` varchar(1) DEFAULT NULL COMMENT '加载任务方式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task_schedule_job
-- ----------------------------

-- ----------------------------
-- Table structure for task_schedule_job_log
-- ----------------------------
DROP TABLE IF EXISTS `task_schedule_job_log`;
CREATE TABLE `task_schedule_job_log` (
  `id` varchar(32) NOT NULL COMMENT '任务日志ID',
  `job_name` varchar(64) NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) NOT NULL COMMENT '任务组名',
  `method_name` varchar(500) DEFAULT NULL COMMENT '任务方法',
  `method_params` varchar(200) DEFAULT '' COMMENT '方法参数',
  `job_message` varchar(500) DEFAULT NULL COMMENT '日志信息',
  `status` char(2) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` text COMMENT '异常信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务调度日志表';

-- ----------------------------
-- Records of task_schedule_job_log
-- ----------------------------