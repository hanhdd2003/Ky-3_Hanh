-- ctrl + shift + Q ::join bảng nhanh
-- List of SQL Commands
-- 1: SELECT
-- Ví dụ: SELECT name FROM customers;
-- Giải thích: SELECT dùng để truy vấn dữ liệu từ cơ sở dữ liệu.

-- 2: SELECT *
-- Ví dụ: SELECT * FROM customers;
-- Giải thích: SELECT * trả về tất cả các cột trong bảng được truy vấn.

-- 3: SELECT DISTINCT
-- Ví dụ: SELECT DISTINCT name FROM customers;
-- Giải thích: SELECT DISTINCT chỉ trả về các dòng có dữ liệu khác nhau.

-- 4: SELECT INTO
-- Ví dụ: SELECT * INTO customers FROM customers_backup;
-- Giải thích: SELECT INTO sao chép dữ liệu từ một bảng vào một bảng khác.

-- 5: SELECT TOP
-- Ví dụ: SELECT TOP 50 * FROM customers;
-- SELECT TOP 50 PERCENT * FROM customers;
-- Giải thích: SELECT TOP trả về số lượng hàng hàng đầu hoặc theo phần trăm từ bảng.

-- 6: AS
-- Ví dụ: SELECT name AS first_name FROM customers;
-- Giải thích: AS đặt tên bảng hoặc cột với một bí danh mà chúng ta có thể chọn.

-- 7: FROM
-- Ví dụ: SELECT name FROM customers;
-- Giải thích: FROM chỉ định bảng chúng ta lấy dữ liệu từ.

-- 8: WHERE
-- Ví dụ: SELECT name FROM customers WHERE name = 'Bob';
-- Giải thích: WHERE lọc kết quả của truy vấn để chỉ trả về kết quả khớp với điều kiện cụ thể.

-- 9: AND
-- Ví dụ: SELECT name FROM customers WHERE name = 'Bob' AND age = 55;
-- Giải thích: AND kết hợp hai hoặc nhiều điều kiện trong một truy vấn.

-- 10: OR
-- Ví dụ: SELECT name FROM customers WHERE name = 'Bob' OR age = 55;
-- Giải thích: OR kết hợp hai hoặc nhiều điều kiện trong một truy vấn.

-- 11: BETWEEN
-- Ví dụ: SELECT name FROM customers WHERE age BETWEEN 45 AND 55;
-- Giải thích: BETWEEN lọc kết quả để chỉ trả về kết quả nằm trong một phạm vi cụ thể.

-- 12: LIKE
-- Ví dụ: SELECT name FROM customers WHERE name LIKE '%Bob%';
-- Giải thích: LIKE tìm kiếm một mẫu cụ thể trong một cột.
--%x - sẽ chọn tất cả các giá trị bắt đầu bằng x.
--%x% - sẽ chọn tất cả các giá trị có x xuất hiện trong đó.
--x% - sẽ chọn tất cả các giá trị kết thúc bằng x.
--x%y - sẽ chọn tất cả các giá trị bắt đầu bằng x và kết thúc bằng y.
--_x% - sẽ chọn tất cả các giá trị có x là ký tự thứ hai.
--x_% - sẽ chọn tất cả các giá trị bắt đầu bằng x và có ít nhất hai ký tự. Bạn có thể thêm các ký tự _ bổ sung để mở rộng yêu cầu về độ dài, ví dụ, x___% để yêu cầu ít nhất bốn ký tự.

-- 13: IN
-- Ví dụ: SELECT name FROM customers WHERE name IN ('Bob', 'Fred', 'Harry');
-- Giải thích: IN cho phép chúng ta chỉ định nhiều giá trị để truy vấn.

-- 14: IS NULL
-- Ví dụ: SELECT name FROM customers WHERE name IS NULL;
-- Giải thích: IS NULL chỉ trả về các hàng có giá trị NULL.

-- 15: IS NOT NULL
-- Ví dụ: SELECT name FROM customers WHERE name IS NOT NULL;
-- Giải thích: IS NOT NULL ngược lại, chỉ trả về các hàng không có giá trị NULL.

-- 16: CREATE DATABASE
-- Ví dụ: CREATE DATABASE dataquestDB;
-- Giải thích: CREATE DATABASE tạo một cơ sở dữ liệu mới.

-- 17: CREATE TABLE
-- Ví dụ: CREATE TABLE customers (
--     customer_id int,
--     name varchar(255),
--     age int
-- );
-- Giải thích: CREATE TABLE tạo một bảng mới trong cơ sở dữ liệu.


-- 18: CREATE INDEX
-- Ví dụ: CREATE INDEX idx_name ON customers (name);
-- Giải thích: CREATE INDEX tạo một chỉ mục cho một bảng để truy xuất dữ liệu nhanh hơn.

