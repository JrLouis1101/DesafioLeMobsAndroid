package com.example.desafiolemobs.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.desafiolemobs.R;
import com.example.desafiolemobs.model.Livro;

import java.util.List;

public class LivrosLojaAdapter extends RecyclerView.Adapter<LivrosLojaAdapter.MyViewHolder> {
    private List<Livro> livrosLoja;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position, Button bt);
    }

    public void setOnItemClickListener(OnItemClickListener listener){ mListener = listener;}


    public LivrosLojaAdapter(List<Livro> livros) {
        this.livrosLoja = livros;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View livroItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.livros_loja_detalhe, parent, false);
        return new MyViewHolder(livroItem, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Livro livro = livrosLoja.get(position);
        holder.textTitulo.setText(livro.getTitle());
        holder.textEscritor.setText(livro.getWriter());
        holder.imageCapa.setImageResource(livro.getImage());
        holder.textLancamento.setText(livro.getLacamento());
        holder.textPreco.setText("R$" + livro.getPrice());


    }



    @Override
    public int getItemCount() {
        return livrosLoja.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitulo;
        private TextView textEscritor;
        private ImageView imageCapa;
        private TextView textLancamento;
        private TextView textPreco;
        private Button btComprar;


        public MyViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            textTitulo = itemView.findViewById(R.id.textTitulo);
            textEscritor = itemView.findViewById(R.id.textEscritor);
            imageCapa = itemView.findViewById(R.id.imageCapa);
            textLancamento = itemView.findViewById(R.id.textLacamento);
            textPreco = itemView.findViewById(R.id.textPreco);
            btComprar = itemView.findViewById(R.id.btCompraLivro);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            btComprar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position, btComprar);
                        }
                    }
                }
            });

        }
    }
}
