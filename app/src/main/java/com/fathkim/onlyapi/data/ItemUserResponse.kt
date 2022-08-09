package com.fathkim.onlyapi.data

import com.google.gson.annotations.SerializedName

data class ItemResponse(

	@field:SerializedName("ItemUserResponse")
	val itemUserResponse: List<ItemUserResponse?>? = null
)