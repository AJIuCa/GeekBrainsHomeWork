BEGIN;
SELECT * FROM citydatabase.district
WHERE 
    id >= 3 AND id < 7;
COMMIT;