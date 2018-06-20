INSERT INTO STAFF VALUES(5,'张三','男',TO_DATE('1987-03-10','yyyy-MM-dd'),'济南',3500);
-- 还得插入张三，××的气死我了！说好的用实验一的表呢！我还特地都把表删了，重新把实验一的表建了一次...

SELECT s.* FROM STAFF s,PROJECT p,SP sp WHERE p.PNAME='小型监控系统' AND p.PNO=sp.PNO AND sp.ENO=s.ENO ORDER BY s.SALARY DESC;
SELECT DISTINCT STAFF.* FROM STAFF,SP WHERE staff.ENO=sp.ENO;
SELECT s.ename,s.salary,p.pname FROM STAFF s,SP sp,PROJECT p WHERE sp.eno=s.eno AND sp.pno=p.pno AND s.eno=4;
SELECT (MAX(salary)-MIN(salary)) FROM STAFF;
SELECT EXTRACT(YEAR FROM ebirthday) AS birth,COUNT(*) FROM STAFF GROUP BY EXTRACT(YEAR FROM ebirthday) ORDER BY birth;
SELECT * FROM STAFF WHERE salary>(SELECT salary FROM STAFF WHERE ename='张三');
SELECT * FROM STAFF WHERE EXTRACT(YEAR FROM ebirthday)>=1980 AND EXTRACT(YEAR FROM ebirthday)<=1989;
SELECT ename,salary*12 FROM STAFF ORDER BY salary;
SELECT pname,penddate-pstartdate FROM PROJECT;
SELECT * FROM PROJECT WHERE pno NOT IN (SELECT pno FROM SP); 
