package appzlogic.architecturalexample.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import appzlogic.architecturalexample.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static UserRepository userRepository;
    private APIService apiService;

    public UserRepository(){
        apiService = RetrofitClass.getAPIService();
    }

    public static UserRepository getInstance(){
        if (userRepository ==null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }


    public MutableLiveData<User> getAllUsers(String firstName, String userId){
        final MutableLiveData<User> listMutableLiveData = new MutableLiveData<>();
        apiService.getAllUsers(firstName, userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.e("kya","****"+response);
                if (response.code()==200){

                    listMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listMutableLiveData.setValue(null);
                Log.e("kya","****"+t.getMessage());
            }
        });
        return listMutableLiveData;
    }
}
