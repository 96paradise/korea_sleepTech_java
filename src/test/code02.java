package test;
//! 1. 문제 설명
//N개의 정수가 주어지면, 그 중 최대값을 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

//public class code02 {
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int N = sc.nextInt();
//    int max = Integer.MIN_VALUE;
//
//    for (int i = 0; i < N; i++) {
//      int num = sc.nextInt();
//
//      if (num > max) {
//        max = num;
//      }
//    }
//    System.out.println(max);
//    sc.close();
//  }
//}

public class code02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int min = Integer.MAX_VALUE; // 초기값을 설정
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if (num < min) {
				min = num;
			}
		}
		System.out.println(min);
		sc.close();
	}
}