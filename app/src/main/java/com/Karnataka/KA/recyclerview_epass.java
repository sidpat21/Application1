package com.Karnataka.KA;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.Karnataka.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class recyclerview_epass extends RecyclerView.Adapter<recyclerview_epass.ViewHolder>{

    private ArrayList<String> mmqrcode = new ArrayList<>();
    private ArrayList<String> mmvalidity_from = new ArrayList<>();
    private ArrayList<String> mmvalidity_to = new ArrayList<>();
    private ArrayList<String> mmsource = new ArrayList<>();
    private ArrayList<String> mmdestination = new ArrayList<>();
    private ArrayList<String> mmdate_generated = new ArrayList<>();

    private Context mContext;

    public recyclerview_epass(Context context, ArrayList<String> qrcode, ArrayList<String> validity_from, ArrayList<String> validity_to, ArrayList<String> source, ArrayList<String> destination,ArrayList<String> date_generated) {
        mmqrcode = qrcode;
        mmvalidity_from=validity_from;
        mmvalidity_to=validity_to;
        mmsource=source;
        mmdestination=destination;
        mmdate_generated=date_generated;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listener_qrcode, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Glide.with(mContext)
                .asBitmap();
        //.load(mImages.get(position))
        //.into(holder.image);

            holder.source.setText(mmsource.get(position));
        holder.des.setText(mmdestination.get(position));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, individual_qrcode.class);
                intent.putExtra("qrcode", mmqrcode.get(position));
                intent.putExtra("validity_from", mmvalidity_from.get(position));
                intent.putExtra("validity_to", mmvalidity_to.get(position));
                intent.putExtra("source", mmsource.get(position));
                intent.putExtra("destination", mmdestination.get(position));
                intent.putExtra("date_generated", mmdate_generated.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mmqrcode.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView source,des;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            source = itemView.findViewById(R.id.cardsource);
            des = itemView.findViewById(R.id.carddes);

            parentLayout = itemView.findViewById(R.id.qrcode_layout);
        }
    }
}

