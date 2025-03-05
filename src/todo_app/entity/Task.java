package todo_app.entity; // 2. 할 일 객체

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    private Long id;        // 할일 ID
    private String title;   // 할일 제목
    private String description; // 할일 설명
    private boolean completed;  // 완료 여부
    private Long userId;    // 해당 할일을 소유한 사용자 ID

 // title, description, userId만 받는 생성자 추가
    public Task(String title, String description, Long userId) {
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.completed = false; // 기본값은 false로 설정
    }
}
