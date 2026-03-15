package com.quinn.affirmationsapp.ui.screens

import coil.compose.rememberAsyncImagePainter
import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.statusBarsPadding
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.quinn.affirmationsapp.R
import com.quinn.affirmationsapp.ui.components.NavBar
import com.quinn.affirmationsapp.viewmodel.AffirmationViewModel

@Composable
fun NewAffirmationScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    affirmationViewModel: AffirmationViewModel = hiltViewModel()
) {
    Scaffold (
        modifier = modifier.statusBarsPadding(),
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
                            onClick = { navController.popBackStack() },
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
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
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
            NewAffirmationBody(
                copyImage = affirmationViewModel::copyImage,
                affirmationImage = affirmationViewModel.affimrationImage,
                affirmationText = affirmationViewModel.affimrationText,
                setImageUri = affirmationViewModel::saveImageUri,
                onTextChange = affirmationViewModel::onTextChange,
                Modifier.padding(innerPadding)
            )
    }
}

@Composable
fun NewAffirmationBody(
    copyImage: (context: Context, imageUri: Uri, filename: String) -> String,
    affirmationImage: String,
    affirmationText: String,
    setImageUri: (String) -> Unit,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // Set the image picker launcher
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent() // Set contract
    ) {
            uri ->
        imageUri = uri
        val fileName = uri.toString() // Set the filename
        imageUri = uri
        val copiedPath = copyImage(
            context,
            (uri as Uri), // Send the uri to copy the image
            fileName.substring((fileName.length-4),fileName.length) // Trim the file name
        )
    }

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
            value = affirmationText,
            placeholder = {
                Text(
                    text = stringResource(R.string.i_am_strong_capable_and_worthy_of_success_textfield_placeholder),
                    color = Color.Gray,
                    style = MaterialTheme.typography.labelLarge
                ) },
            singleLine = true,
            onValueChange = { onTextChange(it) },
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedContainerColor = Color(0xFF1e1e1e),
                unfocusedContainerColor = Color(0xFF1e1e1e),
                focusedIndicatorColor = Color(0xFF1e1e1e),
                unfocusedIndicatorColor = Color(0xFF1e1e1e),
            ),
            shape = RoundedCornerShape(10.dp)

        )
        Text(
            text = "${affirmationText.length}/280 characters",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
        Spacer(Modifier.height(50.dp))
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
            onClick = { imagePickerLauncher.launch("image/*") },
            contentPadding = PaddingValues(0.dp),
            colors = buttonColors(
                contentColor = Color(0xFF1e1e1e),
                containerColor = Color(0xFF1e1e1e)
            ),
            shape = RoundedCornerShape(10.dp)

        ) {
            if (imageUri == null) {
                Column (modifier = Modifier.padding(vertical = 50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally) {
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
            } else {
                imageUri.let {
                    Image(
                        painter = rememberAsyncImagePainter(imageUri),
                        contentDescription = "",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.FillWidth
                    )
                }
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