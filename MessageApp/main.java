import java.util.Map;

public class main {
  public static void main(String[] args) {
        System.out.println("Hello World!");
        NotificationContent noti= new NotificationContent("First Message", "Let's test message");
        Notification n1 = new Notification(noti);
        Map<String,String> notification = n1.getNotification();
        System.out.println(notification.get("body"));
    }
}
