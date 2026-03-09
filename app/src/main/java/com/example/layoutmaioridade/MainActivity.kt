package com.example.layoutmaioridade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layoutmaioridade.ui.theme.LayoutMaioridadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutMaioridadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StartScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun StartScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Qual é a sua idade?",
                color = Color.Blue,
                fontSize = 32.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Aperte os botões para informar a sua idade",
                color = Color.Black,
                fontSize = 18.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        var idade by remember { mutableStateOf(0) }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "$idade",
                color = Color.Black,
                fontSize = 40.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row() {
            Button(
                onClick = {
                    if(idade > 0) {
                        idade -= 1
                    }
                },
                modifier = Modifier
                    .padding(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Icon subtrair",
                    tint = Color.White
                )
            }

            Button(
                onClick = {
                    if (idade <= 99) {
                        idade += 1
                    }
                },
                modifier = Modifier
                    .padding(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                ),
                shape = RoundedCornerShape(5.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "Icon somar",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (idade >= 18){
                Text(
                    text = "Você é MAIOR de idade",
                    color = Color.Blue,
                    fontSize = 32.sp
                )
            }else{
                Text(
                    text = "Você é MENOR de idade",
                    color = Color.Blue,
                    fontSize = 32.sp
                )
            }

        }
    }
}