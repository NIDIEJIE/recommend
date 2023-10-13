/*
 Navicat MySQL Data Transfer

 Source Server         : forgetpassword
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : recommend

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 13/10/2023 19:20:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for history
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `strategy_id` int NULL DEFAULT NULL COMMENT '策略id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `linename` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '线路名',
  `date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `strategy_id`(`strategy_id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `history_ibfk_1` FOREIGN KEY (`strategy_id`) REFERENCES `strategy` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `history_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 117 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES (71, 27, 5, 'A', '2023-04-21 19:56:40');
INSERT INTO `history` VALUES (72, 28, 5, 'B', '2023-04-21 19:56:54');
INSERT INTO `history` VALUES (75, 31, 5, 'A', '2023-04-21 19:57:33');
INSERT INTO `history` VALUES (77, 33, 1, 'A', '2023-04-21 20:11:17');
INSERT INTO `history` VALUES (78, 34, 5, 'C', '2023-04-22 16:44:28');
INSERT INTO `history` VALUES (80, 36, 5, 'D', '2023-04-25 17:54:16');
INSERT INTO `history` VALUES (81, 37, 5, 'E', '2023-04-25 17:54:32');
INSERT INTO `history` VALUES (82, 38, 5, 'T', '2023-04-25 17:54:49');
INSERT INTO `history` VALUES (88, 44, 5, 'A', '2023-04-25 18:07:25');
INSERT INTO `history` VALUES (93, 49, NULL, 'A', '2023-05-16 14:38:08');
INSERT INTO `history` VALUES (94, 50, 5, 'A', '2023-05-23 15:17:54');
INSERT INTO `history` VALUES (95, 51, 5, 'A', '2023-05-23 15:18:35');
INSERT INTO `history` VALUES (96, 52, 5, 'A', '2023-05-23 15:21:58');
INSERT INTO `history` VALUES (98, 54, 5, 'A', '2023-07-25 17:09:05');
INSERT INTO `history` VALUES (99, 55, 5, 'A', '2023-09-18 21:52:36');
INSERT INTO `history` VALUES (100, 56, 5, 'A', '2023-09-18 21:53:17');
INSERT INTO `history` VALUES (101, 57, 5, 'A', '2023-09-18 21:53:57');
INSERT INTO `history` VALUES (102, 58, 5, 'A', '2023-09-18 21:54:09');
INSERT INTO `history` VALUES (103, 59, 5, 'A', '2023-09-18 21:58:12');
INSERT INTO `history` VALUES (104, 60, 5, 'A', '2023-09-18 21:58:26');
INSERT INTO `history` VALUES (105, 61, 5, 'A', '2023-09-18 21:59:02');
INSERT INTO `history` VALUES (106, 62, 5, 'A', '2023-09-18 22:06:45');
INSERT INTO `history` VALUES (107, 63, 5, 'B', '2023-09-18 22:09:10');
INSERT INTO `history` VALUES (108, 64, 5, 'A', '2023-09-18 22:21:29');
INSERT INTO `history` VALUES (109, 65, 5, 'A', '2023-09-18 22:21:40');
INSERT INTO `history` VALUES (110, 66, 5, 'B', '2023-09-18 22:22:08');
INSERT INTO `history` VALUES (111, 67, 5, 'B', '2023-09-18 22:22:43');
INSERT INTO `history` VALUES (112, 68, 5, 'B', '2023-09-18 22:22:51');
INSERT INTO `history` VALUES (113, 69, 5, 'B', '2023-09-18 22:22:56');
INSERT INTO `history` VALUES (114, 70, 5, 'B', '2023-09-18 22:23:01');
INSERT INTO `history` VALUES (115, 71, 5, 'C', '2023-09-19 14:21:00');
INSERT INTO `history` VALUES (116, 72, 5, 'B', '2023-09-19 14:22:45');
INSERT INTO `history` VALUES (117, 73, 6, 'B', '2023-09-19 14:24:48');

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `strategy` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '线路检修策略',
  `status_value` double(20, 15) NULL DEFAULT NULL COMMENT '线路状态评估值',
  `date` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `strategy_ibfk_1`(`user_id`) USING BTREE,
  CONSTRAINT `strategy_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of strategy
-- ----------------------------
INSERT INTO `strategy` VALUES (27, 5, 'A线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）\n', 0.966064780000000, '2023-04-21 19:56:40');
INSERT INTO `strategy` VALUES (28, 5, 'B线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）\nT2杆塔:进行铁塔防腐处理（Ⅲ类检修）\n', 0.969242680000000, '2023-04-21 19:56:54');
INSERT INTO `strategy` VALUES (31, 5, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）\n', 0.941663260000000, '2023-04-21 19:57:33');
INSERT INTO `strategy` VALUES (33, 1, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:进行铁塔防腐处理（Ⅲ类检修）、补装塔材（Ⅲ类检修）、扶正及加固杆塔（Ⅰ类检修）\n', 0.929754775000000, '2023-04-21 20:11:17');
INSERT INTO `strategy` VALUES (34, 5, 'C线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、更换杆塔拉线（Ⅲ类检修）\nT2杆塔:更换零值绝缘子（Ⅱ类检修）\nT7杆塔:修复或更换接地引下线（Ⅲ类检修）\n', 0.924351130000000, '2023-04-22 16:44:28');
INSERT INTO `strategy` VALUES (36, 5, 'D线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）\n', 0.955452970000000, '2023-04-25 17:54:16');
INSERT INTO `strategy` VALUES (37, 5, 'E线路为严重状态，根据状态检修策略，对严重状态的线路需停电处理的严重或危急缺陷，应立即向调度部门申请\"非计划停电\"并在28.5小时内根据具体缺陷开展Ⅰ类-Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）、更换杆塔拉线（Ⅲ类检修）\nT2杆塔:进行铁塔防腐处理（Ⅲ类检修）\n', 0.883299790000000, '2023-04-25 17:54:32');
INSERT INTO `strategy` VALUES (38, 5, 'T线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）\n', 0.970831630000000, '2023-04-25 17:54:49');
INSERT INTO `strategy` VALUES (44, 5, 'A线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、更换杆塔拉线（Ⅲ类检修）\nT2杆塔:进行反向拉线加固（Ⅲ类检修）\nT3杆塔:更换绝缘子（Ⅲ类检修）\n', 0.957567610000000, '2023-04-25 18:07:25');
INSERT INTO `strategy` VALUES (49, NULL, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）\n', 0.918850690000000, '2023-05-16 14:38:08');
INSERT INTO `strategy` VALUES (50, 5, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）、更换绝缘子（Ⅲ类检修）、带电更换金具（Ⅲ类检修）\n', 0.936880216300000, '2023-05-23 15:17:54');
INSERT INTO `strategy` VALUES (51, 5, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:更换绝缘子（Ⅲ类检修）、带电更换金具（Ⅲ类检修）\nT2杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）、更换零值绝缘子（Ⅱ类检修）、更换绝缘子（Ⅲ类检修）\n', 0.929431855000000, '2023-05-23 15:18:35');
INSERT INTO `strategy` VALUES (52, 5, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:钢筋混凝土表面修复（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）、更换绝缘子（Ⅲ类检修）\nT3杆塔:进行铁塔防腐处理（Ⅲ类检修）、补装塔材（Ⅲ类检修）\n', 0.945980992000000, '2023-05-23 15:21:58');
INSERT INTO `strategy` VALUES (54, 5, 'A线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:钢筋混凝土表面修复（Ⅲ类检修）、恢复铁塔基础周围原貌（Ⅲ类检修）、对导线进行带电缠绕修补（Ⅲ类检修）、带电清除异物（Ⅲ类检修）、带电更换绝缘子（Ⅲ类检修）、对OPGW光缆进行带电缠绕修补（Ⅲ类检修）、带电更换金具（Ⅲ类检修）\n', 0.964997515000000, '2023-07-25 17:09:05');
INSERT INTO `strategy` VALUES (55, 5, 'A线路为正常状态，根据状态检修策略，对正常状态的线路可以根据实际运行情况、针对具体的一般缺陷开展Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT3杆塔:对拉线进行缠绕、绑扎修补（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）\n', 0.995494375000000, '2023-09-18 21:52:36');
INSERT INTO `strategy` VALUES (56, 5, 'A线路为正常状态，根据状态检修策略，对正常状态的线路可以根据实际运行情况、针对具体的一般缺陷开展Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT3杆塔:对拉线进行缠绕、绑扎修补（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）、带电更换金具（Ⅲ类检修）\n', 0.990966943000000, '2023-09-18 21:53:17');
INSERT INTO `strategy` VALUES (57, 5, 'A线路为正常状态，根据状态检修策略，对正常状态的线路可以根据实际运行情况、针对具体的一般缺陷开展Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT3杆塔:对拉线进行缠绕、绑扎修补（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）、带电更换金具（Ⅲ类检修）\n', 0.990966943000000, '2023-09-18 21:53:57');
INSERT INTO `strategy` VALUES (58, 5, 'A线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT3杆塔:对拉线进行缠绕、绑扎修补（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）、带电更换金具（Ⅲ类检修）\n', 0.989276068000000, '2023-09-18 21:54:09');
INSERT INTO `strategy` VALUES (59, 5, 'A线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT3杆塔:更换杆塔拉线（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）、带电更换金具（Ⅲ类检修）\n', 0.955798930000000, '2023-09-18 21:58:12');
INSERT INTO `strategy` VALUES (60, 5, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT3杆塔:更换杆塔拉线（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）、更换绝缘子（Ⅲ类检修）、带电更换金具（Ⅲ类检修）\n', 0.934907410000000, '2023-09-18 21:58:26');
INSERT INTO `strategy` VALUES (61, 5, 'A线路为严重状态，根据状态检修策略，对严重状态的线路需停电处理的严重或危急缺陷，应立即向调度部门申请\"非计划停电\"并在28.5小时内根据具体缺陷开展Ⅰ类-Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT3杆塔:钢筋混凝土表面修复（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）、更换杆塔拉线（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）、更换绝缘子（Ⅲ类检修）、带电更换金具（Ⅲ类检修）\n', 0.835026310000000, '2023-09-18 21:59:02');
INSERT INTO `strategy` VALUES (62, 5, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:钢筋混凝土表面修复（Ⅲ类检修）、恢复铁塔基础周围原貌（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）、更换杆塔拉线（Ⅲ类检修）\nT3杆塔:钢筋混凝土表面修复（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）\nT7杆塔:带电更换绝缘子（Ⅲ类检修）、对OPGW光缆进行带电缠绕修补（Ⅲ类检修）\n', 0.945381700000000, '2023-09-18 22:06:45');
INSERT INTO `strategy` VALUES (63, 5, 'B线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:更换杆塔拉线（Ⅲ类检修）\nT3杆塔:修复基础护坡（Ⅲ类检修）\nT7杆塔:带电更换绝缘子（Ⅲ类检修）、对OPGW光缆进行带电缠绕修补（Ⅲ类检修）\nT9杆塔:进行反向拉线加固（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）\n', 0.987799240000000, '2023-09-18 22:09:10');
INSERT INTO `strategy` VALUES (64, 5, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:对拉线进行缠绕、绑扎修补（Ⅲ类检修）、进行反向拉线加固（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）、补装塔材（Ⅲ类检修）、更换塔材（Ⅲ类检修）、扶正及加固杆塔（Ⅰ类检修）\n', 0.938089675000000, '2023-09-18 22:21:29');
INSERT INTO `strategy` VALUES (65, 5, 'A线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:对拉线进行缠绕、绑扎修补（Ⅲ类检修）、进行反向拉线加固（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）、补装塔材（Ⅲ类检修）、更换塔材（Ⅲ类检修）、扶正及加固杆塔（Ⅰ类检修）\n', 0.938089675000000, '2023-09-18 22:21:40');
INSERT INTO `strategy` VALUES (66, 5, 'B线路为正常状态，根据状态检修策略，对正常状态的线路可以根据实际运行情况、针对具体的一般缺陷开展Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:钢筋混凝土表面修复（Ⅲ类检修）\n', 0.996112270000000, '2023-09-18 22:22:08');
INSERT INTO `strategy` VALUES (67, 5, 'B线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:钢筋混凝土表面修复（Ⅲ类检修）\n', 0.965010430000000, '2023-09-18 22:22:43');
INSERT INTO `strategy` VALUES (68, 5, 'B线路为注意状态，根据状态检修策略，对注意状态的线路优先安排Ⅲ类检修，若不能满足需要，则1年内开展Ⅱ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:钢筋混凝土表面修复（Ⅲ类检修）\n', 0.961122700000000, '2023-09-18 22:22:51');
INSERT INTO `strategy` VALUES (69, 5, 'B线路为严重状态，根据状态检修策略，对严重状态的线路需停电处理的严重或危急缺陷，应立即向调度部门申请\"非计划停电\"并在28.5小时内根据具体缺陷开展Ⅰ类-Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:钢筋混凝土表面修复（Ⅲ类检修）、修复基础护坡（Ⅲ类检修）\n', 0.839115100000000, '2023-09-18 22:22:56');
INSERT INTO `strategy` VALUES (70, 5, 'B线路为严重状态，根据状态检修策略，对严重状态的线路需停电处理的严重或危急缺陷，应立即向调度部门申请\"非计划停电\"并在28.5小时内根据具体缺陷开展Ⅰ类-Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:修复基础护坡（Ⅲ类检修）\n', 0.877992400000000, '2023-09-18 22:23:01');
INSERT INTO `strategy` VALUES (71, 5, 'C线路为严重状态，根据状态检修策略，对严重状态的线路需停电处理的严重或危急缺陷，应立即向调度部门申请\"非计划停电\"并在28.5小时内根据具体缺陷开展Ⅰ类-Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、更换杆塔拉线（Ⅲ类检修）、进行反向拉线加固（Ⅲ类检修）、进行杆塔螺栓紧固（Ⅲ类检修）、修复或更换接地引下线（Ⅲ类检修）\nT4杆塔:恢复铁塔基础周围原貌（Ⅲ类检修）、更换杆塔拉线（Ⅲ类检修）、更换绝缘子（Ⅲ类检修）\n', 0.882860932000000, '2023-09-19 14:21:00');
INSERT INTO `strategy` VALUES (72, 5, 'B线路为异常状态，根据状态检修策略，对异常状态的线路根据评价结果具体扣分项确定检修项目，并在7天内完成检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT1杆塔:修复基础护坡（Ⅲ类检修）、更换杆塔拉线（Ⅲ类检修）、更换零值绝缘子（Ⅱ类检修）、更换绝缘子（Ⅲ类检修）\nT7杆塔:对导线进行带电缠绕修补（Ⅲ类检修）、带电更换绝缘子（Ⅲ类检修）\n', 0.930931084000000, '2023-09-19 14:22:45');
INSERT INTO `strategy` VALUES (73, 6, 'B线路为正常状态，根据状态检修策略，对正常状态的线路可以根据实际运行情况、针对具体的一般缺陷开展Ⅲ类检修，结合各杆塔单元关键参量的缺陷，具体检修方案如下:\nT2杆塔:对拉线进行缠绕、绑扎修补（Ⅲ类检修）、进行铁塔防腐处理（Ⅲ类检修）、补装塔材（Ⅲ类检修）、更换绝缘子（Ⅲ类检修）、进行绝缘子清扫（Ⅲ类检修）\n', 0.990326413000000, '2023-09-19 14:24:48');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(66) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(66) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `avatarurl` varchar(177) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户图像url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'NWU', '777777', 'http://localhost/file/5a1c57495b464925ab68a3e99d3b2e87.jfif');
INSERT INTO `user` VALUES (2, 'linmengjie', '123456', '');
INSERT INTO `user` VALUES (4, 'huzhe', '123456', '');
INSERT INTO `user` VALUES (5, 'ccw', '1234567', 'http://localhost/file/021f7381b29a42ee9ffdae108e799ea6.jfif');
INSERT INTO `user` VALUES (6, 'KYX', '1234567', 'http://localhost/file/a8fe6cc518a449ccb38460e9759acde9.jpg');

SET FOREIGN_KEY_CHECKS = 1;
