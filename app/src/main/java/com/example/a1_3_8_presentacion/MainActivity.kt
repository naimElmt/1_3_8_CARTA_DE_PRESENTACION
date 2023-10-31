package com.example.a1_3_8_presentacion



import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a1_3_8_presentacion.ui.theme._1_3_8_PresentacionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _1_3_8_PresentacionTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Pantalla()

                }
            }
        }

    }

//METODO IMAGEN DE BACKGROUND

    @Composable
    fun Imagen_de_Fondo() {
        val fondo = painterResource(R.drawable.fondo)
        Image(
            painter = fondo,
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
    }

//METODO IMAGEN BANNER

    @Composable
    fun BannerImage() {
        val image = painterResource(R.drawable.bannerimage)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(85.dp)
        )
    }


//LISTA CON LENGUAJES DE PROGRAMACION (METODOS)

    @Composable
    fun ElementoLista(nombre: String, @DrawableRes imagen: Int, url: String?) {
        val context = LocalContext.current

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(5.dp))
                .padding(8.dp)
                .clickable {
                    url?.let {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it))
                        context.startActivity(intent)
                    }
                }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            ) {
                Image(
                    painter = painterResource(imagen),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
                Text(text = nombre, modifier = Modifier.padding(start = 8.dp), fontSize = 20.sp)
            }
        }
    }



//ROWS Y METODOS CON INFORMACION PERSONAL

    @Composable
    fun Informacion() {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "Informacion de contacto:", fontSize = 15.sp, fontWeight = FontWeight.Bold)
            NumeroTelefono()
            CorreoElectronico()
            RedSocial()
        }
    }


    @Composable
    fun NumeroTelefono() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.telefono),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "+1234567890", modifier = Modifier.padding(start = 10.dp))
        }
    }

    @Composable
    fun CorreoElectronico() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.correo_electronico),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "correo@example.com", modifier = Modifier.padding(start = 10.dp))
        }
    }

    @Composable
    fun RedSocial() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.medios_de_comunicacion_social),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
            Text(text = "@usuario", modifier = Modifier.padding(start = 10.dp))
        }
    }

//PANTALLA, DONDE METO TODOS LOS METODOS

    @Composable
    fun Pantalla() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {

//IMAGEN DE BACKGROUND

            Imagen_de_Fondo()

//IMAGEN DE BANNER, IMAGEN DE PEFIL Y TEXTOS DE NOMBRE Y FRASE

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top


            ) {
                BannerImage()
                Spacer(modifier = Modifier.height(1.dp))


                val image = painterResource(R.drawable.pfp)
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(165.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape)
                )
                Text(
                    text = stringResource(R.string.texto_nombre),
                    modifier = Modifier.padding(top = 10.dp, bottom = 8.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Text(text = stringResource(R.string.texto_frase), fontSize = 16.sp)
                Spacer(modifier = Modifier.height(30.dp))

//LISTA LENGUAJES DE PROGRAMACIÓN

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 5.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Lenguajes dominados:",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    ElementoLista("Java", R.drawable.java,"https://www.java.com/" )
                    ElementoLista("Kotlin", R.drawable.kotlin,"https://kotlinlang.org/")
                    ElementoLista("HTML", R.drawable.html,"https://developer.mozilla.org/en-US/docs/Web/HTML" )
                }

                Spacer(modifier = Modifier.height(15.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                ) {
                    Informacion()
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        _1_3_8_PresentacionTheme {

            Pantalla()

        }
    }
}