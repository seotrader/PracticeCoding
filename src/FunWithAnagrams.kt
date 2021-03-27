fun main() {
    val list = arrayOf("poke", "pkoe", "okpe", "ekop")
    funWithAnagrams(list)

}

fun funWithAnagrams(text: Array<String>): Array<String> {
    val original = hashMapOf<String,String>()
    val result = arrayListOf<String>()
    text.forEach {
        val sortedString = it.toCharArray().sorted()
        if (!original.containsKey(sortedString.toString())) {
            result.add(it)
            original[sortedString.toString()] = it
        }
    }
    result.sort()
    // Write your code here
    println(result)
    return result.toTypedArray()
}