package br.udesc.oagendador.components;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TimePicker;

import java.time.LocalTime;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import br.udesc.oagendador.R;
import br.udesc.oagendador.adapter.HorariosSalaoAdapter;
import br.udesc.oagendador.adapter.ItemHorarioSalao;

public class DialogHorarioSalao extends DialogFragment {

    public static final String TAG = "dialog_horario_salao";

    private Toolbar toolbar;

    static ItemHorarioSalao itemHorarioSalao;
    static HorariosSalaoAdapter horariosSalaoAdapter;
    ViewGroup testeContariner;
    EditText hora01Salao;
    EditText hora02Salao;

    public static DialogHorarioSalao display(FragmentManager fragmentManager, ItemHorarioSalao item, HorariosSalaoAdapter adapter) {
        DialogHorarioSalao dialogHorarioSalao = new DialogHorarioSalao();
        dialogHorarioSalao.show(fragmentManager, TAG);
        horariosSalaoAdapter = adapter;
        itemHorarioSalao = item;
        return dialogHorarioSalao;
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
        View view = inflater.inflate(R.layout.dialog_horario_salao, container, false);

        toolbar = view.findViewById(R.id.toolbar);

        hora01Salao = view.findViewById(R.id.txtHora01Salao);
        hora01Salao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        hora01Salao.setText(LocalTime.of(hourOfDay,minutes).toString());
                    }
                }, 0, 0, false);
                timePickerDialog.show();
            }

        });

        hora02Salao = view.findViewById(R.id.txtHora02Salao);
        hora02Salao.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        hora02Salao.setText(LocalTime.of(hourOfDay,minutes).toString());
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
        toolbar.setTitle(itemHorarioSalao.getTitulo());
        hora01Salao.setText(itemHorarioSalao.getHorarioEntrada());
        hora02Salao.setText(itemHorarioSalao.getHorarioSaida());
        toolbar.inflateMenu(R.menu.example_dialog);
        toolbar.setOnMenuItemClickListener(item -> {
            itemHorarioSalao.setHorarioEntrada(hora01Salao.getText().toString());
            itemHorarioSalao.setHorarioSaida(hora02Salao.getText().toString());
            horariosSalaoAdapter.notifyDataSetChanged();
            dismiss();
            return true;
        });
    }

}