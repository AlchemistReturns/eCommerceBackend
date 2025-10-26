INSERT INTO categories (name)
VALUES ('Fruits & Vegetables'),
       ('Dairy & Eggs'),
       ('Bakery'),
       ('Beverages'),
       ('Snacks');

INSERT INTO products (name, price, description, category_id)
VALUES
-- Fruits & Vegetables (id = 1)
('Fresh Bananas (1kg)', 85.00, 'Ripe Cavendish bananas, perfect for snacks or smoothies.', 1),
('Red Tomatoes (500g)', 45.00, 'Juicy, farm-fresh tomatoes ideal for salads and cooking.', 1),

-- Dairy & Eggs (id = 2)
('Farm Fresh Eggs (Dozen)', 160.00, 'Grade A brown eggs from free-range hens.', 2),
('Milk (1 Liter)', 90.00, 'Full cream pasteurized milk, rich in protein and calcium.', 2),

-- Bakery (id = 3)
('Whole Wheat Bread', 120.00, 'Soft and healthy bread made from 100% whole wheat flour.', 3),
('Chocolate Muffins (Pack of 4)', 180.00, 'Moist muffins baked with rich cocoa and chocolate chips.', 3),

-- Beverages (id = 4)
('Coca-Cola (1.25L)', 75.00, 'Classic carbonated soft drink with a refreshing taste.', 4),
('Tropicana Orange Juice (1L)', 190.00, '100% pure orange juice with no added sugar or preservatives.', 4),

-- Snacks (id = 5)
('Lay’s Classic Salted Chips (100g)', 70.00, 'Crispy and lightly salted potato chips.', 5),
('Oreo Cookies (120g)', 90.00, 'Chocolate sandwich cookies with vanilla cream filling.', 5);
