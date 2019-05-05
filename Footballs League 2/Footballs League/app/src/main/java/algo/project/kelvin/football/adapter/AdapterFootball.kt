package algo.project.kelvin.football.adapter

import algo.project.kelvin.football.DetailFootball
import algo.project.kelvin.football.model.Football
import algo.project.kelvin.football.ui.FootballRecyclerViewUI
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class AdapterFootball(private val list: ArrayList<Football> = arrayListOf()) : RecyclerView.Adapter<AdapterFootball.FootballViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FootballViewHolder {
        return FootballViewHolder(FootballRecyclerViewUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: FootballViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class FootballViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameFootball: TextView = itemView.findViewById(FootballRecyclerViewUI.TitleFootball)
        private val logoFootball: ImageView = itemView.findViewById(FootballRecyclerViewUI.LogoFootball)

        fun bindItem(items: Football) {

            nameFootball.text = items.titleFootball
            items.logoFootball.let {
                Picasso.get().load(it).into(logoFootball)
            }

            itemView.setOnClickListener {
                itemView.context.toast("You Choose "+items.titleFootball)
                itemView.context.startActivity<DetailFootball>("ID_FOOTBALL" to items.idFootball)
            }
        }
    }
}