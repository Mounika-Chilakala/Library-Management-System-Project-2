package com.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
class Book{
	private String title;
	private String author;
	private boolean available;
	public Book(String title,String author) {
		this.title=title;
		this.author=author;
		this.available=true;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public boolean isAvailable() {
		return available;
	}
	public void borrow() {
		if(available) {
			available=false;
		}else {
			System.out.println("Sorry, this book is already borrowed.");
		}
	}
	public void returnBook() {
		available=true;
	}
	@Override
	public String toString() {
		return title + "by "+author;
	}
}
class LibraryMember{
	private String name;
	private List<Book> borrowedBooks;
	public LibraryMember(String name) {
		this.name=name;
		this.borrowedBooks=new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public List<Book> getBorrowedBooks(){
		return borrowedBooks;
	}
	public void borrowedBook(Book book) {
		if(book.isAvailable()) {
			book.borrow();
			borrowedBooks.add(book);
		}else {
			System.out.println("Sorry, the book "+book.getTitle()+" is not available for borrowing.");
		}
	}
	public void returnBook(Book book) {
		if(borrowedBooks.contains(book)) {
			book.returnBook();
			borrowedBooks.remove(book);
		}else {
			System.out.println("You did not borrow the book "+book.getTitle());
		}
	}
	@Override
	public String toString() {
		return name;
	}
}
public class LibraryDemo {
	public static void main(String[] args) {
		Book book1=new Book("The catcher in the Rye", "J.D.Salinger");
		Book book2=new Book("To Kill a Mockingbird", "Harper Lee");
		LibraryMember member1=new LibraryMember("Mounika");
		LibraryMember member2=new LibraryMember("Nani");
		member1.borrowedBook(book1);
		member1.borrowedBook(book2);
		member2.borrowedBook(book2);
		member1.borrowedBook(book1);
		member2.borrowedBook(book2);
		System.out.println("Books borrowed by "+member1.getName()+": "+member1.getBorrowedBooks());
		System.out.println("Books borrowed by "+member2.getName()+": "+member2.getBorrowedBooks());
	}

}
