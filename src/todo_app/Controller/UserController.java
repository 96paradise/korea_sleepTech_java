package todo_app.Controller; // 14

import java.util.List;

import todo_app.dto.request.UserSignInRequestDto;
import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.UserResponseDto;
import todo_app.entity.User;
import todo_app.service.UserService;
import todo_app.service.implement.UserServiceImpl;

public class UserController {
    private final UserService service;

    public UserController() {
        this.service = new UserServiceImpl();
    }

    public void registerUser(UserSignUpRequestDto dto) {
        service.registerUser(dto);
    }

    public List<UserResponseDto> getAllUsers() {
        return service.listAllUsers();
    }

    public UserResponseDto getUserById(long id) {
        return service.getUserById(id);
    }

    public void updateUser(long id, UserSignUpRequestDto dto) {
        service.updateUser(id, dto);
    }

    public void deleteUser(long id) {
        service.deleteUser(id);
    }

    public UserResponseDto signIn(UserSignInRequestDto dto) {
        User user = service.signIn(dto);
        return new UserResponseDto(user.getId(), user.getUsername());
    }

}
