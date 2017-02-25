public class Book {
	private String title; 
	 private String author;
	 /** Creates a book with author and title */
	 public Book(String author, String title) {
	 this.author = author;
	 this.title = title;
	 }
	 /** returns the name of the author */
	 public String getAuthor() {
	 return author;
	 }
	 /** returns the title */
	 public String getTitle() {
	 return title;
	 }
	 /** Returns a string of both author and title */
	 public String toString() {
	 return author + "\t" + title;
	 }

}
