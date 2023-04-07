package my.tarc.mycontact

import androidx.room.Entity
import androidx.room.PrimaryKey

//Define structure of a table
@Entity(tableName = "contact")  //if table name is not given, class name will be taken
data class Contact (val name: String, @PrimaryKey val phone: String) {
    override fun toString(): String {
        return "$name : $phone"
    }
}
