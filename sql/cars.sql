CREATE TABLE cars (
    id SERIAL PRIMARY KEY,
    manufacturer VARCHAR(100) NOT NULL,
    model VARCHAR(100) NOT NULL,
    engine_volume NUMERIC(2,1) NOT NULL,
    year INT NOT NULL,
    color VARCHAR(50),
    type VARCHAR(20) CHECK (type IN ('sedan', 'hatchback', 'wagon'))
);

INSERT INTO cars (manufacturer, model, engine_volume, year, color, type) VALUES
('Toyota', 'Camry', 2.5, 2020, 'Black', 'sedan'),
('Toyota', 'Corolla', 1.6, 2018, 'White', 'sedan'),
('BMW', 'X5', 3.0, 2021, 'Black', 'wagon'),
('BMW', '320i', 2.0, 2019, 'Blue', 'sedan'),
('Audi', 'A3', 1.8, 2017, 'Red', 'hatchback'),
('Audi', 'A6', 2.4, 2022, 'Gray', 'sedan'),
('Ford', 'Focus', 1.6, 2016, 'White', 'hatchback');