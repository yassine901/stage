-- Initial data for Attijariwafa Bank Transaction Processor
-- This will be loaded automatically by Spring Boot when using H2

-- Create test accounts
INSERT INTO account_entity (account_number, balance, status, account_type, creation_date) VALUES
('001234567890123', 250000, 'ACTIVE', 'CHECKING', CURRENT_TIMESTAMP),
('123456789123456', 156750, 'ACTIVE', 'CHECKING', CURRENT_TIMESTAMP),
('123456789012345', 256750, 'ACTIVE', 'SAVINGS', CURRENT_TIMESTAMP),
('555444333222111', 245680, 'ACTIVE', 'CHECKING', CURRENT_TIMESTAMP),
('999888777666555', 12500, 'BLOCKED', 'CHECKING', CURRENT_TIMESTAMP),
('111222333444555', 0, 'ACTIVE', 'CHECKING', CURRENT_TIMESTAMP);

-- Create system users
INSERT INTO system_users (username, password, active, creation_date) VALUES
('opvuser', 'pa123456', true, CURRENT_TIMESTAMP),
('testuser', 'test123', true, CURRENT_TIMESTAMP),
('admin', 'admin123', true, CURRENT_TIMESTAMP);