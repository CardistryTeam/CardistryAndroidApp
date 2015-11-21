package com.example.nikolay.shuffledex;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

// Implements methods from NoticeDialogListener inside FlourishPickerDialog (DialogPositiveButtonClick and DialogNegativeButtonClick)
public class EfficiencyPracticeAcitivty extends FragmentActivity
        implements FlourishPickerDialog.NoticeDialogListener{


    ArrayList<String> extractedFlourishes;
    String[] flourishArray;
    NumberPicker streakNumberPicker;
    private int streakNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efficiency_practice_acitivty);

        flourishArray= getResources().getStringArray(R.array.dealersGripFlourishArr);

       // Creating NumberPicker
        streakNumberPicker = (NumberPicker)findViewById(R.id.streakPicker);
        streakNumberPicker.setMaxValue(10);
        streakNumberPicker.setMinValue(3);
        streakNumberPicker.setWrapSelectorWheel(false);
        streakNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // Note: If the value of the picker isn't changed at all, the value is 0. Proper validation is necessary at use.
                streakNumber = newVal;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_efficiency_practice_acitivty, menu);
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

    //Displaying the FlourishPickerDialog
    public void showFlourishPicker (View v){
        DialogFragment alert = new FlourishPickerDialog();
        alert.show(getSupportFragmentManager(), "flourishes");
    }

    //Handling clicking PositiveButton
    @Override
    public void onDialogPositiveClick(ArrayList<Integer> arrayList) {
        ArrayList<String> chosenFlourishes = new ArrayList<>();
        if (arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                chosenFlourishes.add(flourishArray[arrayList.get(i)]);
                Toast.makeText(this, "You have selected: "
                        + chosenFlourishes.get(i), Toast.LENGTH_SHORT).show();
            }
            extractedFlourishes = FlourishPickerDialog.extractFlourishes(chosenFlourishes);

        }

    }

    //Handling clicking NegativeButton
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast.makeText(this, "Fuck you!!!", Toast.LENGTH_SHORT).show();
    }

    public void displayAnswer(View view) {
        try{
            Toast.makeText(EfficiencyPracticeAcitivty.this, "" + (streakNumber == 0 ? 3 : streakNumber), Toast.LENGTH_SHORT).show();
            for (int i = 0; i < extractedFlourishes.size(); i++) {
                Toast.makeText(this, extractedFlourishes.get(i), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception exception) {
            Toast.makeText(this, "You must choose flourishes to practice with motherfucker", Toast.LENGTH_SHORT).show();
        }

    }
}
