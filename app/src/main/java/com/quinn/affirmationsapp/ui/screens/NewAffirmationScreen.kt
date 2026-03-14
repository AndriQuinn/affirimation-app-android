
package com.quinn.affirmationsapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.quinn.affirmationsapp.R
import com.quinn.affirmationsapp.ui.components.NavBar

@Composable
fun NewAffirmationScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold (
        topBar = {
            NavBar(
                modifier = Modifier
                    .background(Color(0xFF121212))
                    .fillMaxWidth()
                    .padding(15.dp),
                arrangement = Arrangement.Start,
                elements = listOf(
                    {
                        Button(
                            onClick = {},
                            contentPadding = PaddingValues(0.dp),
                            colors = buttonColors(
                                contentColor = Color.Transparent,
                                containerColor = Color.Transparent
                            )
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.right_arrow),
                                contentDescription = "back_icon_desc",
                                tint = Color.White,
                                modifier = Modifier
                                    .size(25.dp)
                                    .rotate(180f)
                            )
                        }
                    },
                    { Row(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.christmas_stars),
                            contentDescription = "back_icon_desc",
                            tint = Color.White,
                            modifier = Modifier
                                .size(35.dp)
                                .rotate(180f)
                        )
                        Spacer(Modifier.width(10.dp))
                        Text(
                            text = stringResource(R.string.create_affirmation_screen_title),
                            style = MaterialTheme.typography.displaySmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 24.sp
                        )
                    }
                    }
                )
            )
        }
    ) { innerPadding ->
            NewAffirmationBody(Modifier.padding(innerPadding))
    }
}

@Composable
fun NewAffirmationBody(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
            .background(Color(0xFF121212))
            .padding(30.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.your_affirmation_textfield_lbl),
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
                .border(1.dp, Color(0xFF353538), RoundedCornerShape(10.dp)),
            value = "",
            placeholder = {
                Text(
                    text = stringResource(R.string.i_am_strong_capable_and_worthy_of_success_textfield_placeholder),
                    color = Color.White,
                    style = MaterialTheme.typography.labelLarge
                ) },
            singleLine = true,
            onValueChange = {  },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedContainerColor = Color(0xFF1e1e1e),
                unfocusedContainerColor = Color(0xFF1e1e1e),
                focusedIndicatorColor = Color(0xFF1e1e1e),
                unfocusedIndicatorColor = Color(0xFF1e1e1e),
            ),
            shape = RoundedCornerShape(10.dp)

        )
        Text(
            text = "0/280 characters",
            style = MaterialTheme.typography.bodySmall,
            color = Color.White
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.background_image_optional_textfield_lbl),
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        Button(
            modifier = Modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth()
                .border(1.dp, Color(0xFF353538), RoundedCornerShape(10.dp))
            ,
            onClick = {},
            contentPadding = PaddingValues(0.dp),
            colors = buttonColors(
                contentColor = Color(0xFF1e1e1e),
                containerColor = Color(0xFF1e1e1e)
            ),
            shape = RoundedCornerShape(10.dp)

        ) {
            Column (
                modifier = Modifier.padding(vertical = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(R.drawable.add_photo_icon),
                    contentDescription = "add_photo_icon_desc",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                )
                Spacer(Modifier.height(15.dp))
                Text(
                    text = stringResource(R.string.tap_to_add_an_image_btn_lbl),
                    style = MaterialTheme.typography.labelLarge,
                    color = Color.White
                )
                Text(
                    text = stringResource(R.string.png_jpg_up_to_10mb_btn_lbl),
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White
                )
            }
        }
        Spacer(Modifier.height(5.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            contentPadding = PaddingValues(0.dp),
            colors = buttonColors(
                contentColor = Color(0xFF8154EF),
                containerColor = Color(0xFF8154EF)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.star_icon),
                    contentDescription = "back_icon_desc",
                    tint = Color.White,
                    modifier = Modifier
                        .size(20.dp)
                        .rotate(180f)
                )
                Spacer(Modifier.width(15.dp))
                Text(
                    text = stringResource(R.string.add_affirmation_btn_lbl),
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White
                )
            }
        }
    }
}

@Preview (
    showBackground = true,
    showSystemUi = true,
    name = "New Affirmation Screen"
)
@Composable
fun NewAffirmationScreenPreview() {
    NewAffirmationScreen(navController = rememberNavController())
}