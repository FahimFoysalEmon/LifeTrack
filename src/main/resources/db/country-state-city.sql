--
-- Data for Bangladesh
--

-- 1. Insert the Country
INSERT INTO country_list (id, country_name, country_code, flag_icon, currency)
VALUES
    (19, 'Bangladesh', 'BD', NULL, 'BDT');

-- 2. Insert the States (Divisions of Bangladesh)
-- Note: country_list_id is 19, which corresponds to Bangladesh.
INSERT INTO state_list (id, state_name, country_list_id, created_at)
VALUES
    (50, 'Dhaka', 19, '2023-10-27 10:00:00'),
    (51, 'Chittagong', 19, '2023-10-27 10:00:00'),
    (52, 'Khulna', 19, '2023-10-27 10:00:00'),
    (53, 'Rajshahi', 19, '2023-10-27 10:00:00'),
    (54, 'Barisal', 19, '2023-10-27 10:00:00'),
    (55, 'Sylhet', 19, '2023-10-27 10:00:00'),
    (56, 'Rangpur', 19, '2023-10-27 10:00:00'),
    (57, 'Mymensingh', 19, '2023-10-27 10:00:00');

-- 3. Insert the Cities
-- Note: state_list_id corresponds to the IDs of the divisions above.
INSERT INTO city_list (id, prefix, city_name, state_list_id, created_at)
VALUES
    -- Dhaka Division Cities (ID: 50)
    (100, 'DHA', 'Dhaka', 50, '2023-10-27 10:05:00'),
    (101, 'GAZ', 'Gazipur', 50, '2023-10-27 10:05:00'),
    (102, 'NAR', 'Narayanganj', 50, '2023-10-27 10:05:00'),
    (103, 'TAN', 'Tangail', 50, '2023-10-27 10:05:00'),
    (104, 'FAR', 'Faridpur', 50, '2023-10-27 10:05:00'),

    -- Chittagong Division Cities (ID: 51)
    (105, 'CTG', 'Chittagong', 51, '2023-10-27 10:05:00'),
    (106, 'COM', 'Comilla', 51, '2023-10-27 10:05:00'),
    (107, 'COX', 'Cox''s Bazar', 51, '2023-10-27 10:05:00'),
    (108, 'FEN', 'Feni', 51, '2023-10-27 10:05:00'),
    (109, 'BRA', 'Brahmanbaria', 51, '2023-10-27 10:05:00'),

    -- Khulna Division Cities (ID: 52)
    (110, 'KHU', 'Khulna', 52, '2023-10-27 10:05:00'),
    (111, 'JES', 'Jessore', 52, '2023-10-27 10:05:00'),
    (112, 'KUS', 'Kushtia', 52, '2023-10-27 10:05:00'),
    (113, 'SAT', 'Satkhira', 52, '2023-10-27 10:05:00'),

    -- Rajshahi Division Cities (ID: 53)
    (114, 'RAJ', 'Rajshahi', 53, '2023-10-27 10:05:00'),
    (115, 'BOG', 'Bogra', 53, '2023-10-27 10:05:00'),
    (116, 'PAB', 'Pabna', 53, '2023-10-27 10:05:00'),
    (117, 'SIR', 'Sirajganj', 53, '2023-10-27 10:05:00'),

    -- Barisal Division Cities (ID: 54)
    (118, 'BAR', 'Barisal', 54, '2023-10-27 10:05:00'),
    (119, 'PAT', 'Patuakhali', 54, '2023-10-27 10:05:00'),
    (120, 'BHO', 'Bhola', 54, '2023-10-27 10:05:00'),

    -- Sylhet Division Cities (ID: 55)
    (121, 'SYL', 'Sylhet', 55, '2023-10-27 10:05:00'),
    (122, 'SUN', 'Sunamganj', 55, '2023-10-27 10:05:00'),
    (123, 'MOU', 'Moulvibazar', 55, '2023-10-27 10:05:00'),

    -- Rangpur Division Cities (ID: 56)
    (124, 'RAN', 'Rangpur', 56, '2023-10-27 10:05:00'),
    (125, 'DIN', 'Dinajpur', 56, '2023-10-27 10:05:00'),
    (126, 'GAI', 'Gaibandha', 56, '2023-10-27 10:05:00'),

    -- Mymensingh Division Cities (ID: 57)
    (127, 'MYM', 'Mymensingh', 57, '2023-10-27 10:05:00'),
    (128, 'JAM', 'Jamalpur', 57, '2023-10-27 10:05:00'),
    (129, 'SHE', 'Sherpur', 57, '2023-10-27 10:05:00');