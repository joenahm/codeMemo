
-- 0
CREATE TABLE emp AS SELECT * FROM SCOTT.emp;
CREATE TABLE dept AS SELECT * FROM SCOTT.dept;

-- 1
SELECT DISTINCT dept.* FROM DEPT,EMP WHERE dept.deptno IN emp.deptno;

-- 2
SELECT * FROM EMP WHERE sal > (SELECT sal FROM EMP WHERE ename='SMITH');
-- fangfa1
SELECT e1.* FROM EMP e1,emp e2 WHERE e2.ename='SMITH' AND e1.sal>e2.sal;
-- fangfa2

-- 3
SELECT e1.ename 员工姓名,e2.ename 上级姓名 FROM EMP e1,EMP e2 WHERE e1.mgr=e2.empno ORDER BY e1.ename;

-- 4
SELECT e1.* FROM EMP e1,EMP e2 WHERE e1.mgr=e2.empno AND e1.hiredate < e2.hiredate;

-- 5
SELECT d.dname,e.* FROM EMP e FULL JOIN DEPT d ON  e.deptno=d.deptno ORDER BY d.dname;

-- 6
SELECT e.ename,d.dname FROM EMP e,DEPT d WHERE e.job='CLERK' AND d.deptno=e.deptno;

-- 7
SELECT DISTINCT job FROM EMP WHERE sal > 1500;

-- 8
SELECT e.ename FROM EMP e,DEPT d WHERE d.dname='SALES' AND d.deptno=e.deptno;

-- 9
SELECT * FROM EMP WHERE sal > (SELECT AVG(sal) FROM EMP) ORDER BY sal;

-- 10
SELECT e1.* FROM EMP e1,EMP e2 WHERE e2.ename='SCOTT' AND e1.job=e2.job; 
