package br.udesc.oagendador.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import br.udesc.oagendador.R;

public class CadastroEnderecoFragment extends Fragment {

    private static final String TAG = "SpeedDial";

    private PageViewModel pageViewModel;

    public static CadastroEnderecoFragment newInstance() {
        return new CadastroEnderecoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cadastro_endereco, container, false);

        return root;
    }
}
