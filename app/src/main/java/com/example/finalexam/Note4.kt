package com.example.finalexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note_4.*
import kotlinx.android.synthetic.main.activity_note_4.ClearButton
import kotlinx.android.synthetic.main.activity_note_4.NotePageET

class Note4 : AppCompatActivity() {
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_4)
        init()
        reader()
    }

    private fun init() {
        ClearButton.setOnLongClickListener {
            if (NotePageET.text.toString().isNotEmpty()){
                NotePageET.setText("")
                Toast.makeText(
                    this,
                    "If you save this, some information will be lost",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
                Toast.makeText(
                    this,
                    "Layer is empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }
        sharedPreference = getSharedPreferences("INFO", Context.MODE_PRIVATE)
    }

    fun save(view: View) {
        val note4 = NotePageET.text.toString()
        val editor = sharedPreference.edit()
        editor.putString("note4", note4)
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        editor.apply()
    }

    fun reader() {
        val note4 = sharedPreference.getString("note4", "")
        NotePageET.setText(note4)
        val note4title = sharedPreference.getString("note4title", "")
        title4ET.setText(note4title)
    }
    private fun savetitle(){
        var editor = sharedPreference.edit()
        editor.putString("note4title", title4ET.text.toString())
        editor.apply()
    }


    fun back(v: View?) {
        savetitle()
        val intent = Intent(this, NotesPage::class.java)
        if (title4ET.text.toString().isNotEmpty()) {
            intent.putExtra("note4", title4ET.text.toString())
        }else{
            intent.putExtra("note4", "title")

        }
        startActivity(intent)
    }

}