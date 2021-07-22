package com.Karnataka.KA;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

public class logout extends NavigationDrawerBaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.logout);
        displayAlertToChangeActivity();
    }
    public void displayAlertToChangeActivity() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Logout");
        alert.setMessage("Would you want to Logout?");

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //Do something here where "ok" clicked and then perform intent from activity context
                Intent intent = new Intent(logout.this, login.class);
                startActivity(intent);

                SharedPreferences preferences=getSharedPreferences("user_login",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("login","false");
                editor.apply();

                finish();

            }
        });
        alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                alert.setCancelable(true);
                Intent intent = new Intent(logout.this, trialView.class);
                startActivity(intent);
                finish();
            }
        });

        alert.show();
    }
}
