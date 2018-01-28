package com.ab2018.basvuruuygulamasi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.RadioButton;
import android.widget.CheckBox;
import android.widget.Button;
import android.widget.Toast;


//date kismi incele


//eksik var
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class MainActivity extends Activity {

    EditText isim,email,tarih;
    Spinner sehirler;
    String sehir="Ankara";
    RadioButton kadin,erkek;
    CheckBox chk;
    Button buton;
    DatePickerDialog.OnDateSetListener date;
    Calendar myCalendar;
    Intent detailIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isim = findViewById(R.id.isimET);
        email = findViewById(R.id.emailET);
        tarih = findViewById(R.id.bdayET);
        sehirler = findViewById(R.id.sehirSpn);
        kadin = findViewById(R.id.kadinRb);
        erkek = findViewById(R.id.erkekRb);
        chk = findViewById(R.id.chkBx);
        buton = findViewById(R.id.btn);

        myCalendar = Calendar.getInstance();//getInst sistemin su anki tarihi aliyor

        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, month);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();

            }
        };

        tarih.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        sehirler = (Spinner) findViewById(R.id.sehirSpn);
        sehirler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int index, long l) {
                if (index==0)//ilk gün ki position ile ayni index
                    sehir="Ankara";
                else if (index==1)
                    sehir="İzmir";
                else
                    sehir="Karabük";
            }
            //sehirler.setOnItemClickListener(new AdapterView.
            //abc= view.toString();//yanlıs yazılmıs
            //String obj = sp.getSelectedItem().toString();

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        tarih.setText(sdf.format(myCalendar.getTime()));
    }





    //buton icin onClick
    public void basvuru(View view) {
        /*if (isim.getText().toString().isEmpty() || email.getText().toString().isEmpty() || tarih.toString().isEmpty()) {
            Toast.makeText(this, "Lütfen boş alanları doldurunuz", Toast.LENGTH_SHORT).show();
        } else {
            String msg = "";
            msg += "Adınız ve soyadınız: " + isim.getText().toString() + "\n";
            msg += "Emailiniz: " + email.getText().toString() + "\n";
            msg += "Doğum Tarihi: "+tarih.getText() + "\n";
            msg += "Şehir: "+sehir + "\n";
            if (chk.isChecked()) {
                msg += "Akademik Bilişim'e daha önceden başvuru yaptın\n";
            } else {
                msg += "Akademik Bilişim'e daha önceden başvuru yapmadın\n";
            }

            if (kadin.isChecked()) {
                msg += "Cinsiyetiniz: Kadın \n";
            } else {
                msg += "Cinsiyetiniz: Erkek \n";
            }
            makeAndShowDialogBox(msg);
        }*/

        /*Intent (seklinde de olabilir)*/
        detailIntent = new Intent(MainActivity.this,DetailActivity.class);
        startActivity(detailIntent);
    }
        //updateLabel();
        private void makeAndShowDialogBox(String message) {

        AlertDialog.Builder myDialogBox = new AlertDialog.Builder(this);

        // set message, title, and icon
        myDialogBox.setTitle("Başvuru tamamlandı");
        myDialogBox.setMessage(message);
        myDialogBox.setIcon(R.drawable.ab_2);

        // Set three option buttons
        myDialogBox.setPositiveButton("Tamam",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // whatever should be done when answering "YES" goes
                        // here

                    }
                });

        // myDialogBox.setNegativeButton("NO",
        // new DialogInterface.OnClickListener() {
        // public void onClick(DialogInterface dialog, int whichButton) {
        // // whatever should be done when answering "NO" goes here
        //
        // }
        // });

        // myDialogBox.setNeutralButton("Cancel",
        // new DialogInterface.OnClickListener() {
        // public void onClick(DialogInterface dialog, int whichButton) {
        // // whatever should be done when answering "NO" goes here
        //
        // }
        // });

        myDialogBox.create();
        myDialogBox.show();


    }
}
