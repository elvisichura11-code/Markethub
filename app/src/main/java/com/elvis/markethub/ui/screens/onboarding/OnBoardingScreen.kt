package com.elvis.markethub.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elvis.markethub.R
import com.elvis.markethub.ui.theme.neworange

@Composable
fun OnBoardingScreen(){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //How to display an image

        Image(
            painter = painterResource(R.drawable.img),
            contentDescription = "Products",
            modifier = Modifier.size(300.dp)

        )

        Spacer(modifier = Modifier.height(20.dp))



        Text(
            text = "WELCOME TO MARKETHUB",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = neworange,
            fontFamily = FontFamily.Cursive


        )
        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "Shop Smarter",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold


        )

        Text(
            text = "Everywhere you go",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold


        )
        Spacer(modifier = Modifier.height(20.dp))


        Text(
            text = "Markethub is an all-in-one eCommerce platform designed to connect buyers and sellers in a seamless online marketplace.",
            fontSize = 20.sp,
            textAlign = TextAlign.Center


        )
        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(neworange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        )
        {
            Text(
                text = "Get Started"
            )

        }

















    }

}
@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview(){
    OnBoardingScreen()


}