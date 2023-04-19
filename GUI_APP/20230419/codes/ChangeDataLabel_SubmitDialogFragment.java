package com.example.dsd_android;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class ChangeDataLabel_SubmitDialogFragment extends DialogFragment {
    int datalist_id;


    public ChangeDataLabel_SubmitDialogFragment(int id){
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
        builder.setTitle(getString(R.string.Text_changedatalabel_Dialog));
        builder.setItems(R.array.type_of_data, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                GetFromServer getFromServer = new GetFromServer();
                int a = getFromServer.changedatalabel(datalist_id, which);
            }
        });
    return builder.create();
    }
}
