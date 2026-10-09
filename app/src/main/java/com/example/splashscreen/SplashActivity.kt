package com.example.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // untuk menjalankan animasi logo
        val logo = findViewById<ImageView>(R.id.imgLogo)
        (logo.drawable as? Animatable)?.start()

        // setelah animasi selesai,  pindah ke halaman Home
        lifecycleScope.launch {
            delay(2200)
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }
    }
}
