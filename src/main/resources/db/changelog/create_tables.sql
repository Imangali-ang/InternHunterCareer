CREATE TABLE IF NOT EXISTS intern (
    id BIGINT PRIMARY KEY,
    full_name VARCHAR(255),
    age INT,
    place VARCHAR(255),
    degree VARCHAR(255),
    contacts VARCHAR(255),
    city VARCHAR(255),
    speciality VARCHAR(255),
    description TEXT,
    skills TEXT,
    gender VARCHAR(255),
    GPA DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS vacancy (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255),
    salary NUMERIC(20),
    requirements TEXT,
    offers TEXT,
    city VARCHAR(255),
    speciality VARCHAR(255),
    company_id BIGINT,
    intern_ids TEXT,
    vacancy_type VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS company (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) ,
    city VARCHAR(255),
    address VARCHAR(255) ,
    contacts VARCHAR(255) ,
    speciality VARCHAR(255) ,
    description TEXT
);

