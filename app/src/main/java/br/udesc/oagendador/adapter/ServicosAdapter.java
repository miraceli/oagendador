package br.udesc.oagendador.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.udesc.oagendador.R;

public class ServicosAdapter extends ArrayAdapter<ItemServico> {

    public ServicosAdapter(Context context, ArrayList<ItemServico> servicos){
        super(context, 0, servicos);
    }

    public static class ItemServicoHolder{
        TextView titulo;
        TextView desc;
        TextView valor;
        TextView horario;

        public ItemServicoHolder(View view) {
            titulo = (TextView) view.findViewById(R.id.item_titulo);
            desc = (TextView) view.findViewById(R.id.item_desc);
            valor = (TextView) view.findViewById(R.id.item_valor);
            horario = (TextView) view.findViewById(R.id.item_horário);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemServico servico = getItem(position);
        View itemView = convertView;

        itemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_servico, parent, false);

        ItemServicoHolder holder;
        if (itemView.getTag() == null) {
            holder = new ItemServicoHolder(itemView);
            itemView.setTag(holder);
        } else {
            holder = (ItemServicoHolder) itemView.getTag();
        }

        holder.titulo.setText(servico.getTitulo());
        holder.desc.setText(servico.getDescricao());
        holder.valor.setText(servico.getValor());
        if(servico.getHorarioEntrada() == null || servico.getHorarioSaida() == null ){
            holder.horario.setText("");
        }
        else{
            holder.horario.setText(servico.getHorarioEntrada() + " - " + servico.getHorarioSaida());
        }

        return itemView;
    }

}
