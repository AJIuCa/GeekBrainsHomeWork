-- При удалении лайка у пользователя счётчик отправленных лайков уменьшается на 1
-- При удалении лайка (к юзеруего, фотке, комменту к фотке) счётчик полученных лайков соотв. поля уменьшается на 1



CREATE DEFINER=`root`@`localhost` TRIGGER `like_post_AFTER_DELETE_dell_like` AFTER DELETE ON `like_post` FOR EACH ROW BEGIN

UPDATE like_collect SET like_collect.like_out = like_collect.like_out - 1 WHERE user_id = OLD.user_id;

UPDATE like_collect SET like_collect.like_in_total = like_collect.like_in_total - 1 WHERE user_id = OLD.user_id_like;
UPDATE like_collect SET like_collect.like_in_total = like_collect.like_in_total - 1 WHERE user_id = OLD.photo_id_like;
UPDATE like_collect SET like_collect.like_in_total = like_collect.like_in_total - 1 WHERE user_id = OLD.comment_id_like;

UPDATE like_collect SET like_collect.like_in_user = like_collect.like_in_user - 1 WHERE user_id = OLD.user_id_like;

UPDATE like_collect SET like_collect.like_in_photo = like_collect.like_in_photo - 1 WHERE user_id = OLD.photo_id_like;

UPDATE like_collect SET like_collect.like_in_comment = like_collect.like_in_comment - 1 WHERE user_id = OLD.comment_id_like;

END