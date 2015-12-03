package com.example.nikolay.shuffledex.practice.efficiency;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nikolay.shuffledex.Flourish;
import com.example.nikolay.shuffledex.R;

import java.util.ArrayList;

public class EfficiencyPracticePlayActivity extends AppCompatActivity {
    Integer currentStreak = 1;
    Integer counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efficiency_practice_play);
        ArrayList<Flourish> chosenFlourishes = getIntent().getParcelableArrayListExtra("chosenFlourishes");
        Integer streakNumber = getIntent().getIntExtra("streakNumber", 3);
        if (streakNumber == 0) {
            streakNumber = 3;
        }

        TextView currentFlourish = (TextView) findViewById(R.id.currentFlourish);
        currentFlourish.setText(chosenFlourishes.get(0).getName());

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

    public void onSuccessButtonClick(View view) {
        ArrayList<Flourish> chosenFlourishes = getIntent().getParcelableArrayListExtra("chosenFlourishes");
        Integer streakNumber = getIntent().getIntExtra("streakNumber", 3);
        if (streakNumber == 0) {
            streakNumber = 3;
        }
        TextView currentFlourish = (TextView) findViewById(R.id.currentFlourish);
        TextView currentStreakText = (TextView) findViewById(R.id.currentStreak);
        currentStreak++;
        currentStreakText.setText(currentStreak.toString());

        if (currentStreak > streakNumber) {
            counter++;
            currentStreak = 1;
            currentStreakText.setText(currentStreak.toString());
            if (counter < chosenFlourishes.size()) {
                for (int i = counter; i < chosenFlourishes.size(); i++) {
                    for (int j = i; j < chosenFlourishes.size(); j++) {
                        currentFlourish.setText(chosenFlourishes.get(i).getName());
                        break;
                    }
                    break;
                }
            } else {
                Intent intent = new Intent(EfficiencyPracticePlayActivity.this, EfficiencyPracticeFinishActivity.class);
                startActivity(intent);
            }
        }
    }

    public void onFailButtonClick(View view) {
        TextView currentStreakText = (TextView) findViewById(R.id.currentStreak);
        currentStreak = 1;
        currentStreakText.setText(currentStreak.toString());
    }
}