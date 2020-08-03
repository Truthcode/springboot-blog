use xdml;
create table user
(
    id                 bigint primary key auto_increment,
    username           varchar(100),
    encrypted_password varchar(100),
    avatar             varchar(100),
    created_at         datetime,
    updated_at         datetime
)CHARACTER SET utf8 COLLATE utf8_general_ci
