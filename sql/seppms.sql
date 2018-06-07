/*
Navicat MySQL Data Transfer

Source Server         : javaweb-fresh
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : seppms

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-07 13:50:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for belong
-- ----------------------------
DROP TABLE IF EXISTS `belong`;
CREATE TABLE `belong` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `userid` int(11) DEFAULT NULL COMMENT '项目组名字',
  `groupid` int(11) DEFAULT NULL COMMENT '项目组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='user属于的项目组';

-- ----------------------------
-- Records of belong
-- ----------------------------
INSERT INTO `belong` VALUES ('2', '5', '1');
INSERT INTO `belong` VALUES ('3', '6', '1');
INSERT INTO `belong` VALUES ('4', '7', '1');
INSERT INTO `belong` VALUES ('11', '10', '5');
INSERT INTO `belong` VALUES ('12', '14', '1');

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL COMMENT '文件名',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file
-- ----------------------------
INSERT INTO `file` VALUES ('1', '软件工程实践环节要求.doc', '../file/软件工程实践环节要求.doc', '2018-05-30 20:41:48');
INSERT INTO `file` VALUES ('2', '2.总体设计说明书(20180428).doc', '../file/2.总体设计说明书(20180428).doc', '2018-05-30 20:44:46');
INSERT INTO `file` VALUES ('3', '3.详细设计说明书（20180428）.doc', '../file/3.详细设计说明书（20180428）.doc', '2018-05-30 20:46:04');

-- ----------------------------
-- Table structure for group_info
-- ----------------------------
DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `name` varchar(255) DEFAULT NULL COMMENT '项目组名字',
  `leaderid` int(11) DEFAULT NULL COMMENT '组长id',
  `teacherid` int(11) DEFAULT NULL COMMENT '老师id',
  `status` int(11) DEFAULT NULL COMMENT '是否被老师确认(1: 是 0: 否)未确认可以退出，加入',
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='项目组';

-- ----------------------------
-- Records of group_info
-- ----------------------------
INSERT INTO `group_info` VALUES ('1', '大神组', '6', '1', '1', '2018-05-29 15:40:37');
INSERT INTO `group_info` VALUES ('5', '大佬组', '10', '1', '1', '2018-06-03 00:00:00');

-- ----------------------------
-- Table structure for leader_task
-- ----------------------------
DROP TABLE IF EXISTS `leader_task`;
CREATE TABLE `leader_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `task` text COMMENT '任务内容',
  `memberid` int(11) DEFAULT NULL COMMENT '组员id',
  `processid` int(11) DEFAULT NULL COMMENT '过程id',
  `groupid` int(11) DEFAULT NULL COMMENT '组id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='组长分配给组员的任务';

-- ----------------------------
-- Records of leader_task
-- ----------------------------
INSERT INTO `leader_task` VALUES ('1', '需求分析中的数据库设计', '5', '1', '1');
INSERT INTO `leader_task` VALUES ('2', '总体设计系统动态建模', '5', '2', '1');

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `teacherid` int(11) DEFAULT NULL COMMENT '评分老师id',
  `studentid` int(11) DEFAULT NULL COMMENT '学生id',
  `daily` int(11) DEFAULT NULL COMMENT '平时成绩',
  `reply` int(11) DEFAULT NULL COMMENT '答辩成绩',
  `document` int(11) DEFAULT NULL COMMENT '文档成绩',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='成绩';

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES ('1', '1', '5', '95', '92', '95');
INSERT INTO `mark` VALUES ('2', '1', '6', '95', '90', '66');
INSERT INTO `mark` VALUES ('3', '1', '7', '90', '75', '92');
INSERT INTO `mark` VALUES ('4', '1', '8', '85', '84', '63');
INSERT INTO `mark` VALUES ('5', '1', '10', '82', '68', '95');

-- ----------------------------
-- Table structure for member_up_file
-- ----------------------------
DROP TABLE IF EXISTS `member_up_file`;
CREATE TABLE `member_up_file` (
  `id` int(11) NOT NULL,
  `leadertaskid` int(11) DEFAULT NULL COMMENT '组长布置任务id',
  `fileid` int(11) DEFAULT NULL COMMENT '文件id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_up_file
-- ----------------------------

-- ----------------------------
-- Table structure for process
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `name` varchar(255) DEFAULT NULL COMMENT '过程名',
  `starttime` datetime DEFAULT NULL COMMENT '开始时间',
  `endtime` datetime DEFAULT NULL COMMENT '结束时间',
  `groupid` int(11) DEFAULT NULL COMMENT '项目组id',
  `teacherid` int(11) DEFAULT NULL COMMENT '指导教师id',
  `upfiles` varchar(255) DEFAULT NULL COMMENT '该阶段的所有组员上传的文件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='过程(默认需求分析开始两个月后结束，其他的都未开始)';

-- ----------------------------
-- Records of process
-- ----------------------------
INSERT INTO `process` VALUES ('1', '需求分析', '2018-06-01 22:00:30', '2018-07-04 22:00:35', '1', '1', null);
INSERT INTO `process` VALUES ('2', '总体设计', '2018-06-06 21:46:21', '2018-07-04 21:46:38', '1', '1', null);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `userid` int(11) DEFAULT NULL COMMENT '回复者',
  `topicid` int(11) DEFAULT NULL COMMENT '话题id',
  `content` text COMMENT '回复内容',
  `createtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='回复';

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '1', '1', '1.新建java项目2.添加java web application模块', '2018-06-01 12:47:32');
INSERT INTO `reply` VALUES ('2', '7', '1', '老师1的过程说的很详细', '2018-06-01 12:58:09');
INSERT INTO `reply` VALUES ('3', '8', '1', '楼上666', '2018-06-01 13:17:08');
INSERT INTO `reply` VALUES ('5', '5', '2', '你猜', '2018-06-01 00:00:00');
INSERT INTO `reply` VALUES ('6', '5', '1', 'hello', '2018-06-01 00:00:00');
INSERT INTO `reply` VALUES ('8', '5', '1', 'world', '2018-06-01 00:00:00');
INSERT INTO `reply` VALUES ('9', '5', '2', 'role relation permission\r\n', '2018-06-01 00:00:00');
INSERT INTO `reply` VALUES ('10', '5', '1', '采集', '2018-06-01 00:00:00');
INSERT INTO `reply` VALUES ('11', '5', '6', 'hello', '2018-06-01 00:00:00');
INSERT INTO `reply` VALUES ('15', '5', '1', '123', '2018-06-02 00:00:00');
INSERT INTO `reply` VALUES ('18', '15', '1', 'hhh', '2018-06-04 00:00:00');
INSERT INTO `reply` VALUES ('19', '5', '1', 'fff ', '2018-06-04 00:00:00');
INSERT INTO `reply` VALUES ('20', '5', '12', '从从v ', '2018-06-05 00:00:00');
INSERT INTO `reply` VALUES ('21', '5', '12', '', '2018-06-05 00:00:00');
INSERT INTO `reply` VALUES ('22', '1', '13', '11', '2018-06-05 00:00:00');
INSERT INTO `reply` VALUES ('23', '5', '14', '玩儿', '2018-06-06 00:00:00');
INSERT INTO `reply` VALUES ('24', '5', '15', '111111444', '2018-06-06 00:00:00');
INSERT INTO `reply` VALUES ('25', '5', '16', '111', '2018-06-07 00:00:00');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父级编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父级编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(11) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(11) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单(1:是 0:不是)',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT NULL COMMENT '菜单状态 : 1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开 : 1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '1', '0', '0', '主页', 'fa-home', '', '1', '0', '1', '', '1', '1');
INSERT INTO `sys_menu` VALUES ('2', '2', '0', '0', '个人信息', 'fa-user', '/user/profile', '2', '0', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('3', '3', '0', '0', '小组', 'fa-group', '/group/findAll', '3', '0', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('4', '4', '0', '0', '信息查询', 'fa-search', null, '4', '0', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('5', '5', '4', '4', '资料文件', 'fa-file', '/info/findAllMandate', '1', '1', '0', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('6', '6', '4', '4', '我的任务', 'fa-tasks', '/info/findAllLeaderTask', '2', '1', '0', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('7', '7', '4', '4', '我的成绩', 'fa-bar-chart', null, '3', '1', '0', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('8', '8', '0', '0', '交流讨论', 'fa-comment', '/topic/findAllTopic', '5', '0', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('9', '9', '0', '0', '分配任务', 'fa-tasks', null, '6', '0', '1', null, '1', '1');

-- ----------------------------
-- Table structure for sys_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation`;
CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `rolename` varchar(255) DEFAULT NULL COMMENT '角色名',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='菜单角色关系';

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
INSERT INTO `sys_relation` VALUES ('1', 'student', '1');
INSERT INTO `sys_relation` VALUES ('2', 'student', '2');
INSERT INTO `sys_relation` VALUES ('3', 'student', '3');
INSERT INTO `sys_relation` VALUES ('4', 'student', '4');
INSERT INTO `sys_relation` VALUES ('5', 'student', '5');
INSERT INTO `sys_relation` VALUES ('6', 'student', '6');
INSERT INTO `sys_relation` VALUES ('7', 'student', '7');
INSERT INTO `sys_relation` VALUES ('8', 'student', '8');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `number` varchar(255) DEFAULT NULL COMMENT '学号',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='角色';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1151401107', 'admin');
INSERT INTO `sys_role` VALUES ('2', '1151401107', 'student');
INSERT INTO `sys_role` VALUES ('4', '1000', 'teacher');
INSERT INTO `sys_role` VALUES ('5', '1151401109', 'student');
INSERT INTO `sys_role` VALUES ('6', '1151401123', 'leader');
INSERT INTO `sys_role` VALUES ('7', '1151602201', 'student');
INSERT INTO `sys_role` VALUES ('8', '1154101119', 'leader');
INSERT INTO `sys_role` VALUES ('9', '1234', 'student');
INSERT INTO `sys_role` VALUES ('10', '1111', 'student');
INSERT INTO `sys_role` VALUES ('11', '11111111', 'student');
INSERT INTO `sys_role` VALUES ('12', '1024', 'student');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `number` varchar(255) DEFAULT NULL COMMENT '学号/工号(这就是账号)',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `sex` int(11) DEFAULT NULL COMMENT '性别(1:男 2:女)',
  `classname` varchar(255) DEFAULT NULL COMMENT '班级名',
  `email` varchar(255) DEFAULT NULL COMMENT '电邮',
  `specialty` varchar(255) DEFAULT NULL COMMENT '专长',
  `hobby` varchar(255) DEFAULT NULL COMMENT '爱好',
  `status` int(11) DEFAULT NULL COMMENT '状态(1:启用 2:冻结即待确认 3:删除)',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户(暂时不用MD5盐加密)';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '../img/1000_small.jpg', '1000', 'b394478f3dadcdadfab2ce684fa2f289', '老师1', '1', '计算机1151', '', '000', '000', '1', '2018-05-25 14:33:58', '8092');
INSERT INTO `sys_user` VALUES ('2', '头像2', '1151401109', '123', 'hi附近', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('5', '../img/1151401107.jpg', '1151401107', '4cabe469432ffd1fd07e5465dd990cea', '黄正果', '1', '计算机1151', 'tideaaliwen@foxmail.com', '精通各种编程语言的helloWorld11', 'hobbyhobbyhobbyfff   ', '0', '2018-05-29 21:22:49', '5658');
INSERT INTO `sys_user` VALUES ('6', '../img/1151401123_small.jpg', '1151401123', 'f52b3232810295ea804600af2479633d', '钟宸', '1', '计算机1151', '', '收钱', 'hobbyhobby', null, '2018-05-29 19:11:43', null);
INSERT INTO `sys_user` VALUES ('7', '../img/1151602201_small.jpg', '1151602201', '2bddb73921722655ea6b4cf72435f8fa', '汤伟', '1', '计算机1151', '1376129835@qq.com', 'ss', 'hobbyhobby', null, '2018-05-29 19:45:16', '3914');
INSERT INTO `sys_user` VALUES ('8', '../img/1151101434_small.jpg', '1151101434', '7af18770f2c402263884fa3da36ebace', '吴科柯', '0', '计算机1151', null, null, null, '0', null, null);
INSERT INTO `sys_user` VALUES ('10', '../img/qq_small.jpg', '1154101119', 'feb0876eed1cea817f4962e33cf964b2', '张宇', '0', null, null, null, null, '0', '2018-06-01 00:00:00', null);
INSERT INTO `sys_user` VALUES ('11', '../img/qq_small.jpg', '123456', '579d9ec9d0c3d687aaa91289ac2854e4', '测试注册', '0', null, null, null, null, '0', '2018-06-03 00:00:00', null);
INSERT INTO `sys_user` VALUES ('12', '../img/qq_small.jpg', '1234', '7c9c0b787d24816fe630fc8619564306', '测试注册用户2', '0', null, null, null, null, '0', '2018-06-03 00:00:00', null);
INSERT INTO `sys_user` VALUES ('13', '../img/qq_small.jpg', '1111', 'd4f37ba0ac6672f7030e178079d72315', '测试用户3', '0', null, '838667533@qq.com', null, null, '0', '2018-06-03 00:00:00', null);
INSERT INTO `sys_user` VALUES ('14', '../img/qq_small.jpg', '11111111', 'e357431731843abdd82f5797bb9f53c7', '11111111', '0', null, '838667533@qq.com', null, null, '0', '2018-06-04 00:00:00', null);
INSERT INTO `sys_user` VALUES ('15', '../img/qq_small.jpg', '1024', 'a8f636eefb892d8a1dbbc1148788611c', 'huang zhengguo', '0', null, '838667533@qq.com', null, null, '0', '2018-06-04 00:00:00', null);

-- ----------------------------
-- Table structure for teacher_task
-- ----------------------------
DROP TABLE IF EXISTS `teacher_task`;
CREATE TABLE `teacher_task` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `teacherid` int(11) DEFAULT NULL COMMENT '老师id',
  `task` text COMMENT '任务内容',
  `outline` text COMMENT '任务大纲',
  `createtime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='老师发布给项目组的总任务，所有组都一样';

-- ----------------------------
-- Records of teacher_task
-- ----------------------------
INSERT INTO `teacher_task` VALUES ('1', '1', '完成需求分析', '1.xxxxxxxxxx 2.xxxxxxxxxx', '2018-05-30 20:41:18');

-- ----------------------------
-- Table structure for teacher_up_file
-- ----------------------------
DROP TABLE IF EXISTS `teacher_up_file`;
CREATE TABLE `teacher_up_file` (
  `id` int(11) NOT NULL,
  `teachertaskid` int(11) DEFAULT NULL,
  `fileid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher_up_file
-- ----------------------------
INSERT INTO `teacher_up_file` VALUES ('1', '1', '2');
INSERT INTO `teacher_up_file` VALUES ('2', '1', '3');
INSERT INTO `teacher_up_file` VALUES ('3', '1', '1');

-- ----------------------------
-- Table structure for topic
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增',
  `userid` int(11) DEFAULT NULL COMMENT '发起者',
  `title` varchar(255) DEFAULT NULL COMMENT '主题标题',
  `content` text COMMENT '详细内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='话题讨论';

-- ----------------------------
-- Records of topic
-- ----------------------------
INSERT INTO `topic` VALUES ('1', '5', '如何在idea创建javaweb程序', 'IntelliJ IDEA是java语言开发的集成环境，IntelliJ在业界被公认为最好的java开发工具之一，尤其在智能代码助手、代码自动提示、重构、J2EE支持、各类版本控制工具(git、svn、github等)、JUnit、CVS整合、代码分析、 创新的GUI设计等方面的功能可以说是超常的。IDEA是JetBrains公司的产品，这家公司总部位于捷克共和国的首都布拉格，开发人员以严谨著称的东欧程序员为主。它的旗舰版本还支持HTML，CSS，PHP，MySQL，Python等。免费版只支持Java等少数语言。', '2018-05-31 09:50:10');
INSERT INTO `topic` VALUES ('2', '6', '如何引入权限控制', '如何实现a)	角色、权限管理，角色有：组员、组长、指导教师，不同的角色具有不同的权限。', '2018-05-31 10:33:23');
INSERT INTO `topic` VALUES ('3', '7', 'java的io流的使用', '如何使用io流实现文件的上传', '2018-05-31 10:34:18');
INSERT INTO `topic` VALUES ('4', '5', '如何使用单元测试', '请问各位大佬，如何使用Jutil进行单元测试', '2018-06-01 00:00:00');
INSERT INTO `topic` VALUES ('5', '5', '如何使用单元测试', '  官方刚刚', '2018-06-01 00:00:00');
INSERT INTO `topic` VALUES ('6', '5', 'hello', '甲级', '2018-06-01 00:00:00');
INSERT INTO `topic` VALUES ('8', '10', '测试标题', '测试内容测试内容', '2018-06-02 00:00:00');
INSERT INTO `topic` VALUES ('11', '5', 'sss', 'kgl;dfgk\r\n4564654\r\nksjflksdf', '2018-06-04 00:00:00');
INSERT INTO `topic` VALUES ('12', '5', '如何使用单元测试', '当场出彩错 ', '2018-06-05 00:00:00');
INSERT INTO `topic` VALUES ('13', '1', '11', '11', '2018-06-05 00:00:00');
INSERT INTO `topic` VALUES ('14', '5', '如何使用单元测试', '儿童', '2018-06-06 00:00:00');
INSERT INTO `topic` VALUES ('15', '5', '如何使用单元测试', '1111', '2018-06-06 00:00:00');
INSERT INTO `topic` VALUES ('16', '5', '如何使用单元测试', '123', '2018-06-07 00:00:00');
SET FOREIGN_KEY_CHECKS=1;
