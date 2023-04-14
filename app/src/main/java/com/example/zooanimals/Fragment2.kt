package com.example.zooanimals

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment2 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bothViews = activity?.let { ConstraintLayout(it) }
        val bView = inflater.inflate(R.layout.activity_main, bothViews, false)
        val aView = inflater.inflate(R.layout.fragment_2, bothViews, false)

        val animalNameView = aView.findViewById<TextView>(R.id.animalName)
        val animalContinentView = aView.findViewById<TextView>(R.id.animalContinent)
        val background = aView.findViewById<FrameLayout>(R.id.fragment2)

        arguments?.let {
            animalNameView.text = it.getString("animalName")
            animalContinentView.text = it.getString("animalContinent")
            when (animalContinentView.text) {
                "Africa" -> {
                    background.setBackgroundColor(Color.YELLOW)
                }
                "Americas" -> {
                    background.setBackgroundColor(Color.BLUE)
                }
                "Asia" -> {
                    background.setBackgroundColor(Color.RED)
                }
                "Australia" -> {
                    background.setBackgroundColor(Color.rgb(255, 165, 0))
                }
                else -> {
                    background.setBackgroundColor(Color.GREEN)
                }
            }

        }

        bothViews?.addView(aView)
        bothViews?.addView(bView)

        val closeButton = bView.findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener {
            (activity as MainActivity).closeApp()
        }

        return bothViews
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: animal, param2: String) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    /*putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)*/
                }
            }
    }
}