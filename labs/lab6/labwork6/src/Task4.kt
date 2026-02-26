import kotlin.math.pow

fun main(){
    val interest: (Double, Double, Double) -> Double = { startSum: Double, yearPercent: Double, years:Double -> startSum * (1+(yearPercent/100)*years)}
    val compoundinterest: (Double, Double, Double) -> Double = { startSum: Double, yearPercent: Double, years:Double -> startSum * (1+(yearPercent/100)).pow(years) }
}

fun selectCompound(op: String): (Double, Double, Double) -> Double{
    return when(op){
        "прост" -> ::interest
        "слож" -> ::compoundinterest
    }
}