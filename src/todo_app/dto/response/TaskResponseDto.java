package todo_app.dto.response; // 7. 할 일 응답 반환

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    // TaskResponseDto는 클라이언트가 할일(Task) 정보를 받을 때 사용하는 DTO
    // 이때, 클라이언트가 필요한 최소한의 정보만 제공하기 위해 아래 4개의 필드만 포함
    // userId x 보통 클라이언트는 특정 사용자의 할일만 요청하므로 필요 없음
}