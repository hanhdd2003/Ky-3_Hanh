package loginservice;

import java.util.HashMap;
import java.util.Map;

public class LoginService {

    private final Map<String, String> userCredentials;

    public LoginService() {
        userCredentials = new HashMap<>();
        userCredentials.put("user1", "password1");
        userCredentials.put("user2", "password2");
    }

    public boolean authenticate(String username, String password) {
        String storedPassword = userCredentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
}
//