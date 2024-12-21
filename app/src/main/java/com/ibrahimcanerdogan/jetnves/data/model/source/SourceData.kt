package com.ibrahimcanerdogan.jetnves.data.model.source

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "source_data")
data class SourceData(
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "source_id")
    val id: String,
    @SerializedName("category")
    @ColumnInfo(name = "source_category")
    val category: String? = null,
    @SerializedName("country")
    @ColumnInfo(name = "source_country")
    val country: String? = null,
    @SerializedName("description")
    @ColumnInfo(name = "source_description")
    val description: String? = null,
    @SerializedName("language")
    @ColumnInfo(name = "source_language")
    val language: String? = null,
    @SerializedName("name")
    @ColumnInfo(name = "source_name")
    val name: String? = null,
    @SerializedName("url")
    @ColumnInfo(name = "source_url")
    val url: String? = null
)