package coupon

import grails.converters.JSON
import grails.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.servlet.http.HttpServletRequest

@Transactional
class ResultService {

    def getRequestJSON(HttpServletRequest request) {
        def json = JSON.parse(new String(request.inputStream.bytes))

        println "====== request json start"
        println json
        println "====== request json end"

        json
    }

    def success(def item, int gameType) {

        def result = [:]
        if(gameType == 1)
            result = [result: [success: 1, item: item]]
        else if(gameType == 2)
            result = [result: [success: 1, itemId: item.itemId, itemValue: item.itemValue]]
        println "======Error ${new Date()}"
        println result
        println "======Error end"

        result as JSON
    }

    def error() {

        def result = [result: [success: 0]]

        println "======Error ${new Date()}"
        println result
        println "======Error end"

        result as JSON
    }
}
