package parama.com.schoolpluscommunity;

import java.util.ArrayList;

/**
 * Created by Farandi Kusumo on 15-Aug-17.
 */

public class Notification {

    public String title;
    public String subtitle;

    public static ArrayList<Notification> getNotificationFromSampleData(){
        final ArrayList<Notification> notificationArrayList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Notification notification = new Notification();

            notification.title = "Lorem Ipsum Dolor Sit" + i;
            notification.subtitle = "Subtitle" + i ;

            notificationArrayList.add(notification);
        }
        return notificationArrayList;
    }
}
