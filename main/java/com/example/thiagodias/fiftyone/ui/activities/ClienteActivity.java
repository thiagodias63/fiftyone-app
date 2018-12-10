package com.example.thiagodias.fiftyone.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.example.thiagodias.fiftyone.R;
import com.example.thiagodias.fiftyone.app.FiftyoneApplication;
import com.example.thiagodias.fiftyone.model.ListaCliente;
import com.example.thiagodias.fiftyone.model.ListaServico;
import com.example.thiagodias.fiftyone.ui.adapters.ClienteAdapter;
import com.example.thiagodias.fiftyone.ui.adapters.ServicoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClienteActivity extends AppCompatActivity {

    @BindView(R.id.lista)
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);

        ButterKnife.bind(this);

        obterServicos();
    }


    @OnClick(R.id.buttonHome)
    public void buttonHome(){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    public void obterServicos() {
        Call<ListaCliente> call = FiftyoneApplication.getInstance().getServiceRelatorio().obterClientes();

        call.enqueue(new Callback<ListaCliente>() {
            @Override
            public void onResponse(Call<ListaCliente> call, Response<ListaCliente> response) {
                ClienteAdapter adapter = new ClienteAdapter(response.body().getLista(), ClienteActivity.this);
                lista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListaCliente> call, Throwable t) {
                Toast.makeText(ClienteActivity.this, "Falha na requisição", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
