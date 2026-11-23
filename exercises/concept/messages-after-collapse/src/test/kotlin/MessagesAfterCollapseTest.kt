import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MessagesAfterCollapseTest {

    val rooftopChat = listOf(
        "Are you safe?",
        "Yes. Hiding on the rooftop of the library.",
        "Stay there. I will come at sunrise."
    )

    val supplyChat = listOf(
        "We need more supplies. With these we'll only last a day or two.",
        "Yes, I know. I am scouting town for resources right now."
    )

    val waterChat = listOf(
        "Did anyone find water?",
        "Meet me at the ex-exercism hq at noon.",
        "I have some food, but no water.",
        "The river north of town still has water in it."
    )

    val foundSomething = listOf(
        "I found some canned food in an abandoned supermarket",
        "GREAT! Bring as much as you can",
        "This place creeps me out a bit..."
    )

    val lastChat = listOf(
        "Where are you? It's getting dark!",
        "Hello?"
    )

    @BeforeTest
    fun setUp() {
        Messenger.messages.clear()
    }

    @Test
    fun `test adding a message`() {
        Messenger.sendMessage("just setting up my msngr")
        assertEquals(listOf("just setting up my msngr"), Messenger.messages)
    }

    @Test
    fun `test all messages`() {
        Messenger.messages.addAll(rooftopChat)
        assertEquals(Messenger.messages, Messenger.allMessages())
    }

    @Test
    fun `test preserve order messages`() {
        Messenger.messages.addAll(rooftopChat)
        assertEquals(rooftopChat, Messenger.allMessages())
    }

    @Test
    fun `test message count`() {
        Messenger.messages.addAll(supplyChat)
        assertEquals(2, Messenger.messageCount())
    }

    @Test
    fun `test latest message`() {
        Messenger.messages.addAll(foundSomething)
        assertEquals("This place creeps me out a bit...", Messenger.latestMessage())
    }


    @Test
    fun `test send message and all messages together`() {
        lastChat.forEach { Messenger.sendMessage(it) }
        assertEquals(lastChat, Messenger.allMessages())
    }

    @Test
    fun `test search messages`() {
        Messenger.messages.addAll(waterChat)
        assertEquals(
            listOf(
                "Did anyone find water?",
                "I have some food, but no water.",
                "The river north of town still has water in it."
            ),
            Messenger.searchMessages("water")
        )
    }

    @Test
    fun `test search messages without results`() {
        Messenger.messages.addAll(waterChat)
        assertEquals(listOf<String>(), Messenger.searchMessages("radio"))
    }

    @Test
    fun `test search does not change messages`() {
        Messenger.messages.addAll(waterChat)
        Messenger.searchMessages("water")
        assertEquals(waterChat, Messenger.allMessages())
    }
}
