package vn.iotstar.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;



public class BookModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookid;
	private int isbn;
	private String title;
	private String publisher;
	private  BigDecimal price;
	private String description;
	private Date publish_date;
	private String cover_image;
	private int quantity;
	
	public BookModel() {
		super();
	}
	public BookModel(int bookid, int isbn, String title, String publisher, BigDecimal price, String description,
			Date publish_date, String cover_image, int quantity) {
		super();
		this.bookid = bookid;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.publish_date = publish_date;
		this.cover_image = cover_image;
		this.quantity = quantity;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}
	public String getCover_image() {
		return cover_image;
	}
	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "BookModel [bookid=" + bookid + ", isbn=" + isbn + ", title=" + title + ", publisher=" + publisher
				+ ", price=" + price + ", description=" + description + ", publish_date=" + publish_date
				+ ", cover_image=" + cover_image + ", quantity=" + quantity + "]";
	}
	
	
	
}
