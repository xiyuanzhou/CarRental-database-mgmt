CREATE TABLE Customer (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    customerName VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL
);

CREATE TABLE Car (
    CarID INTEGER PRIMARY KEY AUTO_INCREMENT,
    Make VARCHAR(100) NOT NULL,
    Model VARCHAR(100) NOT NULL,
    Years INT NOT NULL,
    Color VARCHAR(50) NOT NULL,
    NumberOfDoors INT NOT NULL,
    TransmissionType VARCHAR(20) NOT NULL,
    FuelType VARCHAR(20) NOT NULL,
    GpsCheck VARCHAR(50) NOT NULL
);


CREATE TABLE Employee (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    ename VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    roles VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);


CREATE TABLE RentalAgreement (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    RentalStart TEXT NOT NULL,
    RentalEnd TEXT NOT NULL,
    TotalCost DECIMAL(10, 2) NOT NULL,
    Status ENUM('Active', 'Completed', 'Canceled') NOT NULL,
    CarID INTEGER NOT NULL,
    CustomerID INTEGER NOT NULL,
    OperatorID INTEGER NOT NULL,
    AdditionalRequests TEXT,
    FOREIGN KEY (CarID) REFERENCES Car (CarID) ON DELETE CASCADE,
    FOREIGN KEY (CustomerID) REFERENCES Customer (ID) ON DELETE CASCADE,
    FOREIGN KEY (OperatorID) REFERENCES Employee (ID) ON DELETE CASCADE
);


CREATE TABLE Reservation (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    CustomerID INTEGER NOT NULL,
    PickupLocation VARCHAR(100) NOT NULL,
    ReturnLocation VARCHAR(100) NOT NULL,
    PickupDate VARCHAR(100) NOT NULL,
    ReturnDate VARCHAR(100) NOT NULL,
    CarTypePreference ENUM('Economy', 'Standard', 'Luxury') NOT NULL,
    AdditionalRequests TEXT,
    FOREIGN KEY (CustomerID) REFERENCES Customer (ID)
);

CREATE TABLE MaintenanceRecord (
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    CarID INTEGER NOT NULL,
    MaintenanceDate  VARCHAR(100) NOT NULL,
    MaintenanceType ENUM('Routine', 'Repair', 'Service') NOT NULL,
    MaintenanceDescription TEXT NOT NULL,
    MaintenanceCost DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (CarID) REFERENCES Car (CarID)
);

-- Dummy data
INSERT INTO Customer (customerName, address, phone, email)
VALUES
    ('John Doe', '123 Main St', '555-1234', 'john@example.com'),
    ('Jane Smith', '456 Elm St', '555-5678', 'jane@example.com'),
    ('Michael Johnson', '789 Oak St', '555-9876', 'michael@example.com'),
	('Mary Johnson', '789 Elm St', '555-4444', 'mary@example.com'),
    ('Robert Brown', '456 Oak St', '555-5555', 'robert@example.com'),
    ('Laura Davis', '123 Elm St', '555-6666', 'laura@example.com'),
    ('William Wilson', '789 Main St', '555-7777', 'william@example.com'),
    ('Jennifer Miller', '456 Oak St', '555-8888', 'jennifer@example.com'),
    ('David Smith', '123 Main St', '555-9999', 'david@example.com');

INSERT INTO Car (Make, Model, Years, Color, NumberOfDoors, TransmissionType, FuelType, GpsCheck)
VALUES
    ('Toyota', 'Corolla', 2022, 'Silver', 4, 'Automatic', 'Gasoline', 'Yes'),
    ('Honda', 'Civic', 2021, 'Blue', 4, 'Automatic', 'Gasoline', 'No'),
    ('Ford', 'Mustang', 2022, 'Red', 2, 'Manual', 'Gasoline', 'Yes'),
	('Ford', 'F-150', 2022, 'Black', 4, 'Automatic', 'Gasoline', 'Yes'),
    ('Chevrolet', 'Tahoe', 2021, 'White', 4, 'Automatic', 'Gasoline', 'Yes'),
    ('Toyota', 'Highlander', 2023, 'Silver', 4, 'Automatic', 'Hybrid', 'Yes'),
    ('Honda', 'Accord', 2022, 'Blue', 4, 'CVT', 'Gasoline', 'Yes'),
    ('Jeep', 'Wrangler', 2023, 'Green', 2, 'Manual', 'Gasoline', 'No');

