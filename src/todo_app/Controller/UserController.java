package todo_app.Controller; // 14

import java.util.List;

import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.UserResponseDto;
import todo_app.service.UserService;
import todo_app.service.implement.UserServiceImpl;

public class UserController {
	private UserService service;
	
	public UserController() {
		this.service = new UserServiceImpl();
	}
	
	public void registerUser(UserSignUpRequestDto dto) {
		service.registerUser(dto);
	}
	
	public List<UserResponseDto> getAllUsers() {
		List<UserResponseDto> users = service.listAllUsers();
		return users;
	}
	
	public UserResponseDto getUserById(long id) {
		UserResponseDto user = service.getUserById(id);
		return user;
	}
	
	public void updateUser(long id, UserSignUpRequestDto dto) {
		service.updateUser(id, dto);
	}
	
	public void deleteUser(long id) {
		service.deleteUser(id);
	}
	
}
