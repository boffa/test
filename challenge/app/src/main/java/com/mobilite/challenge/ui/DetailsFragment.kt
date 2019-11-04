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
import com.mobilite.core.domain.Photo
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.details_fragment.view.*
import kotlinx.android.synthetic.main.details_fragment.view.user_imageView
import kotlinx.android.synthetic.main.details_fragment.view.username_textView
import kotlinx.android.synthetic.main.photo_item.view.*
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
        arguments?.let{
            val photo = it.getParcelable("photo") as Photo
            view.user_imageView.setImageURI(photo.urls.small)
            view.story_imageView.setImageURI(photo.user.profile_image.small)
            view.username_textView.setText(photo.user.username)
            view.small_description_textView.setText(photo.description)
            view.long_description_textView.setText(photo.alt_description)
            view.date_creation_textView.setText(photo.created_at)
            view.date_edition_textView.setText(photo.updated_at)

        }

    }





}
