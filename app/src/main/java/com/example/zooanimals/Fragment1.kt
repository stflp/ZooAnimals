package com.example.zooanimals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment1 : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val bothViews = activity?.let { ConstraintLayout(it) }
        val bView = inflater.inflate(R.layout.activity_main, bothViews, false)
        val rView = inflater.inflate(R.layout.fragment_1, bothViews, false)

        recyclerView = rView.findViewById(R.id.animalsList)
        val layoutManager = LinearLayoutManager(activity)
        adapter = MyAdapter(animals, this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        bothViews?.addView(rView)
        bothViews?.addView(bView)

        val closeButton = bView.findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener {
            (activity as MainActivity).closeApp()
        }

        return bothViews
    }

    fun onItemClick(animal: animal) {
        val bundle = Bundle()
        bundle.putString("animalName", animal.title)
        bundle.putString("animalContinent", animal.subtitle)

        val fragment = Fragment2()
        fragment.arguments = bundle
        fragmentManager?.beginTransaction()?.replace(
            android.R.id.content,
            fragment
        )?.addToBackStack(null)?.commit()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
                    /*putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)*/
                }
            }
    }
}