package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

import component.Item;
import component.electronicItem;
import component.nonElectronicItem;
import mySQLConnect.Connect;
import packageTransaction.Package;

public class Main {

	void printMenu() {
		System.out.println("Welcome to J&T Express");
		System.out.println();
		System.out.println("====================");
		System.out.println("1. Create Delivery");
		System.out.println("2. View Delivery");
		System.out.println("3. Delete Delivery");
		System.out.println("4. Exit");
		System.out.println();
		System.out.println();
		System.out.print(">> ");
	}
	
	int tryCatch() {
		int test = -1;
		try {
			test = scan.nextInt();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			scan.nextLine();
		}
		return test;
	}
	
	void loadItemData() {
		itemData.clear();
		String query = "SELECT * FROM `electronicitem`";
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String itemID = rs.getString(1);
				String itemName = rs.getString(2);
				int weight = rs.getInt(3);
				int warranty = rs.getInt(4);
				electronicItem ei = new electronicItem(itemID, itemName, weight, warranty);
				itemData.add(ei);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		query = "SELECT * FROM `nonelectronicitem`";
		ps = con.prepareStatement(query);
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String itemID = rs.getString(1);
				String itemName = rs.getString(2);
				int weight = rs.getInt(3);
				int fragile = rs.getInt(4);
				nonElectronicItem nei = new nonElectronicItem(itemID, itemName, weight, fragile);
				itemData.add(nei);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	Item getItem(int idx) {
		int count = 0;
		for(Item i : itemData) {
			count++;
			if(count == idx) return i;
		}
		return null;
	}
	
	Item getItemById(String id) {
		for(Item i : itemData) 
			if(i.getItemID().equals(id)) return i;
		
		return null;
	}
	
	String generateTrId() {
		String query = "SELECT * FROM `package` ORDER BY packageID DESC LIMIT 1";
		PreparedStatement ps = con.prepareStatement(query);
		String id = "";
		try {
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getString("packageID");
				String idNum = id.substring(2, id.length());
				int lastId = Integer.parseInt(idNum);
				lastId++;
				
				if(lastId < 10) 
					id = "PI00" + lastId;
				else if(lastId > 9 && lastId < 100)
					id = "PI0" + lastId;
				else 
					id = "PI" + lastId;
			} else id = "PI001";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	void loadPackage() {
		packageData.clear();
		String query = "SELECT * FROM `package`";
		PreparedStatement ps = con.prepareStatement(query);
		try {
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String packageID = rs.getString(1);
				String itemID = rs.getString(2);
				String recipName = rs.getString(3);
				String recipAddress = rs.getString(4);
				String recipEmail = rs.getString(5);
				Package pck = new Package(packageID, itemID, recipName, recipAddress, recipEmail);
				packageData.add(pck);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Package getPackage(int idx) {
		int i = 0;
		for(Package p: packageData) {
			i++;
			if(i == idx) return p;
		}
		return null;
	}
	
	public Main() {
		int choose = -1;
		do {
			printMenu();
			choose = tryCatch();
			
			switch(choose) {
			case 1:
				loadItemData();
				createDelivery();
				break;
			case 2:
				viewDelivery();
				break;
			case 3:
				deleteDelivery();
				break;
			case 4:
				return;
			}
		}while(true);
	}
	
	Connect con = Connect.getConnection();
	Scanner scan = new Scanner(System.in);
	Vector<Item> itemData = new Vector<>();
	Vector<Package> packageData = new Vector<>();
	void createDelivery() {
		int lastId = 0;
		System.out.println("No Name ID Electronic Weight Price Warranty Fragile");
		for(Item i : itemData) {
			lastId++;
			System.out.print(lastId + " ");
			i.display();
			
		}
		int chooseItem = -1;
		do {
			System.out.print("Choose Item [1 - " + lastId + "]: ");
			chooseItem = tryCatch();
		}while(!(chooseItem > 0 && chooseItem < lastId + 1));
		
		String recipientName = "";
		do {
			System.out.print("Input Recipient Name [5 - 10] (Inclusive): ");
			recipientName = scan.nextLine();
			if((recipientName.length() > 4 && recipientName.length() < 11)) {
//				System.out.println("MasukNama");
				break;
			}
		}while(true);
		
		String recipientAddress = "";
		do {
			System.out.print("Input Recipient Address [8 - 25] (Inclusive): ");
			recipientAddress = scan.nextLine();
			if(recipientAddress.length() >= 8 && recipientAddress.length() <= 25) {
//				System.out.println("Masuk");
				break;
			}
		}while(true);
		
		String recipientEmail = "";
		do {
			System.out.println("Input an email [must ends with '@gmail.com']: ");
			recipientEmail = scan.nextLine();
		}while(!(recipientEmail.endsWith("@gmail.com")));
		
		Item i = getItem(chooseItem);
		if(i instanceof electronicItem) {
			System.out.println("===============");
			System.out.println("Detail Package");
			System.out.println("===============");
			System.out.println("Recipient : " + recipientName);
			System.out.println("Name      : " + i.getItemName());
			System.out.println("Warranty  : " + ((electronicItem)i).getWarranty());
			System.out.println("Price     : " + (15000*(Math.round(i.getWeight()))));
			System.out.println("===============");
		}else if(i instanceof nonElectronicItem) {
			String fragile = "";
			if(((nonElectronicItem)i).getFragile() == 1) fragile = "Yes";
			else fragile = "No";
			System.out.println("===============");
			System.out.println("Detail Package");
			System.out.println("===============");
			System.out.println("Recipient : " + recipientName);
			System.out.println("Name      : " + i.getItemName());
			System.out.println("Fragile   : " + fragile);
			System.out.println("Price     : " + (15000*(Math.round(i.getWeight()))));
			System.out.println("===============");			
		}
		
		String transactionId = generateTrId();
		//insert into packageTran
		String queryInsert = "INSERT INTO `package`(`packageID`, `itemID`, `recipientName`, `recipientAddress`, `userEmail`) VALUES "
				+ " (?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(queryInsert);
		try {
			ps.setString(1, transactionId);
			ps.setString(2, i.getItemID());
			ps.setString(3, recipientName);
			ps.setString(4, recipientAddress);
			ps.setString(5, recipientEmail);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n\n\n\n");
		System.out.println("[Press Enter to Continue]");
		scan.nextLine();
		
		loadPackage();
	}
	
	void viewDelivery() {
		loadPackage();
		if(packageData.isEmpty())
			System.out.println("There's No Transaction");
		else {
			int countNum = 0;
			System.out.println("No Name ID Electronic Weight Price Warranty Fragile");
			for(Package pck: packageData) {
				countNum++;
				Item i = getItemById(pck.getItemID());
				System.out.println(countNum + " " + pck.getPackageId() + " " + i.getItemName() + " " + i.getWeight() + " " + pck.getRecipientName() + " " + pck.getRecipientAddress() + " " + pck.getUserEmail());
			}
		}
		System.out.println("Wanna go Back ? [press enter]");
		scan.nextLine();
		
	}
	
	void deleteDelivery() {
		loadPackage();
		if(packageData.isEmpty())
			System.out.println("There's No Transaction");
		else {
			int countNum = 0;
			for(Package pck: packageData) {
				countNum++;
				Item i = getItemById(pck.getItemID());
				System.out.println(countNum + " " + pck.getPackageId() + " " + i.getItemName() + " " + i.getWeight() + " " + pck.getRecipientName() + " " + pck.getRecipientAddress() + " " + pck.getUserEmail());
			}
			
			int numToDel = -1;
			do {
				System.out.print("Input Number to Delete (1 - " + countNum + "): ");
				numToDel = tryCatch();
			}while(!(numToDel > 0 && numToDel < countNum+1));
			Package pckTemp = getPackage(numToDel);
			packageData.remove(numToDel-1);
			
			//DELETE from DATABASE
			String query = "DELETE FROM `package` WHERE packageID = ?";
			PreparedStatement ps = con.prepareStatement(query);
			try {
				ps.setString(1, pckTemp.getPackageId());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Wanna go Back ? [press enter]");
		scan.nextLine();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
