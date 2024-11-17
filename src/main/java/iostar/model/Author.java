package iostar.model;

import java.sql.Date;

public class Author {
    private int authorId;
    private String authorName;
    private Date dateOfBirth;

    // Constructor không có tham số
    public Author() {
    }
 // Constructor có tham số
    public Author(int authorId, String authorName, Date dateOfBirth) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.dateOfBirth = dateOfBirth;
    }

    // Getter và Setter cho authorId
    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    // Getter và Setter cho authorName
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    // Getter và Setter cho dateOfBirth
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Phương thức toString để hiển thị thông tin của Author
    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

