package com.joel.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.joel.domain.model.Comic
import com.joel.presentation.utils.trimTitle
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun ComicScreen(
    comicViewModel: ComicViewModel
){

    val state = comicViewModel.state.value
    val allNewComics = comicViewModel.state.value.allNewComics.collectAsLazyPagingItems()

    ComicContentLayout(
        error = state.error,
        pagingItems = allNewComics,
        onClick = {
            comicViewModel.onEvents(ComicEvents.OnComicClick(it))
        },
        onRetry = {
            comicViewModel.fetchNewComics()
        }
    )

}

@Composable
fun ComicContentLayout(
    error : String,
    pagingItems: LazyPagingItems<Comic>,
    onClick: (Comic) -> Unit,
    onRetry : () -> Unit,

){

    if (error.isNotEmpty()){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {
            ErrorConnection(onRetry = { onRetry() }, message = error)
        }
    } else {
        ScrollableIssueItems(
            pagingItems = pagingItems,
            onClick = onClick
        )
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            modifier = Modifier
//                .fillMaxSize(),
//            contentPadding = PaddingValues(6.dp)
//        ) {
//            items(pagingItems.itemCount){ index ->
//                pagingItems[index]?.let { issues ->
//                    IssueItem(
//                        landscape = landscape,
//                        modifier = Modifier
//                            .width(if (landscape) 215.dp else 130.dp)
//                            .height(if (landscape) 161.25.dp else 195.dp),
//                        onClick = {
//                            onClick(issues)
//                        },
//                        issues = issues
//                    )
//                }
//            }
//        }
    }
//    LazyVerticalGrid(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentPadding = PaddingValues(8.dp),
//        columns = GridCells.Fixed(2)
//    ) {
//        item {
//            if (error.isNotEmpty()){
//                ErrorConnection(onRetry = { onRetry() }, message = error)
//            } else {
//                ScrollableIssueItems(
//                    pagingItems = pagingItems,
//                    onClick = onClick,
//                    landscape = false
//                )
//            }
//        }
//    }
}

@Composable
fun ScrollableIssueItems(
    pagingItems: LazyPagingItems<Comic>,
    onClick: (Comic) -> Unit,
    landscape: Boolean = true
){


    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        columns = GridCells.Fixed(2)
    ) {
        item {

        }
        items(pagingItems.itemCount){ index ->
            pagingItems[index]?.let { issues ->
                IssueItem(
                    landscape = landscape,
                    modifier = Modifier
                        .width(if (landscape) 215.dp else 130.dp)
                        .height(if (landscape) 161.25.dp else 195.dp),
                    onClick = {
                        onClick(issues)
                    },
                    issues = issues
                )
            }
        }
        pagingItems.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                loadState.refresh is LoadState.Error -> {
                    val error = pagingItems.loadState.refresh as LoadState.Error
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                        ) {
                            ErrorConnection(
                                message = error.error.localizedMessage!!,
                                onRetry = {
                                    retry()
                                }
                            )
                        }
                    }
                }

                loadState.append is LoadState.Loading -> {
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }

                loadState.append is LoadState.Error -> {
                    val error = pagingItems.loadState.append as LoadState.Error
                    item {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            ErrorConnection(
                                message = error.error.localizedMessage!!,
                                onRetry = {
                                    retry()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun IssueItem(
    modifier: Modifier,
    landscape: Boolean,
    issues: Comic,
    onClick : (Comic) -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .padding(all = 4.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                onClick(issues)
            },
        horizontalAlignment = Alignment.Start
    ) {
        CoilImage(
            imageModel = issues.image,
            shimmerParams = ShimmerParams(
                baseColor = Color(0xFF180E36),
                highlightColor = Color(0XFF423460),
                durationMillis = 500,
                dropOff = 0.65F,
                tilt = 20F
            ),
            failure = {

            },
            contentScale = ContentScale.Crop,
            circularReveal = CircularReveal(duration = 1000),
            modifier = modifier.clip(RoundedCornerShape(8.dp)),
            contentDescription = "Movie item"
        )

        AnimatedVisibility(visible = landscape) {
            Text(
//                text = trimTitle(issues.title),
                text = issues.title,
                modifier = Modifier
                    .padding(start = 4.dp, top = 4.dp),
                maxLines = 1,
                color = Color.White,
                overflow = TextOverflow.Ellipsis,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun ErrorConnection(
    onRetry : () -> Unit,
    message : String
){

    Card(
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 5.dp
        ),
        border = BorderStroke(width = 0.5.dp, color = Color.Red),
        modifier = Modifier
            .padding(horizontal = 50.dp)
            .clickable {
                onRetry()
            },
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding( horizontal = 8.dp, vertical = 15.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_wifi_off_24),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp),
                tint = Color.Red
            )
            Text(
                text = stringResource(id = R.string.unknown_error),
                fontSize = 18.sp,
                color = Color.Red,
            )
            Text(
                text = message,
                fontSize = 12.sp,
                color = Color.Red,
            )
        }
    }
}

