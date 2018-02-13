package com.tecc0.kotlinchan.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tecc0.kotlinchan.databinding.FragmentSomeBinding
import com.tecc0.kotlinchan.model.User

/**
 * Created by makoto_nishimoto on 2018/02/13.
 */

class SomeFragment : Fragment() {

    private lateinit var binding: FragmentSomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSomeBinding.inflate(inflater, container!!, false)

        val user = User("Squall", "Leonhart")
        binding.user = user

        return binding.root
    }

    companion object {
        fun newInstance(): SomeFragment = SomeFragment()
    }

}