package todo_app.dto.response; // 6. 회원가입, 로그인 시 반환

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private Long id; // 사용자를 고유하게 식별하기 위해 필요
    private String username; // 사용자의 닉네임 또는 아이디를 반환하기 위해 필요
    // UserResponseDto는 회원가입 또는 로그인 후 클라이언트에게 반환할 데이터를 정의하는 DTO
    // 필요한 최소한의 정보만 포함하기 위해 id와 username만 사용
}