-- при добавление нового пользователя, создается строка с его ID в таблице коллекции лайков

CREATE DEFINER=`root`@`localhost` TRIGGER `user_AFTER_INSERT_add_in_like_collect` AFTER INSERT ON `user` FOR EACH ROW BEGIN
insert into like_collect (user_id, like_in, like_out, like_together) values (new.user_id,0,0,0);
END