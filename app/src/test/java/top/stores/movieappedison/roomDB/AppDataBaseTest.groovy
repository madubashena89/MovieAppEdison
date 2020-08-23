//package top.stores.movieappedison.roomDB
//
//import kotlin.jvm.Throws
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@RunWith(AndroidJUnit4::class)
//class AppDataBaseTest {
//    private lateinit var todoDao: MovieDao
//    private lateinit var db: AppDataBase
//
//    @Before
//    fun createDb() {
//        val context = InstrumentationRegistry.getContext()
//        db = Room.inMemoryDatabaseBuilder(
//                context, AppDatabase::class.java).build()
//        todoDao = db.todoDao()
//    }
//
//    @After
//    @Throws(IOException::class)
//    fun closeDb() {
//        db.close()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun writeUserAndReadInList() {
//        val todo: TodoEntry = TodoEntry("title", "detail")
//        todoDao.insertAll(todo)
//        val todoItem = todoDao.findByTitle(todo.title)
//        assertThat(todoItem, equalTo(todo))
//    }
//}
