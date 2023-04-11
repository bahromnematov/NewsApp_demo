package uz.bahrom.newsapp_demo.presentation.screns.main.saved

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.bahrom.newsapp_demo.R
import uz.bahrom.newsapp_demo.databinding.SavedPageBinding
import uz.bahrom.newsapp_demo.presentation.screns.main.home.NewsAdapter
import uz.bahrom.newsapp_demo.presentation.viewmodel.SavedViewModel
import uz.bahrom.newsapp_demo.presentation.viewmodel.impl.SavedViewModelImpl

@AndroidEntryPoint
class SavedPage : Fragment(R.layout.saved_page) {
    private val adapter: NewsAdapter by lazy(LazyThreadSafetyMode.NONE) {
        NewsAdapter()
    }

    private val viewModel: SavedViewModel by viewModels<SavedViewModelImpl>()
    private val viewBinding: SavedPageBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.listSavedNews.adapter = adapter
        viewBinding.listSavedNews.addItemDecoration(
            DividerItemDecoration(
                requireContext(), LinearLayoutManager.VERTICAL
            )
        )

        adapter.setItemClickListener {
            findNavController().navigate(SavedPageDirections.actionSavedPageToReadNewsScreen(it))
        }
        viewModel.savedNewsFlow.onEach {
            adapter.submitList(it)

        }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

}