-- 19: CREATE VIEW
-- Ví dụ: CREATE VIEW [Bob Customers] AS
-- SELECT name, age
-- FROM customers
-- WHERE name = 'Bob';
-- Giải thích: CREATE VIEW tạo một bảng ảo dựa trên kết quả của một câu lệnh SQL.

-- 20: DROP DATABASE
-- Ví dụ: DROP DATABASE dataquestDB;
-- Giải thích: DROP DATABASE xóa toàn bộ cơ sở dữ liệu và dữ liệu bên trong.

-- 21: DROP TABLE
-- Ví dụ: DROP TABLE customers;
-- Giải thích: DROP TABLE xóa bảng cùng với dữ liệu bên trong.

-- 22: DROP INDEX
-- Ví dụ: DROP INDEX idx_name;
-- Giải thích: DROP INDEX xóa một chỉ mục từ cơ sở dữ liệu.

-- 23: UPDATE
-- Ví dụ: UPDATE customers SET age = 56 WHERE name = 'Bob';
-- Giải thích: UPDATE cập nhật dữ liệu trong một bảng.

-- 24: DELETE
-- Ví dụ: DELETE FROM customers WHERE name = 'Bob';
-- Giải thích: DELETE xóa hàng từ bảng dựa trên điều kiện.

-- 25: ALTER TABLE
-- Ví dụ: ALTER TABLE customers ADD surname varchar(255);
-- Giải thích: ALTER TABLE thay đổi cấu trúc của một bảng, bao gồm việc thêm hoặc loại bỏ cột.

-- 26: COUNT
-- Ví dụ: SELECT COUNT(*) FROM customers;
-- Giải thích: COUNT trả về số hàng khớp với điều kiện.

-- 27: SUM
-- Ví dụ: SELECT SUM(age) FROM customers;
-- Giải thích: SUM trả về tổng giá trị của một cột số học.

-- 28: AVG
-- Ví dụ: SELECT AVG(age) FROM customers;
-- Giải thích: AVG trả về giá trị trung bình của một cột số học.

-- 29: MIN
-- Ví dụ: SELECT MIN(age) FROM customers;
-- Giải thích: MIN trả về giá trị nhỏ nhất của một cột số học.

-- 30: MAX
-- Ví dụ: SELECT MAX(age) FROM customers;
-- Giải thích: MAX trả về giá trị lớn nhất của một cột số học.

-- 31: GROUP BY
-- Ví dụ: SELECT name, AVG(age) FROM customers GROUP BY name;
-- Giải thích: GROUP BY nhóm các hàng dựa trên giá trị của một cột và thực hiện các hàm tổng hợp trên từng nhóm.

-- 32: HAVING
-- Ví dụ: SELECT COUNT(customer_id), name FROM customers GROUP BY name HAVING COUNT(customer_id) > 2;
-- Giải thích: HAVING là một phần của GROUP BY và lọc kết quả dựa trên các hàm tổng hợp.

-- 33: ORDER BY
-- Ví dụ: SELECT name FROM customers ORDER BY age;
-- Giải thích: ORDER BY sắp xếp kết quả truy vấn theo cột cụ thể.

-- 34: DESC
-- Ví dụ: SELECT name FROM customers ORDER BY age DESC;
-- Giải thích: DESC sắp xếp kết quả theo thứ tự giảm dần.

-- 35: OFFSET
-- Ví dụ: SELECT name FROM customers ORDER BY age OFFSET 10 ROWS;
-- Giải thích: OFFSET cho phép bỏ qua một số hàng trước khi trả kết quả.

-- 36: FETCH
-- Ví dụ: SELECT name FROM customers ORDER BY age OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;
-- Giải thích: FETCH chỉ định số hàng cần trả sau khi đã bỏ qua hàng.

-- 37: INNER JOIN
-- Ví dụ: SELECT name FROM customers INNER JOIN orders ON customers.customer_id = orders.customer_id;
-- Giải thích: INNER JOIN kết hợp các hàng có giá trị phù hợp trong hai bảng.

-- 38: LEFT JOIN
-- Ví dụ: SELECT name FROM customers LEFT JOIN orders ON customers.customer_id = orders.customer_id;
-- Giải thích: LEFT JOIN kết hợp các hàng từ bảng bên trái với bảng bên phải.

-- 39: RIGHT JOIN
-- Ví dụ: SELECT name FROM customers RIGHT JOIN orders ON customers.customer_id = orders.customer_id;
-- Giải thích: RIGHT JOIN kết hợp các hàng từ bảng bên phải với bảng bên trái.

-- 40: FULL JOIN
-- Ví dụ: SELECT name FROM customers FULL OUTER JOIN orders ON customers.customer_id = orders.customer_id;
-- Giải thích: FULL JOIN kết hợp các hàng có giá trị phù hợp trong cả hai bảng.

-- 41: EXISTS
-- Ví dụ: SELECT name FROM customers WHERE EXISTS (SELECT order FROM ORDERS WHERE customer_id = 1);
-- Giải thích: EXISTS kiểm tra sự tồn tại của bất kỳ hàng nào trong một câu lệnh con.

