CREATE TABLE reviewer_info (
  id BIGINT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  mac_address VARCHAR NOT NULL,
  first_name VARCHAR NOT NULL,
  sur_name VARCHAR NOT NULL,
  patronymic VARCHAR NOT NULL,
  hiring_date DATE NOT NULL,
  dismissal_date DATE,
  cause_dismissal VARCHAR
);
CREATE TABLE sub_admin_delete_requests (
  id BIGINT PRIMARY KEY,
  cause_dismissal VARCHAR NOT NULL,
  requests_date DATE NOT NULL
);
CREATE TABLE sub_admin_info (
  id BIGINT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  mac_address VARCHAR NOT NULL,
  working_mail VARCHAR NOT NULL,
  first_name VARCHAR NOT NULL,
  sur_name VARCHAR NOT NULL,
  patronymic VARCHAR NOT NULL,
);
CREATE TABLE users_data_change_transaction (
  user_id BIGINT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  date_changes DATE NOT NULL,
  before_password VARCHAR,
  new_password VARCHAR,
  before_mail VARCHAR ARRAY,
  new_mail VARCHAR,
  before_user_name VARCHAR,
  new_user_name VARCHAR
);
CREATE TABLE book_publication_requests (
  id BIGINT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  book_or_collection_name VARCHAR NOT NULL UNIQUE,
  book_in_collection_name VARCHAR ARRAY,
  txt_file_path VARCHAR ARRAY,
  id_reviewer BIGINT,
  FOREIGN KEY(id_reviewer) REFERENCES reviewer_info(id)
);
CREATE TABLE book_and_author (
  id BIGINT PRIMARY KEY,
  book_or_collection_name VARCHAR NOT NULL,
  user_id VARCHAR NOT NULL,
  date_of_create_book DATE,
  book_status SMALLINT,
  book_price INT,
  FOREIGN KEY(book_or_collection_name) REFERENCES book_publication_requests(book_or_collection_name)
);
CREATE TABLE book_buy_transaction (
  id BIGINT PRIMARY KEY,
  time_start_transaction DATE NOT NULL,
  user_id BIGINT NOT NULL,
  bool_out_money BIGINT,
  bool_inp_money BIGINT,
  time_end_transaction DATE
);
CREATE TABLE requests_for_author_status (
  id BIGINT PRIMARY KEY,
  user_id BIGINT NOT NULL,
  user_name VARCHAR NOT NULL,
  date_massage DATE NOT NULL,
  first_or_test_book VARCHAR ARRAY NOT NULL,
  id_reviewer BIGINT,
  FOREIGN KEY(id_reviewer) REFERENCES reviewer_info(id)
);
