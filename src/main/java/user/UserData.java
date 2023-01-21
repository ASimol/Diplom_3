package user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {

    private String email;
    private String password;

    public UserData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static UserData from(User user) {
        return new UserData(user.getEmail(), user.getPassword());
    }
}
