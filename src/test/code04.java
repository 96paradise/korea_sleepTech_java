package test;
//! 1. 문제 설명
//: 정수 N개의 배열이 주어지면, 버블 정렬(Bubble Sort) 알고리즘을 이용하여 
// 오름차순으로 정렬한 결과를 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

public class code04 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = sc.nextInt();
    }

    for (int i = 0; i < N - 1; i++) {
      for (int j = 0; j < N - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    for (int num : arr) {
      System.out.print(num + " ");
    }

    sc.close();
  }
}
