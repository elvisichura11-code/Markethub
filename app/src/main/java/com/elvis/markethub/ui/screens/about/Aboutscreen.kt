package com.elvis.markethub.ui.screens.about

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.elvis.markethub.navigation.ROUT_HOME
import com.elvis.markethub.ui.theme.neworange

// ── palette ────────────────────────────────────────────────────────────────
private val OrangeDark   = Color(0xFFE65100)
private val OrangeLight  = Color(0xFFFFF3E0)
private val AccentYellow = Color(0xFFFFD600)
private val AccentRed    = Color(0xFFFF5252)
private val AccentGreen  = Color(0xFF00C853)
private val AccentBlue   = Color(0xFF2979FF)
private val AccentPurple = Color(0xFFAA00FF)
private val White        = Color.White
private val TextDark     = Color(0xFF1A1A1A)
private val TextMedium   = Color(0xFF444444)
private val SurfaceDark  = Color(0xFF1C1C1C)
private val PageBg       = Color(0xFFF5F5F5)

// ── gradient presets ───────────────────────────────────────────────────────
private val heroGradient    = Brush.verticalGradient(listOf(Color(0xFFFF6D00), OrangeDark))
private val gradientBlue    = Brush.linearGradient(listOf(Color(0xFF2979FF), Color(0xFF00B0FF)))
private val gradientGreen   = Brush.linearGradient(listOf(Color(0xFF00C853), Color(0xFF69F0AE)))
private val gradientRed     = Brush.linearGradient(listOf(Color(0xFFFF5252), Color(0xFFFF6D00)))
private val missionGradient = Brush.linearGradient(listOf(SurfaceDark, Color(0xFF2D2D2D)))
private val stripGradient   = Brush.horizontalGradient(listOf(neworange, Color(0xFFFF6D00), AccentYellow))
private val footerGradient  = Brush.verticalGradient(listOf(neworange, OrangeDark))

// ── small composables ──────────────────────────────────────────────────────

@Composable
private fun SectionLabel(text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 14.dp)
    ) {
        Box(
            modifier = Modifier
                .width(5.dp)
                .height(24.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(neworange)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text, fontWeight = FontWeight.ExtraBold, fontSize = 20.sp, color = TextDark)
    }
}

@Composable
private fun BodyText(text: String, color: Color = TextMedium) {
    Text(text = text, fontSize = 14.sp, color = color, lineHeight = 23.sp)
}

@Composable
private fun GradientStatCard(value: String, label: String, gradient: Brush, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .shadow(8.dp, RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp))
            .background(gradient)
            .padding(vertical = 20.dp, horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = value, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp, color = White)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = label, fontSize = 11.sp,
                color = White.copy(alpha = 0.9f),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
private fun FeatureCard(icon: ImageVector, iconBg: Color, title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(iconBg),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = icon, contentDescription = null, tint = White, modifier = Modifier.size(26.dp))
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 15.sp, color = TextDark)
                Spacer(modifier = Modifier.height(3.dp))
                Text(text = description, fontSize = 13.sp, color = TextMedium, lineHeight = 19.sp)
            }
        }
    }
}

@Composable
private fun ContactChip(icon: ImageVector, label: String, chipColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(chipColor.copy(alpha = 0.1f))
            .padding(horizontal = 14.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .background(chipColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = White, modifier = Modifier.size(16.dp))
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(text = label, fontSize = 14.sp, color = TextDark, fontWeight = FontWeight.Medium)
    }
}

