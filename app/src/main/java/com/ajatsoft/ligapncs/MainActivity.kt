package com.ajatsoft.ligapncs

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import android.support.v4.widget.DrawerLayout



class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
                replaceFragmenty(
                        fragment = HomeFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("Inicio")
            }
            R.id.nav_participantes -> {
                replaceFragmenty(
                        fragment = ParticipantesFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("Participantes")
            }
            R.id.nav_graficos -> {
                replaceFragmenty(
                        fragment = GraficosFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("Gráficos")
            }
            R.id.nav_reglamento -> {
                replaceFragmenty(
                        fragment = ReglamentoFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("Reglamento")
            }
            R.id.nav_clasificacion -> {
                replaceFragmenty(
                        fragment = ClasificacionFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("Clasificación")
            }
            R.id.nav_puntosenvivo -> {
                replaceFragmenty(
                        fragment = PuntosenvivoFragment(),
                        allowStateLoss = true,
                        containerViewId = R.id.mainContent
                )
                setTitle("Puntos en Vivo")
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
