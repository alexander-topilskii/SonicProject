package com.ato.sonic_repository

//
//object RangeAdapter : ColumnAdapter<ClosedFloatingPointRange<Double>, String> {
//    override fun decode(databaseValue: String): ClosedFloatingPointRange<Double> {
//        val parts = databaseValue.split("-")
//        if (parts.size != 2) {
//            return 0.0..0.0
//        }
//        val start: Double = parts[0].toDoubleOrNull() ?: 0.0
//        val end: Double = parts[1].toDoubleOrNull() ?: 0.0
//
//        return start..end
//    }
//
//    override fun encode(value: ClosedFloatingPointRange<Double>): String {
//        return "${value.start}-${value.endInclusive}"
//    }
//}

