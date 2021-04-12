use wbs;
SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

truncate table wbs_reservation_status;

BEGIN;
INSERT INTO `wbs_reservation_status` VALUES (1, 1, 3, '待咨询顾问受理', 2, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (2, 2, 4, '受理中(待审核)', 2, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (3, 2, 5, '受理中(待签约)', 2, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (4, 3, 6, '已签约', 2, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (5, -1, 2, '预约服务不成功', 2, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (6, 1, 0, '待咨询顾问受理', 3, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (7, 2, 1, '受理中(待签约)', 3, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (8, 3, 2, '已签约', 3, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (9, -1, 3, '预约服务不成功', 3, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (10, 1, 0, '待咨询顾问受理', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (11, 2, 1, '受理中(待审核)', 1, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (12, 2, 2, '受理中(待签约)', 1, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (13, 3, 3, '已签约', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (14, 3, 4, '回款中', 1, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (15, 3, 5, '已结束', 1, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (16, -1, -1, '预约服务不成功', 1, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (17, 2, 0, '已提交', 2, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (18, 2, 1, '已通过', 2, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (19, -1, 4, '投保不成功', 3, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (20, 1, 0, '待咨询顾问受理', 4, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (21, 2, 1, '受理中(待审核)', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (22, 2, 2, '待签约', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (23, 3, 3, '已签约', 4, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (24, 3, 5, '已结束', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (25, -1, -1, '预约服务不成功', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (26, 2, 6, '待运营初审', 4, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (27, -1, 7, '预约服务不成功', 4, 1, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (28, 2, 8, '待额度确认', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (29, -1, 9, '预约服务不成功', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (30, 2, 10, '待下单', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (31, -1, 11, '签约服务不成功', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (32, 2, 12, '待订单初审', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (33, -1, 13, '签约服务不成功', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (34, 2, 14, '待到账确认', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (35, 2, 15, '冷静期', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (36, -1, 18, '签约服务不成功', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (37, 3, 19, '已赎回', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (38, -1, 20, '已退款', 4, 0, NULL, NULL, NULL, NULL);
INSERT INTO `wbs_reservation_status` VALUES (39, -1, 21, '预约服务不成功', 4, 0, NULL, NULL, NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
