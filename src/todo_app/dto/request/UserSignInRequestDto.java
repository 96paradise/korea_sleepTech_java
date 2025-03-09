package todo_app.dto.request; // 4. 로그인 요청 데이터

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSignInRequestDto {
	private Long id;        
    private String password; 
}