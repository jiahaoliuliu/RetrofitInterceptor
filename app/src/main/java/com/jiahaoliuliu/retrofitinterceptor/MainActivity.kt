package com.jiahaoliuliu.retrofitinterceptor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.jiahaoliuliu.retrofitinterceptor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPresenter(this)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.makeAWishButton.setOnClickListener{makeAWish()}
    }

    private fun makeAWish() {
        Toast.makeText(this, "Making your wish come to true", Toast.LENGTH_SHORT).show()
        presenter.makeAWish()
    }

    override fun showWish(wishesList: List<Wish>) {
        Toast.makeText(this, "Your wish is now completed. Wait for 48 hours to see it", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        presenter.onViewDestroyed()
        super.onDestroy()
    }
}
