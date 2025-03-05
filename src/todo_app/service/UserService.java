package todo_app.service; // 10 인터페이스 (Service 인터페이스): 기능을 정의하는 역할입니다.
// UserService는 기능을 선언만 해두고, 그 기능을 어떻게 수행할지는 UserServiceImpl에서 실제 코드로 작성하는 형태가 됩니다.

import java.util.List;
import java.util.Optional;

import todo_app.entity.User;

public interface UserService {
    User createUser(String username, String password);  // 사용자 생성
    Optional<User> findUserById(Long id);  // ID로 사용자 조회
    List<User> findAllUsers();  // 모든 사용자 조회
    boolean deleteUserById(Long id);  // ID로 사용자 삭제
}
