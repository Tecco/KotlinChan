package com.tecc0.kotlinchan.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tecc0.kotlinchan.api.QiitaApi
import com.tecc0.kotlinchan.constant.ApiService
import com.tecc0.kotlinchan.databinding.FragmentSomeBinding
import com.tecc0.kotlinchan.manager.RetrofitManager
import com.tecc0.kotlinchan.viewmodel.User
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by makoto_nishimoto on 2018/02/13.
 */

class QiitaFragment : Fragment() {

    private lateinit var binding: FragmentSomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSomeBinding.inflate(inflater, container!!, false)

        val user = User("Squall", "Leonhart")
        binding.user = user

        getScheme()

        return binding.root
    }

    private fun getScheme() {
        RetrofitManager().getRetrofit(ApiService.QIITA).create(QiitaApi::class.java)
                .index()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe({ schema ->
                    binding.textview.text = schema?.description
                }, { e -> e?.printStackTrace() })
    }

    companion object {
        fun newInstance() = QiitaFragment()
    }
}