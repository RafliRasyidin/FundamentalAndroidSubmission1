package com.rasyidin.fundamentalandroidsubmission1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rasyidin.fundamentalandroidsubmission1.R
import com.rasyidin.fundamentalandroidsubmission1.model.User
import com.rasyidin.fundamentalandroidsubmission1.ui.DetailUser
import kotlinx.android.synthetic.main.item_list_user.view.*

class ListUserAdapter(private val listUser: ArrayList<User>) :
    RecyclerView.Adapter<ListUserAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listUser[position])

    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User){
            with(itemView){
                Glide.with(itemView.context)
                    .load(user.avatars)
                    .into(img_photo_user)

                tv_company.text = user.company
                tv_name.text = user.name

                itemView.setOnClickListener {
                    val moveDetail = Intent(itemView.context, DetailUser::class.java)
                    moveDetail.putExtra(DetailUser.EXTRA_USER, user)
                    itemView.context.startActivity(moveDetail)
                }
            }
        }
    }
}