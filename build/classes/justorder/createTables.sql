/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  adil
 * Created: Apr 14, 2017
 */
DROP DATABASE IF EXISTS JustOrder;
CREATE DATABASE JustOrder;
USE JustOrder;

create table ITEMS(
    itemname varchar(50),
    INRprice decimal(6,2),
    primary key(itemname)
   );

create table ADMINS(
    adminname varchar(50),
    email varchar(50),
    phone varchar(50),
    username varchar(50),
    password varchar(50)
    primary key(username)
    );

create table CUSTOMERS(
    customername varchar(50),
    email varchar(50),
    phone varchar(50),
    username varchar(50),
    password varchar(50)
    primary key(username)
    );

create table ORDERS(
    orderID int,
    primary key (orderID)
    );

create table DELIVERY(
    custname varchar(50),
    address  varchar(100),
    primary key(custname)
    );