package validate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.*;

public class Validate {

    public boolean checkPhone(String phone) {
        String regex = "\\b0\\d{9}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    public boolean checkUsername(String username) {
        String regex = "^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$";
        return username.matches(regex);
    }

    public boolean checkEmail(String email) {
        String regex = "^[a-z][a-z0-9_\\.]"
                + "{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean checkPassword(String password) {
        String regex1 = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@.$!%*?&])[A-Za-z\\d@$!.%*?&]{8,}$";
        String regex2 = "^\\d{8,}$";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(password);

        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(password);
        boolean isRegex1 = matcher1.matches();
        boolean isRegex2 = matcher2.matches();
        return isRegex1 || isRegex2;
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
