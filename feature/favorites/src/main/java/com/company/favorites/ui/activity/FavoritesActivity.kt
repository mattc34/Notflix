package com.company.favorites.ui.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.company.favorites.R
import com.jeppeman.globallydynamic.globalsplitcompat.GlobalSplitCompat


class FavoritesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        GlobalSplitCompat.installActivity(this)
    }

}
