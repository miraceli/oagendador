package br.udesc.oagendador.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import br.udesc.oagendador.R;

public class CadastroAnnaFragment extends Fragment {

    private PageViewModel pageViewModel;

    public static CadastroAnnaFragment newInstance() {
        return new CadastroAnnaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cadastro_anna, container, false);
        return root;
    }

}
