package com.ulas.doktor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class AppointmentActivity2 extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    Button btnShow,onay;
    TextView dateText;
    AlertDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment2);
        btnShow=findViewById(R.id.btnSHow);
        dateText = findViewById(R.id.date_text);
        onay=findViewById(R.id.btnOnay);


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        onay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kontrol();
            }
        });

        onay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onayla();
            }
        });

    }

    public void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date =month + "/" + dayOfMonth + "/" + year;
        dateText.setText("Randevu Tarihiniz :"+date);
    }

    public void kontrol(){
        onay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(dateText.getText().toString())){
                    Toast.makeText(AppointmentActivity2.this, "Lütfen önce tarih seçin", Toast.LENGTH_SHORT).show();
                }
                else{
                    onayla();
                }
            }
        });
    }

    public void onayla(){
        AlertDialog.Builder builder = new AlertDialog.Builder(AppointmentActivity2.this);
        builder.setTitle("Mide Botox");
        builder.setMessage("Seçtiğiniz tarih için aranacaksınız.Onaylıyor musunuz ?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Toast.makeText(AppointmentActivity2.this, "Seçtiğiniz gün saat için aranacaksınız.", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dateText.setText("");
            }
        });
        builder.show();
    }
}