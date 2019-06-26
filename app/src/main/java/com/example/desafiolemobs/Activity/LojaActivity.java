package com.example.desafiolemobs.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.desafiolemobs.R;
import com.example.desafiolemobs.adapter.LivrosLojaAdapter;
import com.example.desafiolemobs.model.Livro;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LojaActivity extends AppCompatActivity {

    private RecyclerView recyclerLivrosLoja;
    private List<Livro> livrosLoja = new ArrayList<>();
    private Button btAcessoMeusLivros;
    private Button btCompra;
    private LivrosLojaAdapter adapter;
    private Parcelable savedRecyclerLayoutState;
    private static final String BUNDLE_RECYCLER_LAYOUT = "recycler_layout";
    private static final String LIST_STATE = "list_state";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loja);
        prepararLivros();
        preparaLayoyt();


    }


    public void prepararLivros() {


        Livro livro = new Livro("Prisioneiros da Mente", "Augusto Cury", R.drawable.prisioneiros_da_mente, "26/11/2015", 20.00, false);
        livrosLoja.add(livro);

        livro = new Livro("O Poder do Hábito", "Charles Duhigg", R.drawable.poder_do_habito, "26/11/2015", 30.00, false);
        livrosLoja.add(livro);

        livro = new Livro("Harry Potter e as Relíquias da Morte", "J. K. Rowling", R.drawable.hp_reliquias_da_morte, "20/11/2015", 50.00, false);
        livrosLoja.add(livro);

        livro = new Livro("A Guerra dos Tronos", "George R. R. Martin", R.drawable.guerra_dos_tronos, "29/10/2015", 90.00, false);
        livrosLoja.add(livro);

        livro = new Livro("A Arte da Guerra", "Sun Tzu", R.drawable.a_arte_da_guerra, "26/10/2015", 25.00, false);
        livrosLoja.add(livro);

        livro = new Livro("O Hobbit", "J. R. R. Tolkien", R.drawable.hobbit, "26/10/2015", 32.00, false);
        livrosLoja.add(livro);

        livro = new Livro("Jogos Vorazes", "Suzanne Collins", R.drawable.jogos_vorazes, "25/10/2015", 16.00, false);
        livrosLoja.add(livro);

        livro = new Livro("Eragon", "Christopher Paolini", R.drawable.eragon, "22/10/2015", 14.00, false);
        livrosLoja.add(livro);

        livro = new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", R.drawable.meorias, "21/10/2015", 72.00, false);
        livrosLoja.add(livro);


    }

    public void preparaLayoyt(){
        recyclerLivrosLoja = findViewById(R.id.recyclerLivrosLoja);
        btAcessoMeusLivros = findViewById(R.id.btAcessoMeusLivros);

        btAcessoMeusLivros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });

        //definir Layput
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerLivrosLoja.setLayoutManager(layoutManager);

        //definir adapter
        adapter = new LivrosLojaAdapter(livrosLoja);
        recyclerLivrosLoja.setAdapter(adapter);
        eventosDeClick(adapter);
    }

    public void eventosDeClick(LivrosLojaAdapter adapter){
        adapter.setOnItemClickListener(new LivrosLojaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                livrosLoja.get(position);
                Toast.makeText(getApplicationContext(),"Cliquei", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDeleteClick(int position, Button bt) {
                livrosLoja.get(position);
                if(livrosLoja.get(position).getComprado() == false) {
                    livrosLoja.get(position).setComprado(true);
                    int lock = R.drawable.ic_lock_black_24dp;
                    btCompra = bt;
                    btCompra.setText("Comprado");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("livro", (Livro) livrosLoja.get(position));
                }else if(livrosLoja.get(position).getComprado() == true){
                    Toast.makeText(getApplicationContext(),"Você já comprou este livro", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}


