select sysdate from dual;
SELECT empno,ename,sal,sal*1.2 FROM EMP;
SELECT ename,LENGTH(ename) FROM EMP ORDER BY ENAME;
SELECT ename,MONTHS_BETWEEN(SYSDATE,hiredate) FROM EMP;
SELECT ename,LPAD(sal,15,'$') FROM EMP; 
