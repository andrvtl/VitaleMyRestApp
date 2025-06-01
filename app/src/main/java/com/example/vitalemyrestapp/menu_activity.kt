package com.example.vitalemyrestapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class menu_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        var btnSearch : Button = findViewById(R.id.btnSearch)
        var btnWebView : Button = findViewById(R.id.btnWebview)
        var btnRest : Button = findViewById(R.id.btnRest)

        btnSearch.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        })

        btnWebView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, webview_activity::class.java)
            startActivity(intent)
        })

        btnRest.setOnClickListener(View.OnClickListener {
            var toast = Toast.makeText(this, getString(R.string.rest_da_finire), Toast.LENGTH_LONG)
            toast.show()

        })
    }
}