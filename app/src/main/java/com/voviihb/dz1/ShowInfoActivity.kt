package com.voviihb.dz1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ShowInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_info)
        val countTextView = findViewById<TextView>(R.id.countTextView)

        val count = intent.getIntExtra(EXTRA_COUNT, -1)
        countTextView.text = count.toString()

        val color = if (count % 2 == 0) R.color.red else R.color.blue
        countTextView.background = ContextCompat.getDrawable(this, color)

    }

    companion object {
        private const val EXTRA_COUNT: String = "count"
        fun newIntent(context: Context, count: Int): Intent {
            val intent = Intent(context, ShowInfoActivity::class.java)
            intent.putExtra(EXTRA_COUNT, count)
            return intent
        }
    }
}