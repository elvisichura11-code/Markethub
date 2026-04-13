package com.elvis.markethub.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elvis.markethub.ui.screens.about.AboutScreen
import com.elvis.markethub.ui.screens.auth.LoginScreen
import com.elvis.markethub.ui.screens.auth.RegisterScreen
import com.elvis.markethub.ui.screens.home.HomeScreen
import com.elvis.markethub.ui.screens.intent.IntentScreen
import com.elvis.markethub.ui.screens.onboarding.OnBoardingScreen
import com.elvis.markethub.ui.screens.payment.PaymentScreen
import com.elvis.markethub.ui.screens.service.ServiceScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_ONBOARDING

) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_LOGIN){ LoginScreen(navController) }
        composable(ROUT_REGISTER){ RegisterScreen(navController) }
        composable(ROUT_ONBOARDING){ OnBoardingScreen(navController) }
        composable(ROUT_SERVICE){ ServiceScreen(navController) }
        composable(ROUT_PAYMENT){ PaymentScreen(navController) }
        composable(ROUT_INTENT){ IntentScreen(navController) }

    }
}