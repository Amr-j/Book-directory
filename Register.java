import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Register {
	private ArrayList<Book> reg; 
	
	public Register() { 
		reg = new ArrayList<Book>();
	}
	
	public void insert(Book b){
		for (int i = 0; i < reg.size(); i++){
			Book temp = reg.get(i);
			int compare = b.getAuthor().toLowerCase().compareTo(temp.getAuthor().toLowerCase());
			if (compare < 0) { 
				reg.add(i, b);
				return;
			}
			//if (compare == 0) return;
		}
		reg.add(b);
	}
	
	public Book remove(String writer){
		int pos= 0;
		for (int i = 0; i < reg.size(); i++){
			Book temp = reg.get(i);
			if (temp.getAuthor().toLowerCase().compareTo(writer.toLowerCase()) == 0) {
				pos = i;
			}
		}
		return reg.remove(pos);
	}
	
	public String searchByAuthor(String word) {
		String help = word.toLowerCase();
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < reg.size(); i++) { 
			Book b = reg.get(i);
			if(b.getAuthor().toLowerCase().indexOf(help) >= 0){
				s.append(b.getAuthor() + "\n" + b.getTitle() + "\n" );
			}
		}
		return s.toString();
	}
	
	public String searchByTitle(String word) { 
		String help = word.toLowerCase();
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < reg.size(); i++) { 
			Book b = reg.get(i);
			if(b.getTitle().toLowerCase().indexOf(help) >= 0){
				s.append(b.getAuthor() + "\n" + b.getTitle() + "\n" );
			}
		}
		return s.toString();
	}
	
	public String listByAuthor() { 
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < reg.size(); i++) { 
			Book b = reg.get(i);
			s.append(b.getAuthor() + "\n" + b.getTitle() + "\n" );
		}
		
		return s.toString();
	}
	
	public String listByTitle() { 
		StringBuilder s = new StringBuilder();
		boolean[] help = new boolean[reg.size()];
		for(int i = 0; i < reg.size(); i++) { 
			String min = "zzzzzzzzzzzzzzzzzzz";
			int index = 0;
			for (int k = 0; k < reg.size(); k++) {
				if (!help[k] && reg.get(k).getTitle().toLowerCase().compareTo(min) < 0){
					min = reg.get(k).getTitle();
					index = k;
				}
			}
			help[index] = true;
			Book b = reg.get(index);
			s.append(b.getAuthor() + "\n" + b.getTitle() + "\n" );
		}
		
		
		return s.toString();
	}
	
	public void writeToFile(String filename){ 
		PrintWriter out = null;
		try {
			out = new PrintWriter(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte öppnas");
			System.exit(1);
		}
		for (int i = 0; i < reg.size(); i++) {
			Book b = reg.get(i);
			out.println(b.getAuthor());
			out.println(b.getTitle());
		}
		out.close();
	}
	
	public void readFromFile(String filename) { 
		Scanner scan = null;
		try {
			scan = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.err.println("Filen kunde inte öppnas");
			System.exit(1);
		}
		while(scan.hasNext()) {
			String author = scan.next();
			String title = scan.next();
			reg.add(new Book(author, title));
		}
	}

}
