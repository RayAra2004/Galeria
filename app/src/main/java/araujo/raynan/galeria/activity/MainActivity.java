package araujo.raynan.galeria.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import araujo.raynan.galeria.R;
import araujo.raynan.galeria.adapter.MyAdapter;
import araujo.raynan.galeria.model.MainActivityViewModel;
import araujo.raynan.galeria.model.MyItem;
import araujo.raynan.galeria.util.Util;

public class MainActivity extends AppCompatActivity {

    static int NEW_ITEM_REQUEST = 1;

    //declarando arquivo myAdapter
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Capturando o botão e atribuindo  o onClick que cria uma itenção que espera o retorno da activity chamada*/
        FloatingActionButton fabAddItem = findViewById(R.id.fabAddNewItem);
        fabAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NewItemActivity.class);
                startActivityForResult(i, NEW_ITEM_REQUEST);
            }
        });

        RecyclerView rvItens = findViewById(R.id.rvItens);
        // Adiciona um novo ViewModel  de MainActivityViewModel item a lista 'itens'
        MainActivityViewModel vm = new ViewModelProvider(this).get(MainActivityViewModel.class);
        List<MyItem> itens = vm.getItens();

        //Criando um novo myAdapter passando itens como parâmetro e setando no rvItens
        myAdapter = new MyAdapter(this, itens);
        rvItens.setAdapter(myAdapter);

        //define o tamanho como fixo
        rvItens.setHasFixedSize(true);

        //posiciona o layout de maniera vertical
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvItens.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvItens.getContext(),
                DividerItemDecoration.VERTICAL);
        rvItens.addItemDecoration(dividerItemDecoration);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //verifica se o resultado é referente a esta aplicação e confere se o resultado foi OK
        if(requestCode == NEW_ITEM_REQUEST){
            if(resultCode == Activity.RESULT_OK){
                //criando um myItem e preenchendo-o
                MyItem myItem = new MyItem();
                myItem.title = data.getStringExtra("title");
                myItem.description = data.getStringExtra("description");
                Uri selectedPhotoURI = data.getData();

                //tenta transformar a imagem em bitmap
                try {
                    Bitmap photo = Util.getBitmap(MainActivity.this, selectedPhotoURI, 100, 100);
                    myItem.photo = photo;
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                }

                //Salva e adiciona um novo item
                MainActivityViewModel vm = new ViewModelProvider(this).get(MainActivityViewModel.class);
                List<MyItem> itens = vm.getItens();

                itens.add(myItem);
                myAdapter.notifyItemInserted(itens.size()-1);
            }
        }
    }
}