package com.tecc0.kotlinchan.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tecc0.kotlinchan.databinding.FragmentMainBinding
import com.tecc0.kotlinchan.model.User

/**
 * Created by makoto_nishimoto on 2018/02/13.
 */

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container!!, false)

        val user = User("Squall", "Leonhart")
        binding.user = user

        return binding.root
    }

    companion object {
        fun newInstance(): MainFragment = MainFragment()
    }

}