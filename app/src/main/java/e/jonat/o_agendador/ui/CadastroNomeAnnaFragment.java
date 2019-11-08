package e.jonat.o_agendador.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;

import androidx.lifecycle.ViewModelProviders;
import e.jonat.o_agendador.R;

public class CadastroNomeAnnaFragment extends Fragment {

    private PageViewModel pageViewModel;

    public static CadastroNomeAnnaFragment newInstance() {
        return new CadastroNomeAnnaFragment();
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
        View root = inflater.inflate(R.layout.fragment_cadastro_nome_anna, container, false);
        return root;
    }

}