INSERT INTO Employee (ename, address, phone, email, roles, salary)
VALUES
    ('Alice Johnson', '789 Oak St', '555-1111', 'alice@example.com', 'Manager', 60000),
    ('Bob Smith', '123 Main St', '555-2222', 'bob@example.com', 'Operator', 45000),
    ('Emily Davis', '456 Elm St', '555-3333', 'emily@example.com', 'Operator', 45000),
	('John Doe', '567 Pine St, Hamletville', '555-3456', 'john@example.com', 'Technician', 55000.00),
    ('Jane Wilson', '890 Maple St, Countryside', '555-6789', 'jane@example.com', 'Administrator', 50000.00),
	('Michael Brown', '234 Cedar St, Riverside', '555-2345', 'michael@example.com', 'Accountant', 52000.00),
    ('Sarah Adams', '789 Walnut St, Parkville', '555-8765', 'sarah@example.com', 'Marketing Specialist', 48000.00);

INSERT INTO RentalAgreement (RentalStart, RentalEnd, TotalCost, Status, CarID, CustomerID, OperatorID, AdditionalRequests)
VALUES
    ('2023-08-01', '2023-08-05', 250.00, 'Active', 1, 1, 2, 'None'),
    ('2023-08-02', '2023-08-08', 320.00, 'Active', 2, 2, 3, 'Child seat required'),
    ('2023-08-03', '2023-08-10', 450.00, 'Active', 3, 3, 2, 'GPS needed'),
	('2023-08-15', '2023-08-20', 320.00, 'Active', 2, 3, 1, 'None'),
    ('2023-08-17', '2023-08-23', 420.00, 'Active', 5, 2, 4, 'Child seat requested'),
    ('2023-08-19', '2023-08-25', 280.00, 'Active', 1, 1, 3, 'Long-distance trip'),
    ('2023-08-21', '2023-08-24', 200.00, 'Completed', 3, 4, 2, 'Early drop-off'),
    ('2023-08-22', '2023-08-30', 550.00, 'Active', 6, 5, 1, 'Additional driver added'),
    ('2023-08-25', '2023-09-01', 320.00, 'Canceled', 4, 6, 3, 'Change in travel plans');

INSERT INTO Reservation (CustomerID, PickupLocation, ReturnLocation, PickupDate, ReturnDate, CarTypePreference, AdditionalRequests)
VALUES
    (1, 'Airport', 'Airport', '2023-09-01', '2023-09-05', 'Economy', 'None'),
    (2, 'Downtown', 'Downtown', '2023-09-03', '2023-09-10', 'Standard', 'None'),
    (3, 'Suburb', 'Suburb', '2023-09-05', '2023-09-08', 'Luxury', 'Chauffeur service'),
	(4, 'Airport', 'Downtown', '2023-08-18', '2023-08-23', 'Standard', 'Child seat needed'),
    (5, 'Hotel', 'Beach', '2023-08-20', '2023-08-27', 'Luxury', 'Convertible preferred'),
    (6, 'Train Station', 'City Center', '2023-08-22', '2023-08-25', 'Economy', 'GPS required'),
    (7, 'Mall', 'Resort', '2023-08-25', '2023-08-30', 'Standard', 'Ski rack needed');


INSERT INTO MaintenanceRecord (CarID, MaintenanceDate, MaintenanceType, MaintenanceDescription, MaintenanceCost)
VALUES
    (1, '2023-07-15', 'Routine', 'Oil change and inspection', 50.00),
    (2, '2023-07-20', 'Repair', 'Replace brake pads', 120.00),
    (3, '2023-07-25', 'Service', 'Full engine service', 200.00),
    (4, '2023-08-22', 'Routine', 'Tire rotation and balance', 35.00),
    (5, '2023-08-25', 'Repair', 'Replacing a broken side mirror', 150.00);




