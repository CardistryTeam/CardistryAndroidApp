package com.example.nikolay.shuffledex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void openSurvivalMode(View view) {
        Intent intent = new Intent(MainActivity.this, SurvivalModeActivity.class);
        startActivity(intent);
    }

    public void openVersusMode(View view) {
        Intent intent = new Intent(MainActivity.this, VersusModeActivity.class);
        startActivity(intent);
    }

    public void openPracticeMode(View view) {
        Intent intent = new Intent(MainActivity.this, PracticeModeActivity.class);
        startActivity(intent);
    }

    public void openScoreboard(View view) {
        Intent intent = new Intent(MainActivity.this, ScoreboardActivity.class);
        startActivity(intent);
    }

    public void openFlowgraph(View view) {
        Intent intent = new Intent(MainActivity.this, FlowgraphActivity.class);
        startActivity(intent);
    }
}
