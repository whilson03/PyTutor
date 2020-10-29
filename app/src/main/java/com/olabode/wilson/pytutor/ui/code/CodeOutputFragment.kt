package com.olabode.wilson.pytutor.ui.code


import android.app.AlertDialog
import android.app.Dialog
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.webkit.JsPromptResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.views.Interpreter


/**
 *   Created by OLABODE WILSON on 10/23/20.
 */
class CodeOutputFragment(val code: String) : BottomSheetDialogFragment() {

    private lateinit var interpreter: Interpreter
    private val behavior: BottomSheetBehavior<*>? = null
    private lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        root = inflater.inflate(R.layout.code_output_sheet, container, false)
        interpreter = root.findViewById(R.id.interpreter)

        val close = root.findViewById<android.widget.Toolbar>(R.id.toolbar)
        close.setNavigationOnClickListener { dismiss() }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        interpreter.setCode()

        interpreter.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                    val code = code.replace("\n", "\\n")
                            .replace("\t", "\\t")

                    val func = "javascript:run(\"$code\");"
                    view?.evaluateJavascript(func, null)

                } else {
                    val code = code.replace("\n", "\\n")
                            .replace("\t", "\\t")
                    val func = "javascript:run(`$code`);"
                    view?.evaluateJavascript(func, null)
                }

            }
        }

        interpreter.webChromeClient = object : WebChromeClient() {

            override fun onJsPrompt(view: WebView?, url: String?, message: String?, defaultValue: String?, result: JsPromptResult?): Boolean {

                val builder: AlertDialog.Builder = AlertDialog.Builder(view!!.context)

                builder.setTitle(getString(R.string.enter_input)).setMessage(message)

                val et = EditText(view.context)
                et.setSingleLine()
                et.setText(defaultValue)
                builder.setView(et)
                        .setPositiveButton(getString(R.string.ok)) { _, _ ->
                            if (!et.text.toString().isNullOrEmpty()) {
                                result!!.confirm(et.text.toString())
                            } else {
                                result!!.cancel()
                            }

                        }
                        .setNeutralButton(getString(R.string.cancel)) { _, _ -> result!!.cancel() }

                builder.setCancelable(false)
                val dialog = builder.create()
                dialog.show()
                return true
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout =
                    bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { l ->
                val behaviour = BottomSheetBehavior.from(l)
                setupFullHeight(l)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }

    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }
}