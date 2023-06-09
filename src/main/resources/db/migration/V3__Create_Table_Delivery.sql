CREATE TABLE delivery (
  id BIGSERIAL PRIMARY KEY,
  client_id BIGINT NOT NULL,
  tax DECIMAL(10,2) NOT NULL,
  delivery_status VARCHAR(20) NOT NULL,
  order_date TIMESTAMP NOT NULL,
  completion_date TIMESTAMP,
  recipient_name VARCHAR(60) NOT NULL,
  recipient_street VARCHAR(255) NOT NULL,
  recipient_number INTEGER NOT NULL,
  recipient_complement VARCHAR(60),
  recipient_neighborhood VARCHAR(30) NOT NULL
);

ALTER TABLE delivery ADD CONSTRAINT fk_delivery_client FOREIGN KEY (client_id) REFERENCES client (id);