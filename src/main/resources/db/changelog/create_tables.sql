CREATE TABLE IF NOT EXISTS intern (
                        id BIGINT PRIMARY KEY,
                        fullName VARCHAR(255),
                        age INT,
                        place VARCHAR(255),
                        degree VARCHAR(255),
                        contacts VARCHAR(255),
                        city VARCHAR(255),
                        speciality VARCHAR(255),
                        description TEXT,
                        skills TEXT,
                        sex VARCHAR(255),
                        GPA DOUBLE PRECISION
);

CREATE TYPE vacancytype AS ENUM ('ONLINE', 'OFFLINE') ON CONFLICT DO NOTHING;

CREATE TABLE IF NOT EXISTS vacancy (
                         id BIGINT PRIMARY KEY,
                         name VARCHAR(255),
                         salary NUMERIC(20),
                         requirements TEXT,
                         offers TEXT,
                         speciality VARCHAR(255),
                         companyId BIGINT,
                         internIds TEXT,
                         type vacancytype
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

