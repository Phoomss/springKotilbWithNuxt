fun KCondition() {
    var balance = 30_000
    var withdraw = 2_500

    if (balance < withdraw) {
        print("ยอดเงินคงเหลือไม่เพียงพอ")
    } else if (withdraw > 20_000) {
        print("ถอนได้ไม่เกิน 20000")
    } else if (withdraw % 100 != 0) {
        print("ต้องเป็นจำนวนเต็มร้อยเท่านั้น")
    } else {
        balance -= withdraw
        print("ยอดเงินคงเหลือ: $balance บาท\n")
    }

    println("-----------------")

    val remain = 1
    val r = if (remain > 0) "มีสินค้า" else "สินค้าหมด"
    println(r)

    println("---------------------")

    println("-----------------")

    val extname = ".kt"
    when (extname) {
        ".kt" -> println("Kotlin File")
        ".java" -> println("Java File")
        else -> println("Unknown")
    }

    println("-----------------")

    val country = "Mexico"
    when (country) {
        "UK", "USA", "AUS", "CANADA", "NZ" -> println("English")
        "Spain", "Mexico", "Cuba", "Argentina" -> println("Spanish")
        "China", "Taiwan", "Hong Kong" -> println("Chinese")
    }

    println("-----------------")

    val date = 1
    val month = 10
    when {
        date == 1 && month == 1 -> println("วันขึ้นปีใหม่")
        date == 14 && month == 2 -> println("วันวาเลนไทน์")
        date >= 13 && date <= 15 && month == 4 -> println("วันสงกรานต์")
        date == 1 || date == 16 -> println("วันนี้รวย")
    }

    println("-----------------")

    val device = "Oppo"
    val os = when (device) {
        "Oppo", "Vivo", "Samsung", "Sony" -> "Android"
        "iPhone" -> "iOS"
        "iPad" -> "iPadOS"
        else -> "Unknown"
    }
    print(os) //Android
}