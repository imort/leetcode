package intervals

import org.junit.jupiter.api.Test

class SummaryRangesTest {
    @Test
    fun summaryRanges() {
        val test = SummaryRanges()
        assert(test.summaryRanges(intArrayOf(1, 2, 4, 5)) == listOf("1->2", "4->5"))
        assert(test.summaryRanges(intArrayOf(1, 2, 4, 6)) == listOf("1->2", "4", "6"))
        assert(test.summaryRanges(intArrayOf(1, 4, 6, 7)) == listOf("1", "4", "6->7"))
    }
}