-- необходимо иметь возможность считать число полученных сущностью лайков 
-- и выводить список пользователей, поставивших лайки;

SELECT DISTINCT
	socialdb.user.user_id AS id,
    CONCAT(socialdb.user.user_first_name,
            ' ',
            socialdb.user.user_last_name) AS full_name,
            socialdb.like_collect.like_in_photo AS 'Photos likes',
            socialdb.like_collect.like_in_comment AS 'Comments likes'
FROM
    socialdb.user
        INNER JOIN
    socialdb.like_collect ON socialdb.user.user_id = socialdb.like_collect.user_id

WHERE socialdb.like_collect.like_in_photo !=0 OR socialdb.like_collect.like_in_comment !=0

ORDER BY id