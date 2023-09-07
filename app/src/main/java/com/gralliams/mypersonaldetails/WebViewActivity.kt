package com.gralliams.mypersonaldetails

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.gralliams.mypersonaldetails.databinding.ActivityMainBinding
import com.gralliams.mypersonaldetails.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web_view)

        val webView = binding.webview
        webView.settings.apply{
            javaScriptEnabled = true
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }


        // Set a WebViewClient to handle page loading within the WebView
        webView.webViewClient = MyWebViewClient()

            webView.loadUrl(getString(R.string.my_git_link))

    }

    private inner class MyWebViewClient : WebViewClient() {
        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: android.webkit.WebResourceError?
        ) {
            super.onReceivedError(view, request, error)

            val htmlErrorMessage = getString(R.string.error_message).trimIndent()

            view?.loadData(htmlErrorMessage, "text/html", "UTF-8")
        }
    }


}
