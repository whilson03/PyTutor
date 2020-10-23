package com.olabode.wilson.pytutor.views

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

/**
 *   Created by OLABODE WILSON on 10/22/20.
 */
class Interpreter @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {
    companion object {
        private const val ANDROID_ASSETS_PATH = "file:///android_asset/"
    }


    // Our exposed function to show highlighted syntax
    fun setCode() {
        settings.javaScriptEnabled = true
        loadDataWithBaseURL(
                ANDROID_ASSETS_PATH /* baseUrl */,
                setUpPage() /* html-data */,
                "text/html" /* mimeType */,
                "utf-8" /* encoding */,
                "" /* failUrl */
        )
    }

    private fun setUpPage(): String {
        return """ 
            <html> 
<head> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="www/jquery-3.5.1.min.js" type="text/javascript"></script> 
<script src="www/skulpt.min.js" type="text/javascript"></script> 
<script src="www/skulpt-stdlib.js" type="text/javascript"></script> 

</head> 
<body> 

<script type="text/javascript"> 
// output functions are configurable.  This one just appends some text
// to a pre element.
function outf(text) { 
    var mypre = document.getElementById("output"); 
    mypre.innerHTML = mypre.innerHTML + text; 
} 
function builtinRead(x) {
    if (Sk.builtinFiles === undefined || Sk.builtinFiles["files"][x] === undefined)
            throw "File not found: '" + x + "'";
    return Sk.builtinFiles["files"][x];
}

// Here's everything you need to run a python program in skulpt
// grab the code from your textarea
// get a reference to your pre element for output
// configure the output function
// call Sk.importMainWithBody
function run(code) { 
   var prog = code;
   var mypre = document.getElementById("output"); 
   mypre.innerHTML = ''; 
   Sk.pre = "output";
   Sk.configure({output:outf, read:builtinRead}); 
   (Sk.TurtleGraphics || (Sk.TurtleGraphics = {})).target = 'mycanvas';
   var myPromise = Sk.misceval.asyncToPromise(function() {
       return Sk.importMainWithBody("<stdin>", false, prog, true);
   });
   myPromise.then(function(mod) {
       console.log('success');
   },
       function(err) {
       console.log(err.toString());
       mypre.innerHTML = err.toString();
   });
} 
</script> 

</form> 

<pre id="output" ></pre> 
<!-- If you want turtle graphics include a canvas -->
<div id="mycanvas"></div> 

</body> 


</html> 
            
            
        """
    }
}