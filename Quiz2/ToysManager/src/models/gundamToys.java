package models;

public class gundamToys extends generalToys {
	private String detailLevels;

	public gundamToys(String name, String type, int recommendedAge, String detailLevels) {
		super(name, type, recommendedAge);
		this.detailLevels = detailLevels;
	}

	public String getDetailLevels() {
		return detailLevels;
	}

	public void setDetailLevels(String detailLevels) {
		this.detailLevels = detailLevels;
	}

	@Override
	public int calculatePrice() {
		//MG and PG
		if(detailLevels.equals("MG") || detailLevels.equals("PG"))
			return (500000 + (recommendedAge * 30000));
		
		//SD, HG, PG
		return (100000 + (recommendedAge * 30000));
	}
	
	@Override
	public void displayToConsole() {
		// TODO Auto-generated method stub
//		System.out.println(name + " " + type + " " + calculatePrice() + " " + recommendedAge + "+ " + detailLevels + " " + "-");
//		System.out.println("No Name Type Price Recommended Age Detail Level Material");
		System.out.printf("%-11s %-8s %-20d %-17s %-15s %-10s\n", name, type, calculatePrice(), recommendedAge + "+", detailLevels,  "-" );
	}



}
