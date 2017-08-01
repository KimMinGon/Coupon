package coupon

class SeablockCoupon {
    String couponNumber
    Integer gold
    UseInfo useInfo
    Date usingdate

    static constraints = {
        couponNumber nullable: true
        usingdate nullable: true
        gold nullable: true
    }

    static mapping = {
        couponNumber length: 20
    }
}
