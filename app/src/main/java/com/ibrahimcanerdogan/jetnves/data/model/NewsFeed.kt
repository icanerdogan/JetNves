package com.ibrahimcanerdogan.jetnves.data.model

import com.ibrahimcanerdogan.jetnves.data.model.headline.HeadlineNews

data class NewsFeed(
    val newsTopHeadlines: List<HeadlineNews>
) {
    // val allPosts: List<Post> = listOf(highlightedPost) + recommendedPosts + popularPosts + recentPosts
}
