package todo_app.repository; // 8. User 데이터에 대한 List 컬렉션 저장소 정의
// 사용자 등록(save), 사용자 단건 조회(findById), 사용자 전체 조회(findAll), 사용자 삭제(deleteById)

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import todo_app.entity.User;

public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;  // 사용자 ID는 자동 증가되도록 설정, 자동 증가는 ID 충돌을 방지하고, 각 객체가 고유한 식별자를 갖게 하여 데이터의 무결성을 보장
    // private Long nextId = 1L;는 자동 증가 ID를 구현하는 방법 중 하나입니다. 
    // 이 코드를 사용하면 User나 Task 객체가 저장될 때마다 자동으로 고유한 ID를 부여할 수 있습니다.

    // 사용자 등록
    public User save(User user) {
        user.setId(nextId++);  // 새로운 ID를 부여하고 저장
        users.add(user);
        return user;  // 저장된 사용자 객체 반환
    }

    // 사용자 단건 조회
    public Optional<User> findById(Long id) { // findById (메서드 이름)
    	//사용자가 존재할 수도 있고 존재하지 않을 수도 있는 경우를 처리하기 위해 Optional<User>
        return users.stream() // stream()은 users 리스트에서 스트림을 생성하는 역할, 스트림의 주요 작업들(예: filter, map, reduce)은 람다 표현식을 통해 조건을 정의하거나 변환 작업을 수행할 수 있다.
                .filter(user -> user.getId().equals(id))  // filter는 주어진 조건을 만족하는 요소만 남기고, 나머지는 걸러냅니다. 이 경우, user.getId().equals(id) 조건이 참인 사용자만 선택
                // user -> user.getId().equals(id)는 user 객체를 받아서 
                // 그 객체의 id(user.getId()는 user라는 객체의 id 값을 가져오는 코드)가 id(findById(Long id) 메소드에서 외부에서 전달된 id 값)와 일치하는지 확인
                .findFirst();  // 첫 번째로 찾은 값 반환
    }

    // 전체 사용자 조회
    public List<User> findAll() {
        return new ArrayList<>(users);  // 전체 사용자 리스트 반환
    }   // ArrayList<> List<User>를 가지고 오는거고
    	// (users) 위에 List<User> 데이터 가지고 옴

    // 사용자 삭제
    public boolean deleteById(Long id) {
        return users.removeIf(user -> user.getId().equals(id));  // 해당 ID를 가진 사용자 삭제
    } // removeIf는 컬렉션에서 조건에 맞는 요소를 삭제하는 메서드
}
