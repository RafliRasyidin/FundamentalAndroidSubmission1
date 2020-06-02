package com.rasyidin.fundamentalandroidsubmission1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rasyidin.fundamentalandroidsubmission1.R
import com.rasyidin.fundamentalandroidsubmission1.model.User
import kotlinx.android.synthetic.main.activity_detail_user.*

class DetailUser : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_user)

        initToolbar()

        val dataUser = intent.getParcelableExtra(EXTRA_USER) as User
        img_user.setImageResource(dataUser.avatars!!)
        tv_username.text = dataUser.username
        tv_followers.text = dataUser.followers.toString()
        tv_following.text = dataUser.following.toString()
        tv_address.text = dataUser.location
        tv_company.text = dataUser.company
        tv_repository.text = dataUser.repository.toString()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun initToolbar(){
        val actionBar = supportActionBar
        actionBar!!.title = "Detail User"
        actionBar.setDisplayHomeAsUpEnabled(true)
    }
}