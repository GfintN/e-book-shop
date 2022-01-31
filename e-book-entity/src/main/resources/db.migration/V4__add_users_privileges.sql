GRANT INSERT, UPDATE ON TABLE users_data_change_transaction TO normal_user;
GRANT INSERT, SELECT ON TABLE requests_for_author_status TO normal_user;
GRANT SELECT ON TABLE book_buy_transaction TO normal_user;

GRANT INSERT, UPDATE ON TABLE users_data_change_transaction TO reviewer;
GRANT SELECT ON TABLE reviewer_info TO reviewer;
GRANT SELECT ON TABLE book_buy_transaction TO author;
GRANT INSERT, SELECT, DELETE ON TABLE book_publication_requests TO reviewer;
GRANT SELECT, DELETE ON TABLE book_and_author TO reviewer;

GRANT INSERT, UPDATE ON TABLE users_data_change_transaction TO author;
GRANT SELECT ON TABLE book_buy_transaction TO author;
GRANT INSERT ON TABLE book_publication_requests TO author;
GRANT SELECT ON TABLE book_and_author TO author;

GRANT INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA schema TO system;
GRANT CREATE ON SCHEMA schema TO system;
