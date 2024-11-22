package com.example.myhw_3


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter


@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}
@ExperimentalMaterial3Api
@Composable
fun MyApp() {
    val navController = rememberNavController()
    listOf("Экран 1", "Экран 2")
// Пример списка персонажей, эпизодов и локаций
    val characters = listOf(
        Character(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            gender = "Male",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            origin = "Earth",
            location = "Earth"
        ),
        Character(
            id = 2,
            name = "Morty Smith",
            status = "Alive",
            species = "Human",
            gender = "Male",
            image = "https://rickandmortyapi.com/api/character/avatar/2.jpeg",
            origin = "Earth",
            location = "Earth"
        ),
        Character(
            id = 3,
            name = "Summer Smith",
            status = "Alive",
            species = "Human",
            gender = "Female",
            image = "https://rickandmortyapi.com/api/character/avatar/3.jpeg",
            origin = "Earth",
            location = "Earth"
        ),
        Character(
            id = 4,
            name = "Beth Smith",
            status = "Alive",
            species = "Human",
            gender = "Female",
            image = "https://rickandmortyapi.com/api/character/avatar/4.jpeg",
            origin = "Earth",
            location = "Earth"
        ),
        Character(
            id = 5,
            name = "Jerry Smith",
            status = "Alive",
            species = "Human",
            gender = "Male",
            image = "https://rickandmortyapi.com/api/character/avatar/5.jpeg",
            origin = "Earth",
            location = "Earth"
        )
    )




    val episodes = listOf(
        Episode(
            id = 28,
            name = "The Ricklantis Mixup",
            airDate = "September 10, 2017",
            episode = "S03E07",
            characters = listOf(
                "https://rickandmortyapi.com/api/character/1",
                "https://rickandmortyapi.com/api/character/2",
                "https://rickandmortyapi.com/api/character/3",
                "https://rickandmortyapi.com/api/character/4"
            ),
           
        ),
        Episode(
            id = 29,
            name = "The ABCs of Beth",
            airDate = "June 25, 2017",
            episode = "S03E09",
            characters = listOf(
                "https://rickandmortyapi.com/api/character/1",
                "https://rickandmortyapi.com/api/character/5",
                "https://rickandmortyapi.com/api/character/6"
            ),
           
        ),
        Episode(
            id = 30,
            name = "The Rickshank Rickdemption",
            airDate = "April 1, 2017",
            episode = "S03E01",
            characters = listOf(
                "https://rickandmortyapi.com/api/character/1",
                "https://rickandmortyapi.com/api/character/7",
                "https://rickandmortyapi.com/api/character/8"
            ),
           
        ),
        Episode(
            id = 31,
            name = "Pickle Rick",
            airDate = "August 6, 2017",
            episode = "S03E03",
            characters = listOf(
                "https://rickandmortyapi.com/api/character/1",
                "https://rickandmortyapi.com/api/character/9",
                "https://rickandmortyapi.com/api/character/10"
            ),
            
        ),
        Episode(
            id = 32,
            name = "Get Schwifty",
            airDate = "August 23, 2015",
            episode = "S02E05",
            characters = listOf(
                "https://rickandmortyapi.com/api/character/1",
                "https://rickandmortyapi.com/api/character/2",
                "https://rickandmortyapi.com/api/character/3"
            ),
            
        ),
        Episode(
            id = 33,
            name = "Rixty Minutes",
            airDate = "July 26, 2015",
            episode = "S02E08",
            characters = listOf(
                "https://rickandmortyapi.com/api/character/1",
                "https://rickandmortyapi.com/api/character/4",
                "https://rickandmortyapi.com/api/character/5"
            ),
           
        ),
        Episode(
            id = 34,
            name = "Close Rick-Counters of the Rick Kind",
            airDate = "July 10, 2015",
            episode = "S01E10",
            characters = listOf(
                "https://rickandmortyapi.com/api/character/1",
                "https://rickandmortyapi.com/api/character/11",
                "https://rickandmortyapi.com/api/character/12"
            ),
            
        )
    )


    val locations = listOf(
        Location(id = 1, name = "Earth", type = "Planet", dimension = "Dimension C-137"),
        Location(id = 2, name = "Crab World", type = "Planet", dimension = "Dimension 35-C"),
        Location(id = 3, name = "Purge World", type = "Planet", dimension = "Dimension 19"),
        Location(id = 4, name = "Gazorpazorp", type = "Planet", dimension = "Gazorpazorpfield"),
        Location(id = 5, name = "Anatomy Park", type = "Location", dimension = "Dimension C-137"),
        Location(id = 6, name = "Interdimensional Cable", type = "Location", dimension = "Various"),
        Location(id = 7, name = "The Citadel", type = "Station", dimension = "Dimension C-137"),
        Location(id = 8, name = "Ricklettes", type = "Planet", dimension = "Dimension C-137"),
        Location(id = 9, name = "Planet Squanch", type = "Planet", dimension = "Dimension C-137"),
        Location(id = 10, name = "Robo-Rick's Lab", type = "Location", dimension = "Dimension 31"),
        Location(id = 11, name = "Wubba Lubba Dub Dub", type = "Planet", dimension = "Dimension C-137"),
        Location(id = 12, name = "Evil Morty’s Citadel", type = "Station", dimension = "Dimension 2"),
        Location(id = 13, name = "Froopyland", type = "Location", dimension = "Dimension C-137"),
        Location(id = 14, name = "The Flurp Station", type = "Station", dimension = "Dimension 91"),
        Location(id = 15, name = "Beth's Memory", type = "Location", dimension = "Dimension 35-E"),
        Location(id = 16, name = "Space Cruiser", type = "Vehicle", dimension = "Various"),
        Location(id = 17, name = "The Post-Apocalyptic World", type = "Planet", dimension = "Dimension Z-19"),
        Location(id = 18, name = "Zigerions", type = "Planet", dimension = "Dimension 23"),
        Location(id = 19, name = "The Meeseeks Box", type = "Location", dimension = "Dimension 93"),
        Location(id = 20, name = "The Galactic Federation", type = "Organization", dimension = "Dimension 55-X")
    )



    Scaffold(
        topBar = {
            Column {
                // Top bar with project title
                TopAppBar(title = { Text("Rick and Morty API") })
            }
        },
        bottomBar = {
            CustomBottomNavigationBar(navController) // Bottom navigation bar
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavigationGraph(navController, characters, episodes, locations) // Pass data
        }
    }
}

