package com.tsmid.kelvinht.footballleague.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.tsmid.kelvinht.footballleague.R
import com.tsmid.kelvinht.footballleague.model.Football
import com.tsmid.kelvinht.footballleague.view.DetailFootballActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class AdapterFootball(private val list: ArrayList<Football> = arrayListOf(),
                      private val context : Context) : RecyclerView.Adapter<AdapterFootball.FootballViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewHolder {
        return FootballViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_football, parent, false))
    }

    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FootballViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameFootball: TextView = itemView.findViewById(R.id.name_football)
        private val logoFootball: ImageView = itemView.findViewById(R.id.img_football)

        fun bindItem(items: Football) {

            nameFootball.text = items.titleFootball
            items.logoFootball.let {
                Picasso.get().load(it).into(logoFootball)
            }

            itemView.setOnClickListener {
                itemView.context.toast("You Choose "+items.titleFootball)
                itemView.context.startActivity<DetailFootballActivity>("ID_FOOTBALL" to items.idFootball)
            }
        }
    }
}