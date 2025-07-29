-- Initial data for Attijariwafa Bank Transaction Processor
-- This will be loaded automatically by Spring Boot when using H2

-- Create test accounts (matching AccountEntity structure)
INSERT INTO accounts (account_number, account_status, is_debits_blocked, available_balance, real_balance, ledger_balance, facilities, holds, customer_id, created_at, updated_at) VALUES
('001234567890123', 'ACTIVE', 'N', 250000, 250000, 250000, 0, 0, '12345678', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('123456789123456', 'ACTIVE', 'N', 156750, 156750, 156750, 0, 0, '12345679', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('123456789012345', 'ACTIVE', 'N', 256750, 256750, 256750, 0, 0, '12345680', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('555444333222111', 'ACTIVE', 'N', 245680, 245680, 245680, 0, 0, '12345681', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('999888777666555', 'BLOCKED', 'Y', 12500, 12500, 12500, 0, 0, '12345682', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('111222333444555', 'ACTIVE', 'N', 0, 0, 0, 0, 0, '12345683', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Create system users (matching SystemUsers structure)
INSERT INTO system_users (user_id, password, user_type, status, failed_attempts, description, last_login) VALUES
('opvuser', 'pa123456', 'OPERATOR', 'ACTIVE', 0, 'Default OPV operator user', NULL),
('testuser', 'test123', 'TESTER', 'ACTIVE', 0, 'Test user for development', NULL),
('admin', 'admin123', 'ADMIN', 'ACTIVE', 0, 'System administrator', NULL);