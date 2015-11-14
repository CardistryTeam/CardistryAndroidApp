package com.example.nikolay.shuffledex;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Nikolay on 11/14/2015.
 */
public class FlourishPickerDialog extends DialogFragment {
    public ArrayList<String> flourishSet = new ArrayList<>();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final ArrayList mSelectedItems = new ArrayList();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.flourish_picker_text)
                .setMultiChoiceItems(R.array.dealersGripFlourishArr, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            mSelectedItems.add(which);
                        } else if (mSelectedItems.contains(which)) {
                            mSelectedItems.remove(Integer.valueOf(which));
                        }
                    }
                })

                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    @Override
                    public  void onClick(DialogInterface dialog, int id) {
                        flourishSet = mSelectedItems;
                    }
                })

                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.create();
        return builder.show();
    }

}

