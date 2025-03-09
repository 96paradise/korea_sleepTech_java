package todo_app.service; // 10 인터페이스 (Service 인터페이스): 기능을 정의하는 역할입니다.
// UserService는 기능을 선언만 해두고, 그 기능을 어떻게 수행할지는 UserServiceImpl에서 실제 코드로 작성하는 형태가 됩니다.

import java.util.List;

import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.UserResponseDto;


public interface UserService {
    void registerUser(UserSignUpRequestDto dto);
    List<UserResponseDto> listAllUsers();
    UserResponseDto getUserById(Long id);
    void updateUser(Long id, UserSignUpRequestDto dto);
    void deleteUser(Long id);
}
