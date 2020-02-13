object Chapter2 {

    fun insertionSort() {
        val arr = arrayOf(6, 2, 3, 11, 4, 10)
        for (i in 1 until arr.size) {
            val key = arr[i]
            var j = i - 1
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j]
                --j
            }
            arr[j + 1] = key
        }
        println(arr.toList())
    }

    fun mergeSort() {
        var arr = arrayOf(6, 2, 3, -4, 4, 10, 11)
        arr = merge(arr)
        println(arr.toList().toString())
    }

    private fun merge(arr: Array<Int>): Array<Int> {
        if (arr.size == 1) {
            return arr
        }

        val centerIndex = arr.size / 2

        val lArr = merge(arr.copyOfRange(0, centerIndex))
        val rArr = merge(arr.copyOfRange(centerIndex, arr.size))

        var lIndex = 0
        var rIndex = 0
        var index = 0

        val resArr = Array(lArr.size + rArr.size) {it}

        while(index != resArr.size) {
            if(lIndex < lArr.size && rIndex < rArr.size) {
                if(lArr[lIndex] < rArr[rIndex]) {
                    resArr[index] = lArr[lIndex]
                    ++lIndex
                } else {
                    resArr[index] = rArr[rIndex]
                    ++rIndex
                }
            } else {
                if(lIndex == lArr.size) {
                    resArr[index] = rArr[rIndex]
                    ++rIndex
                } else {
                    resArr[index] = lArr[lIndex]
                    ++lIndex
                }
            }
            ++index
        }

        return resArr
    }

}