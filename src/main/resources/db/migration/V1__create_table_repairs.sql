create table repair (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    entry_date VARCHAR(10) NOT NULL,
    out_date VARCHAR(10) NOT NULL,
    name_mechanic VARCHAR(100) NOT NULL,
    exp_years INT NOT NULL,
    brand VARCHAR(50) NOT NULL,
    year_vehicle INT NOT NULL,
    model VARCHAR(50) NOT NULL
);
