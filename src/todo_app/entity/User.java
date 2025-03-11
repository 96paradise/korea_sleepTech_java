package todo_app.entity; // 1. 사용자 객체

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String password;
    private String username;
    private String phone;
    private String email;
    private String gender;
}
