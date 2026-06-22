package com.stride.app

import android.content.res.Configuration
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    protected fun updateOrientation(
        portraitLayout: View,
        landscapeLayout: View,
        bgPortrait: View,
        bgLandscape: View
    ) {
        val isLandscape = resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        portraitLayout.visibility = if (isLandscape) View.GONE else View.VISIBLE
        landscapeLayout.visibility = if (isLandscape) View.VISIBLE else View.GONE
        bgPortrait.visibility = if (isLandscape) View.GONE else View.VISIBLE
        bgLandscape.visibility = if (isLandscape) View.VISIBLE else View.GONE
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        onOrientationChanged()
    }

    open fun onOrientationChanged() {}
}
