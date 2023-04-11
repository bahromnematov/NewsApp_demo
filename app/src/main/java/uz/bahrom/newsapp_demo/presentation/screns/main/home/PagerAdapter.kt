package uz.bahrom.newsapp_demo.presentation.screns.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.bahrom.newsapp_demo.data.enums.Category

@Suppress("UNREACHABLE_CODE")
class PagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    private val categoryList = Category.values()

    override fun getItemCount(): Int = categoryList.size


    override fun createFragment(position: Int): Fragment {
        val page = BasePage()
        page.arguments = Bundle().apply {
            putString("category", categoryList[position].name)
            return page
        }
    }
}