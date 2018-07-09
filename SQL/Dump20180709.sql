CREATE DATABASE  IF NOT EXISTS `store` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `store`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: store
-- ------------------------------------------------------
-- Server version	5.7.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `TB_MENU`
--

DROP TABLE IF EXISTS `TB_MENU`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TB_MENU` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `NAME` varchar(90) DEFAULT NULL COMMENT '菜单名称',
  `URL` varchar(150) DEFAULT NULL COMMENT '菜单URL',
  `NUMBER` varchar(20) DEFAULT NULL COMMENT '序号',
  `ISLEAF` smallint(6) DEFAULT NULL COMMENT '是否叶子节点:0父节点,1叶节点',
  `LEVEL` smallint(6) DEFAULT NULL COMMENT '层级:一级菜单,二级菜单,三级菜单',
  `PARENT_ID` bigint(20) NOT NULL DEFAULT '0' COMMENT '父节点:一级菜单为0',
  `ICON` varchar(50) DEFAULT NULL COMMENT '菜单icon',
  `CREATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_TIME` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TB_MENU`
--

LOCK TABLES `TB_MENU` WRITE;
/*!40000 ALTER TABLE `TB_MENU` DISABLE KEYS */;
INSERT INTO `TB_MENU` VALUES (1,'订单','order','01',0,1,0,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(2,'商品','##','02',0,1,0,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(3,'列表','product_list','0201',1,2,2,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(4,'新增','product_create','0202',1,2,2,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(5,'类目','*','03',0,1,0,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(6,'列表','category_list','0301',1,2,5,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(7,'新增','category_create','0302',1,2,5,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46');
/*!40000 ALTER TABLE `TB_MENU` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gateway_api_define`
--

DROP TABLE IF EXISTS `gateway_api_define`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gateway_api_define` (
  `id` varchar(50) NOT NULL,
  `path` varchar(255) NOT NULL,
  `service_id` varchar(50) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `retryable` tinyint(1) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `strip_prefix` int(11) DEFAULT NULL,
  `api_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gateway_api_define`
--

LOCK TABLES `gateway_api_define` WRITE;
/*!40000 ALTER TABLE `gateway_api_define` DISABLE KEYS */;
INSERT INTO `gateway_api_define` VALUES ('oooo','/tttt/**',NULL,'http://localhost:8090',0,1,1,NULL),('pppp','/pppp/**',NULL,'http://localhost:8090',0,1,1,NULL);
/*!40000 ALTER TABLE `gateway_api_define` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_authority`
--

DROP TABLE IF EXISTS `sys_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(50) NOT NULL,
  `created_date` tinyblob NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` tinyblob,
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_authority`
--

LOCK TABLES `sys_authority` WRITE;
/*!40000 ALTER TABLE `sys_authority` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_menu`
--

DROP TABLE IF EXISTS `sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) DEFAULT NULL COMMENT '前端URL',
  `url` varchar(128) DEFAULT NULL COMMENT '请求链接',
  `method` varchar(32) DEFAULT NULL COMMENT '请求方法',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `component` varchar(64) DEFAULT NULL COMMENT 'VUE页面',
  `sort` int(11) DEFAULT '1' COMMENT '排序值',
  `type` char(1) DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '0--正常 1--删除',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_menu`
--

LOCK TABLES `sys_menu` WRITE;
/*!40000 ALTER TABLE `sys_menu` DISABLE KEYS */;
INSERT INTO `sys_menu` VALUES (1,'系统管理',NULL,'/admin',NULL,NULL,-1,'icon-xitongguanli','Layout',1,'0','2017-11-07 20:56:00','2018-05-14 21:53:22','0'),(2,'用户管理',NULL,'user','',NULL,1,'icon-yonghuguanli','views/admin/user/index',2,'0','2017-11-02 22:24:37','2018-05-14 22:11:35','0'),(3,'菜单管理',NULL,'menu','',NULL,1,'icon-caidanguanli','views/admin/menu/index',3,'0','2017-11-08 09:57:27','2018-05-14 22:11:21','0'),(4,'角色管理',NULL,'role',NULL,NULL,1,'icon-jiaoseguanli','views/admin/role/index',4,'0','2017-11-08 10:13:37','2018-05-14 22:11:19','0'),(5,'日志管理',NULL,'log',NULL,NULL,1,'icon-rizhiguanli','views/admin/log/index',5,'0','2017-11-20 14:06:22','2018-05-14 22:11:18','0'),(6,'字典管理',NULL,'dict',NULL,NULL,1,'icon-zygl','views/admin/dict/index',6,'0','2017-11-29 11:30:52','2018-05-14 22:12:48','0'),(7,'部门管理',NULL,'dept',NULL,NULL,1,'icon-iconbmgl','views/admin/dept/index',7,'0','2018-01-20 13:17:19','2018-05-14 22:11:16','0'),(8,'系统监控',NULL,'',NULL,NULL,-1,'icon-iconbmgl',NULL,8,'0','2018-01-22 12:30:41','2018-05-14 20:41:16','0'),(9,'服务监控',NULL,'http://139.224.200.249:5001',NULL,NULL,8,'icon-jiankong',NULL,9,'0','2018-01-23 10:53:33','2018-04-21 03:51:56','0'),(10,'zipkin监控',NULL,'http://139.224.200.249:5002',NULL,NULL,8,'icon-jiankong',NULL,11,'0','2018-01-23 10:55:18','2018-04-22 07:02:34','0'),(11,'pinpoint监控',NULL,'https://pinpoint.pig4cloud.com',NULL,NULL,8,'icon-xiazaihuancun',NULL,10,'0','2018-01-25 11:08:52','2018-04-22 07:02:38','0'),(12,'缓存状态',NULL,'http://139.224.200.249:8585',NULL,NULL,8,'icon-ecs-status',NULL,12,'0','2018-01-23 10:56:11','2018-04-21 03:51:47','0'),(13,'ELK状态',NULL,'http://139.224.200.249:5601',NULL,NULL,8,'icon-ecs-status',NULL,13,'0','2018-01-23 10:55:47','2018-04-21 03:51:40','0'),(14,'接口文档',NULL,'http://139.224.200.249:9999/swagger-ui.html',NULL,NULL,8,'icon-wendangdocument72',NULL,14,'0','2018-01-23 10:56:43','2018-04-21 03:50:47','0'),(15,'任务监控',NULL,'http://139.224.200.249:8899',NULL,NULL,8,'icon-jiankong',NULL,15,'0','2018-01-23 10:55:18','2018-04-21 03:51:34','0'),(21,'用户查看','',NULL,'/admin/user/**','GET',2,NULL,NULL,NULL,'1','2017-11-07 20:58:05','2018-02-04 14:28:49','0'),(22,'用户新增','sys_user_add',NULL,'/admin/user/*','POST',2,NULL,NULL,NULL,'1','2017-11-08 09:52:09','2017-12-04 16:31:10','0'),(23,'用户修改','sys_user_upd',NULL,'/admin/user/**','PUT',2,NULL,NULL,NULL,'1','2017-11-08 09:52:48','2018-01-17 17:40:01','0'),(24,'用户删除','sys_user_del',NULL,'/admin/user/*','DELETE',2,NULL,NULL,NULL,'1','2017-11-08 09:54:01','2017-12-04 16:31:18','0'),(31,'菜单查看',NULL,NULL,'/admin/menu/**','GET',3,NULL,NULL,NULL,'1','2017-11-08 09:57:56','2017-11-14 17:29:17','0'),(32,'菜单新增','sys_menu_add',NULL,'/admin/menu/*','POST',3,NULL,NULL,NULL,'1','2017-11-08 10:15:53','2018-01-20 14:37:50','0'),(33,'菜单修改','sys_menu_edit',NULL,'/admin/menu/*','PUT',3,NULL,NULL,NULL,'1','2017-11-08 10:16:23','2018-01-20 14:37:56','0'),(34,'菜单删除','sys_menu_del',NULL,'/admin/menu/*','DELETE',3,NULL,NULL,NULL,'1','2017-11-08 10:16:43','2018-01-20 14:38:03','0'),(41,'角色查看',NULL,NULL,'/admin/role/**','GET',4,NULL,NULL,NULL,'1','2017-11-08 10:14:01','2018-02-04 13:55:06','0'),(42,'角色新增','sys_role_add',NULL,'/admin/role/*','POST',4,NULL,NULL,NULL,'1','2017-11-08 10:14:18','2018-04-20 07:21:38','0'),(43,'角色修改','sys_role_edit',NULL,'/admin/role/*','PUT',4,NULL,NULL,NULL,'1','2017-11-08 10:14:41','2018-04-20 07:21:50','0'),(44,'角色删除','sys_role_del',NULL,'/admin/role/*','DELETE',4,NULL,NULL,NULL,'1','2017-11-08 10:14:59','2018-04-20 07:22:00','0'),(45,'分配权限','sys_role_perm',NULL,'/admin/role/*','PUT',4,NULL,NULL,NULL,'1','2018-04-20 07:22:55','2018-04-20 07:24:40','0'),(51,'日志查看',NULL,NULL,'/admin/log/**','GET',5,NULL,NULL,NULL,'1','2017-11-20 14:07:25','2018-02-04 14:28:53','0'),(52,'日志删除','sys_log_del',NULL,'/admin/log/*','DELETE',5,NULL,NULL,NULL,'1','2017-11-20 20:37:37','2017-11-28 17:36:52','0'),(61,'字典查看',NULL,NULL,'/admin/dict/**','GET',6,NULL,NULL,NULL,'1','2017-11-19 22:04:24','2017-11-29 11:31:24','0'),(62,'字典删除','sys_dict_del',NULL,'/admin/dict/**','DELETE',6,NULL,NULL,NULL,'1','2017-11-29 11:30:11','2018-01-07 15:40:51','0'),(63,'字典新增','sys_dict_add',NULL,'/admin/dict/**','POST',6,NULL,NULL,NULL,'1','2018-05-11 22:34:55',NULL,'0'),(64,'字典修改','sys_dict_upd',NULL,'/admin/dict/**','PUT',6,NULL,NULL,NULL,'1','2018-05-11 22:36:03',NULL,'0'),(71,'部门查看','',NULL,'/admin/dept/**','GET',7,NULL,'',NULL,'1','2018-01-20 13:17:19','2018-01-20 14:55:24','0'),(72,'部门新增','sys_dept_add',NULL,'/admin/dept/**','POST',7,NULL,NULL,NULL,'1','2018-01-20 14:56:16','2018-01-20 21:17:57','0'),(73,'部门修改','sys_dept_edit',NULL,'/admin/dept/**','PUT',7,NULL,NULL,NULL,'1','2018-01-20 14:56:59','2018-01-20 21:17:59','0'),(74,'部门删除','sys_dept_del',NULL,'/admin/dept/**','DELETE',7,NULL,NULL,NULL,'1','2018-01-20 14:57:28','2018-01-20 21:18:05','0'),(100,'客户端管理','','client','','',1,'icon-bangzhushouji','views/admin/client/index',9,'0','2018-01-20 13:17:19','2018-05-15 21:28:10','0'),(101,'客户端新增','sys_client_add',NULL,'/admin/client/**','POST',100,'1',NULL,NULL,'1','2018-05-15 21:35:18','2018-05-16 10:35:26','0'),(102,'客户端修改','sys_client_upd',NULL,'/admin/client/**','PUT',100,NULL,NULL,NULL,'1','2018-05-15 21:37:06','2018-05-15 21:52:30','0'),(103,'客户端删除','sys_client_del',NULL,'/admin/client/**','DELETE',100,NULL,NULL,NULL,'1','2018-05-15 21:39:16','2018-05-15 21:52:34','0'),(104,'客户端查看',NULL,NULL,'/admin/client/**','GET',100,NULL,NULL,NULL,'1','2018-05-15 21:39:57','2018-05-15 21:52:40','0'),(110,'路由管理',NULL,'route',NULL,NULL,1,'icon-luyou','views/admin/route/index',8,'0','2018-05-15 21:44:51','2018-05-16 06:58:20','0'),(111,'路由查看',NULL,NULL,'/admin/route/**','GET',110,NULL,NULL,NULL,'1','2018-05-15 21:45:59','2018-05-16 07:23:04','0'),(112,'路由新增','sys_route_add',NULL,'/admin/route/**','POST',110,NULL,NULL,NULL,'1','2018-05-15 21:52:22','2018-05-15 21:53:46','0'),(113,'路由修改','sys_route_upd',NULL,'/admin/route/**','PUT',110,NULL,NULL,NULL,'1','2018-05-15 21:55:38',NULL,'0'),(114,'路由删除','sys_route_del',NULL,'/admin/route/**','DELETE',110,NULL,NULL,NULL,'1','2018-05-15 21:56:45',NULL,'0');
/*!40000 ALTER TABLE `sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `role_code` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `role_desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` char(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  `id` bigint(20) NOT NULL,
  `created_by` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `created_date` tinyblob NOT NULL,
  `last_modified_by` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `last_modified_date` tinyblob,
  `name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `value` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_idx1_role_code` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'admin','ROLE_ADMIN','超级管理员','2017-10-29 15:45:51','2018-04-22 11:40:29','0',0,'','',NULL,NULL,NULL,NULL),(14,'demo','demo','demo用户','2018-04-20 07:14:32','2018-04-21 23:35:22','0',0,'','',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_authorities`
--

DROP TABLE IF EXISTS `sys_role_authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_authorities` (
  `sys_role_id` bigint(20) NOT NULL,
  `authorities_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sys_role_id`,`authorities_id`),
  KEY `FK9oc88v6ini6fjy2spcb8d63no` (`authorities_id`),
  CONSTRAINT `FK9oc88v6ini6fjy2spcb8d63no` FOREIGN KEY (`authorities_id`) REFERENCES `sys_authority` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_authorities`
--

LOCK TABLES `sys_role_authorities` WRITE;
/*!40000 ALTER TABLE `sys_role_authorities` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_role_authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user`
--

DROP TABLE IF EXISTS `sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` varchar(50) NOT NULL,
  `created_date` tinyblob NOT NULL,
  `last_modified_by` varchar(50) DEFAULT NULL,
  `last_modified_date` tinyblob,
  `email` varchar(100) DEFAULT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `image_url` varchar(256) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `password` varchar(60) NOT NULL,
  `username` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_51bvuyvihefoh4kp5syh2jpi4` (`username`),
  UNIQUE KEY `UK_ahtq5ew3v0kt1n7hf1sgp7p8l` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user`
--

LOCK TABLES `sys_user` WRITE;
/*!40000 ALTER TABLE `sys_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_roles`
--

DROP TABLE IF EXISTS `sys_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_roles` (
  `sys_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`sys_user_id`,`roles_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_roles`
--

LOCK TABLES `sys_user_roles` WRITE;
/*!40000 ALTER TABLE `sys_user_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `sys_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_product_category`
--

DROP TABLE IF EXISTS `tb_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_product_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_product_category`
--

LOCK TABLES `tb_product_category` WRITE;
/*!40000 ALTER TABLE `tb_product_category` DISABLE KEYS */;
INSERT INTO `tb_product_category` VALUES (1,'热销榜',2,'2018-01-27 14:46:17','2018-01-27 14:46:17'),(3,'女生最爱',3,'2018-01-28 08:16:53','2018-01-28 08:16:53'),(5,'男生最爱',4,'2018-01-28 09:01:24','2018-01-28 09:01:24'),(6,'男生赚(ˇˍˇ) 想～',10,'2018-01-28 09:44:15','2018-01-28 09:44:15'),(7,'师兄最不爱',101,'2018-02-06 13:33:58','2018-02-06 13:33:58'),(8,'女生最爱',3,'2018-04-13 15:52:10','2018-04-13 15:52:10'),(9,'男生最爱',4,'2018-04-13 15:52:11','2018-04-13 15:52:11'),(11,'男生赚(ˇˍˇ) 想～',10,'2018-04-13 15:52:14','2018-04-13 15:52:14'),(12,'女生最爱',3,'2018-04-13 15:53:37','2018-04-13 15:53:37'),(13,'男生最爱',4,'2018-04-13 15:53:37','2018-04-13 15:53:37'),(15,'男生赚(ˇˍˇ) 想～',10,'2018-04-13 15:53:38','2018-04-13 15:53:38'),(16,'女生最爱',3,'2018-04-13 15:58:17','2018-04-13 15:58:17'),(17,'男生最爱',4,'2018-04-13 15:58:17','2018-04-13 15:58:17'),(19,'男生赚(ˇˍˇ) 想～',10,'2018-04-13 15:58:19','2018-04-13 15:58:19'),(20,'女生最爱',3,'2018-04-13 16:02:02','2018-04-13 16:02:02'),(21,'男生最爱',4,'2018-04-13 16:02:02','2018-04-13 16:02:02'),(23,'男生赚(ˇˍˇ) 想～',10,'2018-04-13 16:02:05','2018-04-13 16:02:05');
/*!40000 ALTER TABLE `tb_product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sys_dept`
--

DROP TABLE IF EXISTS `tb_sys_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sys_dept` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '部门名称',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '是否删除  -1：已删除  0：正常',
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='部门管理';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sys_dept`
--

LOCK TABLES `tb_sys_dept` WRITE;
/*!40000 ALTER TABLE `tb_sys_dept` DISABLE KEYS */;
INSERT INTO `tb_sys_dept` VALUES (1,'山东农信',NULL,'2018-01-22 19:00:23','2018-01-23 12:40:46','0',0),(2,'沙县国际',NULL,'2018-01-22 19:00:38','2018-01-23 12:42:04','0',0),(3,'潍坊农信',NULL,'2018-01-22 19:00:44','2018-01-23 12:40:56','0',1),(4,'高新农信',NULL,'2018-01-22 19:00:52','2018-01-23 12:41:11','0',3),(5,'院校农信',NULL,'2018-01-22 19:00:57','2018-01-23 12:41:22','0',4),(6,'潍坊学院农信',115,'2018-01-22 19:01:06','2018-03-07 16:22:04','0',5),(7,'山东沙县',NULL,'2018-01-22 19:01:57','2018-01-23 12:42:15','0',2),(8,'潍坊沙县',NULL,'2018-01-22 19:02:03','2018-01-23 12:42:23','0',7),(9,'高新沙县',NULL,'2018-01-22 19:02:14','2018-03-07 16:28:14','0',8);
/*!40000 ALTER TABLE `tb_sys_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sys_menu`
--

DROP TABLE IF EXISTS `tb_sys_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(90) DEFAULT NULL COMMENT '菜单名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) DEFAULT NULL COMMENT '前端URL',
  `url` varchar(150) DEFAULT NULL COMMENT '菜单URL',
  `method` varchar(32) DEFAULT NULL,
  `sort` varchar(20) DEFAULT NULL COMMENT '排序值',
  `isleaf` tinyint(1) DEFAULT NULL COMMENT '是否叶子节点:0父节点,1叶节点',
  `level` tinyint(1) DEFAULT NULL COMMENT '层级:一级菜单,二级菜单,三级菜单',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父节点:一级菜单为0',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单icon',
  `component` varchar(64) DEFAULT NULL COMMENT 'VUE页面',
  `type` tinyint(1) DEFAULT NULL COMMENT '菜单类型 （0菜单 1按钮）',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '0--正常 1--删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sys_menu`
--

LOCK TABLES `tb_sys_menu` WRITE;
/*!40000 ALTER TABLE `tb_sys_menu` DISABLE KEYS */;
INSERT INTO `tb_sys_menu` VALUES (1,'系统管理',NULL,'/admin','1',NULL,'01',0,0,0,'el-icon-date','Layout',0,0,'2017-11-07 20:56:00','2018-04-20 13:50:20'),(2,'用户管理',NULL,'user','views/admin/user/index','GET','101',1,1,1,'el-icon-date','views/admin/user/index',0,0,'2017-11-02 22:24:37','2018-04-20 13:50:23'),(3,'菜单管理',NULL,'menu','views/admin/user/index',NULL,'0102',1,1,1,'el-icon-date','views/admin/menu/index',0,0,'2017-11-08 09:57:27','2018-04-20 13:50:25'),(4,'角色管理',NULL,'role','views/admin/role/index',NULL,'0103',1,1,1,'el-icon-date','views/admin/role/index',0,0,'2017-11-08 10:13:37','2018-04-20 13:50:27'),(5,'订单',NULL,NULL,'order',NULL,'04',0,1,0,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(6,'商品',NULL,NULL,'2',NULL,'02',0,1,0,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(7,'列表',NULL,NULL,'product_list',NULL,'0201',1,2,6,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(8,'新增',NULL,NULL,'product_create',NULL,'0202',1,2,6,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(9,'类目',NULL,NULL,'',NULL,'03',0,1,0,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(10,'列表',NULL,NULL,'category_list',NULL,'0301',1,2,9,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(11,'新增',NULL,NULL,'category_create',NULL,'0302',1,2,9,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46');
/*!40000 ALTER TABLE `tb_sys_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sys_oauth_client_details`
--

DROP TABLE IF EXISTS `tb_sys_oauth_client_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sys_oauth_client_details` (
  `client_id` varchar(40) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sys_oauth_client_details`
--

LOCK TABLES `tb_sys_oauth_client_details` WRITE;
/*!40000 ALTER TABLE `tb_sys_oauth_client_details` DISABLE KEYS */;
INSERT INTO `tb_sys_oauth_client_details` VALUES ('app',NULL,'app','server','password,refresh_token',NULL,NULL,NULL,NULL,NULL,'true'),('store',NULL,'$2a$10$wS1qtNOJyGJa7NcH3yYijOjyaFK.boKqo23A8n4n.KbioY5PpCXAG','server','password,refresh_token',NULL,NULL,NULL,NULL,NULL,'false');
/*!40000 ALTER TABLE `tb_sys_oauth_client_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sys_role`
--

DROP TABLE IF EXISTS `tb_sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) NOT NULL COMMENT '角色名称',
  `role_type` int(1) DEFAULT '0' COMMENT '0--普通 1--超级管理员',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_idx1_role_type` (`role_type`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sys_role`
--

LOCK TABLES `tb_sys_role` WRITE;
/*!40000 ALTER TABLE `tb_sys_role` DISABLE KEYS */;
INSERT INTO `tb_sys_role` VALUES (1,'admin',1,'超级管理员','0','2018-05-20 09:01:24','2018-05-31 13:55:48'),(2,'test',2,'管理员','0','2018-05-20 09:01:24','2018-05-31 13:55:48');
/*!40000 ALTER TABLE `tb_sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sys_role_dept`
--

DROP TABLE IF EXISTS `tb_sys_role_dept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sys_role_dept` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `role_id` int(20) DEFAULT NULL COMMENT '角色ID',
  `dept_id` int(20) DEFAULT NULL COMMENT '部门ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色与部门对应关系';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sys_role_dept`
--

LOCK TABLES `tb_sys_role_dept` WRITE;
/*!40000 ALTER TABLE `tb_sys_role_dept` DISABLE KEYS */;
INSERT INTO `tb_sys_role_dept` VALUES (1,1,1),(14,2,1);
/*!40000 ALTER TABLE `tb_sys_role_dept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sys_role_menu`
--

DROP TABLE IF EXISTS `tb_sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sys_role_menu`
--

LOCK TABLES `tb_sys_role_menu` WRITE;
/*!40000 ALTER TABLE `tb_sys_role_menu` DISABLE KEYS */;
INSERT INTO `tb_sys_role_menu` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11);
/*!40000 ALTER TABLE `tb_sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sys_user`
--

DROP TABLE IF EXISTS `tb_sys_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(64) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL,
  `salt` varchar(255) DEFAULT NULL COMMENT '随机盐',
  `phone` varchar(11) NOT NULL COMMENT '手机号',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `dept_id` int(11) DEFAULT NULL COMMENT '部门ID',
  `type` tinyint(1) DEFAULT '0' COMMENT '用户类型',
  `org_code` varchar(50) DEFAULT NULL COMMENT '机构代码',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态: 0-无效, 1-有效',
  `del_flag` tinyint(1) DEFAULT '0' COMMENT '0-正常，1-删除',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_idx1_username` (`username`),
  UNIQUE KEY `user_idx2_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sys_user`
--

LOCK TABLES `tb_sys_user` WRITE;
/*!40000 ALTER TABLE `tb_sys_user` DISABLE KEYS */;
INSERT INTO `tb_sys_user` VALUES (1,'admin','$2a$10$YRuZXxoXcK3X5tzfckzOs.lU4iT1NfE8UZrL8OyO2VPNX9rQ6DOAO',NULL,'110',NULL,'110@qq.com',1,0,NULL,1,0,'2018-05-20 08:55:15','2018-06-16 16:22:43'),(2,'test','$2a$10$IvyJwe4HHzgnm06sY9hABeNsd9NG6AWUcOvDyYO3fYVbN1I7hrvTm',NULL,'12345678900',NULL,NULL,1,0,NULL,1,0,'2018-05-25 16:26:23',NULL);
/*!40000 ALTER TABLE `tb_sys_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sys_user_role`
--

DROP TABLE IF EXISTS `tb_sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sys_user_role`
--

LOCK TABLES `tb_sys_user_role` WRITE;
/*!40000 ALTER TABLE `tb_sys_user_role` DISABLE KEYS */;
INSERT INTO `tb_sys_user_role` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `tb_sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_sys_zuul_route`
--

DROP TABLE IF EXISTS `tb_sys_zuul_route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_sys_zuul_route` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'router Id',
  `path` varchar(255) NOT NULL COMMENT '路由路径',
  `service_id` varchar(255) NOT NULL COMMENT '服务名称',
  `url` varchar(255) DEFAULT NULL COMMENT 'url代理',
  `strip_prefix` char(1) DEFAULT '1' COMMENT '转发去掉前缀',
  `retryable` char(1) DEFAULT '1' COMMENT '是否重试',
  `enabled` char(1) DEFAULT '1' COMMENT '是否启用',
  `sensitiveHeaders_list` varchar(255) DEFAULT NULL COMMENT '敏感请求头',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='动态路由配置表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_sys_zuul_route`
--

LOCK TABLES `tb_sys_zuul_route` WRITE;
/*!40000 ALTER TABLE `tb_sys_zuul_route` DISABLE KEYS */;
INSERT INTO `tb_sys_zuul_route` VALUES (1,'test','test','tsest','1','1','1','0','2018-05-16 07:28:43','2018-05-16 07:35:08','1'),(2,'sdfg','we','jjj','1','1','1','jj','2018-05-16 07:35:43','2018-05-17 13:56:14','1'),(3,'/demo/**','pig-demo-service','','1','1','1','','2018-05-17 14:09:06','2018-05-17 14:32:36','0'),(4,'/admin/**','microservice-store-web-admin','http://localhost:8888/','1','1','1','','2018-05-21 11:40:38','2018-06-22 14:36:58','0'),(5,'/auth/**','microservice-store-auth','','1','1','1','','2018-05-21 11:41:08','2018-06-24 16:19:20','0'),(6,'/user/**','microservice-store-service-user','','1','1','1','','2018-05-21 11:41:08','2018-07-01 16:24:29','0');
/*!40000 ALTER TABLE `tb_sys_zuul_route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `remark` varchar(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES ('PI00000000','spring','spring',30,'admin spring',NULL),('PI00000001','yqqyyq','yqqyyq',28,'such error',NULL),('PI00000002','admin','admin',99,'admin',NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,33,'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',3456,'Alex123'),(2,23,'$2a$04$PCIX2hYrve38M7eOcqAbCO9UqjYg7gfFNpKsinAxh99nms9e.8HwK',7823,'Tom234'),(3,45,'$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu',4234,'Adam');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-09  8:48:57
