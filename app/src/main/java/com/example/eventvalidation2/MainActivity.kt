package com.example.eventvalidation2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.eventvalidation2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Gõ phím hiện Toast[cite: 42]
        binding.etName.doAfterTextChanged { text ->
            if (!text.isNullOrEmpty()) {
                Toast.makeText(this, "Họ tên: $text", Toast.LENGTH_SHORT).show()
            }
        }

        binding.etEmail.doAfterTextChanged { text ->
            if (!text.isNullOrEmpty()) {
                Toast.makeText(this, "Email: $text", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. RadioGroup chọn Giới tính[cite: 42]
        binding.rgGender.setOnCheckedChangeListener { _, checkedId ->
            val gender = when (checkedId) {
                R.id.rbMale -> "Nam"
                R.id.rbFemale -> "Nữ"
                else -> "Khác"
            }
            Toast.makeText(this, "Đã chọn giới tính: $gender", Toast.LENGTH_SHORT).show()
        }

        // 3. CheckBox Mạng xã hội[cite: 42]
        binding.cbFacebook.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "Đã chọn Facebook" else "Đã bỏ chọn Facebook"
            Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
        }

        binding.cbZalo.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "Đã chọn Zalo" else "Đã bỏ chọn Zalo"
            Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
        }

        binding.cbTiktok.setOnCheckedChangeListener { _, isChecked ->
            val status = if (isChecked) "Đã chọn TikTok" else "Đã bỏ chọn TikTok"
            Toast.makeText(this, status, Toast.LENGTH_SHORT).show()
        }

        // 4. Nút Đăng ký chuyển trang[cite: 42]
        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val phone = binding.etPhone.text.toString().trim()
            val msv = binding.etMsv.text.toString().trim()
            val clazz = binding.etClass.text.toString().trim()

            val selectedGenderId = binding.rgGender.checkedRadioButtonId
            val gender = when (selectedGenderId) {
                R.id.rbMale -> "Nam"
                R.id.rbFemale -> "Nữ"
                R.id.rbOther -> "Khác"
                else -> "Chưa chọn"
            }

            val socialList = mutableListOf<String>()
            if (binding.cbFacebook.isChecked) socialList.add("Facebook")
            if (binding.cbZalo.isChecked) socialList.add("Zalo")
            if (binding.cbTiktok.isChecked) socialList.add("TikTok")
            val socials = if (socialList.isNotEmpty()) socialList.joinToString(", ") else "Không chọn"

            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("EXTRA_NAME", name)
                putExtra("EXTRA_EMAIL", email)
                putExtra("EXTRA_PHONE", phone)
                putExtra("EXTRA_MSV", msv)
                putExtra("EXTRA_CLASS", clazz)
                putExtra("EXTRA_GENDER", gender)
                putExtra("EXTRA_SOCIALS", socials)
            }
            startActivity(intent)
        }
    }
}