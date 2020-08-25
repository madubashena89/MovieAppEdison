package top.stores.movieappedison.networkServices

import android.app.Application
import android.content.Context
import android.graphics.Movie
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import top.stores.movieappedison.repositories.MovieRepository
import top.stores.movieappedison.roomDB.MovieEntity
import java.util.*

object VolleyNetworkManager {


   // private val movieRepository = MovieRepository()

    fun downloadData(application: Application){
            val url: String = "https://api.themoviedb.org/4/list/1?page=1&api_key=d956f280a7d5133bcf5ca8233b99febf"
            val movieEntities: MutableList<MovieEntity> = ArrayList<MovieEntity>()


// get the json object
            val objectRequest = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    try {
                        val movieList = response.getJSONArray("results")
                        for (i in 0 until movieList.length()) {
                            val newMovie = MovieEntity()
                            val detailsOfMovieFromApi = movieList[i] as JSONObject
                            val gson = Gson()
                            val entity : MovieEntity = gson.fromJson(detailsOfMovieFromApi.toString(), MovieEntity::class.java)
                            Log.d("EntityValues", "$entity")
                            movieEntities.add(entity)
                        }
                        var repository : MovieRepository = MovieRepository(application)
                        repository.setMoviesList(movieEntities)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }

                },
                Response.ErrorListener { error ->
                    error.printStackTrace() })
             VolleySingleton.getInstance(application.applicationContext).addToRequestQueue(objectRequest)
        }

}