public class InterestRate {
    String acctype;
    Double rate;

    public InterestRate(String acctype, Double rate) {
        this.acctype = acctype;
        this.rate = rate;
//        System.out.println("irate set:"+this.rate);
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
