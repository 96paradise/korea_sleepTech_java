package chapter01;

public class G_Operator {
	public static void main(String[] args) {
		// === 연산자(Operation) === //
		
		// 한 줄 주석 : ctrl + /
		// : 프로그램에서 데이터를 조작허거나 계산
		
		System.out.println("=== 산술 연산자 ===");
		System.out.println(10 + 20); // 덧셈 
		System.out.println(10 - 20); // 뺄셈
		System.out.println(10 * 20); // 곱셈(*)
		
		System.out.println(21 / 10); // 나눗셈(/) - 나눈 결과의 몫을 저장
		System.out.println(21 % 10); // 나눗셈(%) - 나눈 결과의 나머지를 저장
		
		System.out.println("=== 증감 연산자 ===");
		// : 변수의 값을 1 증가(++)시키거나 1 감소(--)시키는 연산자
		int number = 10;
		
		// 전위 증감 연산자 / 후위 증감 연산자
		// 1) 전위 증감 연산자
		// : 값이 먼저 변경되고 나서 계산에 적용
		// - ++변수명, --변수명
		System.out.println(++number); // 1 + 10 (증가) 후 출력
		System.out.println(--number); // -1 + 10 (감소) 후 출력
		
		// 2) 후위 증감 연산자
		// : 값이 계산된 후 변경됨
		// : 변수명++, 변수명--
		System.out.println(number); // 10
		System.out.println(number++); // 10 : 출력 후 1 + 10 (증가)
		System.out.println(number--); // 11 : 출력 후 -1 + 10 (감소)
		System.out.println(number);
		
		number++; // 10
		number++; // 11
		++number; // 13
		--number; // 12
		number--; // 12
		number++; // 11 (+1 남아있음)
		System.out.println(number); // 12
		
		System.out.println("=== 대입(할당) 연산자 ===");
		// : 변수에 값을 할당할 때 사용하는 연산자, 기본 연산자 =
		number = 10;
		System.out.println(number += 3); // number = number + 3 (13)
		System.out.println(number -= 3); // number = number - 3 (10)
		System.out.println(number *= 3); // number = number * 3 (30)
		System.out.println(number /= 3); // number = number / 3 (10)
		System.out.println(number %= 3); // number = number % 3 (1)
		System.out.println(number); //1		
		
		number += 1; // ++number;
		
		System.out.println("=== 비교 연산자 ===");
		// : 좌항과 우항을 비교한 결과를 논리(boolean) 값으로 반환
		// <, >, <=, >=, ==(같다, 일치), !=(같지 않다, 불일치)
		System.out.println(5 > 3); // T
		System.out.println(5 < 3); // F
		System.out.println(5 >= 3); // T
		System.out.println(5 <= 3); // F
		System.out.println(5 == 3); // F
		System.out.println(5 != 3); // T
		
		System.out.println("=== 논리 연산자 ==="); // *중요*
		// : 논리 값(boolean)을 연산
		
		// & (앰퍼샌트), | (vertical bar, 버티컬 바)
		
		// 1) 논리곱(and, &&)
		// - 모든 값이 true면 true의 결과
		// - 하나의 값이라도 false면 fasle의 결과
		System.out.println(true && true); // T
		System.out.println(true && true && false && true && true); // F
		
		// 2) 논리합(or, ||)
		// - 하나의 값이라도 true면 true
		System.out.println(true || true); // T
		System.out.println(false || true || false); // T
		System.out.println(false || false || false); // F
		
		// 3) 부정논리
		// - 값을 전환
		// - 논리값 앞에 !키워드를 사용하여 작성
		boolean bool1 = true;
		boolean bool2 = false;
		System.out.println(!bool1); // F
		System.out.println(!bool2); // T
		
		System.out.println(3 > 2 && 1 == 1); // T
		System.out.println(1 != 1); // F
		System.out.println(3 >= 3 || 10 < 11 && !bool2); // T
		
		System.out.println("=== 조건 (삼항) 연산자 ===");
		// 조건식(논리의 값이 반환) ? 조건식이 참인 경우 반환 : 조건식이 거짓인 경우 반환
		
		int age = 28;
		String drink = age > 19 ? "맥주" : "음료수";
		System.out.println(drink + "을(를) 마십니다.");
		
		// 정수를 담는 x, y 변수를 선언
		// 각각 10, 2를 할당
		// > y값을 활용하여 x의 값이 짝수면 "2의 배수입니다." 출력
		//				x의 값이 홀수면 "2의 배수가 아닙니다." 출력
		
		int x = 10, y = 2; // 같은 자료형일 경우 쉼표로 구분하여 선언 가능
		
		System.out.println(x % y == 0 ? "2의 배수입니다" : "2의 배수가 아닙니다");
		
		System.out.println("=== 기타 연산자 ===");
		// 문자열 연결 연산자 : +
		String result = "최" + "낙원";
		System.out.println(result);
		
		// cf) 연산자의 우선순위
		// : 좌측 >> 우측
		// 그러나, 대입연산자의 경우 우항에서 좌항의 대입이 이루어짐
		//		()괄호 연산자의 경우 우선순위의 연산이 이루어짐
		int num = 4 * (1 + 2);
		
	}
}
