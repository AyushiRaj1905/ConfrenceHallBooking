package com.example.test

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.test.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var etCaptcha: EditText
    private lateinit var ivCaptcha: ImageView
    private lateinit var btnLogin: Button
    private lateinit var btnRefreshCaptcha: Button
    private lateinit var captchaChallenge: String
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etCaptcha = findViewById(R.id.etCaptcha)
        ivCaptcha = findViewById(R.id.ivCaptcha)
        btnLogin = findViewById(R.id.btn_Login)

        btnRefreshCaptcha = findViewById(R.id.btnRefreshCaptcha)
        generateCaptchaChallenge();

        btnLogin.setOnClickListener {
            val i = Intent(this, DetailActivity::class.java)
            startActivity(i)
            val captchaResponse = etCaptcha.text.toString()
//            if (captchaResponse == captchaChallenge) {
//                Toast.makeText(
//                    this, "Login successful",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//
//            } else {
//// CAPTCHA verification failed, show an error message
//                Toast.makeText(
//                    this, "CAPTCHA verification failed",
//                    Toast.LENGTH_SHORT
//                ).show()
            //}
        }
        btnRefreshCaptcha.setOnClickListener {
// Refresh the CAPTCHA challenge
            generateCaptchaChallenge()
        }


// CAPTCHA verification failed, show an error message

// Refresh the CAPTCHA challenge

        /* fun initUI(binding: Any) {

             binding.fabBack.setOnClickListener {
                 // Handle FAB click
             }

             binding.btnLogin.setOnClickListener {
                 // Handle Login button click
             }

             binding.etForgotPassword.setOnClickListener {
                 // Handle Forgot Password text view click
             }

             binding.tvSignUp.setOnClickListener {
                 // Handle Sign Up text view click
             }

         }*/

    }

    private fun generateCaptchaChallenge() {
// Generate a random CAPTCHA challenge (6 characters)
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456";
        val random = Random
        captchaChallenge = (1..6)
            .map { chars[random.nextInt(chars.length)] }
            .joinToString("");
// Set the CAPTCHA challenge text in the TextView
        val captchaBitmap = textToBitmap(captchaChallenge)
        ivCaptcha.setImageBitmap(captchaBitmap)
    }

    private fun textToBitmap(text: String): Bitmap {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.textSize = 60f
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL
        val baseline = -paint.ascent()
        val width = (paint.measureText(text) + 0.5f).toInt()
        val height = (baseline + paint.descent() + 0.5f).toInt()
        val bitmap = Bitmap.createBitmap(
            width, height,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        canvas.drawText(text, 0f, baseline, paint)
        return bitmap;

        /*fun generateCaptcha(n: Int): String {
        // Characters to be included
        val chrs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

        // Generate n characters from above set and
        // add these characters to captcha.
        var captcha = ""
        repeat(n) {
            val index = (0 until 62).random()
            captcha += chrs[index]
        }

        return captcha
    }*/

    }
}