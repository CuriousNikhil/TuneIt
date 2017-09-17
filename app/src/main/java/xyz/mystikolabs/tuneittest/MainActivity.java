package xyz.mystikolabs.tuneittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import xyz.mystikolabs.tuneit.StopToneListener;
import xyz.mystikolabs.tuneit.TuneIt;

public class MainActivity extends AppCompatActivity {

    private EditText frequency,duration,volume;
    private Button play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frequency = (EditText)findViewById(R.id.frequency);
        duration = (EditText)findViewById(R.id.duration);
        volume = (EditText)findViewById(R.id.volume);

        play = (Button) findViewById(R.id.play);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    int freq = Integer.parseInt(frequency.getText().toString().trim());
                    int time = Integer.parseInt(duration.getText().toString().trim());
                   // int vol = Integer.parseInt(volume.getText().toString().trim());
                    //setting the max volume
                    float vol = 1.0f;


                    //and all you have to do is to just use the method as follows
                    //bang ..That's it!
                    TuneIt.getInitialised().create(freq, time, vol, new StopToneListener() {
                        @Override
                        public void onTrackStopped() {
                            Toast.makeText(MainActivity.this, "Track stopped!", Toast.LENGTH_SHORT).show();
                        }
                    });




                }catch (Exception e){

                    e.printStackTrace();

                }


            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
