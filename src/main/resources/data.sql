-- Initial data for Attijariwafa Bank Transaction Processor
-- This will be loaded automatically by Spring Boot when using H2

-- Create test accounts - Updated to match AccountEntity table structure
INSERT INTO accounts (account_number, account_status, available_balance, real_balance, ledger_balance, facilities, holds, customer_id, created_at, updated_at) VALUES
('001234567890123', 'ACTIVE', 250000, 250000, 250000, 0, 0, 'CUST001', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('123456789123456', 'ACTIVE', 156750, 156750, 156750, 0, 0, 'CUST002', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('123456789012345', 'ACTIVE', 256750, 256750, 256750, 0, 0, 'CUST003', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('555444333222111', 'ACTIVE', 245680, 245680, 245680, 0, 0, 'CUST004', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('999888777666555', 'BLOCKED', 12500, 12500, 12500, 0, 0, 'CUST005', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('111222333444555', 'ACTIVE', 0, 0, 0, 0, 0, 'CUST006', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Create system users - Updated to match SystemUsers table structure
INSERT INTO system_users (user_id, password, user_type, status, failed_attempts, description, last_login) VALUES
('opvuser', 'pa123456', 'SYSTEM', 'ACTIVE', 0, 'OPV System User', CURRENT_TIMESTAMP),
('testuser', 'test123', 'TEST', 'ACTIVE', 0, 'Test User', CURRENT_TIMESTAMP),
('admin', 'admin123', 'ADMIN', 'ACTIVE', 0, 'Administrator', CURRENT_TIMESTAMP);