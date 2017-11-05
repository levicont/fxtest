package com.lvg.fxtest.concurrent

class PrimeUtil {
    static boolean isPrime(long num){
        if (num <= 1 || (num % 2) == 0l){
            return false
        }

        int upperDivisor = (int)Math.ceil(Math.sqrt(num))
        for (int divisor = 3; divisor <= upperDivisor; divisor += 2){
            if (num % divisor == 0l)
                return false
        }
        return true
    }
}
