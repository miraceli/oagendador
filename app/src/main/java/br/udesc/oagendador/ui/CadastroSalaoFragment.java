package br.udesc.oagendador.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import br.udesc.oagendador.R;
import br.udesc.oagendador.adapter.HorariosSalaoAdapter;
import br.udesc.oagendador.adapter.ItemHorarioSalao;
import br.udesc.oagendador.components.DialogHorarioSalao;
import ca.antonious.materialdaypicker.MaterialDayPicker;

public class CadastroSalaoFragment extends Fragment  {

    private PageViewModel pageViewModel;

    ListView listaHorarios;
    ArrayList<ItemHorarioSalao> arrayList;

    public static CadastroSalaoFragment newInstance() {
        return new CadastroSalaoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cadastro_salao, container, false);

        ListView list = view.findViewById(R.id.list_horarios_salao);

        final MaterialDayPicker materialDayPicker = view.findViewById(R.id.dayPicker);

        arrayList = new ArrayList<>();

        materialDayPicker.setDayPressedListener(new MaterialDayPicker.DayPressedListener() {
            @Override
            public void onDayPressed(@NonNull MaterialDayPicker.Weekday weekday, boolean isSelected) {
                HorariosSalaoAdapter adapter = new HorariosSalaoAdapter(view.getContext(), arrayList);

                listaHorarios = list;

                listaHorarios.setAdapter(adapter);

                if(isSelected == true) {
                    switch (weekday.name()) {
                        case "SUNDAY":
                            inserirItemHorarioSalao(arrayList, arrayList.size(), new ItemHorarioSalao(0,"Domingo"),7);
                            break;
                        case "MONDAY":
                            inserirItemHorarioSalao(arrayList, arrayList.size(), new ItemHorarioSalao(1,"Segunda"),7);
                            break;
                        case "TUESDAY":
                            inserirItemHorarioSalao(arrayList, arrayList.size(), new ItemHorarioSalao(2,"Terça"),7);
                            break;
                        case "WEDNESDAY":
                            inserirItemHorarioSalao(arrayList, arrayList.size(), new ItemHorarioSalao(3,"Quarta"),7);
                            break;
                        case "THURSDAY":
                            inserirItemHorarioSalao(arrayList, arrayList.size(), new ItemHorarioSalao(4,"Quinta"),7);
                            break;
                        case "FRIDAY":
                            inserirItemHorarioSalao(arrayList, arrayList.size(), new ItemHorarioSalao(5,"Sexta"),7);
                            break;
                        case "SATURDAY":
                            inserirItemHorarioSalao(arrayList, arrayList.size(), new ItemHorarioSalao(6,"Sábado"),7);
                            break;
                    }
                }
                else {
                    switch (weekday.name()) {
                        case "SUNDAY":
                            deletarItemHorarioSalao(0,arrayList);
                            break;
                        case "MONDAY":
                            deletarItemHorarioSalao(1,arrayList);
                            break;
                        case "TUESDAY":
                            deletarItemHorarioSalao(2,arrayList);
                            break;
                        case "WEDNESDAY":
                            deletarItemHorarioSalao(3,arrayList);
                            break;
                        case "THURSDAY":
                            deletarItemHorarioSalao(4,arrayList);
                            break;
                        case "FRIDAY":
                            deletarItemHorarioSalao(5,arrayList);
                            break;
                        case "SATURDAY":
                            deletarItemHorarioSalao(6,arrayList);
                            break;
                    }
                }

                listaHorarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        ItemHorarioSalao itemHorarioSalao = arrayList.get(position);
                        DialogHorarioSalao.display(getActivity().getSupportFragmentManager(), itemHorarioSalao, adapter);
                    }
                });
            }
        });
        return view;
    }

    void inserirItemHorarioSalao(ArrayList<ItemHorarioSalao> arrayList, int n, ItemHorarioSalao itemHorarioSalao, int capacity) {
        if (n < capacity) {
            int i;
            arrayList.add(null);
            for (i = n - 1; (i >= 0 && arrayList.get(i).getIndice() > itemHorarioSalao.getIndice()); i--)
                arrayList.set(i + 1, arrayList.get(i));

            arrayList.set(i + 1, itemHorarioSalao);
        }
    }

    private void deletarItemHorarioSalao(int indice, ArrayList<ItemHorarioSalao> arrayList){
        int contador = 0;
        /*Iteração no contador do ArrayList dos Horários*/
        while ( contador < arrayList.size() ){
            /* Verifica qual o índice do item selecionado */
            if (arrayList.get(contador).getIndice() == indice){

                for ( int i = 0; i < arrayList.size(); i++ ) {
                    /* Só realiza a lógica a partir do item selecionado para frente */
                    if(i >= contador){
                        if(i < arrayList.size() - 1){
                            /* Pega o valor do item posterior */
                            arrayList.set(i, arrayList.get(i+1));
                        }
                        else if(i == arrayList.size() - 1){
                            /* Remove o último item após a lista estar atualizada */
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                }
            }
            contador++;
        }
    }
}
