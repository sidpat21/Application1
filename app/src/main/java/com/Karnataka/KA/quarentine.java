package com.Karnataka.KA;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.Karnataka.R;
import com.android.volley.RequestQueue;

public class quarentine extends NavigationDrawerBaseActivity{
    private TextView output;
    private RequestQueue mQueue;

    private static final int REQUEST_LOCATION = 1;
    Button btnGetLocation;
    TextView showLocation;
    LocationManager locationManager;
    Location location;
    String latitude, longitude;

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;

    String email=login.str_email;

    @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quarentine);

            output=findViewById(R.id.output);
            output.append(String.valueOf(email));
            //mQueue= Volley.newRequestQueue(this);
            //jsonParse();

            ActivityCompat.requestPermissions( this,
                    new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
//            //showLocation = findViewById(R.id.showLocation);
            //btnGetLocation = findViewById(R.id.btnGetLocation);
//            btnGetLocation.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
                     locationManager = (LocationManager)getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
                    if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                        OnGPS();
                    } else {
                        getLocation();
                   }
//                }
//            });




        imageView = (ImageView)findViewById(R.id.imageView9);
        Button photoButton = (Button) findViewById(R.id.button7);

        EnableRuntimePermissionToAccessCamera();
        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent, CAMERA_REQUEST);
                // Toast.makeText(getApplicationContext(),"image uploaded Successfully",Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void EnableRuntimePermissionToAccessCamera(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(quarentine.this,
                Manifest.permission.CAMERA))
        {

            // Printing toast message after enabling runtime permission.
            Toast.makeText(quarentine.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(quarentine.this,new String[]{Manifest.permission.CAMERA}, CAMERA_REQUEST);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }


    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable GPS for Quarentine check").setCancelable(false).setPositiveButton("Yes", new  DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                quarentine.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                quarentine.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Log.d("y","!!!!!!!!!!!!!________________________________________________________________"+locationGPS);
            if (locationGPS != null) {
                double lat = locationGPS.getLatitude();
                double longi = locationGPS.getLongitude();
                latitude = String.valueOf(lat);
                longitude = String.valueOf(longi);
                //showLocation.setText("Your Location: " + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude);
            } else {
                Toast.makeText(this, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }
    }

//    private void jsonParse() {
//        String url="https://tapelike-sounds.000webhostapp.com/json.php";
//        final JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            Log.d("l","response"+response);
//                            JSONArray jsonArray=response.getJSONArray("data");
//                            Log.d("l","responsearray??????????????????????????????????????????"+jsonArray);
//                            for(int i=0;i<=jsonArray.length();i++){
//                                JSONObject regional=jsonArray.getJSONObject(i);
//                                String s=regional.getString("email");
//                                Log.d("l","value???????????????????????????"+s);
//
//                                if(s.equalsIgnoreCase("sid@g.in")){
//                                    String x=regional.getString("name");
//                                    output.append(String.valueOf(x));
//
//                                }
//
//
//                            }
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


}
