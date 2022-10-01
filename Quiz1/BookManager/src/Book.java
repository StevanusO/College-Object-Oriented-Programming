
public class Book {
	private String id;

	private int price;

	private int totalChapter;

	private String type;

	private String title;
	
	public Book(String id, String title, String type, int price, int totalChapter) {
		this.id = id;
		this.title = title;
		this.type = type;
		this.price = price;
		this.totalChapter = totalChapter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTotalChapter() {
		return totalChapter;
	}

	public void setTotalChapter(int totalChapter) {
		this.totalChapter = totalChapter;
	}
	
	
}
