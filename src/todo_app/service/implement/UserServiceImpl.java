package todo_app.service.implement; // 11 구현 클래스 (Impl 클래스): 인터페이스에서 정의한 메소드의 실제 동작을 구현하는 클래스입니다.
// UserServiceImpl에서 userRepository의 메소드를 호출하여 반환된 값을 그대로 반환하는 이유는, UserRepository가 데이터 저장 및 조회를 담당하고, 
// UserServiceImpl이 그 결과를 받아서 클라이언트에게 전달하기 때문입니다.

import java.util.List;
import java.util.Optional;

import todo_app.entity.User;
import todo_app.repository.UserRepository;
import todo_app.service.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    // 생성자 주입 (UserRepository는 의존성 주입을 통해 전달됨)
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String username, String password) {
        // 새로운 User 객체 생성 및 저장
        User newUser = new User(username, password);
        return userRepository.save(newUser);  // UserRepository에 저장 후 반환
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);  // ID로 사용자 조회
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();  // 모든 사용자 조회
    }

    @Override
    public boolean deleteUserById(Long id) {
        return userRepository.deleteById(id);  // ID로 사용자 삭제
    }
}
