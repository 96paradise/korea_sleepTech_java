package todo_app.Controller; // 14

import todo_app.dto.request.UserSignInRequestDto;  // UserSignInRequestDto
import todo_app.dto.request.UserSignUpRequestDto;  // UserSignUpRequestDto
import todo_app.dto.response.UserResponseDto;  // UserResponseDto
import todo_app.entity.User;  // Entity 패키지
import todo_app.repository.UserRepository;  // Repository 패키지

import java.util.List;
import java.util.Optional;

public class UserController {

    private UserRepository userRepository;

    // 생성자에서 UserRepository 인스턴스를 주입받음
    public UserController() {
        this.userRepository = UserRepository.getInstance();  // Singleton 패턴으로 UserRepository 인스턴스 가져오기
    }

    // 사용자 등록 (회원가입)
    public void registerUser(UserSignUpRequestDto dto) {
        User newUser = new User(dto.getId(), dto.getUsername(), dto.getPassword(), dto.getEmail());
        userRepository.save(newUser);
    }

    // 사용자 로그인 (사용자 인증)
    public boolean signInUser(UserSignInRequestDto dto) {
        Optional<User> user = userRepository.findByUsername(dto.getUsername());
        return user.isPresent() && user.get().getPassword().equals(dto.getPassword());
    }

    // 모든 사용자 조회
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        // 사용자 리스트를 UserResponseDto로 변환해서 반환
        return users.stream()
                .map(user -> new UserResponseDto(user.getId(), user.getUsername(), user.getEmail()))
                .toList();
    }

    // ID로 사용자 조회
    public UserResponseDto getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(u -> new UserResponseDto(u.getId(), u.getUsername(), u.getEmail()))
                .orElse(null);  // 사용자가 없으면 null 반환
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(userRepository::delete);  // 사용자가 존재하면 삭제
    }

    // 사용자 정보 업데이트
    public void updateUser(Long id, UserSignUpRequestDto dto) {
        Optional<User> userOpt = userRepository.findById(id);
        userOpt.ifPresent(user -> {
            user.setUsername(dto.getUsername());
            user.setPassword(dto.getPassword());
            user.setEmail(dto.getEmail());
        });
    }
}
