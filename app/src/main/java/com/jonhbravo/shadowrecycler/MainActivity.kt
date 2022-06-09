package com.jonhbravo.shadowrecycler

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.jonhbravo.shadowrecycler.databinding.ActivityMainBinding
import com.xwray.groupie.GroupieAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val groupieAdapter = GroupieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecycler()
    }

    private fun setupRecycler() {
        binding.recyclerView.adapter = groupieAdapter
        groupieAdapter.update(
            listOf(
                DummyItem("Julio Roa"),
                DummyItem("Jonathan Bravo"),
                DummyItem("Karen Ramirez"),
                DummyItem("Patricio Fernandez"),
                DummyItem("Heder Romero")
            )
        )
    }
}