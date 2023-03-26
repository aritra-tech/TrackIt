package com.geekymusketeers.trackit.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekymusketeers.trackit.model.User
import com.geekymusketeers.trackit.helper.Constants
import com.geekymusketeers.trackit.repository.FirebaseRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FirebaseViewModel : ViewModel() {

    private val viewModelScope = CoroutineScope(Dispatchers.IO)
    val errorLiveData = MutableLiveData<String>()
    private val firebaseRepository: FirebaseRepository = FirebaseRepository()
    private val databaseReference: DatabaseReference =
        FirebaseDatabase.getInstance(Constants.baseURL).reference
    val saveUserStatusLiveData = MutableLiveData<Boolean>()


    fun saveUser(user: User) {
        viewModelScope.launch {
            try {
                databaseReference.child(Constants.userPath).child(user.userID).setValue(user)
                    .addOnSuccessListener {
                        saveUserStatusLiveData.postValue(true)
                    }.addOnFailureListener {
                        errorLiveData.postValue(it.message.toString())
                    }
            } catch (e: Exception) {
                errorLiveData.postValue(e.message.toString())
            }
        }
    }
}