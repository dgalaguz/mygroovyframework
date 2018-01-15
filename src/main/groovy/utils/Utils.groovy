package utils

import groovy.json.JsonSlurper
import java.io.File

class Utils {
    static def ReadDataFromPath(String path){
        new JsonSlurper().parseText(new File(path).text)
    }
}
