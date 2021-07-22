package com.Karnataka.KA;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

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

public class volunteerTask extends NavigationDrawerBaseActivity {
    private static final String TAG = "trainingrepo";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mVideo_urls = new ArrayList<>();
    private RequestQueue mQueue;
    String title1,url1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainingrepo);
        Log.d(TAG, "onCreate: started.");
        mQueue= Volley.newRequestQueue(this);
        jsonParse();
        Log.d("check","check___videourls:  "+mVideo_urls);
        Log.d("check","check___Names:  "+mNames);

//        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames,mVideo_urls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    private void jsonParse() {
        final String url="https://covid19-risk-assesment-tool.000webhostapp.com/video.php";
        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("c","sds    "+response);

                            JSONArray jsonArray=response.getJSONArray("link");

                            Log.d("c","responsearrayvideo11111111111111111111111111111111111     "+jsonArray);
                            Log.d("c","responsearrayvideo11111111111111111111111111111111111     "+jsonArray.length());

                            for(int i=0;i<jsonArray.length();i++) {

                                JSONObject single=jsonArray.getJSONObject(i);

                                Log.d("c","inner link index   "+single);

                                title1=single.getString("title");
                                Log.d("c","finalfinalfinaltitle    "+title1);

                                url1=single.getString("url");

                                Log.d("c","finalfinalfinalurl"+url1);

                                mNames.add(title1);
                                mVideo_urls.add(url1);

                                Log.d("c","finalfinalfinal mvideo_urls    "+mVideo_urls);
                                Log.d("c","finalfinalfinal mNames    "+mNames);

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

