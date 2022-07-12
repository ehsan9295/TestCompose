package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

class SecondFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ComposeView(requireContext()).apply {
            setContent {
                Surface {
                        TextWithoutBackground()
                        //***************************************************************************************
                        //***************************************************************************************
                        // *** NOTE: If we set a background color for the first text view all of them will be displayed.
                        // *** I.e. call TextWithBackground() instead of TextWithoutBackground()
                        //***************************************************************************************
                        //***************************************************************************************

                        //TextWithBackground()
                }
            }
        }
        return view
    }

    @Composable
    private fun TextWithoutBackground() {
        Column {
            Text(text = "This is the first line", color = Color.Black, fontSize = 30.sp)
            Text(text = "This is the second line", color = Color.Red, fontSize = 30.sp)
            Text(text = "This is the third line", color = Color.Green, fontSize = 30.sp)
        }
    }

    @Composable
    private fun TextWithBackground() {
        Column {
            Text(
                modifier = Modifier.background(Color.Yellow),
                text = "This is the first line with background",
                color = Color.Black,
                fontSize = 30.sp
            )
            Text(text = "This is the second line", color = Color.Red, fontSize = 30.sp)
            Text(text = "This is the third line", color = Color.Green, fontSize = 30.sp)
        }
    }

}