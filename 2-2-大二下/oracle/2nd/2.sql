UPDATE STAFF SET ebirthplace='中国'||ebirthplace;
UPDATE STAFF SET salary=salary+200 WHERE eno IN (SELECT eno FROM SP WHERE pno=1002);
DELETE FROM SP WHERE pno=1001 AND eno!=3;
INSERT INTO STAFF VALUES(5,'张三','男',TO_DATE('1987-03-10','yyyy-MM-dd'),'济南',3500);
SELECT * FROM STAFF WHERE ename LIKE '王%';
SELECT * FROM STAFF WHERE eno IN (SELECT eno FROM SP WHERE pno=(SELECT pno FROM PROJECT WHERE pbudget=(SELECT MAX(pbudget) FROM PROJECT)));
SELECT pno,COUNT(*) 人数 FROM SP GROUP BY pno ORDER BY pno;
SELECT STAFF.*,PROJECT.* FROM STAFF,SP,PROJECT WHERE STAFF.ename='李有才' AND STAFF.eno=SP.eno AND SP.pno=PROJECT.pno;
SELECT AVG(salary),MAX(salary),MIN(salary) FROM STAFF;
SELECT eno||','||ename||','||esex||','||ebirthday||','||ebirthplace||','||salary OUT_PUT FROM STAFF; 
