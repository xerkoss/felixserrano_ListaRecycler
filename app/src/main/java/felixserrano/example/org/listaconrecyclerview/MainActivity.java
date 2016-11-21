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

}
