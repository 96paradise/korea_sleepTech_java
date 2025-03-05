package todo_app.service.implement; // 13 구현 클래스 (Impl 클래스): 인터페이스에서 정의한 메소드의 실제 동작을 구현하는 클래스입니다.

import java.util.List;

import todo_app.entity.Task;
import todo_app.repository.TaskRepository;
import todo_app.service.TaskService;

public class TaskServiceImpl implements TaskService {
    private TaskRepository taskRepository;

    // 생성자 주입 (TaskRepository는 의존성 주입을 통해 전달됨)
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Long userId, String title, String description) {
        // 새로운 Task 객체 생성
        Task newTask = new Task(title, description, userId);
        return taskRepository.save(newTask);  // TaskRepository에 저장 후 반환
    }

    @Override
    public Task updateTask(Long id, String title, String description, boolean completed) {
        // 할일 수정
        Task taskToUpdate = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        taskToUpdate.setTitle(title);
        taskToUpdate.setDescription(description);
        taskToUpdate.setCompleted(completed);
        return taskRepository.save(taskToUpdate);  // 수정된 Task 저장 후 반환
    }

    @Override
    public Task findTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }

    @Override
    public List<Task> findTasksByUserId(Long userId) {
        return taskRepository.findByUserId(userId);  // 특정 사용자의 할일 조회
    }

    @Override
    public boolean deleteTaskById(Long id) {
        return taskRepository.deleteById(id);  // ID로 할일 삭제
    }
}