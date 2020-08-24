package top.stores.movieappedison.repositories

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import top.stores.movieappedison.roomDB.AppDataBase
import top.stores.movieappedison.roomDB.MovieDao
import top.stores.movieappedison.roomDB.MovieEntity
import kotlin.coroutines.CoroutineContext

class MovieRepository (application: Application) : CoroutineScope{
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val movieDao : MovieDao?

    init {
        val db = AppDataBase.getDatabase(application)
        movieDao = db?.movieDao()
    }

    fun getMovies() = movieDao?.getAllMovies()

    fun getMoviesList() = movieDao?.getAllMovies()


    fun setMoviesList(movieslist: List<MovieEntity>) {
        launch  { movieslist.forEach{
              setMessageBG(it)
        } }
    }

    private suspend fun setMessageBG(movie: MovieEntity){
        withContext(Dispatchers.IO){
            movieDao?.setMovie(movie)
        }
    }
}