package com.voviihb.dz1

import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    companion object {
        private const val PORTRAIT_ORIENTATION_COUNT = 3
        private const val LANDSCAPE_ORIENTATION_COUNT = 4
        private const val SAVED_STATE_KEY_SIZE = "size"
    }

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
        val spanCount =
            if (orientation == Configuration.ORIENTATION_PORTRAIT) PORTRAIT_ORIENTATION_COUNT
            else LANDSCAPE_ORIENTATION_COUNT
        recyclerView.layoutManager = GridLayoutManager(this, spanCount)

        savedInstanceState?.let {
            for (i in 0 until it.getInt(SAVED_STATE_KEY_SIZE)) {
                adapter.items.add(i)
            }
        }

        button.setOnClickListener {
            adapter.items.add(adapter.items.lastIndex + 1)
            adapter.notifyItemInserted(adapter.items.size - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(SAVED_STATE_KEY_SIZE, adapter.itemCount)
    }


}