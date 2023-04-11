package uz.bahrom.newsapp_demo.data.shared_prefs

import android.content.Context
import android.content.SharedPreferences
import uz.bahrom.newsapp_demo.utils.SharedPreference
import javax.inject.Inject

class MyPref @Inject constructor(context: Context, sharedPreferences: SharedPreferences) :
    SharedPreference(context, sharedPreferences) {


    var name: String by Strings("")

    var image: String by Strings("")



}