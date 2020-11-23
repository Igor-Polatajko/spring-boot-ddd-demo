create table if not exists user(
 id           bigint       not null auto_increment,
 name         varchar(255),
 surname      varchar(255),
 active       bit,
 created_at   datetime,
 primary key (id)
);

create table if not exists feedback(
 id           bigint       not null auto_increment,
 content      varchar(255),
 user_id      bigint,
 created_at   datetime,
 primary key (id)
);

alter table feedback
  add constraint FK_Feedback_User foreign key (user_id) references user (id);