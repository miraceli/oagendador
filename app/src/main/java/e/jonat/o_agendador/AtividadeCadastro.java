package e.jonat.o_agendador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import e.jonat.o_agendador.ui.TabsPagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kofigyan.stateprogressbar.StateProgressBar;

public class AtividadeCadastro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade_cadastro);

        final StateProgressBar stateProgressBar = findViewById(R.id.your_state_progress_bar_id);

        TabsPagerAdapter tabsPagerAdapter = new TabsPagerAdapter(getSupportFragmentManager(), this);

        ViewPager viewPager = findViewById(R.id.view_pager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {  }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.ONE);
                        break;
                    case 1:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.TWO);
                        break;
                    case 2:
                        stateProgressBar.setCurrentStateNumber(StateProgressBar.StateNumber.THREE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });
        viewPager.setAdapter(tabsPagerAdapter);
    }





}
