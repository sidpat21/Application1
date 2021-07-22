package com.Karnataka.KA;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.Karnataka.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

//import static com.SecondRound.ch.SaveSharedPreference.setUserName;

public class login extends AppCompatActivity {

    Button login;
    Button register;
    public static String str_email;
    String str_password;
    EditText etEmail,etPassword;
    String urlLogin  = "https://covid19-risk-assesment-tool.000webhostapp.com/log.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

          login=findViewById(R.id.login_sign_in_button);
        register=findViewById(R.id.login_register_button);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);


        SharedPreferences preferences=getSharedPreferences("user_login",MODE_PRIVATE);
        String login=preferences.getString("login","");
        if(login.equals("true")){
            Intent i=new Intent(login.this,trialView.class);
            startActivity(i);
            finish();
        }
    }






    public void SignIn(View view) {
        if(etEmail.getText().toString().equals("")){
            Toast.makeText(this, "Enter Email address", Toast.LENGTH_SHORT).show();
            etEmail.setError("Enter Email Address");
            etEmail.requestFocus();
        }
        else if(!(isEmailValid(etEmail.getText().toString()))){
            Toast.makeText(this, "Invalid Email address", Toast.LENGTH_SHORT).show();
            etEmail.setError("Enter a valid Email address");
            etEmail.requestFocus();
        }
        else if(etPassword.getText().toString().equals("")){
            Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
            etPassword.setError("Enter Password");
            etPassword.requestFocus();
        }
        else{


            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Please Wait..");

            progressDialog.show();

            str_email = etEmail.getText().toString().trim();
            str_password = etPassword.getText().toString().trim();


            StringRequest request = new StringRequest(Request.Method.POST, urlLogin, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    progressDialog.dismiss();

                    if(response.equalsIgnoreCase("Login success")){


                        startActivity(new Intent(getApplicationContext(),trialView.class));
                        finish();
                        Toast.makeText(login.this, response, Toast.LENGTH_SHORT).show();
                        //setUserName(ctx,str_email);

                        SharedPreferences preferences=getSharedPreferences("user_login",MODE_PRIVATE);
                        SharedPreferences.Editor editor=preferences.edit();
                        editor.putString("login","true");
                        editor.apply();


                        etEmail.setText("");
                        etPassword.setText("");
                    }
                    else{
                        Toast.makeText(login.this, response, Toast.LENGTH_SHORT).show();
                    }

                }
            },new Response.ErrorListener(){

                @Override
                public void onErrorResponse(VolleyError error) {
                    progressDialog.dismiss();
                  //  Toast.makeText(login.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            ){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String, String>();
                    params.put("email",str_email);
                    params.put("password",str_password);
                    return params;

                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(login.this);
            requestQueue.add(request);




        }

           }
    private boolean isEmailValid(String email) {

        return email.contains("@")&&email.contains(".");
    }

    public void register(View view) {
        Intent intent=new Intent(login.this,register.class);
        startActivity(intent);
        finish();
    }
}
