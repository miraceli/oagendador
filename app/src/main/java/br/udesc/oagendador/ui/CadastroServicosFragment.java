package br.udesc.oagendador.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import br.udesc.oagendador.Agendamento;
import br.udesc.oagendador.R;
import br.udesc.oagendador.adapter.ItemServico;
import br.udesc.oagendador.adapter.ServicosAdapter;
import br.udesc.oagendador.components.DialogServico;

import static br.udesc.oagendador.R.layout.fragment_cadastro_servicos;

public class CadastroServicosFragment extends Fragment implements View.OnClickListener {

    ListView listaServicos;
    ArrayList<ItemServico> arrayList;
    Spinner spinner;

    private PageViewModel pageViewModel;

    public static CadastroServicosFragment newInstance() {
        return new CadastroServicosFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(fragment_cadastro_servicos, container, false);

        ListView list = view.findViewById(R.id.list_servicos);
        this.listaServicos = list;

        arrayList = new ArrayList<>();

        this.spinner = view.findViewById(R.id.servicos_spinner);

        Button buttonAdicionar = view.findViewById(R.id.btAdd);
        buttonAdicionar.setOnClickListener(this);

        Button button = view.findViewById(R.id.btConfirmarAnna);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Agendamento.class);

                v.getContext().startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onClick(View v) {

        ServicosAdapter adapter = new ServicosAdapter(v.getContext(), arrayList);

        this.listaServicos.setAdapter(adapter);

        switch (spinner.getSelectedItem().toString()){
            case "Corte Cabelo":
                arrayList.add(new ItemServico("Cabelo", "Corte de Cabelo"));
                break;
            case "Barba":
                arrayList.add(new ItemServico("Barba", "Barba feita"));
                break;
            case "Escova":
                arrayList.add(new ItemServico("Escova", "Aplicação de Escova p/ Cabelo"));
                break;
            case "Barba e Cabelo":
                arrayList.add(new ItemServico("Barba e Cabelo", "2 por 1"));
                break;
        }

        this.listaServicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemServico itemServico = arrayList.get(position);
                DialogServico.display(getActivity().getSupportFragmentManager(), itemServico, adapter);
            }
        });

    }
}
