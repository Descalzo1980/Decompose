import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.RootComponent
import navigation.ScreenAComponent
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import screens.ScreenA
import screens.ScreenB

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(rootComponent: RootComponent) {
    MaterialTheme {
            val childStack by rootComponent.childStack.subscribeAsState()
            Children(
                stack = childStack,
                animation = stackAnimation(slide())
            ){ child ->
                when(val instance = child.instance) {
                    is RootComponent.Child.ScreenA -> ScreenA(instance.component)
                    is RootComponent.Child.ScreenB -> ScreenB(instance.component)
                }
            }
    }
}