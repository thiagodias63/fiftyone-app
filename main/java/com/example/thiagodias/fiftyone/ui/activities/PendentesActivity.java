package com.example.thiagodias.fiftyone.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thiagodias.fiftyone.R;
import com.example.thiagodias.fiftyone.app.FiftyoneApplication;
import com.example.thiagodias.fiftyone.model.ListaOrdem;
import com.example.thiagodias.fiftyone.ui.adapters.OrdemAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendentesActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordem);

        ButterKnife.bind(this);
        obterOrdens();
    }

    @OnClick(R.id.buttonHome)
    public void buttonHome(){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void obterOrdens() {
        Call<ListaOrdem> call = FiftyoneApplication.getInstance().getServiceOrdem().listarOrdensPendentes();

        call.enqueue(new Callback<ListaOrdem>() {
            @Override
            public void onResponse(Call<ListaOrdem> call, Response<ListaOrdem> response) {
                OrdemAdapter adapter = new OrdemAdapter(response.body().getLista(), PendentesActivity.this);
                lista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListaOrdem> call, Throwable t) {
                Toast.makeText(PendentesActivity.this, "Ops", Toast.LENGTH_LONG).show();
            }
        });
    }
}
