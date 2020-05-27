package appzlogic.architecturalexample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import appzlogic.architecturalexample.model.User;
import appzlogic.architecturalexample.repository.UserRepository;

public class UserViewModel extends ViewModel {

    private MutableLiveData<User> mutableLiveData;
    private UserRepository userRepository;
    private String firstName;
    private String userId;

    public void init(){
        if (mutableLiveData !=null){
            return;
        }
        userRepository = UserRepository.getInstance();
        mutableLiveData =userRepository.getAllUsers("saty","10");
    }

    public LiveData<User> getUserRepository(){
        return mutableLiveData;
    }
}
