package br.udesc.oagendador;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

public class MainCadastroCliente extends AppCompatActivity {

    private RecyclerView lstDados;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_cadastro_cliente);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        lstDados = (RecyclerView)findViewById(R.id.lstDados);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
         public void onClick(View view) {

                Intent it = new Intent(MainCadastroCliente.this, CardCliente.class);
                startActivity(it);
            }
        });
    }



}
