package com.mobilite.challenge.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilite.challenge.R
import com.mobilite.challenge.factory.MainViewModelFactory
import com.mobilite.challenge.recyclerView.StoryAdapter
import com.mobilite.challenge.viewModel.MainViewModel
import com.mobilite.core.common.BaseViewModelFragment
import com.mobilite.di.component.DependenciesInit
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : BaseViewModelFragment<MainViewModel>() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val component by lazy { DependenciesInit.appComponent() }

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory

    override fun getViewModel(): MainViewModel? {
        return ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        component.inject(this)
        return inflater.inflate(R.layout.main_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }


fun initAdapter() {
     getViewModel()?.getPhotos()
     story_recycler.apply {
         layoutManager = LinearLayoutManager(activity)
         getViewModel()?.getResultPhotos()?.observe(this@MainFragment, Observer {
             adapter = StoryAdapter(it)
         })
     }
 }



}
