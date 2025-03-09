package todo_app.dto.request; // 5. 할 일 생성/수정 요청 데이터

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskRequestDto {
	private Long userId;
	private String title;   
    private String content;
    private LocalDate date;
}