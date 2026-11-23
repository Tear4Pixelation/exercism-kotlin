object Messenger {
    val messages = mutableListOf<String>()

    fun sendMessage(message: String) {
        messages.add(message)
    }

    fun latestMessage(): String {
        return messages.last()
    }

    fun allMessages(): List<String> {
        return messages
    }

    fun messageCount(): Int {
        return messages.size
    }

    fun searchMessages(searchTerm: String): List<String> {
        val results = mutableListOf<String>()
        for (message in messages) {
            if (message.contains(searchTerm)) {
                results.add(message)
            }
        }
        return results

        // there are a few ways to do this in fewer lines or at least "nicer", but those are out of scope.
    }
}
