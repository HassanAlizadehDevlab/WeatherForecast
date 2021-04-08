package com.android.shared.presentation.extension

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * Created by hassanalizadeh on 28,August,2020
 */
fun FragmentManager.addFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    this.beginTransaction()
        .add(containerViewId, fragment, tag)
        .apply { tag?.let { addToBackStack(tag) } }
        .commit()
}

fun FragmentManager.replaceFragment(
    containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    this.beginTransaction()
        .replace(containerViewId, fragment, tag)
        .apply { tag?.let { addToBackStack(tag) } }
        .commit()
}
