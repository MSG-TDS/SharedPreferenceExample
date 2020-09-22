package com.example.sharedpreferenceexample

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // 저장된 설정값을 로그캣에 출력해본다
        val sharedPref = PreferenceManager.getDefaultSharedPreferences(this)

        if(sharedPref != null) {
            Log.i("Shared Pref", sharedPref.getString("signature", "").toString())
            Log.i("Shared Pref", sharedPref.getString("reply", "").toString())
            Log.i("Shared Pref", sharedPref.getBoolean("sync", false).toString())
        }
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)


        }
    }
}