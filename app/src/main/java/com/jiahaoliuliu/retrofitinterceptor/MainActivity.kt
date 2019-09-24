package com.jiahaoliuliu.retrofitinterceptor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.jiahaoliuliu.retrofitinterceptor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.makeAWishButton.setOnClickListener{makeAWish()}
    }

    private fun makeAWish() {
        Toast.makeText(this, "Making your wish come to true", Toast.LENGTH_LONG).show()
    }
}
