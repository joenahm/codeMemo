CREATE TABLE Student(
		sno VARCHAR(10) PRIMARY KEY,
		sname VARCHAR(8),
		ssex VARCHAR(4) DEFAULT '男',
		sage int,
		sdept VARCHAR(20),
		CONSTRAINT ck_sage CHECK(sage>20 AND sage<30)
);

CREATE TABLE Course(
		cno VARCHAR(5) PRIMARY KEY,
		cname VARCHAR(20) UNIQUE,
		cpno VARCHAR(5),
		credit int
);

CREATE TABLE SC(
		sno VARCHAR(10),
		cno VARCHAR(5),
		grade int,
		PRIMARY KEY(sno,cno),
		FOREIGN KEY(sno) REFERENCES Student(sno),
		FOREIGN KEY(cno) REFERENCES Course(cno)
);

ALTER TABLE STU DROP CONSTRAINT ck_sage;

CREATE USER 'wangming'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'liyong'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'liuxing'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'zhouping'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT ON Course TO wangming@localhost;
GRANT SELECT ON Student TO wangming@localhost;
GRANT INSERT,DELETE ON Course TO liyong@localhost;
GRANT INSERT,DELETE ON Student TO liyong@localhost;
GRANT SELECT ON Student TO liuxing@localhost;
GRANT UPDATE(sage) ON Student TO liuxing@localhost;
GRANT ALL PRIVILEGES ON Student TO zhouping@localhost;
GRANT ALL PRIVILEGES ON Course TO zhouping@localhost;
GRANT ALL PRIVILEGES ON *.* TO zhouping@localhost;

REVOKE ALL PRIVILEGES ON *.* FROM liyong@localhost;
REVOKE ALL PRIVILEGES ON *.* FROM zhouping@localhost;