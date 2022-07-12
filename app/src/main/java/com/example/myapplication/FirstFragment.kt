package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment

class FirstFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = ComposeView(requireContext()).apply {
            setContent {
                Surface {
                    SettingsBar()
                }
            }
        }
        return view
    }

    @Composable
    fun SettingsBar() {
        Row(
            Modifier
                .fillMaxWidth()
                .height(24.dp)
        ) {
            Row(
                Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
                    .size(113.dp, 24.dp)
            ) {
                //All channels
                SettingsBarButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    position = ButtonGroupPosition.LEFT,
                    onClick = {
                        (requireActivity() as? MainActivity)?.switchFragment()
                    }
                ) {
                    Icon(
                        painterResource(R.drawable.ic_all_epg),
                        //***************************************************************************************
                        //***************************************************************************************
                        // ******************* NOTE: if we set the icon size to 50.dp the problem does not occur
                        //***************************************************************************************
                        //***************************************************************************************
                        modifier = Modifier.size(100.dp),
                        contentDescription = null,
                        tint = Color.Green
                    )
                }
                //favourite channels
                SettingsBarButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                    position = ButtonGroupPosition.RIGHT,
                ) {
                    Icon(
                        painterResource(R.drawable.ic_favorite_off),
                        contentDescription = null,
                        tint = Color.Green
                    )
                }
            }
            //edit button
            SettingsBarButton(
                modifier = Modifier
                    .wrapContentWidth(Alignment.End)
                    .size(113.dp, 24.dp),
                position = ButtonGroupPosition.SINGLE,
            ) {
                Text(
                    text = stringResource(R.string.edit),
                    color = Color.White
                )
            }
        }
    }

    @Composable
    fun SettingsBarButton(
        position: ButtonGroupPosition,
        modifier: Modifier = Modifier,
        onClick: (() -> Unit)? = null,
        content: @Composable RowScope.() -> Unit,
    ) {
        val shape = shapeBasedOnButtonGroup(MaterialTheme.shapes.small, position)
        OutlinedButton(
            contentPadding = PaddingValues(0.dp),
            modifier = modifier,
            onClick = { onClick?.invoke() },
            shape = shape,
        ) {
            content()
        }
    }

    @Composable
    fun shapeBasedOnButtonGroup(
        baseShape: CornerBasedShape,
        positionInGroup: ButtonGroupPosition
    ): Shape = when (positionInGroup) {
        ButtonGroupPosition.SINGLE -> baseShape
        ButtonGroupPosition.LEFT -> baseShape.copy(
            topEnd = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        )
        ButtonGroupPosition.RIGHT -> baseShape.copy(
            topStart = ZeroCornerSize,
            bottomStart = ZeroCornerSize
        )
        ButtonGroupPosition.MIDDLE -> baseShape.copy(ZeroCornerSize)
    }

    /**
     * Position of multiple Buttons. Influences e.g. border shapes
     *   - Standalone/Single: i.e. [ Button ]
     *   - Left: i.e. [ Button ][ Another Button ]
     *   - Right: i.e. [ Another Button ][ Button ]
     *   - Middle: i.e. [ Another Button 1 ][ Button ][ Another Button 2 ]
     */
    enum class ButtonGroupPosition {
        SINGLE, LEFT, RIGHT, MIDDLE;
    }

}