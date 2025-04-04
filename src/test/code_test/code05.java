package test.code_test;
//! 1. 문제 설명
//오름차순으로 정렬된 정수 배열과 특정 정수 K가 주어질 때, 
//이진 탐색(Binary Search) 알고리즘을 사용하여 K의 인덱스를 찾는 프로그램을 작성하시오.
//K가 배열에 없는 경우 -1을 출력한다. 단, 배열의 인덱스는 0부터 시작한다.

import java.util.Scanner;

public class Code05 {
public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);

  int N = sc.nextInt();
  int[] arr = new int[N];
  for (int i = 0; i < N; i++) {
    arr[i] = sc.nextInt();
  }

  int K = sc.nextInt();

  int index = binarySearch(arr, K);
  System.out.println(index);
  sc.close();
}

public static int binarySearch(int[] arr, int K) {
  int left = 0;
  int right = arr.length - 1;

  while (left <= right) {
    int mid = left + (right - left) / 2;
    if (arr[mid] == K) {
      return mid;
    } else if (arr[mid] < K) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }

  return -1;
}
}
