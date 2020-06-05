package com.sashakhyzhun.korext.fragment

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.sashakhyzhun.korext.R


fun FragmentTransaction.addAnimation(changeAnimation: ChangeAnimation): FragmentTransaction =
		changeAnimation.apply(this)


enum class ChangeAnimation {
	FADE {
		override fun apply(fragmentTransaction: FragmentTransaction): FragmentTransaction =
            fragmentTransaction.setCustomAnimations(
                R.anim.fade_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.fade_out
            )

	},
	SLIDE {
		override fun apply(fragmentTransaction: FragmentTransaction): FragmentTransaction =
            fragmentTransaction.setCustomAnimations(
                R.anim.enter_from_right,
                R.anim.exit_to_left,
                R.anim.enter_from_left,
                R.anim.exit_to_right
            )

	};

	abstract fun apply(fragmentTransaction: FragmentTransaction): FragmentTransaction
}

fun replaceFragment(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
	with(fragmentManager) {
		val f = findFragmentByTag(tag)
		f?.let {
			beginTransaction().remove(f).add(fragment, tag).commit()
			if (executeNow) executePendingTransactions()
		}
	}
}

fun replaceFragment(
    containerId: Int,
    fragmentManager: FragmentManager,
    fragment: Fragment,
    tag: String
) {
    val transaction = fragmentManager.beginTransaction()
	transaction.replace(containerId, fragment, tag)
	transaction.commit()
}