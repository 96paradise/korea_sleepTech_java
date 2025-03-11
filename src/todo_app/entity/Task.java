package todo_app.entity; // 2. 할 일 객체

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private Long id;        
    private String title;   
    private String content;
    private LocalDate date;
}
