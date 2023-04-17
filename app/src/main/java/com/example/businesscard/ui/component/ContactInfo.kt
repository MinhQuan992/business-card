package com.example.businesscard.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.R
import com.example.businesscard.common.ContactIcon
import com.example.businesscard.common.ContactType
import com.example.businesscard.ui.theme.DarkGreen
import com.example.businesscard.ui.theme.LightGreen

@Composable
fun ContactInfo(contactType: ContactType, value: String, modifier: Modifier = Modifier) {
    val icon = when (contactType) {
        ContactType.PHONE_NUMBER -> ContactIcon(
            painterResource(id = R.drawable.baseline_phone_24),
            "Phone number"
        )
        ContactType.EMAIL -> ContactIcon(
            painterResource(id = R.drawable.baseline_email_24),
            "Email address"
        )
        ContactType.GITHUB -> ContactIcon(
            painterResource(id = R.drawable.baseline_share_24),
            "GitHub account"
        )
        ContactType.COMPANY -> ContactIcon(
            painterResource(id = R.drawable.baseline_work_24),
            "Company name"
        )
    }

    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .requiredHeight(50.dp)
            .drawBehind {
                val strokeWidth = 1f
                drawLine(
                    color = Color.White,
                    start = Offset(0f, 0f), //(0,0) at top-left point of the box
                    end = Offset(size.width, 0f), //top-right point of the box
                    strokeWidth = strokeWidth
                )
            }
    ) {
        Icon(
            painter = icon.icon,
            contentDescription = icon.description,
            tint = LightGreen,
            modifier = modifier.padding(60.dp, 0.dp, 24.dp, 0.dp)
        )
        Text(
            text = value,
            fontSize = 18.sp,
            color = Color.White
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContactInfoPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = DarkGreen
    ) {
        ContactInfo(
            contactType = ContactType.COMPANY,
            value = "KMS Healthcare"
        )
    }
}