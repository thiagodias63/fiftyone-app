package com.example.thiagodias.fiftyone.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thiagodias.fiftyone.R;
import com.example.thiagodias.fiftyone.model.Cliente;
import com.example.thiagodias.fiftyone.model.Servico;

import java.util.List;

public class ClienteAdapter extends BaseAdapter {
    private List<Cliente> lista;
    private Context context;

    public ClienteAdapter(List<Cliente> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cliente cliente = lista.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_servico, null);

        TextView nome = view.findViewById(R.id.nome);
        nome.setText("Rank #" + (position + 1) + " - " + cliente.getNome());

        TextView horas = view.findViewById(R.id.horas);
        horas.setText("Horas:" + cliente.getHoras() + " | Receita: " + cliente.getReceita());

        /*
        TextView receita = view.findViewById(R.id.receita);
        receita.setText(servico.getReceita());
        */
        return view;
    }

}
