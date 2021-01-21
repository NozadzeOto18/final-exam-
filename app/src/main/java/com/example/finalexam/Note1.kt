package com.example.finalexam

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalexam.R.layout.activity_note_1
import kotlinx.android.synthetic.main.activity_note_1.*
import kotlinx.android.synthetic.main.activity_note_1.*

class Note1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_note_1)
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


