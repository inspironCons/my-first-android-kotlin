package com.example.retorifit2.data


data class UserResponse(
        var id:Int,
        var name:String,
        var username:String,
        var email:String,
        var address: Address,
        var phone:String,
        var website:String,
        var company: Compnany
)
data class Address(
        var street: String?,
        var suite: String?,
        var city: String?,
        var zipcode:String?,
        var geo: Geo
)

data class Geo(
        var lat: String,
        var lng: String
)

data class Compnany(
        var name:String,
        var catchPhrase:String,
        var bs:String
)


