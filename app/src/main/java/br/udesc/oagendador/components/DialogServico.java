package br.udesc.oagendador.components;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.NumberFormat;
import java.time.LocalTime;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import br.udesc.oagendador.R;
import br.udesc.oagendador.adapter.ItemServico;
import br.udesc.oagendador.adapter.ServicosAdapter;

public class DialogServico extends DialogFragment {

    public static final String TAG = "dialog_horario_servico";

    private Toolbar toolbar;

    static ItemServico itemServico;
    static ServicosAdapter servicosAdapter;
    ViewGroup testeContariner;
    EditText valorServico;
    EditText hora01Servico;
    EditText hora02Servico;

    public static DialogServico display(FragmentManager fragmentManager, ItemServico item, ServicosAdapter adapter) {
        DialogServico dialogServico = new DialogServico();
        dialogServico.show(fragmentManager, TAG);
        servicosAdapter = adapter;
        itemServico = item;
        return dialogServico;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
            dialog.getWindow().setWindowAnimations(R.style.AppTheme);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        testeContariner = container;
        View view = inflater.inflate(R.layout.dialog_servico, container, false);

        toolbar = view.findViewById(R.id.toolbar);

        valorServico = view.findViewById(R.id.txtValorServico);
        valorServico.addTextChangedListener(new MascaraMonetaria(valorServico));

        hora01Servico = view.findViewById(R.id.txtHora01Servico);
        hora01Servico.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        hora01Servico.setText(LocalTime.of(hourOfDay,minutes).toString());
                    }
                }, 0, 0, false);
                timePickerDialog.show();
            }

        });

        hora02Servico = view.findViewById(R.id.txtHora02Servico);
        hora02Servico.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        hora02Servico.setText(LocalTime.of(hourOfDay,minutes).toString());
                    }
                }, 0, 0, false);
                timePickerDialog.show();
            }

        });
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setNavigationOnClickListener(v -> dismiss());
        toolbar.setTitle(itemServico.getTitulo());
        valorServico.setText(itemServico.getValor());
        hora01Servico.setText(itemServico.getHorarioEntrada());
        hora02Servico.setText(itemServico.getHorarioSaida());
        toolbar.inflateMenu(R.menu.example_dialog);
        toolbar.setOnMenuItemClickListener(item -> {
            itemServico.setValor(valorServico.getText().toString());
            itemServico.setHorarioEntrada(hora01Servico.getText().toString());
            itemServico.setHorarioSaida(hora02Servico.getText().toString());
            servicosAdapter.notifyDataSetChanged();
            dismiss();
            return true;
        });
    }

    private class MascaraMonetaria implements TextWatcher {

        final EditText campo;

        public MascaraMonetaria(EditText campo) {
            super();
            this.campo = campo;
        }

        private boolean isUpdating = false;
        // Pega a formatacao do sistema, se for brasil R$ se EUA US$
        private NumberFormat nf = NumberFormat.getCurrencyInstance();

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int after) {
            // Evita que o método seja executado varias vezes.
            // Se tirar ele entre em loop
            if (isUpdating) {
                isUpdating = false;
                return;
            }

            isUpdating = true;
            String str = s.toString();
            // Verifica se já existe a máscara no texto.
            boolean hasMask = ((str.indexOf("R$") > -1 || str.indexOf("$") > -1) &&
            (str.indexOf(".") > -1 || str.indexOf(",") > -1));
            // Verificamos se existe máscara
            if (hasMask) {
                // Retiramos a máscara.
                str = str.replaceAll("[R$]", "").replaceAll("[,]", "")
                        .replaceAll("[.]", "");
            }

            try {
                // Transformamos o número que está escrito no EditText em
                // monetário.
                str = nf.format(Double.parseDouble(str) / 100);
                campo.setText(str);
                campo.setSelection(campo.getText().length());
            } catch (NumberFormatException e) {
                s = "";
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Não utilizado
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Não utilizado
        }
    }


}