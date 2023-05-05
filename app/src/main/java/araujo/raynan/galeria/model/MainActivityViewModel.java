package araujo.raynan.galeria.model;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

//retorna a lista de itens
public class MainActivityViewModel extends ViewModel {
    List<MyItem> itens = new ArrayList<>();

    public List<MyItem> getItens(){
        return itens;
    }
}
