package todo_app.dto.request; // 5. 할 일 생성/수정 요청 데이터

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequestDto {
    private String title;
    private String description;
    private boolean completed;
    private Long userId; // 어떤 사용자의 할일인지 구분
    // 보통 ID(고유번호 id)는 서버에서 자동 생성되므로 클라이언트에서 입력할 필요 없음
}