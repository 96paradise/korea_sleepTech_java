package test.practice.chapter04;

class Person {
	String name;
	int age;
	static int population;

	Person() {
		population++;
	}
	
	Person(String name, int age) {
	this.name = name;
	this.age = age;
	population++;
	}
	
	void introuduce() {
		System.out.println("얀녕하세요, 저는" + name + "이고, 나이는 " + age + "살 입니다.");
	}
}

public class 인스턴스_클래스_변수2 {
	public static void main(String[] args) {
		Person honggildong = new Person("홍길동", 20);
		
		honggildong.introuduce();
		
		System.out.println(Person.population); // 1
		
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		
		System.out.println(Person.population); // 6

	}
}
