package todo_app.service; // 12 인터페이스 (Service 인터페이스): 기능을 정의하는 역할입니다.

import java.util.List;

import todo_app.entity.Task;

public interface TaskService {
    Task createTask(Long userId, String title, String description);  // 할일 생성
    Task updateTask(Long id, String title, String description, boolean completed);  // 할일 수정
    Task findTaskById(Long id);  // ID로 할일 조회
    List<Task> findTasksByUserId(Long userId);  // 특정 사용자(Task 소유자)의 할일 조회
    boolean deleteTaskById(Long id);  // ID로 할일 삭제
}