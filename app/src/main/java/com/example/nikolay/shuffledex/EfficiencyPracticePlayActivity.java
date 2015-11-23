package com.example.nikolay.shuffledex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class EfficiencyPracticePlayActivity extends AppCompatActivity {
    private Integer currentStreak = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efficiency_practice_play);
        ArrayList<String> chosenFlourishes = getIntent().getStringArrayListExtra("chosenFlourishes");
        Integer streakNumber = getIntent().getIntExtra("streakNumber", 3);
        if (streakNumber == 0) {
            streakNumber = 3;
        }

        TextView currentFlourish = (TextView) findViewById(R.id.currentFlourish);
        currentFlourish.setText(chosenFlourishes.get(0));

        TextView streakCount = (TextView) findViewById(R.id.streakCount);
        streakCount.setText(streakNumber.toString());

        TextView currentStreakCount = (TextView) findViewById(R.id.currentStreak);
        currentStreakCount.setText(currentStreak.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_efficiency_practice_play, menu);
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

    public void testVariables(View view) {
        TextView currentFlourish = (TextView) findViewById(R.id.currentFlourish);
        TextView streakCount = (TextView) findViewById(R.id.streakCount);
        ArrayList<String> chosenFlourishes = getIntent().getStringArrayListExtra("chosenFlourishes");
        Integer streakNumber = getIntent().getIntExtra("streakNumber", 3);
        if (streakNumber == 0) {
            streakNumber = 3;
        }
        currentFlourish.setText(chosenFlourishes.get(1));
        streakNumber += 1;
        streakCount.setText(streakNumber.toString());
        Toast.makeText(EfficiencyPracticePlayActivity.this, "" + streakNumber, Toast.LENGTH_SHORT).show();
        for (int i = 0; i < chosenFlourishes.size(); i++) {
            Toast.makeText(EfficiencyPracticePlayActivity.this, chosenFlourishes.get(i), Toast.LENGTH_SHORT).show();
        }
    }

    public void onSuccessButtonClick(View view) {
        ArrayList<String> chosenFlourishes = getIntent().getStringArrayListExtra("chosenFlourishes");
        Integer streakNumber = getIntent().getIntExtra("streakNumber", 3);
        if (streakNumber == 0) {
            streakNumber = 3;
        }

        TextView currentFlourish = (TextView) findViewById(R.id.currentFlourish);
        TextView currentStreakText = (TextView) findViewById(R.id.currentStreak);
        currentStreak++;
        currentStreakText.setText(currentStreak.toString());

        if (currentStreak > streakNumber) {
            currentStreak = 1;
            currentStreakText.setText(currentStreak.toString());
            // *TO-DO - Change flourish
        }
    }

    public void onFailButtonClick(View view) {
        TextView currentStreakText = (TextView) findViewById(R.id.currentStreak);
        currentStreak = 1;
        currentStreakText.setText(currentStreak.toString());
    }
}