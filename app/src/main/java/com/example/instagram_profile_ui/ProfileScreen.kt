package com.example.instagram_profile_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        TopBar("arfin_hosain")
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSections(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        
    }
}


@Composable
fun TopBar(
    name: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 15.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Arrow Back", tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)

            )

        }
            Text(text = name,fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,fontSize = 24.sp)

            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_bell),
                    contentDescription ="Icon Bell",
                    modifier
                        .size(24.dp)
                        .offset(30.dp)
                )
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_dotmenu),
                    contentDescription ="Icon Three Dots",modifier.size(20.dp)
                )
        }
    }
}

@Composable
fun ProfileSection(modifier: Modifier  = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically) {
            RoundImage(
                painter = painterResource(id = R.drawable.arfin),
                modifier = modifier
                    .size(100.dp)
                    .weight(3f),
                image = highlights[it].image
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(modifier = Modifier.weight(7f))
        }
        Spacer(modifier = Modifier.height(10.dp))
        ProfileDes(
            tittle = "Android App Developer",
            descriptions = "Learning and Teaching Android App Development is my passion"+
                    "Still Learning Development"+ "Dream\nis to get a job as an developer",
            url = "https://digitalboosterbd.com",
            translationTittle = "See Translation",
            followedBy = listOf(" Mossad", "Mishary al Afasi "),
            otherCount = 18
        )
    }
    
}

@Composable
fun RoundImage(
    painter: Painter, modifier: Modifier = Modifier, image: Painter
) {
    Image(painter = painter , contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .border(
                shape = CircleShape,
                color = Color.LightGray,
                width = 1.dp
            )
            .padding(3.dp)
            .clip(CircleShape)
    )
}

@Composable
fun StatSection(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceAround,
    modifier = modifier) {
        ProfileStats(numberText = "100", text = "Posts")
        ProfileStats(numberText = "100K", text = "Followers")
        ProfileStats(numberText = "20", text = "Following")
    }
    
}

@Composable
fun ProfileStats(numberText: String,
text: String,
modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(text = numberText,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text)
    }
    
}

@Composable
fun ProfileDes(
    tittle: String,
    descriptions: String,
    url : String,
    translationTittle: String,
    followedBy : List<String>,
    otherCount: Int
) {
    val letterspacing = 0.5.sp
    val lineheight = 20.sp
    
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp)) {
        Text(
            text = tittle,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterspacing,
            lineHeight = lineheight
        )
        Text(
            text = descriptions,
            letterSpacing = letterspacing,
            lineHeight = lineheight
        )
        Text(
            text = url,
            color = Color(0xFF436B91),
            letterSpacing = letterspacing,
            lineHeight = lineheight,
            modifier = Modifier.clickable {  }
        )
        Text(
            text = translationTittle,
            fontWeight = FontWeight.Bold,
            letterSpacing = letterspacing,
            lineHeight = lineheight
        )

        if (followedBy.isNotEmpty()){
            Text(
                text = buildAnnotatedString {
                    val boldStyle = SpanStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    append("Folllowed by")
                    followedBy.forEachIndexed { index, name ->
                        pushStyle(boldStyle)
                        append(name)
                        pop()
                        if (index < followedBy.size - 1){
                            append(", ")
                        }
                    }
                    if (otherCount > 2){
                        append("and")
                        pushStyle(boldStyle)
                        append("$otherCount others")

                    }
                }
            )
        }
    }
}

@Composable
fun ButtonSections(
    modifier: Modifier = Modifier
) {
    val minWidth = 90.dp
    val height = 30.dp
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier) {
        ActionButton(text ="Following",
            icon = Icons.Default.KeyboardArrowDown,
        modifier = Modifier
            .defaultMinSize(minWidth = minWidth)
            .height(height))
        ActionButton(text ="Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height))
        ActionButton(text ="Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height))
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier.size(height))
        
    }
    
}

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null,

) {
    Row(horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(5.dp)
            )
            .padding(6.dp)
    ) {

       if (text != null){
           Text(text = text,
           fontSize = 14.sp,
               fontWeight =  FontWeight.Bold)
       }
        if (icon != null){
           Icon(imageVector = icon, contentDescription = null,
           tint = Color.Black)
        }
    }

}

@Composable
fun HighlightSection(
    modifier: Modifier = Modifier,
    highlights: List<StoryHighlights>
) {
    LazyRow(modifier = modifier) {
        items(highlights.size) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(end = 15.dp)
            ) {
                RoundImage(
                    image = highlights[it].image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = highlights[it].text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}





































