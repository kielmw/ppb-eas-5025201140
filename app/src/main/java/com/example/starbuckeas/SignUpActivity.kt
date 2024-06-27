package com.example.starbuckeas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.starbuckeas.SignInActivity



class SignUpActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var dateOfBirthEditText: EditText
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        nameEditText = findViewById(R.id.name_edit_text)
        emailEditText = findViewById(R.id.email_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        dateOfBirthEditText = findViewById(R.id.date_of_birth_edit_text)
        signUpButton = findViewById(R.id.sign_up_button)

        signUpButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val dateOfBirth = dateOfBirthEditText.text.toString()
            signUp(name, email, password, dateOfBirth)
        }
    }

    private fun signUp(name: String, email: String, password: String, dateOfBirth: String) {
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || dateOfBirth.isEmpty()) {
            Toast.makeText(this, "Harap isi semua kolom", Toast.LENGTH_SHORT).show()
        } else {
            // Simpan data ke SharedPreferences
            val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("name", name)
            editor.putString("email", email)
            editor.putString("password", password)
            editor.putString("dateOfBirth", dateOfBirth)
            editor.putBoolean("rewardClaimed", false)
            editor.apply()

            Toast.makeText(this, "Pendaftaran berhasil! Reward ditambahkan.", Toast.LENGTH_LONG).show()

            // Pindah ke halaman SignIn
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
