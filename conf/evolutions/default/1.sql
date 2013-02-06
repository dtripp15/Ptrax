# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table team (
  id                        bigint auto_increment not null,
  league_id                 bigint,
  division_id               bigint,
  team_name                 varchar(255),
  constraint pk_team primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table team;

SET FOREIGN_KEY_CHECKS=1;

