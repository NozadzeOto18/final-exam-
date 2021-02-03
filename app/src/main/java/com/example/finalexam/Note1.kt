package com.example.finalexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalexam.R.layout.activity_note_1
import kotlinx.android.synthetic.main.activity_note_1.*
import kotlinx.android.synthetic.main.activity_note_1.ClearButton
import kotlinx.android.synthetic.main.activity_note_1.NotePageET

class Note1 : AppCompatActivity() {
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_note_1)
        init()
        reader()

    }

    private fun init() {
        sharedPreference = getSharedPreferences("INFO", Context.MODE_PRIVATE)
        ClearButton.setOnLongClickListener {
            if (NotePageET.text.toString().isNotEmpty()) {
                NotePageET.setText("")
                Toast.makeText(
                    this,
                    "If you save this, some information will be lost",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Layer is empty",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }
    }

    fun save(view: View) {
        val note1 = NotePageET.text.toString()
        val editor = sharedPreference.edit()
        editor.putString("note1", note1)
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        editor.apply()

    }

    fun reader() {
        val note1 = sharedPreference.getString("note1", "")
        NotePageET.setText(note1)
        val note1title = sharedPreference.getString("note1title", "")
        title1ET.setText(note1title)
    }

    private fun savetitle() {
        val note1title = title1ET.text.toString()
        val editor = sharedPreference.edit()
        editor.putString("note1title", note1title)
        editor.apply()
    }

    fun back(v: View?) {
        savetitle()
        val intent = Intent(this, NotesPage::class.java)
        if (title1ET.text.toString().isNotEmpty()) {
            intent.putExtra("note1", title1ET.text.toString())
        } else {
            intent.putExtra("note1", "title")

        }
        startActivity(intent)
    }


}


