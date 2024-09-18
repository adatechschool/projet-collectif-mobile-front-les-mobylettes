package com.example.les_mobylettes;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ApiService {
    @GET("api/v1/products")
    Call<List<SpotData.Record>> getSpots();
}
