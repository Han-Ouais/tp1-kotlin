package tp1

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.*

object ApiClient {
    private const val BASE_URL: String = "https://64ff643ff8b9eeca9e2a1214.mockapi.io/";

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://64ff643ff8b9eeca9e2a1214.mockapi.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()
    }

    val apiService :  ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}