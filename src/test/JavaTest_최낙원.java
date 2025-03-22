package test;

import java.util.Scanner;

class Student {
    private String name; // 이름
    private int score;   // 점수

    // 생성자
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // 이름을 반환하는 메서드
    public String getName() {
        return name;
    }

    // 점수를 반환하는 메서드
    public int getScore() {
        return score;
    }
}
public class JavaTest_최낙원 {
	public static void main(String[] args) {
		// 1. 서술형
		/*
		 * - 기본 데이터 타입
		 * 정수형
		 * byte(4), int(8), long(?), ??
		 * 
		 * 실수형
		 * double
		 * float
		 * 
		 * 문자형
		 * char
		 * 
		 * 조건?형
		 * boolean
		 * 
		 * - 참조 데이터 타입
		 * class
		 * Array
		 * interface?
		 */
		// 2. 코드 구현 문제
		int num1 = 10;
		double num2 = 3.5;
		
		double result = num1 + num2;
		
		System.out.println(result); // 13.5
		
		// 3. 코드 구현 문제
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("짝수입니다");
		} else {
			System.out.println("홀수입니다");
		}
		
		scanner.close();
		
		// 4. 코드 구현 문제
		int[] numbers = {1,2,3,4,5};
		
		for(int i=0; i<numbers.length; i++) {
			System.out.println(i+1);
		}
		
		// 5. 코드 구현 문제
	        // 1. Student 객체 배열 생성 및 초기화
	        Student[] students = {
	            new Student("이승아", 85),
	            new Student("이도경", 92),
	            new Student("이지희", 78),
	            new Student("이지훈", 88),
	            new Student("김명진", 95)
	        };

	        // 2. 점수가 90점 이상인 학생의 이름 출력
	        System.out.println("90점 이상인 학생:");
	        for (Student student : students) {
	            if (student.getScore() >= 90) {
	                System.out.println(student.getName());
	            }
	        }
	    }
	
				
		// 6. 단답형 : Object
		// 7. 단답형 : 크기?,개수? size()
		// 8. 단답형 : 삼항연산자, 변수 = (조건식) ? 값1 : 값2
		// 9. 인터페이스에서 사용x : 4 생성자, + static?도 불가
		// 10. @FunctionalInterface : 1.여러 개의 추상 메서드 포함 가능
		// 11. 코드 출력 결과 : "child"
		// 12. 싱글톤 패턴 가장 일반적으로 사용 되는 메서드 : 2 private static
		// 13. 추상클래스 객체 생성 : O or X 잘 모르겠습니다
		// 14. 다운 캐스팅 :  잘 모르겠습니다
		// 15. 빌더 패턴의 주요 이점 : 2 객체 생성 시 복잡한 생성자 호출 피할 수 있다
		// 16. MVC 패턴에서 사용자의 입력을 처리하는 역할 : main? 잘 모르겠습니다
		// 17. 인터페이스의 모든 메서드는 어떤 접근 제어자 : public
		// 18. 추상 클래스와 인터페이스 차이점 (맞지 않는 것) : 4. 추상 클래스는 정적 메서드를 가질 수 없다

	}
}
