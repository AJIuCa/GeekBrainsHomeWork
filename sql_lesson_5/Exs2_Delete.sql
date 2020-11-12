BEGIN;
DELETE FORM citydatabase.`city-hero` 
WHERE
    id = 1;
ROLLBACK;