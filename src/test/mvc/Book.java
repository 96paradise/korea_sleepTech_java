package test;

// 멤버변수(필드)
public class Book {
	private String title;
	private String author;
	private String publisher;

// 생성자
	public Book(String title, String author, String publisher) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

// Getter 메서드
	public String getTitle() { return title; }
	public String getAuthor() { return author; }
	public String getPublisher() { return publisher; }
	
// toString() 메서드
	@Override
	public String toString() {
		return "Title: " + title + ", Author: " + author + ", Publisher: " + publisher;
	}
}
