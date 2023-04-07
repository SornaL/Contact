package my.tarc.mycontact

import androidx.lifecycle.LiveData
import androidx.room.*

//Provide interface of database functions (CRUD function)
@Dao
interface ContactDao {

    //READ function
    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getAllContact(): LiveData<List<Contact>>

    //Create function
    //OnConflict = if the primary key exist just ignore it
    //suspend = execute it in a separate thread
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(contact: Contact)

    @Update
    suspend fun update(contact:Contact)

    @Delete
    suspend fun delete(contact: Contact)
}