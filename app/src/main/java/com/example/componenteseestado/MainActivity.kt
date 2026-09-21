package com.example.componenteseestado

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
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

    // Criando uma constante estado atual do elemento antes da tela ser atualizada
    // e determina que a parte multavel é o valor
    val textFieldValue = remember {
        mutableStateOf("")
    }

    // Utilizando o "by" para não precisar declarar o "value." dentro do textField
    // O "by" delega a tarefa de definir os get e "set" (acesso de uma propriedade) para outro objeto
    var quantidade by remember {
        mutableStateOf("")
    }
    // VAR -> variável, pode ter o valor alterado.
    // VAL -> valor imutável (não pode ser reatribuído depois).
    var email by remember {
        mutableStateOf("")
    }

    var kotlin by remember {
        mutableStateOf(false)
    }

    var jetCompose by remember {
        mutableStateOf(false)
    }

    var android by remember {
        mutableStateOf(false)
    }

    var sistemaSelecionado by remember {
        mutableStateOf(0)
    }

    var corDeFundo by remember {
        mutableStateOf(Color(28, 40, 65, 1))
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(corDeFundo)
    ) {
        Text(
            text = "Aulas android", // Modifier = Modifier.fillMaxWidth().background(Color(0xFFE8AF5C))
            fontSize = 32.sp, // Tamanho da fon0x58AFDDte, adaptável à escala de texto do usuário
            fontWeight = FontWeight.Bold,
            color = Color(220, 102, 200),
            textAlign = TextAlign.Center,
            letterSpacing = 4.sp,  // Espaçamento entre as letras
            modifier = Modifier
                .background(Color(99, 83, 157))
                .fillMaxWidth()
        )
        Text(
            text = "com Jetpack compose",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(99, 83, 157),
            fontFamily = Righteous,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally)
        )


        TextField(
            // Pega o valor modificado dentro do textFildValue.value
            value = textFieldValue.value,
            onValueChange = { novoValor ->
                // Determina que o textFieldValue.value recebe o "novo valor"
                // ele redesenha aquela string sempre que é digitado algo diferente
                // (o campo atualiza pela quantidade de caracters inseridos)
                textFieldValue.value = novoValor
            },
            modifier = Modifier
                .fillMaxWidth(),

            //cria uma instancia para o teclado
            keyboardOptions = KeyboardOptions(
                // Atribui que o teclado numerico seja aberto ao clicar no campo "textFieldValue
                // keyboardType = KeyboardType.Number

                // determina que a cada palavra digitada, a primeira letra deve ficar em maiusculo
                capitalization = KeyboardCapitalization.Words

                // determina que todas as palavras digitadas devem ficar em maiusculo (capslok)
                // capitalization = KeyboardCapitalization.Characters

                // não possui uma capitalização especifica (estado comum do teclado)
                // capitalization = KeyboardCapitalization.None

                // determina que apenas a primeira letra da frase esteja em maiusculo (após o ponto final tambem)
                // capitalization = KeyboardCapitalization.Sentences
            ),

            // Atribui uma etiqueta de identificação na parte superior no campo de escrita
            label = {
                Text(text = "Nome e sobrenome")
            },

            // LeadingIcon -> icone que está a frente do campo de texto
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = "icone pessoa",
//                    tint = Color(66, 133, 244)
//                )
//            }
        )

        Spacer(modifier = Modifier.height(16.dp))  // Espaçamento entre os componentes

        // Criando um novo textField para testar o placeholder (sugestão/dica)
        // TextFiled -> Possui borda e cor no fundo do campo de texto
        TextField(

            value = quantidade,
            onValueChange = { novoValor ->
                quantidade = novoValor
            },

            modifier = Modifier
                .fillMaxWidth(),      // Ocupa todo o espaçamento da tela
            //.padding(5.dp),     // Espaçamento em volta do texto (se tornou inviavel depois de adicionar o "Spacer"

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

            // Atribui uma sugestão no campo de digitação (sumindo quando a pessoa clica para digitar)
            placeholder = {
                Text(text = "Qual a quantidade?")
            },

            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Blue,              // Ao digitar dentro do campo, a cor fica azul
                unfocusedTextColor = Color.Red,             // Ao clicar em outro campo, o texto fica vermelho
                unfocusedPlaceholderColor = Color.Magenta   //Caso não clique em nada, o texto fica naturalmente magenta
            ),

            // trailingIcon  -> icone que está no final do campo de texto
