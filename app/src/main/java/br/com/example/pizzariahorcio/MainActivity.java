package br.com.example.pizzariahorcio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtChopp;
    EditText txtPizza;
    EditText txtRecheio;
    EditText txtPessoa;

    TextView lblResultadoConsumo;
    TextView lblResultadoServico;
    TextView lblResultadoTotal;
    TextView lblResultadoTotalPessoa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Caixas de textos*/
        txtChopp = findViewById(R.id.txtChopp);
        txtPizza = findViewById(R.id.txtPizza);
        txtRecheio = findViewById(R.id.txtRecheio);
        txtPessoa = findViewById(R.id.txtPessoa);

        /*Labels*/
        lblResultadoConsumo = findViewById(R.id.lblResultadoConsumo);
        lblResultadoServico = findViewById(R.id.lblResultadoServico);
        lblResultadoTotal = findViewById(R.id.lblResultadoTotal);
        lblResultadoTotalPessoa = findViewById(R.id.lblResultadoTotalPessoa);
    }

    public void OnCalcular (View v)
    {
        double valor0 = Double.parseDouble(txtPessoa.getText().toString());

        if(txtChopp.getText().toString().isEmpty() || txtPizza.getText().toString().isEmpty() || txtRecheio.getText().toString().isEmpty() || txtPessoa.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Insira valores nos campos vazios", Toast.LENGTH_SHORT).show();
        }
        else if (valor0 == 0)
        {
            Toast.makeText(this,"Insira um valor acima de 0.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            double chopp = Double.parseDouble(txtChopp.getText().toString()) * 7.30;
            double pizza = Double.parseDouble(txtPizza.getText().toString()) * 31.50;
            double recheio = Double.parseDouble(txtRecheio.getText().toString()) * 5.90;
            double pessoa = Double.parseDouble(txtPessoa.getText().toString());

            double resultadoConsumo = chopp + pizza + recheio;
            double resultadoServico = (resultadoConsumo * 10) / 100;
            double resultadoTotal = resultadoConsumo + resultadoServico;
            double resultadoTotalPessoa = resultadoTotal / pessoa;

            lblResultadoConsumo.setText(String.format("%.2f", resultadoConsumo));
            lblResultadoServico.setText(String.format("%.2f", resultadoServico));
            lblResultadoTotal.setText(String.format("%.2f", resultadoTotal));
            lblResultadoTotalPessoa.setText(String.format("%.2f", resultadoTotalPessoa));
        }
    }
}
