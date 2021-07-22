package com.Karnataka.KA;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.Karnataka.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class epass extends NavigationDrawerBaseActivity {
    Button gen;
    String urlqr = "https://covid19-risk-assesment-tool.000webhostapp.com/qr_json.php";
    private ArrayList<String> mqrcode = new ArrayList<>();
    private ArrayList<String> mvalidity_from = new ArrayList<>();
    private ArrayList<String> mvalidity_to = new ArrayList<>();
    private ArrayList<String> msource = new ArrayList<>();
    private ArrayList<String> mdestination = new ArrayList<>();
    private ArrayList<String> mdate_generated = new ArrayList<>();

    private RequestQueue mQueue;
    String qrcode,validity_from,validity_to,source,destination,date_generated;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.epass);
        appBarTxt.setText(" Get your E-Pass");

        gen = findViewById(R.id.gen);

        gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(epass.this, epassCreate.class);
                startActivity(intent);
            }

        });
        mQueue= Volley.newRequestQueue(this);
        jsonParse();
    }

        private void initRecyclerView(){
            RecyclerView recyclerView = findViewById(R.id.recyclerview_qrcode);
            recyclerview_epass adapter = new recyclerview_epass(this, mqrcode, mvalidity_from,mvalidity_to,msource,mdestination,mdate_generated);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }


    private void jsonParse() {
        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, urlqr, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("c","sds    "+response);

                            JSONArray jsonArray=response.getJSONArray("data");

                            Log.d("c","responsearrayvideo11111111111111111111111111111111111     "+jsonArray);
                            Log.d("c","responsearrayvideo11111111111111111111111111111111111     "+jsonArray.length());

                            for(int i=0;i<jsonArray.length();i++) {

                                JSONObject single=jsonArray.getJSONObject(i);

                                Log.d("c","inner link index   "+single);

                                qrcode=single.getString("qrcode");
                                validity_from=single.getString("validity_from");
                                validity_to=single.getString("validity_to");
                                source=single.getString("source");
                                destination=single.getString("destination");
                                date_generated=single.getString("date_generated");

                                mqrcode.add(qrcode);
                                mvalidity_from.add(validity_from);
                                mvalidity_to.add(validity_to);
                                msource.add(source);
                                mdestination.add(destination);
                                mdate_generated.add(date_generated);

                                Log.d("c","inner link index1   "+mqrcode);
                                Log.d("c","inner link index2   "+mvalidity_to);
                                Log.d("c","inner link index3   "+mvalidity_from);
                                Log.d("c","inner link index4   "+source);
                                Log.d("c","inner link index5   "+destination);
                                Log.d("c","inner link index6   "+date_generated);
                            }




                            initRecyclerView();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}