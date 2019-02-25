SET NAMES utf8mb4;
SET FOREIGN_KEY_CHEKS = 0;

-- ----------------------------
-- Table structure for ads 广告表
-- ----------------------------
DROP TABLE IF EXISTS  ads ;
CREATE TABLE  ads  (
   id  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
   image  varchar(100) DEFAULT NULL COMMENT '图片地址',
   redirect_to  varchar(200) DEFAULT NULL COMMENT '跳转到',
   active  tinyint(1) unsigned DEFAULT NULL COMMENT '是否活跃',
   time  datetime DEFAULT NULL COMMENT '时间',
   description  text COMMENT '描述',
  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment  评论表
-- ----------------------------
DROP TABLE IF EXISTS  comment ;
CREATE TABLE  comment  (
   id  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
   lesson  bigint(20) unsigned DEFAULT NULL COMMENT '视频',
   time  datetime DEFAULT NULL COMMENT '发布时间',
   star_level  tinyint(3) unsigned DEFAULT NULL COMMENT '星级（1:*, 2:**, 3:***, 4:****, 5:*****）',
   comment  text COMMENT '意见或评论',
  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for course  课程表
-- ----------------------------
DROP TABLE IF EXISTS  course ;
CREATE TABLE  course  (
   id  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
   category  bigint(20) unsigned DEFAULT NULL COMMENT '课程类别',
   name  varchar(50) DEFAULT NULL COMMENT '课程名称',
   cover_image  varchar(100) DEFAULT NULL COMMENT '封面图',
   lecture  bigint(20) unsigned DEFAULT NULL COMMENT '讲师',
   create_time  datetime DEFAULT NULL COMMENT '创建时间',
   introduction  text COMMENT '课程描述',
  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for course_category 课程——类别表
-- ----------------------------
DROP TABLE IF EXISTS  course_category ;
CREATE TABLE  course_category  (
   id  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
   name  varchar(50) DEFAULT NULL COMMENT '课程类别名称',
   icon  varchar(100) DEFAULT NULL COMMENT 'icon',
   cover_image  varchar(100) DEFAULT NULL COMMENT '封面图',
   introduction  text COMMENT '介绍',
   priority  tinyint(3) unsigned DEFAULT NULL COMMENT '优先级',
   create_time  datetime DEFAULT NULL COMMENT '创建时间',
   parent  bigint(20) unsigned DEFAULT NULL COMMENT '上一级',
  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lecture 讲师简介表
-- ----------------------------
DROP TABLE IF EXISTS  lecture ;
CREATE TABLE  lecture  (
   id  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
   name  varchar(50) DEFAULT NULL COMMENT '讲师名称',
   gender  tinyint(3) unsigned DEFAULT NULL COMMENT '性别（1:男性, 2:女性）',
   age  tinyint(10) unsigned DEFAULT NULL COMMENT '年龄',
   level  tinyint(4) unsigned DEFAULT NULL COMMENT '级别（1:高级，2:中级，3:初级）',
   introduction  text COMMENT '介绍',
  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for lesson 视频信息表
-- ----------------------------
DROP TABLE IF EXISTS  lesson ;
CREATE TABLE  lesson  (
   id  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
   course  bigint(20) unsigned DEFAULT NULL COMMENT '课程',
   cover_image  varchar(100) DEFAULT NULL COMMENT '封面图',
   name  varchar(50) DEFAULT NULL COMMENT '视频名称',
   video  varchar(100) DEFAULT NULL COMMENT '视频地址',
   create_time  datetime DEFAULT NULL COMMENT '创建时间',
   introduction  text COMMENT '视频说明',
  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for watch_log  学习日志记录表
-- ----------------------------
DROP TABLE IF EXISTS  watch_log ;
CREATE TABLE  watch_log  (
   id  bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
   lesson  bigint(20) unsigned DEFAULT NULL COMMENT '视频',
   time  datetime DEFAULT NULL COMMENT '观看时间',
  PRIMARY KEY ( id )
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
