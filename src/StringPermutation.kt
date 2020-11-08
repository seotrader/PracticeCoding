fun main(){

    var s = "abc"
    findPermutation(s,"")
}

fun findPermutation(s: String, ans: String) {
    if (s.isEmpty()) {
        println("$ans ")
        return
    }
    for (i in 0..s.length-1) {
        var ch = s[i]
        var ros = s.substring(0, i)+s.substring(i+1)
        findPermutation(ros, ans+ch)
    }
}