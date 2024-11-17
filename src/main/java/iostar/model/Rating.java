package  iostar.model;
import java.io.Serializable;

public class Rating implements Serializable{
	private static final long serialVersionUID =1L;
	private int bookid;
    private int userId;
    private int rating;
    private String review_text;
    private User user;
    
    public Rating()
    {
    	
    }
	
	public Rating(int bookid, int userId, int rating, String review_text,User user) {
		this.bookid = bookid;
		this.userId = userId;
		this.rating = rating;
		this.review_text = review_text;
		this.user = user;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public int getBookid() {
		return bookid;
	}



	public void setBookid(int bookid) {
		this.bookid = bookid;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public String getReview_text() {
		return review_text;
	}



	public void setReview_text(String review_text) {
		this.review_text = review_text;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}