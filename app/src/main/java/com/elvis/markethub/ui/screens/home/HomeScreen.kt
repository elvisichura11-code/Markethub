package com.elvis.markethub.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elvis.markethub.R
import com.elvis.markethub.ui.theme.neworange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
//CREATING A TOPAPPBAR
        TopAppBar(
            title = {Text(text = "Home")},
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
        //End of TopApp Bar
        Spacer(modifier = Modifier.height(20.dp))
        // To solve an error on imports press alt+enter


        //SearchBar
        var search by remember { mutableStateOf("") }

        OutlinedTextField(
            value = search,
            onValueChange = { search = it},
            modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth(),
            leadingIcon = { Icon(
                imageVector =  Icons.Default.Search,
                contentDescription = "Search"
            )},
            placeholder = {Text(text = "Search Products and Categories..")}
        )


        //End of SearchBar
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Product Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 10.dp)


        )

        Spacer(modifier = Modifier.height(20.dp))
        //Start of row
        Row(
            modifier = Modifier.padding(start = 20.dp).horizontalScroll(rememberScrollState(


            ))

        ) {

            Column() {
                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "Products",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)

                )
            }

            Spacer(modifier = Modifier.width(20.dp))


            Column() {
                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "Products",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = "Groceries",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)

                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Column() {
                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "Products",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)

                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Column() {
                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "Products",
                    modifier = Modifier.size(200.dp).clip(shape = RoundedCornerShape(10.dp)),
                    contentScale = ContentScale.Crop

                )
                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)

                )
            }

            Spacer(modifier = Modifier.width(20.dp))




        }





        //End of row



















    }

}
@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()


}