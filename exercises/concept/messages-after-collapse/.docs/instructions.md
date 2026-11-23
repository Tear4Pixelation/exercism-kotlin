# Instructions
It is the year 2 after the collapse.
Mobile networks are down. 
You and your friends are stuck in an abandoned city without internet or any reliable long‑distance communication.

Somehow, basic SMS messages still work via satellite. But there is a problem:
You don’t have an app to store and read your messages.

Fortunately, you are a programmer.
A **Kotlin** programmer.

Time to build a tiny message system from scratch.

The messages are simply `String`s.

You will not get empty message histories.

Your objective is to get messages up and running as fast as possible, so you are not concerned with small details too much.
Therefore, you settle on these six capabilities for your app:

## 1. Store the messages

Store the messages that have been sent.

## 2. Send Messages

What chat app doesn't send messages? This is an important feature.

## 3. Read the latest message

No use in sending if I can't receive. The most important message is the latest, so let's do that first.

## 4. Get all messages

If I can only receive the latest message, what happens if I miss one? Or maybe if I forgot the previous message?

## 5. Count all messages

Imagine we finally rebuild civilization, looking back we'd have more than 2000 messages...

## 6. Search the chat for a keyword

Your friends keep mentioning where they found supplies, but it's buried in the chat.
Implement `searchMessages` so it finds every message mentioning a keyword, oldest first.
If nobody mentioned it, return an empty list.

`yourString.contains(searchString)` is the way to check whether `yourString` contains `searchString`.
