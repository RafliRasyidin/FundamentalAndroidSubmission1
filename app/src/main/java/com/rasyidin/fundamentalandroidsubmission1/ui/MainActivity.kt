package com.rasyidin.fundamentalandroidsubmission1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.rasyidin.fundamentalandroidsubmission1.R
import com.rasyidin.fundamentalandroidsubmission1.adapter.ListUserAdapter
import com.rasyidin.fundamentalandroidsubmission1.model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(supportActionBar != null){
            (supportActionBar as ActionBar).title = "Github User's"
        }

        rv_user.setHasFixedSize(true)
        list.addAll(getListUser())
        showRecyclerList()
    }

    private fun getListUser(): ArrayList<User> {
        val dataUsername = resources.getStringArray(R.array.username)
        val dataName = resources.getStringArray(R.array.name)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataAvatars = resources.obtainTypedArray(R.array.avatar)

        val listUser = ArrayList<User>()
        for (position in dataUsername.indices) {
            val user = User(
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position].toInt(),
                dataCompany[position],
                dataFollowers[position].toInt(),
                dataFollowing[position].toInt(),
                dataAvatars.getResourceId(position, 0)
            )
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList() {
        rv_user.layoutManager = LinearLayoutManager(this)
        val mListUserAdapter = ListUserAdapter(list)
        rv_user.adapter = mListUserAdapter
    }
}