//package uz.bahrom.newsapp_demo.presentation.screns.main.home
//
//import android.os.Bundle
//import android.view.View
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import by.kirich1409.viewbindingdelegate.viewBinding
//import com.google.android.material.tabs.TabLayoutMediator
//import uz.bahrom.newsapp_demo.R
//import uz.bahrom.newsapp_demo.data.enums.Category
//import uz.bahrom.newsapp_demo.databinding.HomePageBinding
//
//class HomePage : Fragment(R.layout.home_page) {
//
//    private val categoryList = Category.values()
//
//    private val viewBinding: HomePageBinding by viewBinding()
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        viewBinding.apply {
//            savedMenu.setOnClickListener {
//                findNavController().navigate(HomePageDirections.actionHomePageToSavedPage())
//            }
//            pagerHome.adapter = PagerAdapter(requireActivity())
//
//            TabLayoutMediator(tabLayoutCategories, pagerHome) { tab, pos ->
//                tab.text = categoryList[pos].name
//            }.attach()
//
//        }
//    }
//}


