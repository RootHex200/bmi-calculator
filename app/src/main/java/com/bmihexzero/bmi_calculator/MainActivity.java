package com.bmihexzero.bmi_calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText weight,height;

        TextView details,bmi;

        Button btnRes,btnReset,btnback;




        weight =(EditText) findViewById(R.id.weight);

        height = (EditText) findViewById(R.id.height);

        details = (TextView) findViewById(R.id.details);

        bmi  = (TextView)  findViewById(R.id.bmi);

        btnRes = (Button) findViewById(R.id.btnres);

        btnReset = (Button) findViewById(R.id.btnreset);



        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Strweight = weight.getText().toString();
                String Strheight = height.getText().toString();

                if (Strweight.equals(" "))
                {

                    weight.setError("Place Enter Your Weight");
                    weight.requestFocus();
                    return;
                }
                if (Strheight.equals(" "))
                {

                    height.setError("Place Enter Your Height");
                    height.requestFocus();
                    return;
                }

                float weight = Float.parseFloat(Strweight);

                float height  = Float.parseFloat(Strheight)/100;

                float bmiValue = BMICalculate(weight,height);

                details.setText(interpreteBMI((bmiValue)));

                bmi.setText("BMI ="+bmiValue);


            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                height.setText(" ");

                weight.setText(" ");

                details.setText(" ");
                bmi.setText(" ");

            }
        });


    }

    public float BMICalculate(float weigh,float height){

        return weigh / (height*height);
    }
    public  String interpreteBMI(float bmiValue) {

        if (bmiValue < 16)
        {
            return "Servely Underweight";
        }
        else if (bmiValue < 18.5)
        {
            return "Underweight";
        }
        else if (bmiValue <= 25)
        {
            return "Normal";
        }

        else if (bmiValue < 40)

        {
            return "Overweight";
        }
        else
        {
            return "Obese";
        }
    }

}