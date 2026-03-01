package com.example.app06_TextField

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.app06_TextField.ui.theme.MyApp_Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp_Theme() {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyExample(modifier = Modifier.padding( innerPadding))
                }
            }
        }

    }
}


@Composable
fun MyExample(modifier: Modifier = Modifier) {

    Column(
        Modifier.fillMaxSize().verticalScroll( rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField1()
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField2()
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField3()
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField4()
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField5()
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField6()
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField7()
        Spacer(modifier = Modifier.padding(10.dp))
        MyTextField8()


    }
}

@Composable
fun MyTextField1(){
    var myText by remember{ mutableStateOf("") }
    Text("TextField bàsic, amb estat")
    TextField(value = myText, onValueChange = { myText = it })
}
@Composable
fun MyTextField2(){
    var myText by rememberSaveable(){ mutableStateOf("") }
    Text("Aquest TextField guarda l'estat en rotar")
    TextField(value = myText, onValueChange = { myText = it })
}

@Composable
fun MyTextField3(){
    var myText by rememberSaveable(){ mutableStateOf("") }
    Text("Aquest TextField, a més. té una descripció de la dada a introduir")
    TextField(
        value = myText,
        onValueChange = { myText = it },
        label = { Text(text = "Entra el teu nom") }
    )
}

@Composable
fun MyTextField4(){
    var myText by rememberSaveable(){ mutableStateOf("") }
    Text("Aquest TextField només admet números")
    TextField(
        value = myText,
        onValueChange = { myText = it },
        label = { Text(text = "Entra la teva edat") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

    )
}

@Composable
fun MyTextField5(){
    var myText by rememberSaveable(){ mutableStateOf("") }
    val pattern = remember { Regex("^\\d+\$") }

    Text("Ara amb validació d'una expressió regular")
    TextField(
        value = myText,
        onValueChange = {
            if (it.isEmpty() || it.matches(pattern)) myText = it
        },
        label = { Text(text = "Enter your year of birth") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun MyTextField6() {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    Text("I un exemple de password")
    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Enter your password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisibility) { Icons.Filled.VisibilityOff }
                        else { Icons.Filled.Visibility }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = image, contentDescription = "Password visibility")
            }
        },
        visualTransformation = if (passwordVisibility) { VisualTransformation.None }
        else {
            PasswordVisualTransformation()
        }
    )
}


@Composable
fun MyTextField7(){
    var myText by rememberSaveable(){ mutableStateOf("") }

    Text("Amb OutlinedTextField")
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        label = { Text("Enter your name") })
}


@Composable
fun MyTextField8(){
    var myText by rememberSaveable(){ mutableStateOf("") }

    Text("Amb colors si s'agafa el focus ")
    OutlinedTextField(
        value = myText,
        onValueChange = { myText = it },
        label = { Text("Enter your name") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Green,
            unfocusedContainerColor = Color.Gray,
            focusedTextColor = Color.Black
        )
    )

}
