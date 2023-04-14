package com.example.zooanimals

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = Fragment1()
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content, fragment)
            .commit()

    }

    fun closeApp() {
        finishAffinity()
    }
}


data class animal(val title: String, val subtitle: String, val color: Int)

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTextView = itemView.findViewById<TextView>(R.id.titleTextView)
    private val subtitleTextView = itemView.findViewById<TextView>(R.id.subtitleTextView)

    init {
        val lpT = titleTextView.layoutParams as LinearLayout.LayoutParams
        val lpS = subtitleTextView.layoutParams as LinearLayout.LayoutParams
        lpT.gravity = Gravity.START
        lpS.gravity = Gravity.START
        titleTextView.layoutParams = lpT
        subtitleTextView.layoutParams = lpS
    }


    fun bind(item: animal) {
        //val dividerView = itemView.findViewById<View>(R.id.dividerView)

        when (item.subtitle) {
            "Australia" -> {
                val lpT = titleTextView.layoutParams as LinearLayout.LayoutParams
                val lpS = subtitleTextView.layoutParams as LinearLayout.LayoutParams
                lpT.gravity = Gravity.CENTER
                lpS.gravity = Gravity.CENTER
                titleTextView.layoutParams = lpT
                subtitleTextView.layoutParams = lpS
                /*horizontalLineView.visibility = View.GONE
                verticalLineView.visibility = View.GONE*/
            }
            "Americas" -> {
                val lpT = titleTextView.layoutParams as LinearLayout.LayoutParams
                val lpS = subtitleTextView.layoutParams as LinearLayout.LayoutParams
                lpT.gravity = Gravity.END
                lpS.gravity = Gravity.END
                titleTextView.layoutParams = lpT
                subtitleTextView.layoutParams = lpS
                /*horizontalLineView.visibility = View.GONE
                verticalLineView.visibility = View.GONE*/
            }
            "Asia" -> {
                val lpT = titleTextView.layoutParams as LinearLayout.LayoutParams
                val lpS = subtitleTextView.layoutParams as LinearLayout.LayoutParams
                lpT.gravity = Gravity.START
                lpS.gravity = Gravity.END
                titleTextView.layoutParams = lpT
                subtitleTextView.layoutParams = lpS
                /*horizontalLineView.visibility = View.VISIBLE
                verticalLineView.visibility = View.GONE*/
            }
            "Africa" -> {
                val lpT = titleTextView.layoutParams as LinearLayout.LayoutParams
                val lpS = subtitleTextView.layoutParams as LinearLayout.LayoutParams
                lpT.gravity = Gravity.START
                lpS.gravity = Gravity.START
                titleTextView.layoutParams = lpT
                subtitleTextView.layoutParams = lpS
                /*horizontalLineView.visibility = View.GONE
                verticalLineView.visibility = View.VISIBLE*/
            }
            else -> {
                val lpT = titleTextView.layoutParams as LinearLayout.LayoutParams
                val lpS = subtitleTextView.layoutParams as LinearLayout.LayoutParams
                lpT.gravity = Gravity.START
                lpS.gravity = Gravity.START
                titleTextView.layoutParams = lpT
                subtitleTextView.layoutParams = lpS
                /*horizontalLineView.visibility = View.GONE
                verticalLineView.visibility = View.GONE*/
            }
        }

        titleTextView.text = item.title
        subtitleTextView.text = item.subtitle
        itemView.setBackgroundColor(item.color)


    }
}

class MyAdapter(private val items: List<animal>, private val listener: Fragment1) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}


val animals = listOf(
    animal("Giant Panda", "Asia", Color.RED),
    animal("Reindeer", "Europa", Color.GREEN),
    animal("Kangaroo", "Australia", Color.rgb(255, 165, 0)),
    animal("African Elephant", "Africa", Color.YELLOW),
    animal("Bald Eagle", "Americas", Color.BLUE),
    animal("Bengal Tiger", "Asia", Color.RED),
    animal("Duck-Billed Platypus", "Australia", Color.rgb(255, 165, 0)),
    animal("Kudu", "Africa", Color.YELLOW),
    animal("Komodo Dragon", "Asia", Color.RED),
    animal("Luna Moth", "Americas", Color.BLUE),
    animal("Wombat", "Australia", Color.rgb(255, 165, 0)),
    animal("Blood Python", "Asia", Color.RED),
    animal("Black And White Rhinoceros  ", "Africa", Color.YELLOW),
    animal("Groundhog", "Americas", Color.BLUE),
    animal("Bison", "Europa", Color.GREEN),
    animal("Wallaby", "Australia", Color.rgb(255, 165, 0)),
    animal("Ostrich ", "Africa", Color.YELLOW),
    animal("Binturong", "Asia", Color.RED),
    animal("Dingo", "Australia", Color.rgb(255, 165, 0)),
    animal("European Boar", "Europa", Color.GREEN),
    animal("American Bison", "Americas", Color.BLUE),
    animal("African Elephant", "Africa", Color.YELLOW),
    animal("Gold Finch", "Europa", Color.GREEN),
    animal("Emu", "Australia", Color.rgb(255, 165, 0)),
    animal("Japanese Macaque", "Asia", Color.RED),
    animal("Hippopotamus ", "Africa", Color.YELLOW),
    animal("California Condor", "Americas", Color.BLUE),
    animal("Saltwater Crocodile", "Australia", Color.rgb(255, 165, 0)),
    animal("Zebra", "Africa", Color.YELLOW),
    animal("Wolverine", "Europa", Color.GREEN),
    animal("American Black Bear", "Americas", Color.BLUE),
    animal("Green Turtle", "Asia", Color.RED),
    animal("Tasmanian Devil", "Australia", Color.rgb(255, 165, 0)),
    animal("Spotted Hyena", "Africa", Color.YELLOW),
    animal("Golden Eagle", "Europa", Color.GREEN),
    animal("American Alligator", "Americas", Color.BLUE),
    animal("Giraffe", "Africa", Color.YELLOW),
    animal("European Badger", "Europa", Color.GREEN),
    animal("Kookaburra", "Australia", Color.rgb(255, 165, 0)),
    animal("Sumatran Orangutan", "Asia", Color.RED),
    animal("Gila Monster", "Americas", Color.BLUE),
    animal("Lynx", "Europa", Color.GREEN),
    animal("African Civet", "Africa", Color.YELLOW),
    animal("Clouded Leopard", "Asia", Color.RED),
    animal("Pronghorn", "Americas", Color.BLUE),
    animal("European Viper", "Europa", Color.GREEN),
    animal("Caracal", "Asia", Color.RED),
    animal("Key Deer", "Americas", Color.BLUE),
    animal("Red Deer", "Europa", Color.GREEN),
    animal("Koala", "Australia", Color.rgb(255, 165, 0))
)