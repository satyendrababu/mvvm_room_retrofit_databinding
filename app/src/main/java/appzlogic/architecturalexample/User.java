package appzlogic.architecturalexample;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;



public class User extends BaseObservable {

    public String name;

    public User(String name) {
        this.name = name;
    }


    @Bindable
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
