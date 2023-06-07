//package boj.hackerrank
//
//fun main() {
//    var prevHead = listHead
//    while (prevHead != null) {
//        var head = prevHead
//        while (true) {
//            if (head.next == null) {
//                prevHead.next = null
//                break
//            }
//
//            if (head.next.data % 2 != 0) {
//                prevHead.next = head
//                break
//            }
//            head = head.next
//        }
//        prevHead = prevHead.next
//    }
//}
//
///*
//
//LinkedList 문제
//
// */