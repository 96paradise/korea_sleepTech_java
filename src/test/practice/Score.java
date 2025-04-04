package test.practice;

/* 
1. 점수에 따른 학점 출력 (if, else if, else 사용)

	        사용자로부터 점수를 입력받아 아래 기준에 따라 학점을 출력하세요.
	        0 미만 또는 100 초과인 경우: 유효하지 않은 점수입니다.
	        90 이상: A
	        80 이상: B
	        70 이상: C
	        60 이상: D
	        그 외: F
*/

import java.util.Scanner;

public class Score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("점수를 입력하세요 (0 ~ 100): ");
		int score = sc.nextInt();
		
		if(score < 0 || score > 100) {
			System.out.println("유효하지 않은 점수입니다.");
		} else if (score >= 90) {
			System.out.println("학점 A");
		} else if (score >= 80) {
			System.out.println("학점 B");
		} else if (score >= 70) {
			System.out.println("학점 C");
		} else if (score >= 60) {
			System.out.println("학점 D");
		} else {
			System.out.println("학점 F");
		}
		
		sc.close();
	}
}
