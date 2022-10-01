
public class bookDetail {
	String title;
	String type;
	int totalChapter;
	
	public String getTitle() {
		return title;
	}
	
	public bookDetail(String title, String type, int totalChapter) {
		super();
		this.title = title;
		this.type = type;
		this.totalChapter = totalChapter;
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
	public int getTotalChapter() {
		return totalChapter;
	}
	public void setTotalChapter(int totalChapter) {
		this.totalChapter = totalChapter;
	}
	
	
}
