package com.hagui.pontoalerta

import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hagui.pontoalerta.ui.theme.PontoAlertaTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import androidx.datastore.dataStore
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import androidx.datastore.preferences.core.edit
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PontoAlertaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaPrincipal()
                }
            }
        }
    }
}
@Composable
fun TelaPrincipal(){
    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Titulo()
        AreaPrincipal()

    }
}
@Composable
fun AreaPrincipal(){
    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(30.dp, 30.dp))
    ){
        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Row(){
                Icon(imageVector = Icons.Outlined.Home, contentDescription = null, modifier = Modifier.align(alignment = Alignment.CenterVertically))
                Text(text = "",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .padding(0.dp),
                    )

                Icon(imageVector = Icons.Outlined.Edit, contentDescription = null, modifier = Modifier.align(alignment = Alignment.CenterVertically))
            }
            Row{
                androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.baseline_schedule_24), contentDescription = null, modifier = Modifier.align(alignment = Alignment.CenterVertically))
                //Text(text = "$horasRestante:$minutosRestante:$segundosRestante", style = MaterialTheme.typography.displaySmall, modifier = Modifier.padding(25.dp),
                    //fontWeight = FontWeight.Bold
                //)
            }
            Button(onClick = {
                SalvarDataAtual()
            }) {
                Text(text = "Parar a jornada", modifier = Modifier.padding(5.dp))
            }
        }
    }
}
fun SalvarDataAtual(){
}
@Composable
fun Titulo(){
    Column{
        Row(verticalAlignment = Alignment.CenterVertically){
            Text(text = "Ponto Alerta",
                style = MaterialTheme.typography.displayMedium,

                modifier = Modifier
                    .padding(top = 230.dp, start = 25.dp, end = 0.dp, bottom = 25.dp)
                    .fillMaxWidth()
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewPontoAlerta(){
    PontoAlertaTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            TelaPrincipal()
        }
    }
}


