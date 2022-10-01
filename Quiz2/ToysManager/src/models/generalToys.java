package models;

public abstract class generalToys {
	protected String name, type;
	protected int recommendedAge;
	public generalToys(String name, String type, int recommendedAge) {
		super();
		this.name = name;
		this.type = type;
		this.recommendedAge = recommendedAge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getRecommendedAge() {
		return recommendedAge;
	}
	public void setRecommendedAge(int recommendedAge) {
		this.recommendedAge = recommendedAge;
	}
	
	public abstract int calculatePrice();
	public abstract void displayToConsole();
}
