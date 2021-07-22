package com.Karnataka.KA;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class register extends AppCompatActivity {
        EditText etName, etEmail, etPassword, etCp, etPhone;
        String name, email, password, phone, cp;
        Button signup;
        String urlRegistration = "https://covid19-risk-assesment-tool.000webhostapp.com/reg.php";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.register);

                signup = findViewById(R.id.register_sign_up_button);
                etName = (EditText) findViewById(R.id.register_username);
                etEmail = (EditText) findViewById(R.id.register_email);
                etPassword = (EditText) findViewById(R.id.register_password);
                etPhone = (EditText) findViewById(R.id.phone);
                etCp = (EditText) findViewById(R.id.register_confirm_password);



        }


        public void signup(View view) {
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Please Wait..");


                if (etName.getText().toString().equals("")) {
                        Toast.makeText(this, "Enter Username", Toast.LENGTH_SHORT).show();
                        etName.setError("This Field is required");
                        etName.requestFocus();
                }
                else if (etEmail.getText().toString().equals("")) {
                        Toast.makeText(this, "Enter Email", Toast.LENGTH_SHORT).show();
                        etEmail.setError("This Field is required");
                        etEmail.requestFocus();
                }
                else if (!(isEmailValid(etEmail.getText().toString()))) {
                        Toast.makeText(this, "Invalid Email address", Toast.LENGTH_SHORT).show();
                        etEmail.setError("Enter a valid Email address");
                        etEmail.requestFocus();
                }
                else if (etPassword.getText().toString().equals("")) {
                        Toast.makeText(this, "Enter Password", Toast.LENGTH_SHORT).show();
                        etPassword.setError("This Field is required");
                        etPassword.requestFocus();

                }
                else if (etCp.getText().toString().equals("")) {
                        Toast.makeText(this, "Enter Password Again", Toast.LENGTH_SHORT).show();
                        etCp.setError("This Field is required");
                        etCp.requestFocus();
                }
                else if(!(isPasswordValid(etPassword.getText().toString()))){
                        Toast.makeText(this, "Password not same or too short", Toast.LENGTH_SHORT).show();
                        etCp.setError("Password not same or too short");
                        etCp.requestFocus();
                }
                else if (etPhone.getText().toString().equals("")) {
                        Toast.makeText(this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                        etPhone.setError("This Field is required");
                        etPhone.requestFocus();
                }
                else  if(!(isPhoneValid(etPhone.getText().toString()))){
                        Toast.makeText(this, "Invalid Phone Number", Toast.LENGTH_SHORT).show();
                        etPhone.setError("Invalid Phone number");
                        etPhone.requestFocus();
                }
                else{

                                progressDialog.show();

                                name = etName.getText().toString();
                                email = etEmail.getText().toString();
                                password = etPassword.getText().toString();
                                phone = etPhone.getText().toString();
                                cp = etCp.getText().toString();


                                StringRequest request = new StringRequest(Request.Method.POST, urlRegistration, new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                                progressDialog.dismiss();
                                                if(response.equalsIgnoreCase("Registration Successful")){

                                                etName.setText("");
                                                etEmail.setText("");
                                                etPassword.setText("");
                                                etCp.setText("");
                                                etPhone.setText("");
                                                startActivity(new Intent(getApplicationContext(),login.class));
                                                finish();
                                                Toast.makeText(register.this, response, Toast.LENGTH_SHORT).show();
                                                }
                                                else{
                                                        Toast.makeText(register.this, response, Toast.LENGTH_SHORT).show();
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
                                                params.put("email", email);
                                                params.put("password", password);
                                                params.put("phone", phone);
                                                return params;

                                        }
                                };

                                RequestQueue requestQueue = Volley.newRequestQueue(register.this);
                                requestQueue.add(request);


                        }

                }

        private boolean isEmailValid(String email) {

                return email.contains("@")&&email.contains(".");
        }

        private boolean isPasswordValid(String password) {

                String confirmPassword = etCp.getText().toString();
                return confirmPassword.equals(password) && password.length() > 6;
        }
        private boolean isPhoneValid(String num) {
                return num.length() == 10;
        }
}
