package todo_app; // 16

import java.time.LocalDate;
import java.util.List;
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
    private static final Scanner sc = new Scanner(System.in);
    private static final UserController userController = new UserController();
    private static final TaskController taskController = new TaskController();

    // 메뉴를 출력하는 함수
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
        System.out.println("9. 할 일 필터링");
        System.out.println("10. 할 일 삭제");
        System.out.println("11. 프로그램 종료");
        System.out.print("메뉴를 선택하세요: ");
    }

    // 사용자 입력을 정수로 받는 함수
    private static int getChoice() {
        while (!sc.hasNextInt()) {
            System.out.println("숫자를 입력해주세요.");
            sc.next();
        }
        int choice = sc.nextInt();
        sc.next(); // 버퍼 처리
        return choice;
    }

    // 사용자 입력을 문자열로 받는 함수
    private static String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return sc.nextLine().trim();
    }

    // 사용자 회원가입을 위한 DTO 생성
    private static UserSignUpRequestDto createUserSignUpRequest() {
        UserSignUpRequestDto dto = null;

        try {
            String username = getInput("사용자 이름을 입력하세요");
            String password = getInput("사용자 비밀번호를 입력하세요");
            String phone = getInput("사용자 핸드폰번호를 입력하세요");
            String email = getInput("사용자 이메일을 입력하세요");
            char gender = getInput("사용자 성별을 입력하세요").charAt(0);

            dto = new UserSignUpRequestDto(username, password, phone, email, gender);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }

    // 사용자 로그인 요청 DTO 생성
    private static UserSignInRequestDto createUserSignInRequest() {
        UserSignInRequestDto dto = null;

        try {
        	String email = getInput("사용자 이메일을 입력하세요");
            Long id = (long) email.hashCode();  // email.hashCode()를 사용하여 이메일을 Long 값으로 변환
            String password = getInput("사용자 비밀번호를 입력하세요");

            dto = new UserSignInRequestDto(id, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }

    // 할 일 등록을 위한 DTO 생성
    private static TaskRequestDto createTaskRequest() {
        TaskRequestDto dto = null;

        try {
            long userId = Long.parseLong(getInput("사용자 ID를 입력하세요"));
            String title = getInput("할 일 제목 입력하세요");
            String content = getInput("할 일 내용을 입력하세요");
            LocalDate date = LocalDate.parse("할 일 날짜를 입력하세요");

            dto = new TaskRequestDto(userId, title, content, date);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dto;
    }

    // 메뉴 선택 후 기능 처리
    private static boolean processChoice(int choice) {
        switch (choice) {
            // 사용자 관련 기능
            case 1: { // 사용자 회원가입
                UserSignUpRequestDto signUpRequest = createUserSignUpRequest();
                userController.registerUser(signUpRequest);
                break;
            }
            case 2: { // 사용자 로그인
                UserSignInRequestDto signInRequest = createUserSignInRequest();
                userController.signInUser(signInRequest);
                break;
            }
            case 3: { // 전체 사용자 조회
                List<UserResponseDto> users = userController.getAllUsers();
                if (users.isEmpty()) {
                    System.out.println("사용자 정보가 없습니다.");
                } else {
                    users.forEach(System.out::println);
                }
                break;
            }
            case 4: { // 사용자 단건 조회
                long id = Long.parseLong(getInput("ID를 입력하세요"));
                UserResponseDto user = userController.getUserById(id);
                if (user == null) {
                    System.out.println("해당하는 ID의 사용자가 없습니다.");
                } else {
                    System.out.println(user);
                }
                break;
            }
            case 5: { // 사용자 수정
                long id = Long.parseLong(getInput("ID를 입력하세요"));
                UserSignUpRequestDto signUpRequest = createUserSignUpRequest();
                userController.updateUser(id, signUpRequest);
                break;
            }
            case 6: { // 사용자 삭제
                long id = Long.parseLong(getInput("ID를 입력하세요"));
                userController.deleteUser(id);
                break;
            }

            // 할 일 관련 기능
            case 7: { // 할 일 추가
                TaskRequestDto taskRequest = createTaskRequest();
                taskController.addTask(taskRequest);
                break;
            }
            case 8: { // 할 일 조회
                List<TaskResponseDto> tasks = taskController.getAllTasks();
                if (tasks.isEmpty()) {
                    System.out.println("할 일이 없습니다.");
                } else {
                    tasks.forEach(System.out::println);
                }
                break;
            }
            case 9: { // 할 일 필터링
                String filter = getInput("필터 조건 (예: 완료 여부, 마감일 등):");
                List<TaskResponseDto> filteredTasks = taskController.filterTasks(filter);
                if (filteredTasks.isEmpty()) {
                    System.out.println("검색 결과를 찾을 수 없습니다.");
                } else {
                    filteredTasks.forEach(System.out::println);
                }
                break;
            }
            case 10: { // 할 일 삭제
                long id = Long.parseLong(getInput("할 일 ID를 입력하세요"));
                taskController.deleteTask(id);
                break;
            }
            case 11: { // 종료
                System.out.println("프로그램을 종료합니다. 이용해주셔서 감사합니다.");
                return false;
            }
            default: { // 잘못된 선택
                System.out.println("잘못된 선택입니다. 유효한 메뉴를 선택해주세요.");
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            while (true) {
                displayMenu(); // 프로그램 메뉴 출력
                int choice = getChoice(); // 사용자 메뉴 선택 저장

                // 사용자의 선택을 처리
                if (!processChoice(choice))
                    break;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            // 예외 발생과 상관없이 반드시 실행 보장
            sc.close();
        }
    }
}
