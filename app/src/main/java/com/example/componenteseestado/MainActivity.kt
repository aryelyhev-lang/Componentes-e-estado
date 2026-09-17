package com.example.componenteseestado

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.componenteseestado.ui.theme.ComponentesEEstadoTheme
import com.example.componenteseestado.ui.theme.Righteous

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComponentesEEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BasicComponentsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BasicComponentsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(10, 67, 54))
    ) {
        Text(
            text = "Aulas android", // modifier = Modifier.fillMaxWidth().background(Color(0xFFE8AF5C))
            fontSize = 32.sp, // tamanho da fon0x58AFDDte, adaptável à escala de texto do usuário
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3DDC84),
            textAlign = TextAlign.End,
            letterSpacing = 4.sp,  // espaçamento entre as letras
            modifier = Modifier
                .background(Color(0xFF235284))
                .fillMaxWidth()
        )
        Text(
            text = "com Jetpack compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(66, 133, 244),
            fontFamily = Righteous,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        TextField(
            value = "Android",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth()
        )

        AndroidEnemy(
            color = Color.Cyan,
            modifier = Modifier.size(200.dp)
        )

        AndroidEnemy(
            color = Color.Black,
            modifier = Modifier.size(200.dp)
        )
    }
}

@Composable
fun AndroidEnemy(color: Color, modifier: Modifier = Modifier){
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = "Android Enemy"
    )
}