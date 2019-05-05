package algo.project.kelvin.football.adapter

import algo.project.kelvin.football.R
import algo.project.kelvin.football.model.FootballPreviousMatch
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class AdapterPreviousMatch(private val list: ArrayList<FootballPreviousMatch> = arrayListOf(), private val context: Context)
        : RecyclerView.Adapter<AdapterPreviousMatch.FootballPreviousMatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPreviousMatch.FootballPreviousMatchViewHolder {
        return FootballPreviousMatchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_previous_match, parent, false))
    }

    override fun onBindViewHolder(holder: FootballPreviousMatchViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FootballPreviousMatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameEventPM : TextView = itemView.findViewById(R.id.namePreviousMatch)
        private val nameFileEventPM : TextView = itemView.findViewById(R.id.nameFilePreviousMatch)
        private val nameTim1 : TextView = itemView.findViewById(R.id.nameTim1)
        private val nameTim2 : TextView = itemView.findViewById(R.id.nameTim2)

        fun bindItem(items: FootballPreviousMatch) {

//            nameFootball.text = items.titleFootball
//            items.logoFootball.let {
//                Picasso.get().load(it).into(logoFootball)
//            }
//
//            itemView.setOnClickListener {
//                itemView.context.toast("You Choose "+items.titleFootball)
//                itemView.context.startActivity<DetailFootball>("ID_FOOTBALL" to items.idFootball)
//            }
        }
    }
}