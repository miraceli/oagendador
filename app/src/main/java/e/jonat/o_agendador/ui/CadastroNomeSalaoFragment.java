package e.jonat.o_agendador.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.maltaisn.recurpicker.Recurrence;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import e.jonat.o_agendador.R;
import e.jonat.o_agendador.components.ExampleDialog;

public class CadastroNomeSalaoFragment extends Fragment  {

    private PageViewModel pageViewModel;

    public static CadastroNomeSalaoFragment newInstance() {
        return new CadastroNomeSalaoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastro_nome_salao, container, false);

        TextInputEditText editText = view.findViewById(R.id.HorariosSalao);
        editText.setOnClickListener(v -> openDialog());

        return view;
    }

    private void openDialog() {
        ExampleDialog.display(getActivity().getSupportFragmentManager());
    }
}
