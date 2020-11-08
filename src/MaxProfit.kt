import kotlin.math.max

fun main() {
    val array = intArrayOf(7,1,5,3,6,4)
    val maxProfit = MaxProfit()

    println(maxProfit.maxProfit(array))

}

class MaxProfit {

    fun maxProfit(prices: IntArray): Int {
        return findMaxProfit(prices)
    }

    // O(N) solution
    private fun findMaxProfit(prices: IntArray): Int {
        var maxProfit = 0

        var valleyIndex = 0
        var heightIndex = 0

        var index = 0

        while (index<prices.size-1) {
            while (index<prices.size-1 && prices[index]>=prices[index+1] ) {
                        index++
            }
            valleyIndex = index
            while (index<prices.size-1 && prices[index]<=prices[index+1] ) {
                index++
            }
            heightIndex = index
            maxProfit += prices[heightIndex]-prices[valleyIndex]

        }

        return maxProfit
    }

    // O(n^n) solution - brute force
    private fun findMaxProfit(prices: IntArray, pos: Int) : Int {
        if (pos>=prices.size) {
            return 0
        }
        var maxProfit = 0

        for (index in pos..prices.size-1) {

            var max = 0

            for (j in index+1..prices.size-1) {
                if (prices[index]<prices[j]) {
                    val profit = findMaxProfit(prices,j+1)+prices[j]-prices[index]
                    if (profit>max) max=profit
                }
            }
            if (max>maxProfit) {
                maxProfit = max
            }
        }

        return maxProfit
    }
}