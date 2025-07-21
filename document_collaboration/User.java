package document_collaboration;

public class User {
  private int uid;
  private String name;
  // private String email;

  public User(int uid, String name) {
    this.uid = uid;
    this.name = name;
    // this.email = email;
  }

  public int getUserById () { return uid;};
  public String getUserByname () { return name;};
}