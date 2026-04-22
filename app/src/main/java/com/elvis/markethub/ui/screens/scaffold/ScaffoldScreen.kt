package com.elvis.markethub.ui.screens.scaffold

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elvis.markethub.navigation.ROUT_HOME
import com.elvis.markethub.ui.theme.neworange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen(navController: NavController){
   Column(
        modifier = Modifier.fillMaxSize()
    ) {

        var selectedIndex by remember { mutableStateOf(1) }

        Scaffold(


            //TopBar
            topBar = {
                TopAppBar(
                    title = { Text("Scaffold Screen") },
                    navigationIcon = {
                        IconButton(onClick = { /* Handle back/nav */ }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = neworange,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    actions = {
                        IconButton(onClick = { /* Handle back/nav */ }) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Back")
                        }
                        IconButton(onClick = { /* Handle back/nav */ }) {
                            Icon(Icons.Default.Share, contentDescription = "Back")
                        }

                    }
                )
            },

            //BottomBar
            bottomBar = {
                NavigationBar(
                    containerColor = neworange
                ){
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color.White) },
                        label = { Text("Home") },
                        selected = selectedIndex == 0,
                        onClick = { selectedIndex = 0
                            navController.navigate(ROUT_HOME)
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites", tint = Color.White) },
                        label = { Text("Favorites") },
                        selected = selectedIndex == 1,
                        onClick = { selectedIndex = 1
                            // navController.navigate(ROUT_HOME)
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.White) },
                        label = { Text("Profile") },
                        selected = selectedIndex == 2,
                        onClick = { selectedIndex = 2
                            //  navController.navigate(ROUT_HOME)
                        }
                    )

                    NavigationBarItem(
                        icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = Color.White) },
                        label = { Text("Profile") },
                        selected = selectedIndex == 2,
                        onClick = { selectedIndex = 2
                            //  navController.navigate(ROUT_HOME)
                        }
                    )

                }
            },

            //FloatingActionButton
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { /* Add action */ },
                    containerColor =neworange
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            },
            content = { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {















                }
            }
        )

        //End of scaffold


    }



}
@Preview(showBackground = true)
@Composable
fun ScaffoldScreenPreview(){
    ScaffoldScreen(rememberNavController( ))


}