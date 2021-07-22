package com.Karnataka.KA;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.Karnataka.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class HomeActivityDrawer extends NavigationDrawerBaseActivity {
    Button ss, qw, fh, ch, ad, od, play,ep,pp,quarentine,others,button8,votb,vview;
    TextView marquee;

//    VideoView vv2;
//    MediaController Mc;
private WebView mMap;

    private TextView con,d,cur;
    private RequestQueue mQueue;

    private int[] mImages=new int[]{
            R.drawable.ib, R.drawable.ic
    };

    private String[] mImagetitle=new String[]{
            "aw1","aw2"
    };

    //ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        appBarTxt.setText("Home");


        mMap=findViewById(R.id.wviewaw);
        WebSettings a=  mMap.getSettings();
        a.setJavaScriptEnabled(true);
        mMap.loadUrl("https://tapelike-sounds.000webhostapp.com/uploads/Amitabh%20Bachchan's%20message%20on%20COVID-19.mp4");


//        if(SaveSharedPreference.getUserName(HomeActivityDrawer.this).length() == 0)
//        {
//            Intent i=new Intent(HomeActivityDrawer.this,login.class);
//            startActivity(i);
//        }
//        else
//        {
//            Intent activity = new Intent(getApplicationContext(), HomeActivityDrawer.class);
//            startActivity(activity);
//        }
//        vv2=findViewById(R.id.videoView2);
//        Mc=new MediaController(this);
//
//
//        String path="https://tapelike-sounds.000webhostapp.com/uploads/Amitabh%20Bachchan's%20message%20on%20COVID-19.mp4";
//        Uri uri=Uri.parse(path);
//        vv2.setVideoURI(uri);
//        vv2.setMediaController(Mc);
//        Mc.setAnchorView(vv2);
//        vv2.start();

        CarouselView carouselView=findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
         carouselView.setImageListener(new ImageListener() {
             @Override
             public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);
             }
         });
         carouselView.setImageClickListener(new ImageClickListener() {
             @Override
             public void onClick(int position) {
                 Toast.makeText(HomeActivityDrawer.this,mImagetitle[position],Toast.LENGTH_SHORT).show();

             }
         });

        button8=findViewById(R.id.button8);
        others=findViewById(R.id.button10);
        marquee=findViewById(R.id.marquee);
        ep=findViewById(R.id.button2);
        pp=findViewById(R.id.button3);
        ss = findViewById(R.id.ss);
        qw = findViewById(R.id.qw);
        fh = findViewById(R.id.fh);
        ch = findViewById(R.id.ch);
        ad = findViewById(R.id.ad);
        od = findViewById(R.id.od);
        play = findViewById(R.id.play);
        votb=findViewById(R.id.vot_button);
        quarentine=findViewById(R.id.button6);
        //vview=findViewById(R.id.vview);

//        vview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(HomeActivityDrawer.this,vvideo.class);
//                startActivity(intent);
//            }
//        });
        votb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivityDrawer.this,vot.class);
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivityDrawer.this,unor.class);
                startActivity(intent);
            }
        });
        others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, others.class);
                startActivity(intent);

            }
        });
        quarentine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, quarentine.class);
                startActivity(intent);
            }
        });
marquee.setSelected(true);
        marquee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://tapelike-sounds.000webhostapp.com/a.pdf";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, survey.class);
                startActivity(intent);
            }
        });
        qw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, q.class);
                startActivity(intent);
            }
        });
        fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, hospital.class);
                startActivity(intent);
            }
        });
        ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, call.class);
                startActivity(intent);
            }
        });
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, AppointDoc.class);
                startActivity(intent);
            }
        });
        od.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, DonateActivityDrawer.class);
                startActivity(intent);
            }
        });
        ep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, epass.class);
                startActivity(intent);
            }
        });
        pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivityDrawer.this, qw.class);
                startActivity(intent);
            }
        });
/*        play.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }
});

*/  /*      txtJson = (TextView) findViewById(R.id.tvJsonItem);
                new JsonTask().execute("https://api.rootnet.in/covid19-in/stats/latest");
    }

    private class JsonTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();


        }

        protected String doInBackground(String... params) {


            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();


                InputStream stream = connection.getInputStream();

                reader = new BufferedReader(new InputStreamReader(stream));

                StringBuffer buffer = new StringBuffer();
                String line = "";

                while ((line = reader.readLine()) != null) {
                    buffer.append(line+"\n");
                    Log.d("Response: ", "> " + line);   //here u ll get whole response...... :-)

                }

             *//*   JSONObject obj = new JSONObject(buffer.toString());
                JSONArray regional = obj.getJSONArray("regional");
                //JSONObject confirmedCasesIndian = regional.getJSONObject(4);
                //String cases=confirmedCasesIndian.getString("confirmedCasesIndian");

                for (int i = 0; i < regional.length(); i++) {
                    // create a JSONObject for fetching single user data
                    JSONObject confirmedCasesIndian = regional.getJSONObject(i);
                    // fetch email and name and store it in arraylist
                    personNames.add(confirmedCasesIndian.getString("ConfirmedCasesIndian"));
                }

                String cases=personNames[4];*//*
                return buffer.toString();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);


                 //txtJson.setText(result);




        }
    }*/ con=findViewById(R.id.con);
        cur=findViewById(R.id.cur);
        d=findViewById(R.id.d);

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
                            JSONArray jsonArray=obj.getJSONArray("regional");
                            Log.d("c","responsearray"+jsonArray);
                            JSONObject regional=jsonArray.getJSONObject(17);
                            Log.d("c","responseindex"+regional);
                            int con1=regional.getInt("confirmedCasesIndian");
                            int cur1=regional.getInt("discharged");
                            int d1=regional.getInt("deaths");
                            Log.d("c","responsevalue"+con1);
                            con.append(String.valueOf(con1));
                            cur.append(String.valueOf(cur1));
                            d.append(String.valueOf(d1));

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


