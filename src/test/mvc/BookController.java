package test;

import java.util.ArrayList;
import java.util.List;

// 멤버변수
public class BookController {
	private List<Book> books;
	
// 생성자
	public BookController() {
		this.books = new ArrayList<>();
	}
	
// 책 추가
	public void addBook(String title, String author, String publisher) {
		Book newBook = new Book(title, author, publisher);
		books.add(newBook);
	}
	
// 전체 책 조회
	public List<Book> getAllBooks() {
		return books;
	}
	
// 책 검색 - 제목
	public List<Book> searchBook(String title) {
		List<Book> result = new ArrayList<Book>();
		
		for (Book book: books) {
			if (book.getTitle().contains(title)) {
				result.add(book);
			}
		}
		return result;
	}
	
}
