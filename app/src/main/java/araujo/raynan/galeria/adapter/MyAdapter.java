package araujo.raynan.galeria.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import araujo.raynan.galeria.R;
import araujo.raynan.galeria.activity.MainActivity;
import araujo.raynan.galeria.model.MyItem;

public class MyAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mainActivity);
        View v = inflater.inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    MainActivity mainActivity;
    List<MyItem> itens;

    public  MyAdapter(MainActivity mainActivity, List<MyItem> itens){
        this.mainActivity = mainActivity;
        this.itens = itens;
    }
}
