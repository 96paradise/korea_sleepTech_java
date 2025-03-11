package todo_app; // 16

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import todo_app.Controller.TaskController;
import todo_app.Controller.UserController;
import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.request.UserSignInRequestDto;
import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.dto.response.UserResponseDto;

/*
 * === TODO(할 일) 프로그램 === 
 * 
 * 1. 프로젝트 개요
 * : 할 일(Todo)에 대한 간단한 콘솔 기반 응용 프로그램
 * - 두 도메인(사용자, 할 일)을 대상으로 회원가입, 로그인, 로그아웃, 회원 탈퇴 기능
 * 		할 일에 대한 추가, 조회(단건/전체), 수정, 삭제 기능을 제공
 * 	
 * +) 할 일의 활성화 여부(할 일 완료 여부)에 따른 필터링
 * 
 * 2. 주요 기능 및 비즈니스 로직
 * : 회원 정보 관리 - CR(단건)D (+로그인, 로그아웃)
 * : 할 일 기록 관리 - CR(단건/전쳬)UD (+ 필터링)
 * 
 *  3. 비즈니스 로직 구조
 * - Controller: 사용자의 입력을 처리하고 적절한 서비스 메소드를 호출
 * - Service: 핵심 비즈니스 로직을 수행
 * - Repository: 데이터 저장소와의 상호 작용을 담당
 * - DTO: 계층 간 데이터 전송을 위한 객체
 * - Entity: 데이터베이스 테이블과 매핑되는 도메인 객체
 *
 * 4. 실행 및 관리
 * - Main Class (App.java): 프로그램의 실행 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어
 * 
 */


public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserController userController = new UserController();
    private static final TaskController taskController = new TaskController();
    private static UserResponseDto loggedInUser = null;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> registerUser();
                case 2 -> signInUser();
                case 3 -> listAllUsers();
                case 4 -> getUserById();
                case 5 -> updateUser();
                case 6 -> deleteUser();
                case 7 -> createTask();
                case 8 -> listAllTasks();
                case 9 -> deleteTask();
                case 10 -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n[메뉴 선택]");
        System.out.println("1. 사용자 회원가입");
        System.out.println("2. 사용자 로그인");
        System.out.println("3. 사용자 전체 조회");
        System.out.println("4. 사용자 단건 조회");
        System.out.println("5. 사용자 수정");
        System.out.println("6. 사용자 삭제");
        System.out.println("7. 할 일 추가");
        System.out.println("8. 할 일 조회");
        System.out.println("9. 할 일 삭제");
        System.out.println("10. 프로그램 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    private static void registerUser() {
        System.out.println("\n=== 회원가입 ===");
        System.out.print("사용자 이름: ");
        String username = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();
        System.out.print("전화번호: ");
        String phone = scanner.nextLine();
        System.out.print("이메일: ");
        String email = scanner.nextLine();
        System.out.print("성별(M/F): ");
        String gender = scanner.nextLine();

        UserSignUpRequestDto signUpRequest = new UserSignUpRequestDto(username, password, phone, email, gender);
        userController.registerUser(signUpRequest);
        System.out.println("회원가입이 완료되었습니다.");
    }

    private static void signInUser() {
        System.out.println("\n=== 로그인 ===");
        System.out.print("아이디: ");
        Long userId = scanner.nextLong();
        scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        try {
            loggedInUser = userController.signIn(new UserSignInRequestDto(userId, password));
            System.out.println(loggedInUser.getUsername() + "님, 로그인되었습니다.");
        } catch (Exception e) {
            System.out.println("로그인 실패: " + e.getMessage());
        }
    }

    private static void listAllUsers() {
        System.out.println("\n=== 사용자 목록 ===");
        List<UserResponseDto> users = userController.getAllUsers();
        users.forEach(user -> System.out.println("ID: " + user.getId() + ", 이름: " + user.getUsername()));
    }

    private static void getUserById() {
        System.out.print("\n조회할 사용자 ID: ");
        Long userId = scanner.nextLong();
        scanner.nextLine();
        UserResponseDto user = userController.getUserById(userId);
        if (user != null) {
            System.out.println("ID: " + user.getId() + ", 이름: " + user.getUsername());
        } else {
            System.out.println("사용자를 찾을 수 없습니다.");
        }
    }

    private static void updateUser() {
        System.out.print("\n수정할 사용자 ID: ");
        Long userId = scanner.nextLong();
        scanner.nextLine();
        System.out.print("새 사용자 이름: ");
        String newUsername = scanner.nextLine();
        System.out.print("새 비밀번호: ");
        String newPassword = scanner.nextLine();

        userController.updateUser(userId, new UserSignUpRequestDto(newUsername, newPassword, "", "", ""));
        System.out.println("사용자가 수정되었습니다.");
    }

    private static void deleteUser() {
        System.out.print("\n삭제할 사용자 ID: ");
        Long userId = scanner.nextLong();
        userController.deleteUser(userId);
        System.out.println("사용자가 삭제되었습니다.");
    }

    private static void createTask() {
        if (loggedInUser == null) {
            System.out.println("먼저 로그인 해주세요.");
            return;
        }

        System.out.println("\n=== 할 일 추가 ===");
        System.out.print("할 일 제목: ");
        String title = scanner.nextLine();
        System.out.print("할 일 내용: ");
        String content = scanner.nextLine();
        System.out.print("날짜 (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.println("로그인된 사용자 ID: " + loggedInUser.getId());

        TaskRequestDto taskRequest = new TaskRequestDto(loggedInUser.getId(), title, content, date);
        taskController.createTask(taskRequest);
        System.out.println("할 일이 추가되었습니다.");
    }

    private static void listAllTasks() {
        System.out.println("\n=== 할 일 목록 ===");
        List<TaskResponseDto> tasks = taskController.getAllTasks();
        tasks.forEach(task -> System.out.println("ID: " + task.getId() + ", 제목: " + task.getTitle() + ", 날짜: " + task.getDate()));
    }

    private static void deleteTask() {
        System.out.print("\n삭제할 할 일 ID: ");
        Long taskId = scanner.nextLong();
        taskController.deleteTask(taskId);
        System.out.println("할 일이 삭제되었습니다.");
    }
}