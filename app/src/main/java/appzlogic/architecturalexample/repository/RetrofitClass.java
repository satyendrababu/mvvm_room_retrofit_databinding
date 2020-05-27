package appzlogic.architecturalexample.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {

    private static final String BASE_URL = "http://ec2-18-216-39-87.us-east-2.compute.amazonaws.com:8080/tapisserie/";

    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static APIService getAPIService(){
        return getRetrofitInstance().create(APIService.class);
    }
}
