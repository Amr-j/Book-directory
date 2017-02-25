public class BookRegister {

	public static void main(String[] args) {
		Dialog dialog = new Dialog();
		Register register = new Register();
		
		
		while(true) {
			int command = dialog.readInt("Meny" + "\n"
 					+ "1: S�tt in en ny bok" + "\n"
 					+ "2: Tag bort b�cker" + "\n"
 					+ "3: S�k titel fr�n f�rfattare/del av f�rfattare" + "\n"
 					+ "4: S�k bok fr�n titel" + "\n"
 					+ "5: L�s titlar fr�n en fil" + "\n"
 					+ "6: Skriv titlar till en fil" + "\n"
 					+ "7: Visa b�cker sorterade efter f�rfattare" + "\n"
 					+ "8: Visa b�cker sorterade efter titel" + "\n");
			
			switch(command){
			case 1:
				String author = dialog.readString("Skriv namn p� f�rfattaren");
				String title = dialog.readString("Skriv titel");
				Book book = new Book(author, title);
				register.insert(book);
				break;
			case 2:
				String nameOfAuthor = dialog.readString("Skriv namn p� f�rfattaren");
				Book b = register.remove(nameOfAuthor);
				dialog.printString(b.getAuthor() + " b�cker �r nu borttagna");
				break;
			case 3:
				String searchWord = dialog.readString("Skriv s�k ord");
				String result = register.searchByAuthor(searchWord);
				dialog.printString(result);
				break;
			case 4:
				String t = dialog.readString("Skriv �nskad titel");
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
