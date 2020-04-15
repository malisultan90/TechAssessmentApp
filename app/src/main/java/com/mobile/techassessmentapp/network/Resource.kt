package com.mobile.techassessmentapp.network

import com.mobile.techassessmentapp.utils.constants.AppConstants


/**
 * Base Pojo class which will hold all states of the Responses.
 *
 * @param status [Status] values
 * @param data T  Any class object can be stored here
 * @param message message which needs to be stored
 * @param code Api code which needs to be stored
 * @param loading Loading status i.e. true or false
 */
class Resource<T> private constructor(
    val status: Status,
    val data: T?,
    val message: String? = "",
    val code: Int = 0,
    val loading: Boolean = false
) {

    companion object {
        /**
         * Set Resource as Success status
         * @param data [T] Any class object
         *
         * @return [Resource] instance which contains [Status.SUCCESS] and [T] object
         */
        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }

        /**
         * Set Resource as error status
         * @param msg Error message
         * @param data [T] Any class object
         * @param apiStatusCode Api Status code
         *
         * @return [Resource] instance which contains [Status.ERROR] and [T] object
         */
        fun <T> error(msg: String, data: T?, apiStatusCode: Int): Resource<T> {
            return Resource(Status.ERROR, data, msg, code = apiStatusCode)
        }

        /**
         * Set Resource as Loading status
         *
         * @return [Resource] instance which contains [Status.LOADING] and [T] object
         */
        fun <T> loading(loadingStatus: Boolean): Resource<T> {
            return Resource(Status.LOADING, null, loading = loadingStatus)
        }

        /**
         * Set Resource as Offline status
         * @param msg Error message
         * @param data T Any class object
         *
         * @return [Resource] instance which contains [Status.OFFLINE] and [T] object
         */

        fun <T> offline(msg: String, data: T?): Resource<T> {
            return Resource(Status.OFFLINE, data, msg)
        }

        /**
         * Set Resource as host error status
         * @param msg Error message
         * @param data T Any class object
         *
         * @return [Resource] instance which contains [Status.HOST_ERROR] and [T] object
         */

        fun <T> hostError(msg: String, data: T?): Resource<T> {
            return Resource(Status.HOST_ERROR, data, msg, code = AppConstants.API_UNKNOWN_REQUEST_ERROR_CODE)
        }
    }
}