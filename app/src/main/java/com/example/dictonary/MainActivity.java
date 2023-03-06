package com.example.dictonary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    Button findMeaning;
    TextView output;
    TextView showText;
    EditText textInput;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findMeaning = findViewById(R.id.findMeaning);
        output = findViewById(R.id.output);
        showText = findViewById(R.id.showText);
        textInput = findViewById(R.id.textInput);

        String str[] = {"Absence","Borrow","Cryptocurrency","Delicense","Efface","Influencer","Knell","Municipal","Onset","Tract" };
        showText.setText("The words present in dictonary are :\n");
        showText.setText("The words present in dictonary are : \tAbsence ,Borrow ,Cryptocurrency ,Delicense ,Efface ,\tInfluencer ,Knell ,Municipal ,Onset ,Tract ");

        findMeaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str1[] = {"The lack or unavailability of something or someone",
                        "To take something with the intention of returning it after a period of time",
                        "Virtual or digital currency used on the internet.",
                        "To deprive a vehicle, business, or person of their license (official permission to operate",
                        "To remove, typically by erasing or rubbing.",
                        "An individual who changes or affects the way a larger group of people behave. ",
                        "The sound of a bell rung very slowly; a toll. ",
                        "Related to a self-governing district.",
                        "The early stages, or beginning of. ",
                        "An area of land that is extended. "

                        };
                String data = textInput.getText().toString();


                int var = BinarySearch(data);
                if(var==-1){
                    Toast.makeText(MainActivity.this, " Not found", Toast.LENGTH_SHORT).show();
                }
                else{
                    output.setText(str1[var]);

                }
            }
        });
    }

    public static int BinarySearch(String data) {

        String str[] = {"Absence","Borrow","Cryptocurrency","Delicense","Efface","Influencer","Knell","Municipal","Onset","Tract" };

        int low = 0;
        int high = str.length-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int t = data.compareToIgnoreCase(str[mid]);
            if (t == 0) {
                return mid;
            }
            if (t > 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

}