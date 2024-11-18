/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package math;

public class MathFunctions {
    // Tính chu vi hình chữ nhật

    public double tinhChuViHinhChuNhat(double dai, double rong) {
        if (dai <= 0 || rong <= 0) {
            throw new IllegalArgumentException("Chiều dài và chiều rộng phải lớn hơn 0.");
        }
        return 2 * (dai + rong);
    }

    
    // Kiểm tra ký tự nhập vào là nguyên âm hay phụ âm
    public boolean kiemTraNguyenAm(char character) {
        character = Character.toLowerCase(character);
        return character == 'a' || character == 'e' || 
                character == 'i' || character == 'o' || character == 'u';
    }


    // Giải phương trình bậc 2 ax^2 + bx + c = 0
    public String giaiPhuongTrinhBacHai(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Đây không phải là phương trình bậc hai.");
        }
        double delta = b * b - 4 * a * c;
        if (delta < 0) {
            return "Phương trình vô nghiệm";
        } else if (delta == 0) {
            double x = -b / (2 * a);
            return "Phương trình có nghiệm kép x = " + x;
        } else {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            return "Phương trình có hai nghiệm phân biệt: x1 = " + x1 + ", x2 = " + x2;
        }
    }
}
