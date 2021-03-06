package com.varivoda.igor.zagonetke.ui.shared

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.varivoda.igor.zagonetke.R


fun Context?.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Context.styleableToast(text: String, styleId: Int) {
    com.muddzdev.styleabletoast.StyleableToast.makeText(this, text, Toast.LENGTH_LONG, styleId)
        .show()
}

fun Fragment.vibratePhone(value: Long) {
    val vibrator = context?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
    if (Build.VERSION.SDK_INT >= 26) {
        vibrator.vibrate(VibrationEffect.createOneShot(value, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        vibrator.vibrate(300)
    }
}

fun <T> retrofit2.Response<T>.bodyOrNull(): T? {
    return if (isSuccessful)
        body()
    else
        null
}

val Context.inflater: LayoutInflater
    get() = LayoutInflater.from(this)

fun <T : View> View.bindView(id: Int) = lazy { findViewById<T>(id) }

var bounceAnimation: Animation? = null

fun Button.bounceAnimation() {
    if (bounceAnimation == null) {
        bounceAnimation = AnimationUtils.loadAnimation(context, R.anim.bounce_animation)
    }
    this.startAnimation(bounceAnimation)
}


