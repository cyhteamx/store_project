use store;

DROP TABLE IF EXISTS `TB_MENU`;

-- 菜单表
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
) ENGINE=InnoDB AUTO_INCREMENT=2308 DEFAULT CHARSET=utf8 COMMENT='菜单表';

INSERT INTO `TB_MENU` VALUES (1,'订单','order','01',0,1,0,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(2,'商品','##','02',0,1,0,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(3,'列表','product_list','0201',1,2,2,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(4,'新增','product_create','0202',1,2,2,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(5,'类目','*','03',0,1,0,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(6,'列表','category_list','0301',1,2,5,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46'),(7,'新增','category_create','0302',1,2,5,'el-icon-date','2018-04-15 13:09:46','2018-04-15 13:09:46');


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
-- Table structure for table `student`
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
-- Dumping data for table `student`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES ('PI00000000','spring','spring',30,'admin spring',NULL),('PI00000001','yqqyyq','yqqyyq',28,'such error',NULL),('PI00000002','admin','admin',99,'admin',NULL);
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-25 13:00:27