package vn.linh.androidonswipetouchlistener.swipewithrecyclerviewtest.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import vn.linh.androidonswipetouchlistener.R

class ContactAdapter : ListAdapter<Contact, ContactAdapter.ContactViewHolder>(DIFF_CALLBACK) {
    var TAG = javaClass.simpleName

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder $position")
        val contact = getItem(position)
        holder.name.text = contact.name
        holder.phoneNumber.text = contact.phoneNumber
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var phoneNumber: TextView
        var buttonLive: Button

        init {
            name = itemView.findViewById(R.id.tv_contact_name)
            phoneNumber = itemView.findViewById(R.id.tv_contact_phone_number)
            buttonLive = itemView.findViewById(R.id.button_live)

            buttonLive.setOnClickListener {
                //Toast.makeText(itemView.context, "click", Toast.LENGTH_SHORT).show()
                Log.i("TAG", "click")
            }

            name.setOnClickListener {
                Log.i("TAG", "name click")
            }
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Contact>() {
            override fun areItemsTheSame(
                    oldUser: Contact, newUser: Contact): Boolean {
                // Normally, we will check ID here before check content because id is unique
                return true
            }

            override fun areContentsTheSame(
                    oldUser: Contact, newUser: Contact): Boolean {
                // check content of the item
                return oldUser == newUser
            }
        }
    }
}