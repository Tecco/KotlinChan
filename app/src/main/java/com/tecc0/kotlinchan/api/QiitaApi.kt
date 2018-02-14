package com.tecc0.kotlinchan.api

import com.tecc0.kotlinchan.model.Schema
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by makoto_nishimoto on 2018/02/14.
 */

interface QiitaApi {

    @GET("/api/v2/schema")
    fun index(): Observable<Schema>
}