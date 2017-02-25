public class BookRegister {

	public static void main(String[] args) {
		Dialog dialog = new Dialog();
		Register register = new Register();
		
		
		while(true) {
			int command = dialog.readInt("Menu" + "\n"
 					+ "1: Insert a new book" + "\n"
 					+ "2: delete books" + "\n"
 					+ "3: Search title from writer / part of the author name" + "\n"
 					+ "4: Search book after title" + "\n"
 					+ "5: Read titles from a file" + "\n"
 					+ "6: Wrtie titles to a file" + "\n"
 					+ "7: Show sorted list by author" + "\n"
 					+ "8: Show sorted list by title" + "\n");
			
			switch(command){
			case 1:
				String author = dialog.readString("Write the name of the author");
				String title = dialog.readString("Write titel");
				Book book = new Book(author, title);
				register.insert(book);
				break;
			case 2:
				String nameOfAuthor = dialog.readString("Write the name of the author");
				Book b = register.remove(nameOfAuthor);
				dialog.printString(b.getAuthor() + " books are now deleted");
				break;
			case 3:
				String searchWord = dialog.readString("Write a keyword");
				String result = register.searchByAuthor(searchWord);
				dialog.printString(result);
				break;
			case 4:
				String t = dialog.readString("Enter the desired title");
				String titles = register.searchByTitle(t);
				dialog.printString(titles);
				break;
			case 5:
				String filename = dialog.readString("Write name of the file");
				register.readFromFile(filename);
				break;
			case 6:
				String tofile = dialog.readString("Write name of the file");
				register.writeToFile(tofile);
				break;
			case 7:
				String list = register.listByAuthor();
				dialog.printString(list);
				break;
			case 8:
				String titlelist = register.listByTitle();
				dialog.printString(titlelist);
				break;
			default:
				System.exit(0);
				break;
			}
		}
		
		
				
		

	}

}
