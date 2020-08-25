package top.stores.movieappedison.viewModels

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import top.stores.movieappedison.R
import top.stores.movieappedison.repositories.MovieRepository
import top.stores.movieappedison.roomDB.MovieEntity

class MoviesViewModel (application: Application) : AndroidViewModel(application){

    private var newSupportFragmentManager : FragmentManager? = null

    private var repository:MovieRepository = MovieRepository(application)

    fun getMovies() = repository.getMovies()

//    fun setMessage(movie: MovieEntity) { repository.setMovies(movie)}

    fun swapFragment(frag : Fragment){
        newSupportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container, frag)?.commit()

    }

}