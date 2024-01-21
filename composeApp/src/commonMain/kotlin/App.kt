import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import androidx.compose.foundation.layout.height
import cafe.adriel.voyager.transitions.FadeTransition
import cafe.adriel.voyager.transitions.ScaleTransition
import cafe.adriel.voyager.transitions.SlideTransition

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
        Navigator(screen = MainScreen()){
            navigator ->
            //SlideTransition(navigator)
            //FadeTransition(navigator)
            ScaleTransition(navigator)
        }
    }
}
class MainScreen:Screen{
    @Composable
    override fun Content(){
        val navigator: Navigator? = LocalNavigator.current
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                navigator?.push(SecondScreen())
            }) {
                Text("Navegación Basica")
            }
        }
    }
}
class SecondScreen:Screen{
    @OptIn(ExperimentalResourceApi::class)
    @Composable
    override fun Content() {
        val navigator:Navigator? = LocalNavigator.current
        Column(Modifier.fillMaxSize().background(Color.Gray),horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Segunda Pantalla", fontSize = 26.sp, color = Color.White)
            Spacer(Modifier.height(20.dp))
            Button(onClick = {navigator?.pop()}){
                Text("Volver")
            }
        }
    }

}
