package araujo.raynan.galeria.model;

import android.net.Uri;

import androidx.lifecycle.ViewModel;

//seta e retorna o local que a foto foi armazenada
public class NewItemActivityViewModel  extends ViewModel {
    Uri selectPhotoLocation = null;

    public Uri getSelectPhotoLocation() {
        return selectPhotoLocation;
    }

    public void setSelectPhotoLocation(Uri selectPhotoLocation) {
        this.selectPhotoLocation = selectPhotoLocation;
    }
}
