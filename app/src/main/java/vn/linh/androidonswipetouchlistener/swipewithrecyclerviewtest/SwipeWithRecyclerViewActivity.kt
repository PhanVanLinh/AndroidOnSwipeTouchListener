package vn.linh.androidonswipetouchlistener.swipewithrecyclerviewtest

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import vn.linh.androidonswipetouchlistener.R
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.LinearLayoutManager
import android.widget.Button
import vn.linh.androidonswipetouchlistener.OnSwipeTouchListener
import vn.linh.androidonswipetouchlistener.swipewithrecyclerviewtest.adapter.Contact
import vn.linh.androidonswipetouchlistener.swipewithrecyclerviewtest.adapter.ContactAdapter


class SwipeWithRecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactAdapter

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_with_recycler_view)


        recyclerView = findViewById(R.id.rv_main)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = mLayoutManager

        adapter = ContactAdapter()
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        adapter.submitList(getData())


        findViewById<Button>(R.id.button_next).setOnClickListener {
            next()
        }


        findViewById<Button>(R.id.button_previous).setOnClickListener {
            previous()
        }

        recyclerView.setOnTouchListener(object : OnSwipeTouchListener(this) {
            override fun onSwipeLeft(): Boolean {
                next()
                return true
            }

            override fun onSwipeRight(): Boolean {
                previous()
                return true
            }
        })
    }

    fun next() {
        adapter.submitList(getData())
    }

    fun previous() {
        adapter.submitList(arrayListOf())
    }

    fun getData(): ArrayList<Contact> {
        val contacts = arrayListOf<Contact>()
        contacts.add(Contact("A", "0"))
        contacts.add(Contact("B", "1"))
        contacts.add(Contact("C", "2"))
        contacts.add(Contact("D", "3"))
        contacts.add(Contact("E", "4"))
        contacts.add(Contact("F", "5"))
        contacts.add(Contact("G", "6"))
        contacts.add(Contact("H", "7"))
        contacts.add(Contact("I", "8"))
        contacts.add(Contact("J", "9"))
        contacts.add(Contact("K", "10"))
        return contacts
    }
}
