import retrofit2.Call
import retrofit2.Response
import tp1.ApiClient
import tp1.User
import java.io.IOException

fun main(args: Array<String>) {

    val call: Call<MutableList<User>> = ApiClient.apiService.getUsers()

    try {
        val response: Response<MutableList<User>> = call.execute()

        if (response.isSuccessful) {
            val userList: List<User>? = response.body()

            if (userList != null) {
                for (user in userList) {
                    println("User : ${user._id} | Name: ${user.name} | Email: ${user.email} | Password: ${user.password}")
                }
            } else {
                println("La liste des utilisateurs est nulle.")
            }
        } else {
            println("La requête a échoué avec le code ${response.code()}")
        }
    } catch (e: IOException) {
        println("Une erreur s'est produite lors de l'exécution de la requête : ${e.message}")
    }
}