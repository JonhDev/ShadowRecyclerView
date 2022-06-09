package com.jonhbravo.shadowrecycler

import android.view.View
import com.jonhbravo.shadowrecycler.databinding.ItemDummyBinding
import com.xwray.groupie.viewbinding.BindableItem

class DummyItem(val name: String) : BindableItem<ItemDummyBinding>() {

    override fun bind(viewBinding: ItemDummyBinding, position: Int) {
        viewBinding.textViewName.text = name
    }

    override fun getLayout() = R.layout.item_dummy

    override fun initializeViewBinding(view: View) = ItemDummyBinding.bind(view)
}