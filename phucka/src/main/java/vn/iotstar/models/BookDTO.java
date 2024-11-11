package vn.iotstar.models;

import java.sql.Date;

public class BookDTO {
    private int bookId; // Thêm trường id (hoặc bookId)
    private String coverImage;
    private String title;
    private String isbn;
    private String authorName;
    private String publisher;
    private Date publishDate;
    private int quantity;
    private int slReview;

    // Constructor
    public BookDTO(int bookId, String coverImage, String title, String isbn, String authorName, String publisher,
                   Date publishDate, int quantity, int slReview) {
        this.bookId = bookId; // Thêm id vào constructor
        this.coverImage = coverImage;
        this.title = title;
        this.isbn = isbn;
        this.authorName = authorName;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.quantity = quantity;
        this.slReview = slReview;
    }

    // Getter and Setter cho bookId
    public int getBookId() {
        return bookId;
    }

    public BookDTO() {
		super();
	}

	public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    // Getter và Setter cho các trường khác
    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSlReview() {
        return slReview;
    }

    public void setSlReview(int slReview) {
        this.slReview = slReview;
    }

    public BookDTO(String coverImage, String title, String isbn, String authorName, String publisher, Date publishDate,
			int quantity, int slReview) {
		super();
		this.coverImage = coverImage;
		this.title = title;
		this.isbn = isbn;
		this.authorName = authorName;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.quantity = quantity;
		this.slReview = slReview;
	}

	// Optional: Override toString() to make debugging easier
    @Override
    public String toString() {
        return "BookDTO{" +
                "bookId=" + bookId +  // Thêm bookId vào toString
                ", coverImage='" + coverImage + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishDate=" + publishDate +
                ", quantity=" + quantity +
                ", slReview=" + slReview +
                '}';
    }
}
