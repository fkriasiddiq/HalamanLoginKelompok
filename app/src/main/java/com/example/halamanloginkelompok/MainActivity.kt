package com.example.halamanloginkelompok


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.halamanloginkelompok.ui.theme.HalamanLoginKelompokTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HalamanLoginKelompokTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigator()
                }
            }
        }
    }
}

// Data user
data class User(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val phone: String,
    val password: String
)

@Composable
fun AppNavigator() {
    var currentScreen by remember { mutableStateOf("register") }
    var registeredUser by remember { mutableStateOf<User?>(null) }
    var loggedInUser by remember { mutableStateOf<User?>(null) }

    when (currentScreen) {
        "register" -> RegisterScreen(
            onRegister = { user ->
                registeredUser = user
                currentScreen = "login"
            }
        )
        "login" -> LoginScreen(
            onLogin = { username, password ->
                if (registeredUser != null &&
                    registeredUser!!.username == username &&
                    registeredUser!!.password == password
                ) {
                    loggedInUser = registeredUser
                    currentScreen = "profile"
                }
            },
            onForgotPassword = {
                // Untuk contoh sederhana, hanya menampilkan snackbar / print log
                println("Forgot password clicked")
            }
        )
        "profile" -> ProfileScreen(
            user = loggedInUser!!,
            onLogout = {
                loggedInUser = null
                currentScreen = "login"
            }
        )
    }
}




