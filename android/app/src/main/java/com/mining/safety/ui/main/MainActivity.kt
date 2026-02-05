package com.mining.safety.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mining.safety.R
import com.mining.safety.databinding.ActivityMainBinding
import com.mining.safety.ui.login.LoginActivity
import com.mining.safety.ui.user.UserFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNavigation()

        // 默认显示用户管理界面
        replaceFragment(UserFragment())
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_user -> {
                    replaceFragment(UserFragment())
                    true
                }
                R.id.navigation_material -> {
                    replaceFragment(com.mining.safety.ui.material.MaterialFragment())
                    true
                }
                R.id.navigation_course -> {
                    replaceFragment(com.mining.safety.ui.course.CourseFragment())
                    true
                }
                R.id.navigation_exam -> {
                    replaceFragment(com.mining.safety.ui.exam.ExamFragment())
                    true
                }
                R.id.navigation_topic -> {
                    replaceFragment(com.mining.safety.ui.topic.TopicFragment())
                    true
                }
                R.id.navigation_classroom -> {
                    replaceFragment(com.mining.safety.ui.classroom.ClassroomFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                showLogoutDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setTitle("退出登录")
            .setMessage("确定要退出登录吗？")
            .setPositiveButton("确定") { _, _ ->
                logout()
            }
            .setNegativeButton("取消", null)
            .show()
    }

    private fun logout() {
        // 清除登录信息
        val sharedPreferences = getSharedPreferences("app_prefs", MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()

        // 跳转到登录界面
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}
