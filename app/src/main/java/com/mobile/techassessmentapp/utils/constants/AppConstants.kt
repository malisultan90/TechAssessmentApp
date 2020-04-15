package com.mobile.techassessmentapp.utils.constants

/**
 * Constant helper class which holds all the application common constants fields for further usages in our application.
 */
object AppConstants {

    const val BASE_URL = "https://api.nytimes.com/"

    const val API_KEY = "YzuNFJ6Fio7Tqtn6vAWfcWluXt1HUh5D"
    /**
     * Web connection timeout which will be used for our network layer
     */
    const val WEB_CONNECTION_TIMEOUT = 5L // in 5 sec

    /**
     * Web Connection read timeout which will be used for our network layer
     */
    const val WEB_READ_TIMEOUT = 60L // in minutes

    const val API_UNKNOWN_REQUEST_ERROR_CODE = -1

}