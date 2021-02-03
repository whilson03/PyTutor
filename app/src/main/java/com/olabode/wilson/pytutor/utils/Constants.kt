package com.olabode.wilson.pytutor.utils

/**
 *   Created by OLABODE WILSON on 8/11/20.
 */
object Constants {
    const val APP_PREFERENCES = "com.olabode.wilson.pytutor.PREFERENCES"
    const val IS_FIRST_TIME_USER_KEY = "IS_FIRST_TIME_USER"
    const val MB_THRESHOLD = 1_097_152L
    const val DATABASE_NAME = "PYTUTOR_DATABASE"
    const val PASSWORD_LENGTH = 8
    const val REQUEST_CAMERA_PERMISSION = 9
    const val UPLOAD_IMAGE_DIALOG_TAG = "UPLOAD_IMAGE_DIALOG"
    const val REQUEST_IMAGE_FROM_GALLERY = 0
    const val APP_FILE_PROVIDER_NAME = "com.olabode.wilson.pytutor.fileprovider"
    const val REQUEST_IMAGE_CAPTURE = 100
    const val MARKET_BASE_URL = "http://play.google.com/store/apps/details?id="
    const val PRIVACY_POLICY_LINK = "https://whilson03.wixsite.com/wilsontech/post/privacy-policy"
    const val FEEDBACK_EMAIL = "whilson03@gmail.com"


    const val EXEERCISE_SUBMISSION_HINT = "Enter Question Here.\n" +
            "\n" +
            "N.B:\n" +
            "\t-  Questions should be clearly stated\n" +
            "\n" +
            "\t-  Questions should follow the format below\n" +
            "\n" +
            "\t-  Provide Sample inputs and expected outputs where neccesary\n" +
            "\n" +
            "<format>\n" +
            "\n" +
            "\t<Question-Body> \n" +
            "\t\tFind all the even numbers in a given list\n" +
            "\n" +
            "\t</Question-Body>\n" +
            "\n" +
            "\n" +
            "\t<Samples> \n" +
            "\t\tsample input1 : [2, 3, 6, 8] \n" +
            "\t\texpected output : 2, 6, 8\n" +
            "\n" +
            "\t</samples>\n" +
            "</format>"
}