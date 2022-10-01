package models;

public class statueToys extends generalToys {

	private String materials;

	public statueToys(String name, String type, int recommendedAge, String materials) {
		super(name, type, recommendedAge);
		this.materials = materials;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}

	@Override
	public int calculatePrice() {
		// TODO Auto-generated method stub
		if(materials.equals("PVC"))
			return (1000000 + (recommendedAge * 300000));
		return (5000000 + (recommendedAge * 300000));
	}

	@Override
	public void displayToConsole() {
		// TODO Auto-generated method stub
//		System.out.println(name + " " + type + " " + calculatePrice() + " " + recommendedAge + "+ - " + materials);
		System.out.printf("%-11s %-8s %-20d %-17s %-15s %-10s\n", name, type, calculatePrice(), recommendedAge + "+", "-",  materials);
	}
	

}
