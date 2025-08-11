CREATE TABLE transactions (
    id VARCHAR(36) PRIMARY KEY NOT NULL,
    transaction_type VARCHAR(7) NOT NULL, 
    category VARCHAR(15) NOT NULL,
    transaction_date DATE NOT NULL,
    amount DECIMAL(12, 2) NOT NULL,
    note VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE INDEX idx_tx_category ON transactions(category);
CREATE INDEX idx_tx_date ON transactions(transaction_date);
CREATE INDEX idx_tx_type ON transactions(transaction_type);
CREATE INDEX idx_tx_date_category ON transactions(transaction_date, category);