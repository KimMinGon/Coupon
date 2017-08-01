package coupon

import grails.transaction.Transactional

@Transactional
class CouponService {

    /*def createCoupon() {

        int couponSize = 100000

        final possibleCharacters = [
                '1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F',
                'G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
                'W','X','Y','Z'
        ]

        Set set = new HashSet()
        Random random = new Random()
        int currentIndex = 0
        int i = 0

        while(currentIndex < couponSize) {
            StringBuffer sb = new StringBuffer(16)
            for(i=16 ; i>0 ; i--) {
                sb.append(possibleCharacters.get(random.nextInt(possibleCharacters.size())))
            }
            String couponNumber = sb.toString()

            set.add(couponNumber)

            currentIndex ++
        }

        for(String str : set) {

            //seablock
            //new SeablockCoupon(couponNumber: str, gold: 5000, useInfo: UseInfo.n, usingdate: '').save()

            //YourAnimal
            //new YourAnimalCoupon(couponNumber: str, item: ItemId.itemId_1, itemNum: 10, useInfo: UseInfo.n, usingdate: '').save()
        }
    }*/

    def checkSeablockCoupon(def couponNUmber) {
        SeablockCoupon coupon = SeablockCoupon.findByCouponNumber(couponNUmber)

        if(coupon.useInfo != UseInfo.n) {
            throw new Exception("Already used coupon")
            return
        }

        coupon.useInfo = UseInfo.y
        coupon.usingdate = new Date()
        coupon.save(flush: true)

        return coupon.gold
    }

    def checkYourAnimalCoupon(def couponNumber) {
        YourAnimalCoupon coupon = YourAnimalCoupon.findByCouponNumber(couponNumber)

        if(coupon.useInfo != UseInfo.n) {
            throw new Exception("Already used coupon")
            return
        }
        coupon.useInfo = UseInfo.y
        coupon.usingdate = new Date()
        coupon.save(flush: true)

        return [itemId: coupon.itemId, itemValue: coupon.itemValue]
    }
}
