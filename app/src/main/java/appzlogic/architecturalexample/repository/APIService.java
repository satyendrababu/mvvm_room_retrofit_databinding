package appzlogic.architecturalexample.repository;

import appzlogic.architecturalexample.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {

    @GET("getAllUsers/{firstName}")
    Call<User> getAllUsers(@Path ("firstName") String firstName, @Query("userId") String userId);
}
