package com.example.getir.data

import com.example.getir.R

object ProductData {

    fun getWater(): List<ProductModel> =
        listOf(
            ProductModel("Kuzeyden", R.drawable.water1,12,"300 ml","water"),
            ProductModel("Erikli", R.drawable.water2,44,"300 ml","water"),
            ProductModel("Saka", R.drawable.water3,56,"6 x 500 ml","water"),
            ProductModel("Damla",R.drawable.water4,13,"300 ml","water"),
            ProductModel("Pürse Cam",R.drawable.water5,23,"750 ml","water"),
            ProductModel("Erikli", R.drawable.water2,44,"300 ml","water"),
            ProductModel("Saka", R.drawable.water3,56,"6 x 500 ml","water"),
            ProductModel("Damla",R.drawable.water4,13,"300 ml","water"),
            ProductModel("Pürse Cam",R.drawable.water5,23,"750 ml","water"),
            ProductModel("Erikli", R.drawable.water2,44,"300 ml","water"),
            ProductModel("Saka", R.drawable.water3,56,"6 x 500 ml","water"),
            ProductModel("Damla",R.drawable.water4,13,"300 ml","water"),
            ProductModel("Pürse Cam",R.drawable.water5,23,"750 ml","water")

        )


    fun getGazli(): List<ProductModel> =
        listOf(
            ProductModel("Fanta", R.drawable.gazli1,39,"1 L","gazli"),
            ProductModel("Schweppes Mandalina", R.drawable.gazli2,22,"200 ml","gazli"),
            ProductModel("Sprite", R.drawable.gazli3,32,"250 ml","gazli"),
            ProductModel("Çamlıca Gazoz",R.drawable.gazli4,35,"1 L","gazli"),
            ProductModel("Fruko",R.drawable.gazli5,20,"1 L","gazli"),
            ProductModel("Sprite", R.drawable.gazli3,32,"250 ml","gazli"),
            ProductModel("Çamlıca Gazoz",R.drawable.gazli4,35,"1 L","gazli"),
            ProductModel("Fruko",R.drawable.gazli5,20,"1 L","gazli"),
            ProductModel("Sprite", R.drawable.gazli3,32,"250 ml","gazli"),
            ProductModel("Çamlıca Gazoz",R.drawable.gazli4,35,"1 L","gazli"),
            ProductModel("Fruko",R.drawable.gazli5,20,"1 L","gazli"),
            ProductModel("Sprite", R.drawable.gazli3,32,"250 ml","gazli"),
            ProductModel("Çamlıca Gazoz",R.drawable.gazli4,35,"1 L","gazli"),
            ProductModel("Fruko",R.drawable.gazli5,20,"1 L","gazli")

        )

    fun getAyran(): List<ProductModel> =
        listOf(
            ProductModel("Sütaş Ayran", R.drawable.ayran1,10,"200 ml","ayran"),
            ProductModel("Sütaş Ayran", R.drawable.ayran2,58,"2 L","ayran"),
            ProductModel("Eker Ayran", R.drawable.ayran3,40,"1 L","ayran"),
            ProductModel("Özerhisar Ayran",R.drawable.ayran4,23,"240 ml","ayran"),
            ProductModel("Sütaş Ayran Genç Şişe",R.drawable.ayran5,13,"250 ml","ayran")
        )
}