package com.example.keuangan.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import com.example.parkir.model.DataParkir
import com.example.parkir.persitences.DataParkitDao
import com.example.parkir.ui.theme.Purple700
import com.example.parkir.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormPencatatanParkir(dataParkitDao: DataParkitDao) {
    val tanggal = remember { mutableStateOf(TextFieldValue("")) }
    val noParkir = remember { mutableStateOf(TextFieldValue("")) }
    val platNomer = remember { mutableStateOf(TextFieldValue("")) }
    val petugas = remember { mutableStateOf(TextFieldValue("")) }

    val scope = rememberCoroutineScope()
    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()) {

        OutlinedTextField(
            label = { Text(text = "Tanggal") },
            value = tanggal.value,
            onValueChange = {
                tanggal.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd") }
        )
        OutlinedTextField(
            label = { Text(text = "No Parkir") },
            value = noParkir.value,
            onValueChange = {
                noParkir.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(capitalization =
            KeyboardCapitalization.Characters, keyboardType = KeyboardType.Text),
            placeholder = { Text(text = "XXXXX") }
        )
        OutlinedTextField(
            label = { Text(text = "Plat Nomer") },
            value = platNomer.value,
            onValueChange = {
                platNomer.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "5") }
        )
        OutlinedTextField(
            label = { Text(text = "Petugas") },
            value = petugas.value,
            onValueChange = {
                petugas.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType =
            KeyboardType.Decimal),
            placeholder = { Text(text = "5") }
        )
        val loginButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )
        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )
        Row (modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = DataParkir(id, tanggal.value.text,
                    noParkir.value.text, platNomer.value.text, petugas.value.text)
                scope.launch {
                    dataParkitDao.insertAll(item)
                }

                tanggal.value = TextFieldValue("")
                    noParkir.value = TextFieldValue("")
                    platNomer.value = TextFieldValue("")
                    petugas.value = TextFieldValue("")
            }, colors = loginButtonColors) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
            Button(modifier = Modifier.weight(5f), onClick = {
                tanggal.value = TextFieldValue("")
                noParkir.value = TextFieldValue("")
                platNomer.value = TextFieldValue("")
                petugas.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}