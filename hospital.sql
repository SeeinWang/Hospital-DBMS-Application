drop table Doctor CASCADE CONSTRAINTS;
drop table Nurse CASCADE CONSTRAINTS;
drop table Receptionist CASCADE CONSTRAINTS;
drop table Patient CASCADE CONSTRAINTS;
drop table PatientRecordDate CASCADE CONSTRAINTS;
drop table PatientRecord CASCADE CONSTRAINTS;
drop table keeps CASCADE CONSTRAINTS;
drop table PatientInsurance CASCADE CONSTRAINTS;
drop table InsuranceAccount CASCADE CONSTRAINTS;
drop table Takes CASCADE CONSTRAINTS;
drop table Test CASCADE CONSTRAINTS;
drop table Medicine CASCADE CONSTRAINTS;
drop table Pharmacy CASCADE CONSTRAINTS;
drop table MadeIn CASCADE CONSTRAINTS;
drop table Room CASCADE CONSTRAINTS;
drop table Assigned CASCADE CONSTRAINTS;
drop table IsAssignedTo CASCADE CONSTRAINTS;
drop table Recommends CASCADE CONSTRAINTS;
drop table Administers CASCADE CONSTRAINTS;

Create table Doctor
(id integer,
 specialty char(20), 
 address char(50), 
 name char(20),
   PRIMARY KEY (id));

create table Nurse
(id integer, 
address char(50), 
nname char(20), 
PRIMARY KEY (id));

create table Receptionist
(id integer, 
address char(50), 
name char(20), 
PRIMARY KEY (id));

create table Patient
(pid integer, 
pname char(20), 
address char(50), 
phone char(20),
PRIMARY KEY (pid));

create table PatientRecordDate
(pid integer,
rdate DATE,
primary key(pid));

create table PatientRecord
(pid integer,
cost NUMBER(*,2),
disease char(50),
notes char(100),
primary key(pid),
foreign key (pid) references Patient(pid) on delete CASCADE);

create table Keeps
(pid integer,  
id integer, 
PRIMARY KEY(pid,id),
 foreign key (pid) references PatientRecord(pid) on delete CASCADE,
 foreign key(id) references Receptionist(id) on delete CASCADE);    

create table PatientInsurance
(id integer,
pid integer,
primary key(id,pid),
foreign key(pid) references Patient(pid) on delete CASCADE);

create table InsuranceAccount
(id integer,
amount NUMBER(*,2),
primary key(id));

Create table Test
(tname char(20), 
tdate DATE, 
PRIMARY KEY(tname));

Create table Takes
(pid integer, 
tname char(20),
 result char(30), 
 PRIMARY KEY(pid,tname),
 Foreign key (pid) references Patient(pid) on delete CASCADE,
 Foreign key(tname) references Test(tname) on delete CASCADE);

Create table Medicine
(mname char(20), 
purpose char(30),
price NUMBER(*,2),
PRIMARY KEY(mname));

Create table Pharmacy
(name char(20), 
PRIMARY KEY(name));

Create table MadeIn
(name char(20),
mname char(20),  
PRIMARY KEY (name,mname),
foreign key (name) references Pharmacy(name),
foreign key (mname) references Medicine(mname));

create table Room
(roomno integer,
 type char(30), 
 capacity integer, 
PRIMARY KEY(roomno));

create table Assigned
(id integer, 
roomno integer, 
PRIMARY KEY(id,roomno),
foreign key (id) references Nurse(id),
foreign key(roomno) references Room(roomno));

create table IsAssignedTo
(pid integer, 
roomno integer, 
PRIMARY KEY(pid,roomno),
 foreign key (pid) references Patient(pid) on delete CASCADE,
foreign key(roomno) references Room(roomno) on delete CASCADE);

create table Recommends
(id integer, 
pid integer, 
tname char(20), 
mname char(20),
PRIMARY KEY(id,pid,tname,mname),
 foreign key (id) references Doctor(id),
 foreign key (pid,tname) references Takes(pid,tname) on delete CASCADE,
foreign key (mname) references Medicine(mname) on delete CASCADE);

create table Administers
(id integer, 
pid integer, 
tname char(20),
PRIMARY KEY(id,pid,tname),
foreign key(id) references Nurse(id),
foreign key(pid,tname) references Takes(pid,tname) on delete CASCADE);

create trigger expansionfee after insert on patient
declare 
patientcount integer;
begin
select count(*) into patientcount from patient;
IF patientcount =12 THEN
UPDATE patientrecord SET cost = cost + 10;
END IF;
end;
/

insert into Doctor values
(1, 'family medicine', '2454 Alpha St, Burnaby BC, V3J 0A4', 'Christina Chan');

