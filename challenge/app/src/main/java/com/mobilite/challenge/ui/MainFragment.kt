package com.mobilite.challenge.ui
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilite.challenge.R
import com.mobilite.challenge.factory.MainViewModelFactory
import com.mobilite.challenge.recyclerView.StoryAdapter
import com.mobilite.challenge.viewModel.MainViewModel
import com.mobilite.core.common.BaseViewModelFragment
import com.mobilite.challenge.di.component.DependenciesInit
import com.mobilite.challenge.recyclerView.PhotoAdapter
import com.mobilite.core.domain.Photo
import kotlinx.android.synthetic.main.main_fragment.*
import java.util.*
import javax.inject.Inject

class MainFragment : BaseViewModelFragment<MainViewModel>() {

    private lateinit var photoAdapter: PhotoAdapter

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
         layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
         getViewModel()?.getResultPhotos()?.observe(this@MainFragment, Observer {
             adapter = StoryAdapter(it)

         })
     }
    photo_recycler.apply {
        layoutManager = GridLayoutManager(activity,2,LinearLayoutManager.VERTICAL,false)
        getViewModel()?.getResultPhotos()?.observe(this@MainFragment, Observer {
            photoAdapter = PhotoAdapter(it,{
                  goToPhotoDetails(it)
            })
            adapter = photoAdapter

        })
    }

    search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

        override fun onQueryTextChange(newText: String): Boolean {
            photoAdapter.filter(newText.toLowerCase(Locale.ROOT))
            return true
        }

        override fun onQueryTextSubmit(query: String): Boolean {
            photoAdapter.filter(query.toLowerCase(Locale.ROOT))
            return true
        }

    })
}

    fun goToPhotoDetails(photo: Photo){
        val bundle = bundleOf("photo" to photo)
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment,bundle)
    }
}
