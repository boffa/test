package com.mobilite.challenge.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobilite.challenge.R
import com.mobilite.challenge.factory.MainViewModelFactory
import com.mobilite.challenge.recyclerView.StoryAdapter
import com.mobilite.challenge.viewModel.MainViewModel
import com.mobilite.core.common.BaseViewModelFragment
import com.mobilite.challenge.di.component.DependenciesInit
import com.mobilite.challenge.recyclerView.PhotoAdapter
import kotlinx.android.synthetic.main.main_fragment.*
import javax.inject.Inject

class MainFragment : BaseViewModelFragment<MainViewModel>(), SearchView.OnQueryTextListener {

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
      //  search_view.setOnQueryTextListener(this)

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
            photoAdapter = PhotoAdapter(it)

        })
    }

}

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        search(newText)
        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        search(query)
        return true
    }

    private fun search(s: String?) {
      /*  photoAdapter.search(s) {
            // update UI on nothing found
            Toast.makeText(context, "Nothing Found", Toast.LENGTH_SHORT).show()
        }*/
    }
}
