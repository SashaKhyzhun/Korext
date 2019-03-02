package com.sashakhyzhun.androidcommonutils.fragment

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.sashakhyzhun.androidcommonutils.R


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

fun FragmentActivity.addFragmentLoss(fragment: Fragment, tag: String, executeNow: Boolean = true) {
    addFragmentLoss(this.supportFragmentManager, fragment, tag, executeNow)
}

fun FragmentActivity.addFragmentLoss(
    @IdRes containerViewId: Int, fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
    addFragmentLoss(this.supportFragmentManager, containerViewId, fragment, tag, executeNow)
}

fun FragmentActivity.addFragmentLoss(
    @IdRes containerViewId: Int, fragment: Fragment,
    executeNow: Boolean = true
) {
    addFragmentLoss(this.supportFragmentManager, containerViewId, fragment, executeNow)
}

fun Fragment.addFragmentLoss(fragment: Fragment, tag: String, executeNow: Boolean = true) {
    addFragmentLoss(this.childFragmentManager, fragment, tag, executeNow)
}

fun Fragment.addFragmentLoss(
    @IdRes containerViewId: Int, fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
    addFragmentLoss(this.childFragmentManager, containerViewId, fragment, tag, executeNow)
}

fun Fragment.addFragmentLoss(
    @IdRes containerViewId: Int, fragment: Fragment,
    executeNow: Boolean = true
) {
    addFragmentLoss(this.childFragmentManager, containerViewId, fragment, executeNow)
}

private fun addFragmentLoss(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
    with(fragmentManager) {
        beginTransaction().add(fragment, tag).commitAllowingStateLoss()
        if (executeNow) executePendingTransactions()
    }
}

private fun addFragmentLoss(
    fragmentManager: FragmentManager, @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
    with(fragmentManager) {
        beginTransaction().add(containerViewId, fragment, tag).commitAllowingStateLoss()
        if (executeNow) executePendingTransactions()
    }
}

private fun addFragmentLoss(
    fragmentManager: FragmentManager,
    containerViewId: Int,
    fragment: Fragment,
    executeNow: Boolean = true
) {
    with(fragmentManager) {
        beginTransaction().add(containerViewId, fragment).commitAllowingStateLoss()
        if (executeNow) executePendingTransactions()
    }
}

