
-- 周南的oracle作业2

-- 10 这题上次作业已经做了啊...
SELECT e1.* FROM EMP e1,EMP e2 WHERE e2.ename='SCOTT' AND e1.job=e2.job; 

-- 11
SELECT ename,sal FROM EMP WHERE SAL IN (SELECT SAL FROM EMP WHERE DEPTNO=30);

-- 12
SELECT ename,sal FROM emp WHERE sal > (SELECT MAX(sal) FROM EMP WHERE deptno=30);

-- 13
SELECT deptno 部门编号,COUNT(*) 员工数量,AVG(sal) 平均工资,AVG(TRUNC(SYSDATE)-hiredate)/365 平均服务期限 FROM EMP GROUP BY deptno;

-- 14
SELECT e.ename,d.dname,e.sal FROM EMP e,DEPT d WHERE e.deptno=d.deptno ORDER BY d.dname;

-- 15
SELECT e1.ename,e2.ename FROM EMP e1,EMP e2 WHERE e1.deptno!=e2.deptno AND e1.job=e2.job;

-- 16
SELECT d.*,ce.NOP FROM DEPT d,(SELECT deptno,COUNT(*) NOP FROM EMP GROUP BY deptno) ce WHERE d.deptno=ce.deptno;

-- 17
SELECT job,MIN(sal) FROM EMP GROUP BY JOB;

-- 18
SELECT deptno,MIN(sal) FROM EMP WHERE JOB='MANAGER' GROUP BY deptno;

-- 19
SELECT sal*12 FROM EMP ORDER BY sal; 
