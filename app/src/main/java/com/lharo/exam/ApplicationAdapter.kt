package com.lharo.exam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ApplicationAdapter(context: Context, feedEntries: ArrayList<MovieModel>): RecyclerView.Adapter<ApplicationAdapter.ViewHolder>() {

    private var localContext: Context? = null
    private var localFeedEntries: ArrayList<MovieModel>? = null

    init {
        localContext = context
        localFeedEntries = feedEntries
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApplicationAdapter.ViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(localContext)//Referencia al MainActivity
        val view: View = layoutInflater.inflate(R.layout.rssfeedmovies, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ApplicationAdapter.ViewHolder, position: Int) {
        val currentFeedEntry: MovieModel = localFeedEntries!![position]
        holder.textitle.text = currentFeedEntry.title
        holder.textrating.text = currentFeedEntry.imdbRating
        holder.textmeta.text = currentFeedEntry.metascore
        holder.textvotes.text = currentFeedEntry.imdbVotes

    }

    override fun getItemCount(): Int {
        return localFeedEntries?.size ?: 0
    }

    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

        val textitle: TextView = v.findViewById(R.id.textview_pelicula)
        val textrating: TextView = v.findViewById(R.id.textview_rating)
        val textmeta: TextView = v.findViewById(R.id.textview_meta)
        val textvotes: TextView  = v.findViewById(R.id.textview_votes)

    }

}