package todo_app.repository; // 9. Task 데이터에 대한 List 컬렉션 저장소 정의
//사용자 등록(save), 사용자 단건 조회(findById), 사용자 전체 조회(findAll), 사용자 삭제(deleteById)

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import todo_app.entity.Task;


public class TaskRepository {
    private List<Task> tasks = new ArrayList<Task>();
    private static final TaskRepository instance = new TaskRepository();
    
    private TaskRepository() {}
    
    public static TaskRepository getInstance() {
    	return instance;
    }
    
    public void save(Task task) {
    	tasks.add(task);
    }
    
    public Optional<Task> findById(Long id) {
    	return tasks.stream()
    			.filter(task -> task.getId().equals(id))
    			.findFirst();
    }
    
    public List<Task> taskAll() {
        return new ArrayList<>(tasks);
    }
    
    public void delete(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }

}