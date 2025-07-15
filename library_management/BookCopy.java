package library_management;

import java.util.Date;

public class BookCopy {
    private String copyId;
    private String bookId;
    private String status;
    private String borrowedBy;
    private Date borrowDate;
    private Date dueDate;

    public BookCopy(String copyId, String bookId) {
        this.copyId = copyId;
        this.bookId = bookId;
        borrowedBy = null;
        status = "available";
        borrowDate = null;
        dueDate = null;
    }

    public String getStatus() { return status;}
    public void setStatus(String status) { this.status = status;}

    public String getBorrowedBy() { return borrowedBy;}
    public void setBorrowedBy(String borrowedBy) { this.borrowedBy = borrowedBy;}

    public Date getBorrowDate() { return borrowDate;}
    public void setBorrowDate(Date borrowDate) { this.borrowDate = borrowDate;}

    public Date getDueDate() { return dueDate;}
    public void setDueDate(Date dueDate) { this.dueDate = dueDate;}

    public String getCopyId() { return copyId;}


     
}
