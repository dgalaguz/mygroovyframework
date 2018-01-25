package content

import common.BaseTestPage
import org.openqa.selenium.By

class CalculatorPage extends BaseTestPage{
    static at = {
        eq.displayed
    }

    static content = {
        digit{int d -> $(By.id("com.android.calculator2:id/digit_" + d))}
        add{$(By.id("com.android.calculator2:id/op_add"))}
        eq{$(By.id("com.android.calculator2:id/eq"))}
        res{$(By.id("com.android.calculator2:id/result"))}
        del{$(By.id("com.android.calculator2:id/del"))}
        form{$(By.id("com.android.calculator2:id/formula"))}
    }

    def typeDigit(int d){
        digit(d).click()
    }

    def typeOperation(String op){
        switch (op){
            case "+":
                add.click()
                break
        }
    }

    def getResult(){
        def result = res.text()
        result ? result.toInteger() : null
    }

    def getFormula(){
        form.text()
    }

    def clear(){
        while(getFormula())
        del.click()
    }
}
