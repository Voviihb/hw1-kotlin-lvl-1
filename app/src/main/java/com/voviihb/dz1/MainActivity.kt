package com.voviihb.dz1

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        button = findViewById(R.id.button_add)
        adapter = MainAdapter()

        recyclerView.adapter = adapter

        val orientation = resources.configuration.orientation
        val spanCount = if (orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 4
        recyclerView.layoutManager = GridLayoutManager(this, spanCount)

        savedInstanceState?.let {
            for (i in 0 until it.getInt("size")) {
                adapter.items.add(i)
            }
        }
        button.setOnClickListener {
            adapter.items.add(adapter.items.size)
            adapter.notifyItemInserted(adapter.items.size - 1)
//            Log.d("MainActivity", adapter.items.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("size", adapter.itemCount)
    }


}