package todo_app.service; // 12 인터페이스 (Service 인터페이스): 기능을 정의하는 역할입니다.

import java.util.List;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;


public interface TaskService {
    void createTask(TaskRequestDto dto);
    List<TaskResponseDto> getAllTasks();
    void deleteTask(Long id);
}