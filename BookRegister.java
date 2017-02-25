public class BookRegister {

	public static void main(String[] args) {
		Dialog dialog = new Dialog();
		Register register = new Register();
		
		
		while(true) {
			int command = dialog.readInt("Meny" + "\n"
 					+ "1: Sätt in en ny bok" + "\n"
 					+ "2: Tag bort böcker" + "\n"
 					+ "3: Sök titel från författare/del av författare" + "\n"
 					+ "4: Sök bok från titel" + "\n"
 					+ "5: Läs titlar från en fil" + "\n"
 					+ "6: Skriv titlar till en fil" + "\n"
 					+ "7: Visa böcker sorterade efter författare" + "\n"
 					+ "8: Visa böcker sorterade efter titel" + "\n");
			
			switch(command){
			case 1:
				String author = dialog.readString("Skriv namn på författaren");
				String title = dialog.readString("Skriv titel");
				Book book = new Book(author, title);
				register.insert(book);
				break;
			case 2:
				String nameOfAuthor = dialog.readString("Skriv namn på författaren");
				Book b = register.remove(nameOfAuthor);
				dialog.printString(b.getAuthor() + " böcker är nu borttagna");
				break;
			case 3:
				String searchWord = dialog.readString("Skriv sök ord");
				String result = register.searchByAuthor(searchWord);
				dialog.printString(result);
				break;
			case 4:
				String t = dialog.readString("Skriv önskad titel");
				String titles = register.searchByTitle(t);
				dialog.printString(titles);
				break;
			case 5:
				String filename = dialog.readString("Skriv filsnamn");
				register.readFromFile(filename);
				break;
			case 6:
				String tofile = dialog.readString("Skriv filsnamn");
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
