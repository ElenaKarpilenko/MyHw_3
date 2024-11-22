package com.example.myhw_3
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

data class NavigationItemData(
    val label: String,
    val route: String,
    val icon: Int // Убедитесь, что это ID ресурса
)

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        NavigationItemData("Home", "home", R.drawable.home_icon),
        NavigationItemData("Profile", "profile", R.drawable.profileicon),
        NavigationItemData("Settings", "settings", R.drawable.settingsicon)
    )

    NavigationBar { // Добавляем контейнер для нижней навигации
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = null) },
                label = { Text(item.label) },
                selected = currentRoute(navController) == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        // Избегаем создания нескольких копий одного пункта
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    return navBackStackEntry.value?.destination?.route
}
