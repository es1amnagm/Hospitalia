use Hospitalia;

create table Manager(
manager_id   int,
manager_name  varchar(40),
salary		float,
years_of_experience TINYINT ,
address		varchar(40),
start_date DATE,
gender		varchar(20),
password    varchar(50),
constraint pk_manager primary key (manager_id) ,
constraint ck_gender  check (gender in('female','male'))
);
 
--//////////////////////////////////////////////////////////////////////////////////////////////////////////  doneK
create table Doctor(
doctor_id int,
first_name varchar(20),
last_name varchar(20),
address   varchar (20),
salary		float,
start_date DATE,
years_of_experience TINYINT ,
specialty  varchar(30),
shift     varchar(20) ,
extra_hours   float,
genderd        varchar(20),
password    varchar(50),
speciality_name      varchar(50),
nurse_id        int,
manager_id		int,
constraint ck_shift check (shift in('morning','evening')),
constraint ck_genderd  check (genderd in('female','male')),
constraint pk_doctor primary key (doctor_id),
constraint fk_speciality_doctor foreign key (speciality_name) references Speciality(speciality_name),
constraint fk_nurse_doctor foreign key (nurse_id) references Nurse (nurse_id),
constraint fk_manager_doctor foreign key (manager_id) references Manager(manager_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK
create table Nurse(
nurse_id int,
first_name varchar(20),
last_name varchar(20),
address   varchar (20),
start_date DATE,
years_of_experience TINYINT ,
specialty  varchar(30),
salary		float,
shift     varchar(20) ,
extra_hours   float,
gendern        varchar(20),
password    varchar(50),
speciality_name      varchar(50),
doctor_id		int,
supervisor_id      int,
manager_id		int,
constraint ck_shift_nurse check (shift in('morning','evening')),
constraint ck_gendern  check (gendern in('female','male')),
constraint pk_nurse primary key (nurse_id),
constraint fk_speciality_nurse foreign key (speciality_name) references Speciality(speciality_name),
constraint fk_doctor_nurse foreign key (doctor_id) references Doctor(doctor_id),
constraint fk_supervisor_nurse foreign key (supervisor_id) references Nurse(supervisor_id),
constraint fk_manager_nurse foreign key (manager_id) references Manager(manager_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK

create table Pharmacyutical(
pharmacyutical_id		int,
first_name varchar(20),
last_name varchar(20),
address   varchar (20),
start_date DATE,
years_of_experience TINYINT ,
salary		float,
shift     varchar(20) ,
extra_hours   float,
genderph        varchar(20),
password    varchar(50),
pharmacy_id   int,
manager_id	   int,
constraint ck_shift_pharmacyutical check (shift in('morning','evening')),
constraint ck_genderph  check (genderph in('female','male')),
constraint pk_pharmacyutical primary key(pharmacyutical_id),
constraint fk_pharmacy_pharmacyutical foreign key (pharmacy_id) references Pharmacy(pharmacy_id),
constraint fk_manager_Pharmacyutical foreign key (manager_id) references Manager(manager_id)

);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK
create table Store(
store_id	int,
isfull		bit,
location	varchar(50),

constraint pk_store primary key (store_id)
);
 --////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK
create table store_and_medicine(
medicine_name varchar(40),
number_number_of_medicine_box int,
store_id		int,
 constraint fk_store_store_and_medicine foreign key(store_id) references Store(store_id)
);
 --////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK

create table worker_store(
worker_store_id		int,
first_name varchar(20),
last_name varchar(20),
address   varchar (20),
start_date DATE,
salary		float,
shift     varchar(20) ,
extra_hours   float,
genderws       varchar(20),

store_id		int,
manager_id	   int,
constraint ck_shift_worker_store check (shift in('morning','evening')),
constraint ck_genderws  check (genderws in('female','male')),
constraint pk_worker_store primary key(worker_store_id),
constraint fk_store_worker_store foreign key (store_id) references Store(store_id),
constraint fk_manager_worker_store foreign key (manager_id) references Manager(manager_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK
create table Patient
(
patient_id int,
first_name varchar(20),
last_name varchar(20),
genderp varchar(20),
visit_date    date,
out_date      date,
diagnosis     text,
address			varchar(40),

doctor_id		int,
nurse_id		int,

constraint pk_patient primary key (patient_id) ,
constraint ck_genderp  check (genderp in('female','male') ),
constraint fk_doctor_patient foreign key (doctor_id) references Doctor(doctor_id),
constraint fk_nurse_patient foreign key (nurse_id) references Nurse (nurse_id),
);
 
--//////////////////////////////////////////////////////////////////////////////////////////////////////////doneK
create table Speciality
(
speciality_name  varchar(50),
constraint pk_speciality primary key (speciality_name)
);
--//////////////////////////////////////////////////////////////////////////////////////////////////////////doneK
create table Receptionist(
receptionist_id int,
first_name varchar(20),
last_name varchar(20),
address   varchar (20),
start_date DATE,
salary    float,
years_of_experience TINYINT ,
shift     varchar(20) ,
extra_hours   float,
genderr        varchar(20),
password    varchar(50),
manager_id	int,
constraint ck_genderr  check (genderr in('female','male')),
constraint ck_shift_receptionist check (shift in('morning','evening')),

constraint pk_receptionist primary key (receptionist_id),
constraint fk_manager_receptionist foreign key (manager_id) references Manager(manager_id)

);
--//////////////////////////////////////////////////////////////////////////////////////////////////////////doneK
create table Donations(
donation_id		int,
name_of_donar	varchar(30),
address_of_donar varchar(30),
amount	float,
date		date,

receptionist_id  int,
manager_id   int,

constraint  pk_donations primary key (donation_id),
constraint  fk_receptionist_donations foreign key (receptionist_id) references Receptionist (receptionist_id),
constraint fk_manager_donations foreign key (manager_id) references Manager(manager_id)

);
 --////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK

create table Paramedic(
paramedic_id int,
first_name varchar(20),
last_name varchar(20),
address   varchar (20),
salary   float,
start_date DATE,
years_of_experience TINYINT ,
shift     varchar(20) ,
extra_hours   float,
genderpar       varchar(20),
password    varchar(50),
ambulance_id      int,
driver_id         int,
receptionist_id   int,
manager_id			int,
constraint ck_shift_paramedic check (shift in('morning','evening')),
constraint ck_genderpar  check (genderpar in('female','male')),
constraint pk_paramedic primary key (paramedic_id),
constraint fk_ambulance_paramedic foreign key (ambulance_id) references Ambulance(ambulance_id),
constraint fk_driver_paramedic foreign key (driver_id) references Driver(driver_id),
constraint fk_receptionist_paramedic foreign key (receptionist_id) references Receptionist(receptionist_id),
constraint fk_manager_paramedic foreign key (manager_id) references Manager(manager_id)
);
 
--//////////////////////////////////////////////////////////////////////////////////////////////////////////doneK
 create table Driver(
driver_id int,
first_name varchar(20),
last_name varchar(20),
address   varchar (20),
years_of_experience TINYINT ,

salary		float ,
shift     varchar(20) ,
start_date DATE,
extra_hours   float,
genderdr        varchar(20),

receptionist_id		 int,
manager_id			int,
constraint ck_genderdr  check (genderdr in('female','male')),
constraint ck_shift_driver check (shift in('morning','evening')),

constraint pk_driverdr primary key (driver_id),
constraint fk_receptionist_driver foreign key (receptionist_id) references Receptionist(receptionist_id),
constraint fk_manager_driver foreign key (manager_id) references Manager(manager_id)

);
 
 --//////////////////////////////////////////////////////////////////////////////////////////////////////////doneK
create table Ambulance (
ambulance_id	int,
is_free			bit, -- make it take null if the car is break down ,
out_date			date,
in_date			date,

driver_id		int,
need_preparing  bit default 0,
constraint pk_ambulance primary key(ambulance_id),
constraint fk_driver_ambulance foreign key (driver_id) references Driver (driver_id)
);
 --////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK
create table Clinic (
clinic_id		int,
floor		int,
nurse_id	int,
doctor_id	int,
patient_id  int,
 constraint fk_nurse_clinic foreign key (nurse_id) references Nurse(nurse_id),
constraint fk_doctor_clinic foreign key (doctor_id) references Doctor(doctor_id),
constraint fk_patient_clinic foreign key (patient_id) references Patient(patient_id)
);
 
--////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK
create table Room (
room_id		int,
floor		int,
beds		int,
capacity	int,


constraint pk_room primary key (room_id),
);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK

create table Invoice(
invoice_id		int,
price		float,
state		    AS    -- we won't take this column from the user this will calculate automatic 
        CASE 
            WHEN paid = 0 THEN 'unpaid'
            WHEN paid = price THEN 'paid'
            ELSE 'still paying'
        END PERSISTED, 
paid		float default 0.0,
date		date,

patient_id	int,
receptionist_id		int,

constraint pk_invoice primary key (invoice_id),
constraint fk_patient_invoice foreign key (patient_id) references Patient(patient_id),
constraint fk_receptionist_invoice foreign key (receptionist_id) references Receptionist (receptionist_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// doneK
create table Operation(
operation_id	int,
type	varchar(40),
done   bit,
date   date,
room_id		int,
patient_id    int,
constraint pk_operation  primary key(operation_id),
constraint fk_patient_operation foreign key(patient_id) references Patient(patient_id),
constraint fk_room_operation   foreign key (room_id) references Room(room_id)
);
 
 --i want if the patient take all medicine that exist in this treatment the state will be 'full' and if he don't take any of medicine the state in treatment will be 'zero' and if he take some of medicine the state in treatment will be number of medicine he took
create table Treatment(
treatment_id	int,
date		date,
state		    varchar(30)   ,
doctor_id		int,
patient_id		int,

constraint pk_treatment primary key (treatment_id),
constraint fk_doctor_treatment foreign key (doctor_id) references Doctor(doctor_id),
constraint fk_patient_treatment foreign key (patient_id) references Patient(patient_id)
);
 
--//////////////////////////////////////////////////////////////////////////////////////////////////////////doneK
create table Cleaner(
cleaner_id int,
first_name varchar(20),
last_name varchar(20),
address   varchar (20),
shift     varchar(20) ,
extra_hours   float,
start_date DATE,
genderc        varchar(20),

manager_id     int,

constraint ck_genderc  check (genderc in('female','male')),
constraint ck_shift_cleaner check (shift in('morning','evening')),

constraint pk_cleaner primary key (cleaner_id),
constraint fk_manager_cleaner foreign key (manager_id) references Manager(manager_id)
);
 --//////////////////////////////////////////////////////////////////////////////////////////////////////////  done
create table Pharmacy(
pharmacy_id int,
floor	int,

constraint pk_pharmacy primary key (pharmacy_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done

create table treatment_and_medicine(
treatment_id		int,
medicine_name	varchar(40),

constraint pk_treatment_and_medicine primary key( treatment_id,medicine_name),
constraint fk_treatment_treatment_and_medicine foreign key (treatment_id) references Treatment(treatment_id),
 );
 --////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table clean_room(
cleaner_id	int,
room_id		int,

constraint pk_clean_room primary key (cleaner_id,room_id) ,
constraint fk_cleaner_clean_room foreign key (cleaner_id) references Cleaner(cleaner_id),
constraint fk_room_clean_room foreign key (room_id) references Room(room_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table clean_clinic(
cleaner_id	int,
clinic_id		int,

constraint pk_clean_clinic primary key (cleaner_id,clinic_id) ,
constraint fk_cleaner_clean_clinic foreign key (cleaner_id) references Cleaner(cleaner_id),
constraint fk_clinic_clean_clinic foreign key (clinic_id) references Clinic(clinic_id)
);
 
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done

create table patient_take_donation(
patient_id	int,
donation_id int,
date date default getdate(),
constraint pk_patient_take_donation primary key (patient_id),
constraint fk_patient_patient_take_donation foreign key (patient_id) references Patient(patient_id),
constraint fk_donation_patient_take_donation foreign key (donation_id) references Donations(donation_id)
);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
 
create table nurse_do_operation(
nurse_id int,
operation_id int,

constraint pk_nurse_do_operation primary key (nurse_id,operation_id),
constraint fk_nurse_nurse_do_operation foreign key (nurse_id) references Nurse(nurse_id),
constraint fk_opration_nurse_do_operation foreign key (operation_id) references Operation(operation_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done

create table doctor_do_operation(
doctor_id int,
operation_id int,

constraint pk_doctor_do_operation primary key (doctor_id,operation_id),
constraint fk_doctor_doctor_do_operation foreign key (doctor_id) references Doctor(doctor_id),
constraint fk_opration_doctor_do_operation foreign key (operation_id) references Operation(operation_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
CREATE TABLE Patient_Treatment_Medicine (
    treatment_id   INT,
    medicine_name  VARCHAR(40),
    patient_id     INT,
    is_taken       BIT,

    CONSTRAINT fk_patient_treatment_medicine FOREIGN KEY (treatment_id, medicine_name) 
        REFERENCES Treatment_and_Medicine (treatment_id, medicine_name),
    CONSTRAINT fk_patient_medicine FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table driver_take_patient(
driver_id		int,
patient_id		int,
date			date default getdate(),
constraint pk_driver_take_patient primary key (patient_id),
constraint fk_driver_driver_take_patient foreign key (driver_id) references Driver(driver_id),
constraint fk_patient_driver_take_patient foreign key (patient_id) references Patient(patient_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table patient_take_by_ambulance(
patient_id		int,
ambulance_id		int,
date			date default getdate(),

constraint pk_patient_take_by_ambulance primary key (patient_id),
constraint fk_patient_patient_take_by_ambulance foreign key (patient_id) references Patient(patient_id),
constraint fk_ambulance_patient_take_by_ambulance foreign key (ambulance_id) references Ambulance (ambulance_id)
);

--//////////////////////////////////////////////////////////////////////////////////////////////////////////
create table nurse_work_at_room(
nurse_id  int,
room_id   int,
constraint pk_nurse_work_at_room primary key(nurse_id,room_id),
constraint fk_nurse_nurse_work_at_room foreign key (nurse_id) references Nurse(nurse_id),
constraint fk_room_nurse_work_at_room foreign key (room_id) references Room(room_id)
);
--//////////////////////////////////////////////////////////////////////////////////////////////////////////

create table treatment_and_pharmacy(
treatment_id		int,
pharmacy_id	int,

constraint pk_treatment_and_pharmacy primary key( treatment_id,pharmacy_id),
constraint fk_treatment_treatment_and_pharmacy foreign key (treatment_id) references Treatment(treatment_id),
constraint fk_pharmacy_treatment_and_pharmacy foreign key (pharmacy_id) references Pharmacy (pharmacy_id)
);
--//////////////////////////////////////////////////////////////////////////////////////////////////////////  done
create table pharmacy_and_medicine(
pharmacy_id		int,
medicine_name		varchar(40),
number_of_medicine_box	int,
constraint pk_pharmcy_and_medicine primary key (pharmacy_id,medicine_name),
constraint fk_pharmacy_pharmacy_and_medicine foreign key (pharmacy_id) references Pharmacy(pharmacy_id),
 );
 --//////////////////////////////////////////////////////////////////////////////////////////////////////////

create table patient_and_paramedic(
patient_id    int,
paramedic_id   int,

constraint pk_patient_and_paramedic primary key(patient_id,paramedic_id),
constraint fk_patient_patient_and_paramedic foreign key (patient_id) references Patient(patient_id),
constraint fk_paramedic_patient_and_paramedic foreign key (paramedic_id) references Paramedic(paramedic_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table doctor_with_patient_in_room(
doctor_id		int,
patient_id		int,

constraint pk_doctor_whit_patient_int_room primary key(doctor_id,patient_id) ,
constraint fk_doctor_doctor_whit_patient_int_room foreign key(doctor_id) references Doctor(doctor_id),
constraint fk_patient_doctor_whit_patient_int_room foreign key (patient_id) references Patient(patient_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table doctor_work_at_room(
doctor_id		int,
room_id		int,

constraint pk_doctor_work_at_room primary key(doctor_id,room_id) ,
constraint fk_doctor_doctor_work_at_room foreign key(doctor_id) references Doctor(doctor_id),
constraint fk_room_doctor_work_at_room foreign key (room_id) references Room(room_id)
);
 
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table patient_stay_in_room(
patient_id		int,
room_id		int,
constraint pk_patient_stay_in_room primary key(patient_id),
constraint fk_patient_patient_stay_in_room foreign key (patient_id) references Patient(patient_id),
constraint fk_room_patient_stay_in_room foreign key (room_id ) references Room (room_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table nurse_with_patient_in_room(
nurse_id		int,
patient_id		int,

constraint pk_nurse_with_patient_in_room  primary key(nurse_id,patient_id),
constraint fk_nurse_nurse_with_patient_in_room foreign key(nurse_id) references Nurse(nurse_id),
constraint fk_patient_nurse_with_patient_in_room foreign key(patient_id) references Patient(patient_id)
);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table patien_call_receptionsit(
receptionist_id			int,
patient_id		int,

constraint pk_patien_call_receptionsit primary key(patient_id),
constraint fk_receptionist_patien_call_receptionsit foreign key(receptionist_id) references Receptionist(receptionist_id),
constraint fk_patient_patien_call_receptionsit foreign key (patient_id) references Patient(patient_id)
);
 --////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table pharmacyutical_call_worker_store_to_get_medicine(
worker_store_id	int,
pharmacyutical_id int,
ordder varchar(100) ,
constraint pk_pharmacyutical_call_worker_store_to_get_medicine primary key (worker_store_id),
constraint fk_worker_store_pharmacyutical_call_worker_store_to_get_medicine foreign key(worker_store_id) references worker_store(worker_store_id),
constraint fk_pharmacyutical_pharmacyutical_call_worker_store_to_get_medicine foreign key(pharmacyutical_id) references Pharmacyutical(pharmacyutical_id)
);
 
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table doctor_phone(
doctor_id	int,
phone		varchar(11),

constraint pk_doctor_phone primary key(doctor_id,phone),
constraint fk_doctor_doctor_phone foreign key (doctor_id) references Doctor(doctor_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table paramedic_phone(
paramedic_id	int,
phone		varchar(11),

constraint pk_paramedic_phone primary key(paramedic_id,phone),
constraint fk_paramedic_paramedic_phone foreign key (paramedic_id) references Paramedic(paramedic_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table driver_phone(
driver_id	int,
phone		varchar(11),

constraint pk_driver_phone primary key(driver_id,phone),
constraint fk_driver_driver_phone foreign key (driver_id) references Driver(driver_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table patient_phone(
patient_id  int,
phone		varchar(11),

constraint pk_patient_phone primary key(patient_id,phone),
constraint fk_patient_patient_phone foreign key (patient_id) references Patient(patient_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table cleaner_phone(
cleaner_id	int,
phone		varchar(11),

constraint pk_cleaner_phone primary key(cleaner_id,phone),
constraint fk_cleaner_cleaner_phone foreign key (cleaner_id) references Cleaner(cleaner_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table receptionist_phone(
receptionist_id	int,
phone		varchar(11),

constraint pk_receptionist_phone primary key(receptionist_id,phone),
constraint fk_receptionist_receptionist_phone foreign key (receptionist_id) references Receptionist(receptionist_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table donar_phone(
donation_id	int,
phone		varchar(11),

constraint pk_donar_phone primary key(donation_id,phone),
constraint fk_donar_donar_phone foreign key (donation_id) references Donations(donation_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table nurse_phone(
nurse_id	int,
phone		varchar(11),

constraint pk_nurse_phone primary key(nurse_id,phone),
constraint fk_nurse_nurse_phone foreign key (nurse_id) references Nurse(nurse_id)
); 
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table manager_phone(
manager_id	int,
phone		varchar(11),

constraint pk_manager_phone primary key(manager_id,phone),
constraint fk_manager_manager_phone foreign key (manager_id) references Manager(manager_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table pharmacyutical_phone(
pharmacyutical_id	int,
phone		varchar(11),

constraint pk_pharmacyutical_phone primary key(pharmacyutical_id,phone),
constraint fk_pharmacyutical_pharmacyutical_phone foreign key (pharmacyutical_id) references Pharmacyutical(pharmacyutical_id)
);--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table worker_store_phone(
worker_store_id	int,
phone		varchar(11),

constraint pk_worker_store_phone primary key(worker_store_id,phone),
constraint fk_worker_store_worker_store_phone foreign key (worker_store_id) references worker_store(worker_store_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done

create table doctor_holiday(
doctor_id   int,
holiday		date,

constraint pk_doctor_holiday primary key (doctor_id,holiday),
constraint fk_doctor_doctor_holiday foreign key (doctor_id) references Doctor( doctor_id)
);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table paramedic_holiday(
    paramedic_id   int,
    holiday        date,

    constraint pk_paramedic_holiday primary key (paramedic_id, holiday),
    constraint fk_paramedic_paramedic_holiday foreign key (paramedic_id) references Paramedic(paramedic_id)
);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table driver_holiday(
    driver_id      int,
    holiday        date,

    constraint pk_driver_holiday primary key (driver_id, holiday),
    constraint fk_driver_driver_holiday foreign key (driver_id) references Driver(driver_id)
);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table cleaner_holiday(
    cleaner_id     int,
    holiday        date,

    constraint pk_cleaner_holiday primary key (cleaner_id, holiday),
    constraint fk_cleaner_cleaner_holiday foreign key (cleaner_id) references Cleaner(cleaner_id)
);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table receptionist_holiday(
    receptionist_id int,
    holiday         date,

    constraint pk_receptionist_holiday primary key (receptionist_id, holiday),
    constraint fk_receptionist_receptionist_holiday foreign key (receptionist_id) references Receptionist(receptionist_id)
);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table manager_holiday(
    manager_id     int,
    holiday        date,

    constraint pk_manager_holiday primary key (manager_id, holiday),
    constraint fk_manager_manager_holiday foreign key (manager_id) references Manager(manager_id)
);

--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table nurse_holiday(
    nurse_id       int,
    holiday        date,

    constraint pk_nurse_holiday primary key (nurse_id, holiday),
    constraint fk_nurse_nurse_holiday foreign key (nurse_id) references Nurse(nurse_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table worker_store_holiday(
    worker_store_id       int,
    holiday        date,

    constraint pk_worker_store_holiday primary key (worker_store_id, holiday),
    constraint fk_worker_store_worker_store_holiday foreign key (worker_store_id) references worker_store(worker_store_id)
);
--////////////////////////////////////////////////////////////////////////////////////////////////////////// done
create table pharmacyutical_holiday(
    pharmacyutical_id       int,
    holiday        date,

    constraint pk_pharmacyutical_holiday primary key ( pharmacyutical_id, holiday),
    constraint fk_pharmacyutical_pharmacyutical_holiday foreign key ( pharmacyutical_id) references  Pharmacyutical( pharmacyutical_id)
);

-- Triggers
CREATE TRIGGER trg_update_treatment_state
ON Patient_Treatment_Medicine
AFTER INSERT, UPDATE, DELETE
AS
BEGIN
    UPDATE Treatment
    SET state = CASE
        -- Case 1: All medicines are taken
        WHEN NOT EXISTS (
            SELECT 1
            FROM Treatment_and_Medicine tm
            WHERE tm.treatment_id = Treatment.treatment_id
              AND NOT EXISTS (
                SELECT 1
                FROM Patient_Treatment_Medicine ptm
                WHERE ptm.treatment_id = tm.treatment_id
                  AND ptm.medicine_name = tm.medicine_name
                  AND ptm.is_taken = 1
              )
        ) THEN 'full'

        -- Case 2: No medicines are taken
        WHEN NOT EXISTS (
            SELECT 1
            FROM Patient_Treatment_Medicine ptm
            WHERE ptm.treatment_id = Treatment.treatment_id
              AND ptm.is_taken = 1
        ) THEN 'zero'

        -- Case 3: Some medicines are taken
        ELSE CAST((
            SELECT COUNT(1)
            FROM Patient_Treatment_Medicine ptm
            WHERE ptm.treatment_id = Treatment.treatment_id
              AND ptm.is_taken = 1
        ) AS VARCHAR)
    END
    FROM Treatment
    WHERE EXISTS (
        SELECT 1
        FROM Patient_Treatment_Medicine ptm
        WHERE ptm.treatment_id = Treatment.treatment_id
    );
END;



 