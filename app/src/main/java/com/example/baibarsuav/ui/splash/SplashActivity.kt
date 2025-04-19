package com.example.baibarsuav.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import com.example.baibarsuav.databinding.ActivitySplashBinding
import com.example.baibarsuav.ui.main.MainActivity
import com.example.core.base.BaseActivity
import com.example.core.utils.gone
import com.example.core.utils.visible
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    override fun getViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun getViewModelClass(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }

    override fun setupUI() {
        setUpAnimation()
    }

    private fun setUpAnimation() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.apply {
                delay(1000)
                textViewAppName.visible()
                delay(2000)
                buttonStarted.visible()
            }
        }

        binding.buttonStarted.setOnClickListener {
            binding.apply {
                lvAnimation.apply {
                    visible()
                    playAnimation()

                    animate()
                        .scaleX(0f)
                        .scaleY(0f)
                        .translationY(-500f)
                        .setDuration(2000)
                        .withEndAction {
                            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                            finish()
                        }
                        .start()
                }

                textViewAppName.gone()
                buttonStarted.gone()
            }
        }
    }
}
