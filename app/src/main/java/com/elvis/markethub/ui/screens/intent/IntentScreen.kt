package com.elvis.markethub.ui.screens.intent

import android.content.Intent
import android.provider.MediaStore
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elvis.markethub.R
import com.elvis.markethub.navigation.ROUT_REGISTER
import com.elvis.markethub.ui.theme.neworange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntentScreen(navController: NavController){
    //Intent refers to how one navigates between screens or apps
    //Implicit intent is navigating to apps outside your project
    //Explicit intent is navigating within screens in your project
    Column(
        modifier = Modifier
            .paint(painter = painterResource(R.drawable.background), contentScale = ContentScale.FillBounds)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,



    ) {
        val mContext = LocalContext.current
        TopAppBar(
            title = {Text(text = "Intent")},
            navigationIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription ="menu"


                    ) }

            },
            actions = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.ShoppingCart,
                        contentDescription ="shopping"


                    ) }

                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.Notifications,
                        contentDescription ="notifications"


                    ) }

                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.Share,
                        contentDescription ="Share"


                    ) }


            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = neworange,
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            )


        )
        Spacer(modifier = Modifier.width(30.dp))

        //PAY VIA MPESA


        Button(
            onClick = {
                val simToolKitLaunchIntent =
                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { mContext.startActivity(it) }

            },
            colors = ButtonDefaults.buttonColors(neworange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        )
        {
            Text(
                text = "Pay Via M-Pesa"
            )

        }

        Spacer(modifier = Modifier.width(20.dp))

        //SEND MESSAGE


        Button(
            onClick = {
                val smsIntent= Intent(Intent.ACTION_SENDTO)
                smsIntent.data="smsto:0720245837".toUri()
                smsIntent.putExtra("sms_body","Hello Elvis ,how was your day?")
                mContext.startActivity(smsIntent)

            },
            colors = ButtonDefaults.buttonColors(neworange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        )
        {
            Text(
                text = "Send Message"
            )

        }


        Spacer(modifier = Modifier.width(20.dp))

        //CALL OR TELEPHONE


        Button(
            onClick = {
                val callIntent= Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0720245837".toUri()
                mContext.startActivity(callIntent)

            },
            colors = ButtonDefaults.buttonColors(neworange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        )
        {
            Text(
                text = "Call"
            )

        }


        Spacer(modifier = Modifier.width(20.dp))

        //CAMERA


        Button(
            onClick = {
                val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (cameraIntent.resolveActivity(mContext.packageManager)!=null){
                    mContext.startActivity(cameraIntent)
                }else{
                    println("Camera app is not available")
                }
            },
            colors = ButtonDefaults.buttonColors(neworange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        )
        {
            Text(
                text = "Camera"
            )

        }

        Spacer(modifier = Modifier.width(20.dp))
        //EMAIL


        Button(
            onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("elvisichura11@gmail.com"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "subject")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello Elvis, this is the email body")
                mContext.startActivity(shareIntent)
            },
            colors = ButtonDefaults.buttonColors(neworange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        )
        {
            Text(
                text = "Email"
            )

        }


        Spacer(modifier = Modifier.width(20.dp))

        //SHARE


        Button(
            onClick = {
                val shareIntent=Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "https://github.com/gloryakinyi")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))

            },
            colors = ButtonDefaults.buttonColors(neworange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        )
        {
            Text(
                text = "Share"
            )

        }

    }
}








@Preview(showBackground = true)
@Composable
fun IntentScreenPreview() {
    IntentScreen(rememberNavController())
}
