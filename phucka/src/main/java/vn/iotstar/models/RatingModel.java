package vn.iotstar.models;

import java.io.Serializable;

public class RatingModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userid;
	private int bookid;
	private int rating;
	private String review_text;
	public RatingModel() {
		super();
	}
	public RatingModel(int userid, int bookid, int rating, String review_text) {
		super();
		this.userid = userid;
		this.bookid = bookid;
		this.rating = rating;
		this.review_text = review_text;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
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
	@Override
	public String toString() {
		return "RatingModel [userid=" + userid + ", bookid=" + bookid + ", rating=" + rating + ", review_text="
				+ review_text + "]";
	}
	
	

}
