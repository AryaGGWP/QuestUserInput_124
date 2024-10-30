package com.example.pertemuan_5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily.Companion.Cursive
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier){
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var noTelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var memilihjk by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var emailsv by remember { mutableStateOf("") }
    var noTelponsv by remember { mutableStateOf("") }
    var alamatsv by remember { mutableStateOf("") }
    var jenissv by remember { mutableStateOf("") }
    var memilihjksv by remember { mutableStateOf("") }

    val listjk = listOf("Laki-Laki", "Perempuan")

    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Biodata",
            fontSize = 16.sp
        , fontWeight = FontWeight.Bold)
        Spacer(Modifier.padding(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = { Text("nama")},
            placeholder = {Text("Masukkan Nama Anda")}
        )
        Row {
            listjk.forEach{item ->
                Row(verticalAlignment = Alignment.CenterVertically) { RadioButton(
                    selected = memilihjk == item,
                    onClick = {
                        memilihjk = item
                    }
                )
                    Text(item)
                }
            }
            TextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = email,
                onValueChange = {email = it},
                label = { Text("E-mail")},
                placeholder = {Text("Masukkan E-mail Anda")}
            )
            TextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = noTelpon,
                onValueChange = {noTelpon = it},
                label = { Text("No Telepon")},
                placeholder = {Text("Masukkan Nomor Telepon Anda")}
            )
            TextField(
                modifier = Modifier.fillMaxWidth().padding(5.dp),
                value = alamat,
                onValueChange = {alamat = it},
                label = { Text("Alamat")},
                placeholder = {Text("Masukkan Nama Anda")}
            )
            Button(onClick = {
                namasv = nama
                emailsv = email
                noTelponsv = noTelpon
                alamatsv = alamat
                memilihjksv = memilihjk
            }) {
                Text("Submit")
            }
            ElevatedCard(modifier = Modifier.fillMaxWidth()
                ,colors = CardDefaults.cardColors(containerColor = Color.Black)
            )
            {
                DetailMessage(judul = "nama", isinya = namasv)
                DetailMessage(judul = "email", isinya = emailsv)
                DetailMessage(judul = "noTelpon", isinya = noTelponsv)
                DetailMessage(judul = "Alamat", isinya = alamatsv)
                DetailMessage(judul = "Jenis Kelamin", isinya = memilihjksv)
            }
        }
    }
}

@Composable
fun DetailMessage(
    judul: String, isinya: String
) {
        Row(modifier = Modifier.fillMaxWidth().padding(top = 12.dp
        )){
            Text(
                text = judul,
                modifier = Modifier.weight(0.3f),
                fontSize = 18.sp
            )
            Text(text = ":",
                modifier = Modifier.weight(0.2f),
                fontWeight = FontWeight.Bold
            )
            Text(text = isinya,
                modifier = Modifier.weight(0.9f),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Cursive
            )
        }
    }
