--  Создайте запрос, который выведет информацию: id пользователя; имя; лайков получено; лайков поставлено; взаимные лайки.

SELECT 
    socialdb.user.user_id AS id,
    CONCAT(socialdb.user.user_first_name,
            ' ',
            socialdb.user.user_last_name) AS full_name,
    socialdb.like_collect.like_in,
    socialdb.like_collect.like_out,
    socialdb.like_collect.like_together
FROM
    socialdb.user
        INNER JOIN
    socialdb.like_collect ON socialdb.user.user_id = socialdb.like_collect.user_id
ORDER BY id