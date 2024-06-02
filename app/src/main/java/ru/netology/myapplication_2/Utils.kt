package ru.netology.myapplication_2

object Utils {
    fun formatNumber(count: Int): String {
        return when {
            count < 1000 -> count.toString() // Если количество меньше 1000, просто отобразить его
            count < 1100 -> "${count / 1000}K" // Если количество от 1000 до 1099, отобразить в формате К
            count < 10000 -> "${count / 1000}.${count % 1000 / 100}K" // Если количество от 1100 до 9999, отобразить с одной десятичной частью
            count < 1000000 -> "${count / 1000}K" // Если количество от 10000 до 999999, отобразить в формате К без десятичной части
            else -> {
                val millions = count / 1000000
                val remainder = count % 1000000
                if (remainder >= 100000) {
                    val tenths = remainder / 100000
                    "${millions}.${tenths}M" // Отображаем с одной десятичной частью, если десятая часть не равна нулю
                } else {
                    "${millions}M" // Отображаем без десятичной части, если остаток меньше 100000
                }
                }
        }
    }
}