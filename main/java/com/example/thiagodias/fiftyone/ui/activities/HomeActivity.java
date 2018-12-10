package com.example.thiagodias.fiftyone.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.thiagodias.fiftyone.R;
import com.example.thiagodias.fiftyone.model.Cliente;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);

        // setFragment(ProdutoFragment.create());
        // obterProduto();
    }

    @OnClick(R.id.buttonCadastrarOrdem)
    public void buttonCadastrarOrdem(){
        Intent i = new Intent(this, CadastrarActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.buttonVerOrdens)
    public void buttonVerOrdens(){
        Intent i = new Intent(this, OrdemActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.buttonLiberarOrdem)
    public void buttonLiberarOrdem(){
        Intent i = new Intent(this, PendentesActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.buttonConcluidas)
    public void buttonConcluidas(){
        Intent i = new Intent(this, ConcluidasActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.buttonServicos)
    public void buttonServicos(){
        Intent i = new Intent(this, ServicoActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.buttonClientes)
    public void buttonClientes(){
        Intent i = new Intent(this, ClienteActivity.class);
        startActivity(i);
    }

    @OnClick(R.id.buttonSair)
    public void buttonSair(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    /*
    @OnClick(R.id.buttonServicos)
    public void button2Click(){
        setFragment(ServicoFragment.create());
    }

    public void setFragment(Fragment f){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content, f);
        ft.commit();
    }

    public void obterProduto() {
        Call<ListaServico> call = FiftyoneApplication.getInstance().getServiceProduto().obterProdutos();

        call.enqueue(new Callback<ListaServico>() {
            @Override
            public void onResponse(Call<ListaServico> call, Response<ListaServico> response) {
                ServicoAdapter adapter = new ServicoAdapter(response.body().getLista(), HomeActivity.this);
                lista.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ListaServico> call, Throwable t) {
                Toast.makeText(HomeActivity.this, "Ops", Toast.LENGTH_LONG).show();
            }
        });
    }
    */
}
