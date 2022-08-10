package edu.uchicago.skgrogg.movies.repository

import edu.uchicago.skgrogg.movies.common.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject


class EmailRepository @Inject constructor() {

    suspend fun Emailer(subject: String, body: String, email: String) {
        return withContext(Dispatchers.IO) {
            var client = OkHttpClient().newBuilder()
            .build()
            var mediaType: MediaType = "application/json".toMediaTypeOrNull()!!
            var body: RequestBody =
            "{\"subject\":\"$subject\", \"body\": \"$body\", \"email\": \"$email\"}"
            .toRequestBody(mediaType)
            var request: Request = Request.Builder()
                .url(Constants.emailURL)
                .method("POST", body)
                .addHeader("X-Amz-Content-Sha256", "beaead3198f7da1e70d03ab969765e0821b24fc913697e929e726aeaebf0eba3")
                .addHeader("X-Amz-Date", "20220810T185825Z")
                .addHeader("Authorization", "AWS4-HMAC-SHA256 Credential=AKIAW272URXZ63T236NQ/20220810/us-east-1/execute-api/aws4_request, SignedHeaders=host;x-amz-content-sha256;x-amz-date, Signature=6cdc8a2b05a2b760e5794dca192682e51d598f7456eab6a62fc070c2cc974f38")
                .addHeader("Content-Type", "application/json")
                .build()
            var response: okhttp3.Response = client.newCall(request).execute()
            println(response)
           }
        }
}