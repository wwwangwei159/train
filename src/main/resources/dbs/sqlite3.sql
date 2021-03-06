------drop table 
drop table m_user;
drop table message_leave;
drop table reserve_course;
drop table questionnaire;
drop table evaluation_result;
drop table qna_question;
drop table question;
drop table question_option;
drop table exam_result_head;
drop table exam_result_detail;
drop table course

CREATE TABLE m_user(  ---用户表
user_id varchar(15) primary key, ----yyyymmddhhmisssss8888
name varchar(80),
pwd varchar(80) DEFAULT NULL, 
create_datetime datetime default null, 
update_datetime datetime default null,
age int default null, 
sex varchar(10) default null,
mobile varchar(80) default null, 
email varchar(80) default null,
phone varchar(80) default null
);

CREATE TABLE message_leave ( ---留言表
mess_id varchar(15) primary key,  ----yyyymmddhhmisssss8888
reserve_name varchar(80) DEFAULT NULL, ---预约人姓名
user_id varchar(80) DEFAULT NULL,
leave_datetime datetime DEFAULT NULL,
message varchar(1024) DEFAULT NULL, ---留言内容
mobile varchar(80) DEFAULT NULL,
email varchar(80) DEFAULT NULL,
phone varchar(80) DEFAULT NULL,
status varchar(80) DEFAULT NULL
);

CREATE TABLE reserve_course( ---预约老师表
reserve_id varchar(15) primary key,  ----yyyymmddhhmisssss8888
reserve_name varchar(80) DEFAULT NULL, --预约人姓名
course_id varchar(80) DEFAULT NULL,  --预约课程
point_datetime datetime DEFAULT NULL, --预约人时间
agree_datetime datetime DEFAULT NULL,
mobile varchar(80) DEFAULT NULL,
email varchar(80) DEFAULT NULL,
phone varchar(80) DEFAULT NULL,
status varchar(2) DEFAULT NULL
);


CREATE TABLE questionnaire (
qna_id varchar(15) primary key,  ---问卷id  ----yyyymmddhhmisssss888 
qna_name varchar(256) DEFAULT NULL,---问卷名称
user_id varchar(80) DEFAULT NULL,
create_datetime datetime DEFAULT NULL,
publish_datetime datetime DEFAULT NULL,
qna_type varchar(256) DEFAULT NULL,  ---问卷类型
qna_status varchar(20) DEFAULT NULL   ---问卷类型
);

CREATE TABLE evaluation_result (  ---问卷总评表
result_id varchar(15) primary key,       
qna_id varchar(256) DEFAULT NULL,
min_score_interval int NOT NULL,   ---问卷区间
max_score_interval int NOT NULL,   ---问卷区间
result_message varchar(2048) DEFAULT NULL, ---评定结果
ressult_seq int NOT NULL
);

CREATE TABLE qna_question (
qna_qid varchar(15) primary key,  ---问卷问题 ----yyyymmddhhmisssss888 
qna_id varchar(80) DEFAULT NULL,  ---问卷id
q_id varchar(80) DEFAULT NULL,  ---问题id
q_seq int NOT NULL    ---问卷问题序号
);

CREATE TABLE question (
q_id varchar(15) primary key,  ---问题id
q_name varchar(512) DEFAULT NULL, ---问题名称
q_type varchar(20) DEFAULT NULL, ---问题类型，单选，多选
q_factor varchar(50) DEFAULT NULL,  ---问题因子，做分类用
q_status varchar(20) DEFAULT NULL   ---问题状态
);

CREATE TABLE question_option (  ---问题选项内容表
q_op_id varchar(15) primary key,     
q_op_seq int NOT NULL,
q_op_name varchar(512) DEFAULT NULL,
q_op_score int NOT NULL,
q_id varchar(80) DEFAULT NULL
);



CREATE TABLE exam_result_head (  ---答题结果表
exam_id varchar(15) primary key,  ---答题id     
qna_id varchar(15) DEFAULT NULL,  --问卷id
user_id varchar(15) DEFAULT NULL, ---答题人id
exam_score int NOT NULL  ---问卷
);

CREATE TABLE exam_result_detail (  ---答题结果表
exam_result_id varchar(15) primary key,  ---详细id   
exam_id varchar(15) DEFAULT NULL,   ---答题id   
qna_id varchar(15) DEFAULT NULL,  --问卷id冗余字段
q_id varchar(15) DEFAULT NULL, ---问题ID
exam_score int NOT NULL  ---问卷
);

CREATE TABLE course(  ---课程表
course_id varchar(15) primary key, ----yyyymmddhhmisssss8888
course_name varchar(80),---课程名称
course_message varchar(300),----课程介绍
course_address varchar(300),----上课地点
user_id varchar(15) DEFAULT NULL,---上课老师
start_datetime datetime default null, ---开始时间
end_datetime datetime default null,---结束时间
max_count int default null, ---最大人数
now_count int default 0,---当前预约数
email varchar(80) default null,---咨询邮箱
phone varchar(80) default null ---课程咨询电话
);