insert into Doctor values
(2, 'gynecology', '167 W 2nd Ave, Vancouver BC, V5K 1X4', 'Tina Moore');

insert into Doctor values
(3, 'oncology', '6655 Lawson Ave, West Vancouver BC, V7P 0A4', 'Karen Lindstrom');

insert into Doctor values
(4, 'protology', '3516 70th Ave, Vancouver BC, V5K 1P3', 'Roger Jang');

insert into Doctor values
(5, 'ear nose and throat', '1452 W 14th Ave, Vancouver BC, V5K 0B3', 'Parminder Grover');
				   
insert into Nurse values
(1, '3514 Adera St, Vancouver BC, V6M 1A9', 'John Morrison');

insert into Nurse values
(2, '1242 Alice St, Vancouver BC, V5P 0A3', 'Kelvin Xin');

insert into Nurse values
(3, '46 Heywood St, North Vancouver BC, V7G 5T2', 'Sharon Walls');

insert into Nurse values
(4, '8256 Byrne Rd, Burnaby BC, V3N 6E3', 'Aditya Singh');

insert into Nurse values
(5, '9245 Esquimalt Ave, West Vancouver BC, V7S 8P2', 'Pablo Tan');
		 
insert into Receptionist values
(1, '15326 97th Ave, Surrey BC, V3R 7F3', 'Keith Lorenzo');

insert into Receptionist values
(2, '345 Pandora St, Vancouver BC, V5K 6N2', 'George Nadal');

insert into Receptionist values
(3, '3685 23rd Ave, Vancouver BC, V5M 6G3', 'Amy Nakamura');

insert into Receptionist values
(4, '6347 MacPherson St, Burnaby BC, V5E 2T2', 'Rachel Smith');

insert into Receptionist values
(5, '4356 Waltham Ave, Burnaby BC, V5E 8E8', 'Natalia Mendes');		 
		 
insert into Patient values
(1, 'Samuel Ko', '5432 University Dr, Burnaby BC, V5A 2G9', '604-555-9182');

insert into Patient values
(2, 'Mischa Smirnov', '3684 Larkin Dr, Vancouver BC, V6S 4R2', '604-555-3215');

insert into Patient values
(3, 'Danny Chao', '239 E 10th Ave, Vancouver BC, V5T 0P4', '604-555-1029');

insert into Patient values
(4, 'Ingela Lundberg', '4369 Grange St, Burnaby BC, V5H 1E3', '778-555-4320');

insert into Patient values
(5, 'Preeti Dhillon', '5692 Cornwall St, New Westminster BC, V3L 6H2', '778-555-0012');

insert into Patient values
(6, 'Vineeth Dhillon', '5692 Cornwall St, New Westminster BC, V3L 6H2', '778-555-0012');

insert into Patient values
(7, 'Cecelia Ko', '5432 University Dr, Burnaby BC, V5A 2G9', '604-555-9182');

insert into Patient values
(8, 'Ahra Ko', '5432 University Dr, Burnaby BC, V5A 2G9', '604-555-9182');

insert into Patient values
(9, 'Reggie Liu', null, '778-555-9898');

insert into Patient values
(10, 'Nelson Salonga', null, null);

insert into PatientRecord values
(1, 35.00, 'giardiasis', 'Patient complained of 3+ weeks abdominal pains. Completed test in office');

insert into PatientRecord values
(2, 255.00, 'colorectal cancer', 'Follow-up visit and colonoscopy');

insert into PatientRecord values
(3, 25.00, 'yeast infection', 'Swab for abnormal, prolonged infection');

insert into PatientRecord values
(4, 655.00, 'melanoma', 'Chemotherapy treatment');

insert into PatientRecord values
(5, 65.00, 'vertigo', 'Prescription and advised on theraputic exercises');

insert into PatientRecord values
(6, 0.00, null, null);

insert into PatientRecord values
(7, 0.00, null, null);

insert into PatientRecord values
(8, 0.00, null, null);

insert into PatientRecord values
(9, 0.00, null, null);

insert into PatientRecord values
(10, 0.00, null, null);

insert into PatientRecordDate values
(1, TO_DATE('2016/05/03 09:45', 'yyyy/mm/dd hh24:mi'));

insert into PatientRecordDate values
(2, TO_DATE('2016/05/19 11:30', 'yyyy/mm/dd hh24:mi'));

insert into PatientRecordDate values
(3, TO_DATE('2016/04/25 14:15', 'yyyy/mm/dd hh24:mi'));

insert into PatientRecordDate values
(4, TO_DATE('2016/05/28 15:00', 'yyyy/mm/dd hh24:mi'));

