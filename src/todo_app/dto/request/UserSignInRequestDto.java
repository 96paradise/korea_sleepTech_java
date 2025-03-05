package todo_app.dto.request; // 4. 로그인 요청 데이터

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSignInRequestDto {
    private String username;
    private String password;
    // username과 password만 있으면 기본적인 회원가입이 가능함
    // 보통 ID(고유번호 id)는 서버에서 자동 생성되므로 클라이언트에서 입력할 필요 없음
    // 추가 정보(이메일, 전화번호 등)는 추후 확장 가능
}