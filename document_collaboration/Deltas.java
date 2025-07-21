package document_collaboration;

public class Deltas {
  private String operation;
  private int position;
  private int length;
  private String content;

  public Deltas ( String operation, int position, String content) {
    this.content = content;
    this.operation = operation;
    this.position = position;
    this.length = length;
  }

  public String apply(String baseContent) {
    switch (operation) {
      case "INSERT":
        return baseContent.substring(0,position) + content + baseContent.substring(position+1);
      case "DELETE":
        return baseContent.substring(0,position) +  baseContent.substring(position+length);
      case "RETAIN": 
        return baseContent;
      default:
        return baseContent;
    }
  }
}
