package top.stores.movieappedison.roomDB

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "movie_table", primaryKeys = ["movieID"])
class MovieEntity {

    @ColumnInfo(name = "movie_name")
    var movieName : String? = null
}