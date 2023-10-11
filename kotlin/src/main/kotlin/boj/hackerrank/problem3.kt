//package boj.hackerrank
//
//fun main() {
//    val text = "abcd"
//    val prefixString = "eeab"
//    val suffixString = "aeee"
//    val result = calculateScore(text, prefixString, suffixString)
//    println(result)
//}
//
//fun calculateScore(text: String, prefixString: String, suffixString: String): String {
//    var prefixText = ""
//    for (i in 1 .. prefixString.length) {
//        val s = prefixString.substring(prefixString.length - i, prefixString.length)
//        if (s in text) {
//            prefixText = s // 한글자 확인 (사전순)
//        }
//    }
//
//    var suffixText = ""
//    for (i in 1 .. suffixString.length) {
//        val s = suffixString.substring(0, i)
//        if (s in text) {
//            suffixText = s // 한글자 확인 (사전순)
//        }
//    }
//
//    val start = text.indexOf(prefixText)
//    val end = text.indexOf(suffixText)
//
//    return if (start > end) {
//        listOf(prefixText, suffixText).sorted()[0]
//    } else {
//        text.substring(start, end + suffixText.length)
//    }
//}