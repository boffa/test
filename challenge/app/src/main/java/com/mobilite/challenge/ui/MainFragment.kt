package com.mobilite.challenge.ui
import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.drawee.view.SimpleDraweeView
import com.mobilite.challenge.R
import com.mobilite.challenge.factory.MainViewModelFactory
import com.mobilite.challenge.recyclerView.StoryAdapter
import com.mobilite.challenge.viewModel.MainViewModel
import com.mobilite.core.common.BaseViewModelFragment
import com.mobilite.challenge.di.component.DependenciesInit
import com.mobilite.challenge.recyclerView.PhotoAdapter
import com.mobilite.core.domain.Photo
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.story_details.*
import java.util.*
import javax.inject.Inject

class MainFragment : BaseViewModelFragment<MainViewModel>() {

    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var storyAdapter: StoryAdapter

    private var detailsPopup: PopupWindow? = null

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
             storyAdapter = StoryAdapter(it,{
                 goToStoryDetails(it)

             })
             adapter = storyAdapter

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


    private fun goToStoryDetails(it: Photo) {

            // Initialize a new layout inflater instance
        val inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // Inflate a custom view using layout inflater
            val view = inflater.inflate(R.layout.story_details,null)
            val storyImageView = view.findViewById<SimpleDraweeView>(R.id.story_imageView)
            val backButton = view.findViewById<AppCompatImageButton>(R.id.back_button)

              storyImageView.setImageURI(it.urls.regular)

            // Initialize a new instance of popup window
            val popupWindow = PopupWindow(
                view, // Custom view to show in popup window
                LinearLayout.LayoutParams.MATCH_PARENT, // Width of popup window
                LinearLayout.LayoutParams.MATCH_PARENT // Window height
            )
            backButton.setOnClickListener()
            {
             popupWindow.dismiss()
              storyAdapter.notifyDataSetChanged()
            }
            // Set an elevation for the popup window
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                popupWindow.elevation = 10.0F
            }


            // If API level 23 or higher then execute the code
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                // Create a new slide animation for popup window enter transition
                val slideIn = Slide()
                slideIn.slideEdge = Gravity.TOP
                popupWindow.enterTransition = slideIn

                // Slide animation for popup window exit transition
                val slideOut = Slide()
                slideOut.slideEdge = Gravity.RIGHT
                popupWindow.exitTransition = slideOut

            }


        // Finally, show the popup window on app
        TransitionManager.beginDelayedTransition(rootView)
        popupWindow.showAtLocation(
            rootView, // Location to display popup window
            Gravity.CENTER, // Exact position of layout to display popup
            0, // X offset
            0 // Y offset
        )
    }


    fun goToPhotoDetails(photo: Photo){
        val bundle = bundleOf("photo" to photo)
        findNavController().navigate(R.id.action_mainFragment_to_detailsFragment,bundle)
    }
}

