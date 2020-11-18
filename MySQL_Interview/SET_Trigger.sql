-- При комментировании у пользователя счётчик отправленных лайков увеличивается на 1
-- У пользователя которого пролайкали (его, его фотку, коммент к фотке) счётчик полученных лайков увеличивается на 1



CREATE DEFINER=`root`@`localhost` TRIGGER `like_post_AFTER_INSERT` AFTER INSERT ON `like_post` FOR EACH ROW BEGIN

UPDATE like_collect SET like_collect.like_out = like_collect.like_out + 1 WHERE user_id = NEW.user_id;

UPDATE like_collect SET like_collect.like_in_total = like_collect.like_in_total + 1 WHERE user_id = NEW.user_id_like;
UPDATE like_collect SET like_collect.like_in_total = like_collect.like_in_total + 1 WHERE user_id = NEW.photo_id_like;
UPDATE like_collect SET like_collect.like_in_total = like_collect.like_in_total + 1 WHERE user_id = NEW.comment_id_like;

UPDATE like_collect SET like_collect.like_in_user = like_collect.like_in_user + 1 WHERE user_id = NEW.user_id_like;

UPDATE like_collect SET like_collect.like_in_photo = like_collect.like_in_photo + 1 WHERE user_id = NEW.photo_id_like;

UPDATE like_collect SET like_collect.like_in_comment = like_collect.like_in_comment + 1 WHERE user_id = NEW.comment_id_like;

END