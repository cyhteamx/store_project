use store;

DROP TABLE IF EXISTS `TB_MENU`;

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
