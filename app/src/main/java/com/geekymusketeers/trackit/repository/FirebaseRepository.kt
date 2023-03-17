package com.geekymusketeers.trackit.repository

import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class FirebaseRepository {
    private val auth = Firebase.auth
    private val database = FirebaseDatabase.getInstance().reference
}