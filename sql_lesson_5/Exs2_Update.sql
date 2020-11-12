BEGIN;
UPDATE citydatabase.`city-hero` 
SET 
    title = 'Москва'
WHERE
    id = 1;
    COMMIT;