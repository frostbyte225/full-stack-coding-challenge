CREATE TABLE employee (
    id BIGINT NOT NULL,
    user_id VARCHAR(255) NOT NULL UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    state VARCHAR(255) NOT NULL,
    zip VARCHAR(255) NOT NULL,
    cell_phone VARCHAR(255) NOT NULL,
    home_phone VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

INSERT INTO employee VALUES ( 101, 'test_user_id' , 
                                    'test_first_name', 
                                    'test_last_name', 
                                    'test_address', 
                                    'test_state', 
                                    'test_zip', 
                                    'test_cell', 
                                    'test_home', 
                                    'test_email');