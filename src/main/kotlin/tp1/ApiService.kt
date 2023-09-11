package tp1

import retrofit2.http.*
import retrofit2.Response
import tp1.User

interface ApiService {
    @GET("/users")
    suspend fun getUsers(): Response<MutableList<User>>
}