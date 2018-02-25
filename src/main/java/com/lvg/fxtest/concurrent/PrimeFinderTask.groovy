package com.lvg.fxtest.concurrent

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.concurrent.Task

class PrimeFinderTask extends Task<ObservableList<Long>>{
    private long lowerLimit = 1
    private long upperLimit = 30
    private long sleepTimeInMillis = 500

    PrimeFinderTask(){}

    PrimeFinderTask(long lowerLimit, long upperLimit){
        this.lowerLimit = lowerLimit
        this.upperLimit = upperLimit
    }

    PrimeFinderTask(long lowerLimit, long upperLimit, long sleepTimeInMillis){
        this(lowerLimit, upperLimit)
        this.sleepTimeInMillis = sleepTimeInMillis
    }

    @Override
    protected void succeeded() {
        super.succeeded()
        updateMessage('The task finished successfully')
    }

    @Override
    protected void cancelled() {
        super.cancelled()
        updateMessage('The task was canceled')
    }

    @Override
    protected void failed() {
        super.failed()
        updateMessage('The task failed!')
    }

    @Override
    protected ObservableList<Long> call() throws Exception {
        final ObservableList<Long> results = FXCollections.<Long>observableArrayList()

        this.updateTitle('Prime Number Finder Task')

        long count = this.upperLimit - this.lowerLimit + 1
        long counter = 0

        for(long i = lowerLimit; i <= upperLimit; i++){
            if (this.isCancelled()){
                break
            }

            counter++

            this.updateMessage("Checking $i for a prime number")

            try{
                Thread.sleep(sleepTimeInMillis)
            }catch(InterruptedException ex){
                if(this.cancelled()){
                    break
                }
            }

            if (PrimeUtil.isPrime(i)){
                results.add(i)

                updateValue(FXCollections.<Long>unmodifiableObservableList(results))
                updateProgress(counter,count)
            }

        }
        return results




    }
}
