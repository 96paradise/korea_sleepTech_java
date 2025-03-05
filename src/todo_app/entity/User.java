package todo_app.entity; // 1. 사용자 객체

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // 종합 패키지 getter/setter, toString(), equals(), hashCode() 
@NoArgsConstructor // 기본 생성자(매개변수가 없는 생성자)를 자동으로 생성해 줌, new User(); 이런 식으로 기본 생성자를 호출할 수 있음
@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자를 자동으로 생성해 줌
public class User {
    private Long id;        // 사용자 ID
    private String username; // 사용자 이름
    private String password; // 비밀번호
    private List<Task> tasks; // 사용자의 할일 목록
    // private List<Task> tasks; 사용자가 가지고 있는 할 일 목록을 저장하는 필드, 1명의 User → 여러 개의 Task (1:N 관계)

 // username과 password만 받는 생성자 추가
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
