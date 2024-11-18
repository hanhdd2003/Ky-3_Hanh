-- Kiểu dữ liệu chuỗi
CREATE TABLE StringTypes (
    char_type CHAR(255),                  -- Độ dài cố định, tối đa 255 ký tự
    varchar_type VARCHAR(65535),          -- Độ dài biến đổi, tối đa 65535 ký tự
    binary_type BINARY(255),              -- Tương tự CHAR nhưng lưu trữ byte, độ dài cố định, tối đa 255 byte
    varbinary_type VARBINARY(65535),      -- Tương tự VARCHAR nhưng lưu trữ byte, độ dài biến đổi, tối đa 65535 byte
    tinyblob_type TINYBLOB,                -- Đối với BLOBs, độ dài tối đa: 255 byte
    tinytext_type TINYTEXT,                -- Độ dài tối đa: 255 ký tự
    text_type TEXT(65535),                 -- Độ dài tối đa: 65535 byte
    blob_type BLOB(65535),                 -- Đối với BLOBs, độ lưu trữ tối đa: 65535 byte
    mediumtext_type MEDIUMTEXT,            -- Độ dài tối đa: 16777215 ký tự
    mediumblob_type MEDIUMBLOB,            -- Đối với BLOBs, độ lưu trữ tối đa: 16777215 byte
    longtext_type LONGTEXT,                -- Độ dài tối đa: 4294967295 ký tự
    longblob_type LONGBLOB,                -- Đối với BLOBs, độ lưu trữ tối đa: 4294967295 byte
    enum_type ENUM('val1', 'val2', 'val3'), -- Enum với giá trị được chọn từ danh sách
    set_type SET('val1', 'val2', 'val3')    -- Set với các giá trị được chọn từ danh sách
);

-- Kiểu dữ liệu số
CREATE TABLE NumberTypes (
    bit_type BIT(1),              -- Giá trị bit
    tinyint_type TINYINT,         -- Số nguyên nhỏ
    bool_type BOOL,               -- Giá trị boolean (0 hoặc 1)
    smallint_type SMALLINT,       -- Số nguyên nhỏ
    mediumint_type MEDIUMINT,     -- Số nguyên trung bình
    int_type INT,                 -- Số nguyên trung bình
    integer_type INTEGER,         -- Tương tự INT
    bigint_type BIGINT,           -- Số nguyên lớn
    float_type FLOAT,             -- Số thập phân không cố định
    double_type DOUBLE,           -- Số thập phân không cố định
    decimal_type DECIMAL(10, 2),  -- Số thập phân chính xác
    numeric_type NUMERIC(10, 2)   -- Số thập phân chính xác
);

-- Kiểu dữ liệu ngày/giờ
CREATE TABLE DateTimeTypes (
    date_type DATE,                  -- Định dạng ngày: 'YYYY-MM-DD'
    datetime_type DATETIME,          -- Định dạng ngày và giờ: 'YYYY-MM-DD hh:mm:ss'
    timestamp_type TIMESTAMP,        -- Định dạng dấu thời gian
    time_type TIME,                  -- Định dạng thời gian: 'hh:mm:ss'
    year_type YEAR                   -- Định dạng năm: bốn chữ số
);

-- Các kiểu dữ liệu khác
CREATE TABLE OtherTypes (
    sql_variant_type sql_variant,       -- Lưu trữ nhiều loại dữ liệu
    uniqueidentifier_type uniqueidentifier, -- Số nhận dạng duy nhất (GUID)
    xml_type xml,                      -- Dữ liệu có định dạng XML
    cursor_type CURSOR,                -- Tham chiếu đến con trỏ
    table_type TABLE,                  -- Lưu trữ tập hợp kết quả
);

Declare @datetime datetime = getdate()
select @datetime

Declare @ngay datetimeoffset  = sysdatetimeoffset()
select @ngay

thêm thông tin múi giờ : datetimeoffset 

DECLARE @dto DATETIMEOFFSET = SYSDATETIMEOFFSET(); 
SET @dto = (SELECT GETUTCDATE() AT TIME ZONE 'Korea Standard Time')
SELECT @dto

DECLARE @utcTime DATETIMEOFFSET = GETUTCDATE();
SELECT @utcTime AT TIME ZONE 'UTC' AT TIME ZONE 'SE Asia Standard Time' AS LocalTime;

-- lấy thông tin các múi giờ
SELECT * FROM sys.time_zone_info;

