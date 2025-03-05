package todo_app.Controller; // 15

import todo_app.dto.request.TaskRequestDto;  // DTO 요청 패키지
import todo_app.dto.response.TaskResponseDto;  // DTO 응답 패키지
import todo_app.entity.Task;  // Entity 패키지
import todo_app.repository.TaskRepository;  // Repository 패키지

import java.util.List;
import java.util.Optional;

public class TaskController {

    private TaskRepository taskRepository;

    // 생성자에서 TaskRepository 인스턴스를 주입받음
    public TaskController() {
        this.taskRepository = TaskRepository.getInstance();  // Singleton 패턴으로 TaskRepository 인스턴스 가져오기
    }

    // 작업 등록
    public void registerTask(TaskRequestDto dto) {
        Task newTask = new Task(dto.getId(), dto.getTitle(), dto.getDescription(), dto.getStatus());
        taskRepository.save(newTask);
    }

    // 모든 작업 조회
    public List<TaskResponseDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        // 작업 리스트를 TaskResponseDto로 변환해서 반환
        return tasks.stream()
                .map(task -> new TaskResponseDto(task.getId(), task.getTitle(), task.getDescription(), task.getStatus()))
                .toList();
    }

    // ID로 작업 조회
    public TaskResponseDto getTaskById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.map(t -> new TaskResponseDto(t.getId(), t.getTitle(), t.getDescription(), t.getStatus()))
                .orElse(null);  // 작업이 없으면 null 반환
    }

    // 작업 삭제
    public void deleteTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        task.ifPresent(taskRepository::delete);  // 작업이 존재하면 삭제
    }

    // 작업 정보 업데이트
    public void updateTask(Long id, TaskRequestDto dto) {
        Optional<Task> taskOpt = taskRepository.findById(id);
        taskOpt.ifPresent(task -> {
            task.setTitle(dto.getTitle());
            task.setDescription(dto.getDescription());
            task.setStatus(dto.getStatus());
        });
    }
}