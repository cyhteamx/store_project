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
INSERT INTO `tb_sys_menu` VALUES (1,'系统管理',NULL,'/admin','1','01',0,0,0,'el-icon-date','Layout',0,0,'2017-11-07 20:56:00','2018-04-20 13:50:20'),(2,'用户管理',NULL,'user','views/admin/user/index','0101',1,1,1,'el-icon-date','views/admin/user/index',0,0,'2017-11-02 22:24:37','2018-04-20 13:50:23'),(3,'菜单管理',NULL,'menu','views/admin/user/index','0102',1,1,1,'el-icon-date','views/admin/menu/index',0,0,'2017-11-08 09:57:27','2018-04-20 13:50:25'),(4,'角色管理',NULL,'role','views/admin/role/index','0103',1,1,1,'el-icon-date','views/admin/role/index',0,0,'2017-11-08 10:13:37','2018-04-20 13:50:27'),(5,'订单',NULL,NULL,'order','04',0,1,0,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(6,'商品',NULL,NULL,'2','02',0,1,0,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(7,'列表',NULL,NULL,'product_list','0201',1,2,6,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(8,'新增',NULL,NULL,'product_create','0202',1,2,6,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(9,'类目',NULL,NULL,'','03',0,1,0,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(10,'列表',NULL,NULL,'category_list','0301',1,2,9,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46'),(11,'新增',NULL,NULL,'category_create','0302',1,2,9,'el-icon-date',NULL,0,0,'2018-04-15 13:09:46','2018-04-15 13:09:46');
/*!40000 ALTER TABLE `tb_sys_menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-01  0:31:50
