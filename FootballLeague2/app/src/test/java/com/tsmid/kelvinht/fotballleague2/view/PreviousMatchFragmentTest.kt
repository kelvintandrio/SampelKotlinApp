package com.tsmid.kelvinht.fotballleague2.view

import com.tsmid.kelvinht.fotballleague2.retrofit.ApiInterface

import org.junit.Test
import org.mockito.Mockito

class PreviousMatchFragmentTest {

    @Test
    fun onViewCreated() {
        val apiRepository = Mockito.mock(ApiInterface::class.java)
        val url = apiRepository.url2+"eventspastleague.php?id=4346"
        apiRepository.doRequest(url)
        Mockito.verify(apiRepository).doRequest(url)
    }
}