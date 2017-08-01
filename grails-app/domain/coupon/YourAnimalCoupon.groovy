package coupon

class YourAnimalCoupon {

    String couponNumber
    Integer itemId
    Integer itemValue
    UseInfo useInfo
    Date usingdate

    static constraints = {
        couponNumber nullable: true
        usingdate nullable: true
    }

    static mapping = {
        couponNumber length: 16
        useInfo length: 5
    }
}
