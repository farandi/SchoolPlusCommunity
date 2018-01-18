package parama.com.schoolpluscommunity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button notificationButton, profileButton, scheduleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        notificationButton = (Button)findViewById(R.id.notificationButton);
        profileButton = (Button)findViewById(R.id.profileButton);
        scheduleButton = (Button)findViewById(R.id.scheduleButton);

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),List.class);
                startActivity(i);
            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),EventAct.class);
                startActivity(i);
            }
        });
    }
}
