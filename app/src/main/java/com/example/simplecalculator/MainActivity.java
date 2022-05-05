package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstNumberET, secondNumberET;
    RadioGroup operationTypeRG;
    RadioButton plusRB, minusRB, multiplyRB, divisionRB;
    Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberET = (EditText) findViewById(R.id.firstNumberET);
        secondNumberET = (EditText) findViewById(R.id.secondNumberET);

        // operations type
        plusRB = (RadioButton) findViewById(R.id.plusRB);
        minusRB = (RadioButton) findViewById(R.id.minusRB);
        multiplyRB = (RadioButton) findViewById(R.id.multiplyRB);
        divisionRB = (RadioButton) findViewById(R.id.divisionRB);
        // group
        operationTypeRG = (RadioGroup) findViewById(R.id.operationTypeRG);


        calculateBtn = (Button) findViewById(R.id.calculateBtn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean flag = false;
                Double firstNumber = 0d, secondNumber = 0d, ans = 0d;
                    // fetching the numbers

                String fn = firstNumberET.getText().toString();
                String sn = secondNumberET.getText().toString();
// removing bugs of NumberFormat Exceptions
                if(fn.isEmpty())
                {
                    fn = "0";
                    firstNumberET.setText(fn);
                }
                if (sn.isEmpty())
                {
                    sn = "0";
                    secondNumberET.setText(sn);
                }

                firstNumber = Double.parseDouble(fn);
                secondNumber = Double.parseDouble(sn);

                if(plusRB.isChecked())
                {
                    // do plus
                    ans = firstNumber + secondNumber;
                    flag = true;
                }
                else if (minusRB.isChecked())
                {
                    // do minus
                    ans = firstNumber - secondNumber;
                    flag = true;
                }
                else if( multiplyRB.isChecked() )
                {
                    // do multiply
                    ans = firstNumber * secondNumber;
                    flag = true;
                }
                else if ( divisionRB.isChecked() ){
                    // do division
                    ans = firstNumber / secondNumber;
                    flag = true;
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please select an operation type", Toast.LENGTH_LONG).show();
                    flag = false;
                }
            // now time to display the ans

                if(flag)
                {
                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    intent.putExtra("answer", ans.toString());
                    startActivity(intent);
                }

            }
        });
    }
}