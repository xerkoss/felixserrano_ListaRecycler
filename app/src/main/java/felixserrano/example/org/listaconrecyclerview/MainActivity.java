package felixserrano.example.org.listaconrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends RecyclerViewActivity {

    private static final String[] items = {"En", "un", "lugar", "de", "la", "Mancha", "de", "cuyo", "nombre",
            "no", "quiero", "acordarme", "no", "ha", "mucho", "tiempo", "que", "vivía", "un", "hidalgo", "de",
            "los", "de", "lanza", "en", "astillero", "adarga", "antigua", "rocín", "flaco", "y", "galgo", "corredor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutManager(new LinearLayoutManager(this));
        setAdapter(new AdaptadorConIcono());
    }

    class AdaptadorConIcono extends RecyclerView.Adapter<FilaHolder>{

        @Override
        public FilaHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            return (new FilaHolder(getLayoutInflater().inflate(R.layout.fila,parent,false)));
        }

        @Override
        public void onBindViewHolder(FilaHolder holder,int position)
        {
            holder.bindModel(items[position]);
        }

        @Override
        public int getItemCount(){
            return(items.length);
        }
    }

    static class FilaHolder extends RecyclerView.ViewHolder{
        TextView etiqueta = null;
        TextView tamanyo = null;
        ImageView icono = null;
        String template = null;

        FilaHolder(View fila)
        {
            super(fila);

            etiqueta = (TextView)fila.findViewById(R.id.etiqueta);
            tamanyo = (TextView)fila.findViewById(R.id.tamanyo);
            icono = (ImageView)fila.findViewById(R.id.icono);
            template = tamanyo.getContext().getString(R.string.tamanyo_template);
        }

        private void bindModel(String item)
        {
            etiqueta.setText(item);
            tamanyo.setText(String.format(template,item.length()));

            if(item.length()>4)
            {
                icono.setImageResource(android.R.drawable.btn_star_big_off);
            }
            else
            {
                icono.setImageResource(android.R.drawable.btn_star_big_on);
            }
        }
    }
}
