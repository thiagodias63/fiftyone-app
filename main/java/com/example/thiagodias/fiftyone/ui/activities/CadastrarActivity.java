package com.example.thiagodias.fiftyone.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thiagodias.fiftyone.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CadastrarActivity extends AppCompatActivity {
    @BindView(R.id.cliente)
    TextView cliente;
    // Spinner cliente;

    @BindView(R.id.servico)
    TextView servico;

    @BindView(R.id.prazo)
    TextView prazo;

    @BindView(R.id.horas)
    TextView horas;

    List<String> listaClientes = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        ButterKnife.bind(this);
    }


    @OnClick(R.id.buttonHome)
    public void buttonHome(){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.btn_cadastrar)
    public void Cadastrar() {

        String uCliente = cliente.getText().toString();
        String uServico = servico.getText().toString();
        String uHoras = horas.getText().toString();
        String uPrazo = prazo.getText().toString();

        Toast.makeText(getApplicationContext(), "Cadastrado" , Toast.LENGTH_SHORT).show();
        if (uCliente != "" && uHoras != "" && uPrazo != "" && uServico != "") {
            Intent i = new Intent(this, OrdemActivity.class);
            i.putExtra("cliente", uCliente);
            i.putExtra("Servico", uServico);
            i.putExtra("Horas", uHoras);
            i.putExtra("Prazo", uPrazo);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "Preencha o formúlario corretamente" , Toast.LENGTH_SHORT).show();
        }
    }

    /*
        obterClientes();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CadastrarActivity.this, android.R.layout.simple_spinner_item, listaClientes);
        //set thespinners adapter to the previously created one.
        cliente.setAdapter(adapter);

    public void obterClientes() {
        Call<ListaCliente> call = FiftyoneApplication.getInstance().getServiceCliente().obterClientes();

        call.enqueue(new Callback<ListaCliente>() {
            @Override
            public void onResponse(Call<ListaCliente> call, Response<ListaCliente> response) {
                // System.out.println(response.body().getLista());

                for(Cliente c : response.body().getLista()){
                    listaClientes.add(c.nome);
                }

            }

            @Override
            public void onFailure(Call<ListaCliente> call, Throwable t) {
                Toast.makeText(CadastrarActivity.this, "Ops", Toast.LENGTH_LONG).show();
            }
        });
    }
    */

}
