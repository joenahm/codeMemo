 
SELECT ename,sal FROM EMP WHERE sal>1200 ORDER BY hiredate;
--第二题看不懂 不做了
SELECT ename,hiredate,TO_CHAR(hiredate,'yyyy"年"MM"月"dd"日"') FROM EMP;
SELECT ename,job,DECODE(job,'PRESIDENT','A','MANAGER','B','ANALYST','C','SALESMAN','D','CLERK','E') GRADE FROM EMP;

SELECT ename,job,
		CASE job WHEN 'PRESIDENT' THEN 'A'
				WHEN 'MANAGER' THEN 'B'
				WHEN 'ANALYST' THEN 'C'
				WHEN 'SALESMAN' THEN 'D'
				WHEN 'CLERK' THEN 'E'
		END GRADE
FROM EMP;
