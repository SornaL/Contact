package my.tarc.mycontact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


//Holds the UI Data
//The ViewModel survive until the application runs
class ContactViewModel (application: Application): AndroidViewModel(application) {
    //LiveData gives us updated contacts when they change
    var contactList : LiveData<List<Contact>>
    private val repository: ContactRepository

    //Connect the repository
    init {
        val contactDao = ContactDatabase.getDatabase(application).contactDao()
        repository = ContactRepository(contactDao)
        contactList = repository.allContacts
    }

    //launch - calling coroutine - async task
    fun insertContact(contact: Contact) = viewModelScope.launch{
         repository.insert(contact)
    }

    fun deleteContact(contact: Contact) = viewModelScope.launch {
        repository.delete(contact)
    }

    fun updateContact(contact: Contact) = viewModelScope.launch {
        repository.update(contact)
    }
}
