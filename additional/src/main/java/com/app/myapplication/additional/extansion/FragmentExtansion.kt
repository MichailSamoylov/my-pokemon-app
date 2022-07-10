package com.app.myapplication.additional.extansion

import androidx.fragment.app.Fragment
import androidx.activity.OnBackPressedCallback

fun Fragment.addBackPressedListener(enabledCallback: Boolean = true, action: OnBackPressedCallback.() -> Unit): OnBackPressedCallback {
	val callback: OnBackPressedCallback = object : OnBackPressedCallback(enabledCallback) {
		override fun handleOnBackPressed() {
			action.invoke(this)
		}
	}
	requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
	return callback
}