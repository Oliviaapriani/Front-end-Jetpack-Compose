package com.example.pedulisehat.repository

import com.example.pedulisehat.model.Product

class ProductRepository {
    private val product = listOf(
        Product(1, "VIOSTIN", "Membantu mengatasi kaku dan nyeri sendi, Mencegah dan terapi Osteoarthritis (Pengapuran Sendi), Nutrisi pembentukan tulang rawan sendi, mengurangi dan menghambat peradangan sendi.", "https://res-5.cloudinary.com/dk0z4ums3/image/upload/c_scale,h_500,w_500/v1/production/pharmacy/products/1659929963_5fb376b341ab59059e86774f", 5.0, 20000.00),
        Product(2, "CDR", "Suplementasi Kalsium, Vitamin C, D, B6 agar tulang sehat pada orang dewasa serta membantu memenuhi kebutuhan kalsium pada ibu hamil dan menyusui. Juga diperlukan untuk masa pertumbuhan, masa penyembuhan, membantu memelihara tulang dan gigi yang sehat dan kuat, serta gangguan penyerapan makanan.", "https://res-3.cloudinary.com/dk0z4ums3/image/upload/c_scale,h_750,w_750/v1/production/pharmacy/products/1659929343_5fb37cbc41ab59059e8685d8", 5.0, 9000.00),
        Product(3, "Forneuro", "FORNEURO 6 KAPSUL adalah multivitamin 3 in 1 dengan paduan lengkap vitamin B1, B6, B12, E dan asam folat. untuk membantu meringankan gejala kram, kaku, kebas, kesemutan dan pegal pada otot. Mencegah dan mengobati defisiensi : vit B1, B6, B12, vit.E, Asam Folat & Anemia megaloblastik.", "https://res-5.cloudinary.com/dk0z4ums3/image/upload/c_scale,h_750,w_750/v1/production/pharmacy/products/1660368796_62a19098f15ee840f565fc97", 5.0, 149000.00),
        Product(4, "Vitamin D3+K2 IPI TUBE", "VITAMIN D3+K2 IPI TUBE merupakan vitamin yang digunakan untuk memenuhi kebutuhan vitamin D3 dan K2. Kombinasi vitamin D3 dengan vitamin K2 bekerja secara sinergis yaitu membantu memelihara kesehatan tulang.", "https://www.gogobli.com/produk/ipi/338461_ipi_d3.jpg", 5.0, 25000.00),
        Product(5, "Curcuma Plus", "Memenuhi kebutuhan vitamin di masa tumbuh kembang anak, membantu pertumbuhan tulang dan gigi yang kuat, perkembangan otak, serta membantu memperbaiki nafsu makan anak.", "https://www.gogobli.com/produk/curcuma_plus/569583_curcumaplus.jpg", 5.0, 25.000),
        Product(6, "Clast", "Untuk mengatasi mual dan muntah akibat pemberian obat anti kanker dan kemoterapi, serta mual dan muntah karena sebab lain. ", "https://encrypted-tbn0.gstatic.com/shopping?q=tbn:ANd9GcQ8xZWu0i8W_Ke6w58ZROBzFaukzlNFlPBL4ENqe7vFFdoHXaUSQdWZQ0xldj7LRvhUZ6q4lpdJ4FgTZO-YeoFOifA0FMb60w", 5.0, 30000.00),
        Product(7, "IMUNOGRAD KAPLET", "Imunogard adalah suplemen yang digunakan untuk memelihara imunitas tubuh dan mempercepat pemulihan ketika sakit.", "https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcTwEPUfVaD6tXY_d6i5SosTJpkqMSVVHh0lUN1lLhz2eADmNCSyQdntcgt4vNnUuyuca8rQpigIwXIiPAj_AIhx0-cY6SBE6PVt9CXlhi8ZCVowScZ6dmiN&usqp=CAE", 5.0, 60500.00),
        Product(8, "Neurobion Forte", "NEUROBION FORTE merupakan vitamin neurotropik dengan kandungan Vitamin B1, Vitamin B6, Vitamin B12, yang penting untuk kesehatan fungsi saraf.", "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSW5KU7sNbl5xqVyFevdpVU9uhJrXPO4YMpELHpeKbuAmk0yYz8ElNCxt8fMBg52NSLqI8v93DqRxvIH3LreT-5tmmSaGlXhaRShGJIzS87dhmLaeT_hlYp&usqp=CAE", 5.0, 52.000),
        Product(9, "Vitamin E IPI ", "Vitamin E adalah vitamin larut lemak yang penting untuk menjaga kesehatan kulit, mata, otak, dan organ reproduksi. Vitamin ini memiliki efek antioksidan sehingga mampu menangkal radikal bebas penyebab penyakit. Selain dari makanan, asupan vitamin E juga dapat diperoleh dari suplemen.", "https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcTBNhRllex7cK3Hv_hgIp5oycsJmwQ1KH8-U0Y0E-43o8STGsJ0WBqoTqKVSLq5a-dSPRfOLvoC5sWGKR8EVohhFmsXV6AI&usqp=CAY", 5.0, 9000.00),
        Product(10, "Antasida", "Antasida adalah obat untuk meredakan gejala akibat asam lambung berlebih, seperti nyeri ulu hati, kembung, mual, atau rasa panas di dada. Obat ini bisa digunakan dalam pengobatan sakit maag, penyakit asam lambung (GERD), tukak lambung, atau gastritis.", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnJMRkQ194Y4lKqjI-7wdUkys_s2l9TzX6LA&s", 5.0, 2000.00),
    )

    fun getProduct() : List<Product>{
        return product
    }
}