CREATE TABLE IF NOT EXISTS produtos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco NUMERIC(10, 2) NOT NULL,
    quantidade INT NOT NULL,
    estoque_minimo INT NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS produtos_nome_unico ON produtos (nome);

INSERT INTO produtos (nome, preco, quantidade, estoque_minimo) VALUES
('Notebook Dell Inspiron', 4500.00, 8, 5),
('Mouse Gamer RGB', 150.00, 3, 10),
('Teclado Mecânico', 350.00, 12, 5),
('Monitor Ultrawide 29"', 1200.00, 2, 4),
('Headset Gamer', 250.00, 15, 10),
('Webcam Full HD', 320.00, 6, 8),
('SSD NVMe 1TB', 550.00, 0, 5),
('Cadeira Gamer', 1100.00, 9, 3),
('Hub USB 3.0', 90.00, 4, 10),
('Fonte 650W', 480.00, 7, 6)
ON CONFLICT (nome) DO NOTHING;