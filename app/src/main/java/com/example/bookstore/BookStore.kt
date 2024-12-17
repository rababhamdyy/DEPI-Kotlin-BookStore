package com.example.bookstore


class BookStore{

    private val books = mutableListOf<Book>()

    fun addBook(){
        println("\nInput book's title : ")
        var title: String? = readlnOrNull()
        while (title.isNullOrEmpty()) {
            println("Please provide a valid title.")
            title = readlnOrNull()
        }

        println("Input book's author : ")
        var author: String? = readlnOrNull()
        while (author.isNullOrEmpty()) {
            println("Please provide a valid author.")
            author = readlnOrNull()
        }

        println("Input book's price : ")
        var price = readlnOrNull()?.toDoubleOrNull()
        while (price == null || price <= 0) {
            println("Please provide a valid price (greater than 0).")
            price = readlnOrNull()?.toDoubleOrNull()
        }

        val newBook = Book(title, author, price)
        books.add(newBook)
        println("You added a new book : $title ")
        println("\nCurrent books in store : \n${books.joinToString ("\n"){ " ${it.title}" }}")
    }

    fun removeBook(){
        println("\nInput book's title which you want to remove it : ")
        val titleRemoved = readlnOrNull()
        while (titleRemoved.isNullOrEmpty()) {
            println("Please provide a valid title to remove")
        }

        val removed = books.removeIf { it.title.equals(titleRemoved.toString(),ignoreCase = true) }
        if (removed) {
            println("Successfully removed the book : \"$titleRemoved\".")
        } else {
            println("No book found with the title : \"$titleRemoved\".")
        }
        println("\nCurrent books in store : \n${books.joinToString ("\n"){ " ${it.title}" }}")
    }

    fun displayAllBooks(){
        println("\nCurrent books in store with details:")
        if (books.isEmpty()) {
            println("No books in the store.")
        } else {
            books.forEach {
                println(it.bookDetails())
                if (it.title.startsWith('r',ignoreCase = true)){
                    println(it.discount(20.0))
                }
            }
        }
    }

    fun addExistingBook(book: Book) {
        books.add(book)
    }
}