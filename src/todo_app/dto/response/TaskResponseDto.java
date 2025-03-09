package todo_app.dto.response; // 7. 할 일 응답 반환

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskResponseDto {
	private Long id;        
    private String title;   
    private String content;
    private LocalDate date;
}