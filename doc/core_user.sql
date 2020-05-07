DROP TABLE IF EXISTS `core_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `core_user` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(16) DEFAULT NULL,
  `NAME` varchar(16) DEFAULT NULL,
  `PASSWORD` varchar(64) DEFAULT NULL,
  `CREATE_TIME` datetime(6) DEFAULT NULL,
  `ORG_ID` int(65) DEFAULT NULL,
  `STATE` varchar(16) DEFAULT NULL COMMENT '用户状态 1:启用 0:停用',
  `JOB_TYPE1` varchar(16) DEFAULT NULL,
  `DEL_FLAG` tinyint(6) DEFAULT NULL COMMENT '用户删除标记 0:未删除 1:已删除',
  `update_Time` datetime DEFAULT NULL,
  `JOB_TYPE0` varchar(16) DEFAULT NULL,
  `attachment_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;