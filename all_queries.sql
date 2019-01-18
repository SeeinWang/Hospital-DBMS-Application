//query 1 Add New Patient: input:pid optionals:one or all of pname, address, phone, amount
INSERT INTO Patient(pid, pname, address, phone) 
VALUES (‘input’, optional1, optional2, optional3);

INSERT INTO PatientRecord(pid, cost, disease, notes)
VALUES (pid, 0.00, null, null);

INSERT INTO PatientRecordDate(pid, rdate)
VALUES (pid, TO_DATE('2016/06/17 13:00'));

INSERT INTO Keeps(pid, id)
VALUES (pid, 1);

INSERT INTO InsuranceAccount(id, amount)
VALUES (pid, amount);

INSERT INTO PatientInsurance(id, pid)
VALUES (pid, pid);

//query 2 Return Medicine Recommended based on test: input1:pid, input2: testName
SELECT mname
FROM Recommends
WHERE pid=input1 and tname=input2;

//query 3 Return Patient Test: input:pid
SELECT  takes.tname, test.tdate, takes.result
FROM Takes takes, Test test
WHERE takes.tname=test.tname AND takes.pid = input;

//query 4 Delete Patient: input:pid
DELETE FROM Patient WHERE pid = input;

//query 5 Add Test Results: input1:pid, input2:testName, input3:date, input4:result
INSERT INTO Takes (pid, tname, result) 
VALUES (input1, input2, input4)	;

INSERT INTO Test (tname, tdate)
VALUES (input2, input3);

//query 6 Update Patient Contact: input1:pid, input2: one of ContactName, address, phone
UPDATE Patient
SET pname=input2
WHERE pid=input1;

//query 7 inputs : input1 = id, input2 = roomno
insert into assigned
values(input1,input2);

//query 8 inputs : input1 = pid, input2 = cost
update PatientRecord
set cost = input2
where pid = input1;

inputs : input1 = pid, input2 = disease
update PatientRecord
set disease = input2
where pid = input1;

inputs : input1 = pid, input2 = notes
update PatientRecord
set notes = input2
where pid = input1;

//query 9 inputs : input1 = id, input2 = pid,input3 = tname,input4 = mname
insert into recommends
values (input1, input2, input3, input4);

//query 10 inputs: input1 = pid
update PatientRecord
set cost = cost + (select sum(M.price)
            from Medicine M, recommends R
            where R.pid = input1 and
                  R.mname = M.mname)
where pid = input1;

//query 11 inputs: input1 = pid
update patientrecord
set cost = cost - (cost * (select ia.amount from insuranceaccount ia, patientinsurance pi where pi.pid=input1 and ia.id=pi.id))
where pid=input1

//Query 12: Find the name of patients who were recommended every medicine. inputs: none
select P.pname
from patient P
where not exists ((select mname
				   from Medicine)
				   minus
				   (select mname
				   from recommends R
				   where R.pid = P.pid))

//Query 13:Find the most expensive medicine. inputs: none
select mname
from Medicine
where price = (select max(price)
               from Medicine);

//Query 14:Find the least expensive medicine. inputs: none
select mname
from Medicine
where price = (select min(price)
               from Medicine);
               
//Query 15:Find the average number of tests taken by patients. inputs: none
select avg(T.num)
from (select pid, count(*) as num
      from Takes
      group by pid) T;
