package com.learning.models

import kotlinx.serialization.Serializable

@Serializable
data class Order(val number: String, val contents: List<OrderItem>)

@Serializable
data class OrderItem(val item: String, val amount: Int, val price: Double)

val orderStorage = listOf(
  Order(
    "2023-02-23-01", listOf(
      OrderItem("Ham Sandwich", 2, 5.50),
      OrderItem("Water", 1, 1.50),
      OrderItem("Beer", 3, 2.30),
      OrderItem("Cheesecake", 1, 3.75)
    )
  ),
  Order(
    "2023-02-23-02", listOf(
      OrderItem("Cheeseburger", 1, 8.50),
      OrderItem("Water", 2, 1.50),
      OrderItem("Coke", 2, 1.76),
      OrderItem("Ice Cream", 1, 2.35)
    )
  )
)
