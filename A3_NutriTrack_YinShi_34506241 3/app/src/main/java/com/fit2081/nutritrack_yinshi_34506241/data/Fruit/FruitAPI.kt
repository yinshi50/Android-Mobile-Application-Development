package com.fit2081.nutritrack_yinshi_34506241.data.Fruit

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface FruitAPI {
    @GET("api/fruit/{name}")
    suspend fun getFruit(@Path("name") name: String): Response<FruitResponse>

    companion object {
        const val BASE_URL = "https://www.fruityvice.com/"

        fun create(): FruitAPI {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(FruitAPI::class.java)
        }
    }


}
