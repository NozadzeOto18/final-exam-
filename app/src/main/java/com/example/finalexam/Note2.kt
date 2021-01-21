package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_note_1.*

class Note2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note2)
        init()
    }

    private fun init() {
        ClearButton.setOnLongClickListener {
            NotePageET.setText("")
            true
        }

    }

    fun back(v: View?) {
        if (NotePageET.text.toString().isEmpty()) {
            val intent = Intent(this, NotesPage::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Clear or save text", Toast.LENGTH_LONG).show()

        }
    }
}
