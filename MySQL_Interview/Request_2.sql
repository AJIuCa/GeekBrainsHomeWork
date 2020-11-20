-- Для структуры из задачи 1 выведите список всех пользователей, 
-- которые поставили лайк пользователям A и B (id задайте произвольно), но при этом не поставили лайк пользователю C.

SELECT DISTINCT
	socialdb.user.user_id AS id,
    CONCAT(socialdb.user.user_first_name,
            ' ',
            socialdb.user.user_last_name) AS full_name
FROM
    socialdb.user
        INNER JOIN
    socialdb.like_post ON socialdb.user.user_id = socialdb.like_post.user_id
    WHERE like_post.user_id_like IN (2,3) and like_post.user_id_like != (1)
ORDER BY id