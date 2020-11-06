package com.olabode.wilson.pytutor.ui.code


import android.app.AlertDialog
import android.app.Dialog
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
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.olabode.wilson.pytutor.R
import com.olabode.wilson.pytutor.databinding.FragmentCodeOutputBinding
import com.olabode.wilson.pytutor.views.Interpreter


/**
 *   Created by OLABODE WILSON on 10/23/20.
 */

class CodeOutputFragment : BottomSheetDialogFragment() {


    private lateinit var interpreter: Interpreter
    private var _binding: FragmentCodeOutputBinding? = null
    private val binding get() = _binding!!
    private val args: CodeOutputFragmentArgs by navArgs()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {

            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout = bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { l ->
                val behaviour = BottomSheetBehavior.from(l)
                setupFullHeight(l)
                behaviour.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }
        return dialog
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentCodeOutputBinding.inflate(inflater, container, false)
        interpreter = binding.interpreter
        val close = binding.toolbar
        close.setNavigationOnClickListener { dismiss() }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        interpreter.setCode()
        val code = args.code

        interpreter.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                val formattedCode = Regex.escapeReplacement(code)
                        .replace("\n", "\\n")
                        .replace("\t", "\\t")

                val func = "javascript:run(`$formattedCode`);"
                view?.evaluateJavascript(func, null)
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
                            if (et.text.toString().isNotEmpty()) {
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

    private fun setupFullHeight(bottomSheet: View) {
        val layoutParams = bottomSheet.layoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT
        bottomSheet.layoutParams = layoutParams
    }
}