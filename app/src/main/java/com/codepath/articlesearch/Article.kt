package com.codepath.articlesearch

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// @Keep is to keep the data from being erased even it is not used
// @ Serializable is used to
//  serialize data( converting data) used by app to a format can be used in a file.
//  Or deserialize data read external data and convert to runtime data.
@Keep
@Serializable
data class SearchNewsResponse(
    @SerialName("response")
    // response in BaseResponse instance datatype
    val response: BaseResponse?
)

@Keep
@Serializable
// Maps to the base response(List of Articles) under "response"
data class BaseResponse(
    @SerialName("docs")
    val docs: List<Article>?
)

@Keep
@Serializable
data class Article(
    @SerialName("abstract")
    val abstract : String?,

    @SerialName("headline")
    val headline : Headline?,

    @SerialName("byline")
    val byline : Byline?,

    @SerialName("multimedia")
    val multimedia : List<MultiMedia>?,
) : java.io.Serializable {
    val mediaImageUrl = "https://www.nytimes.com/${multimedia?.firstOrNull { it.url != null }?.url ?: ""}"
}


@Keep
@Serializable
data class Headline(
    @SerialName("main")
    val main : String
) :java.io.Serializable // implements the java.io.Serializable interface

@Keep
@Serializable
data class Byline(
    @SerialName("original")
    val original : String? = null
) : java.io.Serializable // implements the java.io.Serializable interface

@Keep
@Serializable
data class MultiMedia(
    @SerialName("url")
    val url: String?
) : java.io.Serializable // implements the java.io.Serializable interface


