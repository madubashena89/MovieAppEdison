package top.stores.movieappedison.roomDB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getAllMovies() : List<MovieEntity>

    @Query("DELETE FROM movie_table")
    fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setMoviesList(movieList: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setMovie(movieList: MovieEntity)
}