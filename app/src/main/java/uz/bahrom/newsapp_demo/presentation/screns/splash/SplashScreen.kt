package uz.bahrom.newsapp_demo.presentation.screns.splash

import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.bahrom.newsapp_demo.R
import uz.bahrom.newsapp_demo.presentation.viewmodel.SplashViewModel
import uz.bahrom.newsapp_demo.presentation.viewmodel.impl.SplashViewModelImpl
import uz.gita.news_app_io.presentation.screens.splash.SplashScreenDirections


@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen : Fragment(R.layout.splash_page) {

    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onResume() {
        super.onResume()
        viewModel.navigator.onEach {
            findNavController().navigate(SplashScreenDirections.actionSplashScreenToHomePage())
        }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

}