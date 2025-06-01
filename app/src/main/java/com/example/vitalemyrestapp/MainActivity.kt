package com.example.vitalemyrestapp

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

private const val s = "La password deve contenere almeno 4 caratteri"

class MainActivity : AppCompatActivity() {

    private lateinit var txtUsername: InputType
    private lateinit var txtPassword: InputType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val users = arrayOf("User1", "User2","User3")
        val pwds = arrayOf("123","456","789")

        var btnLogin : Button = findViewById(R.id.btnLogin)
        var imgLogo: ImageView = findViewById<ImageView>(R.id.imgLogo)
        imgLogo.setImageResource(R.drawable.movie)

        btnLogin.setOnClickListener(View.OnClickListener {
            login(users, pwds)
        })

    }

    // FUNZIONE LOGIN LEGATA AL BOTTONE btnLogin

    private fun login(users: Array<String>, pwds: Array<String>) {

        // Acquisice valori compilati nei campi utente e password
        var user = findViewById<EditText>(R.id.textUsername)
        var userTXT = user.text.toString()
        var pwd = findViewById<EditText>(R.id.textPassword)
        var pwdTXT = pwd.text.toString()



        // Controlla che i campi utente e password siano compilati
        if (userTXT.isEmpty() || pwdTXT.isEmpty()) {
            Toast.makeText(this, getString(R.string.controllo_compilazione), Toast.LENGTH_SHORT).show()
            return
        }

        // Controlla che la password sia lunga almeno 3 caratteri
        if (pwdTXT.length < 3) {
            Toast.makeText(this, getString(R.string.criterio_password), Toast.LENGTH_SHORT).show()
            return
        }



        // Scorre array users e controlla se quelli inseriti corrispondo a quelli registrati nell'array (usa lo stesso indice per users e pwds)
        for(i in users.indices){
            if(users[i].contentEquals(userTXT) && pwds[i].contentEquals(pwdTXT)){
                val intent = Intent(this, menu_activity::class.java)
                var toast = Toast.makeText(this, R.string.acessoConfermato, Toast.LENGTH_LONG)
                toast.show()
                startActivity(intent)
                return
            }
        }
        // Se non trova corrispondenze nega accesso
        var toast = Toast.makeText(this, R.string.accessoErrore, Toast.LENGTH_LONG)
        toast.show()
    }
}

