// import NotificationContent;
import java.util.Map;

public class Notification {
  private NotificationContent n1;
  
  public Notification(NotificationContent n1) {
    this.n1 = n1;
  }

  public Map<String, String> getNotification() {
    return n1.getMessage();
  }
}
