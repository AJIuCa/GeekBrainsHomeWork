SELECT 
    title_ru AS 'Населенные пункты'
FROM
    geodata._cities
WHERE
    region_ru LIKE 'Московская область';