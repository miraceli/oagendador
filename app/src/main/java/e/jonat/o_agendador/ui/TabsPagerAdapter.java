package e.jonat.o_agendador.ui;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import e.jonat.o_agendador.R;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public TabsPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return CadastroNomeAnnaFragment.newInstance();
            case 1:
                return CadastroNomeSalaoFragment.newInstance();
            case 2:
                return CadastroEnderecoFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

}