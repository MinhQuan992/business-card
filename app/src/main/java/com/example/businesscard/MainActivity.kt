package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.businesscard.common.ContactType
import com.example.businesscard.ui.component.ContactInfo
import com.example.businesscard.ui.component.Profile
import com.example.businesscard.ui.theme.BusinessCardTheme
import com.example.businesscard.ui.theme.DarkGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DarkGreen
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val phoneNumber = stringResource(id = R.string.phone_number)
    val email = stringResource(id = R.string.email)
    val github = stringResource(id = R.string.github)
    val company = stringResource(id = R.string.company)

    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Profile()
        Column {
            ContactInfo(
                contactType = ContactType.PHONE_NUMBER,
                value = phoneNumber
            )
            ContactInfo(
                contactType = ContactType.EMAIL,
                value = email
            )
            ContactInfo(
                contactType = ContactType.GITHUB,
                value = github
            )
            ContactInfo(
                contactType = ContactType.COMPANY,
                value = company
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = DarkGreen
        ) {
            BusinessCard()
        }
    }
}