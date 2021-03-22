import com.sun.org.apache.xpath.internal.operations.Bool

/*
Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

 */
fun main() {
    val array = arrayOf<CharArray>(
            charArrayOf('1'),
            charArrayOf('1'))

    val numberOfIslands = NumberOfIslands()

    println("Result = ${numberOfIslands.numIslands(array)}")
}

data class Cell(var i: Int, var j: Int)

class NumberOfIslands {
    val visited = mutableListOf<Cell>()
    var count = 0
    var rows = 0
    var columns = 0

    fun numIslands(grid: Array<CharArray>): Int {
        rows = grid.size

        for (i in 0..grid.size-1) {
            for (j in 0..grid[i].size-1) {
                if (grid[i][j] == '1' && !visited.contains(Cell(i,j))) {
                    columns = grid[i].size
                    helperDfs(Cell(i, j), grid)
                    count++
                }
            }
        }
        return count
    }

    private fun isValid(cell: Cell): Boolean {
        if (cell.i >= 0 && cell.j>=0 && cell.j<=columns-1 && cell.i<=rows-1) return true
        return false
    }
    private fun getAdjList(cell: Cell): ArrayList<Cell> {
        val result = ArrayList<Cell>()

        if (isValid(Cell(cell.i+1, cell.j))) result.add(Cell(cell.i+1, cell.j))
        if (isValid(Cell(cell.i-1, cell.j))) result.add(Cell(cell.i-1, cell.j))
        if (isValid(Cell(cell.i, cell.j+1))) result.add(Cell(cell.i, cell.j+1))
        if (isValid(Cell(cell.i, cell.j-1))) result.add(Cell(cell.i, cell.j-1))
        return result
    }

    private fun helperDfs(cell: Cell, grid: Array<CharArray>) {

        visited.add(cell)

        println("i=${cell.i}, j=${cell.j}")
        if (grid[cell.i][cell.j]=='0') return

        val adj = getAdjList(cell)
        adj.forEach {
            if (!visited.contains(it)) {
                helperDfs(it, grid)
            }
        }
    }
}