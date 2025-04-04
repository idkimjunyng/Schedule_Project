create table member (
                        created_at datetime(6),
                        id bigint not null auto_increment,
                        updated_at datetime(6),
                        email varchar(255) not null,
                        name varchar(255) not null,
                        password varchar(255) not null,
                        primary key (id)
) engine=InnoDB

create table todo (
                      created_at datetime(6),
                      id bigint not null auto_increment,
                      member_id bigint,
                      updated_at datetime(6),
                      content longtext,
                      title varchar(255) not null,
                      primary key (id)
) engine=InnoDB