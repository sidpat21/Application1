package com.Karnataka.KA;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.Karnataka.R;

public class survey extends NavigationDrawerBaseActivity {
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    Button nextS;
    EditText elab, egat, eage;
    CheckBox cno, cas, cca, cch, cdi, chy, che,none,fever,dry,sore,nose,breath;
    TextView res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);
        appBarTxt.setText("Survey for symptoms");

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gen, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        nextS = findViewById(R.id.next);
        elab = findViewById(R.id.lab);
        egat = findViewById(R.id.gat);
        eage = findViewById(R.id.age);
        cno = findViewById(R.id.no);
        cas = findViewById(R.id.as);
        cca = findViewById(R.id.ca);
        cch = findViewById(R.id.ch);
        cdi = findViewById(R.id.di);
        chy = findViewById(R.id.hy);
        che = findViewById(R.id.he);
        res = findViewById(R.id.res);
        none=findViewById(R.id.none);
        nose=findViewById(R.id.nose);
        fever=findViewById(R.id.fever);
        sore=findViewById(R.id.sore);
        breath=findViewById(R.id.breath);
        dry=findViewById(R.id.dry);

        nextS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result();
            }
        });

    }


    // mDisplayDate = (TextView) findViewById(R.id.tvDate);

//        mDisplayDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Calendar cal = Calendar.getInstance();
//                int year = cal.get(Calendar.YEAR);
//                int month = cal.get(Calendar.MONTH);
//                int day = cal.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog dialog = new DatePickerDialog(
//                        survey.this,
//                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
//                        mDateSetListener,
//                        year,month,day);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                dialog.show();
//            }
//        });

//        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                month = month + 1;
//             //   Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);
//
//                String date = month + "/" + day + "/" + year;
//                mDisplayDate.setText(date);
//            }
//        };

    void result() {
        int r = 0;
        int age = Integer.parseInt(eage.getText().toString());
        String lab = elab.getText().toString();
        String gat = egat.getText().toString();

        if (age <= 15 && age >= 60) {
            r += 8;
        } else if (age >= 15 && age <= 30) {
            r += 3;
        } else {
            r += 4;
        }

        if (cno.isChecked()) {
            r += 2;
        }
        if (cas.isChecked()) {
            r += 8;
        }
        if (cca.isChecked()) {
            r += 6;
        }
        if (cch.isChecked()) {
            r += 9;
        }
        if (cdi.isChecked()) {
            r += 4;
        }
        if (chy.isChecked()) {
            r += 3;
        }
        if (che.isChecked()) {
            r += 5;
        }

        if (lab.equalsIgnoreCase("y")) {
            r += 20;
        } else {
            r += 0;
        }

        if (gat.equalsIgnoreCase("y")) {
            r += 12;
        } else {
            r += 0;
        }

        if (none.isChecked()) {
            r += 0;
        }
        if (fever.isChecked()) {
            r += 8;
        }
        if (dry.isChecked()) {
            r += 6;
        }
        if (breath.isChecked()) {
            r += 9;
        }
        if (sore.isChecked()) {
            r += 8;
        }
        if (nose.isChecked()) {
            r += 6;
        }



        if(r<=10){
            res.setText("Low Risk");
        }
        else if(r>10&&r<=20){
            res.setText("Medium Risk");
        }
        else{
            res.setText("High Risk");
        }

    }
}
