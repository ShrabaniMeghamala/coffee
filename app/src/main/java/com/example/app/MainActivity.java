package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity=1;
    boolean addWhippedCream;
    boolean addChocolate;
    TextView priceText;
    EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        priceText=findViewById(R.id.price);
    }
    public void increment(View view){
        quantity = quantity+1;
        display(quantity);
    }
    public void decrement(View view){
        quantity = quantity-1;
        if(quantity<1){
            quantity=1;
        }
        display(quantity);
    }

    public void submitOrder(View view){
        EditText text = (EditText)findViewById(R.id.name);
        String name = text.getText().toString();

        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();


        CheckBox chocolateCheckBox=(CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate=chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);
        String priceMessage=creatOrderSummary(name,price,hasWhippedCream,hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        displayPrice(price);
    }
    private int calculatePrice(boolean addWhipped, boolean addChocolate){
        int price=5;
        if (addWhipped){
            price = price+1;
        }
        if(addChocolate){
            price=price+2;
        }
        return quantity*price;
    }
    private String creatOrderSummary(String name,int price,boolean addWhippedCream,boolean addChocolate){
        String priceMessage="Name: " + name;
        priceMessage=priceMessage+"\nAdd whipped cream:"+translate(addWhippedCream);
        priceMessage=priceMessage+"\nAdd chocolate:"+translate(addChocolate) ;
        priceMessage= priceMessage+"\nQuantity:" + quantity;
        priceMessage= priceMessage+"\nTotal:$" + price;
        priceMessage=priceMessage + "\nThank you";
        return priceMessage;
    }

    public String translate(boolean trueorFalse) {
        String ans=null;
        if (trueorFalse) {
            ans= "Yes";
        }
        else {
            ans= "NO";
        }
        return ans;
    }



    private void display(int number){
        TextView quantityTextView=(TextView) findViewById(R.id.quantity);
        quantityTextView.setText(""+number);

        CheckBox whippedCreamCheckBox=(CheckBox) findViewById(R.id.whipped);
        boolean hasWhippedCream=whippedCreamCheckBox.isChecked();


        CheckBox chocolateCheckBox=(CheckBox) findViewById(R.id.chocolate);
        boolean hasChocolate=chocolateCheckBox.isChecked();

        priceText.setText(""+calculatePrice(hasWhippedCream,hasChocolate));
    }
    private void displayPrice(int number){
        TextView priceTextVIew=(TextView) findViewById(R.id.price);
        priceTextVIew.setText(NumberFormat.getCurrencyInstance().format(number));


    }
//    private void displayMessage(String message){
//        TextView priceTextView = (TextView) findViewById(R.id.price);
//        priceTextView.setText(message);
//    }

}