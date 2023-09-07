package com.example.kasir_intan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPelanggan = findViewById<EditText>(R.id.editNamaPelanggan)
        val namaBarang = findViewById<EditText>(R.id.editNamaBarang)
        val jumlahBeli = findViewById<EditText>(R.id.editJumlahBeli)
        val HargaSatuan = findViewById<EditText>(R.id.editHarga)
        val UangBayar = findViewById<EditText>(R.id.editUang)
        val btnProses = findViewById<Button>(R.id.btnProses)

        val txthargaTotal = findViewById<TextView>(R.id.txthargaTotal)
        val txtUangKembali = findViewById<TextView>(R.id.txtUangKembali)
        val txtBonus = findViewById<TextView>(R.id.txtBonus)
        val txtKeterangan = findViewById<TextView>(R.id.txtKeterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnProses.setOnClickListener {
            var hargaBarang = Integer.parseInt(HargaSatuan.text.toString())
            var jmlBarang = Integer.parseInt(jumlahBeli.text.toString())
            var hargaTotal = hargaBarang * jmlBarang
            val UangBayar = Integer.parseInt(UangBayar.text.toString())
            val kembalian = UangBayar - hargaTotal

            txthargaTotal.text = "Harga Total Rp." + hargaTotal
            txtUangKembali.text = "Kembalian: " + if (kembalian >= 0) "Tidak Ada" else kembalian

            if (hargaTotal >= 200000) {
                txtBonus.text = "Bonus: Mouse"
            } else if (hargaTotal >= 400000) {
                txtBonus.text = "Bonus: Keyboard"
            } else if (hargaTotal >= 600000) {
                txtBonus.text = "Bonus: Hardisk"
            } else {
                txtBonus.text = "Bonus: Tidak ada"
            }

            if (kembalian == 0) {
                txtKeterangan.text = "Keterangan: Uang pas"
            } else if (kembalian > 0) {
                txtKeterangan.text = "Keterangan:Menunggu kembalian"
            } else {
                txtKeterangan.text = "Keterangan: Uang kurang " + abs(kembalian)
            }
        }

        btnReset.setOnClickListener {
            namaPelanggan.setText("")
            namaBarang.setText("")
            jumlahBeli.setText("")
            HargaSatuan.setText("")
            UangBayar.setText("")
            txthargaTotal.text = "Harga Total"
            txtUangKembali.text = "Kembalian"
            txtBonus.text = "Bonus"
            txtKeterangan.text = "Keterangan"

        }
    }
}