@Composable
fun NavigationGraph(
    navController: NavHostController,
    characters: List<Character>,
    episodes: List<Episode>,
    locations: List<Location>
) {
    NavHost(
        navController = navController,
        startDestination = "characters"
    ) {


        composable("episodes") {
            EpisodesScreen(navController, episodes)
        }
        composable("locations") {
            LocationsScreen(navController, locations)
        }
    }
}

@Composable
fun CharacterListItem(character: Character, navController: NavController) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable {
            navController.navigate("characterDetail/${character.id}")
        }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = "Character Image",
                modifier = Modifier.size(60.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = character.name, fontWeight = FontWeight.Bold)
                Text(text = "Status: ${character.status}")
                Text(text = "Species: ${character.species}")
            }
        }
    }
}

@Composable
fun CharacterDetailScreen(characterId: Int, characters: List<Character>) {
    val character = characters.first { it.id == characterId }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(character.image),
            contentDescription = "Character Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = character.name, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.headlineMedium)
        Text(text = "Status: ${character.status}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Species: ${character.species}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Gender: ${character.gender}", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Origin: ${character.origin}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Location: ${character.location}", style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun EpisodesScreen(navController: NavController, episodes: List<Episode>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(episodes) { episode ->
            EpisodeItem(episode, navController)
        }
    }
}

@Composable
fun EpisodeItem(episode: Episode, navController: NavController) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column {
                Text(text = episode.name, fontWeight = FontWeight.Bold)
                Text(text = "Air Date: ${episode.airDate}")
                Text(text = "Episode: ${episode.episode}")
            }
        }
    }
}

@Composable
fun LocationsScreen(navController: NavController, locations: List<Location>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(locations) { location ->
            LocationItem(location, navController)
        }
    }
}

@Composable
fun LocationItem(location: Location, navController: NavController) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column {
                Text(text = location.name, fontWeight = FontWeight.Bold)
                Text(text = "Type: ${location.type}")
                Text(text = "Dimension: ${location.dimension}")
            }
        }
    }
}

@Composable
fun CustomBottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        NavigationItem("Characters", "characters", Icons.Default.Person),
        NavigationItem("Episodes", "episodes", Icons.AutoMirrored.Filled.List),
        NavigationItem("Locations", "locations", Icons.Default.Place)
    )

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(item.label) },
                selected = navController.currentRoute() == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

data class NavigationItem(val label: String, val route: String, val icon: ImageVector)

@Composable
fun NavHostController.currentRoute(): String? {
    val navBackStackEntry = currentBackStackEntryAsState()
    return navBackStackEntry.value?.destination?.route
}

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String,
    val origin: String,
    val location: String
)

data class Episode(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<String>
)

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String)




