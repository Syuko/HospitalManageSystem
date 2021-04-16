/*
Navicat MySQL Data Transfer

Source Server         : myconnect
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : hospitalsystem

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2021-04-16 17:34:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed` (
  `bedId` int(11) NOT NULL AUTO_INCREMENT,
  `bedName` varchar(20) DEFAULT NULL,
  `homeId` int(11) DEFAULT NULL,
  `patientId` int(11) DEFAULT NULL,
  PRIMARY KEY (`bedId`)
) ENGINE=InnoDB AUTO_INCREMENT=83 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES ('1', 'A', '1', '5');
INSERT INTO `bed` VALUES ('2', 'B', '1', '4');
INSERT INTO `bed` VALUES ('3', 'C', '1', '33');
INSERT INTO `bed` VALUES ('4', 'D', '1', '32');
INSERT INTO `bed` VALUES ('5', 'A', '2', '6');
INSERT INTO `bed` VALUES ('6', 'B', '2', '3');
INSERT INTO `bed` VALUES ('7', 'C', '2', '29');
INSERT INTO `bed` VALUES ('8', 'D', '2', '13');
INSERT INTO `bed` VALUES ('9', 'A', '3', null);
INSERT INTO `bed` VALUES ('10', 'B', '3', null);
INSERT INTO `bed` VALUES ('11', 'C', '3', null);
INSERT INTO `bed` VALUES ('12', 'D', '3', null);
INSERT INTO `bed` VALUES ('17', 'A', '5', null);
INSERT INTO `bed` VALUES ('18', 'B', '5', null);
INSERT INTO `bed` VALUES ('19', 'C', '5', null);
INSERT INTO `bed` VALUES ('20', 'D', '5', null);
INSERT INTO `bed` VALUES ('21', 'A', '6', null);
INSERT INTO `bed` VALUES ('22', 'B', '6', null);
INSERT INTO `bed` VALUES ('23', 'C', '6', null);
INSERT INTO `bed` VALUES ('24', 'D', '6', null);
INSERT INTO `bed` VALUES ('25', 'A', '7', null);
INSERT INTO `bed` VALUES ('26', 'B', '7', null);
INSERT INTO `bed` VALUES ('27', 'C', '7', null);
INSERT INTO `bed` VALUES ('28', 'D', '7', null);
INSERT INTO `bed` VALUES ('29', 'A', '8', null);
INSERT INTO `bed` VALUES ('30', 'B', '8', null);
INSERT INTO `bed` VALUES ('31', 'C', '8', null);
INSERT INTO `bed` VALUES ('32', 'D', '8', null);
INSERT INTO `bed` VALUES ('33', 'A', '11', null);
INSERT INTO `bed` VALUES ('34', 'B', '11', null);
INSERT INTO `bed` VALUES ('35', 'C', '11', null);
INSERT INTO `bed` VALUES ('36', 'D', '11', null);
INSERT INTO `bed` VALUES ('37', 'A', '12', null);
INSERT INTO `bed` VALUES ('38', 'B', '12', null);
INSERT INTO `bed` VALUES ('39', 'C', '12', null);
INSERT INTO `bed` VALUES ('40', 'D', '12', null);
INSERT INTO `bed` VALUES ('41', 'A', '13', null);
INSERT INTO `bed` VALUES ('42', 'B', '13', null);
INSERT INTO `bed` VALUES ('43', 'C', '13', null);
INSERT INTO `bed` VALUES ('44', 'D', '13', null);
INSERT INTO `bed` VALUES ('45', 'A', '14', null);
INSERT INTO `bed` VALUES ('46', 'B', '14', null);
INSERT INTO `bed` VALUES ('47', 'C', '14', null);
INSERT INTO `bed` VALUES ('48', 'D', '14', null);
INSERT INTO `bed` VALUES ('49', 'A', '15', null);
INSERT INTO `bed` VALUES ('50', 'B', '15', null);
INSERT INTO `bed` VALUES ('51', 'C', '15', null);
INSERT INTO `bed` VALUES ('52', 'D', '15', null);
INSERT INTO `bed` VALUES ('53', 'A', '16', null);
INSERT INTO `bed` VALUES ('54', 'B', '16', null);
INSERT INTO `bed` VALUES ('55', 'C', '16', null);
INSERT INTO `bed` VALUES ('56', 'D', '16', null);
INSERT INTO `bed` VALUES ('57', 'A', '17', null);
INSERT INTO `bed` VALUES ('58', 'B', '17', null);
INSERT INTO `bed` VALUES ('59', 'C', '17', null);
INSERT INTO `bed` VALUES ('60', 'D', '17', null);
INSERT INTO `bed` VALUES ('61', 'A', '18', null);
INSERT INTO `bed` VALUES ('62', 'B', '18', null);
INSERT INTO `bed` VALUES ('63', 'C', '18', null);
INSERT INTO `bed` VALUES ('64', 'D', '18', null);
INSERT INTO `bed` VALUES ('65', 'A', '19', '7');
INSERT INTO `bed` VALUES ('67', 'A', '9', null);
INSERT INTO `bed` VALUES ('68', 'B', '9', null);
INSERT INTO `bed` VALUES ('69', 'C', '9', null);
INSERT INTO `bed` VALUES ('70', 'D', '9', null);
INSERT INTO `bed` VALUES ('78', 'A', '48', null);
INSERT INTO `bed` VALUES ('79', 'B', '48', null);
INSERT INTO `bed` VALUES ('80', 'C', '48', null);
INSERT INTO `bed` VALUES ('82', null, '48', null);

-- ----------------------------
-- Table structure for build
-- ----------------------------
DROP TABLE IF EXISTS `build`;
CREATE TABLE `build` (
  `buildName` varchar(50) NOT NULL,
  `buildTierNum` int(11) NOT NULL,
  `buildHomeNum` int(11) NOT NULL,
  PRIMARY KEY (`buildName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of build
-- ----------------------------
INSERT INTO `build` VALUES ('DH0001', '4', '18');
INSERT INTO `build` VALUES ('DH0002', '4', '18');
INSERT INTO `build` VALUES ('DH0003', '5', '3');
INSERT INTO `build` VALUES ('DH0004', '3', '3');

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge` (
  `chargeId` int(11) NOT NULL AUTO_INCREMENT,
  `patientId` int(11) NOT NULL,
  `nurseId` int(11) NOT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`chargeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of charge
-- ----------------------------

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `doctorId` int(11) NOT NULL AUTO_INCREMENT,
  `doctorName` varchar(50) NOT NULL,
  `doctorPassword` varchar(255) NOT NULL,
  `doctorSex` char(1) DEFAULT NULL,
  `doctorAge` int(11) DEFAULT NULL,
  `doctorPhone` varchar(50) DEFAULT NULL,
  `doctorDep` varchar(50) DEFAULT NULL,
  `doctorPosition` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`doctorId`)
) ENGINE=InnoDB AUTO_INCREMENT=212021006 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('212021001', '飞彩', '111111', 'f', '22', '45642621226', '儿科', '住院医生');
INSERT INTO `doctor` VALUES ('212021002', '永梦', '123456', 'm', '20', '18220089563', '儿科', '住院医生');
INSERT INTO `doctor` VALUES ('212021003', '大我', '123456', 'm', '20', '11256631562', '外科', '主治医生');
INSERT INTO `doctor` VALUES ('212021004', '帕拉德', '123456', 'f', '50', '15232366655', '外科', '副主任');
INSERT INTO `doctor` VALUES ('212021005', '战极', '123456', 'm', '45', '14512265554', '儿科', '主任');

-- ----------------------------
-- Table structure for drug
-- ----------------------------
DROP TABLE IF EXISTS `drug`;
CREATE TABLE `drug` (
  `drugId` int(11) NOT NULL AUTO_INCREMENT,
  `drugName` varchar(50) DEFAULT NULL,
  `drugNum` int(11) DEFAULT NULL,
  `drugAdd` varchar(255) DEFAULT NULL,
  `drugPrice` decimal(10,2) DEFAULT NULL,
  `drugType` varchar(20) DEFAULT NULL COMMENT '分甲乙',
  `drugRate` float DEFAULT NULL,
  PRIMARY KEY (`drugId`)
) ENGINE=InnoDB AUTO_INCREMENT=202100018 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drug
-- ----------------------------
INSERT INTO `drug` VALUES ('202100001', '小柴胡', '0', '1号柜', '23.50', '甲', '0');
INSERT INTO `drug` VALUES ('202100002', '川北枇杷露', '50', '1号柜', '22.20', '甲', '0');
INSERT INTO `drug` VALUES ('202100003', '阿托评片', '88', '1号柜', '54.30', '乙', '0.1');
INSERT INTO `drug` VALUES ('202100004', '安乃近片', '140', '1号柜', '23.00', '乙', '0.1');
INSERT INTO `drug` VALUES ('202100005', '鼻炎康片', '49', '1号柜', '54.00', '甲', '0');
INSERT INTO `drug` VALUES ('202100006', '百服宁', '29', '1号柜', '123.00', '乙', '0.1');
INSERT INTO `drug` VALUES ('202100007', '痰咳经三', '27', '1号柜', '109.00', '乙', '0.1');
INSERT INTO `drug` VALUES ('202100008', '大黄素大片', '50', '1号柜', '33.00', '甲', '0');
INSERT INTO `drug` VALUES ('202100009', '果导片', '50', '1号柜', '34.70', '甲', '0');
INSERT INTO `drug` VALUES ('202100010', '生化丸', '47', '1号柜', '32.60', '甲', '0');
INSERT INTO `drug` VALUES ('202100011', '但是通胶囊', '50', '1号柜', '34.50', '乙', '0.1');
INSERT INTO `drug` VALUES ('202100012', '复方血栓通胶囊', '50', '1号柜', '85.00', '乙', '0.1');
INSERT INTO `drug` VALUES ('202100013', '抗骨增生', '50', '1号柜', '98.00', '乙', '0.1');
INSERT INTO `drug` VALUES ('202100014', '宫炎平胶囊', '50', '1号柜', '66.00', '乙', '0.1');
INSERT INTO `drug` VALUES ('202100017', '盐酸肾上腺素注射液', '60', '1号柜', '543.20', '乙', '0.1');

-- ----------------------------
-- Table structure for d_p
-- ----------------------------
DROP TABLE IF EXISTS `d_p`;
CREATE TABLE `d_p` (
  `dpId` int(11) NOT NULL AUTO_INCREMENT,
  `patientId` int(11) NOT NULL,
  `doctorId` int(11) DEFAULT NULL,
  `dpTime` datetime DEFAULT NULL,
  `shortAdvice` varchar(255) DEFAULT NULL,
  `longAdvice` text,
  PRIMARY KEY (`dpId`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_p
-- ----------------------------
INSERT INTO `d_p` VALUES ('1', '1', '212021001', '2021-03-18 20:54:19', '青霉素皮试', '安慕希路，1天3次，每次一片;');
INSERT INTO `d_p` VALUES ('2', '2', '212021001', '2021-03-31 03:12:59', '细胞色素c皮试(+)', '胃食道逆流是指下食道括约肌无法阻挡胃液回流到食道，造成胃酸损伤食道壁而产生火烧心');
INSERT INTO `d_p` VALUES ('3', '3', '212021001', '2021-03-04 23:38:55', '血常规、大便常规、小便常规', '过度使用声带：大喊大叫、唱卡拉OK等过度使用声带的行为，容易造成声带发炎、烧声，引发喉咙痛');
INSERT INTO `d_p` VALUES ('4', '4', '212021001', '2021-04-04 15:34:48', '青霉素皮试', '安慕希路，1天3次，每次一片;');
INSERT INTO `d_p` VALUES ('9', '5', '212021001', '2020-12-18 12:12:11', '肝功能、肾功能、血糖', '二级护理');
INSERT INTO `d_p` VALUES ('10', '9', '212021001', '2021-03-31 03:14:50', '胸片(CR正侧位)', '肝功能、肾功能、血糖');
INSERT INTO `d_p` VALUES ('11', '10', '212021001', '2021-03-31 03:15:48', '内科护理常规', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('12', '6', '212021002', '2021-04-04 16:23:30', '肝功能、肾功能、血糖', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('13', '7', '212021002', '2021-04-04 16:28:01', '血常规、大便常规、小便常规', '胃食道逆流是指下食道括约肌无法阻挡胃液回流到食道，造成胃酸损伤食道壁而产生火烧心');
INSERT INTO `d_p` VALUES ('14', '8', '212021002', '2021-04-12 16:28:06', '血常规、大便常规、小便常规', '二级护理');
INSERT INTO `d_p` VALUES ('15', '11', '212021002', '2021-04-06 16:28:09', '肝功能、肾功能、血糖', '胃食道逆流是指下食道括约肌无法阻挡胃液回流到食道，造成胃酸损伤食道壁而产生火烧心');
INSERT INTO `d_p` VALUES ('16', '12', '212021002', '2021-04-02 16:28:13', '内科护理常规', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('17', '13', '212021002', '2021-04-01 16:28:18', '青霉素皮试', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('18', '14', '212021002', '2021-04-09 16:28:23', '血常规、大便常规、小便常规', '安慕希路，1天3次，每次一片;');
INSERT INTO `d_p` VALUES ('19', '15', '212021002', '2021-04-01 16:28:27', '内科护理常规', '二级护理');
INSERT INTO `d_p` VALUES ('20', '16', '212021002', '2021-04-02 16:28:31', '肝功能、肾功能、血糖', '胃食道逆流是指下食道括约肌无法阻挡胃液回流到食道，造成胃酸损伤食道壁而产生火烧心');
INSERT INTO `d_p` VALUES ('21', '17', '212021003', '2021-04-01 16:28:34', '内科护理常规', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('22', '18', '212021003', '2021-04-01 16:28:38', '血常规、大便常规、小便常规', '二级护理');
INSERT INTO `d_p` VALUES ('23', '19', '212021003', '2021-04-01 16:28:41', '内科护理常规', '安慕希路，1天3次，每次一片;');
INSERT INTO `d_p` VALUES ('24', '20', '212021003', '2021-04-02 16:28:45', '血常规、大便常规、小便常规', '二级护理');
INSERT INTO `d_p` VALUES ('25', '21', '212021003', '2021-04-02 16:28:49', '青霉素皮试', '安慕希路，1天3次，每次一片;');
INSERT INTO `d_p` VALUES ('26', '22', '212021003', '2021-04-03 16:28:52', '内科护理常规', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('27', '23', '212021003', '2021-04-03 16:28:55', '肝功能、肾功能、血糖', '胃食道逆流是指下食道括约肌无法阻挡胃液回流到食道，造成胃酸损伤食道壁而产生火烧心');
INSERT INTO `d_p` VALUES ('28', '24', '212021003', '2021-04-02 16:28:59', '内科护理常规', '安慕希路，1天3次，每次一片;');
INSERT INTO `d_p` VALUES ('29', '25', '212021003', '2021-04-04 16:29:49', '肝功能、肾功能、血糖', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('30', '26', '212021003', '2021-04-04 16:29:52', '内科护理常规', '胃食道逆流是指下食道括约肌无法阻挡胃液回流到食道，造成胃酸损伤食道壁而产生火烧心');
INSERT INTO `d_p` VALUES ('31', '27', '212021004', '2021-04-04 16:29:54', '肝功能、肾功能、血糖', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('32', '28', '212021004', '2021-04-04 16:29:56', '青霉素皮试', '安慕希路，1天3次，每次一片;');
INSERT INTO `d_p` VALUES ('33', '29', '212021004', '2021-04-04 16:29:59', '青霉素皮试', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('34', '30', '212021004', '2021-04-04 16:30:02', '内科护理常规', '安慕希路，1天3次，每次一片;');
INSERT INTO `d_p` VALUES ('35', '31', '212021004', '2021-04-04 16:30:04', '青霉素皮试', '胃食道逆流是指下食道括约肌无法阻挡胃液回流到食道，造成胃酸损伤食道壁而产生火烧心');
INSERT INTO `d_p` VALUES ('36', '32', '212021004', '2021-04-04 16:30:06', '内科护理常规', '安慕希路，1天3次，每次一片;');
INSERT INTO `d_p` VALUES ('37', '32', '212021002', '2021-04-04 17:57:22', '青霉素皮试', '氨茶碱平片 10mg t.i.d');
INSERT INTO `d_p` VALUES ('38', '33', '212021004', '2021-04-04 21:00:13', null, null);
INSERT INTO `d_p` VALUES ('39', '34', '212021004', '2021-04-04 21:00:16', null, null);
INSERT INTO `d_p` VALUES ('40', '35', '212021001', '2021-04-13 12:02:31', '肝功能、肾功能、血糖', '安乃近片，1天3次，每次一片;\r\n氨茶碱平片 10mg t.i.d');

-- ----------------------------
-- Table structure for home
-- ----------------------------
DROP TABLE IF EXISTS `home`;
CREATE TABLE `home` (
  `homeId` int(11) NOT NULL AUTO_INCREMENT,
  `homeName` varchar(30) DEFAULT NULL,
  `buildName` varchar(50) DEFAULT NULL,
  `homeTier` int(11) DEFAULT NULL,
  `homeType` varchar(50) DEFAULT NULL,
  `homeBedNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`homeId`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of home
-- ----------------------------
INSERT INTO `home` VALUES ('1', '101', 'DH0001', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('2', '102', 'DH0001', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('3', '103', 'DH0001', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('5', '105', 'DH0001', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('6', '106', 'DH0001', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('7', '107', 'DH0001', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('8', '108', 'DH0001', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('9', '109', 'DH0001', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('10', '110', 'DH0001', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('11', '101', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('12', '102', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('13', '103', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('14', '104', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('15', '105', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('16', '106', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('17', '107', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('18', '108', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('19', '201', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('20', '202', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('21', '203', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('22', '204', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('23', '205', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('24', '206', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('25', '207', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('26', '208', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('27', '209', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('28', '210', 'DH0001', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('29', '201', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('30', '202', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('31', '203', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('32', '204', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('33', '205', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('34', '206', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('35', '207', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('36', '208', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('37', '209', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('38', '210', 'DH0002', '2', '普通病房', '4');
INSERT INTO `home` VALUES ('40', '109', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('43', '110', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('44', '110', 'DH0002', '1', '普通病房', '4');
INSERT INTO `home` VALUES ('48', '301', 'DH0001', '4', '普通病房', '4');
INSERT INTO `home` VALUES ('49', '302', 'DH0001', '3', '普通病房', '4');
INSERT INTO `home` VALUES ('55', '104', 'DH0001', '1', '普通病房', '4');

-- ----------------------------
-- Table structure for nurse
-- ----------------------------
DROP TABLE IF EXISTS `nurse`;
CREATE TABLE `nurse` (
  `nurseId` int(11) NOT NULL AUTO_INCREMENT,
  `nurseName` varchar(50) NOT NULL,
  `nursePassword` varchar(255) NOT NULL,
  `nurseSex` char(1) DEFAULT NULL,
  `nurseAge` int(11) DEFAULT NULL,
  `nursePhone` varchar(50) DEFAULT NULL COMMENT '电话',
  `nursePosition` varchar(50) DEFAULT NULL COMMENT '职位（护士/护士长）',
  `nurseDep` varchar(50) DEFAULT NULL COMMENT '科室',
  PRIMARY KEY (`nurseId`)
) ENGINE=InnoDB AUTO_INCREMENT=172019017 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nurse
-- ----------------------------
INSERT INTO `nurse` VALUES ('2', '嗡嗡嗡', '2', 'm', '45', '1234545566', '护士长', '儿科');
INSERT INTO `nurse` VALUES ('3', 'popy', '123456', 'f', '22', '12345655556', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019001', '荒木废炉眼', '12345678', 'f', '19', '1235689745', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019002', '延鹤', '111111', 'f', '45', '1234545566', '护士长', '儿科');
INSERT INTO `nurse` VALUES ('172019003', '家帝', '111111', 'f', '22', '16563233566', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019004', '文天', '54t34', 'f', '23', '1854545566', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019005', '芃谷', '22343', 'f', '23', '16886845566', '护士', '外科');
INSERT INTO `nurse` VALUES ('172019006', '轩钊', '2342', 'f', '24', '126787866', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019007', '涛华', '45432', 'f', '56', '12346785566', '护士长', '儿科');
INSERT INTO `nurse` VALUES ('172019008', '起欣', '45312', 'f', '33', '12334555566', '护士', '内科');
INSERT INTO `nurse` VALUES ('172019009', '郁禄', '12332', 'f', '45', '1253445566', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019010', '加郁', '342', 'f', '22', '16563233566', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019011', '寅远', '54t34', 'f', '23', '1854545566', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019012', '喆允', '22343', 'f', '23', '16886845566', '护士', '外科');
INSERT INTO `nurse` VALUES ('172019013', '强子', '2342', 'f', '24', '126787866', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019014', '澄鹤', '45432', 'f', '56', '12346785566', '护士', '儿科');
INSERT INTO `nurse` VALUES ('172019015', '帆日', '45312', 'f', '33', '12334555566', '护士', '内科');
INSERT INTO `nurse` VALUES ('172019016', '颜翱', '12332', 'f', '45', '1253445566', '护士', '儿科');

-- ----------------------------
-- Table structure for nurseschedule
-- ----------------------------
DROP TABLE IF EXISTS `nurseschedule`;
CREATE TABLE `nurseschedule` (
  `nurseId` int(11) NOT NULL,
  `mon` varchar(255) DEFAULT NULL,
  `tue` varchar(255) DEFAULT NULL,
  `wed` varchar(255) DEFAULT NULL,
  `thu` varchar(255) DEFAULT NULL,
  `fri` varchar(255) DEFAULT NULL,
  `sat` varchar(255) DEFAULT NULL,
  `sun` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nurseId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nurseschedule
-- ----------------------------
INSERT INTO `nurseschedule` VALUES ('172019001', '白8-8', '休', '晚8-8', '休', '晚8-8', '休', '休', null);
INSERT INTO `nurseschedule` VALUES ('172019002', '休', '白8-8', '休', '晚8-8', '休', '白8-8', '白8-8', '');
INSERT INTO `nurseschedule` VALUES ('172019003', '白8-8', '晚8-8', '休', '晚8-8', '白8-8', '休', '白8-8', null);
INSERT INTO `nurseschedule` VALUES ('172019004', '晚8-8', '休', '晚8-8', '休', '休', '晚8-8', '休', null);
INSERT INTO `nurseschedule` VALUES ('172019005', '休', '白8-8', '晚8-8', '晚8-8', '休', '休', '休', null);
INSERT INTO `nurseschedule` VALUES ('172019006', '晚8-8', '休', '白8-8', '晚8-8', '休', '白8-8', '休', '');
INSERT INTO `nurseschedule` VALUES ('172019007', '白8-8', '白8-8', '休', '休', '晚8-8', '休', '白8-8', null);
INSERT INTO `nurseschedule` VALUES ('172019008', '休', '白8-8', '晚8-8', '晚8-8', '白8-8', '休', '早8-8', '无');
INSERT INTO `nurseschedule` VALUES ('172019009', '晚8-8', '休', '休', '晚8-8', '休', '晚8-8', '晚8-8', null);
INSERT INTO `nurseschedule` VALUES ('172019010', '休', '白8-8', '晚8-8', '休', '休', '白8-8', '白8-8', null);
INSERT INTO `nurseschedule` VALUES ('172019011', '晚8-8', '休', '白8-8', '晚8-8', '白8-8', '休', '晚8-8', null);
INSERT INTO `nurseschedule` VALUES ('172019012', '白8-8', '休', '休', '休', '晚8-8', '休', '休', null);
INSERT INTO `nurseschedule` VALUES ('172019013', '晚8-8', '休', '白8-8', '休', '休', '白8-8', '休', null);

-- ----------------------------
-- Table structure for n_d
-- ----------------------------
DROP TABLE IF EXISTS `n_d`;
CREATE TABLE `n_d` (
  `ndId` int(11) NOT NULL AUTO_INCREMENT,
  `patientId` int(11) DEFAULT NULL,
  `nurseId` int(11) DEFAULT NULL,
  `drugId` int(11) DEFAULT NULL,
  `ndNum` int(11) DEFAULT NULL,
  `ndTime` datetime DEFAULT NULL,
  PRIMARY KEY (`ndId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of n_d
-- ----------------------------
INSERT INTO `n_d` VALUES ('1', '1', '172019002', '202100003', '12', '2021-04-06 12:18:37');
INSERT INTO `n_d` VALUES ('2', '1', '172019002', '202100005', '1', '2021-04-06 12:19:09');
INSERT INTO `n_d` VALUES ('3', '1', '172019002', '202100001', '2', '2021-04-06 12:36:04');
INSERT INTO `n_d` VALUES ('4', '1', '172019002', '202100006', '20', '2021-04-06 12:51:09');
INSERT INTO `n_d` VALUES ('5', '1', '172019002', '202100010', '2', '2021-04-07 10:14:57');
INSERT INTO `n_d` VALUES ('6', '32', '172019002', '202100004', '12', '2021-04-13 12:17:20');
INSERT INTO `n_d` VALUES ('7', '32', '172019002', '202100006', '1', '2021-04-13 12:17:43');
INSERT INTO `n_d` VALUES ('8', '32', '172019002', '202100007', '22', '2021-04-13 12:41:51');
INSERT INTO `n_d` VALUES ('9', '35', '172019002', '202100003', '2', '2021-04-13 01:16:08');
INSERT INTO `n_d` VALUES ('10', '35', '172019002', '202100005', '1', '2021-04-13 01:18:12');
INSERT INTO `n_d` VALUES ('11', '35', '172019002', '202100010', '1', '2021-04-13 01:18:20');
INSERT INTO `n_d` VALUES ('12', '35', '172019002', '202100007', '1', '2021-04-13 01:18:26');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `patientId` int(11) NOT NULL AUTO_INCREMENT,
  `patientName` varchar(50) NOT NULL,
  `patientSex` char(8) DEFAULT NULL,
  `patientAge` int(11) DEFAULT NULL,
  `patientPhone` varchar(50) DEFAULT NULL,
  `patientHistory` text,
  `patientRank` int(11) DEFAULT NULL,
  `patientBe` char(1) DEFAULT NULL,
  `patientHadBed` int(11) DEFAULT NULL,
  `patientType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`patientId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('1', '病人001', 'm', '46', '152336452458', '头疼', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('2', '病人002', 'm', '10', '1256-5266', '安匹西林药物过敏', '1', '0', null, null);
INSERT INTO `patient` VALUES ('3', '病人003', 'm', '56', '1256332256985', '胃炎', '1', 'y', '1', null);
INSERT INTO `patient` VALUES ('4', '病人004', 'm', '22', '152336452458', '发烧', '1', 'y', '1', null);
INSERT INTO `patient` VALUES ('5', '病人005', 'f', '55', '16511212212', '胃疼', '1', 'y', '1', null);
INSERT INTO `patient` VALUES ('6', '病人006', 'f', '23', '745644542222', '小腿骨折', '1', 'y', '1', null);
INSERT INTO `patient` VALUES ('7', '病人007', 'm', '32', '148645222244', '饮酒过度，胃溃疡', '1', 'y', '1', null);
INSERT INTO `patient` VALUES ('8', '病人008', 'm', '46', '1523364524583', '视神经衰弱', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('9', '病人009', 'f', '33', '115555565656', '感冒', '1', '0', null, null);
INSERT INTO `patient` VALUES ('10', '病人010', 'm', '36', '15235666458', '感冒', '1', '0', null, null);
INSERT INTO `patient` VALUES ('11', '病人011', 'f', '33', '152336452458', '糖尿病', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('12', '病人012', 'f', '33', '152336452458', '肾功能衰竭', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('13', '病人013', 'm', '33', '152336452458', '贫血', '1', 'y', '1', null);
INSERT INTO `patient` VALUES ('14', '病人014', 'f', '33', '152336452458', '肠道炎', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('15', '病人015', 'f', '33', '152336452458', '糖尿病', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('16', '病人016', 'm', '33', '152336452458', '糖尿病', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('17', '病人017', 'f', '33', '152336452458', '糖尿病', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('18', '病人018', 'f', '33', '152336452458', '肾功能衰竭', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('19', '病人019', 'm', '33', '152336452458', '肠道炎', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('20', '病人020', 'f', '98', '152336452458', '糖尿病', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('21', '病人021', 'f', '33', '152336452458', '肠道炎', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('22', '病人022', 'f', '55', '152336452458', 'v肾功能衰竭', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('23', '病人023', 'f', '33', '152336452458', '糖尿病', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('24', '病人024', 'f', '65', '152336452458', '肾功能衰竭', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('25', '病人025', 'm', '3', '152336452458', '糖尿病', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('26', '病人026', 'm', '32', '152336452458', 'v肾功能衰竭', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('27', '病人027', 'f', '3', '152336452458', '糖尿病', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('28', '病人028', 'f', '33', '152336452458', '糖尿病', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('29', '病人029', 'f', '23', '152336452458', '糖尿病', '1', 'y', '1', null);
INSERT INTO `patient` VALUES ('30', '病人030', 'f', '3', '152336452458', '贫血', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('31', '病人031', 'f', '33', '152336452458', '贫血', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('32', '病人032', 'm', '34', '152336452458', '糖尿病', '1', 'y', '1', null);
INSERT INTO `patient` VALUES ('33', '病人033', 'f', '33', '152336452458', '糖尿病', '1', 'y', '1', null);
INSERT INTO `patient` VALUES ('34', '病人034', 'f', '33', '152336452458', '贫血', '1', 'y', null, null);
INSERT INTO `patient` VALUES ('35', '檀丽斗', 'm', '22', '152336452458', '饮酒过度，胃溃疡', '1', 'y', null, null);
DROP TRIGGER IF EXISTS `patiernt_trigger`;
DELIMITER ;;
CREATE TRIGGER `patiernt_trigger` AFTER DELETE ON `bed` FOR EACH ROW BEGIN
UPDATE patient SET patientHadBed = NULL
WHERE patientId = old.patientId;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `build_trigger`;
DELIMITER ;;
CREATE TRIGGER `build_trigger` AFTER DELETE ON `build` FOR EACH ROW BEGIN
DELETE FROM home 
WHERE buildName = old.buildName;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `home_trigger`;
DELIMITER ;;
CREATE TRIGGER `home_trigger` AFTER DELETE ON `home` FOR EACH ROW BEGIN
DELETE FROM bed 
WHERE homeId = old.homeId;
END
;;
DELIMITER ;
