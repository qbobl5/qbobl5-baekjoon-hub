SELECT COUNT(*) AS FISH_COUNT
FROM fish_info
WHERE length <= 10 OR length IS NULL;