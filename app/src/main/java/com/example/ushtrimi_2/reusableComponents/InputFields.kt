package com.example.ushtrimi_2.reusableComponents

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun ReusableInputEmailField(
    value : String,
    event : (String)-> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions : KeyboardOptions = KeyboardOptions.Default,
    label : String = ""
){
    OutlinedTextField(
        value = value,
        label = {Text(text = label)},
        onValueChange = event,
        keyboardOptions = keyboardOptions,
        maxLines = 1,
        visualTransformation = visualTransformation,

        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun AlertUser(){
    //
}