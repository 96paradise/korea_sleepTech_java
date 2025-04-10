package test.practice.chapter03;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class 단어_퀴즈_맞추기_게임 {

	public static void main(String[] args) {
		
		// 객체 배열 일반변수 차이점 알아놓기
		ArrayList<String> items = new ArrayList<String>();
		
		items.add("커피");
		items.add("볼펜");
		items.add("핸드폰");
		items.add("포스트잇");
		items.add("리모콘");

		Random random = new Random();
		int index = random.nextInt(items.size());
		String selectedItem = items.get(index);

		Scanner sc = new Scanner(System.in);
		String userGuess;

		while (true) {
			System.out.println("아이템을 맞춰보세요.");
			userGuess = sc.nextLine();

			if (userGuess.equals(selectedItem)) {
				System.out.println("정답입니다.");
				break;
			} else if (userGuess.equals("종료")) {
				break;
			} else {
				System.out.println("틀렸습니다. 다시 시도해주세요.");
			}
		}

		sc.close();
		System.out.println("프로그램이 종료되었습니다.");
	}
}