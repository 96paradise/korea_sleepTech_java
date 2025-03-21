package todo_app.Controller; // 15

import java.util.List;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.service.TaskService;
import todo_app.service.implement.TaskServiceImpl;

public class TaskController {
	private TaskService service;
	
	public TaskController() {
		this.service = new TaskServiceImpl();
	}
	
	public void createTask(TaskRequestDto dto) {
		service.createTask(dto);
	}
	
	public List<TaskResponseDto> getAllTasks(){
		return service.getAllTasks();
	}
	
	public void deleteTask(Long id) {
	    service.deleteTask(id);
	}

}