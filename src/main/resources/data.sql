INSERT INTO categories (category_name) VALUES
                                           ('Fiction'),
                                           ('Non-fiction'),
                                           ('Science Fiction'),
                                           ('Fantasy'),
                                           ('Biography'),
                                           ('Historical Fiction'),
                                           ('Mystery'),
                                           ('Thriller');

INSERT INTO products (
    product_name, publisher_name, author_name, translator_name, purchase_price,
    unit_price, discount_price, selling_price, description,
    thumbnail_image_data, product_image_data, product_status, category_id
) VALUES
      ('Product 1', 'Publisher 1', 'Author 1', 'Translator 1', 10000, 15000, 2000, 13000,
       'This is the description for Product 1.', 'thumbnail_data_1', 'image_data_1', 'ACTIVE', 1),

      ('Product 2', 'Publisher 2', 'Author 2', 'Translator 2', 15000, 20000, 3000, 17000,
       'This is the description for Product 2.', 'thumbnail_data_2', 'image_data_2', 'INACTIVE', 2),

      ('Product 3', 'Publisher 3', 'Author 3', 'Translator 3', 12000, 18000, 2500, 15500,
       'This is the description for Product 3.', 'thumbnail_data_3', 'image_data_3', 'ACTIVE', 3),

      ('Product 4', 'Publisher 4', 'Author 4', 'Translator 4', 11000, 16000, 1500, 14500,
       'This is the description for Product 4.', 'thumbnail_data_4', 'image_data_4', 'INACTIVE', 4),

      ('Product 5', 'Publisher 5', 'Author 5', 'Translator 5', 9000, 14000, 1000, 13000,
       'This is the description for Product 5.', 'thumbnail_data_5', 'image_data_5', 'ACTIVE', 5);

