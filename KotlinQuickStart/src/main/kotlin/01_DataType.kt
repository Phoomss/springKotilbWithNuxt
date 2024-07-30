fun FDataType() {
//    Byte
//    var เป็นการประกาศตัวแปลที่สามารถเปลี่ยนแปลงได้
//    val เป็นการประกาศตัวแปรที่ไมาสามารถเปลี่ยนแปลงได้
    val kByte: Byte = 120 // -128 to 127
    val kShort: Short = 30_000 // -32,768 to 32,767
    val kInt: Int = 2_000_000 // -2,147,483,648 to 2,147,483,647
    val kLong: Long = 9000000000000000000 // -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807

    println("kByte: $kByte")
    println("kShort: $kShort")
    println("kInt: $kInt")
    println("kLong: $kLong")

    println("\n# Unsigned Integral Type\n---------------------")
    val kUByte: UByte = 255U // 0 to 255 u = ห้ามใส่ติดลบ -12
    val kUShort: UShort = 65_535U // 0 to 65535
    val kUInt: UInt = 4_294_967_295U // 0 to 4294967295
    val kULong: ULong = 18_446_744_073_709_551_615UL // 0 to 18446744073709551615

    println("kUByte=$kUByte")
    println("kUShort=$kUShort")
    println("kUInt=$kUInt")
    println("kULong=$kULong")

    println("\n# Floating Point Type\n---------------------")
    val kFloat: Float = 3.4028235E38F // 1.4E-45 to 3.4028235E38
    val kDouble: Double = 1.7976931348623157E308 // 4.9E-324 to 1.7976931348623157E308
    println("kFloat=$kFloat")
    println("kDouble=$kDouble")

    println("\n# Boolean Type\n---------------------")
    val kBoolean1: Boolean = true
    val kBoolean2: Boolean = false
    println("kBoolean1=$kBoolean1")
    println("kBoolean2=$kBoolean2")

    println("\n# String Type\n---------------------")
    val kChar: Char = 'S'
    val kString: String = "Samit Koyom"
    println("kChar=$kChar")
    println("kString=$kString")

    println("\n# Any Type\n---------------------")
    val kAny1: Any = 20
    val kAny2: Any = 100.50
    val kAny3: Any = true
    val kAny4: Any = "John"
    println("kAny1=$kAny1")
    println("kAny2=$kAny2")
    println("kAny3=$kAny3")
    println("kAny4=$kAny4")
}