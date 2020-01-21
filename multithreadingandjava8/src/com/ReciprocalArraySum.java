package com;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public final class ReciprocalArraySum {

    private ReciprocalArraySum() {
    }

    protected static double seqArraySum(final double[] input) {
        double sum = 0;

        // Compute sum of reciprocals of array elements
        for (int i = 0; i < input.length; i++) {
            sum += 1 / input[i];
        }

        return sum;
    }

    /**
     * Computes the size of each chunk, given the number of chunks to create
     * across a given number of elements.
     */
    private static int getChunkSize(final int nChunks, final int nElements) {
        // Integer ceil
        return (nElements + nChunks - 1) / nChunks;
    }

    private static int getChunkStartInclusive(final int chunk,
            final int nChunks, final int nElements) {
        final int chunkSize = getChunkSize(nChunks, nElements);
        return chunk * chunkSize;
    }

    private static int getChunkEndExclusive(final int chunk, final int nChunks,
            final int nElements) {
        final int chunkSize = getChunkSize(nChunks, nElements);
        final int end = (chunk + 1) * chunkSize;
        if (end > nElements) {
            return nElements;
        } else {
            return end;
        }
    }

    private static class ReciprocalArraySumTask extends RecursiveAction {
        private final int startIndexInclusive;
        private final int endIndexExclusive;
        private final double[] input;
        private double value;

        ReciprocalArraySumTask(final int setStartIndexInclusive,
                final int setEndIndexExclusive, final double[] setInput) {
            this.startIndexInclusive = setStartIndexInclusive;
            this.endIndexExclusive = setEndIndexExclusive;
            this.input = setInput;
        }

        public double getValue() {
            return value;
        }

        @Override
        protected void compute() {
            if(endIndexExclusive-startIndexInclusive<=10000) {
            	 for (int i = startIndexInclusive; i < endIndexExclusive; i++) {
                     value += 1 / input[i];
                 }
}
            else if(startIndexInclusive>endIndexExclusive) {
            	value+=0;
            }
            else if(startIndexInclusive==endIndexExclusive) {
            	value+=input[startIndexInclusive];
            }
            	else {
            		
            		ReciprocalArraySumTask reciprocalArraySumTaskLeft= new ReciprocalArraySumTask(startIndexInclusive,
            					(startIndexInclusive+endIndexExclusive)/2	, input);
            		ReciprocalArraySumTask reciprocalArraySumTaskRight = new ReciprocalArraySumTask((startIndexInclusive+endIndexExclusive)/2,
            				endIndexExclusive, input);
            		ForkJoinTask.invokeAll(reciprocalArraySumTaskLeft,reciprocalArraySumTaskRight);
            		/*reciprocalArraySumTaskLeft.fork();
            		reciprocalArraySumTaskRight.compute();
            		reciprocalArraySumTaskLeft.join();*/
            		value= reciprocalArraySumTaskLeft.getValue()+reciprocalArraySumTaskRight.getValue();
            	}
            }
        }
    
    protected static double parArraySum(final double[] input) {
    	assert input.length % 2 == 0;
    	double sum=0;
    	ReciprocalArraySumTask arraySumTask = new ReciprocalArraySumTask(0, input.length, input);
    	arraySumTask.invoke();
    	/*ReciprocalArraySumTask arraySumTaskRight = new ReciprocalArraySumTask(0, input.length/2, input);
    	ReciprocalArraySumTask arraySumTaskLeft = new ReciprocalArraySumTask((input.length/2)+1, input.length-1, input);
    	arraySumTaskRight.fork();
    	arraySumTaskLeft.compute();
    	arraySumTaskRight.join();
    	
    	return sum=arraySumTaskRight.getValue()+arraySumTaskLeft.getValue();*/
    		return sum=arraySumTask.getValue();
    }

    protected static double parManyTaskArraySum(final double[] input,
            final int numTasks) {
        double sum = 0;

        // Compute sum of reciprocals of array elements
        for (int i = 0; i < input.length; i++) {
            sum += 1 / input[i];
        }

        return sum;
    }
}
