package com.proteccion.seriefibonacci.domain;

// import java.time.LocalDateTime;

public class FibonacciModified {
    private Integer seed1;
    private Integer seed2;
    private Integer limit;

    public FibonacciModified(){
        // LocalDateTime now = LocalDateTime.now();
        // this.seed1 = now.getMinute();
        // this.limit = now.getSecond();
    }

    public FibonacciModified(Integer seed1, Integer seed2, Integer limit){
        this.seed1 = seed1;
        this.seed2 = seed2;
        this.limit = limit;
    }

    public Integer getseed1() {
        return this.seed1;
    }

    public void setseed1(Integer seed1) {
        this.seed1 = seed1;
    }

    public Integer getSeed2() {
        return this.seed2;
    }

    public void setSeed2(Integer seed2) {
        this.seed2 = seed2;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((limit == null) ? 0 : limit.hashCode());
        result = prime * result + ((seed1 == null) ? 0 : seed1.hashCode());
        result = prime * result + ((seed2 == null) ? 0 : seed2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FibonacciModified other = (FibonacciModified) obj;
        if (limit == null) {
            if (other.limit != null)
                return false;
        } else if (!limit.equals(other.limit))
            return false;
        if (seed1 == null) {
            if (other.seed1 != null)
                return false;
        } else if (!seed1.equals(other.seed1))
            return false;
        if (seed2 == null) {
            if (other.seed2 != null)
                return false;
        } else if (!seed2.equals(other.seed2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FibonacciModified [limit=" + limit + ", seed1=" + seed1 + ", seed2=" + seed2 + "]";
    }

}
