package top.stores.movieappedison.roomDB

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "movie_table", primaryKeys = ["id"])
class MovieEntity {

    @ColumnInfo(name = "id")
    var movieID : String? = null

    @ColumnInfo(name = "id")
    var release_date : String? = null

    @ColumnInfo(name = "id")
    var movieName : String? = null

    @ColumnInfo(name = "id")
    var movieName : String? = null

    @ColumnInfo(name = "id")
    var movieName : String? = null
}