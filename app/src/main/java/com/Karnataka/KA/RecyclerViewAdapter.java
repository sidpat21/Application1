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
import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mtitle = new ArrayList<>();
    private ArrayList<String> mVideourls = new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> title, ArrayList<String> videourls) {
            mtitle = title;
            mVideourls=videourls;
            mContext = context;
            }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listener, parent, false);
            ViewHolder holder = new ViewHolder(view);
            return holder;
            }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
            Log.d(TAG, "onBindViewHolder: called.");

            Glide.with(mContext)
            .asBitmap();
            //.load(mImages.get(position))
            //.into(holder.image);

            holder.title.setText(mtitle.get(position));


            holder.parentLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mtitle.get(position));

                Toast.makeText(mContext, mtitle.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, ActivityVideo.class);
                intent.putExtra("video_url", mVideourls.get(position));
               // intent.putExtra("image_name", mImageNames.get(position));
                mContext.startActivity(intent);
             }
            });

    }

    @Override
    public int getItemCount() {
            return mtitle.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView title;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}

