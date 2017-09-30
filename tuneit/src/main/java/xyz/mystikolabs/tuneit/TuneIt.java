package xyz.mystikolabs.tuneit;


import android.os.Handler;
import java.util.logging.LogRecord;

/**
 * Created by nikhya on 17/9/17.
 *
 *The main class to initialize everything
 *
 */

public class TuneIt {

    private static final TuneIt INITIALISE = new TuneIt();
    private RunToneProcess runToneProcess;
    private boolean isProcessRunning = false;
    private final Handler stopProcess;

    private TuneIt(){
        stopProcess = new Handler();

    }

    //create instance of the TuneIt class calling this method on any activity or fragment
    public static TuneIt getInitialised(){
        return INITIALISE;
    }


    //stop the current running track or tone
    public void stop(){
        if (runToneProcess != null){
            runToneProcess.stopPlaying();
            runToneProcess.interrupt();
            runToneProcess = null;
            isProcessRunning = false;
        }
    }


    //generate the sound by calling this method over the instance of the cl
    /**
    * @params frequency,duration, toneStoppedlistener and volume
    **/
    public void create(int frequency,int duration,float volume,StopToneListener listener){

        if (!isProcessRunning){
            stop();
            runToneProcess = new RunToneProcess(duration,frequency,volume,listener);
            runToneProcess.start();
            isProcessRunning = true;
            stopProcess.postDelayed(new Runnable() {
                @Override
                public void run() {

                    stop();

                }
            },duration*10);

        }

    }


}
