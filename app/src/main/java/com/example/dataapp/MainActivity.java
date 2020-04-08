package com.example.dataapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    EditText myinput;
    TextView mytext;
    MyDBHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myinput = findViewById(R.id.etData);
        mytext = findViewById(R.id.txtDisplay);
        handler = new MyDBHandler(this, null, null, 1);

        printDatabase();
    }

    private void printDatabase() {
        String dbString = handler.databaseToString();
        mytext.setText(dbString);
        myinput.setText("");
    }

    public void addButtonClick(View view) {
        Products products = new Products(myinput.getText().toString());
        handler.addProduct(products);
        printDatabase();

    }

    public void deleteButtonClick(View view) {
        String inputText = myinput.getText().toString();
        handler.deteleProduct(inputText);
        printDatabase();
    }
}
