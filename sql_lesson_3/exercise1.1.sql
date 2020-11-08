SELECT 
    country_id as 'Код Страны', region_id as 'Код Региона'
FROM
    geodata._cities
WHERE
    title_ru like 'Москва'
