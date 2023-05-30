package hashmap

import org.junit.jupiter.api.Test

class RansomNoteTest {
    @Test
    fun canConstruct() {
        assert(!RansomNote.canConstruct("ab", ""))
        assert(!RansomNote.canConstruct("aa", "a"))
        assert(!RansomNote.canConstruct("ab", "aa"))
        assert(RansomNote.canConstruct("ab", "abc"))
    }
}