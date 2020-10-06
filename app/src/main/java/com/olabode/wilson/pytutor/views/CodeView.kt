package com.olabode.wilson.pytutor.views

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

/**
 *   Created by OLABODE WILSON on 9/30/20.
 */

class CodeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {
    companion object {
        private const val ANDROID_ASSETS_PATH = "file:///android_asset/"
    }

    // Our exposed function to show highlighted syntax
    fun setCode(
        formattedSourceCode: String,
        language: String,
        showLineNumbers: Boolean = true
    ) {
        settings.javaScriptEnabled = true
        loadDataWithBaseURL(
            ANDROID_ASSETS_PATH /* baseUrl */,
            prismJsHtmlContent(
                formattedSourceCode,
                language,
                showLineNumbers
            ) /* html-data */,
            "text/html" /* mimeType */,
            "utf-8" /* encoding */,
            "" /* failUrl */
        )
    }

    fun prismJsHtmlContent(
        formattedSourceCode: String,
        language: String,
        showLineNumbers: Boolean = true
    ): String {
        return """<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="www/prism.css" rel="stylesheet"/>
    <script src="www/prism.js"></script>
</head>
<body>
<pre class="${if (showLineNumbers) "line-numbers" else ""}">
<code class="language-${language}">${formattedSourceCode}</code>
</pre>
</body>
</html>
"""
    }
}

