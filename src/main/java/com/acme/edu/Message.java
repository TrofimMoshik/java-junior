package com.acme.edu;

/**
 * Created by Trofim Moshik on 02.03.2018.
 */
class Message {
    printInt(int message){
        int sum = 0;
        if ((sum + (long) message) >= Integer.MAX_VALUE) {
            sum = 0;
        }
        sum += message;
    }
}
