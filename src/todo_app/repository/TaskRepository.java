package todo_app.repository; // 9. Task 데이터에 대한 List 컬렉션 저장소 정의

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import todo_app.entity.Task;

public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>();
    private Long nextId = 1L;

    // 할일 저장 (등록 & 수정)
    public Task save(Task task) {
        if (task.getId() == null) {  // 신규 등록이면 ID 자동 생성
            task.setId(nextId++);
            tasks.add(task);
        } else {  // 기존 할일 수정
            deleteById(task.getId()); // 기존 데이터 삭제 후 추가
            tasks.add(task);
        }
        return task;
    }

    // 할일 단건 조회
    public Optional<Task> findById(Long id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
    }

    // 특정 사용자(Task 소유자)의 할일 전체 조회
    public List<Task> findByUserId(Long userId) {
        return tasks.stream()
                .filter(task -> task.getUserId().equals(userId))  // userId가 일치하는 할일만 필터링
                .collect(Collectors.toList()); // 결과를 List로 모은다
        		// collect는 최종 연산 (Terminal Operation) 중 하나로, 스트림의 결과를 컬렉션으로 변환할 수 있게 해줍니다. 
        		// Collectors.toList()는 스트림의 요소들을 새로운 List로 모은다는 의미입니다.
    }

    // 전체 할일 조회
    public List<Task> findAll() {
        return new ArrayList<>(tasks);
    }

    // 할일 삭제
    public boolean deleteById(Long id) {
        return tasks.removeIf(task -> task.getId().equals(id));
    }
}