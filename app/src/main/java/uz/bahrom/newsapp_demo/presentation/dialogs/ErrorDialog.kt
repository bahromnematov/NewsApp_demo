package uz.bahrom.newsapp_demo.presentation.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import uz.bahrom.newsapp_demo.databinding.DialogErrorBinding
import uz.bahrom.newsapp_demo.utils.config

class ErrorDialog(ctx: Context, private val message: String) : Dialog(ctx) {
    private lateinit var binding: DialogErrorBinding

    private var cancelListener: (() -> Unit)? = null

    fun setCancelListener(block: () -> Unit) {
        cancelListener = block
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = DialogErrorBinding.inflate(layoutInflater)
        config(binding)
        binding.tvErrorMessage.text = message
        binding.btnCancel.setOnClickListener {
            cancelListener?.invoke()
            dismiss()
        }

    }

}