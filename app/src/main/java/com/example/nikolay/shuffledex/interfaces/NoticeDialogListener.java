package com.example.nikolay.shuffledex.interfaces;

import android.support.v4.app.DialogFragment;

import java.util.ArrayList;

/**
 * Created by Nikolay on 11/30/2015.
 */
public interface NoticeDialogListener {
    void onDialogPositiveClick(ArrayList<Integer> arrayList);
    void onDialogNegativeClick(DialogFragment dialog);
}