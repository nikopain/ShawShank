package usm.nicolas.shawshank.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import usm.nicolas.shawshank.model.Model;

/**
 * Created by niko on 05/04/2016.
 */
public interface Api  {

    @GET("/person/{id}")
    Call<Model> getModel(@Path("id") int id);


}
