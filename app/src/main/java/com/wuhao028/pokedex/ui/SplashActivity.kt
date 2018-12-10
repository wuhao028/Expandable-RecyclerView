package com.wuhao028.pokedex.ui

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.wuhao028.pokedex.R
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*
import android.view.WindowManager



/**
 *Created by WuHao028 on 4/11/18
 */

class SplashActivity : AppCompatActivity() {

    private var alphaAnimation: AlphaAnimation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getSupportActionBar()?.hide()
        setContentView(R.layout.activity_splash)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }


        var welcomePics = arrayOf(R.drawable.welcomeone, R.drawable.welcometwo,
                R.drawable.welcomethree, R.drawable.welcomefour, R.drawable.welcomefive)

        var random = Random()
        var i = random.nextInt(5)
        welcome_image.setImageResource(welcomePics[i])
        alphaAnimation = AlphaAnimation(0.3f, 1.0f)
        alphaAnimation?.duration = 800
        alphaAnimation?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(arg0: Animation) {
                jumpToMain()
            }

            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationStart(animation: Animation) {}
        })
        welcome_image.startAnimation(alphaAnimation)
    }

    fun jumpToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

}