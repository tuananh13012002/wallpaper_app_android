package com.example.asm_anhdroidnetworking;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;


import androidx.cardview.widget.CardView;

public class NetworkChangeListener extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(!Common.isConnectedInternet(context)){
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            View view= LayoutInflater.from(context).inflate(R.layout.layout_check_internet,null);
            builder.setView(view);
            CardView btn=view.findViewById(R.id.btnRetry);
            AlertDialog dialog=builder.create();
            dialog.show();
            dialog.setCancelable(false);
            dialog.getWindow().setGravity(Gravity.CENTER);
            btn.setOnClickListener(view1 -> {
                dialog.dismiss();
                onReceive(context,intent);
            });
        }
    }
}
