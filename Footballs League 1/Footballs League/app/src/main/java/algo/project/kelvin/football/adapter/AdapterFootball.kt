package algo.project.kelvin.football.adapter

import algo.project.kelvin.football.model.Football
import algo.project.kelvin.football.ui.FootballMainUI
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class AdapterFootball(private val list: ArrayList<Football> = arrayListOf()) : RecyclerView.Adapter<AdapterFootball.FootballViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewHolder {
        return FootballViewHolder(FootballMainUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
//        holder.bindItem(list[position])
        val football = list[position]
        holder.nameFootball.text = football.titleFootball
        football.logoFootball.let {
            Picasso.get().load(it).into(holder.logoFootball)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FootballViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameFootball: TextView
        var logoFootball: ImageView

        init {
            nameFootball = itemView.findViewById(FootballMainUI.TitleFootball)
            logoFootball = itemView.findViewById(FootballMainUI.LogoFootball)
        }

//        fun bindItem(items: ClipData.Item) {
//            nameFootball.text =
//            logoFootball.image?.let { Picasso.get().load(it).into(image) }
//        }
    }
}