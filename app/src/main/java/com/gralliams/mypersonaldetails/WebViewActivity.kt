package com.gralliams.mypersonaldetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.gralliams.mypersonaldetails.databinding.ActivityMainBinding
import com.gralliams.mypersonaldetails.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_view)

        var webView = binding.webview
        webView.settings.javaScriptEnabled = true

        webView.webViewClient = WebViewClient()

        webView.loadUrl("https://github.com/GreatGrant")
    }
}