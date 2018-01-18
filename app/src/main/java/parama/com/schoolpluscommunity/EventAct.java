package parama.com.schoolpluscommunity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventAct extends AppCompatActivity {

    CalendarView calendarView;
    ListView    eventList;

    static final String[] SAMPLES = new String[]{"Event 1", "Event 2", "Event 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        calendarView = (CalendarView)findViewById(R.id.calendarView);
        eventList = (ListView)findViewById(R.id.list_event);

        final ArrayList<String> eventArrayList = new ArrayList<>();
        for (int i = 0; i< SAMPLES.length; i++){
            eventArrayList.add(SAMPLES[i]);
        }

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,eventArrayList);
        eventList.setAdapter(adapter);

        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                view.animate().setDuration(2000).alpha(0).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        eventArrayList.remove(item);
                        adapter.notifyDataSetChanged();
                        view.setAlpha(1);
                    }
                });
            }
        });

    }
}
