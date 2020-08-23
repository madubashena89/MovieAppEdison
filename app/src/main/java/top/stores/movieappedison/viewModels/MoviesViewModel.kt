package top.stores.movieappedison.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import top.stores.movieappedison.repositories.MovieRepository
import top.stores.movieappedison.roomDB.MovieEntity

class MoviesViewModel (application: Application) : AndroidViewModel(application){

    private var repository:MovieRepository = MovieRepository(application)

    fun getMessages() = repository.getMovies()

    fun setMessage(movie: MovieEntity) { repository.setMovies(movie)}

}