package com.example.android.firstprogrammingassignment

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this);
        auth = FirebaseAuth.getInstance()

        login_button.setOnClickListener {
            val email = username_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            //login(email,password)
        }
        register_button.setOnClickListener {
            val email = username_edit_text.text.toString()
            val password = password_edit_text.text.toString()
            register(email,password)
        }
    }

    fun register(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("login:", "createUserWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(baseContext, "Successfully Registered!",
                        Toast.LENGTH_LONG).show()
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("login:", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                    //updateUI(null)
                }

                // ...
            }
    }



    fun login() {

    }
}
