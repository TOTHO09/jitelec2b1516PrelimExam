package tech.sidespell.prelimexam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


     private TextView tvTimer,tvSeekbar;
     private SeekBar seekbar;
     private ToggleButton btnSwitch;
    private RadioButton Rincrement,Rdecrement;
    private int timeRemaining;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvTimer = (TextView) findViewById(R.id.tvTimer);

        btnSwitch = (ToggleButton) findViewById(R.id.btnSwitch);

        seekbar = (SeekBar) findViewById(R.id.seekBar);
        tvSeekbar = (TextView) findViewById(R.id.tvSeekbar);
        Rincrement = (RadioButton) findViewById(R.id.Rincrement);
        Rdecrement = (RadioButton) findViewById(R.id.Rdecrement);

        btnSwitch.setOnCheckedChangeListener(this);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeekbar.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       if (isChecked)
       {
            //TODO: Start
           final Handler handler = new Handler();

           Runnable runnable = new Runnable() {
               @Override
               public void run() {
                   int num = Integer.valueOf(tvSeekbar.getText().toString());
                   timeRemaining += 1;
                   tvTimer.setText(timeRemaining + "");

                   if (timeRemaining > 0) {
                       handler.postDelayed(this, num);
                   }
               }
           };
           handler.postDelayed(runnable, 1000);
       }
        else
       {
           tvTimer.setText(timeRemaining + "");
           //TODO: OFF
       }

    }
}
