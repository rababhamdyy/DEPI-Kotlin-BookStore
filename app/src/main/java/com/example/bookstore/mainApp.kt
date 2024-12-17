package com.example.bookstore

fun main(){
    /* Assignment: Simple OOP App
    ● Create a class Book with properties for title, author, and price.
    ● Implement methods to display book details and to apply a discount to the price.
    ● Create a class BookStore that holds a list of books and has methods to add a book, remove a book, and display all books.
    ● Use these classes to create a simple bookstore application. */
    val book1 = Book(title = "Harry Potter", author = "J.K. Rowling", price = 50.0)
    println(book1.bookDetails())
    println(book1.discount(discount = 15.0))

    val collectionOfBooks = BookStore()
    collectionOfBooks.addExistingBook(book1)

    println("\nHow many books would you like to add ?")
    val numberOfBooks = readlnOrNull()?.toIntOrNull() ?: 0
    repeat(numberOfBooks) {
        collectionOfBooks.addBook()
    }

    collectionOfBooks.removeBook()
    collectionOfBooks.displayAllBooks()
}