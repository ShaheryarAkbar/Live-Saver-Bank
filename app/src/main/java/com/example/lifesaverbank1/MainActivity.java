package com.example.lifesaverbank1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    public Button button1;
    EditText name, fname, contact, address, bgroup;
    public DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btnsearch);

        name = findViewById(R.id.Name);
        fname = findViewById(R.id.FName);
        contact = findViewById(R.id.Number);
        address = findViewById(R.id.Address);
        bgroup = findViewById(R.id.bloodgroup);
        DB = new DBHelper(MainActivity.this);
 //       button1.setOnClickListener(new View.OnClickListener() {
 //           @Override
//            public void onClick(View v) {
//                Cursor res = DB.getdata();
                //     if(res.getCount()==0){
                //       Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                //  startActivity(new Intent(getApplicationContext(),Fetchdata.class));
                //       return;

//                StringBuffer buffer = new StringBuffer();
//                while (res.moveToNext()) {
//                    buffer.append("Name :" + res.getString(0) + "\n");
//                    buffer.append("Father Name :" + res.getString(1) + "\n");
//                    buffer.append("Contact Number :" + res.getString(2) + "\n");
//                    buffer.append("Address :" + res.getString(3) + "\n");
//                    buffer.append("Blood Group :" + res.getString(4) + "\n");
//                    buffer.append("\n");
//                    buffer.append("-----------------------------------------------------------" + "\n");
//                    buffer.append("\n");
//                }
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                builder.setCancelable(true);
//                builder.setTitle("User Entries");
//                builder.setMessage(buffer.toString());
//                builder.show();
//            }
//
//        });

        button1 = (Button) findViewById(R.id.btnsearch);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(MainActivity.this, Fetchdata.class);
                    startActivity(intent);
                }
                catch (Exception ex) {
                    Toast.makeText(getApplicationContext(), ex.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        button = (Button) findViewById(R.id.btnDonor);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registration.class);
                startActivity(intent);
            }
        });
    }
}