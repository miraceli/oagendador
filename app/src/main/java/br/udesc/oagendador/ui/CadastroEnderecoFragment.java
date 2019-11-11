package br.udesc.oagendador.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class CadastroEnderecoFragment extends Fragment implements View.OnClickListener {

    ListView listaDoida;
    ArrayList<ItemServico> arrayList;
    Spinner spinner;

    private PageViewModel pageViewModel;

    public static CadastroEnderecoFragment newInstance() {
        return new CadastroEnderecoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro_endereco, container, false);

        ListView list = view.findViewById(R.id.list_servicos);
        this.listaDoida = list;
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

        this.listaDoida.setAdapter(adapter);

        switch (spinner.getSelectedItem().toString()){
            case "Corte Cabelo":
                arrayList.add(new ItemServico("Cabelo", "Corte de Cabelo", "R$ 30,00", "08:00 - 18:00"));
                break;
            case "Barba":
                arrayList.add(new ItemServico("Barba", "Barba feita", "R$ 20,00", "08:00 - 18:00"));
                break;
            case "Escova":
                arrayList.add(new ItemServico("Escova", "Aplicação de Escova p/ Cabelo", "R$ 50,00", "08:00 - 12:00"));
                break;
            case "Barba e Cabelo":
                arrayList.add(new ItemServico("Barba e Cabelo", "2 por 1", "R$ 40,00", "13:30 - 17:00"));
                break;
        }

    }
}
