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
            login(email,password)
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
                    val intent : Intent = Intent(this,DisplayActivity::class.java)
                    intent.putExtra(CURRENT_USER_KEY,user)
                    startActivity(intent)
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("login:", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    companion object {
        val CURRENT_USER_KEY = "Current_User"
        //val CLIENT_KEY = "Clientz"
    }

    fun login(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("login:", "signInWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(baseContext, "Successfully Logged in!",
                        Toast.LENGTH_LONG).show()
                    val intent : Intent = Intent(this,DisplayActivity::class.java)
                    intent.putExtra(CURRENT_USER_KEY,user)
                    startActivity(intent)
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("login:", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }

                // ...
            }

    }
}
