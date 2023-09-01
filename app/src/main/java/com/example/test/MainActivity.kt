package com.example.test

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
    private lateinit var  userName:EditText;
    private lateinit var mEditTextPassword:EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set up ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        etCaptcha = findViewById(R.id.etCaptcha)
        ivCaptcha = findViewById(R.id.ivCaptcha)
        btnLogin = findViewById(R.id.btn_Login)
        userName = findViewById(R.id.et_UserName)
        mEditTextPassword = findViewById(R.id.et_Password)

        btnRefreshCaptcha = findViewById(R.id.btnRefreshCaptcha)
        generateCaptchaChallenge();

        btnLogin.setOnClickListener {
            //Matching user id and password
            // Declare a HashMap for user IDs and passwords
            val userCredentials = HashMap<String, String>()

            // Add user IDs and passwords to the HashMap
            userCredentials["user1"] = "pass1"
            userCredentials["user2"] = "pass2"
            userCredentials["user3"] = "pass3"
            userCredentials["user4"] = "pass4"
            // Add more user credentials as needed

            // Check if a user ID and password combination is valid
            val userId = userName.text.toString();
            val password = mEditTextPassword.text.toString();
            if (userCredentials.containsKey(userId) && userCredentials[userId] == password) {
                // Authentication successful
                // Add your logic here for a valid user
                val captchaResponse = etCaptcha.text.toString()
                if (captchaResponse == captchaChallenge) {
                    val i = Intent(this, DetailActivity::class.java)
                    startActivity(i)
                    Toast.makeText(
                        this, "Login successful",
                        Toast.LENGTH_SHORT
                    ).show()


                } else {
// CAPTCHA verification failed, show an error message
                    Toast.makeText(
                        this, "CAPTCHA verification failed",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            } else {
                // Authentication failed
                // Add your logic here for an invalid user
                Toast.makeText(this@MainActivity,
                    "Incorrct Username or Pass",Toast.LENGTH_LONG)
                    .show();

            }
        }
        btnRefreshCaptcha.setOnClickListener {
// Refresh the CAPTCHA challenge
            generateCaptchaChallenge()
        }

    }

    override fun onStart() {
        super.onStart()

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

        fun generateCaptcha(n: Int): String {
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
    }

    }
}