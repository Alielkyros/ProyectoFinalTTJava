-- -----------------------------------------------------------------------
-- Categoría 1: Electrónica
-- -----------------------------------------------------------------------
INSERT INTO product (title, category, price, image, stock, deleted, deleted_date) VALUES
('Smartphone G20', 'Electrónica', 799.99, 'e_phone_g20.jpg', 40, FALSE, NULL),
('Auriculares Bluetooth X5', 'Electrónica', 89.50, 'e_headset_x5.png', 75, FALSE, NULL),
('Smartwatch S10', 'Electrónica', 199.00, 'e_watch_s10.webp', 25, FALSE, NULL),
('Tablet Pro 10"', 'Electrónica', 450.00, 'e_tablet_pro.jpg', 33, FALSE, NULL),
('Cámara Web 4K', 'Electrónica', 55.75, 'e_webcam_4k.png', 50, FALSE, NULL);

-- -----------------------------------------------------------------------
-- Categoría 2: Ropa y Accesorios
-- -----------------------------------------------------------------------
INSERT INTO product (title, category, price, image, stock, deleted, deleted_date) VALUES
('Zapatillas Running AirFlow', 'Ropa y Accesorios', 95.00, 'd_zapatillas.jpg', 60, FALSE, NULL),
('Camiseta Dry-Fit', 'Ropa y Accesorios', 25.50, 'd_camiseta.png', 120, FALSE, NULL),
('Leggings Compresión', 'Ropa y Accesorios', 45.99, 'd_leggings.webp', 88, FALSE, NULL),
('Sudadera Térmica', 'Ropa y Accesorios', 59.90, 'd_sudadera.jpg', 45, FALSE, NULL),
('Gorra Deportiva UV', 'Ropa y Accesorios', 15.00, 'd_gorra.png', 200, FALSE, NULL);

-- -----------------------------------------------------------------------
-- Categoría 3: Hogar y Cocina
-- -----------------------------------------------------------------------
INSERT INTO product (title, category, price, image, stock, deleted, deleted_date) VALUES
('Set Utensilios Bambú (5 pizzas)', 'Hogar y Cocina', 30.25, 'h_utensilios.jpg', 55, FALSE, NULL),
('Lámpara de Escritorio LED', 'Hogar y Cocina', 49.99, 'h_lampara.png', 35, FALSE, NULL),
('Mesa Auxiliar Plegable', 'Hogar y Cocina', 75.00, 'h_mesa_aux.webp', 18, FALSE, NULL),
('Maceta Auto-riego Grande', 'Hogar y Cocina', 12.50, 'h_maceta.jpg', 90, FALSE, NULL),
('Robot Aspirador Inteligente', 'Hogar y Cocina', 250.00, 'h_robot_asp.png', 10, FALSE, NULL);

-- -----------------------------------------------------------------------
-- Categoría 4: Libros y Multimedia
-- -----------------------------------------------------------------------
INSERT INTO product (title, category, price, image, stock, deleted, deleted_date) VALUES
('El Código del Programador', 'Libros y Multimedia', 22.00, 'l_codigo.jpg', 70, FALSE, NULL),
('Ficción: El Último Viaje', 'Libros y Multimedia', 18.50, 'l_novela.png', 110, FALSE, NULL),
('Revista de Diseño Gráfico', 'Libros y Multimedia', 9.99, 'l_revista.webp', 40, FALSE, NULL),
('Aprende a Invertir (Ed. 2024)', 'Libros y Multimedia', 35.00, 'l_inversion.jpg', 65, FALSE, NULL),
('Libro de Recetas Veganas', 'Libros y Multimedia', 28.75, 'l_recetas.png', 80, FALSE, NULL);

-- -----------------------------------------------------------------------
-- Categoría 5: Alimentos Gourmet
-- -----------------------------------------------------------------------
INSERT INTO product (title, category, price, image, stock, deleted, deleted_date) VALUES
('Café Arábica de Origen (250g)', 'Alimentos Gourmet', 15.99, 'a_cafe.jpg', 95, FALSE, NULL),
('Aceite de Oliva Extra Virgen (500ml)', 'Alimentos Gourmet', 12.50, 'a_aceite.png', 150, FALSE, NULL),
('Chocolate Negro 85% Cacao', 'Alimentos Gourmet', 5.75, 'a_chocolate.webp', 200, FALSE, NULL),
('Miel Orgánica de Flores (1kg)', 'Alimentos Gourmet', 19.00, 'a_miel.jpg', 70, FALSE, NULL),
('Queso Curado de Oveja (200g)', 'Alimentos Gourmet', 25.00, 'a_queso.png', 30, FALSE, NULL);