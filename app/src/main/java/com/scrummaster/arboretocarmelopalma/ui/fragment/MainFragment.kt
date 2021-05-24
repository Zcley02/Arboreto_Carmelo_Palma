package com.scrummaster.arboretocarmelopalma.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import com.scrummaster.arboretocarmelopalma.ui.MainViewModel
import javax.inject.Inject
import com.scrummaster.arboretocarmelopalma.R
import com.scrummaster.arboretocarmelopalma.intent.Intent
import com.scrummaster.arboretocarmelopalma.utils.AdapterTree
import com.scrummaster.arboretocarmelopalma.utils.DataState


@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainFragment
constructor() : Fragment(R.layout.fragment_first) {
    private val TAG: String = "AppDebug"

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var adapterTrees: AdapterTree

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeObservers()
        val layoutManager =
            LinearLayoutManager(
                requireActivity().applicationContext,
                LinearLayoutManager.VERTICAL,
                false
            )
        layoutManager.reverseLayout = true
        layoutManager.stackFromEnd = true
        recyclerViewTrees.layoutManager = layoutManager
        recyclerViewTrees.adapter = adapterTrees

        subscribeObservers()
        lifecycleScope.launch {
            viewModel.userIntent.send(Intent.GetTreeEvent)
        }
    }

    private fun subscribeObservers(){
        lifecycleScope.launch {
            viewModel.dataState.collect {
                when(it){
                    is DataState.Success -> {
                        displayProgressBar(false)
                        adapterTrees.setTrees(it.trees)
                    }
                    is DataState.Error -> {
                        displayProgressBar(false)
                        displayError(it.exception.message)
                    }
                    is DataState.Loading -> {
                        displayProgressBar(true)
                    }
                }
            }
        }
    }

    private fun displayError(message: String?) {
        //  if (message != null) text.text = message else text.text = "Unknown error."
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        progress_bar.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }
}