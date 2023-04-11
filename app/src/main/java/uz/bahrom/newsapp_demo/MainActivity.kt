package uz.bahrom.newsapp_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.bahrom.newsapp_demo.presentation.dialogs.ProgressDialog

class MainActivity : AppCompatActivity() {
    private lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dialog = ProgressDialog(this)
    }

    fun showProgress() {
        dialog.show()
    }

    fun hideProgress() {
        dialog.cancel()
    }
}