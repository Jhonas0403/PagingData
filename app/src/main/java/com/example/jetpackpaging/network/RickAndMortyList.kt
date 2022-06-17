package com.example.jetpackpaging.network

data class RickAndMortyList(val info: Info, val results: List<CharacterData> )
data class CharacterData(val name: String?, val species: String?, val image: String?, val status:String?)
data class Info(val count: Int?, val pages: String?, val next: String?,val prev: String?)

data class UsersList(val results: List<Users>)
data class Users(val name:String?, val lastName:String?, val age: Int?, val gender:String?)