//            trailingIcon = {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = "icone pessoa",
//                    tint = Color(66, 133, 244)
//                )
//            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // "it" é uma palavra-chave implícita do Kotlin.
        // Ela é usada quando temos uma função lambda (callback)
        // que recebe apenas UM parâmetro.

        // Nesse caso:
        // { email = it }
        // O "it" representa o valor que foi passado para a função.
        // No OutlinedTextField, esse valor é o novo texto digitado pelo usuário.
        // É como se tivéssemos escrito:
        // { novoTexto -> email = novoTexto }
        // Porém, como existe apenas um parâmetro, podemos usar "it"
        // para deixar o código mais curto.

        // OutlinedTextField -> Não possui borda e nem cor no fundo do campo de texto
        OutlinedTextField(
            // onValueChange é um callback.
            // Ele é executado sempre que o texto do campo muda.
            // O parâmetro recebido pelo callback é o novo valor digitado.
            value = email,
            onValueChange = { email = it },
            singleLine = true, // Não permite gerar novas linhas dentro do campo ao clicar "enter"

            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),

            // Atribui uma etiqueta na parte superior do campo de texto
            label = {
                Text(text = "Email")
            },

            // Atribui uma sugestão dentro do campo de texto
            placeholder = {
                Text(text = "Digite seu email")
            },

            // Atribui um arredondamento nas bordas do campo de texto para mudar o formato do mesmo
            shape = RoundedCornerShape(
                topStart = 32.dp,
                bottomEnd = 32.dp
            ),

            // Atribui cores diferente para a borda do campo de texto dependendo do foco do mouse
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Blue,
                unfocusedBorderColor = Color.Magenta
            )
        )

        // Criando check box na tela
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = jetCompose,
                onCheckedChange = { jetCompose = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Magenta
                )
            )

            Text("Jet Compose")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = kotlin,
                onCheckedChange = { kotlin = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Magenta
                )
            )

            Text("Kotlin")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = android,
                onCheckedChange = { android = it },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Magenta
                )
            )

            Text("Android")
        }


        // Criando um radio button
        // A variavel sistemaSelecionado inicia em 0
        // sempre que esse valor muda, o item selecionado tambem muda
        // ou seja, a tela inicia sempre selecionado no item MacIOS
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 0,
                onClick = {sistemaSelecionado = 0}
            )

            Text(text = "MacIOS")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 1,
                onClick = {sistemaSelecionado = 1}
            )

            Text(text = "Windows")
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = sistemaSelecionado == 2,
                onClick = {sistemaSelecionado = 2}
            )

            Text(text = "Linux")
        }


        // Criando um row para guardar um botão
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Button(
                onClick = {
                    corDeFundo = Color(28, 40, 65, 2)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(99, 83, 157),
                    contentColor = Color.White
                ),
                border = BorderStroke(4.dp, Color(99, 83, 157)),
                shape = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    //Icon(imageVector = Icons.Default.Star, contentDescription = "Star")
                    Text(text = "★")
                    Text(text = "Clique aqui")
                }

            }

            // Botão que não possui cir de fundo
            OutlinedButton(
                onClick = {
                    corDeFundo = Color.LightGray
                }
            ) {
                Text(text = "Criar conta")
            }
        }
    }
}

@Composable
fun AndroidEnemy(color: Color, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = "Android Enemy"
    )
}