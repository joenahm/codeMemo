CREATE TABLE staff(
		eno INT PRIMARY KEY,
		ename VARCHAR(10) NOT NULL,
		esex VARCHAR(4) DEFAULT '男',
		ebirthday DATE,
		ebirthplace VARCHAR(20),
		ewage INT,
		CONSTRAINT ck_esex CHECK(esex='男' OR esex='女') 
);

CREATE TABLE project(
		pno INT PRIMARY KEY,
		pname VARCHAR(100) NOT NULL,
		pstartdate DATE,
		penddate DATE,
		pbudget INT,
		CONSTRAINT ck_pno CHECK(pno>=1001),
		CONSTRAINT uk_pname UNIQUE(pname),
		CONSTRAINT ck_penddate CHECK(penddate>pstartdate)
);

INSERT INTO staff VALUES(1,'王晓明','女',TO_DATE('1980-01-03','yyyy-MM-dd'),'山东青岛',8900);
INSERT INTO staff VALUES(2,'王函','男',TO_DATE('1978-06-12','yyyy-MM-dd'),'广东佛山',7600);
INSERT INTO staff VALUES(3,'李有才','男',TO_DATE('1978-05-23','yyyy-MM-dd'),'上海',7800);
INSERT INTO staff VALUES(4,'张小小','女',TO_DATE('1982-09-07','yyyy-MM-dd'),'山东济南',4500);

INSERT INTO project VALUES(1001,'小型监控系统',TO_DATE('2009-08-06','yyyy-MM-dd'),TO_DATE('2010-01-01','yyyy-MM-dd'),12000);
INSERT INTO project VALUES(1002,'办公网络安全',TO_DATE('2009-12-30','yyyy-MM-dd'),TO_DATE('2010-10-01','yyyy-MM-dd'),450000);
INSERT INTO project VALUES(1003,'电子购物广场',TO_DATE('2009-11-30','yyyy-MM-dd'),TO_DATE('2009-12-31','yyyy-MM-dd'),12000);
INSERT INTO project VALUES(1004,'图书管理系统',TO_DATE('2008-11-30','yyyy-MM-dd'),TO_DATE('2009-12-31','yyyy-MM-dd'),20000);

CREATE TABLE sp(
		eno INT,
		pno INT,
		CONSTRAINT pk_no PRIMARY KEY(eno,pno),
		CONSTRAINT fk_eno FOREIGN KEY(eno) REFERENCES STAFF(eno),
		CONSTRAINT fk_pno FOREIGN KEY(pno) REFERENCES PROJECT(pno)
);

INSERT INTO sp VALUES(1,1001);
INSERT INTO sp VALUES(1,1002);
INSERT INTO sp VALUES(1,1003);
INSERT INTO sp VALUES(1,1004);
INSERT INTO sp VALUES(2,1002);
INSERT INTO sp VALUES(2,1003);
INSERT INTO sp VALUES(3,1001);
INSERT INTO sp VALUES(3,1002);
INSERT INTO sp VALUES(4,1001);

SELECT eno AS 员工编号,pno AS 项目编号  FROM sp;

COMMENT ON COLUMN PROJECT.PNO IS '项目编号';
COMMENT ON COLUMN PROJECT.PNAME IS '项目名称';
COMMENT ON COLUMN PROJECT.PSTARTDATE IS '起始日期';
COMMENT ON COLUMN PROJECT.PENDDATE IS '结束日期';
COMMENT ON COLUMN PROJECT.PBUDGET IS '预算';

ALTER TABLE STAFF RENAME COLUMN ewage TO salary; 
