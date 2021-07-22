package com.Karnataka.KA;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.Karnataka.R;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class trialView extends NavigationDrawerBaseActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem firstItem,secondItem,thirdItem;
//    private int[] mImages=new int[]{
//            R.drawable.ib, R.drawable.ic
//    };
//
//    private String[] mImagetitle=new String[]{
//            "aw1","aw2"
//    };
    private TextView con,d,cur,time;
    private RequestQueue mQueue;
    Button viewAll,volunterRegistration,ngo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trailview);
        appBarTxt.setText("COVID-19 Risk Assesment Tool");

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        firstItem = findViewById(R.id.tabItem1);
        secondItem = findViewById(R.id.tabItem2);
        thirdItem = findViewById(R.id.tabItem3);
//        viewAll=(Button)findViewById(R.id.button10);

        tabLayout.setupWithViewPager(viewPager);
//        CarouselView carouselView=findViewById(R.id.carousel);
//        carouselView.setPageCount(mImages.length);
//        carouselView.setImageListener(new ImageListener() {
//            @Override
//            public void setImageForPosition(int position, ImageView imageView) {
//                imageView.setImageResource(mImages[position]);
//            }
//        });
//        carouselView.setImageClickListener(new ImageClickListener() {
//            @Override
//            public void onClick(int position) {
//                Toast.makeText(trialView.this,mImagetitle[position],Toast.LENGTH_SHORT).show();
//
//            }
//        });
        final PagerAdapter adapter = new PagerAdapter
                (this,getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


//        viewAll.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(trialView.this,others.class);
//                startActivity(i);
//            }
//        });

//        volunterRegistration=findViewById(R.id.volunter);
//
//        volunterRegistration.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(trialView.this,volunteerRegistration.class);
//                startActivity(i);
//            }
//        });
//
//        ngo=findViewById(R.id.ngo);
//
//        ngo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i=new Intent(trialView.this,ngoRegistration.class);
//                startActivity(i);
//            }
//        });
//


//        con=findViewById(R.id.con);
//        cur=findViewById(R.id.cur);
//        d=findViewById(R.id.d);
//        time=findViewById(R.id.time);
//
//        mQueue= Volley.newRequestQueue(this);
//        jsonParse();


    }

//    private void jsonParse() {
//        String url="https://api.rootnet.in/covid19-in/stats/latest";
//        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            Log.d("c","response"+response);
//                            JSONObject obj=response.getJSONObject("data");
//                            Log.d("c","response_____r    "+obj);
//                            JSONArray jsonArray=obj.getJSONArray("regional");
//                            Log.d("c","responsearray"+jsonArray);
//                            JSONObject regional=jsonArray.getJSONObject(15);
//                            Log.d("c","responseindex"+regional);
//                            int con1=regional.getInt("confirmedCasesIndian");
//                            int cur1=regional.getInt("discharged");
//                            int d1=regional.getInt("deaths");
//                            Log.d("c","responsevalue"+con1);
//                            con.append(String.valueOf(con1));
//                            cur.append(String.valueOf(cur1));
//                            d.append(String.valueOf(d1));
//
//                            String tim=response.getString("lastRefreshed");
//                            Log.d("c","responsevalue_update________78451239976166"+"      "+tim);
//                            String a=tim.substring(0,10);
//                            String b=tim.substring(11,19);
//                            String t="  "+a+"  ,"+b;
//                            time.append(t);
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

}
