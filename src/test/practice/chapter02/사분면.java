package test.practice.chapter02;

import java.util.Scanner;

public class 사분면 {
	public static void main(String[] args) {
	String functionScope = null;

    Scanner sc = new Scanner(System.in);
    System.out.println("x: ");
    int x = sc.nextInt();

    System.out.println("y: ");
    int y = sc.nextInt();

    if (x > 0 && y > 0) {
        functionScope = "제1사분면";
    } else if (x < 0 && y > 0) {
        functionScope = "제2사분면";
    } else if (x < 0 && y < 0) {
        functionScope = "제3사분면";
    } else {
        functionScope = "제4사분면";
    }

    System.out.println("결과: " + functionScope);
    sc.close();
	}
}
