-- 1
CREATE VIEW af80 AS SELECT * FROM STAFF WHERE EXTRACT(YEAR FROM ebirthday) >= 1980;
SELECT * FROM af80;

-- 2
CREATE OR REPLACE PROCEDURE info_scan(sno IN STAFF.eno%TYPE, num OUT number)
AS
BEGIN
		SELECT COUNT(STAFF.eno) INTO num FROM SP,STAFF WHERE STAFF.eno=sno AND SP.eno=STAFF.eno;
END;

DECLARE
		num NUMBER;
BEGIN
		info_scan(1,num);
		dbms_output.put_line(num);
END;

-- 3 不会做
SELECT * FROM PROJECT;


-- 4
DECLARE
		CURSOR csinfo IS
			SELECT eno,ename,salary FROM STAFF;
BEGIN
		UPDATE STAFF SET salary=salary*1.15 WHERE salary<5000;
		UPDATE STAFF SET salary=salary*1.1 WHERE salary>5000 AND salary<8000;
		UPDATE STAFF SET salary=salary*1.05 WHERE salary>8000;
		
		FOR sinfo IN csinfo LOOP
				EXIT WHEN csinfo%NOTFOUND;

				dbms_output.put_line(sinfo.eno||sinfo.ename||sinfo.salary);
		END LOOP;
END;

-- 5
DECLARE
		CURSOR cur IS
			SELECT pno,pname,pbudget FROM PROJECT;
BEGIN
		FOR pinfo IN cur LOOP
				EXIT WHEN cur%NOTFOUND;

				dbms_output.put_line(pinfo.pno||pinfo.pname||pinfo.pbudget);
		END LOOP;
END;

-- 6
DECLARE
		CURSOR cur(sno STAFF.eno%TYPE) IS
			SELECT eno,ename,TO_CHAR(SYSDATE,'yyyy')-EXTRACT(YEAR FROM ebirthday) eage FROM STAFF WHERE eno=sno;
BEGIN
		FOR sinfo IN cur(2) LOOP
				EXIT WHEN cur%NOTFOUND;

				dbms_output.put_line(sinfo.eno||sinfo.ename||sinfo.eage);
		END LOOP;
END; 
