package common.utils

import groovy.json.JsonSlurper

class Utils {
    static def ReadDataFromPath(String path){
        new JsonSlurper().parseText(new File(path).text)
    }
}