-- 42: GRANT
-- Ví dụ: GRANT SELECT, UPDATE ON customers TO usr_bob;
-- Giải thích: GRANT cấp quyền truy cập cho một người dùng vào các đối tượng trong cơ sở dữ liệu.

-- 43: REVOKE
-- Ví dụ: REVOKE SELECT, UPDATE ON customers FROM usr_bob;
-- Giải thích: REVOKE loại bỏ quyền truy cập của một người dùng vào các đối tượng trong cơ sở dữ liệu.

-- 44: SAVEPOINT
-- Ví dụ: SAVEPOINT SAVEPOINT_NAME;
-- Giải thích: SAVEPOINT cho phép bạn xác định một điểm trong giao dịch mà bạn có thể quay trở lại sau này.

-- 45: COMMIT
-- Ví dụ: DELETE FROM customers WHERE name = 'Bob'; COMMIT;
-- Giải thích: COMMIT để lưu tất cả các giao dịch vào cơ sở dữ liệu.

-- 46: ROLLBACK
-- Ví dụ: ROLLBACK TO SAVEPOINT_NAME;
-- Giải thích: ROLLBACK để hoàn tác các giao dịch chưa được lưu vào cơ sở dữ liệu.

-- 47: TRUNCATE TABLE
-- Ví dụ: TRUNCATE TABLE customers;
-- Giải thích: TRUNCATE TABLE xóa tất cả dữ liệu từ bảng, nhưng giữ lại cấu trúc của bảng.

-- 48: UNION
-- Ví dụ: SELECT name FROM customers UNION SELECT name FROM orders;
-- Giải thích: UNION kết hợp nhiều kết quả từ hai hoặc nhiều câu lệnh SELECT và loại bỏ các dòng trùng lặp.

-- 49: UNION ALL
-- Ví dụ: SELECT name FROM customers UNION SELECT name FROM orders;
-- Giải thích: UNION ALL kết hợp nhiều kết quả từ hai hoặc nhiều câu lệnh SELECT và giữ lại các dòng trùng lặp.

-- 50: CONCAT
-- Ví dụ: SELECT CONCAT(first name, ' ', last name) AS full name FROM student;

-- 51: -- Đóng database
--USE master;
--ALTER DATABASE TenDatabase SET OFFLINE;
-- giải thích: đóng database 


--52: -- Mở lại database
--USE master;
--ALTER DATABASE TenDatabase SET ONLINE;

--53: phím tắt:
--Ctrl + R: Hiện hoặc ẩn cửa sổ dạng kết quả (Results Pane)
--Ctrl + Tab: Chuyển giữa các cửa sổ truy vấn đã mở.
--Ctrl + Shift + U: Chuyển một phần văn bản hoặc cả truy vấn đến chữ hoa (uppercase).
--Ctrl + Shift + L: Chuyển một phần văn bản hoặc cả truy vấn đến chữ thường (lowercase).
--Ctrl + Shift + C: Bôi đen comment trên một dòng.
--Ctrl + K, Ctrl + C: Comment một phần văn bản đã bôi đen.
--CTRL + K, CTRL + U: BỎ COMMENT (UNCOMMENT) PHẦN VĂN BẢN ĐÃ BÔI ĐEN.
--CTRL + K, CTRL + X: create table 


--Collapse All: Ctrl + M, Ctrl + O

--Thu gọn tất cả các khối code.
--Expand All: Ctrl + M, Ctrl + X

--Mở rộng tất cả các khối code.
--Collapse Current Region: Ctrl + M, Ctrl + C

--Thu gọn phần code hiện tại.
--Expand Current Region: Ctrl + M, Ctrl + E

--Mở rộng phần code hiện tại.
--Collapse Selection: Ctrl + M, Ctrl + H

--Thu gọn lựa chọn của bạn.
--Expand Selection: Ctrl + M, Ctrl + J

--Mở rộng lựa chọn của bạn.

--UPDATE table_name
--SET column1 = value1, column2 = value2, ...
--WHERE condition;
-- vi du :  UPDATE Employees
	      --SET Salary = Salary + 500
		  --WHERE EmployeeID = 12345;
--IF (condition)
--BEGIN
--    -- Các lệnh T-SQL khi điều kiện đúng
--END
--ELSE
--BEGIN
--    -- Các lệnh T-SQL khi điều kiện sai
--END
-- vi du: IF (EXISTS(SELECT 1 FROM dbo.MyTable))
        --BEGIN
        --    PRINT 'Bảng đã có dữ liệu.'
        --    -- Thêm các lệnh khác nếu cần
		--END
		--ELSE
		--BEGIN
		--    PRINT 'Bảng chưa có dữ liệu.'
		--    -- Thêm các lệnh khác, có thể là INSERT để thêm dữ liệu
		--END

-- 54: DATALENGTH : Xem 1 phần tử chiếm bao nhiêu trong bộ nhớ




