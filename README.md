# Animated Splash Screen App 📱✨

Proyek ini adalah aplikasi Android berbasis **Kotlin** yang mendemonstrasikan pembuatan **Custom Splash Screen dengan Logo Beranimasi**. Aplikasi ini tidak menggunakan library core-splashscreen bawaan Google, melainkan menggunakan pendekatan kustom yang menggabungkan objek **`Animatable`** untuk visualisasi logo dan **Kotlin Coroutines (`lifecycleScope`)** untuk manajemen transisi halaman yang aman dari *memory leak*.

## 🚀 Fitur Utama & Cara Kerja
* **Vector Vector/Drawable Animation**: Memanfaatkan *casting* `logo.drawable as? Animatable` untuk memicu jalannya animasi kustom pada logo (`ImageView`) tepat saat aplikasi dibuka.
* **Coroutines Lifecycle-Aware Delay**: Menggunakan komponen `lifecycleScope.launch` dengan `delay(2200)` (2.2 detik) untuk menahan layar pembuka selama animasi logo berlangsung, lalu otomatis berpindah ke halaman `HomeActivity`.
* **Safe Transition**: Memanggil fungsi `finish()` setelah `startActivity()` agar pengguna tidak bisa kembali ke halaman Splash Screen saat menekan tombol *Back* (kembali) di HP mereka.

## 🛠️ Arsitektur & Dependencies
* **Bahasa Utama**: Kotlin
* **Komponen Android**: `AppCompatActivity`, `Intent`, `Animatable`
* **Dependencies Utama**:
  * `androidx.lifecycle:lifecycle-runtime-ktx` (Untuk menangani `lifecycleScope` dan Coroutines secara aman sesuai siklus hidup Activity)

## 💻 Alur Kode Utama (`SplashActivity.kt`)
Aplikasi ini berjalan dengan logika utama sebagai berikut:
```kotlin
// Menjalankan animasi kustom pada drawable logo
val logo = findViewById<ImageView>(R.id.imgLogo)
(logo.drawable as? Animatable)?.start()

// Menunggu animasi selesai (2.2 detik), lalu pindah ke HomeActivity
lifecycleScope.launch {
    delay(2200)
    startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
    finish()
}
```

## ⚙️ Cara Menjalankan Proyek
1. **Clone repositori ini**:
   ```bash
   git clone https://github.com
   ```
2. Buka folder proyek menggunakan **Android Studio**.
3. Pastikan proses **Gradle Sync** selesai dengan sukses.
4. Hubungkan emulator atau HP Android fisik Anda, lalu klik tombol **Run** (ikon play hijau).
