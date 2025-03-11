package todo_app.service.implement; // 13 구현 클래스 (Impl 클래스)

import java.util.List;
import java.util.stream.Collectors;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.entity.Task;
import todo_app.repository.TaskRepository;
import todo_app.service.TaskService;

public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    
    private static long currentId = 1;
    
    public TaskServiceImpl() {
        this.taskRepository = TaskRepository.getInstance();
    }
    
    private Long generateTaskId() {
        return currentId++;
    }

    @Override
    public void createTask(TaskRequestDto dto) {
        Long newTaskId = generateTaskId(); 
        Task task = new Task(newTaskId, dto.getTitle(), dto.getContent(), dto.getDate());
        taskRepository.save(task);
        System.out.println("할 일 저장 완료 (ID: " + newTaskId + ")");
    }

    @Override
    public List<TaskResponseDto> getAllTasks() {
        List<TaskResponseDto> responseDtos = null;
        try {
            List<Task> tasks = taskRepository.taskAll();  // taskAll() 메서드 사용
            responseDtos = tasks.stream()
                .map(task -> new TaskResponseDto(task.getId(), task.getTitle(), task.getContent(), task.getDate()))
                .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return responseDtos;
    }

    @Override
    public void deleteTask(Long id) {
        try {
            Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID는 존재하지 않습니다. ID: " + id));
            taskRepository.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
