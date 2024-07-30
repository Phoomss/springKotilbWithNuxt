fun kNullSafety() {
//     var a: Int = null
//     var b: String = "Hello"
//     b = null

    var books: Int? = null
    // วิธีที่ 1 ใช้ if ตรวจสอบ
    if(books != null){
        books = books.dec() // ลบออก 1
        println(books) // 4
    }

    // วิธีที่ 2 ใช้ Call Safety (?)
    books = books?.dec() // ลบออก 1
    println(books) // 3

    println("-------------------------")
    val a: Int? = null
    val x = a ?: 0 //หาก a เป็น null ตัวแปร x จะเท่ากับ 0 แต่หากไม่เป็น null ตัวแปร x = a
    println(x) // 10
    /* เทียบเท่ากับ
      val x = if (a != null) a else 0
    */
    val b: Double? = 1.23
    val y = b ?: -1.0
    println(y) // 1.23

    println("-------------------------")

    val i: Int? = 20
    val j: Int? = 30
    val c: Int = i!! + j!!
    println(c)

    val str: String? = "123"
    val m: Int = str!!.toInt()
    print(m)

}