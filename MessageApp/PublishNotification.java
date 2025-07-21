package MessageApp;

import java.util.*;

public class PublishNotification {
  private Queue<Notification> queue = new LinkedList<>();

  public void addNotification (Notification n1) {
    queue.add(n1);
  }
  public Queue<Notification> getAllNotifications() {
    return queue;
  }

}

