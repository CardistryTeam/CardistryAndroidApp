package com.example.nikolay.shuffledex;


import android.app.Activity;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Nikolay on 11/14/2015.
 */
public class FlourishPickerDialog extends DialogFragment {

    /* The activity that creates an instance of this dialog fragment must
 * implement this interface in order to receive event callbacks.
 * Each method passes the DialogFragment in case the host needs to query it. */
    // Interface to handle PositiveButton click
    public interface NoticeDialogListener {
        void onDialogPositiveClick(ArrayList<Integer> arrayList);
        void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    NoticeDialogListener mListener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (NoticeDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");
        }
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // ArrayList<Integer> to hold the index of each flourish the user chooses in the dealersGripArr in string.xml
        final ArrayList<Integer> selectedItemsIndexList = new ArrayList<>();
        // New dialog AlertDialog builder. It's final
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Set title
        builder.setTitle(R.string.flourish_picker_text)
                //Setting the options.
                .setMultiChoiceItems(R.array.dealersGripFlourishArr, null, new DialogInterface.OnMultiChoiceClickListener() {
                    //onClick action.
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                        Click the checkbox to add the index of the chosen flourish in
//                        dealersGripArr to selectedItemsIndexList
                        if (isChecked) {
                            selectedItemsIndexList.add(which);
                        }
//                        If it is already clicked remove it from the selectedItemsIndexList
                        else if (selectedItemsIndexList.contains(which)) {
                            selectedItemsIndexList.remove(Integer.valueOf(which));
                        }
                    }
                })
                //Handle clicking PositiveButton. This is also the problem I am currently working on.
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    @Override
                    public  void onClick(DialogInterface dialog, int id) {
                        mListener.onDialogPositiveClick(selectedItemsIndexList);

                    }
                })
                //Handle clicking NegativeButton
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mListener.onDialogNegativeClick(FlourishPickerDialog.this);
                    }
                });
        //Return the AlertDialog
        return builder.create();
    }

}