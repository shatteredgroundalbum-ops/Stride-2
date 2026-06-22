package com.stride.app

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.stride.app.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateOrientation()

        // Fade in logo then go to MainActivity
        binding.splashLogo.animate()
            .alpha(1f)
            .setDuration(800)
            .setStartDelay(200)
            .withEndAction {
                binding.splashLogo.animate()
                    .alpha(0f)
                    .setDuration(500)
                    .setStartDelay(1500)
                    .withEndAction {
                        startActivity(Intent(this, MainActivity::class.java))
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                        finish()
                    }
                    .start()
            }
            .start()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        updateOrientation()
    }

    private fun updateOrientation() {
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        binding.splashBgPortrait.visibility = if (isLandscape) View.GONE else View.VISIBLE
        binding.splashBgLandscape.visibility = if (isLandscape) View.VISIBLE else View.GONE
    }
}
