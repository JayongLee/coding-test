-- 코드를 입력하세요
SELECT ANIMAL_ID, NAME, IF (sex_upon_intake LIKE '%Neutered%' OR sex_upon_intake LIKE '%Spayed%', "O", "X")
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;