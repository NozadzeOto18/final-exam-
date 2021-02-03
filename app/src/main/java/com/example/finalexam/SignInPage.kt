package com.example.finalexam

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_note_1.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInPage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        init()
        remembered()
    }

    private fun init() {
        auth = Firebase.auth
        sharedPreference = getSharedPreferences("remember", Context.MODE_PRIVATE)
        SignInButton.setOnClickListener() {
            signIn()
        }
    }
    private fun signIn() {
        val signInEmail = SignInEmailEditText.text.toString()
        val signInPassword = SignInPasswordEditText.text.toString()
        val editor = sharedPreference.edit()
        if (signInPassword.isNotEmpty() && signInEmail.isNotEmpty()) {
            auth.signInWithEmailAndPassword(signInEmail, signInPassword)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Authentication passed", Toast.LENGTH_SHORT).show()
                        val user = auth.currentUser
                        signInProgressBar.visibility = View.VISIBLE
                        val intent = Intent(this, NotesPage()::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                    }
                }
            if (remember.isChecked) {
                editor.putString("email", signInEmail)
                editor.putString("password", signInPassword)
                editor.apply()
            }
        }
    }
    private fun remembered() {
        var rememberedEmail = sharedPreference.getString("email", "")
        SignInEmailEditText.setText(rememberedEmail)
        var rememberedPassword = sharedPreference.getString("password","")
        SignInPasswordEditText.setText(rememberedPassword)
    }
}