package com.example.thiagodias.fiftyone.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thiagodias.fiftyone.R;
import com.example.thiagodias.fiftyone.app.FiftyoneApplication;
import com.example.thiagodias.fiftyone.model.ListaServico;
import com.example.thiagodias.fiftyone.ui.adapters.ServicoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicoActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servico);

        ButterKnife.bind(this);

        obterServicos();
    }


    @OnClick(R.id.buttonHome)
    public void buttonHome(){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void obterServicos() {
        Call<ListaServico> call = FiftyoneApplication.getInstance().getServiceRelatorio().obterServicos();

        call.enqueue(new Callback<ListaServico>() {
            @Override
            public void onResponse(Call<ListaServico> call, Response<ListaServico> response) {
                ServicoAdapter adapter = new ServicoAdapter(response.body().getLista(), ServicoActivity.this);
                lista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListaServico> call, Throwable t) {
                Toast.makeText(ServicoActivity.this, "Falha na requisição", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
