package br.udesc.oagendador.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.udesc.oagendador.R;

public class HorariosSalaoAdapter extends ArrayAdapter<ItemHorarioSalao> {

    public HorariosSalaoAdapter(Context context, ArrayList<ItemHorarioSalao> horarioSalao){
        super(context, 0, horarioSalao);
    }

    public static class ItemHorarioSalaoHolder{
        TextView titulo;
        TextView horarioEntrada;
        TextView horarioSaida;

        public ItemHorarioSalaoHolder(View view) {
            titulo = (TextView) view.findViewById(R.id.item_horario_titulo);
            horarioEntrada = (TextView) view.findViewById(R.id.item_horario_entrada);
            horarioSaida = (TextView) view.findViewById(R.id.item_horario_saida);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ItemHorarioSalao horarioSalao = getItem(position);
        View itemView = convertView;

        itemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_item_horario_salao, parent, false);

        ItemHorarioSalaoHolder holder;
        if (itemView.getTag() == null) {
            holder = new ItemHorarioSalaoHolder(itemView);
            itemView.setTag(holder);
        } else {
            holder = (ItemHorarioSalaoHolder) itemView.getTag();
        }

        holder.titulo.setText(horarioSalao.getTitulo());
        holder.horarioEntrada.setText(horarioSalao.getHorarioEntrada());
        holder.horarioSaida.setText(horarioSalao.getHorarioSaida());

        return itemView;
    }

}
