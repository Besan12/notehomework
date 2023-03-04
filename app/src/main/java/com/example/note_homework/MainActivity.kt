package com.example.note_homework

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notes = ArrayList<noteModel>()
        val db = Firebase.firestore
        val arrayAdapter = adapter( this,notes )
        listnotes.adapter = arrayAdapter
        btnAdd.setOnClickListener {
            val i = Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
        db.collection("notes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    notes.add(
                        noteModel(
                            document.getString("note_title").toString(),
                            document.getString("note_description").toString(),
                            document.getString("note_letter").toString(),
                        )
                    )
                    arrayAdapter.notifyDataSetChanged()
                    Log.d(TAG, "${document.id} => ${document.data}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }
}