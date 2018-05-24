create or replace procedure setrank as
cursor sccur is
select score from sc for update;
temp sccur%rowtype;
sctemp number;
grade varchar(1);
begin
	for temp in sccur loop
		sctemp:=temp.score;
		if sctemp>=90 then
			grade:='A';
		end if;
		if sctemp>=80 and sctemp<90 then
			grade:='B';
		end if;
		if sctemp>=70 and sctemp<80 then
			grade:='C';
		end if;
		if sctemp>=60 and sctemp<70 then
			grade:='D';
		end if;
		if sctemp<60 then
			grade:='F';
		end if;
		update sc set newgrade=grade where current of sccur;
	end loop;
end setrank;