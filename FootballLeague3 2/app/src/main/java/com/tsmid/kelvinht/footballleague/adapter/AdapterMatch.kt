package com.tsmid.kelvinht.footballleague.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.tsmid.kelvinht.footballleague.R
import com.tsmid.kelvinht.footballleague.model.MatchFootball
import com.tsmid.kelvinht.footballleague.model.attribute.AttributeMatchFootball
import org.jetbrains.anko.toast

class AdapterMatch(private var list: MatchFootball?, private var context: Context?)
        : RecyclerView.Adapter<AdapterMatch.FootballMatchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballMatchViewHolder {
        return FootballMatchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent, false))
    }

    override fun onBindViewHolder(holder: FootballMatchViewHolder, position: Int) {
        holder.bindItem(list?.events?.get(position))
    }

    override fun getItemCount(): Int {
        return list?.events?.size!!
    }

    class FootballMatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameEvent : TextView = itemView.findViewById(R.id.nameMatch)
        private val nameFileEvent : TextView = itemView.findViewById(R.id.nameFileMatch)
        private val nameTim1 : TextView = itemView.findViewById(R.id.nameTim1)
        private val nameTim2 : TextView = itemView.findViewById(R.id.nameTim2)
        private val score : TextView = itemView.findViewById(R.id.scoreEvent)

        @SuppressLint("SetTextI18n")
        fun bindItem(items: AttributeMatchFootball?) {

            nameEvent.text = items?.nameEvent
            nameFileEvent.text = items?.nameFileEvent
            nameTim1.text = items?.team1Event
            nameTim2.text = items?.team2Event
            if (items?.scoreTeam1Event == null) {
                score.text = "0:0"
            }
            else {
                score.text = "${items.scoreTeam1Event}:${items.scoreTeam2Event}"
            }

            itemView.setOnClickListener {
                itemView.context.toast("You Choose "+items?.nameEvent)
//                itemView.context.startActivity<DetailMatch>("ID_FOOTBALL_EVENT" to items.idEvent,
//                    "STATUS" to "0")
            }
        }
    }
}