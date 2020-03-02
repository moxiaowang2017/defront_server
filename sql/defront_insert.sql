insert into defront_question(id,question,answer,type,keywords,clicks) values ('1233434',' 原型链','object',1,'原型链',3);


insert into defront_company(id,name) values ('1233434',' 杭州无端科技有限公司');


DROP TABLE IF EXISTS `defront_common_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_common_question` (
  `id` varchar(32) NOT NULL,
  `question` varchar(100) NOT NULL COMMENT '问题',
  `question_model` varchar(500) NOT NULL DEFAULT '' COMMENT '问题模版',
  `recommendation` int (5) NOT NULL DEFAULT '0' COMMENT '推荐量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='常见问题表';


insert into defront_common_question(id,question,question_model,recommendation) VALUES (UUID_SHORT(),'自我介绍','自我介绍',0);
insert into defront_common_question(id,question,question_model,recommendation) VALUES (UUID_SHORT(),'项目介绍','自我介绍',0);
insert into defront_common_question(id,question,question_model,recommendation) VALUES (UUID_SHORT(),'如何看待前端开发？','自我介绍',0);
insert into defront_common_question(id,question,question_model,recommendation) VALUES (UUID_SHORT(),'平时是如何学习前端开发的？','自我介绍',0);
insert into defront_common_question(id,question,question_model,recommendation) VALUES (UUID_SHORT(),'未来三到五年的规划是怎样的？','自我介绍',0);