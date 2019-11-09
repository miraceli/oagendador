package e.jonat.o_agendador.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.textfield.TextInputEditText;
import com.maltaisn.recurpicker.Recurrence;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import ca.antonious.materialdaypicker.MaterialDayPicker;
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

        final MaterialDayPicker materialDayPicker = view.findViewById(R.id.dayPicker);
        materialDayPicker.setDaySelectionChangedListener(new MaterialDayPicker.DaySelectionChangedListener() {
            @Override
            public void onDaySelectionChanged(@NonNull List<MaterialDayPicker.Weekday> selectedDays) {
                //appendLog(String.format("[DaySelectionChangedListener]%s", selectedDays.toString()));
            }
        });

        materialDayPicker.setDayPressedListener(new MaterialDayPicker.DayPressedListener() {
            @Override
            public void onDayPressed(@NonNull MaterialDayPicker.Weekday weekday, boolean isSelected) {
                //appendLog(String.format("[DayPressedListener] %s is selected: %b", weekday.toString(), isSelected));
            }
        });

        materialDayPicker.setSelectedDays(MaterialDayPicker.Weekday.MONDAY);

        return view;
    }

    private void openDialog() {
        ExampleDialog.display(getActivity().getSupportFragmentManager());
    }
}
