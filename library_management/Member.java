package library_management;

public class Member extends User {
    private int issuedBooks;
    private int borrowingLimit;
    private int totalFine;

    public Member(String id, String name, String role, int borrowingLimit) {
        super(id, name, role);
        issuedBooks = 0;
        this.borrowingLimit = borrowingLimit;
        totalFine = 0;
    }
    public int getIssuedBook() { return issuedBooks;}
    public int getBorrowingLimit() { return borrowingLimit;}

}