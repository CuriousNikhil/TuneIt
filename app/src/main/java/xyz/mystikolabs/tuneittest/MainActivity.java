package xyz.mystikolabs.tuneittest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import xyz.mystikolabs.tuneit.Frequency;
import xyz.mystikolabs.tuneit.StopToneListener;
import xyz.mystikolabs.tuneit.TuneIt;

public class MainActivity extends AppCompatActivity {

    private SeekBar frequency,duration;
    private TextView hertz,seconds;
    private Button play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frequency = (SeekBar) findViewById(R.id.frequency);
        duration = (SeekBar) findViewById(R.id.duration);
        hertz = (TextView)findViewById(R.id.hertz);
        seconds = (TextView)findViewById(R.id.seconds);

        play = (Button) findViewById(R.id.play);


        frequency.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                hertz.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        duration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                seconds.setText(String.valueOf(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    int freq = frequency.getProgress();
                    int time = duration.getProgress();

                   // int vol = Integer.parseInt(volume.getText().toString().trim());
                    //setting the max volume
                    float vol = 1.0f;


                    //and all you have to do is to just use the method as follows
                    //bang ..That's it!

                    /*
                    * Here you can use a utility class "Frequency"
                    * Which is a static frequency constants of octave
                    * It contains Three levels of octave
                    * 1- high level frequency octave
                    * 2- mid level frequency octave
                    * 3- low level frequency octave
                    * */

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
