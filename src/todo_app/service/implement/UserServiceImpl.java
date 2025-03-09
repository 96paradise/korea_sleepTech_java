package todo_app.service.implement; // 11 구현 클래스 (Impl 클래스): 인터페이스에서 정의한 메소드의 실제 동작을 구현하는 클래스입니다.
// UserServiceImpl에서 userRepository의 메소드를 호출하여 반환된 값을 그대로 반환하는 이유는, UserRepository가 데이터 저장 및 조회를 담당하고, 
// UserServiceImpl이 그 결과를 받아서 클라이언트에게 전달하기 때문입니다.

import java.util.List;
import java.util.stream.Collectors;

import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.UserResponseDto;
import todo_app.entity.User;
import todo_app.repository.UserRepository;
import todo_app.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private static long currentId = 1;

    public UserServiceImpl() {
        this.repository = UserRepository.getInstance();
    }

    private Long generateId() {
        return currentId++;
    }

    @Override
    public void registerUser(UserSignUpRequestDto dto) {
        User user = new User(
        		generateId(), dto.getPassword(), dto.getUsername(), dto.getPhone(), dto.getEmail(), dto.getGender()
        );
        
        repository.save(user);
    }

    @Override
    public List<UserResponseDto> listAllUsers() {
    	List<User> users = repository.findAll();    	
        
    	List<UserResponseDto> responseDtos = users.stream()
                .map(user -> new UserResponseDto(user.getId(), user.getUsername()))
                .collect(Collectors.toList());
    	
    	return responseDtos;
    }

    @Override
    public UserResponseDto getUserById(Long id) {
    	UserResponseDto responseDto = null;
    	
    	try {
    		User user = repository.findById(id)
    				.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 사용자를 조회할 수 없습니다." + id));
    		responseDto = new UserResponseDto(user.getId(), user.getUsername());
    	} catch (Exception e) {
    		System.out.println(e.getMessage());
    	}
    	return responseDto;
    }

    @Override
    public void updateUser(Long id, UserSignUpRequestDto dto) {
        try {
        	User user = repository.findById(id)
        			.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 사용자를 조회할 수 없습니다." + id));
        	
        	user.setUsername(dto.getUsername());
        	user.setPassword(dto.getPassword());
        	user.setPhone(dto.getPhone());
        	user.setEmail(dto.getEmail());
        	user.setGender(dto.getGender());
        }catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
        	User user = repository.findById(id)
        			.orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 사용자를 조회할 수 없습니다." + id));
        	repository.delete(user);
        }catch (Exception e) {
        	System.out.println(e.getMessage());
        }
    }
}