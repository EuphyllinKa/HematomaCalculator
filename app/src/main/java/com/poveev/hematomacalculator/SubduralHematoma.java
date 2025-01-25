package com.poveev.hematomacalculator;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubduralHematoma extends AppCompatActivity {
    private EditText A_size;
    private EditText B_size;


    private EditText h1_size;
    private EditText h2_size;

    private Button add_SubdHemat;

    private TextView resaltViwe;

    private Button button_information;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subdural_hematoma);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_subdural_hematoma), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        A_size = findViewById(R.id.A_size);
        B_size =findViewById(R.id.B_size);

        h1_size = findViewById(R.id.h1_size);
        h2_size = findViewById(R.id.h2_size);

        add_SubdHemat = findViewById(R.id.add_SubdHemat);
        resaltViwe = findViewById(R.id.resaltViwe);

        button_information = findViewById(R.id.button_information);
        button_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               showInfoAlert("Подсказка");
            }
        });

        add_SubdHemat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float A = Float.parseFloat(A_size.getText().toString());
                float B = Float.parseFloat(B_size.getText().toString());
                float h1 = Float.parseFloat(h1_size.getText().toString());
                float h2 = Float.parseFloat(h2_size.getText().toString());

                float res = (float) (Math.PI/6*(Math.pow(h1,3)+Math.pow(h2,3))+Math.PI/8*A*B*(h1+h2));
                resaltViwe.setText(((res) + " см³"));
            }
        });
    }

    private void showInfoAlert(String text) {
            AlertDialog.Builder builder = new AlertDialog.Builder(SubduralHematoma.this);
            builder.setMessage(text)
                    .setTitle("Формулы подсчета объема гематом")
                    .setCancelable(false)
                    .setPositiveButton("Свернуть", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();



        }
    private void showInfoSG(String textSG){

    }
    public void goMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}