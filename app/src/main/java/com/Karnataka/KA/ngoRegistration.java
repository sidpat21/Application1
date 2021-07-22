package com.Karnataka.KA;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.Karnataka.R;

import java.net.URISyntaxException;

public class ngoRegistration extends AppCompatActivity {
    ImageView close,attach;
    private static final int SELECT_VIDEO = 3;
    private String selectedPath;
    private TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ngo_registration);

        textView=findViewById(R.id.filepath);
        close=findViewById(R.id.closengor);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ngoRegistration.this,trialView.class);
                startActivity(i);
                finish();
            }
        });

        attach=findViewById(R.id.attach);

        attach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosedocument();
            }
        });
    }



    private void choosedocument() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select a Document "), SELECT_VIDEO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_VIDEO) {
                System.out.println("SELECT_DOCUMENT");
                Uri selectedImageUri = data.getData();
                try {
                    selectedPath = getPath(this,selectedImageUri);
                    textView.setText(selectedPath);

                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                Log.d("document", "aasadsadsadssssssssssssssssssssssssssssssssssssssssssssss" + selectedPath);
            }
        }
    }

    public static String getPath(Context context, Uri uri) throws URISyntaxException {
        if ("content".equalsIgnoreCase(uri.getScheme())) {
            String[] projection = { "_data" };
            Cursor cursor = null;

                cursor = context.getContentResolver().query(uri, projection, null, null, null);
                int column_index = cursor.getColumnIndexOrThrow("_data");
                if (cursor.moveToFirst()) {
                    return cursor.getString(column_index);
                }

        }
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }


}
