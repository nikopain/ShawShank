package usm.nicolas.shawshank;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import usm.nicolas.shawshank.api.Api;
import usm.nicolas.shawshank.model.Model;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retro = new Retrofit.Builder()
                .baseUrl("http://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retro.create(Api.class);

        api.getModel(1).enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if(response.isSuccessful()){
                    Model m = response.body();
                    Log.d("Modelo",m.name);
                }
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });


    }
}
