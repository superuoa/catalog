CREATE TABLE IF NOT EXISTS product(
  id integer not null auto_increment,
  name varchar(255) not null,
  description varchar (255) not null,
  price  int(11) NOT NULL,
  warranty int(11) NOT NULL,
  primary key (id)
);