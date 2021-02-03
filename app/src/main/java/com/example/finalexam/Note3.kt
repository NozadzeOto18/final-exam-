package com.example.finalexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note_3.*
import kotlinx.android.synthetic.main.activity_note_3.ClearButton
import kotlinx.android.synthetic.main.activity_note_3.NotePageET

class Note3 : AppCompatActivity() {
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_3)
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
        val note3 = NotePageET.text.toString()
        val editor = sharedPreference.edit()
        editor.putString("note3", note3)
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        editor.apply()
    }

    fun reader() {
        val note3 = sharedPreference.getString("note3", "")
        NotePageET.setText(note3)
        val note3title = sharedPreference.getString("note3title", "")
        title3ET.setText(note3title)
    }

    fun back(v: View?) {
        savetitle()
        val intent = Intent(this, NotesPage::class.java)
        if (title3ET.text.toString().isNotEmpty()) {
            intent.putExtra("note3", title3ET.text.toString())
        } else {
            intent.putExtra("note3", "title")

        }
        startActivity(intent)
    }

    private fun savetitle() {
        val editor = sharedPreference.edit()
        editor.putString("note3title", title3ET.text.toString())
        editor.apply()
    }


}
