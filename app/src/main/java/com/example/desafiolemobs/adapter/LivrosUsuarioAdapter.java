package com.example.desafiolemobs.adapter;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.desafiolemobs.R;
        import com.example.desafiolemobs.model.Livro;

        import java.util.ArrayList;
        import java.util.List;

public class LivrosUsuarioAdapter extends RecyclerView.Adapter<LivrosUsuarioAdapter.MyViewHolder> {

    private List<Livro> livrosUsuario;

    public LivrosUsuarioAdapter(List<Livro> livros) {
        this.livrosUsuario = livros;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View livroItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.livros_usuario_detalhe, parent, false);
        return new MyViewHolder(livroItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Livro livro = livrosUsuario.get(position);
        holder.textTitulo.setText(livro.getTitle());
        holder.textEscritor.setText(livro.getWriter());
        holder.imageCapa.setImageResource(livro.getImage());
        holder.textLancamento.setText(livro.getLacamento());

    }


    @Override
    public int getItemCount() {
        return livrosUsuario.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textTitulo;
        private TextView textEscritor;
        private ImageView imageCapa;
        private TextView textLancamento;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitulo = itemView.findViewById(R.id.textTitulo);
            textEscritor = itemView.findViewById(R.id.textEscritor);
            imageCapa = itemView.findViewById(R.id.imageCapa);
            textLancamento = itemView.findViewById(R.id.textLacamento);

        }
    }
}
