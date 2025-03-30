package test;
//! 1. 문제 설명
//자연수 N이 주어지면, N의 모든 약수를 오름차순으로 출력하는 프로그램을 작성하시오.
//EX) 24의 약수 1,2,3,4,6,8,12,24
//EX) 35의 약수 1,5,7,35

import java.util.Scanner;

//public class code03 {
//  public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int N = sc.nextInt();
//
//    for (int i = 1; i <= N; i++) {
//      if (N % i == 0) {
//        System.out.println(i + " ");
//      }
//    }
//    sc.close();
//  }
//}

public class code03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if (N % 2 != 0) {
			for (int i = 1; i <= N; i ++) {
				if (N % i == 0) {
				System.out.println(i +  " ");
				}
			}
		}
		sc.close();
	}
}