insert into PatientRecordDate values
(5, TO_DATE('2016/05/07 08:00', 'yyyy/mm/dd hh24:mi'));

insert into PatientRecordDate values
(6, TO_DATE('2016/05/08 08:00', 'yyyy/mm/dd hh24:mi'));

insert into PatientRecordDate values
(7, TO_DATE('2016/05/09 08:00', 'yyyy/mm/dd hh24:mi'));

insert into PatientRecordDate values
(8, TO_DATE('2016/05/10 08:00', 'yyyy/mm/dd hh24:mi'));

insert into PatientRecordDate values
(9, TO_DATE('2016/05/11 08:00', 'yyyy/mm/dd hh24:mi'));

insert into PatientRecordDate values
(10, TO_DATE('2016/05/12 08:00', 'yyyy/mm/dd hh24:mi'));

insert into Keeps values
(1, 3);

insert into Keeps values
(2, 5);

insert into Keeps values
(3, 2);

insert into Keeps values
(4, 1);

insert into Keeps values
(5, 4);

insert into Keeps values
(6, 1);

insert into Keeps values
(7, 1);

insert into Keeps values
(8, 1);

insert into Keeps values
(9, 1);

insert into Keeps values
(10, 1);

insert into PatientInsurance values
(1, 1);

insert into PatientInsurance values
(2, 2);

insert into PatientInsurance values
(3, 3);

insert into PatientInsurance values
(4, 4);

insert into PatientInsurance values
(5, 5);

insert into PatientInsurance values
(6, 6);

insert into PatientInsurance values
(7, 7);

insert into PatientInsurance values
(8, 8);

insert into PatientInsurance values
(9, 9);

insert into PatientInsurance values
(10, 10);

insert into InsuranceAccount values
(1, 0.50);

insert into InsuranceAccount values
(2, 0.75);

insert into InsuranceAccount values
(3, 0.50);

insert into InsuranceAccount values
(4, 0.80);

insert into InsuranceAccount values
(5, 1.00);

insert into InsuranceAccount values
(6, 0.50);

insert into InsuranceAccount values
(7, 0.50);

insert into InsuranceAccount values
(8, 1.00);

insert into InsuranceAccount values
(9, 1.00);

insert into InsuranceAccount values
(10, 0.50);

insert into Test values
('giardiasis', TO_DATE('2016/05/03 09:45', 'yyyy/mm/dd hh24:mi'));

insert into Test values
('colonoscopy', TO_DATE('2016/05/19 11:30', 'yyyy/mm/dd hh24:mi'));

insert into Test values
('pelvic examination', TO_DATE('2016/04/25 14:15', 'yyyy/mm/dd hh24:mi'));

insert into Test values
('epidermal biopsy', TO_DATE('2016/05/28 15:00', 'yyyy/mm/dd hh24:mi'));

insert into Test values
('ct scan', TO_DATE('2016/05/07 08:00', 'yyyy/mm/dd hh24:mi'));

insert into Test values
('ultrasound', TO_DATE('2016/05/07 14:00', 'yyyy/mm/dd hh24:mi'));

insert into Test values
('x-ray', TO_DATE('2016/03/12 09:45', 'yyyy/mm/dd hh24:mi'));

insert into Test values
('blood iron', TO_DATE('2015/12/17 12:15', 'yyyy/mm/dd hh24:mi'));

insert into Test values
('blood sugar', TO_DATE('2015/12/18 08:00', 'yyyy/mm/dd hh24:mi'));

insert into Takes values
(1, 'giardiasis', 'positive for giardia');

insert into Takes values
(2, 'colonoscopy', 'abnormal polyps and bleeding');

insert into Takes values
(3, 'pelvic examination', 'severe yeast infection');

insert into Takes values
(4, 'epidermal biopsy', 'metastasis detected');

insert into Takes values
(5, 'ct scan', 'normal brain activity');

insert into Takes values
(6, 'ultrasound', 'large, dense mass');

insert into Takes values
(7, 'x-ray', 'several hairline fractures');

insert into Takes values
(9, 'blood iron', 'extremely low levels');

insert into Takes values
(10, 'blood sugar', 'pre-diabetes detected');

insert into Medicine values
('metronidazole', 'giardiasis treatment', 45.99);

insert into Medicine values
('fluorouracil', 'colorectal cancer therapy', 85.99);

insert into Medicine values
('flucanozole', 'yeast infection treatment', 19.99);

insert into Medicine values
('dacarbazine', 'melanoma therapy', 39.99);

insert into Medicine values
('betahistine', 'vertigo treatment', 14.99);

insert into Medicine values
('tylenol 3', 'pain killer', 15.99);

insert into Medicine values
('methadone', 'addiction', 9.99);

