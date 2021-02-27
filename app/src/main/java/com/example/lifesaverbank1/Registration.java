package com.example.lifesaverbank1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText name, fname, contact, address, bgroup;
    Button insert,edit,delete;
    DBHelper DB;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.Name);
        fname = findViewById(R.id.FName);
        contact = findViewById(R.id.Number);
        address = findViewById(R.id.Address);
        bgroup = findViewById(R.id.bloodgroup);

        insert = findViewById(R.id.btnregister);
        edit = findViewById(R.id.btnedit);
        delete = findViewById(R.id.btndelete);

        DB = new DBHelper(Registration.this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nameTXT = name.getText().toString();
                    String fnameTXT = fname.getText().toString();
                    String contactTXT = contact.getText().toString();
                    String addressTXT = address.getText().toString();
                    String bgroupTXT = bgroup.getText().toString();
                    Boolean checkinsertdata = DB.insertuserdata(nameTXT, fnameTXT, contactTXT, addressTXT, bgroupTXT);

                    if (checkinsertdata == true) {
                        Toast.makeText(Registration.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Registration.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex) {
                    Toast.makeText(Registration.this,ex.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nameTXT = name.getText().toString();
                    String fnameTXT = fname.getText().toString();
                    String contactTXT = contact.getText().toString();
                    String addressTXT = address.getText().toString();
                    String bgroupTXT = bgroup.getText().toString();
                    Boolean checkeditdata = DB.updateuserdata(nameTXT, fnameTXT, contactTXT, addressTXT, bgroupTXT);

                    if (checkeditdata == true) {
                        Toast.makeText(Registration.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Registration.this, "Entry Not Update", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex) {
                    Toast.makeText(Registration.this,ex.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String nameTXT = name.getText().toString();
                    Boolean checkdeletedata = DB.deleteuserdata(nameTXT);

                    if (checkdeletedata == true) {
                        Toast.makeText(Registration.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Registration.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception ex) {
                    Toast.makeText(Registration.this,ex.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}