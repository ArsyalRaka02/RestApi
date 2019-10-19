package com.example.restapi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.POJO.NowPlaying
import com.example.restapi.POJO.Upcoming
import com.example.restapi.R
import com.example.restapi.activities.DetailActivity
import com.example.restapi.utils.EndPoint
import com.example.restapi.utils.SquareLayout
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.upcoming_thumbnail.view.*

class UpcomingAdapter: RecyclerView.Adapter<UpcomingAdapter.ViewHolder> {

    var mMovieData : List<Upcoming.UpcomingData>? = null
    var mContext : Context? = null

    constructor(c: FragmentActivity?, data: List<Upcoming.UpcomingData>?){
        this.mContext = c
        this.mMovieData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater = LayoutInflater.from(mContext).inflate(R.layout.upcoming_thumbnail, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return mMovieData!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val upcomingData: Upcoming.UpcomingData = mMovieData!![position]

        Picasso.get()
            .load(EndPoint.IMAGE_URL_POSTER + upcomingData.poster_path)
            .into(holder!!.movieThumb)

        holder.squareLayout.setOnClickListener{
            val intent = Intent(mContext?.applicationContext, DetailActivity::class.java)
            intent.putExtra("id_movie", upcomingData.idMovie)
            intent.putExtra("title_movie", upcomingData.movieTitle)
            intent.putExtra("backdrop_movie", upcomingData.backdrop_path)
            intent.putExtra("overview_movie", upcomingData.overview)
            intent.putExtra("releasedate_movie", upcomingData.release_date)
            intent.putExtra("voteaverage_movie", upcomingData.vote_avarage)
            intent.putExtra("votecount_movie", upcomingData.vote_count)
            mContext!!.startActivity(intent)
        }
    }

    class ViewHolder(itemView : View?): RecyclerView.ViewHolder(itemView!!) {
        var movieThumb = itemView?.findViewById<View>(R.id.upcoming_thumbnail) as ImageView
        var squareLayout = itemView?.findViewById<View>(R.id.sq_upcoming) as SquareLayout
    }
}