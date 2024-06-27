package com.example.starbuckeas

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ClaimRewardActivity : AppCompatActivity() {
    private lateinit var rewardTextView: TextView
    private lateinit var claimRewardButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_claim_reward)

        rewardTextView = findViewById(R.id.reward_text_view)
        claimRewardButton = findViewById(R.id.claim_reward_button)

        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val rewardClaimed = sharedPreferences.getBoolean("rewardClaimed", false)

        if (rewardClaimed) {
            rewardTextView.text = "Reward sudah di-claim."
            claimRewardButton.isEnabled = false
        } else {
            rewardTextView.text = "Anda memiliki 1 reward minuman Rp10.000."
        }

        claimRewardButton.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putBoolean("rewardClaimed", true)
            editor.apply()

            Toast.makeText(this, "Reward berhasil di-claim!", Toast.LENGTH_SHORT).show()
            rewardTextView.text = "Reward sudah di-claim."
            claimRewardButton.isEnabled = false
        }
    }
}