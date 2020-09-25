package com.example.tournament.login.dashboard.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tournament.R
import com.example.tournament.login.dashboard.model.Tournament
import java.text.SimpleDateFormat

class DashBoardAdapter(var context: Context, var data: List<Tournament>):RecyclerView.Adapter<DashBoardAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val poster:ImageView = view.findViewById(R.id.poster)
        val date:TextView =view.findViewById(R.id.date)
        val group:TextView = view.findViewById(R.id.group)
        val trophy:TextView =view.findViewById(R.id.trophy)
        val mode:TextView =view.findViewById(R.id.mode)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_tournaments, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DashBoardAdapter.ViewHolder, position: Int) {
        var model = data[position]
        holder.date.text = transformDate(model.startDate)
        holder.group.text = model.totalParticipant.toString()
        holder.trophy.text = model.totalPrize.toString()
        holder.mode.text = model.team
        Glide.with(context).load(model.image).placeholder(R.drawable.logo).into(holder.poster)
    }

    private fun transformDate(startDate: String):String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        val outputFormat = SimpleDateFormat("MMM dd, yyyy")
        val date = inputFormat.parse(startDate)
        val formattedDate = outputFormat.format(date)
        return formattedDate



    }
}