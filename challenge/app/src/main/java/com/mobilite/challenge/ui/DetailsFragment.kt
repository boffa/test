package com.mobilite.challenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.mobilite.challenge.R
import com.mobilite.challenge.di.component.DependenciesInit
import com.mobilite.challenge.factory.MainViewModelFactory
import com.mobilite.challenge.viewModel.DetailsViewModel
import com.mobilite.core.common.BaseViewModelFragment
import javax.inject.Inject

class DetailsFragment : BaseViewModelFragment<DetailsViewModel>() {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private val component by  lazy { DependenciesInit.appComponent() }


    override fun getViewModel(): DetailsViewModel? {
        return ViewModelProviders.of(this).get(DetailsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        component.inject(this)
        return inflater.inflate(R.layout.details_fragment, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }





}
