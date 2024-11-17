package iostar.model;

import java.util.Date;
import java.util.List;

public class Book {
	 private int  bookid;

	    private String isbn;
	    private String title;
	    private String publisher;
	    private Double price;
	    private String description;
	    private Date publish_date;
	    private String cover_image;
	    private Integer quantity;
	    private List<Author> authors;
	    private List<Rating> ratings;
	    
	    
	    
		public Book() {
		}
		public Book(int bookid, String isbn, String title, String publisher, Double price, String description,
				Date publish_date, String cover_image, Integer quantity) {
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
		
		public List<Rating> getRatings() {
			return ratings;
		}
		public void setRatings(List<Rating> ratings) {
			this.ratings = ratings;
		}
		public List<Author> getAuthors() {
			return authors;
		}
		public void setAuthors(List<Author> authors) {
			this.authors = authors;
		}
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
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
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
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
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
	    
}
