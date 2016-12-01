DROP DATABASE member;
CREATE DATABASE member;
USE member;

create table guest(
name varchar(20),
age int,
id varchar(20),
password varchar(20),
come int);

create table room(
room int,
room1 int,
room2 int,
room3 int,
room4 int,
room5 int,
room6 int,
room7 int,
room8 int,
room9 int);

create table economy(
word varchar(20),
mean varchar(30));

create table traffic(
word varchar(20),
mean varchar(30));

create table business(
word varchar(20),
mean varchar(30));

create table shopping(
word varchar(20),
mean varchar(30));

create table travel(
word varchar(20),
mean varchar(30));

INSERT INTO room VALUES(0,0,0,0,0,0,0,0,0,0);

INSERT INTO economy VALUES ('agricultural', '(adj)농업의');
INSERT INTO economy VALUES ('belongings', '(n)소유물');
INSERT INTO economy VALUES ('collateral', '(n)담보');
INSERT INTO economy VALUES ('deduction', '(n)공제');
INSERT INTO economy VALUES ('auction', '(n)경매');
INSERT INTO economy VALUES ('brokerage', '(n)중개업');
INSERT INTO economy VALUES ('consumption', '(n)소비');
INSERT INTO economy VALUES ('deficit', '(n)적자');
INSERT INTO economy VALUES ('economic', '(adj)경제학의');
INSERT INTO economy VALUES ('deduct', '(v)공제하다');

INSERT INTO traffic VALUES ('aboard', '(adj)타고있는');
INSERT INTO traffic VALUES ('tollbooth', '(n)통행료징수소');
INSERT INTO traffic VALUES ('boulevard', '(n)(도시안팎의)대로');
INSERT INTO traffic VALUES ('carrier', '(n)운송업자');
INSERT INTO traffic VALUES ('congestion', '(n)혼잡');
INSERT INTO traffic VALUES ('departure', '(n)출발');
INSERT INTO traffic VALUES ('detour', '(n)우회로');
INSERT INTO traffic VALUES ('license', '(n)운전면허증');
INSERT INTO traffic VALUES ('commuter', '(n)통근자');
INSERT INTO traffic VALUES ('airliner', '(n)여객기');

INSERT INTO business VALUES ('panel', '(n)위원회');
INSERT INTO business VALUES ('alternative', '(n)대안');
INSERT INTO business VALUES ('venture', '(n)투자');
INSERT INTO business VALUES ('implication', '(n)암시');
INSERT INTO business VALUES ('amend', '(v)수정하다');
INSERT INTO business VALUES ('evaluate', '(v)평가하다');
INSERT INTO business VALUES ('handout', '(n)유인물');
INSERT INTO business VALUES ('postpone', '(v)연기하다');
INSERT INTO business VALUES ('presentation', '(n)발표회');
INSERT INTO business VALUES ('negotiate', '(v)협상하다');

INSERT INTO shopping VALUES ('brandnew', '(adj)신제품인');
INSERT INTO shopping VALUES ('handmade', '(adj)수제의');
INSERT INTO shopping VALUES ('installment', '(n)할부');
INSERT INTO shopping VALUES ('defective', '(adj)결함이있는');
INSERT INTO shopping VALUES ('durability', '(n)내구성');
INSERT INTO shopping VALUES ('faulty', '(adj)결점(흠)이 있는');
INSERT INTO shopping VALUES ('inventory', '(n)재고품(목록)');
INSERT INTO shopping VALUES ('optional', '(adj)임의의');
INSERT INTO shopping VALUES ('coupon', '(n)쿠폰');
INSERT INTO shopping VALUES ('warranty', '(n)보증(서)');

INSERT INTO travel VALUES ('itinerary', '(n)여행일정(표)');
INSERT INTO travel VALUES ('derail', '(v)탈선하다');
INSERT INTO travel VALUES ('valid', '(adj)유효한');
INSERT INTO travel VALUES ('baggage', '(n)수화물');
INSERT INTO travel VALUES ('admission', '(n)입국(허가)');
INSERT INTO travel VALUES ('agent', '(n)대행인');
INSERT INTO travel VALUES ('ferry', '(n)여객선');
INSERT INTO travel VALUES ('reserve', '(v)예약하다');
INSERT INTO travel VALUES ('transit', '(n)통과');
INSERT INTO travel VALUES ('commute', '(v)통근하다');

COMMIT;