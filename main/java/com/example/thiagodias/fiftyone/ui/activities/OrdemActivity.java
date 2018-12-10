package com.example.thiagodias.fiftyone.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thiagodias.fiftyone.R;
import com.example.thiagodias.fiftyone.app.FiftyoneApplication;
import com.example.thiagodias.fiftyone.model.ListaOrdem;
import com.example.thiagodias.fiftyone.model.Ordem;
import com.example.thiagodias.fiftyone.ui.adapters.OrdemAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrdemActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        if (intent.hasExtra("codigo")) {
            finalizarOrdem();
        }
        else if (intent.hasExtra("cliente")) {
            novaOrdem();
        } else {
            obterOrdens();
        }
        /*
        obterOrdens();
        /*
        String email;

        email= extras.getString("email");
        set_email.setText(email);
         */

    }

    @OnClick(R.id.buttonHome)
    public void buttonHome(){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void obterOrdens() {
        Call<ListaOrdem> call = FiftyoneApplication.getInstance().getServiceOrdem().listarOrdens();

        call.enqueue(new Callback<ListaOrdem>() {
            @Override
            public void onResponse(Call<ListaOrdem> call, Response<ListaOrdem> response) {
                OrdemAdapter adapter = new OrdemAdapter(response.body().getLista(), OrdemActivity.this);
                lista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListaOrdem> call, Throwable t) {
                Toast.makeText(OrdemActivity.this, "Ops", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void novaOrdem () {
        Ordem o = new Ordem();
        Bundle extras = getIntent().getExtras();
        o.setCliente(extras.getString("cliente"));
        o.setServico(extras.getString("Servico"));
        o.setHoras(extras.getString("Horas"));
        o.setPrazo(extras.getString("Prazo"));

        Call<ListaOrdem> call = FiftyoneApplication.getInstance().getServiceOrdem().cadastrar(o);

        call.enqueue(new Callback<ListaOrdem>() {
            @Override
            public void onResponse(Call<ListaOrdem> call, Response<ListaOrdem> response) {
                System.out.println(response.body().getLista());
                if (response.body().isStatus()) {
                    OrdemAdapter adapter = new OrdemAdapter(response.body().getLista(), OrdemActivity.this);
                    lista.setAdapter(adapter);
                } else {
                    Toast.makeText(OrdemActivity.this, "Erro ao cadastrar", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ListaOrdem> call, Throwable t) {
                Toast.makeText(OrdemActivity.this, "Erro ao cadastrar", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void finalizarOrdem ()
    {
        Bundle extras = getIntent().getExtras();
        // Integer i = Integer.parseInt(extras.getString("codigo"));
        String i = extras.getString("codigo");

        Call<ListaOrdem> call = FiftyoneApplication.getInstance().getServiceOrdem().finalizar(i);

        call.enqueue(new Callback<ListaOrdem>() {
            @Override
            public void onResponse(Call<ListaOrdem> call, Response<ListaOrdem> response) {
                System.out.println(response.body().getLista());
                if (response.body().isStatus()) {
                    OrdemAdapter adapter = new OrdemAdapter(response.body().getLista(), OrdemActivity.this);
                    lista.setAdapter(adapter);
                } else {
                    Toast.makeText(OrdemActivity.this, "Erro ao finalizar ordem", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ListaOrdem> call, Throwable t) {
                Toast.makeText(OrdemActivity.this, "Erro ao finalizar ordem", Toast.LENGTH_LONG).show();
            }
        });
    }
}
