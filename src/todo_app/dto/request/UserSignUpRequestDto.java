package todo_app.dto.request; // 3. 회원가입 요청 데이터

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignUpRequestDto {
    private String username;
    private String password;
    private String phone;
    private String email;
    private char gender;
}

