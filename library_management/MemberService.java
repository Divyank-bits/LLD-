package library_management;

import java.time.*;
import java.util.*;

public class MemberService {

    private Member member;
    private Book book;

    public MemberService(Member member) {
        this.member = member;
        // this.book = book;
        this.book = new Book();
    }

    public void borrowBook(String bookId) {
        int issuedBooks = member.getIssuedBook();
        // System.out.println(limit);
        int borrowingLimit = member.getBorrowingLimit();
        if(issuedBooks==borrowingLimit) {
            throw new IllegalStateException("Limit is over");
        }
        BookCopy bc = book.getBookCopy();
        if(bc.equals(null)) {
            throw new IllegalStateException("No available copies");
        }
        LocalDate today = LocalDate.now();
        Date borrowDate = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date dueDate    = Date.from(today.plusDays(5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        bc.setBorrowDate(borrowDate);
        bc.setBorrowedBy(member.getId());
        bc.setDueDate(dueDate);
    }

    public void returnBook(String copyId) {
        // Step 1: Find the copy from the book
        BookCopy bc = book.getBookCopyById(copyId);
        if (bc == null) {
            throw new IllegalArgumentException("Invalid copy ID");
        }

        // Step 2: Check if it was actually borrowed
        if (!"borrowed".equals(bc.getStatus())) {
            throw new IllegalStateException("Book copy is not currently borrowed");
        }

        // Step 3: Reset BookCopy state
        bc.setStatus("available");
        bc.setBorrowDate(null);
        bc.setDueDate(null);
        bc.setBorrowedBy(null);

        // Step 4: Update book's availableCopies count
        book.incrementAvailableCopies();

        // Step 5 (optional): Decrease member's issuedBooks count if you're tracking it
        // member.decrementIssuedBooks(); // if you have such a method
    }


}
