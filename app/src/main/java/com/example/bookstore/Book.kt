package com.example.bookstore


class Book (val title :String, val author :String, val price :Double ){

    fun bookDetails() :String{
        return "\nBook of: $title series by $author, price = $price bound"
    }

    fun  discount(discount :Double = 20.0) :String{
        val discountPrice = price * (discount/100)
        return "Book's price after discount $discount % = $discountPrice bound"
    }
}