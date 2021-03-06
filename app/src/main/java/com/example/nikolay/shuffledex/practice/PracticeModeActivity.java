package com.example.nikolay.shuffledex.practice;

import android.content.Intent;
import android.provider.OpenableColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.nikolay.shuffledex.R;
import com.example.nikolay.shuffledex.practice.efficiency.EfficiencyPracticeAcitivty;
import com.example.nikolay.shuffledex.practice.speed.SpeedPracticeActivity;

public class PracticeModeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_mode);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practice_mode, menu);
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


    public void openEfficiencyPracticeMode(View view) {
        Intent intent = new Intent(PracticeModeActivity.this, EfficiencyPracticeAcitivty.class);
        startActivity(intent);
    }

    public void openSpeedPracticeMode(View view) {
        Intent intent = new Intent(PracticeModeActivity.this, SpeedPracticeActivity.class);
        startActivity(intent);
    }
}