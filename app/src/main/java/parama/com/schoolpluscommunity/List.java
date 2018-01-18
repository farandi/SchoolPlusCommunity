package parama.com.schoolpluscommunity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final ArrayList<Notification> notificationList = Notification.getNotificationFromSampleData();

        MenuListAdapter adapter = new MenuListAdapter(this, notificationList);

        mListView = (ListView)findViewById(R.id.notificationList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Notification selectedNotification = notificationList.get(position);

                Toast.makeText(List.this, selectedNotification.title, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
