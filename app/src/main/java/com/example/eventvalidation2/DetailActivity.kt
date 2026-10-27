package com.example.eventvalidation2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.eventvalidation2.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận dữ liệu qua Intent[cite: 42]
        val name = intent.getStringExtra("EXTRA_NAME") ?: ""
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: ""
        val phone = intent.getStringExtra("EXTRA_PHONE") ?: ""
        val msv = intent.getStringExtra("EXTRA_MSV") ?: ""
        val clazz = intent.getStringExtra("EXTRA_CLASS") ?: ""
        val gender = intent.getStringExtra("EXTRA_GENDER") ?: ""
        val socials = intent.getStringExtra("EXTRA_SOCIALS") ?: ""

        // Hiển thị thông tin
        val displayInfo = """
            - Họ và tên: $name
            - Email: $email
            - Số điện thoại: $phone
            - Mã sinh viên: $msv
            - Lớp: $clazz
            - Giới tính: $gender
            - Mạng xã hội: $socials
        """.trimIndent()

        binding.tvDetailResult.text = displayInfo

        // Nút quay lại
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}