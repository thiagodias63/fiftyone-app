package com.example.thiagodias.fiftyone.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thiagodias.fiftyone.R;
import com.example.thiagodias.fiftyone.app.FiftyoneApplication;
import com.example.thiagodias.fiftyone.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;

    @BindView(R.id.senha)
    EditText senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    /*
    @OnClick(R.id.btn_logar)

    public void logarUser(){
        // Pega o valor do text do edittext
        //String nuser = username.getText().toString();
        //String nsenha = senha.getText().toString();

        /*
        //validação de login
        if(nuser.equals("thiago") && nsenha.equals("thiago")){
            Toast.makeText(getApplicationContext(),"Logado", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, HomeActivity
                    .class);
            i.putExtra("email", nuser);
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "senha ou email não confere.", Toast.LENGTH_SHORT).show();
        }
        */
    // }

    @OnClick(R.id.btn_logar)
    public void logar() {
        String uName = username.getText().toString();
        String uSenha = senha.getText().toString();
        User u = new User();

        u.setName(uName);
        u.setPassword(uSenha);

        Call<User> call = FiftyoneApplication.getInstance().getServiceUser().logar(u);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User uResponse = response.body();

                if (uResponse.isStatus()) {
                    Toast.makeText(getApplicationContext(),"Logado", Toast.LENGTH_SHORT).show();
                    entrar();
                } else {
                    Toast.makeText(MainActivity.this, "Usuário ou senha incorretos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ops", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void entrar()
    {
        Intent i = new Intent(this, HomeActivity.class);
        i.putExtra("user", username.toString());
        startActivity(i);
    }
}
