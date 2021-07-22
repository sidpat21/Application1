package com.Karnataka.KA;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Karnataka.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LabelFormatter;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class others extends HomeActivityDrawer {
    private TextView con,d,cur,mh1,mh2,mh3,tn1,tn2,tn3,dl1,dl2,dl3,gj1,gj2,gj3,rj1,rj2,rj3,mp1,mp2,mp3,up1,up2,up3,wb1,wb2,wb3,ap1,ap2,ap3,br1,br2,br3,ka1,ka2,ka3;
    private RequestQueue mQueue;
    CardView is,ks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.others);
        appBarTxt.setText("Covid19 Updates");

//        final GraphView graph = (GraphView) findViewById(R.id.graph);
//
//        graph.setVisibility(View.VISIBLE);
//
//                String firstInput_1, secondInput_1;
//                String firstInput_2, secondInput_2;
//                String firstInput_3, secondInput_3;
//                String firstInput_4, secondInput_4;
//                //  1 and 5
//                firstInput_1 ="1" ;
//                secondInput_1 = "1";
//                firstInput_2 = "2";
//                secondInput_2 = "2";
//                firstInput_3 = "3";
//                secondInput_3 = "3";
//
//                try {
//
////                    final ArrayList<String> month=new ArrayList<>();
////                    month.add("May");
////                    month.add("Jun");
////                    month.add("July");
//
//                    String[] month={"may","june","july"};
//                    StaticLabelsFormatter staticLabelsFormatter=new StaticLabelsFormatter(graph,month,null,null);
//
//                    LineGraphSeries < DataPoint > series = new LineGraphSeries< >(new DataPoint[] {
//                            new DataPoint(0, 0),
//                            new DataPoint(Integer.valueOf(firstInput_1), Integer.valueOf(secondInput_1)),
//                            new DataPoint(Integer.valueOf(firstInput_2), Integer.valueOf(secondInput_2)),
//                            new DataPoint(Integer.valueOf(firstInput_3), Integer.valueOf(secondInput_3)),
//                    });
//
//
//
//                    graph.setTitle("Cumulative");
//
//                    graph.addSeries(series);
//
//                }
//
//                catch (IllegalArgumentException e) {
//                    Toast.makeText(others.this, e.getMessage(), Toast.LENGTH_LONG).show();
//                }


        mh1=findViewById(R.id.mh1);
        mh2=findViewById(R.id.mh2);
        mh3=findViewById(R.id.mh3);
        tn1=findViewById(R.id.tn1);
        tn2=findViewById(R.id.tn2);
        tn3=findViewById(R.id.tn3);
        dl1=findViewById(R.id.dl1);
        dl2=findViewById(R.id.dl2);
        dl3=findViewById(R.id.dl3);
        tn3=findViewById(R.id.tn3);
        gj1=findViewById(R.id.gj1);
        gj2=findViewById(R.id.gj2);
        gj3=findViewById(R.id.gj3);
        rj1=findViewById(R.id.rj1);
        rj2=findViewById(R.id.rj2);
        rj3=findViewById(R.id.rj3);
        mp1=findViewById(R.id.mp1);
        mp2=findViewById(R.id.mp2);
        mp3=findViewById(R.id.mp3);
        up1=findViewById(R.id.up1);
        up2=findViewById(R.id.up2);
        up3=findViewById(R.id.up3);
        wb1=findViewById(R.id.wb1);
        wb2=findViewById(R.id.wb2);
        wb3=findViewById(R.id.wb3);
        ap1=findViewById(R.id.ap1);
        ap2=findViewById(R.id.ap2);
        ap3=findViewById(R.id.ap3);
        br1=findViewById(R.id.br1);
        br2=findViewById(R.id.br2);
        br3=findViewById(R.id.br3);
        ka1=findViewById(R.id.ka1);
        ka2=findViewById(R.id.ka2);
        ka3=findViewById(R.id.ka3);

    con=findViewById(R.id.i1);
    cur=findViewById(R.id.i2);
    d=findViewById(R.id.i3);

    is=findViewById(R.id.india_stat);
    ks=findViewById(R.id.ka_stat);

    is.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(com.Karnataka.KA.others.this,indiaStat.class);
            startActivity(i);
        }
    });

        ks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(com.Karnataka.KA.others.this,ka_stat.class);
                startActivity(i);
            }
        });



    mQueue= Volley.newRequestQueue(this);
    jsonParse();

}   //oncreate ends here

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
                            JSONObject india=obj.getJSONObject("summary");


                            int con1=india.getInt("confirmedCasesIndian");
                            int cur1=india.getInt("discharged");
                            int d1=india.getInt("deaths");
                            Log.d("c","responsevalue"+con1);
                            con.append(String.valueOf(con1));
                            cur.append(String.valueOf(cur1));
                            d.append(String.valueOf(d1));

                            JSONArray regional=obj.getJSONArray("regional");
                            Log.d("c","responsevalue1"+regional);
                            for(int i=0;i<regional.length();i++){
                                JSONObject state=regional.getJSONObject(i);
                                Log.d("c","responsevalue2"+state);
                                String s=state.getString("loc");

                                if(s.equalsIgnoreCase("Maharashtra")){
                                    Log.d("c","responsevalue____m"+"execttes");
                                    mh1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    mh2.append(String.valueOf(state.getInt("discharged")));
                                    mh3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("Tamil Nadu")){
                                    tn1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    tn2.append(String.valueOf(state.getInt("discharged")));
                                    tn3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("Delhi")){
                                    dl1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    dl2.append(String.valueOf(state.getInt("discharged")));
                                    dl3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("Gujarat")){
                                    gj1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    gj2.append(String.valueOf(state.getInt("discharged")));
                                    gj3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("Rajasthan")){
                                    rj1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    rj2.append(String.valueOf(state.getInt("discharged")));
                                    rj3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("Madhya Pradesh")){
                                    mp1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    mp2.append(String.valueOf(state.getInt("discharged")));
                                    mp3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("Uttar Pradesh")){
                                    up1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    up2.append(String.valueOf(state.getInt("discharged")));
                                    up3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("West Bengal")){
                                    wb1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    wb2.append(String.valueOf(state.getInt("discharged")));
                                    wb3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("Andhra Pradesh")){
                                    ap1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    ap2.append(String.valueOf(state.getInt("discharged")));
                                    ap3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("Bihar")){
                                    br1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    br2.append(String.valueOf(state.getInt("discharged")));
                                    br3.append(String.valueOf(state.getInt("deaths")));
                                }
                                if(s.equalsIgnoreCase("Karnataka")){
                                    ka1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
                                    ka2.append(String.valueOf(state.getInt("discharged")));
                                    ka3.append(String.valueOf(state.getInt("deaths")));
                                }
                            }


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