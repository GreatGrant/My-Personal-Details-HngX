package com.gralliams.mypersonaldetails

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
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
        webView.settings.javaScriptEnabled = true

        // Set a WebViewClient to handle page loading within the WebView
        webView.webViewClient = MyWebViewClient()

        if (isConnectedToInternet(this)) {
            // Load the URL when there's an internet connection
            webView.loadUrl(getString(R.string.my_git_link))
        } else {
            // Display an error message when there's no internet connection
            webView.loadData(
       getString(R.string.error_message).trimIndent(),
                "text/html",
                "UTF-8"
            )
        }
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

    private fun isConnectedToInternet(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)

        // Check if the device has a network connection and it's capable of internet access
        return networkCapabilities != null &&
                networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

}
