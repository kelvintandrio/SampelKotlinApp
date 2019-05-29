package com.tsmid.kelvinht.fotballleague2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tsmid.kelvinht.fotballleague2.R
import com.tsmid.kelvinht.fotballleague2.model.FavoriteFootballMatch
import com.tsmid.kelvinht.fotballleague2.view.DetailMatch
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class AdapterFootballFavorite (private val list: MutableList<FavoriteFootballMatch> = mutableListOf(), private val context : Context ) :
                    RecyclerView.Adapter<AdapterFootballFavorite.FootballFavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballFavoriteViewHolder {
        return FootballFavoriteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent, false))
    }

    override fun onBindViewHolder(holder: FootballFavoriteViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FootballFavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameEvent : TextView = itemView.findViewById(R.id.nameMatch)
        private val nameFileEvent : TextView = itemView.findViewById(R.id.nameFileMatch)
        private val nameTim1 : TextView = itemView.findViewById(R.id.nameTim1)
        private val nameTim2 : TextView = itemView.findViewById(R.id.nameTim2)
        private val score : TextView = itemView.findViewById(R.id.scoreEvent)

        @SuppressLint("SetTextI18n")
        fun bindItem(items: FavoriteFootballMatch) {

            nameEvent.text = items.name
            nameFileEvent.text = items.nameFile
            nameTim1.text = items.team1
            nameTim2.text = items.team2
            if (items.scoreTeam2 == "null" && items.scoreTeam1 == "null") {
                score.text = "0:0"
            }
            else {
                score.text = items.scoreTeam1+":"+items.scoreTeam2
            }

            itemView.setOnClickListener {
                itemView.context.toast("You Choose "+items.name)
                itemView.context.startActivity<DetailMatch>("ID_FOOTBALL_EVENT" to items.idEvent,
                    "STATUS" to "1")
            }
        }
    }
}