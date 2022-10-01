import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	void menu() {
		System.out.println("Book's Manager");
		System.out.println("1. View Books");
		System.out.println("2. Insert Book");
		System.out.println("3. Delete Book");
		System.out.println("4. Exit");
		System.out.print(">> ");
	}
	
	void viewBooks() {
		if(arrLiBook.isEmpty()) {
			System.out.println("There is no book yet.");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		else {
			int len = arrLiBook.size();
			System.out.println("=============================================================");
			System.out.printf("| %-6s| %-6s| %-11s| %-11s| %-16s|\n", "No", "Id", "Title", "Price", "Total Chapter(s)");
			System.out.println("=============================================================");
			for(int i = 0; i < len; i++) {
				System.out.printf("| %-6s| %-6s| %-11s| %-11d| %-16d|\n", i+1, arrLiBook.get(i).getId(), arrLiBook.get(i).getTitle(), arrLiBook.get(i).getPrice(), arrLiBook.get(i).getTotalChapter());
			}
			System.out.println("=============================================================");
			System.out.println("Press enter to continue...");
			scan.nextLine();			
		}
	}
	
	
	void insertBook() {
		String title;
		do {
			System.out.print("Input title [5-10 Characters]: ");
			title = scan.nextLine();
		}while(!(title.length() >= 5 && title.length() <=10));
		
		String type;
		do {
			System.out.print("Input type [Novel|Comic Case Sensitive]: ");
			type = scan.nextLine();
		}while(!(type.equals("Novel") || type.equals("Comic")));
		
		int chapter = -1;
		do {
			System.out.print("Input number of chapter(s) [1-10]: ");
			chapter = scan.nextInt(); scan.nextLine();
		}while(!(chapter >= 1 && chapter <=10));
		
		String id;
		id = "BK" + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10);
		
		int price = -1;
		if(type.equals("Novel")) price = 100000 + chapter * 1000;
		else if(type.equals("Comic")) price = 50000 + chapter * 1000;
		arrLiBook.add(new Book(id, title, type, price, chapter));
		System.out.println("Book created!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	void deleteBooks() {
		if(arrLiBook.isEmpty()) {
			System.out.println("There is no book yet.");
			System.out.println("Press enter to continue...");
			scan.nextLine();
			return;
		}
		else {
			int delIdx = -1, len = arrLiBook.size();
			do {
				System.out.println("=============================================================");
				System.out.printf("| %-6s| %-6s| %-11s| %-11s| %-16s|\n", "No", "Id", "Title", "Price", "Total Chapter(s)");
				System.out.println("=============================================================");
				for(int i = 0; i < len; i++) {
					System.out.printf("| %-6s| %-6s| %-11s| %-11d| %-16d|\n", i+1, arrLiBook.get(i).getId(), arrLiBook.get(i).getTitle(), arrLiBook.get(i).getPrice(), arrLiBook.get(i).getTotalChapter());
				}
				System.out.println("=============================================================");
				System.out.println("Press enter to continue...");		
				System.out.print("Choose index to be delete [1.." + len + "]: ");
				delIdx = scan.nextInt(); scan.nextLine();
			}while(!(delIdx >= 1 && delIdx <=len));
			arrLiBook.remove(delIdx-1);
			viewBooks();
		}
	}
	
	public Main() {
		arrLiBook.add(new Book("BK001", "Percy J", "Novel", 110000, 10));
		arrLiBook.add(new Book("BK002", "One Piece", "Comic", 60000, 10));
		arrLiBook.add(new Book("BK004", "Superman", "Novel", 110000, 10));
		arrLiBook.add(new Book("BK005", "Naruto", "Comic", 60000, 10));
		arrLiBook.add(new Book("BK028", "Harry P", "Novel", 108000, 8));
		// TODO Auto-generated constructor stub
		int idx = -1;
		do {
			menu();
			idx = scan.nextInt(); scan.nextLine();
			
			switch(idx) {
			case 1:
				viewBooks();
				break;
			
			case 2:
				insertBook();
				break;
				
			case 3:
				deleteBooks();
				break;
				
			case 4:
				break;
			}
		}while(idx!=4);
	}
	ArrayList<Book> arrLiBook = new ArrayList<Book>();
	bookDetail bkDetail;
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Main();
	}

}