fun addFragmentLossIfNotExist(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {

    if (fragmentManager.findFragmentByTag(tag) == null)
        addFragmentLoss(fragmentManager, fragment, tag, executeNow)
}

fun addFragmentLossIfNotExist(
    fragmentManager: FragmentManager, @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {

    if (fragmentManager.findFragmentByTag(tag) == null)
        addFragmentLoss(fragmentManager, containerViewId, fragment, tag, executeNow)
}

fun addFragmentLossIfNotExist(
    fragmentManager: FragmentManager,
    containerViewId: Int,
    fragment: Fragment,
    executeNow: Boolean = true
) {

    if (fragmentManager.findFragmentById(containerViewId) == null)
        addFragmentLoss(fragmentManager, containerViewId, fragment, executeNow)
}

fun FragmentActivity.addFragment(fragment: Fragment, tag: String, executeNow: Boolean = true) {
    addFragment(this.supportFragmentManager, fragment, tag, executeNow)
}

fun FragmentActivity.addFragment(
    @IdRes containerViewId: Int, fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
    addFragment(this.supportFragmentManager, containerViewId, fragment, tag, executeNow)
}

fun FragmentActivity.addFragmentToBackStack(
    @IdRes containerViewId: Int, fragment: Fragment,
    tag: String,
    executeNow: Boolean = true,
    addToBackStack: Boolean = true
) {
    with(this.supportFragmentManager) {
        beginTransaction().add(containerViewId, fragment, tag)
            .apply { if (addToBackStack) addToBackStack(tag) }
            .commit()
        if (executeNow) executePendingTransactions()
    }
}

fun FragmentActivity.addFragment(
    @IdRes containerViewId: Int, fragment: Fragment,
    executeNow: Boolean = true
) {
    addFragment(this.supportFragmentManager, containerViewId, fragment, executeNow)
}

fun Fragment.addFragment(fragment: Fragment, tag: String, executeNow: Boolean = true) {
    addFragment(this.childFragmentManager, fragment, tag, executeNow)
}

fun Fragment.addFragment(
    @IdRes containerViewId: Int, fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
    addFragment(this.childFragmentManager, containerViewId, fragment, tag, executeNow)
}

fun Fragment.addFragment(
    @IdRes containerViewId: Int, fragment: Fragment,
    executeNow: Boolean = true
) {
    addFragment(this.childFragmentManager, containerViewId, fragment, executeNow)
}

fun addFragment(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
    with(fragmentManager) {
        beginTransaction().add(fragment, tag).commit()
        if (executeNow) executePendingTransactions()
    }
}

fun addFragment(
    fragmentManager: FragmentManager, @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
    with(fragmentManager) {
        beginTransaction().add(containerViewId, fragment, tag).commit()
        if (executeNow) executePendingTransactions()
    }
}

fun addFragment(
    fragmentManager: FragmentManager,
    containerViewId: Int,
    fragment: Fragment,
    executeNow: Boolean = true
) {
    with(fragmentManager) {
        beginTransaction().add(containerViewId, fragment).commit()
        if (executeNow) executePendingTransactions()
    }
}

fun addFragmentIfNotExist(
    fragmentManager: FragmentManager,
    fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {
    if (fragmentManager.findFragmentByTag(tag) == null)
        addFragment(fragmentManager, fragment, tag, executeNow)

}

fun addFragmentIfNotExist(
    fragmentManager: FragmentManager, @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String,
    executeNow: Boolean = true
) {

    if (fragmentManager.findFragmentByTag(tag) == null)
        addFragment(fragmentManager, containerViewId, fragment, tag, executeNow)
}

fun addFragmentIfNotExist(
    fragmentManager: FragmentManager,
    containerViewId: Int,
    fragment: Fragment,
    executeNow: Boolean = true
) {

    if (fragmentManager.findFragmentById(containerViewId) == null)
        addFragment(fragmentManager, containerViewId, fragment, executeNow)
}

fun FragmentActivity.hasFragment(tag: String): Boolean {
    return this.supportFragmentManager.findFragmentByTag(tag) != null
}

fun FragmentActivity.getFragment(tag: String) = this.supportFragmentManager.findFragmentByTag(tag)

fun Fragment.hasFragment(
    fragmentManager: FragmentManager = childFragmentManager,
    tag: String
): Boolean {
    return fragmentManager.findFragmentByTag(tag) != null
}

private fun hasFragment(fragmentManager: FragmentManager, tag: String): Boolean {
    return fragmentManager.findFragmentByTag(tag) != null
}


fun Fragment.replaceFragment(fragment: Fragment, tag: String, executeNow: Boolean = true) {
    replaceFragment(this.childFragmentManager, fragment, tag, executeNow)
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

fun replaceFragmentWithBackstack(
    containerId: Int,
    fragmentManager: FragmentManager,
    fragment: Fragment,
    tag: String
) {
    val transaction = fragmentManager.beginTransaction()
    transaction.replace(containerId, fragment, tag)
    transaction.addToBackStack(tag)
    transaction.commit()
}

fun replaceFragmentWithBackstack(
    containerId: Int,
    fragmentManager: FragmentManager,
    fragment: Fragment,
    changeAnimation: ChangeAnimation = ChangeAnimation.SLIDE,
    tag: String
) {
    val transaction = fragmentManager.beginTransaction()
    transaction.addAnimation(changeAnimation)
    transaction.replace(containerId, fragment, tag)
    transaction.addToBackStack(tag)
    transaction.commit()
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

fun replaceFragment(
    containerId: Int,
    fragmentManager: FragmentManager,
    fragment: Fragment,
    changeAnimation: ChangeAnimation = ChangeAnimation.SLIDE,
    tag: String
) {
    val transaction = fragmentManager.beginTransaction()
    transaction.addAnimation(changeAnimation)
    transaction.replace(containerId, fragment, tag)
    transaction.commit()
}