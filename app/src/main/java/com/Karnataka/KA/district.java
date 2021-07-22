//package com.Karnataka.KA;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.widget.TextView;
//
//import com.Karnataka.R;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.JsonObjectRequest;
//import com.android.volley.toolbox.Volley;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//public class district extends HomeActivityDrawer {
//    private TextView con,d,cur,bgm1,bgm2,bgm3,blr1,blr2,blr3,blu1,blu2,blu3,dk1,dk2,dk3,ud1,ud2,ud3,uk1,uk2,uk3,up1,up2,up3,wb1,wb2,wb3,ap1,ap2,ap3,br1,br2,br3,ka1,ka2,ka3;
//    private RequestQueue mQueue;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.others);
//        appBarTxt.setText("Covid19 District-wise Details");
//
//        bgm1=findViewById(R.id.bgm1);
//        bgm2=findViewById(R.id.bgm2);
//        bgm3=findViewById(R.id.bgm3);
//
//        blr1=findViewById(R.id.blr1);
//        blr2=findViewById(R.id.blr2);
//        blr3=findViewById(R.id.blr3);
//
//        blu1=findViewById(R.id.blu1);
//        blu2=findViewById(R.id.blu2);
//        blu3=findViewById(R.id.blu3);
//
//        dk3=findViewById(R.id.dk3);
//        dk1=findViewById(R.id.dk1);
//        dk2=findViewById(R.id.dk2);
//
//        ud3=findViewById(R.id.ud3);
//        ud1=findViewById(R.id.ud1);
//        ud2=findViewById(R.id.ud2);
//
//        uk3=findViewById(R.id.uk3);
//        uk1=findViewById(R.id.uk1);
//        uk2=findViewById(R.id.uk2);
////        mp3=findViewById(R.id.mp3);
////        up1=findViewById(R.id.up1);
////        up2=findViewById(R.id.up2);
////        up3=findViewById(R.id.up3);
////        wb1=findViewById(R.id.wb1);
////        wb2=findViewById(R.id.wb2);
////        wb3=findViewById(R.id.wb3);
////        ap1=findViewById(R.id.ap1);
////        ap2=findViewById(R.id.ap2);
////        ap3=findViewById(R.id.ap3);
////        br1=findViewById(R.id.br1);
////        br2=findViewById(R.id.br2);
////        br3=findViewById(R.id.br3);
////        ka1=findViewById(R.id.ka1);
////        ka2=findViewById(R.id.ka2);
////        ka3=findViewById(R.id.ka3);
//
//        con=findViewById(R.id.ka1);
//        cur=findViewById(R.id.ka2);
//        d=findViewById(R.id.ka3);
//
//        mQueue= Volley.newRequestQueue(this);
//        jsonParse();
//
//    }   //oncreate ends here
//
//    private void jsonParse() {
//        String url="https://api.covid19india.org/state_district_wise.json";
//        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            Log.d("c","response"+response);
//                            JSONObject obj=response.getJSONObject("Karnataka");
//                            Log.d("c","response_____r    "+obj);
//                            JSONObject districtall=obj.getJSONObject("districtData");
//                            JSONObject district=districtall.getJSONObject("Belagavi");
//                            JSONObject confirmed=obj.getJSONObject("confirmed");
//
//
////                            int con1=india.getInt("confirmedCasesIndian");
////                            int cur1=india.getInt("discharged");
////                            int d1=india.getInt("deaths");
//                           // Log.d("c","responsevalue"+con1);
////                            con.append(String.valueOf(con1));
////                            cur.append(String.valueOf(cur1));
////                            d.append(String.valueOf(d1));
//
//                            JSONArray regional=obj.getJSONArray("regional");
//                            Log.d("c","responsevalue1"+regional);
//                            for(int i=0;i<regional.length();i++){
//                                JSONObject state=regional.getJSONObject(i);
//                                Log.d("c","responsevalue2"+state);
//                                String s=state.getString("loc");
//
//                                if(s.equalsIgnoreCase("Maharashtra")){
//                                    Log.d("c","responsevalue____m"+"execttes");
//                                    mh1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    mh2.append(String.valueOf(state.getInt("discharged")));
//                                    mh3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("Tamil Nadu")){
//                                    tn1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    tn2.append(String.valueOf(state.getInt("discharged")));
//                                    tn3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("Delhi")){
//                                    dl1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    dl2.append(String.valueOf(state.getInt("discharged")));
//                                    dl3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("Gujarat")){
//                                    gj1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    gj2.append(String.valueOf(state.getInt("discharged")));
//                                    gj3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("Rajasthan")){
//                                    rj1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    rj2.append(String.valueOf(state.getInt("discharged")));
//                                    rj3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("Madhya Pradesh")){
//                                    mp1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    mp2.append(String.valueOf(state.getInt("discharged")));
//                                    mp3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("Uttar Pradesh")){
//                                    up1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    up2.append(String.valueOf(state.getInt("discharged")));
//                                    up3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("West Bengal")){
//                                    wb1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    wb2.append(String.valueOf(state.getInt("discharged")));
//                                    wb3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("Andhra Pradesh")){
//                                    ap1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    ap2.append(String.valueOf(state.getInt("discharged")));
//                                    ap3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("Bihar")){
//                                    br1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    br2.append(String.valueOf(state.getInt("discharged")));
//                                    br3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                                if(s.equalsIgnoreCase("Karnataka")){
//                                    ka1.append(String.valueOf(state.getInt("confirmedCasesIndian")));
//                                    ka2.append(String.valueOf(state.getInt("discharged")));
//                                    ka3.append(String.valueOf(state.getInt("deaths")));
//                                }
//                            }
//
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//            }
//        });
//
//        mQueue.add(request);
//    }
//
//
//}