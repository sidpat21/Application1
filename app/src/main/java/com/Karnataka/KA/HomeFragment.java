package com.Karnataka.KA;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

public class HomeFragment extends Fragment {
    private TextView con,d,cur,time;
    private RequestQueue mQueue;
    Button viewAll,volunterRegistration,ngo;

    public HomeFragment() {
        // Required empty public constructor
    }
    Activity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context=getActivity();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    public void onStart(){
        super.onStart();
        CardView fh=(CardView) context.findViewById(R.id.fh);
        CardView button6=(CardView)context.findViewById(R.id.button6);
        CardView ad=(CardView)context.findViewById(R.id.ad);
        CardView ch=(CardView)context.findViewById(R.id.ch);
        CardView ss=(CardView)context.findViewById(R.id.ss);
        viewAll=(Button)context.findViewById(R.id.button10);
        con=context.findViewById(R.id.con);
        cur=context.findViewById(R.id.cur);
        d=context.findViewById(R.id.d);
        time=context.findViewById(R.id.time);

        mQueue= Volley.newRequestQueue(context);
        jsonParse();



        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,others.class);
                startActivity(i);
            }
        });
        fh.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, hospital.class);
                startActivity(intent);
            }

        });
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, quarentine.class);
                startActivity(intent);
            }

        });
        ad.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, AppointDoc.class);
                startActivity(intent);
            }

        });
        ch.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, call.class);
                startActivity(intent);
            }

        });
        ss.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(context, survey.class);
                startActivity(intent);
            }

        });

    }

    private void jsonParse() {
        String url="https://api.rootnet.in/covid19-in/stats/latest";
        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("c","response"+response);
                            JSONObject obj=response.getJSONObject("data");
                            Log.d("c","response_____r    "+obj);
                            JSONArray jsonArray=obj.getJSONArray("regional");
                            Log.d("c","responsearray"+jsonArray);
                            JSONObject regional=jsonArray.getJSONObject(15);
                            Log.d("c","responseindex"+regional);
                            int con1=regional.getInt("confirmedCasesIndian");
                            int cur1=regional.getInt("discharged");
                            int d1=regional.getInt("deaths");
                            Log.d("c","responsevalue"+con1);
                            con.setText("");
                            cur.setText("");
                            d.setText("");
                            con.append(String.valueOf(con1));
                            cur.append(String.valueOf(cur1));
                            d.append(String.valueOf(d1));

                            String tim=response.getString("lastRefreshed");
                            Log.d("c","responsevalue_update________78451239976166"+"      "+tim);
                            String a=tim.substring(0,10);
                            String b=tim.substring(11,19);
                            String t="  "+a+"  ,"+b;
                            time.setText("");
                            time.append(t);


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