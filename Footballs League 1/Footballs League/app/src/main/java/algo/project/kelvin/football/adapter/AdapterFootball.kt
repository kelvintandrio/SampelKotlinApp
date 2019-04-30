package algo.project.kelvin.football.adapter

import algo.project.kelvin.football.DetailFootball
import algo.project.kelvin.football.model.Football
import algo.project.kelvin.football.ui.FootballMainUI
import android.support.v4.content.ContextCompat.startActivity
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
        val football = list[position]
        holder.nameFootball.text = football.titleFootball
        football.logoFootball.let {
            Picasso.get().load(it).into(holder.logoFootball)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FootballViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var nameFootball: TextView = itemView.findViewById(FootballMainUI.TitleFootball)
        var logoFootball: ImageView = itemView.findViewById(FootballMainUI.LogoFootball)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            //Toast.makeText(itemView.context, "You choose "+nameFootball.text.toString(), Toast.LENGTH_SHORT).show()
            startActivity<DetailFootball>("NAME_FOOTBALL" to "Dicoding")
            toast("Hello")
        }
    }
}