-- 问题分类字典：1.JS 2.CSS 3.HTML 4.es6 5.vue 6.nodeJs

DROP TABLE IF EXISTS `defront_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_user` (
  `id` varchar(32) NOT NULL AUTO_INCREMENT,
  `username` varchar(63) NOT NULL COMMENT '用户名称',
  `password` varchar(63) NOT NULL DEFAULT '' COMMENT '用户密码',
  `gender` tinyint(3) NOT NULL DEFAULT '0' COMMENT '性别：0 未知， 1男， 1 女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `last_login_time` datetime DEFAULT NULL COMMENT '最近一次登录时间',
  `last_login_ip` varchar(63) NOT NULL DEFAULT '' COMMENT '最近一次登录IP地址',
  `user_level` tinyint(3) DEFAULT '0' COMMENT '0 普通用户，1 VIP用户，2 高级VIP用户',
  `nickname` varchar(63) NOT NULL DEFAULT '' COMMENT '用户昵称或网络名称',
  `mobile` varchar(20) NOT NULL DEFAULT '' COMMENT '用户手机号码',
  `avatar` varchar(255) NOT NULL DEFAULT '' COMMENT '用户头像图片',
  `weixin_openid` varchar(63) NOT NULL DEFAULT '' COMMENT '微信登录openid',
  `session_key` varchar(100) NOT NULL DEFAULT '' COMMENT '微信登录会话KEY',
  `status` tinyint(3) NOT NULL DEFAULT '0' COMMENT '0 可用, 1 禁用, 2 注销',
  `add_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


DROP TABLE IF EXISTS `defront_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_question` (
  `id` varchar(32) NOT NULL,
  `question` varchar(100) NOT NULL COMMENT '问题',
  `answer` varchar(2000) NOT NULL DEFAULT '' COMMENT '答案',
  `type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '类型：0 未知， 1 js，2 css 3 html 4 es6 5 nodejs 6 vue',
  `keywords` varchar(50) DEFAULT NULL COMMENT '关键字',
  `clicks` int(50) NOT NULL DEFAULT '0' COMMENT '点击量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='问题表';



DROP TABLE IF EXISTS `defront_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_company` (
  `id` varchar(32) NOT NULL,
  `name` varchar(100) NOT NULL COMMENT '公司名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司表';

DROP TABLE IF EXISTS `defront_question_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_question_company` (
  `id` varchar(32) NOT NULL,
  `quetion` varchar(100) NOT NULL COMMENT '问题',
  `quetion_id` varchar(32) NOT NULL COMMENT '问题ID',
  `company_id` varchar(32) NOT NULL COMMENT '公司ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司问题关联表';


DROP TABLE IF EXISTS `defront_personal_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_personal_question` (
  `id` varchar(32) NOT NULL,
  `question` varchar(100) NOT NULL COMMENT '问题',
  `my_answer` varchar(2000) NOT NULL DEFAULT '' COMMENT '我的答案',
  `is_open` tinyint(3) NOT NULL DEFAULT '0' COMMENT '是否公开：0 不公开， 1 公开',
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户Id',
  `keywords` varchar(200) NOT NULL DEFAULT '' COMMENT '关键字',
  `weight` int(50) NOT NULL DEFAULT '0' COMMENT '权重',
  `common_id` varchar(32) NOT NULL DEFAULT '' COMMENT '常见问题Id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='个人常见问题表';


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


DROP TABLE IF EXISTS `defront_mark_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_mark_question` (
  `id` varchar(32) NOT NULL,
  `question` varchar(100) NOT NULL COMMENT '问题',
  `question_id` varchar(32) NOT NULL COMMENT '问题Id',
  `answer` varchar(2000) NOT NULL DEFAULT '' COMMENT '答案',
  `keywords` varchar (100) NOT NULL DEFAULT '' COMMENT '关键字',
  `weight` int (3) NOT NULL DEFAULT '0' COMMENT '排序',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='个人标注问题表';


DROP TABLE IF EXISTS `defront_company_discuss`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_company_discuss` (
  `id` varchar(32) NOT NULL,
  `company_id` varchar(32) NOT NULL COMMENT '公司Id',
  `discuss` varchar(500) NOT NULL DEFAULT '' COMMENT '评论',
  `user_id` varchar (32) NOT NULL DEFAULT '' COMMENT '用户Id',
  `nick_name` varchar (50) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `avatar` varchar (500) NOT NULL DEFAULT '' COMMENT '头像',
  `discuss_time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司评论表';


DROP TABLE IF EXISTS `defront_question_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_question_company` (
  `id` varchar(32) NOT NULL,
  `company_id` varchar(32) NOT NULL COMMENT '公司Id',
  `question` varchar (200) NOT NULL DEFAULT '' COMMENT '问题',
  `question_id` varchar (32) NOT NULL DEFAULT '' COMMENT '问题Id',
  `type` varchar (10) NOT NULL DEFAULT '' COMMENT '问题类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司问题关联表';


DROP TABLE IF EXISTS `defront_training_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_training_question` (
  `id` varchar(32) NOT NULL,
  `question` varchar(32) NOT NULL COMMENT '公司Id',
  `type` tinyint(3) NOT NULL DEFAULT '0' COMMENT '问题类型：0 单选， 1 多选',
  `category` tinyint(3) NOT NULL DEFAULT '0' COMMENT '问题分类：0 js， 1 Html，2',
  `tip` varchar(100) NOT NULL COMMENT '问题提示',
  `order_index` int(5) NOT NULL COMMENT '问题排序',
  `analysis` varchar(300) NOT NULL COMMENT '答案解析',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='练习题库';


DROP TABLE IF EXISTS `defront_question_option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_question_option` (
  `id` varchar(32) NOT NULL,
  `question_id` varchar(32) NOT NULL COMMENT '关联问题',
  `option_val` varchar(200) NOT NULL DEFAULT '' COMMENT '选项答案',
  `is_answer` tinyint(1) NOT NULL DEFAULT '' COMMENT '是否是正确答案 0 false,1 true',
  `weight` int(3) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='题目选项';


DROP TABLE IF EXISTS `defront_do_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_do_question` (
  `id` varchar(32) NOT NULL,
  `question_id` varchar(32) NOT NULL COMMENT '关联问题',
  `question` varchar(200) NOT NULL COMMENT '问题',
  `user_id` varchar(32) NOT NULL COMMENT '用户Id',
  `is_true` tinyint(3) NOT NULL COMMENT '是否正确 0 不正确,1 正确',
  `do_time` datetime DEFAULT NULL COMMENT '做题时间',
  `category` int(3) DEFAULT NULL DEFAULT 0 COMMENT '题目类型',
  `str_date` varchar(15) DEFAULT NULL COMMENT '字符串型日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='个人做题集';

DROP TABLE IF EXISTS `defront_publish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_publish` (
  `id` varchar(32) NOT NULL,
  `content` varchar(500) NOT NULL DEFAULT '' COMMENT '内容',
  `html` varchar(2000) NOT NULL DEFAULT '' COMMENT '内容',
  `user_id` varchar (32) NOT NULL DEFAULT '' COMMENT '用户Id',
  `nick_name` varchar (50) NOT NULL DEFAULT '' COMMENT '用户昵称',
  `avatar` varchar (500) NOT NULL DEFAULT '' COMMENT '头像',
  `publish_time_str` varchar (20) NOT NULL DEFAULT '' COMMENT '发布时间,字符串格式',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `clicks` int(5) NOT NULL COMMENT '点赞数',
  `review_num` int(5) NOT NULL COMMENT '评论数',
  `anonymous` tinyint(3) NOT NULL COMMENT '是否匿名 0 不正确,1 正确',
  `category` varchar (50) NOT NULL DEFAULT '' COMMENT '发布类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='信息发布表';

DROP TABLE IF EXISTS `defront_clock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_clock` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户Id',
  `clock_time_str` varchar(20) NOT NULL DEFAULT '' COMMENT '打卡时间',
  `continue_day` int (5) NOT NULL DEFAULT 1 COMMENT '连续打卡天数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='打卡表';

DROP TABLE IF EXISTS `defront_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_article` (
  `id` varchar(32) NOT NULL,
  `category` varchar(10) NOT NULL DEFAULT '' COMMENT '类型',
  `title` varchar(200) NOT NULL DEFAULT '' COMMENT '标题',
  `label` varchar (500) NOT NULL DEFAULT '' COMMENT '简介',
  `url` varchar (20) NOT NULL DEFAULT '' COMMENT '链接',
  `publish_year` varchar (20) NOT NULL DEFAULT '' COMMENT '发布年份',
  `publish_date` varchar (20) NOT NULL DEFAULT '' COMMENT '发布日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章表';


DROP TABLE IF EXISTS `defront_advice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_advice` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户Id',
  `advice` varchar(200) NOT NULL DEFAULT '' COMMENT '建议',
  `advice_time` datetime DEFAULT null COMMENT '建议时间',
  `detail_id` varchar(32) DEFAULT null COMMENT '建议详情ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='建议表';

DROP TABLE IF EXISTS `defront_article_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_article_detail` (
  `id` varchar(32) NOT NULL,
  `article` varchar(5000) NOT NULL DEFAULT '' COMMENT '文章',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='文章详情表';

DROP TABLE IF EXISTS `defront_interview_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_interview_records` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
  `company` varchar(50) NOT NULL DEFAULT '' COMMENT '面试公司名称',
  `company_id` varchar(32) NOT NULL DEFAULT '' COMMENT '面试公司ID',
  `is_review` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否评价',
  `interview_time` datetime DEFAULT null COMMENT '面试时间',
  `interview_date_str` varchar(20)  NOT NULL DEFAULT '' COMMENT '面试时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='面试记录表';

DROP TABLE IF EXISTS `defront_clicks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `defront_clicks` (
  `id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL DEFAULT '' COMMENT '用户ID',
  `concat_id` varchar(32) NOT NULL DEFAULT '' COMMENT '关联ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='点赞表';

