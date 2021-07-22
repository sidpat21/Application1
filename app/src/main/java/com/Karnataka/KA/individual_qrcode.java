package com.Karnataka.KA;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.Karnataka.R;
import com.bumptech.glide.Glide;

public class individual_qrcode extends NavigationDrawerBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.individual_qrcode);
        getIncomingIntent();
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("qrcode") && getIntent().hasExtra("validity_from") && getIntent().hasExtra("validity_to")&& getIntent().hasExtra("source")&& getIntent().hasExtra("destination")&& getIntent().hasExtra("date_generated")){

            String qrcode = getIntent().getStringExtra("qrcode");
            String vs = getIntent().getStringExtra("validity_from");
            String ve = getIntent().getStringExtra("validity_to");
            String s = getIntent().getStringExtra("source");
            String d = getIntent().getStringExtra("destination");
            String dg = getIntent().getStringExtra("date_generated");



            setImage(qrcode,vs,ve,s,d,dg);
        }
    }


    private void setImage(String qrcode, String vs,String ve,String s,String d,String dg){

        TextView vss = findViewById(R.id.textView60);
        vss.setText(vs);
        TextView vee = findViewById(R.id.textView61);
        vee.setText(ve);
        TextView ss = findViewById(R.id.textView53);
        ss.setText(s);
        TextView dd = findViewById(R.id.textView56);
        dd.setText(d);
        TextView dgg = findViewById(R.id.textView52);
        dgg.setText(dg);
        ImageView image = findViewById(R.id.imageView8);

        byte [] encodeByte= Base64.decode(qrcode,Base64.DEFAULT);
        Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);

        Glide.with(this)
                .asBitmap()
                .load(bitmap)
                .into(image);
    }

}
