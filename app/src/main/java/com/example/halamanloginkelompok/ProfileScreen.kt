package com.example.halamanloginkelompok

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen(user: User, onLogout: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Profile", style = MaterialTheme.typography.headlineMedium)

        Text("First Name: ${user.firstName}")
        Text("Last Name: ${user.lastName}")
        Text("Username: ${user.username}")
        Text("Email: ${user.email}")
        Text("Phone: ${user.phone}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { onLogout() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Logout")
        }
    }
}
