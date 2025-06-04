# Create an insert script to populate my table with 10 test data rows. Use my table CREATE TABLE student ( id INT PRIMARY KEY, name VARCHAR(50) NOT NULL, email VARCHAR(100) UNIQUE, phone VARCHAR(20), major VARCHAR(50), gpa DECIMAL(3,2), graduation_date DATE ); 

Sure! Here's an `INSERT` script that populates your `student` table with **10 test data rows** using realistic values:

```sql
INSERT INTO student (id, name, email, phone, major, gpa, graduation_date) VALUES
(1, 'Alice Johnson', 'alice.johnson@example.com', '555-1234', 'Computer Science', 3.75, '2025-06-15'),
(2, 'Bob Smith', 'bob.smith@example.com', '555-2345', 'Mechanical Engineering', 3.42, '2024-12-20'),
(3, 'Catherine Lee', 'catherine.lee@example.com', '555-3456', 'Mathematics', 3.90, '2025-05-10'),
(4, 'David Kim', 'david.kim@example.com', '555-4567', 'Physics', 3.25, '2024-11-30'),
(5, 'Eva Brown', 'eva.brown@example.com', '555-5678', 'Biology', 3.58, '2025-04-28'),
(6, 'Frank Green', 'frank.green@example.com', '555-6789', 'Chemistry', 3.10, '2026-01-12'),
(7, 'Grace Liu', 'grace.liu@example.com', '555-7890', 'History', 3.85, '2024-09-01'),
(8, 'Henry Adams', 'henry.adams@example.com', '555-8901', 'Economics', 3.67, '2025-03-21'),
(9, 'Isabella Moore', 'isabella.moore@example.com', '555-9012', 'Psychology', 3.95, '2024-08-18'),
(10, 'Jack Wilson', 'jack.wilson@example.com', '555-0123', 'Art History', 2.95, '2025-07-30');
```

### Notes:

* `email` is unique for each row.
* `gpa` values fit within `DECIMAL(3,2)` (e.g., `3.75`).
* `graduation_date` uses `DATE` format (`YYYY-MM-DD`).

Let me know if you want this adapted for a specific SQL dialect (e.g., MySQL, PostgreSQL, SQL Server) or seeded with dynamic/random data.
