package com.poveev.hematomacalculator;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.ref.Cleaner;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private EditText A_number, B_number, C_number;
    private Button button;

    private Button information;



    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        resultTextView = findViewById(R.id.resultTextView);
        A_number = findViewById(R.id.A_number);
        B_number = findViewById(R.id.B_number);
        C_number = findViewById(R.id.C_number);
        button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float num1 = Float.parseFloat(A_number.getText().toString());
                float num2 = Float.parseFloat(B_number.getText().toString());
                float num3 = Float.parseFloat(C_number.getText().toString());
                float res = (num1 * num2 * num3) * 5 / 2 / 6;
                resultTextView.setText(String.valueOf(res));


            }
        });
        Button information = findViewById(R.id.information);
        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfoAlert("Подсказка");
            }
        });


    }
    private void showInfoAlert(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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

   private void showInfo(String text){

    }
    public void goSubduralHematoma(View view) {
        Intent intent = new Intent(this, SubduralHematoma.class);
        startActivity(intent);
    }
}