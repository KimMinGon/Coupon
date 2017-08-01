package coupon

class CouponController {
    def resultService
    def couponService

    def checkCouponNumber() {
        def requestJSON = resultService.getRequestJSON(request)

        def item
        def couponNumber = requestJSON.couponNumber
        def gameType = requestJSON.gameType

        if(!couponNumber || !gameType) {
            render resultService.error()
            return
        }

        try {

            if(gameType == 1)
                item = couponService.checkSeablockCoupon(couponNumber)
            else if (gameType == 2)
                item = couponService.checkYourAnimalCoupon(couponNumber)
            else {
                throw new Exception()
            }

        } catch (e) {
            e.printStackTrace()
            render resultService.error()
            return
        }

        render resultService.success(item, gameType as int)
    }

    /*def createCoupon() {

        couponService.createCoupon()

        render "success"
    }*/


}
