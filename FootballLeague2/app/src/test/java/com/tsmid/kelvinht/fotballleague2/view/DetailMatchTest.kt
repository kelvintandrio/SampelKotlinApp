package com.tsmid.kelvinht.fotballleague2.view

import com.tsmid.kelvinht.fotballleague2.retrofit.ApiInterface
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mockito

class DetailMatchTest {

    @Test
    fun onCreate() {
        val apiRepository = Mockito.mock(ApiInterface::class.java)
        val url = apiRepository.url2+"lookupevent.php?id=23358"
        apiRepository.doRequest(url)
        Mockito.verify(apiRepository).doRequest(url)
    }
}