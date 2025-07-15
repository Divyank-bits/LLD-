package library_management;

public class Main {
    public static void main(String[] args) {
        // new member
        Member m1 = new Member("m1","Divyank","member",5);
        //new Book
        Book b1 = new Book();
        b1.addBook("b1", "Harry Potter 1", "JK Rowling", "fiction");
        //bookcopies
        BookCopy hp1 = new BookCopy("hp1", b1.getId());
        BookCopy hp2 = new BookCopy("hp2", b1.getId());
        BookCopy hp3 = new BookCopy("hp3", b1.getId());

        MemberService mService = new MemberService(m1);
    }
}
