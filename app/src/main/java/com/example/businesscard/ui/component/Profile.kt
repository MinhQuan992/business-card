package com.example.businesscard.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.R
import com.example.businesscard.ui.theme.DarkGreen
import com.example.businesscard.ui.theme.LightGreen

@Composable
fun Profile(modifier: Modifier = Modifier) {
    val avt = painterResource(id = R.drawable.avt)
    val fullName = stringResource(id = R.string.full_name)
    val title = stringResource(id = R.string.title)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = avt,
            contentDescription = "avatar",
            modifier = modifier
                .size(150.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        Text(
            text = fullName,
            fontSize = 40.sp,
            color = Color.White,
            modifier = modifier.padding(0.dp, 30.dp, 0.dp, 10.dp)
        )
        Text(
            text = title,
            fontSize = 18.sp,
            color = LightGreen,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfilePreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkGreen
    ) {
        Profile()
    }
}
