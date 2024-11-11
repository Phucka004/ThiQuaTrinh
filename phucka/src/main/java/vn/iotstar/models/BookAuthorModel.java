package vn.iotstar.models;

import java.io.Serializable;

public class BookAuthorModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookid;
	private int author_id;
	public BookAuthorModel() {
		super();
	}
	public BookAuthorModel(int bookid, int author_id) {
		super();
		this.bookid = bookid;
		this.author_id = author_id;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	@Override
	public String toString() {
		return "BookAuthorModel [bookid=" + bookid + ", author_id=" + author_id + "]";
	}
	
	

}