insert into Medicine values
('lipitor', 'cholesterol', 45.99);

insert into Medicine values
('synthroid', 'thyroid stimulant', 41.99);

insert into Medicine values
('amoxicillin', 'antibiotic', 12.99);

insert into Pharmacy values
('UBC ShoppersDrugMart');

insert into Pharmacy values
('Alberni LondonDrugs');

insert into Pharmacy values
('W 4th Safeway');

insert into Pharmacy values
('Kingsway LondonDrugs');

insert into Pharmacy values
('Broadway Pharmasave');

insert into MadeIn values
('UBC ShoppersDrugMart', 'metronidazole');

insert into MadeIn values
('Alberni LondonDrugs', 'fluorouracil');

insert into MadeIn values
('W 4th Safeway', 'flucanozole');

insert into MadeIn values
('Kingsway LondonDrugs', 'dacarbazine');

insert into MadeIn values
('Broadway Pharmasave', 'betahistine');

insert into MadeIn values
('Broadway Pharmasave', 'tylenol 3');

insert into MadeIn values
('UBC ShoppersDrugMart', 'tylenol 3');

insert into MadeIn values
('W 4th Safeway', 'tylenol 3');

insert into MadeIn values
('Kingsway LondonDrugs', 'methadone');

insert into MadeIn values
('Broadway Pharmasave', 'methadone');

insert into MadeIn values
('Alberni LondonDrugs', 'lipitor');

insert into MadeIn values
('Alberni LondonDrugs', 'synthroid');

insert into MadeIn values
('W 4th Safeway', 'synthroid');

insert into MadeIn values
('Kingsway LondonDrugs', 'amoxicillin');

insert into MadeIn values
('Broadway Pharmasave', 'amoxicillin');

insert into MadeIn values
('Alberni LondonDrugs', 'amoxicillin');

insert into Room values
(103, 'routine examination', 1);

insert into Room values
(104, 'colonoscopy examination', 1);

insert into Room values
(105, 'routine examination', 1);

insert into Room values
(206, 'routine examination', 1);

insert into Room values
(208, 'ct scan room', 1);

insert into Room values
(301, 'inpatient care', 2);

insert into Room values
(305, 'inpatient care', 2);

insert into Room values
(307, 'inpatient care', 2);

insert into Assigned values
(5, 103);

insert into Assigned values
(1, 104);

insert into Assigned values
(2, 105);

insert into Assigned values
(3, 206);

insert into Assigned values
(4, 208);

insert into Assigned values
(2, 301);

insert into Assigned values
(5, 305);

insert into Assigned values
(4, 307);

insert into IsAssignedTo values
(1, 103);

insert into IsAssignedTo values
(2, 104);

insert into IsAssignedTo values
(3, 105);

insert into IsAssignedTo values
(4, 206);

insert into IsAssignedTo values
(5, 208);

insert into IsAssignedTo values
(6, 307);

insert into IsAssignedTo values
(7, 307);

insert into IsAssignedTo values
(9, 301);

insert into IsAssignedTo values
(10, 305);

insert into Recommends values
(1, 1, 'giardiasis', 'metronidazole');

insert into Recommends values
(1, 1, 'giardiasis', 'fluorouracil');

insert into Recommends values
(1, 1, 'giardiasis', 'flucanozole');

insert into Recommends values
(1, 1, 'giardiasis', 'dacarbazine');

insert into Recommends values
(1, 1, 'giardiasis', 'betahistine');

insert into Recommends values
(1, 1, 'giardiasis', 'tylenol 3');

insert into Recommends values
(1, 1, 'giardiasis', 'methadone');

insert into Recommends values
(1, 1, 'giardiasis', 'lipitor');

insert into Recommends values
(1, 1, 'giardiasis', 'synthroid');

insert into Recommends values
(1, 1, 'giardiasis', 'amoxicillin');

insert into Recommends values
(4, 2, 'colonoscopy', 'fluorouracil');

insert into Recommends values
(2, 3, 'pelvic examination', 'flucanozole');

insert into Recommends values
(3, 4, 'epidermal biopsy', 'dacarbazine');

insert into Recommends values
(5, 5, 'ct scan', 'betahistine');

insert into Recommends values
(2, 6, 'ultrasound', 'tylenol 3');

insert into Recommends values
(3, 7, 'x-ray', 'tylenol 3');

insert into Administers values
(5, 1, 'giardiasis');

insert into Administers values
(1, 2, 'colonoscopy');

insert into Administers values
(2, 3, 'pelvic examination');

insert into Administers values
(3, 4, 'epidermal biopsy');

insert into Administers values
(4, 5, 'ct scan');
