package com.tsmid.kelvinht.fotballleague2.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tsmid.kelvinht.fotballleague2.R
import com.tsmid.kelvinht.fotballleague2.db.FootballFavorite
import com.tsmid.kelvinht.fotballleague2.db.database
import com.tsmid.kelvinht.fotballleague2.model.FavoriteFootballMatch
import com.tsmid.kelvinht.fotballleague2.model.FootballMatch
import com.tsmid.kelvinht.fotballleague2.view.DetailMatch
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

@Suppress("SENSELESS_COMPARISON")
class AdapterMatch(private var list: ArrayList<FootballMatch> = arrayListOf(), private var context: Context?)
        : RecyclerView.Adapter<AdapterMatch.FootballMatchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballMatchViewHolder {
        return FootballMatchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent, false), context)
    }

    override fun onBindViewHolder(holder: FootballMatchViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FootballMatchViewHolder(itemView: View, context: Context?) : RecyclerView.ViewHolder(itemView) {

        private val nameEvent : TextView = itemView.findViewById(R.id.nameMatch)
        private val nameFileEvent : TextView = itemView.findViewById(R.id.nameFileMatch)
        private val nameTim1 : TextView = itemView.findViewById(R.id.nameTim1)
        private val nameTim2 : TextView = itemView.findViewById(R.id.nameTim2)
        private val score : TextView = itemView.findViewById(R.id.scoreEvent)
        private val context : Context = context!!

        @SuppressLint("SetTextI18n")
        fun bindItem(items: FootballMatch) {

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
                val status = cekDataFavoriteFootball(context, items.idEvent)
                itemView.context.startActivity<DetailMatch>("ID_FOOTBALL_EVENT" to items.idEvent,
                    "STATUS" to status)
            }
        }

        private fun cekDataFavoriteFootball(context: Context?, id: String) : String {
            var status = "0"
            context?.database?.use {
                val result = select(FootballFavorite.TABLE_FOOTBALL_FAVORITE)
                            .where("ID_EVENT = {id}", "id" to id)
                val favorite = result.parseList(classParser<FavoriteFootballMatch>())
                if (favorite.isNotEmpty())
                    status = "1"
            }
            return status
        }
    }
}