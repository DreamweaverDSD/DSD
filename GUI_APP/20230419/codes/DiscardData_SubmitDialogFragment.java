package com.example.dsd_android;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DiscardData_SubmitDialogFragment extends DialogFragment {
    int datalist_id;


    public DiscardData_SubmitDialogFragment(int id){
        datalist_id = id;
    }

    //Below are using to set onclick event of positive and negative.
    public void onDialogPositiveClick(DialogFragment dialog){

    }
    public void onDialogNegativeClick(DialogFragment dialog){

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.Text_discarddata_Name);
        StringBuilder message = new StringBuilder(getString(R.string.Text_discarddata_Dialog));
        message.append(" " + datalist_id + "?");
        builder.setMessage(message);
        builder.setPositiveButton(R.string.Dialog_discarddata_true, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        GetFromServer getFromServer = new GetFromServer();
                        int result = getFromServer.discarddata(id);
                        if(result == 0){
                            System.out.println("Success");
                        }
                    }
                })
                .setNegativeButton(R.string.Dialog_discarddata_false, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
