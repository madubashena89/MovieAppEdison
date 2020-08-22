package top.stores.movieappedison.roomDB

import androidx.room.Dao
import androidx.room.Query

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getAllMovies() : List<MovieEntity>

//    @Query("SELECT * FROM movie_table WHERE title LIKE :title")
//    fun findByTitle(title: String): TodoEntity
//
//    @Insert
//    fun insertAll(vararg todo: TodoEntity)
//
//    @Delete
//    fun delete(todo: TodoEntity)
//
//    @Update
//    fun updateTodo(vararg todos: TodoEntity)
}