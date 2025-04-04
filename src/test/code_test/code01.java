package test.code_test;
//! 1. 문제 설명
//: 두 정수 A와 B가 주어질 떄, 두 수의 합을 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

//class code01 {
//public static void main(String[] args) {
//  Scanner sc = new Scanner(System.in);
//  int A = sc.nextInt();
//  int B = sc.nextInt();
//  System.out.println(A + B);
//
//  sc.close();
//}
//}

class Code01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		System.out.println(A * B);
		
		sc.close();
	}
}