// ── main screen ────────────────────────────────────────────────────────────

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {

    var selectedIndex by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About Us", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = neworange,
                    titleContentColor = White,
                    navigationIconContentColor = White
                ),
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = White)
                    }
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Share, contentDescription = "Share", tint = White)
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(containerColor = neworange) {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = White) },
                    label = { Text("Home", color = White) },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0; navController.navigate(ROUT_HOME) }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites", tint = White) },
                    label = { Text("Favorites", color = White) },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = White) },
                    label = { Text("Profile", color = White) },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }, containerColor = neworange, shape = CircleShape) {
                Icon(Icons.Default.Add, contentDescription = "Support", tint = White)
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(PageBg)
                .verticalScroll(rememberScrollState())
        ) {

            // ── Hero Banner ──────────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(heroGradient)
                    .padding(vertical = 40.dp, horizontal = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                // decorative circle
                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .clip(CircleShape)
                        .background(White.copy(alpha = 0.05f))
                        .align(Alignment.TopEnd)
                        .offset(x = 40.dp, y = (-20).dp)
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(White.copy(alpha = 0.18f))
                            .border(3.dp, AccentYellow, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = null,
                            tint = White,
                            modifier = Modifier.size(44.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "MarketHub",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 34.sp,
                        color = White,
                        letterSpacing = 1.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .background(AccentYellow.copy(alpha = 0.25f))
                            .padding(horizontal = 16.dp, vertical = 5.dp)
                    ) {
                        Text(
                            text = "Your Ultimate Shopping Destination",
                            fontSize = 13.sp,
                            color = AccentYellow,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }

            // ── Stats Row (overlapping hero) ─────────────────────────────
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .offset(y = (-18).dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                GradientStatCard("50K+",  "Products",   gradientBlue,  Modifier.weight(1f))
                GradientStatCard("200K+", "Customers",  gradientGreen, Modifier.weight(1f))
                GradientStatCard("4.8★",  "App Rating", gradientRed,   Modifier.weight(1f))
            }

            // ── Decorative strip ─────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .background(stripGradient)
            )

            // ── Our Story ────────────────────────────────────────────────
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)) {
                SectionLabel("Our Story")
                Card(
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        BodyText(
                            "MarketHub was founded in 2021 with a simple mission: make online " +
                                    "shopping smarter, faster, and more enjoyable for everyone across " +
                                    "Africa and beyond. We started as a small team of passionate developers " +
                                    "and entrepreneurs who believed that great products should be accessible " +
                                    "to everyone, regardless of where they live."
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        BodyText(
                            "Today, MarketHub connects thousands of sellers with millions of buyers, " +
                                    "offering electronics, fashion, home goods, beauty products, and much " +
                                    "more — all in one seamless place."
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(OrangeLight)
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text("🚀  Founded 2021", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = neworange)
                            }
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(Color(0xFFE8F5E9))
                                    .padding(horizontal = 12.dp, vertical = 6.dp)
                            ) {
                                Text("🌍  Africa & Beyond", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = AccentGreen)
                            }
                        }
                    }
                }
            }

            // ── Why Choose Us ────────────────────────────────────────────
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(horizontal = 16.dp, vertical = 20.dp)
            ) {
                SectionLabel("Why Choose MarketHub?")
                FeatureCard(Icons.Default.Favorite,     AccentRed,    "Curated Quality Products",  "Every seller is vetted so you always shop with confidence.")
                FeatureCard(Icons.Default.ShoppingCart, neworange,    "Fast & Secure Checkout",    "Multiple payment options with bank-grade encryption.")
                FeatureCard(Icons.Default.Notifications,AccentGreen,  "Real-Time Order Tracking",  "Know exactly where your package is at every step.")
                FeatureCard(Icons.Default.Person,       AccentBlue,   "24/7 Customer Support",     "Our friendly team is always ready to help you out.")
                FeatureCard(Icons.Default.Star,         AccentPurple, "Exclusive Deals & Offers",  "Unlock member-only discounts, flash sales & seasonal promotions.")
            }

            Spacer(modifier = Modifier.height(12.dp))

            // ── Our Mission ──────────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(missionGradient)
                    .padding(24.dp)
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Star, contentDescription = null, tint = AccentYellow, modifier = Modifier.size(22.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Our Mission", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp, color = White)
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                    Text(
                        text = "\"To empower buyers and sellers through technology by creating a trusted, " +
                                "inclusive, and seamless marketplace that brings the best of commerce to every doorstep.\"",
                        fontSize = 14.sp,
                        color = White.copy(alpha = 0.85f),
                        lineHeight = 23.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(neworange)
                            .padding(horizontal = 14.dp, vertical = 7.dp)
                    ) {
                        Text("Connecting Africa, One Deal at a Time", fontSize = 12.sp, color = White, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ── Contact Us ───────────────────────────────────────────────
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White)
                    .padding(horizontal = 16.dp, vertical = 20.dp)
            ) {
                SectionLabel("Get In Touch")
                ContactChip(Icons.Default.Menu,          "www.markethub.co.ke",          neworange)
                ContactChip(Icons.Default.Notifications, "support@markethub.co.ke",      AccentBlue)
                ContactChip(Icons.Default.Phone,         "+254 700 123 456",             AccentGreen)
                ContactChip(Icons.Default.Share,         "@MarketHubApp | @MarketHub_KE",AccentPurple)
            }

            // ── Footer ───────────────────────────────────────────────────
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(footerGradient)
                    .padding(vertical = 24.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("MarketHub", fontWeight = FontWeight.ExtraBold, fontSize = 20.sp, color = White, letterSpacing = 1.sp)
                    Text("v1.0.0", fontSize = 12.sp, color = AccentYellow, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text("© 2024 MarketHub. All rights reserved.", fontSize = 11.sp, color = White.copy(alpha = 0.7f))
                }
            }
        }
    }
}

// ── Preview ────────────────────────────────────────────────────────────────
@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen(rememberNavController())
}