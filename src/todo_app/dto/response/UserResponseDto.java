package todo_app.dto.response; // 6. 회원가입, 로그인 시 반환

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String username;
}