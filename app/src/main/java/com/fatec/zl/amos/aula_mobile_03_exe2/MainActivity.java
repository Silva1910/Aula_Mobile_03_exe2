package com.fatec.zl.amos.aula_mobile_03_exe2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etConsumo;
    private EditText etQuantidade;
    private TextView tvRes;
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
        etQuantidade = findViewById(R.id.etQuantidade);
        etQuantidade.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etConsumo = findViewById(R.id.etConsumo);
        etConsumo.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        tvRes = findViewById(R.id.tvRes);
        tvRes.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());


    }

    private void calc(){
        float quant = Float.parseFloat(etQuantidade.getText().toString());
        float cons = Float.parseFloat(etConsumo.getText().toString());

        float autonomia = quant * cons;

         autonomia = autonomia * 1000;

        tvRes.setText("a autonomia e de => " + autonomia + " metros");

        etQuantidade.setText("");
        etConsumo.setText("");
    }

}