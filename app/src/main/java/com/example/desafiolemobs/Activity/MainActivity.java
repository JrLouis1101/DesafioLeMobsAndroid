package com.example.desafiolemobs.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.desafiolemobs.R;
import com.example.desafiolemobs.adapter.LivrosLojaAdapter;
import com.example.desafiolemobs.adapter.LivrosUsuarioAdapter;
import com.example.desafiolemobs.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btAcessoLoja;
    private RecyclerView recyclerUsuario;
    private List<Livro> meusLivros = new ArrayList<>();
    LivrosUsuarioAdapter adapter = new LivrosUsuarioAdapter(meusLivros);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btAcessoLoja = findViewById(R.id.btAcessoLoja);
        btAcessoLoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LojaActivity.class);
                startActivity(intent);


            }
        });

        recyclerUsuario = findViewById(R.id.recyclerUsuario);


        //definir Layput
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerUsuario.setLayoutManager(layoutManager);

        //definir adapter
       // LivrosUsuarioAdapter adapter = new LivrosUsuarioAdapter(meusLivros);
        recyclerUsuario.setAdapter(adapter);

    }


    public void adcionaLivro(Livro livro){
        meusLivros.add(livro);
    }

    public Livro recebeLivro(){
        Bundle dados = getIntent().getExtras();
        Livro livro = (Livro) dados.getSerializable("livro");

        return livro;
    }
}
