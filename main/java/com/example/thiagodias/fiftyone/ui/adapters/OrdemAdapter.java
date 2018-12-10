package com.example.thiagodias.fiftyone.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thiagodias.fiftyone.R;
import com.example.thiagodias.fiftyone.model.Ordem;
import com.example.thiagodias.fiftyone.ui.activities.HomeActivity;
import com.example.thiagodias.fiftyone.ui.activities.OrdemActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.OnClick;

public class OrdemAdapter extends BaseAdapter {
    private List<Ordem> lista;
    private Context context;

    public OrdemAdapter(List<Ordem> lista, Context context) {
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
        Ordem ordem = lista.get(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_ordem, null);

        TextView cliente = view.findViewById(R.id.cliente_servico);
        cliente.setText(ordem.getCodigo().toString() + " | " + ordem.getCliente() + " - " + ordem.getServico());

        /*TextView servico = view.findViewById(R.id.servico);
        servico.setText(ordem.getServico());*/

        TextView esforco = view.findViewById(R.id.horas_prazo);
        Integer horas = Integer.parseInt(ordem.getHoras());
        String horasTexto;
        if (horas > 60) {
            horas = horas / 60;
            horasTexto = horas.toString() + "Horas";
        } else {
            horasTexto = horas.toString() + "Minutos";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date prazo = sdf.parse(ordem.getPrazo());
            Date hoje = sdf.parse("10/12/2018");

            if (hoje.compareTo(prazo) > 0) {
                if (!ordem.isCompletada())
                    esforco.setText("Esforço de " + horasTexto + ". Atrasado!");
                else
                    esforco.setText("Esforço de " + horasTexto);
            } else {
                esforco.setText("Esforço de horas - " + horas.toString() + " Até o dia " + ordem.getPrazo());
            }
        } catch (ParseException e) {
            System.out.println(e);
        }
        /*
        TextView prazo = view.findViewById(R.id.prazo);
        prazo.setText(ordem.getPrazo());
        */
        /*
        TextView finalizado = view.findViewById(R.id.finalizado);
        if (!ordem.isCompletada())
            finalizado.setVisibility(View.INVISIBLE);
        else
            finalizado.setVisibility(View.VISIBLE);
        */
        Button finalizar = view.findViewById(R.id.finalizar);
        if (ordem.isCompletada()) {
            finalizar.setText("Finalizada");
            finalizar.setTextColor(Color.parseColor("#303F9F"));
            finalizar.setEnabled(false);
        } else {
            finalizar.setText("Finalizar");
            finalizar.setEnabled(true);
        }
        finalizar.setTag(position);

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Object obj = v.getTag();
                /* System.out.println(obj.toString()); */

                Intent i = new Intent(context, OrdemActivity.class);
                i.putExtra("codigo", obj.toString());
                context.startActivity(i);

                /*
                if (obj instanceof String) {
                    if ("1".equals(obj)) {
                        v.setTag("2");
                        //Your first button state
                    } else if ("2".equals(obj)) {
                        v.setTag("1");
                        //Your second button state
                    }
                }
                */
            }
        });
        return view;
    }
}
