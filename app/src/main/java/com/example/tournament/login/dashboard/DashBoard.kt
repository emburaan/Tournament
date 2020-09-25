package com.example.tournament.login.dashboard

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.tournament.R
import com.example.tournament.databinding.ActivityDashBoardBinding
import com.example.tournament.login.dashboard.adapter.DashBoardAdapter
import com.example.tournament.login.dashboard.model.Tournament
import com.example.tournament.login.dashboard.model.TournamentModel
import com.example.tournament.network.RetrofitClient
import com.example.tournament.network.TournamentApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit


class DashBoard : AppCompatActivity() {
    lateinit var binding: ActivityDashBoardBinding
    private lateinit var viewModel: DashBoardViewModel
    private lateinit var owner: LifecycleOwner




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_dash_board
        )
        viewModel = ViewModelProviders.of(this).get(DashBoardViewModel::class.java)

        setUpObserver()
        binding.progress = true
        viewModel.fetchData()





    }

    private fun setUpObserver() {

        viewModel.tournaments.observe(this, Observer {
            setupAdapter(it)
            binding.progress=false
        })

    }


    private fun setupAdapter(tournaments: List<Tournament>) {
        Log.d("data1234",tournaments.get(1).startDate)
        binding.recyclerView.adapter = DashBoardAdapter(this,tournaments)
    }
}