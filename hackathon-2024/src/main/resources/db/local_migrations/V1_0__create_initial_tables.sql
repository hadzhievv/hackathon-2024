-- V1__initial_setup.sql

CREATE SCHEMA IF NOT EXISTS hackathon_2024;


-- Create devices table
CREATE TABLE hackathon_2024.device
(
    device_id        SERIAL PRIMARY KEY,
    product_type     VARCHAR(100)        NOT NULL,
    serial_number    VARCHAR(100) UNIQUE NOT NULL,
    software_version VARCHAR(50),
    hardware_version VARCHAR(50),
    comm_settings    JSONB,
    status           VARCHAR(20) DEFAULT 'Active',
    created_at       TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);