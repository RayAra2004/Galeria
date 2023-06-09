package araujo.raynan.galeria.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    //vinculando informações ao objeto que chamou a função
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyItem myItem = itens.get(position);

        View v = holder.itemView;

        ImageView imvfoto = v.findViewById(R.id.imvPhoto);
        imvfoto.setImageBitmap(myItem.photo);

        TextView tvTitle = v.findViewById(R.id.tvTitle);
        tvTitle.setText(myItem.title);

        TextView tvdesc = v.findViewById(R.id.tvDesc);
        tvdesc.setText(myItem.description);
    }

    MainActivity mainActivity;
    List<MyItem> itens;

    @Override
    public int getItemCount() {

        return itens.size();
    }


    //preenchendo as informações
    public  MyAdapter(MainActivity mainActivity, List<MyItem> itens){
        this.mainActivity = mainActivity;
        this.itens = itens;
    }
}
