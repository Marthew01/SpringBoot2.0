delete FROM `hibernate_sequence`;
INSERT INTO `hibernate_sequence` VALUES (4);
delete FROM `permission_t`;
INSERT INTO `permission_t` VALUES (1, 'Retrieve');
INSERT INTO `permission_t` VALUES (2, 'Create');
INSERT INTO `permission_t` VALUES (3, 'Update');
INSERT INTO `permission_t` VALUES (4, 'Delete');
delete FROM `role_t`;
INSERT INTO `role_t` VALUES (1, 'guest');
INSERT INTO `role_t` VALUES (2, 'user');
INSERT INTO `role_t` VALUES (3, 'admin');
delete from `user_t`;
INSERT INTO `user_t` VALUES (1, '北京', '程序猿', 999, 'c4bcff1909b6aac57fbf88aca1088ffa', 'bb14c90e937f08e6c200901704409997', '男', 'admin', 10000);
INSERT INTO `user_t` VALUES (2, '山西', '老师', 555, '2a646ecf27bd37d4abc03029fe3455c4', 'f0b935ae29d1f0767b37d0852c15d469', '男', 'zhang', 5220000);
INSERT INTO `user_t` VALUES (3, '广东', '打工仔', 1, '8e0d21343239c5d399a08e876f9097c3', '61857c9da1c4be4a6af0d4b8ad93c461', '女', 'li', -100);
delete FROM `role_permission_t`;
INSERT INTO `role_permission_t` VALUES (1, 1);
INSERT INTO `role_permission_t` VALUES (2, 1);
INSERT INTO `role_permission_t` VALUES (3, 2);
INSERT INTO `role_permission_t` VALUES (2, 3);
INSERT INTO `role_permission_t` VALUES (3, 1);
INSERT INTO `role_permission_t` VALUES (3, 3);
INSERT INTO `role_permission_t` VALUES (3, 4);
INSERT INTO `role_permission_t` VALUES (2, 4);
DELETE FROM user_role_t;
INSERT INTO `user_role_t` VALUES (1, 3);
INSERT INTO `user_role_t` VALUES (2, 2);
INSERT INTO `user_role_t` VALUES (3, 1);