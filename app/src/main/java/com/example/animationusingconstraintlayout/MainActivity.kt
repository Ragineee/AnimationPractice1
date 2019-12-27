package com.example.animationusingconstraintlayout

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var show :Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        backgroundImage.setOnClickListener(View.OnClickListener {
            if(show)
                revertAnimation()
            else
                showAnimation()
        })

    }

    private fun showAnimation() {
        show= true
        val constraintset: ConstraintSet = ConstraintSet().apply {
            clone(this@MainActivity,R.layout.activity_main_animated)
        }

        val transition:ChangeBounds = ChangeBounds().apply {
            setInterpolator(AnticipateInterpolator(1.0f))
            setDuration(1200)
        }

        TransitionManager.beginDelayedTransition(cc1,transition)
        constraintset.applyTo(cc1)


    }


    private fun revertAnimation() {

        show = false

        val constraintSet:ConstraintSet = ConstraintSet().apply {
            clone(this@MainActivity,R.layout.activity_main)
        }


        val transition:ChangeBounds = ChangeBounds().apply {
            setInterpolator(AnticipateInterpolator(1.0f))
            setDuration(1200)
        }

        TransitionManager.beginDelayedTransition(cc1,transition)
        constraintSet.applyTo(cc1)



    }
}