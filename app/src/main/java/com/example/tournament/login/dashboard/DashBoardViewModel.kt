package com.example.tournament.login.dashboard

import android.graphics.Insets.add
import android.util.Log
import androidx.core.view.OneShotPreDrawListener.add
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tournament.login.dashboard.model.Tournament
import com.example.tournament.login.dashboard.model.TournamentModel
import com.example.tournament.network.RetrofitClient
import com.example.tournament.network.TournamentApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.internal.util.BackpressureHelper.add
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit


class DashBoardViewModel:ViewModel() {
    lateinit var tournamentApi:TournamentApi
    var compositeDisposable = CompositeDisposable()
    val tournaments: MutableLiveData<List<Tournament>> = MutableLiveData()
    init {
        network()

    }
    fun network() {
        val retrofit: Retrofit? = RetrofitClient.getInstance()
        tournamentApi = retrofit!!.create<TournamentApi>(TournamentApi::class.java)
    }
     fun fetchData() {
        compositeDisposable.add(
            tournamentApi.getPosts()
            !!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(OnSucess(),OnFail()))

    }
    private fun OnSucess(): (TournamentModel) -> Unit = { homemodel ->
        tournaments.value=homemodel.tournaments




    }

    private fun OnFail(): (Throwable) -> Unit = { error ->
        Log.d("error",error.message.toString())
    }



}