package com.example.finalexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note_2.*
import kotlinx.android.synthetic.main.activity_note_2.ClearButton
import kotlinx.android.synthetic.main.activity_note_2.NotePageET

class Note2 : AppCompatActivity() {
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_2)
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
        val note2 = NotePageET.text.toString()
        val editor = sharedPreference.edit()
        editor.putString("note2", note2)
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        editor.apply()
    }

    fun reader() {
        val note2 = sharedPreference.getString("note2", "")
        NotePageET.setText(note2)
        val note2title = sharedPreference.getString("note2title", "")
        title2ET.setText(note2title)
    }

    fun back(v: View?) {
        savetitle()
        val intent = Intent(this, NotesPage::class.java)
        if (title2ET.text.toString().isNotEmpty()) {
            intent.putExtra("note2", title2ET.text.toString())
        } else {
            intent.putExtra("note2", "title")

        }
        startActivity(intent)
    }

    private fun savetitle() {
        val editor = sharedPreference.edit()
        editor.putString("note2title", title2ET.text.toString())
        editor.apply()
    }


}