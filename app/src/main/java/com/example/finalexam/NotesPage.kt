package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NotesPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_page)
    }
    fun Note1 (view: View){
        val intent=Intent(this, Note1::class.java)
        startActivity(intent)
    }
    fun Note2 (view: View) {
        val intent=Intent (this, Note2::class.java)
        startActivity((intent))
    }
}