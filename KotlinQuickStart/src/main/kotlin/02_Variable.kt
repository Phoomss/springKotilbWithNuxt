fun FVariable() {
    var number: Int = 10
    number = 20

    val result: Double = 10.50

    val str: String = "Hi Kotlin"

    println("number = $number")
    println("Result = $result")
    println("String = $str")

    val pi: Float = 3.141f
    val pricePerUnit: Short = 1000
    val lat: Double
    val lon: Double
    lat = 100.12345
    lon = 80.67890
    // lon = 80.00 // Error
    println(pi)
    println(pricePerUnit)
    println(lat)
    println(lon)

//    การสร้างตัวแแปลเก็บค่า null
//    var name:String = null //=== error
//    val age:Int? = null

    val temperature = 20
    val isHot = if(temperature>40) true else false
    println(isHot)
}