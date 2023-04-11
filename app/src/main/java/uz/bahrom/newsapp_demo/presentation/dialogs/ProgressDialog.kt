package uz.bahrom.newsapp_demo.presentation.dialogs
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import uz.bahrom.newsapp_demo.databinding.ProgresImageBinding
import uz.bahrom.newsapp_demo.utils.config

class ProgressDialog(context: Context) : Dialog(context) {
    private lateinit var binding: ProgresImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ProgresImageBinding.inflate(layoutInflater)
        config(binding)
        setCancelable(false)


    }
}