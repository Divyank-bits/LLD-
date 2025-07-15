package library_management;

import java.util.*;

public class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private int totalCopies;
    private int availableCopies;
    private List<BookCopy> copies;

    // public Book (String id, String title, String author, String category, int totalCopies, int availableCopies) {
    //     this.id = id;
    //     this.title = title;
    //     this.author = author;
    //     this.category = category;
    //     this.totalCopies = totalCopies;
    //     this.availableCopies = availableCopies;
    //     copies = new ArrayList<>();
    // }

    public String getId() { return id;}
    public String getTitle() { return title;}
    public String getAuthor() { return author;}
    public String getCategory() { return category;}
    public int getTotalCopies() { return totalCopies;}
    public int getAvailableCopies() { return availableCopies;}

    public BookCopy createBookCopy(String copyId) {
        BookCopy bc = new BookCopy(copyId, id);
        copies.add(bc);
        totalCopies+=1;
        availableCopies+=1;
        return bc;
    }

    public BookCopy getBookCopy() {
        for(BookCopy bc: copies) {
            if(bc.getStatus().equals("available")) {
                bc.setStatus("borrowed");
                availableCopies -=1;
                return bc;
            }
        
        }
        return null;
    }

    public BookCopy getBookCopyById(String copyId) {
        for (BookCopy bc : copies) {
            if (bc.getCopyId().equals(copyId)) {
                return bc;
            }
        }
        return null;
    }
    public void incrementAvailableCopies() {
        availableCopies += 1;
    }


}
