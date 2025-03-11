package todo_app.repository; // 8. User 데이터에 대한 List 컬렉션 저장소 정의

// 사용자 등록(save), 사용자 단건 조회(findById), 사용자 전체 조회(findAll), 사용자 삭제(deleteById)

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import todo_app.entity.User;

public class UserRepository {
    private static final UserRepository instance = new UserRepository();
    private static List<User> users = new ArrayList<>();
    
    private UserRepository() {}

    public static UserRepository getInstance() {
        return instance;
    }

    public void save(User newUser) {
        users.add(newUser);
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public void delete(User user) {
        users.remove(user);
    }
}
