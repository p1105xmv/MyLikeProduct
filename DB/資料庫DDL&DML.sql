create database esunjojo  COLLATE Chinese_Taiwan_Stroke_90_CI_AS_SC ;

USE eSun;

CREATE TABLE Userinfo(
   userid int not null primary key identity(1,1),
   username nvarchar(30) not null,
   email nvarchar(50)
);

CREATE TABLE UserAccount(
   account nvarchar(100) not null primary key,
   userid int,
   FOREIGN KEY (userid) REFERENCES Userinfo(userid)
);

CREATE TABLE Product(
   productid int not null primary key identity(1,1),
   product_name nvarchar(100) not null,
   price int,
   fee_rate DECIMAL(5, 2),
   userid int,
   FOREIGN KEY (userid) REFERENCES Userinfo(userid)
);

CREATE TABLE LikeList(
   listid int not null primary key identity(1,1),
   productid int,
   order_quantity int,
   account nvarchar(100),
   total_fee DECIMAL(10, 2),
   total_amount int,
   FOREIGN KEY (productid) REFERENCES Product(productid),
   FOREIGN KEY (account) REFERENCES UserAccount(account)
);

insert into Userinfo
values('王財富','money6666@tmail.com'),('白富美','maymay987@gmail.com'),('李大仁','bigreng@tmail.com'),('陳小山','mountain456@gmail.com'),('林佳儀','mary000@kmail.com');

insert into UserAccount
values('48630586048372',1),('0398742649245',1),('346894255800',2),('10009875329',3),('9746638996110',3),('098877177348',3),
('2497661134304',3),('1387004994623',4),('9839592636644',4),('70707085740522',5),('0786859572111',5);


insert into Product
values('美股最強20檔高股息ETF',50000,0.02,1),('優惠高利存款',80000,0.01,1),('綠色授信專案貸款',8990000,0.03,2),
('太陽光電專案融資',10000000,0.06,2),('海外債券A',6000,0.02,2),('黃金存摺C',80000,0.04,3),('海外綜合ETF',40000,0.01,3),
('高盛投資基金X美元',300000,0.03,4),('全球動態多重資產基金',6030000,0.04,4),('百達精選品牌退休基金',20000000,0.03,5);


insert into LikeList
values(1,10,'0398742649245',10000,510000),(6,2,'10009875329',6400,166400);

select * from LikeList;

update Product
set product_name = '美股最強30檔高股息ETF' where productid=1