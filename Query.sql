create database bb use bb
set
    dateformat dmy create table Doctors(
        D_EFN int primary key,
        D_FName varchar(200) NOT NULL,
        D_LName varchar(200) NOT NULL,
        D_NID int Unique,
        D_Salary int
    );

create table D_Phone(
    D_Phone varchar(15) unique,
    D_EFN1 int foreign key references Doctors(D_EFN)
);

create table D_Q(
    D_Qual varchar(200),
    D_EFN2 int foreign key references Doctors(D_EFN)
);

create table Nurses(
    N_EFN int primary key,
    N_FName varchar(200) NOT NULL,
    N_LName varchar(200) NOT NULL,
    N_NID int Unique,
    N_Salary int,
    D_EFN3 int foreign key references Doctors(D_EFN)
);

create table N_Phone(
    N_Phone varchar(15) unique,
    N_EFN1 int foreign key references Nurses(N_EFN)
);

create table Donors(
    DO_NN int primary key,
    DO_FName varchar(200) NOT NULL,
    DO_LName varchar(200) NOT NULL,
    DO_BT varchar(3),
    DO_DDate date,
    DO_DAR varchar(5),
    D_EFN4 int foreign key references Doctors(D_EFN),
    N_EFN2 int foreign key references Nurses(N_EFN)
);

create table DO_Phone(
    DO_Phone varchar(15) unique,
    DO_NN1 int foreign key references Donors(DO_NN)
);