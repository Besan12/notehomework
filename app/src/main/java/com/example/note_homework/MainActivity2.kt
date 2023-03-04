package com.example.note_homework

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.view.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val db = Firebase.firestore

        add.setOnClickListener{
            val title = ntitle.text.toString()
            val description = description.text.toString()
            val letter = nletter.text.toString()
            val userNote = hashMapOf(
                "note_title" to title,
                "note_description" to description,
                "note_letter" to letter
            )
            db.collection("notes")
                .add(userNote)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    val i = Intent(this,MainActivity::class.java)
                    startActivity(i)
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }

    }
}