package uz.bahrom.newsapp_demo.presentation.screns.read

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.bahrom.newsapp_demo.R
import uz.bahrom.newsapp_demo.databinding.PageWebviewBinding
import uz.bahrom.newsapp_demo.presentation.viewmodel.ReadViewModel
import uz.bahrom.newsapp_demo.presentation.viewmodel.impl.ReadViewModelImpl
import uz.bahrom.newsapp_demo.utils.hideProgress
import uz.bahrom.newsapp_demo.utils.showProgress


@AndroidEntryPoint
class ReadNewsScreen : Fragment(R.layout.page_webview) {

    private val viewBinding: PageWebviewBinding by viewBinding()

    private val args: ReadNewsScreenArgs by navArgs()

    private val viewModel: ReadViewModel by viewModels<ReadViewModelImpl>()

    private lateinit var tts: TextToSpeech

    private var isSelected = false

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewBinding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        isSelected = args.news.saved == 1

        loadSaved()

        viewBinding.imageSaved.setOnClickListener {
            isSelected = !isSelected
            viewModel.updateNews(args.news.copy(saved = if (isSelected) 1 else 0))
            loadSaved()
        }
        showProgress()

        viewBinding.webviewNews.apply {
            settings.apply {
                domStorageEnabled = true
                loadsImagesAutomatically = true
                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                javaScriptEnabled = true
            }
            webViewClient = object : WebViewClient() {

                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                    hideProgress()
                }
            }
            webChromeClient = WebChromeClient()
        }



        viewBinding.webviewNews.loadUrl(args.news.newsUrl)

        //text to speech
        tts = TextToSpeech(requireContext()) {

        }
    }

    private fun loadSaved() {
        if (!isSelected) {
            viewBinding.imageSaved.setImageResource(R.drawable.ic_bookmark)
        } else {
            viewBinding.imageSaved.setImageResource(R.drawable.ic_selected_bookmark)
        }
    }

}