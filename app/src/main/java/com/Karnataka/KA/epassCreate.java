package com.Karnataka.KA;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.Karnataka.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class epassCreate extends NavigationDrawerBaseActivity  {
    EditText editText,editText3,editText4,editText5;
    Button gen;
    String vs,ve;
    String urlGeneration = "https://covid19-risk-assesment-tool.000webhostapp.com/qr-pass.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.epass_create);
        appBarTxt.setText(" Generate E-Pass");


        editText=findViewById(R.id.editText);
        gen=findViewById(R.id.button4);
        editText3=findViewById(R.id.editText3);
        editText4=findViewById(R.id.editText4);
        editText5=findViewById(R.id.editText5);
        final ProgressDialog progressDialog = new ProgressDialog(this);

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data="generation date: "+java.text.DateFormat.getDateTimeInstance().format(new Date())+"\nsource: "+editText.getText().toString()+"\nto destination: "+editText3.getText().toString()+"\n\n"+"start date: "+editText4.getText().toString()+"\nend date:"+editText5.getText().toString();
                QRGEncoder qrgEncoder=new QRGEncoder(data,null, QRGContents.Type.TEXT,500);
                Bitmap bitmap=qrgEncoder.getBitmap();

                progressDialog.setMessage("Generating Quick Response(QR) Code");

                progressDialog.show();

                final String s = editText.getText().toString();
                final String gtime=java.text.DateFormat.getDateTimeInstance().format(new Date());
                final String d = editText3.getText().toString();
                vs=editText4.getText().toString();
                ve=editText5.getText().toString();
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//                try {
//                    Date dob_var = sdf.parse(valstart.getText().toString());
//                    DateFormat dateFormatISO8601 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    vs = dateFormatISO8601.format(dob_var);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
//                try {
//                    Date dob_var = sdf.parse(valend.getText().toString());
//                    DateFormat dateFormatISO8601 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                    ve = dateFormatISO8601.format(dob_var);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }


                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100,bos);
                final byte[] bArray = bos.toByteArray();
                final String qrimg= Base64.encodeToString(bArray, Base64.DEFAULT);


                StringRequest request = new StringRequest(Request.Method.POST, urlGeneration, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        if(response.equalsIgnoreCase("generation Successful")){

                            editText.setText("");
                            editText3.setText("");
                            editText4.setText("");
                            editText5.setText("");
                            startActivity(new Intent(getApplicationContext(),epass.class));
                            finish();
                            Toast.makeText(epassCreate.this, response, Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(epassCreate.this, response, Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(epassCreate.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                }

                ) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();

                        params.put("qrcode",qrimg);
                        params.put("vs", vs);
                        params.put("ve", ve);
                        params.put("source",s);
                        params.put("destination", d);
                        params.put("gen", gtime);

                        return params;

                    }
                };

                RequestQueue requestQueue = Volley.newRequestQueue(epassCreate.this);
                requestQueue.add(request);




            }
        });
    }

}
