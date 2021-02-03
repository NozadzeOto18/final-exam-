package com.example.finalexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_notes_page.*

class NotesPage : AppCompatActivity() {
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_page)
        init()

    }

    private fun init() {
        sharedPreference = getSharedPreferences("INFO", Context.MODE_PRIVATE)
        val note2TextView: String? = intent.extras?.getString("note2", "")
        this.note2TV.text = note2TextView
        val note3TextView: String? = intent.extras?.getString("note3", "")
        this.note3TV.text = note3TextView
        val note4TextView: String? = intent.extras?.getString("note4", "")
        this.note4TV.text = note4TextView
        val note1TextView: String? = intent.extras?.getString("note1", "")
        this.note1TV.text = note1TextView
        saveTitles()
        readtitles()



    }

    fun readtitles() {
        val note1tv = sharedPreference.getString("note1tv", "")
        note1TV.text = note1tv
        val note2tv = sharedPreference.getString("note2tv", "")
        note2TV.text = note2tv
        val note3tv = sharedPreference.getString("note3tv", "")
        note3TV.text = note3tv
        val note4tv = sharedPreference.getString("note4tv", "")
        note4TV.text = note4tv
    }

    fun saveTitles() {
        val editor = sharedPreference.edit()
        if (note1TV.text.toString().isNotEmpty()) {
            editor.putString("note1tv", note1TV.text.toString())
            editor.apply()
        }
        if (note2TV.text.toString().isNotEmpty()) {
            editor.putString("note2tv", note2TV.text.toString())
            editor.apply()
        }
        if (note3TV.text.toString().isNotEmpty()) {
            editor.putString("note3tv", note3TV.text.toString())
            editor.apply()
        }
        if (note4TV.text.toString().isNotEmpty()) {
            editor.putString("note4tv", note4TV.text.toString())
            editor.apply()
        }
    }

    fun note3(view: View) {
        val intent = Intent(this, Note3()::class.java)
        startActivity(intent)
    }

    fun note4(view: View) {
        val intent = Intent(this, Note4::class.java)
        startActivity((intent))
    }

    fun note1(view: View) {
        val intent = Intent(this, Note1()::class.java)
        startActivity((intent))
    }

    fun note2(view: View) {
        val intent = Intent(this, Note2::class.java)
        startActivity((intent))
    }
}