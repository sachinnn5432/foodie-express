package com.example.foodordering

object DataProvider {
    val restaurants = listOf(
        Restaurant(1, "The Gourmet Kitchen", "https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?w=800", 4.8f, "25-30 min", "Italian, Continental"),
        Restaurant(2, "Burger Bistro", "https://images.unsplash.com/photo-1571091718767-18b5b1457add?w=800", 4.5f, "15-20 min", "American, Fast Food"),
        Restaurant(3, "Sushi Zen", "https://images.unsplash.com/photo-1579871494447-9811cf80d66c?w=800", 4.9f, "35-40 min", "Japanese, Asian"),
        Restaurant(4, "Taco Fiesta", "https://images.unsplash.com/photo-1565299585323-38d6b0865b47?w=800", 4.2f, "20-25 min", "Mexican, Street Food"),
        Restaurant(5, "Indian Tadka", "https://images.unsplash.com/photo-1585937421612-70a008356fbe?w=800", 4.7f, "30-35 min", "North Indian, Mughlai")
    )

    val foodItems = listOf(
        FoodItem(1, 1, "Paneer Butter Masala", 280.0, "https://images.unsplash.com/photo-1631452180519-c014fe946bc7?w=800", 4.7f, "Creamy tomato based gravy with soft paneer cubes."),
        FoodItem(2, 1, "Garlic Naan (2 pcs)", 90.0, "https://images.unsplash.com/photo-1601050633729-1954844b0576?w=800", 4.5f, "Tandoori baked flatbread with a hint of garlic and butter."),
        FoodItem(3, 2, "Ultimate Veggie Burger", 180.0, "https://images.unsplash.com/photo-1550547660-d9450f859349?w=800", 4.6f, "Crispy veggie patty with fresh lettuce, tomato, and cheese."),
        FoodItem(4, 2, "Cheesy Peri Peri Fries", 120.0, "https://images.unsplash.com/photo-1573015613731-ffdf1ef3f57f?w=800", 4.4f, "Classic fries seasoned with spicy peri-peri and melted cheese."),
        FoodItem(5, 3, "Dragon Sushi Roll", 450.0, "https://images.unsplash.com/photo-1617196034183-421b4917c92d?w=800", 4.9f, "Premium sushi roll with tempura prawn, avocado, and spicy mayo."),
        FoodItem(6, 4, "Spicy Paneer Tacos", 220.0, "https://images.unsplash.com/photo-1551504734-5ee1c4a1479b?w=800", 4.3f, "Soft tortillas filled with spicy paneer and fresh salsa."),
        FoodItem(7, 5, "Hyderabadi Chicken Biryani", 350.0, "https://images.unsplash.com/photo-1563379091339-03b17af4a4f9?w=800", 4.8f, "Aromatic basmati rice cooked with succulent chicken and spices."),
        FoodItem(8, 5, "Dal Makhani Special", 240.0, "https://images.unsplash.com/photo-1546833999-b9f581a1996d?w=800", 4.7f, "Slow-cooked black lentils with butter and cream.")
    )

    val cartItems = mutableListOf<CartItem>()
}
