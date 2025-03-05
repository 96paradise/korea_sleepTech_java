package todo_app; // 16

import java.util.List;
import java.util.Scanner;

import todo_app.Controller.TaskController;
import todo_app.Controller.UserController;
import todo_app.dto.request.TaskRequestDto;
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

    // UserController와 TaskController 객체 선언
    private static UserController userController;
    private static TaskController taskController;

    public static void main(String[] args) {
        // Controller 객체 초기화
        userController = new UserController();
        taskController = new TaskController();

        // 애플리케이션 시작 메시지
        System.out.println("To-Do List Application");

        // 사용자 입력을 받기 위한 Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 메인 메뉴 출력
        while (true) {
            System.out.println("\n메뉴를 선택하세요:");
            System.out.println("1. 사용자 등록");
            System.out.println("2. 모든 사용자 조회");
            System.out.println("3. 사용자 조회");
            System.out.println("4. 사용자 수정");
            System.out.println("5. 사용자 삭제");
            System.out.println("6. 할 일 등록");
            System.out.println("7. 특정 사용자 할 일 조회");
            System.out.println("8. 할 일 조회");
            System.out.println("9. 할 일 삭제");
            System.out.println("10. 종료");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Enter key를 소비

            switch (choice) {
                case 1:
                    // 사용자 등록
                    System.out.println("사용자 이름을 입력하세요:");
                    String username = scanner.nextLine();
                    System.out.println("비밀번호를 입력하세요:");
                    String password = scanner.nextLine();

                    UserRequestDto userDto = new UserRequestDto(username, password);
                    userController.registerUser(userDto);
                    System.out.println("사용자가 등록되었습니다.");
                    break;

                case 2:
                    // 모든 사용자 조회
                    List<UserResponseDto> users = userController.getAllUsers();
                    for (UserResponseDto user : users) {
                        System.out.println("ID: " + user.getId() + ", 사용자 이름: " + user.getUsername());
                    }
                    break;

                case 3:
                    // 사용자 조회
                    System.out.println("사용자 ID를 입력하세요:");
                    long userId = scanner.nextLong();
                    UserResponseDto userResponse = userController.getUserById(userId);
                    if (userResponse != null) {
                        System.out.println("ID: " + userResponse.getId() + ", 사용자 이름: " + userResponse.getUsername());
                    } else {
                        System.out.println("사용자를 찾을 수 없습니다.");
                    }
                    break;

                case 4:
                    // 사용자 수정
                    System.out.println("수정할 사용자 ID를 입력하세요:");
                    long updateUserId = scanner.nextLong();
                    scanner.nextLine(); // Enter key를 소비
                    System.out.println("새로운 사용자 이름을 입력하세요:");
                    String newUsername = scanner.nextLine();
                    System.out.println("새로운 비밀번호를 입력하세요:");
                    String newPassword = scanner.nextLine();

                    UserRequestDto updateUserDto = new UserRequestDto(newUsername, newPassword);
                    userController.updateUser(updateUserId, updateUserDto);
                    System.out.println("사용자가 수정되었습니다.");
                    break;

                case 5:
                    // 사용자 삭제
                    System.out.println("삭제할 사용자 ID를 입력하세요:");
                    long deleteUserId = scanner.nextLong();
                    userController.deleteUser(deleteUserId);
                    System.out.println("사용자가 삭제되었습니다.");
                    break;

                case 6:
                    // 할 일 등록
                    System.out.println("할 일을 등록할 사용자 ID를 입력하세요:");
                    long taskUserId = scanner.nextLong();
                    scanner.nextLine(); // Enter key를 소비
                    System.out.println("할 일 제목을 입력하세요:");
                    String title = scanner.nextLine();
                    System.out.println("할 일 설명을 입력하세요:");
                    String description = scanner.nextLine();

                    TaskRequestDto taskDto = new TaskRequestDto(taskUserId, title, description);
                    taskController.registerTask(taskDto);
                    System.out.println("할 일이 등록되었습니다.");
                    break;

                case 7:
                    // 특정 사용자 할 일 조회
                    System.out.println("사용자 ID를 입력하세요:");
                    long taskUserIdInput = scanner.nextLong();
                    List<TaskResponseDto> tasks = taskController.getTasksByUserId(taskUserIdInput);
                    for (TaskResponseDto task : tasks) {
                        System.out.println("ID: " + task.getId() + ", 제목: " + task.getTitle() + ", 설명: " + task.getDescription());
                    }
                    break;

                case 8:
                    // 할 일 조회
                    System.out.println("할 일 ID를 입력하세요:");
                    long taskId = scanner.nextLong();
                    TaskResponseDto taskResponse = taskController.getTaskById(taskId);
                    if (taskResponse != null) {
                        System.out.println("ID: " + taskResponse.getId() + ", 제목: " + taskResponse.getTitle() + ", 설명: " + taskResponse.getDescription());
                    } else {
                        System.out.println("할 일을 찾을 수 없습니다.");
                    }
                    break;

                case 9:
                    // 할 일 삭제
                    System.out.println("삭제할 할 일 ID를 입력하세요:");
                    long deleteTaskId = scanner.nextLong();
                    taskController.deleteTask(deleteTaskId);
                    System.out.println("할 일이 삭제되었습니다.");
                    break;

                case 10:
                    // 종료
                    System.out.println("애플리케이션을 종료합니다.");
                    scanner.close();
                    return;

                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }
}
