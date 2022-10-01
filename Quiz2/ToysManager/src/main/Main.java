package main;

import java.util.Scanner;
import java.util.Vector;

import models.generalToys;
import models.gundamToys;
import models.statueToys;

public class Main {

	void toyManagerMenu() {
		System.out.println("Toy's Manager");
		System.out.println("1. View Toys");
		System.out.println("2. Insert Toy");
		System.out.println("3. Delete Toy");
		System.out.println("4. Exit");
		System.out.print(">> ");
	}
	
	int testIn() {
		int test = -1;
		try {
			test = scan.nextInt();
		} catch (Exception e) {
		} finally {
			scan.nextLine();
		}
		return test;
	}
	
	void insertToy() {
		String nameToy;
		do {
			System.out.print("Input name [5-10 Characters]: ");
			nameToy = scan.nextLine();
		}while(!(nameToy.length() > 4 && nameToy.length() < 11));
		
		int ageRecommendedForToy = -1;
		do {
			System.out.print("Input recommended age [1-20]: ");
			ageRecommendedForToy = testIn();
		}while(!(ageRecommendedForToy > 0 && ageRecommendedForToy < 21));
		
		String typeToy;
		do {
			System.out.print("Input toys type [Gundam|Statue]: ");
			typeToy = scan.nextLine();
		}while(!(typeToy.equals("Gundam") || typeToy.equals("Statue")));
	
		if(typeToy.equals("Statue")) {
			String materialToys;
			do {
				System.out.print("Input material [PVC|Resin]: ");
				materialToys = scan.nextLine();
			}while(!(materialToys.equals("PVC") || materialToys.equals("Resin")));
			
			dataToys.add(new statueToys(nameToy, typeToy, ageRecommendedForToy, materialToys));
		}else if(typeToy.equals("Gundam")) {
			String detailLevel;
			do {
				System.out.print("Input detail level [SD|HG|RG|MG|PG]: ");
				detailLevel = scan.nextLine();
			}while(!(detailLevel.equals("SD") || detailLevel.equals("HG") || detailLevel.equals("RG") || detailLevel.equals("MG") || detailLevel.equals("PG")));
			
			dataToys.add(new gundamToys(nameToy, typeToy, ageRecommendedForToy, detailLevel));
		}
		System.out.println("Toy inserted!");
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	void viewToys() {
		if(dataToys.isEmpty())
			System.out.println("There is no toy yet.");
		else {
			int idxDisplay = 0;
			System.out.printf("%-3s %-11s %-8s %-20s %-17s %-15s %-10s\n", "No", "Name", "Type", "Price", "Recommended Age", "Detail Level", "Material" );
			for (generalToys generalToys : dataToys) {
				System.out.printf("%-3d ", (idxDisplay+1));
				generalToys.displayToConsole();
				idxDisplay++;
			}
		}
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	
	void deleteToy() {
		if(dataToys.isEmpty())
			System.out.println("There is no toy yet.");
		else {
			int idxDisplay = 0;
			System.out.printf("%-3s %-11s %-8s %-20s %-17s %-15s %-10s\n", "No", "Name", "Type", "Price", "Recommended Age", "Detail Level", "Material" );
			for (generalToys generalToys : dataToys) {
				System.out.printf("%-3d ", (idxDisplay+1));
				generalToys.displayToConsole();
				idxDisplay++;
			}
			int idxToDel = -1;
			do {
				System.out.print("Choose index to be delete [1.." + idxDisplay + "]: ");
				idxToDel = testIn();
			}while(!(idxToDel > 0 && idxToDel < (idxDisplay+1)));
			
			dataToys.remove(idxToDel-1);
			
			idxDisplay = 0;
			System.out.printf("%-3s %-11s %-8s %-20s %-17s %-15s %-10s\n", "No", "Name", "Type", "Price", "Recommended Age", "Detail Level", "Material" );
			for (generalToys generalToys1 : dataToys) {
				System.out.printf("%-3d ", (idxDisplay+1));
				generalToys1.displayToConsole();
				idxDisplay++;
			}
			System.out.println("Press enter to continue...");
			scan.nextLine();
		}
	}
	
	public Main() {
		dataToys.add(new gundamToys("Wing 002", "Gundam", 3, "HG"));
		dataToys.add(new gundamToys("Barbatos", "Gundam", 15, "MG"));
		dataToys.add(new gundamToys("MK-4", "Gundam", 12, "PG"));
		dataToys.add(new statueToys("Luffy", "Statue", 15, "Resin"));
		dataToys.add(new statueToys("Zorro", "Statue", 15, "Resin"));
		dataToys.add(new statueToys("Luffy .Z", "Statue", 18, "Resin"));
		dataToys.add(new gundamToys("DJ-Wing G", "Gundam", 8, "HG"));
		int menuIdx = -1;
		do {
			toyManagerMenu();
			menuIdx = testIn();
			switch(menuIdx) {
			case 1:
				viewToys();
				break;
			case 2:
				insertToy();
				break;
			case 3:
				deleteToy();
				break;
			}
		}while(menuIdx != 4);
		
		
		
	}

	Vector<generalToys> dataToys = new Vector<generalToys>();
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
