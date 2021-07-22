package com.Karnataka.KA;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.Karnataka.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class volunteerRegistration extends AppCompatActivity {

    EditText namevr, addvr, mnovr, evr, anyothervr;
    CheckBox mon, tue, wed, thur, fri, sat, sun;
    // RadioButton dri,nur,med,fin,tec,adm,veh;
    String name, email, add, phone, anyother, radiovalue;
    private RadioGroup rgroup;
    private RadioButton rbutton;
    Button regvr;
    ImageView close;
    String day, day_database = "";
    String url = "https://covid19-risk-assesment-tool.000webhostapp.com/volunteer_registration_Karnataka.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volunteer_registration);

        regvr = findViewById(R.id.vrsubmit);
        namevr = (EditText) findViewById(R.id.namevr);
        addvr = (EditText) findViewById(R.id.addressvr);
        mnovr = (EditText) findViewById(R.id.mnovr);
        evr = (EditText) findViewById(R.id.evr);
        close = findViewById(R.id.closevr);

        anyothervr = (EditText) findViewById(R.id.anyothervr);

        mon = (CheckBox) findViewById(R.id.monvr);
        tue = (CheckBox) findViewById(R.id.tuevr);
        wed = (CheckBox) findViewById(R.id.wedvr);
        thur = (CheckBox) findViewById(R.id.thurvr);
        fri = (CheckBox) findViewById(R.id.frivr);
        sat = (CheckBox) findViewById(R.id.satvr);
        sun = (CheckBox) findViewById(R.id.sunvr);

        rgroup = (RadioGroup) findViewById(R.id.radiogroup);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(volunteerRegistration.this, trialView.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void regvr(View view) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait..");

        if (namevr.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
            namevr.requestFocus();
        } else if (addvr.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Address", Toast.LENGTH_SHORT).show();
            addvr.requestFocus();
        } else if (mnovr.getText().toString().equals("")) {
            Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
            mnovr.requestFocus();
        }
        else if(evr.getText().toString().equals("")){
            Toast.makeText(this, "Enter Email ID", Toast.LENGTH_SHORT).show();
        }
        else if (!(isEmailValid(evr.getText().toString()))) {
            Toast.makeText(this, "Invalid Email ID", Toast.LENGTH_SHORT).show();
        }

        else if (!(isPhoneValid(mnovr.getText().toString()))) {
            Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
        } else {
            name = namevr.getText().toString();
            add = addvr.getText().toString();
            phone = mnovr.getText().toString();
            email = evr.getText().toString();
            anyother = anyothervr.getText().toString();

            List<CheckBox> items = new ArrayList<CheckBox>();
            items.add(mon);
            items.add(tue);
            items.add(wed);
            items.add(thur);
            items.add(fri);
            items.add(sat);
            items.add(sun);
            ArrayList<String> daychoosen = new ArrayList<String>();

            for (CheckBox item : items) {
                if (item.isChecked()) {
                    day = item.getText().toString();
                    daychoosen.add(day);
                }
            }

            for (int i = 0; i < daychoosen.size(); i++) {
                day_database += "," + daychoosen.get(i);
            }

            //radioButton
            int selectedId = rgroup.getCheckedRadioButtonId();
            rbutton = (RadioButton) findViewById(selectedId);
            radiovalue = rbutton.getText().toString();


            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();
                    if (response.equalsIgnoreCase("Registration Successful")) {

                        namevr.setText("");
                        evr.setText("");
                        addvr.setText("");
                        mnovr.setText("");
                        startActivity(new Intent(getApplicationContext(), trialView.class));
                        finish();
                        Toast.makeText(volunteerRegistration.this, response, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(volunteerRegistration.this, response, Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                    // Toast.makeText(register.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();

                    params.put("name", name);
                    params.put("address", add);
                    params.put("mobilenumber", phone);
                    params.put("email", email);
                    params.put("available", day_database);
                    params.put("whatcanthey", radiovalue);
                    params.put("otherinfo", anyother);


                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(volunteerRegistration.this);
            requestQueue.add(request);

        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@") && email.contains(".");
    }

    private boolean isPhoneValid(String num) {
        return num.length() == 10;
    }
}

