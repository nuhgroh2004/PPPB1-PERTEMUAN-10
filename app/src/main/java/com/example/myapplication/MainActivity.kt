package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapterClub = ClubAdapter(generateDataDummy()){
            club ->
            Toast.makeText(this@MainActivity, "You click ${club.nameClub}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvDiaster.apply {
                adapter = adapterClub
//                layoutManager = LinearLayoutManager(this@MainActivity)
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun generateDataDummy(): List<Club>{
        return listOf(
            Club(
                nameClub = "Barcelona",
                img = "https://i.eurosport.com/2024/10/27/4055835-82254348-2560-1440.jpg"
            ),
            Club(
                nameClub = "Real Madrid",
                img = "https://cdns.klimg.com/bola.net/resized/810x540/library/upload/21/2024/10/996x664/real-madrid-5_aa4345b.jpg"
            ),
            Club(
                nameClub = "AC Milan",
                img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPn8edYCSreM7e3F1KqOw6yCbnHwnyqYwIDA&s"
            ),
            Club(
                nameClub = "Manchester United",
                img = "https://assets.goal.com/images/v3/blte395ae2a4ef2d789/Antony.jpg?auto=webp&format=pjpg&width=3840&quality=60"
            ),
            Club(
                nameClub = "Liverpool",
                img = "https://klikinfo.id/wp-content/uploads/2024/10/darwin-nunez-liverpool-1-768x512-1.jpg"
            ),
            Club(
                nameClub = "Menchester City",
                img = "https://tmssl.akamaized.net//images/foto/galerie/erling-haaland-manchester-city-2024-1727103341-148917.jpg?lm=1727103361"
            ),
            Club(
                nameClub = "Chelsea",
                img = "https://imgsrv2.voi.id/r2Iyvol9dWUqHDVG_NfLTSKNHT0kIT9mzVxW9reX-4o/auto/1200/675/sm/1/bG9jYWw6Ly8vcHVibGlzaGVycy8zMTYwNjgvMjAyMzEwMDMxMTE0LW1haW4uY3JvcHBlZF8xNjk2MzA2NDUyLmpwZWc.jpg"
            ),
            Club(
                nameClub = "Arsenal",
                img = "https://images.teamtalk.com/content/uploads/2023/09/06114544/Declan-Rice-Arsenal-3.jpg"
            ),
            Club(
                nameClub = "Tottenham Hotspur",
                img = "https://asset.kompas.com/crops/yB3RFKGnBWLWYxlsH9hI1xoMqGg=/0x1:580x388/1200x800/data/photo/2020/07/13/5f0b569f374ca.jpg"
            ),

        )
    }
}