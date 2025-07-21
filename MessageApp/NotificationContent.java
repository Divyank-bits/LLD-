import java.util.Map;
import java.util.HashMap;

public class NotificationContent {
  private String title;
  private String body;
  private Map<String, String> notification;

  public NotificationContent(String title, String body) {
    this.title = title;
    this.body = body;
    this.notification = new HashMap<>();
    this.notification.put("title", title);
    this.notification.put("body", body);
  }

  public String getTitle() {
    return title;
  }

  public String getBody() {
    return body;
  }

  public void setMessage(Map<String, String> n1) {
    this.notification = n1;
  }
  
  public Map<String, String> getMessage() {
    return notification;
  }
}
