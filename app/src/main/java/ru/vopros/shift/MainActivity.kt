package ru.vopros.shift

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import ru.vopros.shift.presentation.screen.root.RootScreen
import ru.vopros.shift.presentation.theme.ShiftTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShiftTheme {
                RootScreen()
            }
        }
    }

}
