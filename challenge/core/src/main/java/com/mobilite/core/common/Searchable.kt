package com.mobilite.core.common

interface Searchable {
    /** This method will allow to specify a search string to compare against
    your search this can be anything depending on your use case.
     */
    fun getSearchCriteria(): String
}